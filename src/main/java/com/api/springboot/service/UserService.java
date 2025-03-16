package com.api.springboot.service;

import com.api.springboot.domain.model.User;

import java.util.List;

public interface UserService {

    User findById(Long id);

    List<User> findAll();

    User create(User userToCreate);


}
