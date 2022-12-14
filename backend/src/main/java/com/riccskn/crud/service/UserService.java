package com.riccskn.crud.service;

import com.riccskn.crud.dto.UserDTO;
import com.riccskn.crud.model.User;

import java.util.List;

public interface UserService {

    User getById(long id);

    List<User> getAll();

    User save(UserDTO dto);

    User deleteById(long id);

}
