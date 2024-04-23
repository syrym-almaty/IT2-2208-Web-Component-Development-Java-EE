package com.example.postcreating.service.impl;

import com.example.postcreating.dto.PostDTO;
import com.example.postcreating.entity.Post;
import com.example.postcreating.entity.User;
import com.example.postcreating.handlers.BadRequestException;
import com.example.postcreating.handlers.NotFoundException;
import com.example.postcreating.mapper.PostMapper;
import com.example.postcreating.repository.PostRepository;
import com.example.postcreating.repository.UserRepository;
import com.example.postcreating.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.postcreating.entity.Role.ADMIN;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private PostMapper postMapper;

    @Override
    public PostDTO createPost(PostDTO postDTO, final Long userId) {
        log.debug("Update post with ID: {}", postDTO.getId());
        User author = userRepository.findById(userId).orElse(null);
        postDTO.setAuthor(author);

        Post post = postRepository.save(PostMapper.toModulePost(postDTO));
        log.info("Post created with ID {}", post.getId());
        return PostMapper.toDTOPost(post);
    }

    @Override
    public PostDTO updatePost(PostDTO postDTO, final Long userId) {
        log.debug("Updating post ID {}", postDTO.getId());
        Post post = findPostAndValidateCreator(postDTO.getId(), userId);

        if (postDTO.getTitle() != null) {
            post.setTitle(postDTO.getTitle());
        }
        if (postDTO.getContent() != null) {
            post.setContent(postDTO.getContent());
        }

        Post updatedPost = postRepository.save(post);
        log.info("Post with ID {} update", updatedPost.getId());
        return PostMapper.toDTOPost(updatedPost);
    }

    @Override
    public void erasePost(Long userId, Long postId) {
        log.debug("Deleting post with ID {}", postId);
        findPostAndValidateCreator(postId, userId);

        postRepository.deleteById(postId);
        log.info("Post with ID {} deleted", postId);
    }

    @Override
    public PostDTO getPost(Long id) {
        log.debug("Getting post with ID {}", id);
        Post post = postRepository.findById(id).orElseThrow(() -> new NotFoundException("Post not found"));
        return PostMapper.toDTOPost(post);
    }

    @Override
    public List<PostDTO> getPostByNameOrContent(String text) {
        return PostMapper.toDTOPostList(postRepository.findByTitleContainingIgnoreCaseOrContentContainsIgnoreCase(text, text));
    }

    @Override
    public List<PostDTO> getPostsByUser(Long userId) {
        return PostMapper.toDTOPostList(postRepository.findByAuthorId(userId));
    }

    @Override
    public List<PostDTO> getPosts(Long adminId) {
        /*return PostMapper.toDTOPostList(postRepository.findAll());*/

        log.debug("Retrieving all posts for admin {}", adminId);

        isAdmin(adminId);

        final List<PostDTO> postDTOList = new ArrayList<>();
        final Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Pageable page = PageRequest.of(0, 1, sort);
        Page<Post> userPage = postRepository.findAll(page);

        do {
            userPage.getContent().forEach(post -> {
                PostDTO userDTO = PostMapper.toDTOPost(post);
                postDTOList.add(userDTO);
            });
            if (userPage.hasNext()) {
                page = userPage.nextOrLastPageable();
                userPage = postRepository.findAll(page);
            } else {
                page = null;
            }
        } while (page != null);

        log.info("Total posts retrieved: {}", postDTOList.size());
        return postDTOList;
    }




    @Override
    public List<PostDTO> getPostsByNameAsc() {
        return PostMapper.toDTOPostList(postRepository.findAllByOrderByTitleAsc());
    }

    @Override
    public List<PostDTO> findPostsByNameDesc() {
        return PostMapper.toDTOPostList(postRepository.findAllByOrderByTitleDesc());
    }





    private Post findPostAndValidateCreator(final Long postId, final Long userId) {
        final Post post = postRepository.findById(postId).orElse(null);
        if (!post.getAuthor().getId().equals(userId)) {
            throw new BadRequestException("User is not the owner of the post");
        }
        return post;
    }

    private void isAdmin(Long id) {
        if (userRepository.getById(id).getRole() != ADMIN) {
            throw new BadRequestException("The user is not an admin");
        }
    }
}
