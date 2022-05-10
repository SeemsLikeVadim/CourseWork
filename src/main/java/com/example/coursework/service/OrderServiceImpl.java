package com.example.coursework.service;


import com.example.coursework.model.Order;
import com.example.coursework.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderRepository orderRepository;

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }
}
