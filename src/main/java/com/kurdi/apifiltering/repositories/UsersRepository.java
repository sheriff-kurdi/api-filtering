package com.kurdi.apifiltering.repositories;

import com.kurdi.apifiltering.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Integer> {
}
