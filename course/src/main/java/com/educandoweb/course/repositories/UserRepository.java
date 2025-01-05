package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.User;
// criar jpa respository crira uma interface extendendo da jpaRepository
public interface UserRepository extends JpaRepository<User, Long> {

}
