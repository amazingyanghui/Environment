package com.tengdi.environmentalprotectionint.modules.statistics.entity;

import java.io.Serializable;

/**
 *
 * 大屏图
 * @author tengdi
 * @email 
 * @date 2018-10-26 10:10:19
 */
public class StatisticsTotalEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;

	private Integer count;

	private Integer type;

	private String createDate;

	private Double couValue;

	private Integer differType;

	private String couValueName;

	private String unit;

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getCouValueName() {
		return couValueName;
	}

	public void setCouValueName(String couValueName) {
		this.couValueName = couValueName;
	}

	public Integer getDifferType() {
		return differType;
	}

	public void setDifferType(Integer differType) {
		this.differType = differType;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public Double getCouValue() {
		return couValue;
	}

	public void setCouValue(Double couValue) {
		this.couValue = couValue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}
