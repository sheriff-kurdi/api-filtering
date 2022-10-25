package com.kurdi.apifiltering.controllers;

import com.kurdi.apifiltering.entities.User;
import com.kurdi.apifiltering.repositories.UsersRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users/")
public class UsersController {
    final UsersRepository usersRepository;

    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping
    public List<User> getAll() {
        List<User> users = usersRepository.findAll();
        return users;
    }
}
