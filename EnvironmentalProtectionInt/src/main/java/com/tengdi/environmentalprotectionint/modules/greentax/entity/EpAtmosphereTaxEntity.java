package com.tengdi.environmentalprotectionint.modules.greentax.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;

import java.io.Serializable;
import java.util.Date;

/**
 * 大气水排放税上报
 * 
 * @author tengdi
 * @email 
 * @date 2019-03-06 09:50:05
 */
@TableName("ep_atmosphere_tax")
public class EpAtmosphereTaxEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 排口ID
	 */
	private String dischargeId;
	/**
	 * 气，水
	 */
	private String dischargeType;
	/**
	 * 排放量
	 */
	private String emissions;
	/**
	 * 污染当量
	 */
	private String pollutionEquivalent;
	/**
	 * 上报区间
	 */
	private String reportSection;
	/**
	 * 0 未提交 1 已提交，待审核 2 已审核  
	 */
	private String status;
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 创建用户
	 */
	private String createUser;
    /**
     *税源编号
     * @return
     */
	@TableField(exist = false)
    private String taxSourceCode;
    /**
     * 监控点编号
     */
	@TableField(exist = false)
    private String monitorCode;
    /**
     * 监控点名称
     */
	@TableField(exist = false)
    private String monitorName;
    /**
     * 主要污染物
     */
	@TableField(exist = false)
    private String mainPollution;
    /**
     *污染物排放量计算方法
     * @return
     */
	@TableField(exist = false)
    private String computingMethod;
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
	 * 设置：排口ID
	 */
	public void setDischargeId(String dischargeId) {
		this.dischargeId = dischargeId;
	}
	/**
	 * 获取：排口ID
	 */
	public String getDischargeId() {
		return dischargeId;
	}
	/**
	 * 设置：气，水
	 */
	public void setDischargeType(String dischargeType) {
		this.dischargeType = dischargeType;
	}
	/**
	 * 获取：气，水
	 */
	public String getDischargeType() {
		return dischargeType;
	}
	/**
	 * 设置：排放量
	 */
	public void setEmissions(String emissions) {
		this.emissions = emissions;
	}
	/**
	 * 获取：排放量
	 */
	public String getEmissions() {
		return emissions;
	}
	/**
	 * 设置：污染当量
	 */
	public void setPollutionEquivalent(String pollutionEquivalent) {
		this.pollutionEquivalent = pollutionEquivalent;
	}
	/**
	 * 获取：污染当量
	 */
	public String getPollutionEquivalent() {
		return pollutionEquivalent;
	}
	/**
	 * 设置：上报区间
	 */
	public void setReportSection(String reportSection) {
		this.reportSection = reportSection;
	}
	/**
	 * 获取：上报区间
	 */
	public String getReportSection() {
		return reportSection;
	}
	/**
	 * 设置：0 未提交 1 已提交，待审核 2 已审核  
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：0 未提交 1 已提交，待审核 2 已审核  
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * 设置：创建用户
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取：创建用户
	 */
	public String getCreateUser() {
		return createUser;
	}

    public String getTaxSourceCode() {
        return taxSourceCode;
    }

    public void setTaxSourceCode(String taxSourceCode) {
        this.taxSourceCode = taxSourceCode;
    }

    public String getMonitorCode() {
        return monitorCode;
    }

    public void setMonitorCode(String monitorCode) {
        this.monitorCode = monitorCode;
    }

    public String getMonitorName() {
        return monitorName;
    }

    public void setMonitorName(String monitorName) {
        this.monitorName = monitorName;
    }

    public String getMainPollution() {
        return mainPollution;
    }

    public void setMainPollution(String mainPollution) {
        this.mainPollution = mainPollution;
    }

    public String getComputingMethod() {
        return computingMethod;
    }

    public void setComputingMethod(String computingMethod) {
        this.computingMethod = computingMethod;
    }
}
