package com.kurdi.apifiltering.controllers;

import com.kurdi.apifiltering.entities.User;
import com.kurdi.apifiltering.repositories.UsersRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users/")
public class UsersController {
    final UsersRepository usersRepository;

    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping
    public ResponseEntity<Page<User>> getAll() {
        Pageable sortedByAgeDesc =
                PageRequest.of(0, 1, Sort.by("age").descending());
        Page<User> users = usersRepository.findAll(sortedByAgeDesc);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
