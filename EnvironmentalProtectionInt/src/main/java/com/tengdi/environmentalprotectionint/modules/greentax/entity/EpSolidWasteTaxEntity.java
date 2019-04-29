package com.tengdi.environmentalprotectionint.modules.greentax.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;

import java.io.Serializable;
import java.util.Date;

/**
 * 固体废物环保税上报
 * 
 * @author tengdi
 * @email 
 * @date 2019-03-06 09:52:02
 */
@TableName("ep_solid_waste_tax")
public class EpSolidWasteTaxEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 固废采集表中固废ID
	 */
	private String solidWasteId;
	/**
	 * 处置方式
	 */
	private String dispostionType;
	/**
	 * 产生量
	 */
	private String quantity;
	/**
	 * 综合利用量
	 */
	private String comprehensiveUtilization;
	/**
	 * 处置量
	 */
	private String disposalCapacity;
	/**
	 * 上报区间
	 */
	private String reportSection;
	/**
	 * 0 未提交 1 已提交，待审核 2 已审核  
	 */
	private String status;
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 创建用户
	 */
	private String createUser;
	/**
	 * 设施编号
	 */
	@TableField(exist = false)
	private String measuresCode;
	/**
	 * 设施名称
	 */
	@TableField(exist = false)
	private String measuresName;
	/**
	 * 固体废物名或编码
	 */
	@TableField(exist = false)
	private String waste;
	/**
	 * 八位码
	 */
	@TableField(exist = false)
	private String eightCode;
	/**
	 * 综合利用方式/处置方式
	 */
	@TableField(exist = false)
	private String mode;
	/**
	 * 设置：
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：固废采集表中固废ID
	 */
	public void setSolidWasteId(String solidWasteId) {
		this.solidWasteId = solidWasteId;
	}
	/**
	 * 获取：固废采集表中固废ID
	 */
	public String getSolidWasteId() {
		return solidWasteId;
	}
	/**
	 * 设置：处置方式
	 */
	public void setDispostionType(String dispostionType) {
		this.dispostionType = dispostionType;
	}
	/**
	 * 获取：处置方式
	 */
	public String getDispostionType() {
		return dispostionType;
	}
	/**
	 * 设置：产生量
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	/**
	 * 获取：产生量
	 */
	public String getQuantity() {
		return quantity;
	}
	/**
	 * 设置：综合利用量
	 */
	public void setComprehensiveUtilization(String comprehensiveUtilization) {
		this.comprehensiveUtilization = comprehensiveUtilization;
	}
	/**
	 * 获取：综合利用量
	 */
	public String getComprehensiveUtilization() {
		return comprehensiveUtilization;
	}
	/**
	 * 设置：处置量
	 */
	public void setDisposalCapacity(String disposalCapacity) {
		this.disposalCapacity = disposalCapacity;
	}
	/**
	 * 获取：处置量
	 */
	public String getDisposalCapacity() {
		return disposalCapacity;
	}
	/**
	 * 设置：0 未提交 1 已提交，待审核 2 已审核  
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：0 未提交 1 已提交，待审核 2 已审核  
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * 设置：创建用户
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取：创建用户
	 */
	public String getCreateUser() {
		return createUser;
	}

	public String getReportSection() {
		return reportSection;
	}

	public void setReportSection(String reportSection) {
		this.reportSection = reportSection;
	}

	public String getMeasuresCode() {
		return measuresCode;
	}

	public void setMeasuresCode(String measuresCode) {
		this.measuresCode = measuresCode;
	}

	public String getMeasuresName() {
		return measuresName;
	}

	public void setMeasuresName(String measuresName) {
		this.measuresName = measuresName;
	}

	public String getWaste() {
		return waste;
	}

	public void setWaste(String waste) {
		this.waste = waste;
	}

	public String getEightCode() {
		return eightCode;
	}

	public void setEightCode(String eightCode) {
		this.eightCode = eightCode;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}
}
