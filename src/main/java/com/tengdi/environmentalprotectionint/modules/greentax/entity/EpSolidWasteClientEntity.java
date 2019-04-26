package com.tengdi.environmentalprotectionint.modules.greentax.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Date;
/**
 * 固体废物基础信息采集-
 * 
 * @author tengdi
 * @email 
 * @date 2019-03-06 10:20:06
 */
@TableName("ep_solid_waste_client")
public class EpSolidWasteClientEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 主表ID
	 */
	private String mainId;
	/**
	 * 委托方式 接受/委托
	 */
	private String clientType;
	/**
	 * 委托方名称
	 */
	private String clientName;
	/**
	 * 客户统一社会信用代码
	 */
	private String clientSocialCreditCode;
	/**
	 * 固体废物名或编码
	 */
	private String clientWaste;
	/**
	 * 处理方式
	 */
	private String handleMode;
	/**
	 * 资质说明
	 */
	private String qualification;
	/**
	 * 客户联系人或电话
	 */
	private String clientLinkman;
	/**
	 * 合同截止时间
	 */
	private Date clientContractDeadline;

	/**
	 * 设置：
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：主表ID
	 */
	public void setMainId(String mainId) {
		this.mainId = mainId;
	}
	/**
	 * 获取：主表ID
	 */
	public String getMainId() {
		return mainId;
	}
	/**
	 * 设置：委托方式 接受/委托
	 */
	public void setClientType(String clientType) {
		this.clientType = clientType;
	}
	/**
	 * 获取：委托方式 接受/委托
	 */
	public String getClientType() {
		return clientType;
	}
	/**
	 * 设置：委托方名称
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	/**
	 * 获取：委托方名称
	 */
	public String getClientName() {
		return clientName;
	}
	/**
	 * 设置：客户统一社会信用代码
	 */
	public void setClientSocialCreditCode(String clientSocialCreditCode) {
		this.clientSocialCreditCode = clientSocialCreditCode;
	}
	/**
	 * 获取：客户统一社会信用代码
	 */
	public String getClientSocialCreditCode() {
		return clientSocialCreditCode;
	}
	/**
	 * 设置：固体废物名或编码
	 */
	public void setClientWaste(String clientWaste) {
		this.clientWaste = clientWaste;
	}
	/**
	 * 获取：固体废物名或编码
	 */
	public String getClientWaste() {
		return clientWaste;
	}
	/**
	 * 设置：处理方式
	 */
	public void setHandleMode(String handleMode) {
		this.handleMode = handleMode;
	}
	/**
	 * 获取：处理方式
	 */
	public String getHandleMode() {
		return handleMode;
	}
	/**
	 * 设置：资质说明
	 */
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	/**
	 * 获取：资质说明
	 */
	public String getQualification() {
		return qualification;
	}
	/**
	 * 设置：客户联系人或电话
	 */
	public void setClientLinkman(String clientLinkman) {
		this.clientLinkman = clientLinkman;
	}
	/**
	 * 获取：客户联系人或电话
	 */
	public String getClientLinkman() {
		return clientLinkman;
	}
	/**
	 * 设置：合同截止时间
	 */
	public void setClientContractDeadline(Date clientContractDeadline) {
		this.clientContractDeadline = clientContractDeadline;
	}
	/**
	 * 获取：合同截止时间
	 */
	public Date getClientContractDeadline() {
		return clientContractDeadline;
	}
}
