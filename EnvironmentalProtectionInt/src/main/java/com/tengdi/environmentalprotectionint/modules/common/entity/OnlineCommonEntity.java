package com.tengdi.environmentalprotectionint.modules.common.entity;

import java.util.List;

public class OnlineCommonEntity {
    /**
     * 公司id
     */
    private String cid;
    /**
     * 排口id
     */
    private String mid;
    /**
     * 开始时间
     */
    private String startDate;
    /**
     * 结束时间
     */
    private String endDate;
    /**
     * 因子list
     */
    private List<String> factorList;
    /**
     * 查出数据存放处
     */
    private List<double[]> testDataList;
    /**
     * 查出名字存放处
     */
    private List<String> nameList;
    /**
     * 是否是废水和废气（0：废水废气的排放量；1：不是废水废气的浓度）
     */
    private List<Integer> isEnvironmentFactorList;
    /**
     * 最大值list
     */
    private List<Double> maximumValueList;
    /**
     * 最小值list
     */
    private List<Double> minimumValueList;

    public List<Double> getMaximumValueList() {
        return maximumValueList;
    }

    public void setMaximumValueList(List<Double> maximumValueList) {
        this.maximumValueList = maximumValueList;
    }

    public List<Double> getMinimumValueList() {
        return minimumValueList;
    }

    public void setMinimumValueList(List<Double> minimumValueList) {
        this.minimumValueList = minimumValueList;
    }

    public List<double[]> getTestDataList() {
        return testDataList;
    }

    public void setTestDataList(List<double[]> testDataList) {
        this.testDataList = testDataList;
    }

    public List<String> getNameList() {
        return nameList;
    }

    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }

    public List<Integer> getIsEnvironmentFactorList() {
        return isEnvironmentFactorList;
    }

    public void setIsEnvironmentFactorList(List<Integer> isEnvironmentFactorList) {
        this.isEnvironmentFactorList = isEnvironmentFactorList;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<String> getFactorList() {
        return factorList;
    }

    public void setFactorList(List<String> factorList) {
        this.factorList = factorList;
    }
}
