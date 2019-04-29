package com.tengdi.environmentalprotectionint.modules.seeper.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 江北新区积淹水点整治任务表
 * 
 * @author tengdi
 * @email 
 * @date 2018-10-26 10:10:19
 */
@TableName("seeper_task")
public class SeeperTaskEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键（UUID）
	 */
	@TableId
	private String pid;
	/**
	 * 任务分类（取自字典表）
	 */
	private Integer seeperType;
	@TableField(exist = false)
	private String seeperTypeName;

	public String getSeeperTypeName() {
		return seeperTypeName;
	}

	public void setSeeperTypeName(String seeperTypeName) {
		this.seeperTypeName = seeperTypeName;
	}

	/**
	 * 项目名称
	 */
	private String projectName;
	/**
	 * 积水原因
	 */
	private String seeperReason;
	/**
	 * 建设单位
	 */
	private String buildUnit;
	/**
	 * 序号
	 */
	private Integer sort;
	/**
	 * 创建时间
	 */
	private String createdate;
	/**
	 * 更新时间
	 */
	private String updatedate;
	/**
	 * 删除时间
	 */
	private String deletedate;
	/**
	 * 建设项目和整治措施
	 */
	private String renovateProject;

	/**
	 * 设置：主键（UUID）
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}
	/**
	 * 获取：主键（UUID）
	 */
	public String getPid() {
		return pid;
	}
	/**
	 * 设置：任务分类（取自字典表）
	 */
	public void setSeeperType(Integer seeperType) {
		this.seeperType = seeperType;
	}
	/**
	 * 获取：任务分类（取自字典表）
	 */
	public Integer getSeeperType() {
		return seeperType;
	}
	/**
	 * 设置：项目名称
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	/**
	 * 获取：项目名称
	 */
	public String getProjectName() {
		return projectName;
	}
	/**
	 * 设置：积水原因
	 */
	public void setSeeperReason(String seeperReason) {
		this.seeperReason = seeperReason;
	}
	/**
	 * 获取：积水原因
	 */
	public String getSeeperReason() {
		return seeperReason;
	}
	/**
	 * 设置：建设单位（取自字典表）
	 */
	public void setBuildUnit(String buildUnit) {
		this.buildUnit = buildUnit;
	}
	/**
	 * 获取：建设单位（取自字典表）
	 */
	public String getBuildUnit() {
		return buildUnit;
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
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	/**
	 * 获取：创建时间
	 */
	public String getCreatedate() {
		return createdate;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	/**
	 * 获取：更新时间
	 */
	public String getUpdatedate() {
		return updatedate;
	}
	/**
	 * 设置：删除时间
	 */
	public void setDeletedate(String deletedate) {
		this.deletedate = deletedate;
	}
	/**
	 * 获取：删除时间
	 */
	public String getDeletedate() {
		return deletedate;
	}
	/**
	 * 设置：建设项目和整治措施
	 */
	public void setRenovateProject(String renovateProject) {
		this.renovateProject = renovateProject;
	}
	/**
	 * 获取：建设项目和整治措施
	 */
	public String getRenovateProject() {
		return renovateProject;
	}
}
