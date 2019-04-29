package com.tengdi.environmentalprotectionint.modules.emergency.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;

import java.io.Serializable;
import java.util.Date;

/**
 * 应急队伍
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-23 15:10:45
 */
@TableName("emergency_system_ranks")
public class EmergencySystemRanksEntity implements Serializable {
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
	@TableField(exist = false)
	private String companyName;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * 队伍名称
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String ranksName;
	/**
	 * 所属单位（企业）
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String ranksCompany;
	/**
	 * 队伍人数
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer ranksNumber;
	/**
	 * 队伍特长
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String ranksSpeciality;
	/**
	 * 联系人
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String linkmen;
	/**
	 * 联系电话
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String linkphone;
	/**
	 * 地址
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String address;
	/**
	 * 创建时间
	 */
	private Date createdate;

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
	 * 设置：队伍名称
	 */
	public void setRanksName(String ranksName) {
		this.ranksName = ranksName;
	}
	/**
	 * 获取：队伍名称
	 */
	public String getRanksName() {
		return ranksName;
	}
	/**
	 * 设置：所属单位（企业）
	 */
	public void setRanksCompany(String ranksCompany) {
		this.ranksCompany = ranksCompany;
	}
	/**
	 * 获取：所属单位（企业）
	 */
	public String getRanksCompany() {
		return ranksCompany;
	}
	/**
	 * 设置：队伍人数
	 */
	public void setRanksNumber(Integer ranksNumber) {
		this.ranksNumber = ranksNumber;
	}
	/**
	 * 获取：队伍人数
	 */
	public Integer getRanksNumber() {
		return ranksNumber;
	}
	/**
	 * 设置：队伍特长
	 */
	public void setRanksSpeciality(String ranksSpeciality) {
		this.ranksSpeciality = ranksSpeciality;
	}
	/**
	 * 获取：队伍特长
	 */
	public String getRanksSpeciality() {
		return ranksSpeciality;
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
	 * 设置：联系电话
	 */
	public void setLinkphone(String linkphone) {
		this.linkphone = linkphone;
	}
	/**
	 * 获取：联系电话
	 */
	public String getLinkphone() {
		return linkphone;
	}
	/**
	 * 设置：地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：地址
	 */
	public String getAddress() {
		return address;
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
}
