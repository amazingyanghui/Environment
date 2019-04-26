package com.tengdi.environmentalprotectionint.modules.emergency.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;

import java.io.Serializable;
import java.util.Date;

/**
 * 专家信息
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-23 15:13:57
 */
@TableName("emergency_system_expert")
public class EmergencySystemExpertEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键UUID
	 */
	@TableId
	private String pid;
	/**
	 * 对应的污染源（企业）ID
	 */
	private String cid;
	@TableField(exist = false)
	private String companyName;

	/**
	 * 姓名
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String expertName;
	/**
	 * 性别
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer sex;

	@TableField(exist = false)
	private String sexName;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getSexName() {
		return sexName;
	}

	public void setSexName(String sexName) {
		this.sexName = sexName;
	}

	/**
	 * 出生日期
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String birthday;
	/**
	 * 籍贯
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String nativePlace;
	/**
	 * 联系电话
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String linkphone;
	/**
	 * 擅长领域
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String field;
	/**
	 * 工作单位（企业）
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String company;
	/**
	 * 聘任开始时间
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String appointmentStarttime;
	/**
	 * 聘任结束时间
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String appointmentEndtime;
	/**
	 * 创建时间
	 */
	private Date createdate;

	/**
	 * 设置：主键UUID
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}
	/**
	 * 获取：主键UUID
	 */
	public String getPid() {
		return pid;
	}
	/**
	 * 设置：对应的污染源（企业）ID
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}
	/**
	 * 获取：对应的污染源（企业）ID
	 */
	public String getCid() {
		return cid;
	}
	/**
	 * 设置：姓名
	 */
	public void setExpertName(String expertName) {
		this.expertName = expertName;
	}
	/**
	 * 获取：姓名
	 */
	public String getExpertName() {
		return expertName;
	}
	/**
	 * 设置：性别
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * 获取：性别
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * 设置：出生日期
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	/**
	 * 获取：出生日期
	 */
	public String getBirthday() {
		return birthday;
	}
	/**
	 * 设置：籍贯
	 */
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	/**
	 * 获取：籍贯
	 */
	public String getNativePlace() {
		return nativePlace;
	}
	/**
	 * 设置：联系电话
	 */
	public void setLinkphone(String linkphone) {
		this.linkphone = linkphone;
	}
	/**
	 * 获取：联系电话
	 */
	public String getLinkphone() {
		return linkphone;
	}
	/**
	 * 设置：擅长领域
	 */
	public void setField(String field) {
		this.field = field;
	}
	/**
	 * 获取：擅长领域
	 */
	public String getField() {
		return field;
	}
	/**
	 * 设置：工作单位（企业）
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	/**
	 * 获取：工作单位（企业）
	 */
	public String getCompany() {
		return company;
	}
	/**
	 * 设置：聘任开始时间
	 */
	public void setAppointmentStarttime(String appointmentStarttime) {
		this.appointmentStarttime = appointmentStarttime;
	}
	/**
	 * 获取：聘任开始时间
	 */
	public String getAppointmentStarttime() {
		return appointmentStarttime;
	}
	/**
	 * 设置：聘任结束时间
	 */
	public void setAppointmentEndtime(String appointmentEndtime) {
		this.appointmentEndtime = appointmentEndtime;
	}
	/**
	 * 获取：聘任结束时间
	 */
	public String getAppointmentEndtime() {
		return appointmentEndtime;
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
