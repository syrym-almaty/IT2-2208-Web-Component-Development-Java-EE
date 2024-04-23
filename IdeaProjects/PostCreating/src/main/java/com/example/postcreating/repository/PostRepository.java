package com.example.postcreating.repository;

import com.example.postcreating.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByTitleContainingIgnoreCaseOrContentContainsIgnoreCase(String title, String content);

    List<Post> findByAuthorId(Long authorId);

    List<Post> findAllByOrderByTitleAsc();

    List<Post> findAllByOrderByTitleDesc();

    List<Post> findAllByAuthor_Id(Long id);

}
