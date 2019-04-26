package com.tengdi.environmentalprotectionint.modules.common.entity;

import java.io.Serializable;

public class ImportExcelEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    //pid
    private String pid;
    // 表名
    private String tableName;
    // 表字段
    private String colsName;
    // 表字段value
    private String colsValue;
    //父id
    private String outId;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColsName() {
        return colsName;
    }

    public void setColsName(String colsName) {
        this.colsName = colsName;
    }

    public String getColsValue() {
        return colsValue;
    }

    public void setColsValue(String colsValue) {
        this.colsValue = colsValue;
    }

    public String getOutId() {
        return outId;
    }

    public void setOutId(String outId) {
        this.outId = outId;
    }
}
