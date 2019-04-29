package com.tengdi.environmentalprotectionint.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 反馈记录
 * 
 * @author tengdi
 * @email 
 * @date 2018-11-13 10:15:09
 */
@TableName("sys_feedback_record")
public class SysFeedbackRecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String pid;
	/**
	 * 反馈主表（外键id）
	 */
	private String oid;
	/**
	 * 登录用户
	 */
	private String companyName;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * 反馈内容
	 */
	private String feedbackContent;
	/**
	 * 反馈时间
	 */
	private String feedbackDate;
	/**
	 * 回复内容
	 */
	private String replyContent;
	/**
	 * 回复时间
	 */
	private String replyDate;
	/**
	 * 回复状态（0：未回复；1：已回复）
	 */
	private String replyStatus;
	/**
	 * 创建时间
	 */
	private String createDate;
	/**
	 * 修改时间
	 */
	private String updateDate;
	/**
	 * 删除时间
	 */
	private String deleteDate;
	/**
	 * 备用
	 */
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
	 * 设置：反馈主表（外键id）
	 */
	public void setOid(String oid) {
		this.oid = oid;
	}
	/**
	 * 获取：反馈主表（外键id）
	 */
	public String getOid() {
		return oid;
	}
	/**
	 * 设置：反馈内容
	 */
	public void setFeedbackContent(String feedbackContent) {
		this.feedbackContent = feedbackContent;
	}
	/**
	 * 获取：反馈内容
	 */
	public String getFeedbackContent() {
		return feedbackContent;
	}
	/**
	 * 设置：反馈时间
	 */
	public void setFeedbackDate(String feedbackDate) {
		this.feedbackDate = feedbackDate;
	}
	/**
	 * 获取：反馈时间
	 */
	public String getFeedbackDate() {
		return feedbackDate;
	}
	/**
	 * 设置：回复内容
	 */
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	/**
	 * 获取：回复内容
	 */
	public String getReplyContent() {
		return replyContent;
	}
	/**
	 * 设置：回复时间
	 */
	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}
	/**
	 * 获取：回复时间
	 */
	public String getReplyDate() {
		return replyDate;
	}
	/**
	 * 设置：回复状态（0：未回复；1：已回复）
	 */
	public void setReplyStatus(String replyStatus) {
		this.replyStatus = replyStatus;
	}
	/**
	 * 获取：回复状态（0：未回复；1：已回复）
	 */
	public String getReplyStatus() {
		return replyStatus;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：创建时间
	 */
	public String getCreateDate() {
		return createDate;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	/**
	 * 获取：修改时间
	 */
	public String getUpdateDate() {
		return updateDate;
	}
	/**
	 * 设置：删除时间
	 */
	public void setDeleteDate(String deleteDate) {
		this.deleteDate = deleteDate;
	}
	/**
	 * 获取：删除时间
	 */
	public String getDeleteDate() {
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
