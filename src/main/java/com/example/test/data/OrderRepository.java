package com.example.test.data;

import com.example.test.tacos.Order;

public interface OrderRepository {

    Order save(Order order);
}
