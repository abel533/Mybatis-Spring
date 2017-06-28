package com.isea533.mybatis.model;

/**
 * Created by Administrator on 2016/7/27.
 */
public enum OrderSort {
    ASC("asc"),

    DESC("desc");

    private String orderType;

    private OrderSort(String orderType) {
        this.orderType = orderType;
    }

    public String getType() {
        return orderType;
    }
}
