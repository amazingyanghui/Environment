package com.tengdi.environmentalprotectionint.modules.greentaxesinformation.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 危险废物
 * 
 * @author tengdi
 * @email 
 * @date 2019-03-05 17:03:48
 */
@TableName("sys_waste")
public class SysWasteEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	private Integer id;
	/**
	 * 废物类别
	 */
	private String wastetype;
	/**
	 * 废物名称
	 */
	private String wastename;
	/**
	 * 行业来源
	 */
	private String company;
	/**
	 * 废物代码
	 */
	private String wastecode;
	/**
	 * 危险废物
	 */
	private String waste;
	/**
	 * 危险特性
	 */
	private String danger;
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
	 * 备用
	 */
	private String backup;

	/**
	 * 设置：ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：ID
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：废物类别
	 */
	public void setWastetype(String wastetype) {
		this.wastetype = wastetype;
	}
	/**
	 * 获取：废物类别
	 */
	public String getWastetype() {
		return wastetype;
	}
	/**
	 * 设置：废物名称
	 */
	public void setWastename(String wastename) {
		this.wastename = wastename;
	}
	/**
	 * 获取：废物名称
	 */
	public String getWastename() {
		return wastename;
	}
	/**
	 * 设置：行业来源
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	/**
	 * 获取：行业来源
	 */
	public String getCompany() {
		return company;
	}
	/**
	 * 设置：废物代码
	 */
	public void setWastecode(String wastecode) {
		this.wastecode = wastecode;
	}
	/**
	 * 获取：废物代码
	 */
	public String getWastecode() {
		return wastecode;
	}
	/**
	 * 设置：危险废物
	 */
	public void setWaste(String waste) {
		this.waste = waste;
	}
	/**
	 * 获取：危险废物
	 */
	public String getWaste() {
		return waste;
	}
	/**
	 * 设置：危险特性
	 */
	public void setDanger(String danger) {
		this.danger = danger;
	}
	/**
	 * 获取：危险特性
	 */
	public String getDanger() {
		return danger;
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
	/**
	 * 设置：备用
	 */
	public void setBackup(String backup) {
		this.backup = backup;
	}
	/**
	 * 获取：备用
	 */
	public String getBackup() {
		return backup;
	}
}
