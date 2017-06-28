package com.isea533.mybatis.model;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/27.
 */
public class Order {

    private List<OrderBy> orders = new ArrayList<OrderBy>();

    public List<OrderBy> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderBy> orders) {
        this.orders = orders;
    }

    public void addOrder(String orderName, OrderSort orderSort) {
        orders.add(new OrderBy(orderName, orderSort.getType()));
    }

    //每个排序都有个index。没用到
//    public void addIndexOrder(int index, String orderName, OrderSort orderSort) {
//        int c = orders.size();
//        if (index < 0 || (index != 0 && index > c - 1))
//            return;
//        orders.add(index, new OrderBy(orderName, orderSort.getType()));
//    }

    @Override
    public String toString() {
        String orderStr = "";
        for (OrderBy o : orders) {
            orderStr += o.getOrderName() + " " + o.getOrderSort() + ",";
        }

        orderStr = StringUtils.substringBeforeLast(orderStr, ",");
        return orderStr.length() < 1 ? "" : " order by " + orderStr;

    }
}
