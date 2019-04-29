package com.tengdi.environmentalprotectionint.modules.petition.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;

import java.io.Serializable;

/**
 * 信访投诉
 * 
 * @author tengdi
 * @email 
 * @date 2018-11-20 09:53:05
 */
@TableName("petition_system_complain")
public class PetitionSystemComplainEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * pid
	 */
	@TableId
	private String pid;
	/**
	 * cid
	 */
	private String cid;
	/**
	 * 公司名称
	 */
	@TableField(exist = false)
	private String companyName;
	@TableField(exist = false)
	private String companyAddress;

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	/**
	 * 举报主题
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String informTitle;
	/**
	 * 举报人
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String informPerson;
	/**
	 * 举报方式
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer informType;
	/**
	 * 举报方式name
	 */
	@TableField(exist = false)
	private String informTypeName;
	/**
	 * 举报日期
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String informDate;
	/**
	 * 联系电话
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String linkPhone;
	/**
	 * 电子邮箱
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String linkEmail;
	/**
	 * 信访人数
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer letterPersonNum;
	/**
	 * 被举报单位
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String informedCompany;
	/**
	 * 单位地址
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String informedAddress;
	/**
	 * 举报内容
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String informContent;
	/**
	 * 处理单位
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String handleCompany;
	/**
	 * 网上回复结果
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String replyContent;
	/**
	 * 举报内容是否属实
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer informIsTrue;
	/**
	 * 举报内容是否属实name
	 */
	@TableField(exist = false)
	private String informIsTrueName;
	/**
	 * 反馈违法情况
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String replyLawContent;
	/**
	 * 是否反馈
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer isReply;
	/**
	 * 是否反馈name
	 */
	@TableField(exist = false)
	private String isReplyName;
	/**
	 * 立案查处否
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer isPenalize;
	/**
	 * 立案查处否name
	 */
	@TableField(exist = false)
	private String isPenalizeName;
	/**
	 * 反馈方式
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer replyType;
	/**
	 * 反馈方式name
	 */
	@TableField(exist = false)
	private String replyTypeName;
	/**
	 * 举报人意见
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String informOpinion;
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
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String backup;

	/**
	 * 设置：pid
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}
	/**
	 * 获取：pid
	 */
	public String getPid() {
		return pid;
	}
	/**
	 * 设置：cid
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}
	/**
	 * 获取：cid
	 */
	public String getCid() {
		return cid;
	}
	/**
	 * 设置：举报主题
	 */
	public void setInformTitle(String informTitle) {
		this.informTitle = informTitle;
	}
	/**
	 * 获取：举报主题
	 */
	public String getInformTitle() {
		return informTitle;
	}
	/**
	 * 设置：举报人
	 */
	public void setInformPerson(String informPerson) {
		this.informPerson = informPerson;
	}
	/**
	 * 获取：举报人
	 */
	public String getInformPerson() {
		return informPerson;
	}
	/**
	 * 设置：举报方式
	 */
	public void setInformType(Integer informType) {
		this.informType = informType;
	}
	/**
	 * 获取：举报方式
	 */
	public Integer getInformType() {
		return informType;
	}
	/**
	 * 设置：举报日期
	 */
	public void setInformDate(String informDate) {
		this.informDate = informDate;
	}
	/**
	 * 获取：举报日期
	 */
	public String getInformDate() {
		return informDate;
	}
	/**
	 * 设置：联系电话
	 */
	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}
	/**
	 * 获取：联系电话
	 */
	public String getLinkPhone() {
		return linkPhone;
	}
	/**
	 * 设置：电子邮箱
	 */
	public void setLinkEmail(String linkEmail) {
		this.linkEmail = linkEmail;
	}
	/**
	 * 获取：电子邮箱
	 */
	public String getLinkEmail() {
		return linkEmail;
	}
	/**
	 * 设置：信访人数
	 */
	public void setLetterPersonNum(Integer letterPersonNum) {
		this.letterPersonNum = letterPersonNum;
	}
	/**
	 * 获取：信访人数
	 */
	public Integer getLetterPersonNum() {
		return letterPersonNum;
	}
	/**
	 * 设置：被举报单位
	 */
	public void setInformedCompany(String informedCompany) {
		this.informedCompany = informedCompany;
	}
	/**
	 * 获取：被举报单位
	 */
	public String getInformedCompany() {
		return informedCompany;
	}
	/**
	 * 设置：单位地址
	 */
	public void setInformedAddress(String informedAddress) {
		this.informedAddress = informedAddress;
	}
	/**
	 * 获取：单位地址
	 */
	public String getInformedAddress() {
		return informedAddress;
	}
	/**
	 * 设置：举报内容
	 */
	public void setInformContent(String informContent) {
		this.informContent = informContent;
	}
	/**
	 * 获取：举报内容
	 */
	public String getInformContent() {
		return informContent;
	}
	/**
	 * 设置：处理单位
	 */
	public void setHandleCompany(String handleCompany) {
		this.handleCompany = handleCompany;
	}
	/**
	 * 获取：处理单位
	 */
	public String getHandleCompany() {
		return handleCompany;
	}
	/**
	 * 设置：网上回复结果
	 */
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	/**
	 * 获取：网上回复结果
	 */
	public String getReplyContent() {
		return replyContent;
	}
	/**
	 * 设置：举报内容是否属实
	 */
	public void setInformIsTrue(Integer informIsTrue) {
		this.informIsTrue = informIsTrue;
	}
	/**
	 * 获取：举报内容是否属实
	 */
	public Integer getInformIsTrue() {
		return informIsTrue;
	}
	/**
	 * 设置：反馈违法情况
	 */
	public void setReplyLawContent(String replyLawContent) {
		this.replyLawContent = replyLawContent;
	}
	/**
	 * 获取：反馈违法情况
	 */
	public String getReplyLawContent() {
		return replyLawContent;
	}
	/**
	 * 设置：是否反馈
	 */
	public void setIsReply(Integer isReply) {
		this.isReply = isReply;
	}
	/**
	 * 获取：是否反馈
	 */
	public Integer getIsReply() {
		return isReply;
	}
	/**
	 * 设置：立案查处否
	 */
	public void setIsPenalize(Integer isPenalize) {
		this.isPenalize = isPenalize;
	}
	/**
	 * 获取：立案查处否
	 */
	public Integer getIsPenalize() {
		return isPenalize;
	}
	/**
	 * 设置：反馈方式
	 */
	public void setReplyType(Integer replyType) {
		this.replyType = replyType;
	}
	/**
	 * 获取：反馈方式
	 */
	public Integer getReplyType() {
		return replyType;
	}
	/**
	 * 设置：举报人意见
	 */
	public void setInformOpinion(String informOpinion) {
		this.informOpinion = informOpinion;
	}
	/**
	 * 获取：举报人意见
	 */
	public String getInformOpinion() {
		return informOpinion;
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getInformTypeName() {
		return informTypeName;
	}

	public void setInformTypeName(String informTypeName) {
		this.informTypeName = informTypeName;
	}

	public String getInformIsTrueName() {
		return informIsTrueName;
	}

	public void setInformIsTrueName(String informIsTrueName) {
		this.informIsTrueName = informIsTrueName;
	}

	public String getIsReplyName() {
		return isReplyName;
	}

	public void setIsReplyName(String isReplyName) {
		this.isReplyName = isReplyName;
	}

	public String getIsPenalizeName() {
		return isPenalizeName;
	}

	public void setIsPenalizeName(String isPenalizeName) {
		this.isPenalizeName = isPenalizeName;
	}

	public String getReplyTypeName() {
		return replyTypeName;
	}

	public void setReplyTypeName(String replyTypeName) {
		this.replyTypeName = replyTypeName;
	}
}
