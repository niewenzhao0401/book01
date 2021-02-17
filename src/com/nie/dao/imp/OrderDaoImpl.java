package com.nie.dao.imp;/*
 *
 *@auth  wenzhao
 *@date 2021/2/7  17:56
 */

import com.nie.dao.OrderDao;
import com.nie.pojo.Order;

public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`) values(?,?,?,?,?)";

        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }
}