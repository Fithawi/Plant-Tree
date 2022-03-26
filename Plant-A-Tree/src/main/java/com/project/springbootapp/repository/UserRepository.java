package com.project.springbootapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.project.springbootapp.user.User;

public interface UserRepository extends CrudRepository<User,Long> {
User findByUsername(String username);
}
