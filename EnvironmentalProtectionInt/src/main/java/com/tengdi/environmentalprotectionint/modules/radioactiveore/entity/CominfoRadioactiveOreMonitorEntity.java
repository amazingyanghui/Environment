package com.tengdi.environmentalprotectionint.modules.radioactiveore.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 放射性检测表（包含【废水】放射性检测、和【固体物料及废物】放射性检测）
 * 
 * @author tengdi
 * @email 
 * @date 2019-03-12 17:25:58
 */
@TableName("cominfo_radioactive_ore_monitor")
public class CominfoRadioactiveOreMonitorEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键（UUID）
	 */
	@TableId
	private String pid;
	/**
	 * 企业ID
	 */
	private String cid;
	/**
	 * 年度
	 */
	private String year;
	/**
	 * 类型（0：废水；1：固体物料及废物）
	 */
	private String category;
	/**
	 * 检测类型（0：取样的总排口；1：取样的治理设施；2：含放射性固体物料；3：含放射性固体废物；）
	 */
	private String monitorType;
	/**
	 * 取样的名称
	 */
	private String monitorName;
	/**
	 * 取样的编号
	 */
	private String monitorCode;
	/**
	 * 经度
	 */
	private String longitude;
	/**
	 * 纬度
	 */
	private String latitude;
	/**
	 * 取样时间
	 */
	private String samplingDate;
	/**
	 * 备注
	 */
	private String remarks;
	/**
	 * 创建时间
	 */
	private String createdate;
	/**
	 * 修改时间
	 */
	private String updatedate;
	/**
	 * 删除时间
	 */
	private String deletedate;

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
	 * 设置：企业ID
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}
	/**
	 * 获取：企业ID
	 */
	public String getCid() {
		return cid;
	}
	/**
	 * 设置：年度
	 */
	public void setYear(String year) {
		this.year = year;
	}
	/**
	 * 获取：年度
	 */
	public String getYear() {
		return year;
	}
	/**
	 * 设置：类型（0：废水；1：固体物料及废物）
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * 获取：类型（0：废水；1：固体物料及废物）
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * 设置：检测类型（0：取样的总排口；1：取样的治理设施；2：含放射性固体物料；3：含放射性固体废物；）
	 */
	public void setMonitorType(String monitorType) {
		this.monitorType = monitorType;
	}
	/**
	 * 获取：检测类型（0：取样的总排口；1：取样的治理设施；2：含放射性固体物料；3：含放射性固体废物；）
	 */
	public String getMonitorType() {
		return monitorType;
	}
	/**
	 * 设置：取样的名称
	 */
	public void setMonitorName(String monitorName) {
		this.monitorName = monitorName;
	}
	/**
	 * 获取：取样的名称
	 */
	public String getMonitorName() {
		return monitorName;
	}
	/**
	 * 设置：取样的编号
	 */
	public void setMonitorCode(String monitorCode) {
		this.monitorCode = monitorCode;
	}
	/**
	 * 获取：取样的编号
	 */
	public String getMonitorCode() {
		return monitorCode;
	}
	/**
	 * 设置：经度
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	/**
	 * 获取：经度
	 */
	public String getLongitude() {
		return longitude;
	}
	/**
	 * 设置：纬度
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	/**
	 * 获取：纬度
	 */
	public String getLatitude() {
		return latitude;
	}
	/**
	 * 设置：取样时间
	 */
	public void setSamplingDate(String samplingDate) {
		this.samplingDate = samplingDate;
	}
	/**
	 * 获取：取样时间
	 */
	public String getSamplingDate() {
		return samplingDate;
	}
	/**
	 * 设置：备注
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * 获取：备注
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	/**
	 * 获取：创建时间
	 */
	public String getCreatedate() {
		return createdate;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	/**
	 * 获取：修改时间
	 */
	public String getUpdatedate() {
		return updatedate;
	}
	/**
	 * 设置：删除时间
	 */
	public void setDeletedate(String deletedate) {
		this.deletedate = deletedate;
	}
	/**
	 * 获取：删除时间
	 */
	public String getDeletedate() {
		return deletedate;
	}
}
