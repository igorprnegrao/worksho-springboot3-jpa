package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.Order;
//criar jpa respository crira uma interface extendendo da jpaRepository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
