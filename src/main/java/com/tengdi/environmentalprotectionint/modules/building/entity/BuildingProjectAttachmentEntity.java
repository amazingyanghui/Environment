package com.tengdi.environmentalprotectionint.modules.building.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.tengdi.core.utils.DateUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * 审批/批复文件
 * 
 * @author tengdi
 * @email 
 * @date 2018-09-07 17:55:13
 */
@TableName("building_project_attachment")
public class BuildingProjectAttachmentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID（UUID）
	 */
	@TableId
	private String pid;
	/**
	 * 文件名称
	 */
	private String fileName;
	/**
	 * 附件大小
	 */
	private String attachmentSize;
	/**
	 * 附件格式
	 */
	private String attachmentFormat;
	/**
	 * 附件地址
	 */
	private String attachmentUrl;
	/**
	 * 创建时间
	 */
	private Date createdate;
	/**
	 * 建设项目id
	 */
	private String bid;

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	/**
	 * 创建时间，转换String接受
	 */
	@TableField(exist = false)
	private String createdateStr;

	/**
	 * 设置：主键ID（UUID）
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}
	/**
	 * 获取：主键ID（UUID）
	 */
	public String getPid() {
		return pid;
	}
	/**
	 * 设置：文件名称
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * 获取：文件名称
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * 设置：附件大小
	 */
	public void setAttachmentSize(String attachmentSize) {
		this.attachmentSize = attachmentSize;
	}
	/**
	 * 获取：附件大小
	 */
	public String getAttachmentSize() {
		return attachmentSize;
	}
	/**
	 * 设置：附件格式
	 */
	public void setAttachmentFormat(String attachmentFormat) {
		this.attachmentFormat = attachmentFormat;
	}
	/**
	 * 获取：附件格式
	 */
	public String getAttachmentFormat() {
		return attachmentFormat;
	}
	/**
	 * 设置：附件地址
	 */
	public void setAttachmentUrl(String attachmentUrl) {
		this.attachmentUrl = attachmentUrl;
	}
	/**
	 * 获取：附件地址
	 */
	public String getAttachmentUrl() {
		return attachmentUrl;
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

	public String getCreatedateStr() {
		return  DateUtils.format(createdate);
	}

	public void setCreatedateStr(String createdateStr) {
		this.createdateStr = createdateStr;
	}
}
