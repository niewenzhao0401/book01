package com.nie.dao;/*
 *
 *@auth  wenzhao
 *@date 2021/2/7  17:50
 */

import com.nie.pojo.Order;

public interface OrderDao {
    //保存订单
    public int saveOrder(Order order);


}
