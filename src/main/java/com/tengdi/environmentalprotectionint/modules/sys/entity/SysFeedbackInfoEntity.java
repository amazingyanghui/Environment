package com.tengdi.environmentalprotectionint.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.List;

/**
 * 反馈主表
 * 
 * @author tengdi
 * @email 
 * @date 2018-11-13 10:15:02
 */
@TableName("sys_feedback_info")
public class SysFeedbackInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableField(exist = false)
	public List<SysFeedbackRecordEntity> sysFeedbackRecordList;

	public List<SysFeedbackRecordEntity> getSysFeedbackRecordList() {
		return sysFeedbackRecordList;
	}

	public void setSysFeedbackRecordList(List<SysFeedbackRecordEntity> sysFeedbackRecordList) {
		this.sysFeedbackRecordList = sysFeedbackRecordList;
	}

	/**
	 * 
	 */
	@TableId
	private String pid;
	/**
	 * 登录用户（存入公司账号）
	 */
	private String loginUser;
	/**
	 * 登录用户（公司名）
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
	 * 姓名
	 */
	private String userName;
	/**
	 * 电话
	 */
	private String userPhone;
	/**
	 * 邮箱
	 */
	private String userMail;
	/**
	 * 问题类型:（0：问题咨询，1：意见建议，2：投诉）
	 */
	private String questionType;
	/**
	 * 问题类型name
	 */
	@TableField(exist = false)
	private String questionTypeName;

	/**
	 * 反馈类型（0：用户反馈:1：系统反馈）
	 */
	private String feedbackType;
	/**
	 * 反馈类型name
	 */
	@TableField(exist = false)
	private String feedbackTypeName;
	/**
	 * 响应状态（0：未回复；1：已回复）
	 */
	private String replyStatus;
	/**
	 * 响应状态name
	 */
	@TableField(exist = false)
	private String replyStatusName;

	public String getQuestionTypeName() {
		return questionTypeName;
	}

	public void setQuestionTypeName(String questionTypeName) {
		this.questionTypeName = questionTypeName;
	}

	public String getFeedbackTypeName() {
		return feedbackTypeName;
	}

	public void setFeedbackTypeName(String feedbackTypeName) {
		this.feedbackTypeName = feedbackTypeName;
	}

	public String getReplyStatusName() {
		return replyStatusName;
	}

	public void setReplyStatusName(String replyStatusName) {
		this.replyStatusName = replyStatusName;
	}

	/**
	 * 反馈内容
	 */
	@TableField(exist = false)
	private String feedbackContent;

	public String getFeedbackContent() {
		return feedbackContent;
	}

	public void setFeedbackContent(String feedbackContent) {
		this.feedbackContent = feedbackContent;
	}

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
	 * 设置：登录用户（存入公司账号）
	 */
	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}
	/**
	 * 获取：登录用户（存入公司账号）
	 */
	public String getLoginUser() {
		return loginUser;
	}
	/**
	 * 设置：姓名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：姓名
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：电话
	 */
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	/**
	 * 获取：电话
	 */
	public String getUserPhone() {
		return userPhone;
	}
	/**
	 * 设置：邮箱
	 */
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	/**
	 * 获取：邮箱
	 */
	public String getUserMail() {
		return userMail;
	}
	/**
	 * 设置：问题类型:（0：问题咨询，1：意见建议，2：投诉）
	 */
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	/**
	 * 获取：问题类型:（0：问题咨询，1：意见建议，2：投诉）
	 */
	public String getQuestionType() {
		return questionType;
	}
	/**
	 * 设置：反馈类型（0：用户反馈:1：系统反馈）
	 */
	public void setFeedbackType(String feedbackType) {
		this.feedbackType = feedbackType;
	}
	/**
	 * 获取：反馈类型（0：用户反馈:1：系统反馈）
	 */
	public String getFeedbackType() {
		return feedbackType;
	}
	/**
	 * 设置：响应状态（0：未回复；1：已回复）
	 */
	public void setReplyStatus(String replyStatus) {
		this.replyStatus = replyStatus;
	}
	/**
	 * 获取：响应状态（0：未回复；1：已回复）
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
