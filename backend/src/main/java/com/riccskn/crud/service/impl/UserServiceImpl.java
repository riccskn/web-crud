package com.riccskn.crud.service.impl;

import com.riccskn.crud.dto.UserDTO;
import com.riccskn.crud.exception.ResourceNotFoundException;
import com.riccskn.crud.model.User;
import com.riccskn.crud.repository.UserRepository;
import com.riccskn.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User getById(long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(HttpStatus.NOT_FOUND,"User not found"));
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(UserDTO dto) {
        User user = new User();

        user.setName(dto.getName());
        user.setNickname(dto.getNickname());
        user.setPhone(dto.getPhone());
        user.setEmail(dto.getEmail());

        userRepository.save(user);
        return user;
    }

    @Override
    public User deleteById(long id) {

       User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(HttpStatus.NOT_FOUND,"User not found"));

       userRepository.delete(user);
       return user;
    }
}
