package com.tengdi.environmentalprotectionint.modules.online.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;

import java.io.Serializable;

/**
 * 因子信息表
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-21 14:52:07
 */
@TableName("online_monitor_factor")
public class OnlineMonitorFactorEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 因子ID(主键UUID)
	 */
	@TableId
	private String pid;
	/**
	 * 因子名称
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String factorName;
	/**
	 * 因子编码
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String factorCode;
	/**
	 * 因子国际编码
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String factorInternationalCode;
	/**
	 * 排序序号
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer sort;
	/**
	 * 单位
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String unit;
	/**
	 * 排放量单位
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String emissionUnit;

	public String getEmissionUnit() {
		return emissionUnit;
	}

	public void setEmissionUnit(String emissionUnit) {
		this.emissionUnit = emissionUnit;
	}

	/**
	 * 因子分类（0:废水，1：废气；2：VOC）字典维护
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer factorType;

	/**
	 * 因子分类名称
	 */
	@TableField(exist = false)
	private String factorTypeName;

	public String getFactorTypeName() {
		return factorTypeName;
	}

	public void setFactorTypeName(String factorTypeName) {
		this.factorTypeName = factorTypeName;
	}

	/**
	 * 是否是环境因子（0：环境因素，1：监测因子）
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer isEnvironmentFactor;

	public Integer getFactorType() {
		return factorType;
	}

	public void setFactorType(Integer factorType) {
		this.factorType = factorType;
	}

	public Integer getIsEnvironmentFactor() {
		return isEnvironmentFactor;
	}

	public void setIsEnvironmentFactor(Integer isEnvironmentFactor) {
		this.isEnvironmentFactor = isEnvironmentFactor;
	}

	/**
	 * 设置：因子ID(主键UUID)
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}
	/**
	 * 获取：因子ID(主键UUID)
	 */
	public String getPid() {
		return pid;
	}
	/**
	 * 设置：因子名称
	 */
	public void setFactorName(String factorName) {
		this.factorName = factorName;
	}
	/**
	 * 获取：因子名称
	 */
	public String getFactorName() {
		return factorName;
	}
	/**
	 * 设置：因子编码
	 */
	public void setFactorCode(String factorCode) {
		this.factorCode = factorCode;
	}
	/**
	 * 获取：因子编码
	 */
	public String getFactorCode() {
		return factorCode;
	}
	/**
	 * 设置：因子国际编码
	 */
	public void setFactorInternationalCode(String factorInternationalCode) {
		this.factorInternationalCode = factorInternationalCode;
	}
	/**
	 * 获取：因子国际编码
	 */
	public String getFactorInternationalCode() {
		return factorInternationalCode;
	}
	/**
	 * 设置：排序序号
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 获取：排序序号
	 */
	public Integer getSort() {
		return sort;
	}
	/**
	 * 设置：单位
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	/**
	 * 获取：单位
	 */
	public String getUnit() {
		return unit;
	}
}
