package com.labs.game.cartservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartItem {
    private Integer id;
    private String customer;
    private String product;
    private int quantity;

    public CartItem(int i, String s, String aaa, int i1) {
        this.id = i;
        this.customer = s;
        this.product = aaa;
        this.quantity = i1;
    }
}