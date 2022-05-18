package com.starlight.clientservice.service;

import com.starlight.clientservice.model.Order;
import com.starlight.clientservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements CommonService<Order, Long> {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void save(Order model) {

    }

    @Override
    public Optional<Order> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Order update(Order model) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }
}
