package com.tengdi.environmentalprotectionint.modules.greentax.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Date;
/**
 * 固体废物基础信息采集主表
 * 
 * @author tengdi
 * @email 
 * @date 2019-03-06 10:20:18
 */
@TableName("ep_solid_waste_main")
public class EpSolidWasteMainEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 企业ID
	 */
	private String companyId;
	/**
	 * 主管部门
	 */
	private String competentDepartment;
	/**
	 * 主管税务
	 */
	private String competentTax;
	/**
	 * 危废ID，多个以逗号分隔
	 */
	private String wasteIds;
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 创建用户
	 */
	private String createUser;

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
	 * 设置：企业ID
	 */
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	/**
	 * 获取：企业ID
	 */
	public String getCompanyId() {
		return companyId;
	}
	/**
	 * 设置：主管部门
	 */
	public void setCompetentDepartment(String competentDepartment) {
		this.competentDepartment = competentDepartment;
	}
	/**
	 * 获取：主管部门
	 */
	public String getCompetentDepartment() {
		return competentDepartment;
	}
	/**
	 * 设置：主管税务
	 */
	public void setCompetentTax(String competentTax) {
		this.competentTax = competentTax;
	}
	/**
	 * 获取：主管税务
	 */
	public String getCompetentTax() {
		return competentTax;
	}
	/**
	 * 设置：危废ID，多个以逗号分隔
	 */
	public void setWasteIds(String wasteIds) {
		this.wasteIds = wasteIds;
	}
	/**
	 * 获取：危废ID，多个以逗号分隔
	 */
	public String getWasteIds() {
		return wasteIds;
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
}
