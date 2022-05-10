package com.example.coursework.web;

import com.example.coursework.model.Order;
import com.example.coursework.model.User;
import com.example.coursework.repository.OrderRepository;
import com.example.coursework.repository.UserRepository;
import com.example.coursework.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MainController {

    private Authentication authentication;

    @Autowired
    OrderService orderService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/order")
    public String order(Model m) {
        m.addAttribute("order", new Order());
        return "order";
    }

    @PostMapping("/order")
    public String addOrder(@ModelAttribute("order") Order order) {

        authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        User user = userRepository.findByEmail(email);

        order.setUser(user);
        orderService.save(order);
        return "redirect:/order?success";
    }

    @GetMapping("/admin")
    public String userRecords(Model model) {

        List<Order> list = orderRepository.findAll();

        model.addAttribute("orders", list);

        return "admin";
    }
}