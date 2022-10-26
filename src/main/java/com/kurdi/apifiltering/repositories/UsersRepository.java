package com.kurdi.apifiltering.repositories;

import com.kurdi.apifiltering.entities.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UsersRepository extends PagingAndSortingRepository<User, Integer> {
}
