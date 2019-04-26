package com.tengdi.environmentalprotectionint.modules.common.entity;

import java.util.List;
import java.util.Map;

/**
 * 通用查询条件对象
 */
public class QueryCriterias {
    /**
     * 表名或视图名
     */
    private String table;
    /**
     * 相等值列名
     */
    private List<Map<String,Object>> equalColumns;
    /**
     * 模糊查询列名
     */
    private List<Map<String,Object>> likeColumns;
    /**
     * 排序列名
     */
    private String orderColumn;
    /**
     * 时间搜索列
     */
    private String dateColumn;

    /**
     * 时间搜索列
     */
    private String startDate;

    /**
     * 时间搜索列
     */
    private String endDate;
    /**
     * 使用哪个字段汇总
     */
    private String groupColumn;
    /**
     * 合计列
     */
    private String totalColumn;
    private List<String> factorList;

    public List<String> getFactorList() {
        return factorList;
    }

    public void setFactorList(List<String> factorList) {
        this.factorList = factorList;
    }

    /**
     * 下面几个属性都是表格分页相关
     */
    private Integer pagenumber;

    private Integer pagesize;

    private Integer limit;

    private Integer page;

    private boolean showXh;

    /**
     * 数据的状态
     */
    private Integer status;

    /**
     * 汇总列名可以多个如sum(salary),max(name)
     */
    private String sumCols;
    /**
     * 用来接收str的数组
     */
    private String[] strCols;

    /**
     * 备用一个自由的where条件
     */
    private String backup;

    public String getBackup() {
        return backup;
    }

    public void setBackup(String backup) {
        this.backup = backup;
    }

    public String getSumCols() {
        return sumCols;
    }

    public void setSumCols(String sumCols) {
        this.sumCols = sumCols;
    }


    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public List<Map<String, Object>> getEqualColumns() {
        return equalColumns;
    }

    public void setEqualColumns(List<Map<String, Object>> equalColumns) {
        this.equalColumns = equalColumns;
    }

    public List<Map<String, Object>> getLikeColumns() {
        return likeColumns;
    }

    public void setLikeColumns(List<Map<String, Object>> likeColumns) {
        this.likeColumns = likeColumns;
    }

    public String getOrderColumn() {
        return orderColumn;
    }

    public void setOrderColumn(String orderColumn) {
        this.orderColumn = orderColumn;
    }

    public Integer getPagenumber() {
        return pagenumber;
    }

    public void setPagenumber(Integer pagenumber) {
        this.pagenumber = pagenumber;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getGroupColumn() {
        return groupColumn;
    }

    public void setGroupColumn(String groupColumn) {
        this.groupColumn = groupColumn;
    }

    public boolean isShowXh() {
        return showXh;
    }

    public void setShowXh(boolean showXh) {
        this.showXh = showXh;
    }

    public String getDateColumn() {
        return dateColumn;
    }

    public void setDateColumn(String dateColumn) {
        this.dateColumn = dateColumn;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String[] getStrCols() {
        return strCols;
    }

    public void setStrCols(String[] strCols) {
        this.strCols = strCols;
    }

    public String getTotalColumn() {
        return totalColumn;
    }

    public void setTotalColumn(String totalColumn) {
        this.totalColumn = totalColumn;
    }
}
