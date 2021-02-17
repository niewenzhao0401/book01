package com.nie.test;

import com.nie.dao.OrderItemDao;
import com.nie.dao.imp.OrderItemDaoImpl;
import com.nie.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

/*
 *
 *@auth  wenzhao
 *@date 2021/2/7  18:16
 */
public class OrderItemDaoTest {

    @Test
    public void saveOrderItem() {
        OrderItemDao orderItemDao= new OrderItemDaoImpl();

        orderItemDao.saveOrderItem(new OrderItem(null,"java从入门到精通", 1,new BigDecimal(100),new BigDecimal(100),"1234567890"));
        orderItemDao.saveOrderItem(new OrderItem(null,"javaScript从入门到精通", 2,new BigDecimal(100),new BigDecimal(200),"1234567890"));
        orderItemDao.saveOrderItem(new OrderItem(null,"Netty入门", 1,new BigDecimal(100),new BigDecimal(100),"1234567890"));


    }
}