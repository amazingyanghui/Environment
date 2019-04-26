package com.tengdi.environmentalprotectionint.modules.emergency.entity;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;

import java.io.Serializable;
import java.util.Date;

/**
 * 应急物资
 *
 * @author tengdi
 * @email
 * @date 2018-09-11 10:39:12
 */
@TableName("emergency_system_supplies")
public class EmergencySystemSuppliesEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键UUID
	 */
	@TableId
	private String pid;
	/**
	 * 对应的污染源（企业）ID
	 */
	private String cid;
	/**
	 * 存放单位
	 */
	@TableField(exist = false)
	private String companyName;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * 物资名称
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String suppliesName;
	/**
	 * 物资数量
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Double suppliesNumber;
	/**
	 * 物资单位
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String suppliesUnit;
	/**
	 * 物资类型
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer suppliesType;
	/**
	 * 物资类型name
	 */
	@TableField(exist = false)
	private String suppliesTypeName;

	public String getSuppliesTypeName() {
		return suppliesTypeName;
	}

	public void setSuppliesTypeName(String suppliesTypeName) {
		this.suppliesTypeName = suppliesTypeName;
	}

	/**
	 * 存放单位（企业）
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String storeCompany;
	/**
	 * 存放地址
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String storeAddress;
	/**
	 * 联系人
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String linkmen;
	/**
	 * 联系人电话
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String linkphone;
	/**
	 * 创建时间
	 */
	private Date createdate;
	/**
	 * 应急处置设施
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer emergencyDisposalFacility;

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
	 * 设置：对应的污染源（企业）ID
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}
	/**
	 * 获取：对应的污染源（企业）ID
	 */
	public String getCid() {
		return cid;
	}
	/**
	 * 设置：物资名称
	 */
	public void setSuppliesName(String suppliesName) {
		this.suppliesName = suppliesName;
	}
	/**
	 * 获取：物资名称
	 */
	public String getSuppliesName() {
		return suppliesName;
	}
	/**
	 * 设置：物资数量
	 */
	public void setSuppliesNumber(Double suppliesNumber) {
		this.suppliesNumber = suppliesNumber;
	}
	/**
	 * 获取：物资数量
	 */
	public Double getSuppliesNumber() {
		return suppliesNumber;
	}
	/**
	 * 设置：物资单位
	 */
	public void setSuppliesUnit(String suppliesUnit) {
		this.suppliesUnit = suppliesUnit;
	}
	/**
	 * 获取：物资单位
	 */
	public String getSuppliesUnit() {
		return suppliesUnit;
	}
	/**
	 * 设置：物资类型
	 */
	public void setSuppliesType(Integer suppliesType) {
		this.suppliesType = suppliesType;
	}
	/**
	 * 获取：物资类型
	 */
	public Integer getSuppliesType() {
		return suppliesType;
	}
	/**
	 * 设置：存放单位（企业）
	 */
	public void setStoreCompany(String storeCompany) {
		this.storeCompany = storeCompany;
	}
	/**
	 * 获取：存放单位（企业）
	 */
	public String getStoreCompany() {
		return storeCompany;
	}
	/**
	 * 设置：存放地址
	 */
	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}
	/**
	 * 获取：存放地址
	 */
	public String getStoreAddress() {
		return storeAddress;
	}
	/**
	 * 设置：联系人
	 */
	public void setLinkmen(String linkmen) {
		this.linkmen = linkmen;
	}
	/**
	 * 获取：联系人
	 */
	public String getLinkmen() {
		return linkmen;
	}
	/**
	 * 设置：联系人电话
	 */
	public void setLinkphone(String linkphone) {
		this.linkphone = linkphone;
	}
	/**
	 * 获取：联系人电话
	 */
	public String getLinkphone() {
		return linkphone;
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
	 * 设置：应急处置设施
	 */
	public void setEmergencyDisposalFacility(Integer emergencyDisposalFacility) {
		this.emergencyDisposalFacility = emergencyDisposalFacility;
	}
	/**
	 * 获取：应急处置设施
	 */
	public Integer getEmergencyDisposalFacility() {
		return emergencyDisposalFacility;
	}
}
