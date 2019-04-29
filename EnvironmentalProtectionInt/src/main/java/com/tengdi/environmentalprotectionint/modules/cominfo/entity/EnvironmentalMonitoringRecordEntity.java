package com.tengdi.environmentalprotectionint.modules.cominfo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;

import java.io.Serializable;
import java.util.Date;

/**
 * 环境监察记录表
 * 
 * @author tengdi
 * @email 
 * @date 2018-12-04 10:50:12
 */
@TableName("environmental_monitoring_record")
public class EnvironmentalMonitoringRecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键（UUID）
	 */
	@TableId
	private String pid;
	/**
	 * 关联的企业ID
	 */
	private String cid;
	/**
	 * 公司名称
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
	 * 检测人
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String testerName;
	/**
	 * 检测类型
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String testType;
	/**
	 * 检测内容
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String testContent;
	/**
	 * 检测时间
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String testDate;
	/**
	 * 创建日期
	 */
	private Date createdate;
	/**
	 * 修改日期
	 */
	private Date updatedate;
	/**
	 * 
	 */
	private Date deletedate;

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
	 * 设置：关联的企业ID
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}
	/**
	 * 获取：关联的企业ID
	 */
	public String getCid() {
		return cid;
	}
	/**
	 * 设置：检测人
	 */
	public void setTesterName(String testerName) {
		this.testerName = testerName;
	}
	/**
	 * 获取：检测人
	 */
	public String getTesterName() {
		return testerName;
	}
	/**
	 * 设置：检测类型
	 */
	public void setTestType(String testType) {
		this.testType = testType;
	}
	/**
	 * 获取：检测类型
	 */
	public String getTestType() {
		return testType;
	}
	/**
	 * 设置：检测内容
	 */
	public void setTestContent(String testContent) {
		this.testContent = testContent;
	}
	/**
	 * 获取：检测内容
	 */
	public String getTestContent() {
		return testContent;
	}
	/**
	 * 设置：检测时间
	 */
	public void setTestDate(String testDate) {
		this.testDate = testDate;
	}
	/**
	 * 获取：检测时间
	 */
	public String getTestDate() {
		return testDate;
	}
	/**
	 * 设置：创建日期
	 */
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	/**
	 * 获取：创建日期
	 */
	public Date getCreatedate() {
		return createdate;
	}
	/**
	 * 设置：修改日期
	 */
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	/**
	 * 获取：修改日期
	 */
	public Date getUpdatedate() {
		return updatedate;
	}
	/**
	 * 设置：
	 */
	public void setDeletedate(Date deletedate) {
		this.deletedate = deletedate;
	}
	/**
	 * 获取：
	 */
	public Date getDeletedate() {
		return deletedate;
	}
}
