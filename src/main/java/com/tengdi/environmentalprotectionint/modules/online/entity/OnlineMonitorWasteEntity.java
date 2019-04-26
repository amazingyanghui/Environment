package com.tengdi.environmentalprotectionint.modules.online.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 排放污染物信息表
 * 
 * @author tengdi
 * @email 
 * @date 2019-03-06 16:46:24
 */
@TableName("online_monitor_wasteinfo")
public class OnlineMonitorWasteEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键UUID
     */
    @TableId
    private String pid;
    /**
     * 对应企业信息表中的【企业ID】
     */
    private String cid;
    /**
     * 对应排口信息表中的【监控点ID】
     */
    private String mid;
    /**
     * 年度
     */
    private String year;
    /**
     * 污染物名称、测点名称、污染物名称
     */
    private String pollutantName;
    /**
     * 污染物代码
     */
    private String pollutantCode;
    /**
     * 污染物单位
     */
    private String pollutantUnit;
    /**
     * 污染物种类
     */
    private String pollutantType;
    /**
     * 执行标准(mg/Nm3)
     */
    private String standard;
    /**
     * 标准类型
     */
    private String standardType;
    /**
     * 适用的行业标准
     */
    private String industryStandard;
    /**
     * 适用的企业范围
     */
    private String businessScope;
    /**
     * 废气时段
     */
    private String exhaustTime;
    /**
     * 污染物排放许可量(吨)、污染物堆放许可量（固废）(吨)
     */
    private String emissionPermits;
    /**
     * 污染物实际排放量(吨)、污染物实际堆放量（固废）
     */
    private String actualDischarge;
    /**
     * 产量
     */
    private String output;
    /**
     * 排放量
     */
    private String emissions;
    /**
     * 测点位置
     */
    private String measurePosition;
    /**
     * 主要噪声源
     */
    private String mainNoiseSource;
    /**
     * 噪声源性质
     */
    private String noiseSourceNature;
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
     * 对应排污口名称
     */
    @TableField(exist = false)
    private String portName;
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
     * 设置：对应企业信息表中的【企业ID】
     */
    public void setCid(String cid) {
        this.cid = cid;
    }
    /**
     * 获取：对应企业信息表中的【企业ID】
     */
    public String getCid() {
        return cid;
    }
    /**
     * 设置：对应排口信息表中的【监控点ID】
     */
    public void setMid(String mid) {
        this.mid = mid;
    }
    /**
     * 获取：对应排口信息表中的【监控点ID】
     */
    public String getMid() {
        return mid;
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
     * 设置：污染物名称、测点名称、污染物名称
     */
    public void setPollutantName(String pollutantName) {
        this.pollutantName = pollutantName;
    }
    /**
     * 获取：污染物名称、测点名称、污染物名称
     */
    public String getPollutantName() {
        return pollutantName;
    }
    /**
     * 设置：污染物代码
     */
    public void setPollutantCode(String pollutantCode) {
        this.pollutantCode = pollutantCode;
    }
    /**
     * 获取：污染物代码
     */
    public String getPollutantCode() {
        return pollutantCode;
    }
    /**
     * 设置：污染物单位
     */
    public void setPollutantUnit(String pollutantUnit) {
        this.pollutantUnit = pollutantUnit;
    }
    /**
     * 获取：污染物单位
     */
    public String getPollutantUnit() {
        return pollutantUnit;
    }
    /**
     * 设置：污染物种类
     */
    public void setPollutantType(String pollutantType) {
        this.pollutantType = pollutantType;
    }
    /**
     * 获取：污染物种类
     */
    public String getPollutantType() {
        return pollutantType;
    }
    /**
     * 设置：执行标准(mg/Nm3)
     */
    public void setStandard(String standard) {
        this.standard = standard;
    }
    /**
     * 获取：执行标准(mg/Nm3)
     */
    public String getStandard() {
        return standard;
    }
    /**
     * 设置：标准类型
     */
    public void setStandardType(String standardType) {
        this.standardType = standardType;
    }
    /**
     * 获取：标准类型
     */
    public String getStandardType() {
        return standardType;
    }
    /**
     * 设置：适用的行业标准
     */
    public void setIndustryStandard(String industryStandard) {
        this.industryStandard = industryStandard;
    }
    /**
     * 获取：适用的行业标准
     */
    public String getIndustryStandard() {
        return industryStandard;
    }
    /**
     * 设置：适用的企业范围
     */
    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope;
    }
    /**
     * 获取：适用的企业范围
     */
    public String getBusinessScope() {
        return businessScope;
    }
    /**
     * 设置：废气时段
     */
    public void setExhaustTime(String exhaustTime) {
        this.exhaustTime = exhaustTime;
    }
    /**
     * 获取：废气时段
     */
    public String getExhaustTime() {
        return exhaustTime;
    }
    /**
     * 设置：污染物排放许可量(吨)、污染物堆放许可量（固废）(吨)
     */
    public void setEmissionPermits(String emissionPermits) {
        this.emissionPermits = emissionPermits;
    }
    /**
     * 获取：污染物排放许可量(吨)、污染物堆放许可量（固废）(吨)
     */
    public String getEmissionPermits() {
        return emissionPermits;
    }
    /**
     * 设置：污染物实际排放量(吨)、污染物实际堆放量（固废）
     */
    public void setActualDischarge(String actualDischarge) {
        this.actualDischarge = actualDischarge;
    }
    /**
     * 获取：污染物实际排放量(吨)、污染物实际堆放量（固废）
     */
    public String getActualDischarge() {
        return actualDischarge;
    }
    /**
     * 设置：产量
     */
    public void setOutput(String output) {
        this.output = output;
    }
    /**
     * 获取：产量
     */
    public String getOutput() {
        return output;
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
     * 设置：测点位置
     */
    public void setMeasurePosition(String measurePosition) {
        this.measurePosition = measurePosition;
    }
    /**
     * 获取：测点位置
     */
    public String getMeasurePosition() {
        return measurePosition;
    }
    /**
     * 设置：主要噪声源
     */
    public void setMainNoiseSource(String mainNoiseSource) {
        this.mainNoiseSource = mainNoiseSource;
    }
    /**
     * 获取：主要噪声源
     */
    public String getMainNoiseSource() {
        return mainNoiseSource;
    }
    /**
     * 设置：噪声源性质
     */
    public void setNoiseSourceNature(String noiseSourceNature) {
        this.noiseSourceNature = noiseSourceNature;
    }
    /**
     * 获取：噪声源性质
     */
    public String getNoiseSourceNature() {
        return noiseSourceNature;
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

    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }
}
