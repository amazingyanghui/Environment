package com.tengdi.environmentalprotectionint.modules.online.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 监控点监控因子信息表
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-21 14:52:16
 */
@TableName("online_monitor_point_factor")
public class OnlineMonitorPointFactorEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 监控点因子ID(主键UUID)
	 */
	@TableId
	private String pid;
	/**
	 * 监控点ID
	 */
	private String mid;
	/**
	 * 因子ID
	 */
	private String fid;
	/**
	 * 使用否(0：否；1：是)
	 */
	private Integer useflag;
	/**
	 * 使用否名称
	 */
	@TableField(exist = false)
	private String useFlagName;

	public String getUseFlagName() {
		return useFlagName;
	}

	public void setUseFlagName(String useFlagName) {
		this.useFlagName = useFlagName;
	}

	/**
	 * 检测单位
	 */
	private String testCompany;
	/**
	 * 最大检测值
	 */
	private Double maximumValue;
	/**
	 * 最小检测值
	 */
	private Double minimumValue;
	/**
	 * 因子名称
	 */
	@TableField(exist = false)
	private String factorName;
	/**
	 * 因子类型
	 */
	@TableField(exist = false)
	private Integer factorType;

	public Integer getFactorType() {
		return factorType;
	}

	public void setFactorType(Integer factorType) {
		this.factorType = factorType;
	}

	/**
	 * 排口名称（监控点）
	 */
	@TableField(exist = false)
	private String monitorName ;
	/**
	 * 排口对应表名（监测点）
	 */
	@TableField(exist = false)
	private String	tableName ;

	/**
	 * 排口类型
	 * @return
	 */
	@TableField(exist = false)
	private String	monitorType ;

	/**
	 * 排口类型数量
	 * @return
	 */
	@TableField(exist = false)
	private String	drainsCount ;

	/**
	 * 月份
	 * @return
	 */
	@TableField(exist = false)
	private String month ;
	/**
	 * 月份排放量
	 * @return
	 */
	@TableField(exist = false)
	private String monthVauleCount ;

    /**
     * 年份
     * @return
     */
    @TableField(exist = false)
    private String year ;
    /**
     * 年份统计总量
     * @return
     */
    @TableField(exist = false)
    private String yearVauleCount ;

	/**
	 * 每月浓度排放量
	 * @return
	 */
	@TableField(exist = false)
	private String potencyCount ;


	public String getFactorName() {
		return factorName;
	}

	public void setFactorName(String factorName) {
		this.factorName = factorName;
	}

	/**
	 * 设置：监控点因子ID(主键UUID)
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}
	/**
	 * 获取：监控点因子ID(主键UUID)
	 */
	public String getPid() {
		return pid;
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
	 * 设置：使用否(0：否；1：是)
	 */
	public void setUseflag(Integer useflag) {
		this.useflag = useflag;
	}
	/**
	 * 获取：使用否(0：否；1：是)
	 */
	public Integer getUseflag() {
		return useflag;
	}
	/**
	 * 设置：检测单位
	 */
	public void setTestCompany(String testCompany) {
		this.testCompany = testCompany;
	}
	/**
	 * 获取：检测单位
	 */
	public String getTestCompany() {
		return testCompany;
	}
	/**
	 * 设置：最大检测值
	 */
	public void setMaximumValue(Double maximumValue) {
		this.maximumValue = maximumValue;
	}
	/**
	 * 获取：最大检测值
	 */
	public Double getMaximumValue() {
		return maximumValue;
	}
	/**
	 * 设置：最小检测值
	 */
	public void setMinimumValue(Double minimumValue) {
		this.minimumValue = minimumValue;
	}
	/**
	 * 获取：最小检测值
	 */
	public Double getMinimumValue() {
		return minimumValue;
	}


	public String getMonitorName() {
		return monitorName;
	}

	public void setMonitorName(String monitorName) {
		this.monitorName = monitorName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getMonitorType() {
		return monitorType;
	}

	public void setMonitorType(String monitorType) {
		this.monitorType = monitorType;
	}

	public String getDrainsCount() {
		return drainsCount;
	}

	public void setDrainsCount(String drainsCount) {
		this.drainsCount = drainsCount;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getMonthVauleCount() {
		return monthVauleCount;
	}

	public void setMonthVauleCount(String monthVauleCount) {
		this.monthVauleCount = monthVauleCount;
	}

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getYearVauleCount() {
        return yearVauleCount;
    }

    public void setYearVauleCount(String yearVauleCount) {
        this.yearVauleCount = yearVauleCount;
    }


	public String getPotencyCount() {
		return potencyCount;
	}

	public void setPotencyCount(String potencyCount) {
		this.potencyCount = potencyCount;
	}
}
