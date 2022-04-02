package com.project.springbootapp.repository;
import org.springframework.data.repository.CrudRepository;

import com.project.springbootapp.user.security.Role;

public interface RoleRepository extends CrudRepository<Role,Long>{

}
