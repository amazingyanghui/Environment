package com.tengdi.environmentalprotectionint.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 审批单位字典表
 * 
 * @author tengdi
 * @email 
 * @date 2018-10-18 12:00:20
 */
@TableName("sys_approval_unit")
public class SysApprovalUnitEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * uuid
	 */
	@TableId
	private String pid;
	/**
	 * 审批单位代码
	 */
	private String companyCode;
	/**
	 * 审批单位名称
	 */
	private String companyName;
	/**
	 * 序号
	 */
	private Integer sort;
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 修改时间
	 */
	private Date updateDate;
	/**
	 * 删除时间
	 */
	private Date deleteDate;

	/**
	 * 设置：uuid
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}
	/**
	 * 获取：uuid
	 */
	public String getPid() {
		return pid;
	}
	/**
	 * 设置：审批单位代码
	 */
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	/**
	 * 获取：审批单位代码
	 */
	public String getCompanyCode() {
		return companyCode;
	}
	/**
	 * 设置：审批单位名称
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * 获取：审批单位名称
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * 设置：序号
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 获取：序号
	 */
	public Integer getSort() {
		return sort;
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
	 * 设置：修改时间
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * 设置：删除时间
	 */
	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}
	/**
	 * 获取：删除时间
	 */
	public Date getDeleteDate() {
		return deleteDate;
	}
}
