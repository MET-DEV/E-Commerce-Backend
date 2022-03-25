package com.metsoft.ecommerce.api.controller;

import com.metsoft.ecommerce.model.Order;
import com.metsoft.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/orders/")
@RestController
public class OrdersController {
    private OrderRepository orderRepository;

    @Autowired
    public OrdersController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    @GetMapping("/getall")
    public List<Order> getAll(){
        return orderRepository.findAll();
    }
}
