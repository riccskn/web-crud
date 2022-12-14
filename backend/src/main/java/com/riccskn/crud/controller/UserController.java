package com.riccskn.crud.controller;

import com.riccskn.crud.dto.UserDTO;
import com.riccskn.crud.model.User;
import com.riccskn.crud.repository.UserRepository;
import com.riccskn.crud.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") long id) {
       return new ResponseEntity<User>(userService.getById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody UserDTO dto) {
       return new ResponseEntity<>(userService.save(dto),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(userService.deleteById(id),HttpStatus.OK);
    }

}
