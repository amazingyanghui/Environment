package com.tengdi.environmentalprotectionint.modules.cominfo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;

import java.io.Serializable;
import java.util.Date;

/**
 * 主要产品
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-02 17:42:18
 */
@TableName("cominfo_production_product")
public class CominfoProductionProductEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键UUID
	 */
	@TableId
	private String pid;
	/**
	 * 映射基本信息表主键（UUID）
	 */
	private String cid;
	/**
	 * 产品代码
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String productCode;
	/**
	 * 产品名称
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String productName;
	/**
	 * 年产量
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String annualOutput;
	/**
	 * 实际年产量 
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String actualAnnualOutput;
	/**
	 * 单位
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String unit;
	/**
	 * 备注
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String remarks;
	/**
	 * 创建时间
	 */
	private Date createdate;
	/**
	 * 修改时间
	 */
	private Date updatedate;
	/**
	 * 删除时间
	 */
	private Date deletedate;

	/**
	 * 设置：主键UUID
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}
	/**
	 * 获取：主键UUID
	 */
	public String getPid() {
		return pid;
	}
	/**
	 * 设置：映射基本信息表主键（UUID）
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}
	/**
	 * 获取：映射基本信息表主键（UUID）
	 */
	public String getCid() {
		return cid;
	}
	/**
	 * 设置：产品代码
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	/**
	 * 获取：产品代码
	 */
	public String getProductCode() {
		return productCode;
	}
	/**
	 * 设置：产品名称
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * 获取：产品名称
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * 设置：年产量
	 */
	public void setAnnualOutput(String annualOutput) {
		this.annualOutput = annualOutput;
	}
	/**
	 * 获取：年产量
	 */
	public String getAnnualOutput() {
		return annualOutput;
	}
	/**
	 * 设置：实际年产量 
	 */
	public void setActualAnnualOutput(String actualAnnualOutput) {
		this.actualAnnualOutput = actualAnnualOutput;
	}
	/**
	 * 获取：实际年产量 
	 */
	public String getActualAnnualOutput() {
		return actualAnnualOutput;
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
	/**
	 * 设置：备注
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * 获取：备注
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreatedate() {
		return createdate;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdatedate() {
		return updatedate;
	}
	/**
	 * 设置：删除时间
	 */
	public void setDeletedate(Date deletedate) {
		this.deletedate = deletedate;
	}
	/**
	 * 获取：删除时间
	 */
	public Date getDeletedate() {
		return deletedate;
	}
}
