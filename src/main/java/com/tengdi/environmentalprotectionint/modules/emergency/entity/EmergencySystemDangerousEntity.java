package com.tengdi.environmentalprotectionint.modules.emergency.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;

import java.io.Serializable;
import java.util.Date;

/**
 * 危险化学品
 * 
 * @author tengdi
 * @email 
 * @date 2018-09-11 11:50:45
 */
@TableName("emergency_system_dangerous")
public class EmergencySystemDangerousEntity implements Serializable {
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
	 * 品名
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String dangerousName;
	/**
	 * 别名
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String dangerousAnotherName;
	/**
	 * CAS号
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String casNumber;
	/**
	 * UN号
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String unNumer;
	/**
	 * 特性（危害类型）多种。类型按照危险化学品目录中的规定
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String dangerousType;
	/**
	 * 特性（危害类型）多种。类型按照危险化学品目录中的规定
	 */
	@TableField(exist = false)
	private String dangerousTypeName;

	public String getDangerousTypeName() {
		return dangerousTypeName;
	}

	public void setDangerousTypeName(String dangerousTypeName) {
		this.dangerousTypeName = dangerousTypeName;
	}

	/**
	 * 数量
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String amount;
	/**
	 * 化学品属性(产品、原料等)
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String dangerousAttribute;
	/**
	 * 防范说明
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String precautionaryNote;
	/**
	 * 应急处置
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String emergencyDisposal;
	/**
	 * 用途
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String purpose;
	/**
	 * 限制的用途
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String restrictedUses;
	/**
	 * 应用的行业领域
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String industryArea;
	/**
	 * 创建时间
	 */
	private Date createdate;
	/**
	 * 存放单位
	 */
	@TableField(exist=false)
	private String companyName;
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
	 * 设置：品名
	 */
	public void setDangerousName(String dangerousName) {
		this.dangerousName = dangerousName;
	}
	/**
	 * 获取：品名
	 */
	public String getDangerousName() {
		return dangerousName;
	}
	/**
	 * 设置：别名
	 */
	public void setDangerousAnotherName(String dangerousAnotherName) {
		this.dangerousAnotherName = dangerousAnotherName;
	}
	/**
	 * 获取：别名
	 */
	public String getDangerousAnotherName() {
		return dangerousAnotherName;
	}
	/**
	 * 设置：CAS号
	 */
	public void setCasNumber(String casNumber) {
		this.casNumber = casNumber;
	}
	/**
	 * 获取：CAS号
	 */
	public String getCasNumber() {
		return casNumber;
	}
	/**
	 * 设置：UN号
	 */
	public void setUnNumer(String unNumer) {
		this.unNumer = unNumer;
	}
	/**
	 * 获取：UN号
	 */
	public String getUnNumer() {
		return unNumer;
	}
	/**
	 * 设置：特性（危害类型）多种。类型按照危险化学品目录中的规定
	 */
	public void setDangerousType(String dangerousType) {
		this.dangerousType = dangerousType;
	}
	/**
	 * 获取：特性（危害类型）多种。类型按照危险化学品目录中的规定
	 */
	public String getDangerousType() {
		return dangerousType;
	}
	/**
	 * 设置：数量
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	/**
	 * 获取：数量
	 */
	public String getAmount() {
		return amount;
	}
	/**
	 * 设置：化学品属性(产品、原料等)
	 */
	public void setDangerousAttribute(String dangerousAttribute) {
		this.dangerousAttribute = dangerousAttribute;
	}
	/**
	 * 获取：化学品属性(产品、原料等)
	 */
	public String getDangerousAttribute() {
		return dangerousAttribute;
	}
	/**
	 * 设置：防范说明
	 */
	public void setPrecautionaryNote(String precautionaryNote) {
		this.precautionaryNote = precautionaryNote;
	}
	/**
	 * 获取：防范说明
	 */
	public String getPrecautionaryNote() {
		return precautionaryNote;
	}
	/**
	 * 设置：应急处置
	 */
	public void setEmergencyDisposal(String emergencyDisposal) {
		this.emergencyDisposal = emergencyDisposal;
	}
	/**
	 * 获取：应急处置
	 */
	public String getEmergencyDisposal() {
		return emergencyDisposal;
	}
	/**
	 * 设置：用途
	 */
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	/**
	 * 获取：用途
	 */
	public String getPurpose() {
		return purpose;
	}
	/**
	 * 设置：限制的用途
	 */
	public void setRestrictedUses(String restrictedUses) {
		this.restrictedUses = restrictedUses;
	}
	/**
	 * 获取：限制的用途
	 */
	public String getRestrictedUses() {
		return restrictedUses;
	}
	/**
	 * 设置：应用的行业领域
	 */
	public void setIndustryArea(String industryArea) {
		this.industryArea = industryArea;
	}
	/**
	 * 获取：应用的行业领域
	 */
	public String getIndustryArea() {
		return industryArea;
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
}
