package com.nie.service;/*
 *
 *@auth  wenzhao
 *@date 2021/2/7  18:29
 */

import com.nie.pojo.Cart;

public interface OrderService {
    public String createOrder(Cart cart, Integer userId);
}
