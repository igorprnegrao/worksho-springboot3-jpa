package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.OrderItem;
import com.educandoweb.course.entities.pk.OrderItemPK;
// criar jpa respository crira uma interface extendendo da jpaRepository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
