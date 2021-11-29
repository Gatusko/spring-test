package com.example.test.web;

import com.example.test.data.OrderRepository;
import com.example.test.tacos.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {

    private OrderRepository orderRepository;


    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/current")
    public String orderForm(Model model)
    {
        model.addAttribute("order",new Order());
        return "orderForm";
    }
    @PostMapping
    public String processOrder(Order order, SessionStatus sessionStatus)
    {
        orderRepository.save(order);
        sessionStatus.setComplete();
        log.info("Order Submitted:" + order);
        return "redirect:/";
    }
}
