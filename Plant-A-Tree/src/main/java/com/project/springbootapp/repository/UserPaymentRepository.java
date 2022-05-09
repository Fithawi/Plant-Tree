package com.project.springbootapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.project.springbootapp.user.UserPayment;

public interface UserPaymentRepository extends CrudRepository<UserPayment, Long> {

}
