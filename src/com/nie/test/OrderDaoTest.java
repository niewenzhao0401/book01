package com.nie.test;

import com.nie.dao.OrderDao;
import com.nie.dao.imp.OrderDaoImpl;
import com.nie.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

/*
 *
 *@auth  wenzhao
 *@date 2021/2/7  18:16
 */
public class OrderDaoTest {

    @Test
    public void saveOrder() {
        OrderDao orderDao = new OrderDaoImpl();

        orderDao.saveOrder(new Order("1234567890",new Date(),new BigDecimal(100),0, 1));

    }
}