package com.chinex.restendpoints.controller;

import com.chinex.restendpoints.dto.UserRequestDto;
import com.chinex.restendpoints.model.User;
import com.chinex.restendpoints.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Optional<User>> getUserId(@PathVariable Long id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }
    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody UserRequestDto request) {
        return new ResponseEntity<>(userService.createUser(request), HttpStatus.CREATED);
    }

    @PutMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateUser(@PathVariable(value = "id") Long id, @RequestBody UserRequestDto requestDto) {
        return new ResponseEntity<>(userService.updateUser(id, requestDto), HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/users")
    public ResponseEntity<?> deleteUsers() {
        userService.deleteAllUsers();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
