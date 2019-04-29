package com.tengdi.environmentalprotectionint.modules.cominfo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 污染源（企业）附件
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-24 15:29:14
 */
@TableName("cominfo_baseinfo_attachment")
public class CominfoBaseinfoAttachmentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID（UUID）
	 */
	@TableId
	private String pid;

	/**
	 * 对应的企业(污染源)ID
	 */
	private String cid;

	/**
	 * 附件名称
	 */
	private String fileName;
	/**
	 * 附件类型
	 */
	private Integer fileType;
	/**
	 * 附件类型value
	 */
	@TableField(exist = false)
	private String fileTypeValue;

	public String getFileTypeValue() {
		return fileTypeValue;
	}

	public void setFileTypeValue(String fileTypeValue) {
		this.fileTypeValue = fileTypeValue;
	}

	/**
	 * 附件大小
	 */
	private String attachmentSize;
	/**
	 * 附件格式
	 */
	private String attachmentFormat;
	/**
	 * 上传者
	 */
	private String uploadPerson;
	/**
	 * 上传时间
	 */
	private String uploadTime;
	/**
	 * 上传时间截取年月日
	 */
	@TableField(exist = false)
	private String uploadDate;
	/**
	 * 附件地址
	 */
	private String attachmentUrl;
	/**
	 * 创建时间
	 */
	private Date createdate;

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

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
	 * 设置：附件名称
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * 获取：附件名称
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * 设置：附件类型
	 */
	public void setFileType(Integer fileType) {
		this.fileType = fileType;
	}
	/**
	 * 获取：附件类型
	 */
	public Integer getFileType() {
		return fileType;
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
	 * 设置：上传者
	 */
	public void setUploadPerson(String uploadPerson) {
		this.uploadPerson = uploadPerson;
	}
	/**
	 * 获取：上传者
	 */
	public String getUploadPerson() {
		return uploadPerson;
	}
	/**
	 * 设置：上传时间
	 */
	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}
	/**
	 * 获取：上传时间
	 */
	public String getUploadTime() {
		return uploadTime;
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

	public String getUploadDate() {
		return uploadTime.substring(0,uploadTime.indexOf(" "));
	}

	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}
}
