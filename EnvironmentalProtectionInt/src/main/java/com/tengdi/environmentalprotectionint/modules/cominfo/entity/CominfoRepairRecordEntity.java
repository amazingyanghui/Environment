package com.tengdi.environmentalprotectionint.modules.cominfo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;

import java.io.Serializable;
import java.util.Date;

/**
 * 治理设施维护记录表
 * 
 * @author tengdi
 * @email 
 * @date 2018-10-19 15:19:06
 */
@TableName("cominfo_repair_record")
public class CominfoRepairRecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String pid;
	/**
	 * 公司id
	 */
	private String cid;
	/**
	 * 排口id
	 */
	private String mid;
	/**
	 * 治理设施id
	 */
	private String wid;
	/**
	 * 维护人
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String repairPerson;
	/**
	 * 维护内容
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String repairContent;
	/**
	 * 维护情况
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String repairCondition;
	/**
	 * 维护时间
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String repairDate;
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
	 * 备用
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String backup;

	/**
	 * 设置：
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}
	/**
	 * 获取：
	 */
	public String getPid() {
		return pid;
	}
	/**
	 * 设置：公司id
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}
	/**
	 * 获取：公司id
	 */
	public String getCid() {
		return cid;
	}
	/**
	 * 设置：排口id
	 */
	public void setMid(String mid) {
		this.mid = mid;
	}
	/**
	 * 获取：排口id
	 */
	public String getMid() {
		return mid;
	}
	/**
	 * 设置：治理设施id
	 */
	public void setWid(String wid) {
		this.wid = wid;
	}
	/**
	 * 获取：治理设施id
	 */
	public String getWid() {
		return wid;
	}
	/**
	 * 设置：维护人
	 */
	public void setRepairPerson(String repairPerson) {
		this.repairPerson = repairPerson;
	}
	/**
	 * 获取：维护人
	 */
	public String getRepairPerson() {
		return repairPerson;
	}
	/**
	 * 设置：维护内容
	 */
	public void setRepairContent(String repairContent) {
		this.repairContent = repairContent;
	}
	/**
	 * 获取：维护内容
	 */
	public String getRepairContent() {
		return repairContent;
	}
	/**
	 * 设置：维护情况
	 */
	public void setRepairCondition(String repairCondition) {
		this.repairCondition = repairCondition;
	}
	/**
	 * 获取：维护情况
	 */
	public String getRepairCondition() {
		return repairCondition;
	}
	/**
	 * 设置：维护时间
	 */
	public void setRepairDate(String repairDate) {
		this.repairDate = repairDate;
	}
	/**
	 * 获取：维护时间
	 */
	public String getRepairDate() {
		return repairDate;
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
