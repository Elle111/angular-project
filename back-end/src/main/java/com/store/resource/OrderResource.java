package com.store.resource;

import com.store.domain.Order;
import com.store.domain.User;
import com.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderResource {

    @Autowired
    private UserService userService;

    @RequestMapping("/getOrderList")
    public List<Order> getOrderList(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        List<Order> orderList = user.getOrderList();

        return orderList;
    }


}
