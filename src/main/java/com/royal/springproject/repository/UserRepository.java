package com.royal.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.royal.springproject.model.User;


public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsernameAndPassword(String un, String psw);

}
