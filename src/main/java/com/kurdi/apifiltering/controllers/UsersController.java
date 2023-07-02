package com.kurdi.apifiltering.controllers;

import com.kurdi.apifiltering.Specifications.ApiSpecifications;
import com.kurdi.apifiltering.Specifications.RequestDto;
import com.kurdi.apifiltering.Specifications.SearchRequestDto;
import com.kurdi.apifiltering.entities.User;
import com.kurdi.apifiltering.repositories.UsersRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/users/")
public class UsersController {
    final UsersRepository usersRepository;
    final ApiSpecifications<User> userApiSpecifications;


    public UsersController(UsersRepository usersRepository, ApiSpecifications<User> userApiSpecifications) {
        this.usersRepository = usersRepository;
        this.userApiSpecifications = userApiSpecifications;

    }

    @PostMapping
    public ResponseEntity getAll(@RequestBody RequestDto requestDto) {

        Pageable sortedByAgeDesc =
                PageRequest.of(0,2 , Sort.by("age").descending());
        Page users = usersRepository.findAll(userApiSpecifications.getSearchSpecifications(requestDto.getSearchRequestDtoList()), sortedByAgeDesc);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
