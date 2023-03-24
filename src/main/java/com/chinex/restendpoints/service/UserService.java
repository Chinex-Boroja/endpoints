package com.chinex.restendpoints.service;

import com.chinex.restendpoints.dto.UserRequestDto;
import com.chinex.restendpoints.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAllUsers();

    Optional<User> findById(Long id);

    User createUser(UserRequestDto request);

    User updateUser(Long id, UserRequestDto request);

    void deleteUser(Long id);

    void deleteAllUsers();


}
