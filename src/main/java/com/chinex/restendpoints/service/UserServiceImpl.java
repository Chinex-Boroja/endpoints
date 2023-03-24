package com.chinex.restendpoints.service;

import com.chinex.restendpoints.dto.UserRequestDto;
import com.chinex.restendpoints.model.User;
import com.chinex.restendpoints.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
    @Override
    public User createUser(UserRequestDto request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, UserRequestDto request) {
//        Optional<User> user = userRepository.findById(id);
//        if (user.isPresent()) {
//
//            return userRepository.save(user);
//        }
        if (userRepository.findById(id).isPresent()) {
            User existingUser = userRepository.findById(id).get();
            existingUser.setName(request.getName());
            existingUser.setEmail(request.getEmail());

            return userRepository.save(existingUser);
        }
        else

            return null;

    }
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }
}
