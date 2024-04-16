package com.example.postcreating.service;

import com.example.postcreating.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO addUser(UserDTO userDTO);

    UserDTO updateUser(final Long id, UserDTO uset);

    UserDTO getFromId(final Long id);

    void eraseUser(final Long id);

    List<UserDTO> getEveryUser();

    boolean userExists(final Long id);


}
