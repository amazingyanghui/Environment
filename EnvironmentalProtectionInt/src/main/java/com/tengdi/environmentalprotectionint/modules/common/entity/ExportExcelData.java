package com.tengdi.environmentalprotectionint.modules.common.entity;

public class ExportExcelData extends QueryCriterias {
    // excel表头
    private String headers;
    // 表头对应的列字段
    private String headerFields;
    // excel文件名
    private String title;

    public String getHeaderFields() {
        return headerFields;
    }

    public void setHeaderFields(String headerFields) {
        this.headerFields = headerFields;
    }

    public String getHeaders() {
        return headers;
    }

    public void setHeaders(String headers) {
        this.headers = headers;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
