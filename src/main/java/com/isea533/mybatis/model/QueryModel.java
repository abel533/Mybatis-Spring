package com.isea533.mybatis.model;

/**
 * @author liuzh_3nofxnp
 * @since 2015-11-09 22:25
 */
public class QueryModel {
    private Integer pageNum;
    private Integer pageSize;
    private String orderBy;
    private Boolean countSql;
    private Boolean pageSizeZero;
    private Boolean reasonable;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public Boolean getCountSql() {
        return countSql;
    }

    public void setCountSql(Boolean countSql) {
        this.countSql = countSql;
    }

    public Boolean getPageSizeZero() {
        return pageSizeZero;
    }

    public void setPageSizeZero(Boolean pageSizeZero) {
        this.pageSizeZero = pageSizeZero;
    }

    public Boolean getReasonable() {
        return reasonable;
    }

    public void setReasonable(Boolean reasonable) {
        this.reasonable = reasonable;
    }
}
