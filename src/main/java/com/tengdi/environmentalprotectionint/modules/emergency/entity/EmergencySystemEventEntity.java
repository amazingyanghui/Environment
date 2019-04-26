package com.tengdi.environmentalprotectionint.modules.emergency.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;

import java.io.Serializable;
import java.util.Date;

/**
 * 环境应急事件
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-23 15:15:20
 */
@TableName("emergency_system_event")
public class EmergencySystemEventEntity implements Serializable {
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
	/**
	 * 事件标题
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String eventTitle;
	/**
	 * 发生日期
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String occurrenceDate;
	/**
	 * 发生地点
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String occurrencePoint;
	/**
	 * 事件简述
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String eventSketch;
	/**
	 * 事件等级
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer eventLevel;
	/**
	 * 事件等级name
	 */
	@TableField(exist = false)
	private String eventLevelName;

	public String getEventLevelName() {
		return eventLevelName;
	}

	public void setEventLevelName(String eventLevelName) {
		this.eventLevelName = eventLevelName;
	}

	/**
	 * 财产损失（万元）
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Double propertyLoss;
	/**
	 * 转移群众
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String transferMasses;
	/**
	 * 企业名称
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String companyName;
	/**
	 * 创建时间
	 */
	private Date createdate;
	/**
	 * 处置状态
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String disposalstatus;
	/**
	 * 处置状态name
	 */
	@TableField(exist = false)
	private String disposalStatusName;

	public String getDisposalStatusName() {
		return disposalStatusName;
	}

	public void setDisposalStatusName(String disposalStatusName) {
		this.disposalStatusName = disposalStatusName;
	}

	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String pollutionrange ;
	/**
	 * 污染程度
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private	String pollutionlevel ;
	/**
	 * 污染程度name
	 */
	@TableField(exist = false)
	private String pollutionLevelName;

	public String getPollutionLevelName() {
		return pollutionLevelName;
	}

	public void setPollutionLevelName(String pollutionLevelName) {
		this.pollutionLevelName = pollutionLevelName;
	}

	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String pollutant ;

	@TableField(fill = FieldFill.INSERT_UPDATE)
	private	String casualties ;

	/**
	 * 设置：主键UUID
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPollutionrange() {
		return pollutionrange;
	}

	public void setPollutionrange(String pollutionrange) {
		this.pollutionrange = pollutionrange;
	}

	public String getPollutionlevel() {
		return pollutionlevel;
	}

	public void setPollutionlevel(String pollutionlevel) {
		this.pollutionlevel = pollutionlevel;
	}

	public String getPollutant() {
		return pollutant;
	}

	public void setPollutant(String pollutant) {
		this.pollutant = pollutant;
	}

	public String getCasualties() {
		return casualties;
	}

	public void setCasualties(String casualties) {
		this.casualties = casualties;
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
	 * 设置：事件标题
	 */
	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}
	/**
	 * 获取：事件标题
	 */
	public String getEventTitle() {
		return eventTitle;
	}
	/**
	 * 设置：发生日期
	 */
	public void setOccurrenceDate(String occurrenceDate) {
		this.occurrenceDate = occurrenceDate;
	}
	/**
	 * 获取：发生日期
	 */
	public String getOccurrenceDate() {
		return occurrenceDate;
	}
	/**
	 * 设置：发生地点
	 */
	public void setOccurrencePoint(String occurrencePoint) {
		this.occurrencePoint = occurrencePoint;
	}
	/**
	 * 获取：发生地点
	 */
	public String getOccurrencePoint() {
		return occurrencePoint;
	}
	/**
	 * 设置：事件简述
	 */
	public void setEventSketch(String eventSketch) {
		this.eventSketch = eventSketch;
	}
	/**
	 * 获取：事件简述
	 */
	public String getEventSketch() {
		return eventSketch;
	}
	/**
	 * 设置：事件等级
	 */
	public void setEventLevel(Integer eventLevel) {
		this.eventLevel = eventLevel;
	}
	/**
	 * 获取：事件等级
	 */
	public Integer getEventLevel() {
		return eventLevel;
	}
	/**
	 * 设置：财产损失（万元）
	 */
	public void setPropertyLoss(Double propertyLoss) {
		this.propertyLoss = propertyLoss;
	}
	/**
	 * 获取：财产损失（万元）
	 */
	public Double getPropertyLoss() {
		return propertyLoss;
	}
	/**
	 * 设置：转移群众
	 */
	public void setTransferMasses(String transferMasses) {
		this.transferMasses = transferMasses;
	}
	/**
	 * 获取：转移群众
	 */
	public String getTransferMasses() {
		return transferMasses;
	}
	/**
	 * 设置：企业名称
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * 获取：企业名称
	 */
	public String getCompanyName() {
		return companyName;
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

	public String getDisposalstatus() {
		return disposalstatus;
	}

	public void setDisposalstatus(String disposalstatus) {
		this.disposalstatus = disposalstatus;
	}
}
