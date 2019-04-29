package com.tengdi.environmentalprotectionint.modules.common.entity;

public class SelectEntity {
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private Integer type;
    private String code;

    public SelectEntity() {
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
