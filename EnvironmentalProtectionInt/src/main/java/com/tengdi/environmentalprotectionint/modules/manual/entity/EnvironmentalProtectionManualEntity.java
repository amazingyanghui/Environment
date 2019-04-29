package com.tengdi.environmentalprotectionint.modules.manual.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 环保手册法律法规节点目录
 *
 * @author tengdi
 * @email
 * @date 2018-10-10 15:28:58
 */
@TableName("environmental_protection_manual")
public class EnvironmentalProtectionManualEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键(UUID)
	 */
	@TableId
	private String pid;
	/**
	 * 父级目录，一级目录为0
	 */
	private String parentId;
	/**
	 * 节点名称
	 */
	private String codeName;
	/**
	 * 上级目录名称
	 */
	private String parentName;
	/**
	 * 状态
	 */
	private Integer status;
	/**
	 * 目录编码
	 */
	private String storeCode;
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 更新时间
	 */
	private Date updateDate;
	/**
	 * 删除时间
	 */
	private Date deleteDate;
	/**
	 * 备注
	 */
	private String backup;

	/**
	 * 设置：主键(UUID)
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}
	/**
	 * 获取：主键(UUID)
	 */
	public String getPid() {
		return pid;
	}
	/**
	 * 设置：父级目录，一级目录为0
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：父级目录，一级目录为0
	 */
	public String getParentId() {
		return parentId;
	}
	/**
	 * 设置：节点名称
	 */
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}
	/**
	 * 获取：节点名称
	 */
	public String getCodeName() {
		return codeName;
	}
	/**
	 * 设置：上级目录名称
	 */
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	/**
	 * 获取：上级目录名称
	 */
	public String getParentName() {
		return parentName;
	}
	/**
	 * 设置：状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：目录编码
	 */
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
	/**
	 * 获取：目录编码
	 */
	public String getStoreCode() {
		return storeCode;
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
	 * 设置：更新时间
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	/**
	 * 获取：更新时间
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
	/**
	 * 设置：备注
	 */
	public void setBackup(String backup) {
		this.backup = backup;
	}
	/**
	 * 获取：备注
	 */
	public String getBackup() {
		return backup;
	}
}