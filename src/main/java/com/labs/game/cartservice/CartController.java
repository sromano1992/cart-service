package com.labs.game.cartservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class CartController {

    @Autowired
    private CartService service;

    @GetMapping("/cart-items")
    public CartItem[] getCartItems(@RequestParam String customer){
        return service.findByCustomer(customer);
    }
}