package com.project.adminportal.repository;
import org.springframework.data.repository.CrudRepository;

import com.project.adminportal.user.security.Role;

public interface RoleRepository extends CrudRepository<Role,Long>{

}
