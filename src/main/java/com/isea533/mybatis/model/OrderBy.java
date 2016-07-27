package com.isea533.mybatis.model;

/**
 * Created by Administrator on 2016/7/27.
 */
public class OrderBy {

    private String orderName;
    private String orderSort;

    public OrderBy(String orderName, String orderSort) {
        this.orderName = orderName;
        this.orderSort = orderSort;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderSort() {
        return orderSort;
    }

    public void setOrderSort(String orderSort) {
        this.orderSort = orderSort;
    }
}
