package com.api.springboot.service.impl;

import com.api.springboot.domain.model.User;
import com.api.springboot.domain.repository.UserRepository;
import com.api.springboot.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User create(User userToCreate) {
        if (userToCreate.getId() != null) {
            throw new IllegalArgumentException("Novo usuário não deve ter ID definido");
        }

        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())){
            throw new IllegalArgumentException("Usuário já existe na base de dados");
        }

        return userRepository.save(userToCreate);
    }

}
