package com.example.postcreating.service.impl;

import com.example.postcreating.dto.UserDTO;
import com.example.postcreating.entity.User;
import com.example.postcreating.handlers.BadRequestException;
import com.example.postcreating.mapper.UserMapper;
import com.example.postcreating.repository.UserRepository;
import com.example.postcreating.service.UserService;
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
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private UserMapper userMapper;

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        log.debug("Adding a user with email: {}", userDTO.getEmail());

        User savedUser = userRepository.saveAndFlush(UserMapper.toModule(userDTO));
        UserDTO savedUserDTO = UserMapper.toDTO(savedUser);

        log.info("User added with ID: {}", savedUserDTO.getId());
        return savedUserDTO;

    }

    @Override
    public UserDTO updateUser(final Long id, UserDTO userDTO) {
        log.debug("Updating user with ID: {}", id);

        User realUser = findUserById(id);
        updateUserInfoDTO(realUser, userDTO);
        userRepository.save(realUser);

        log.info("User updated with ID: {}", id);
        return UserMapper.toDTO(realUser);
    }

    @Override
    public UserDTO getFromId(Long id) {
        log.debug("Retrieving user with ID: {}", id);

        User user = findUserById(id);

        log.info("User retrieved with ID: {}", id);
        return UserMapper.toDTO(user);
    }

    @Override
    public void eraseUser(final Long id) {
        log.debug("Deleting user with ID: {}", id);

        userRepository.deleteById(id);

        log.info("User deleted with ID: {}", id);
    }

    @Override
    public List<UserDTO> getEveryUser() {
        /*return UserMapper.toDTOUserList(userRepository.findAll());*/


        log.debug("Retrieving all users");


        final List<UserDTO> userDTOs = new ArrayList<>();
        final Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Pageable page = PageRequest.of(0, 1, sort);
        Page<User> userPage = userRepository.findAll(page);

        do {
            userPage.getContent().forEach(user -> {
                UserDTO userDTO = UserMapper.toDTO(user);
                userDTOs.add(userDTO);
            });
            if (userPage.hasNext()) {
                page = userPage.nextOrLastPageable();
                userPage = userRepository.findAll(page);
            } else {
                page = null;
            }
        } while (page != null);

        log.info("Total users retrieved: {}", userDTOs.size());
        return userDTOs;
    }

    @Override
    public boolean userExists(Long id) {
        final boolean exists = userRepository.existsById(id);

        log.debug("User existence check for ID: {} - Exists: {}", id, exists);
        return exists;    }


















    private User findUserById(final Long id){

        try {
            return userRepository.findById(id).orElse(null);
        }catch (Exception e){
            System.out.println("User with ID: {}" + id + " not found");
        }
        return null;

    }

    private void updateUserInfoDTO(User user, UserDTO userDTO) {
        if (userDTO.getName() != null) {
            user.setName(userDTO.getName());
        }
        if (userDTO.getEmail() != null) {
            user.setEmail(userDTO.getEmail());
        }
    }

    /*private void isAdmin(Long id) {
        if (userRepository.getById(id).getRole() == ADMIN) {
            throw new BadRequestException("The user is not an admin");
        }
    }*/
}
