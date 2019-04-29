package com.tengdi.environmentalprotectionint.modules.emergency.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.tengdi.core.utils.DateUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * 应急预案文档
 * 
 * @author tengdi
 * @email 
 * @date 2018-11-19 19:30:17
 */
@TableName("emergency_system_plan_file")
public class EmergencySystemPlanFileEntity implements Serializable {
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
	 * 应急预案id
	 */
	private String aid;
	/**
	 * 文件名称
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String fileName;
	/**
	 * 附件大小
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String attachmentSize;
	/**
	 * 附件格式
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String attachmentFormat;
	/**
	 * 附件地址
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String attachmentUrl;
	/**
	 * 上传者
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String uploadPerson;
	/**
	 * 上传时间
	 */
	private String uploadTime;
	/**
	 * 创建时间
	 */
	private Date createdate;
	/**
	 * 创建时间，转换String接受
	 */
	@TableField(exist = false)
	private String createdateStr;
	public String getCreatedateStr() {
		return  DateUtils.format(createdate);
	}

	public void setCreatedateStr(String createdateStr) {
		this.createdateStr = createdateStr;
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
	 * 设置：对应的企业(污染源)ID
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}
	/**
	 * 获取：对应的企业(污染源)ID
	 */
	public String getCid() {
		return cid;
	}
	/**
	 * 设置：应急预案id
	 */
	public void setAid(String aid) {
		this.aid = aid;
	}
	/**
	 * 获取：应急预案id
	 */
	public String getAid() {
		return aid;
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
