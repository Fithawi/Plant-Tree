package com.project.adminportal.repository;

import org.springframework.data.repository.CrudRepository;

import com.project.adminportal.user.User;

public interface UserRepository extends CrudRepository<User,Long>
{
User findByUsername(String username);
}
