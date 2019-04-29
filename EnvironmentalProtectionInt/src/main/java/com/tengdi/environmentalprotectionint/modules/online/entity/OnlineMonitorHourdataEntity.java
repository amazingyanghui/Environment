package com.tengdi.environmentalprotectionint.modules.online.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 小时数据表
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-21 14:51:50
 */
@TableName("online_monitor_hourdata")
public class OnlineMonitorHourdataEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键（UUID）
	 */
	@TableId
	private String pid;
	/**
	 * 数据时间
	 */
	private String createdate;
	/**
	 * 历史数据ID
	 */
	private String historyId;
	/**
	 * 企业ID
	 */
	private String cid;
	/**
	 * 监控点ID
	 */
	private String mid;
	/**
	 * 因子ID
	 */
	private String fid;
	/**
	 * 检测数据
	 */
	private Double testData;
	/**
	 * avg：日平均值；cou：日排放量；max：日最大值；min：日最小值；zsavg：日平均折算浓度；zscou：日折算排放量；zsmax：日折算最大值；
	 */
	private String dataType;
	/**
	 * 日平均值
	 */
	private String avgValue;
	/**
	 * 日排放量
	 */
	private String couValue;
	/**
	 * 日最大值
	 */
	private String maxValue;
	/**
	 * 日最小值
	 */
	private String minValue;
	/**
	 * 日平均折算浓度
	 */
	private String zsavgValue;
	/**
	 * 日折算排放量
	 */
	private String zscouValue;
	/**
	 * 日折算最大值
	 */
	private String zsmaxValue;

	public String getAvgValue() {
		return avgValue;
	}

	public void setAvgValue(String avgValue) {
		this.avgValue = avgValue;
	}

	public String getCouValue() {
		return couValue;
	}

	public void setCouValue(String couValue) {
		this.couValue = couValue;
	}

	public String getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(String maxValue) {
		this.maxValue = maxValue;
	}

	public String getMinValue() {
		return minValue;
	}

	public void setMinValue(String minValue) {
		this.minValue = minValue;
	}

	public String getZsavgValue() {
		return zsavgValue;
	}

	public void setZsavgValue(String zsavgValue) {
		this.zsavgValue = zsavgValue;
	}

	public String getZscouValue() {
		return zscouValue;
	}

	public void setZscouValue(String zscouValue) {
		this.zscouValue = zscouValue;
	}

	public String getZsmaxValue() {
		return zsmaxValue;
	}

	public void setZsmaxValue(String zsmaxValue) {
		this.zsmaxValue = zsmaxValue;
	}

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
	 * 设置：数据时间
	 */
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	/**
	 * 获取：数据时间
	 */
	public String getCreatedate() {
		return createdate;
	}
	/**
	 * 设置：历史数据ID
	 */
	public void setHistoryId(String historyId) {
		this.historyId = historyId;
	}
	/**
	 * 获取：历史数据ID
	 */
	public String getHistoryId() {
		return historyId;
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
	 * 设置：监控点ID
	 */
	public void setMid(String mid) {
		this.mid = mid;
	}
	/**
	 * 获取：监控点ID
	 */
	public String getMid() {
		return mid;
	}
	/**
	 * 设置：因子ID
	 */
	public void setFid(String fid) {
		this.fid = fid;
	}
	/**
	 * 获取：因子ID
	 */
	public String getFid() {
		return fid;
	}
	/**
	 * 设置：检测数据
	 */
	public void setTestData(Double testData) {
		this.testData = testData;
	}
	/**
	 * 获取：检测数据
	 */
	public Double getTestData() {
		return testData;
	}
	/**
	 * 设置：avg：日平均值；cou：日排放量；max：日最大值；min：日最小值；zsavg：日平均折算浓度；zscou：日折算排放量；zsmax：日折算最大值；
	 */
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	/**
	 * 获取：avg：日平均值；cou：日排放量；max：日最大值；min：日最小值；zsavg：日平均折算浓度；zscou：日折算排放量；zsmax：日折算最大值；
	 */
	public String getDataType() {
		return dataType;
	}
}
