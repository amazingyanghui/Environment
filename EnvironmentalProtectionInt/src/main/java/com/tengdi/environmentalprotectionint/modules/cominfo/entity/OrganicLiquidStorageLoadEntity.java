package com.tengdi.environmentalprotectionint.modules.cominfo.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 工业企业有机液体储罐、装载信息
 * 
 * @author tengdi
 * @email 
 * @date 2019-03-07 16:15:35
 */
@TableName("organic_liquid_storage_load")
public class OrganicLiquidStorageLoadEntity implements Serializable {
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
	 * 物料名称
	 */
	private String materielName;
	/**
	 * 物料代码
	 */
	private String materielCode;
	/**
	 * 储罐类型
	 */
	private String storageTankType;
	/**
	 * 储罐容积
	 */
	private String storageTankVolume;
	/**
	 * 储存温度
	 */
	private String temperature;
	/**
	 * 相同类型、容积、温度的储罐个数
	 */
	private String storageTankNumber;
	/**
	 * 物料年周转量
	 */
	private String annualTurnover;
	/**
	 * 挥发性有机物处理工艺
	 */
	private String treatmentProcess1;
	/**
	 * 年装载量
	 */
	private String annualLoadingCapacity;
	/**
	 * 其中：汽车/火车装载量
	 */
	private String carTrainLoad;
	/**
	 * 汽车/火车装载方式
	 */
	private String carTrainLoadMode;
	/**
	 * 船舶装载量
	 */
	private String shipLoad;
	/**
	 * 船舶装载方式
	 */
	private String shipLoadMode;
	/**
	 * 挥发性有机物处理工艺
	 */
	private String treatmentProcess2;
	/**
	 * 挥发性有机物产生量
	 */
	private String output;
	/**
	 * 挥发性有机物排放量
	 */
	private String emissions;
	/**
	 * 数据时间
	 */
	private String dataTime;
	/**
	 * 备注
	 */
	private String remarks;
	/**
	 * 创建时间
	 */
	private String createdate;
	/**
	 * 更新时间
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
	 * 设置：物料名称
	 */
	public void setMaterielName(String materielName) {
		this.materielName = materielName;
	}
	/**
	 * 获取：物料名称
	 */
	public String getMaterielName() {
		return materielName;
	}
	/**
	 * 设置：物料代码
	 */
	public void setMaterielCode(String materielCode) {
		this.materielCode = materielCode;
	}
	/**
	 * 获取：物料代码
	 */
	public String getMaterielCode() {
		return materielCode;
	}
	/**
	 * 设置：储罐类型
	 */
	public void setStorageTankType(String storageTankType) {
		this.storageTankType = storageTankType;
	}
	/**
	 * 获取：储罐类型
	 */
	public String getStorageTankType() {
		return storageTankType;
	}
	/**
	 * 设置：储罐容积
	 */
	public void setStorageTankVolume(String storageTankVolume) {
		this.storageTankVolume = storageTankVolume;
	}
	/**
	 * 获取：储罐容积
	 */
	public String getStorageTankVolume() {
		return storageTankVolume;
	}
	/**
	 * 设置：储存温度
	 */
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	/**
	 * 获取：储存温度
	 */
	public String getTemperature() {
		return temperature;
	}
	/**
	 * 设置：相同类型、容积、温度的储罐个数
	 */
	public void setStorageTankNumber(String storageTankNumber) {
		this.storageTankNumber = storageTankNumber;
	}
	/**
	 * 获取：相同类型、容积、温度的储罐个数
	 */
	public String getStorageTankNumber() {
		return storageTankNumber;
	}
	/**
	 * 设置：物料年周转量
	 */
	public void setAnnualTurnover(String annualTurnover) {
		this.annualTurnover = annualTurnover;
	}
	/**
	 * 获取：物料年周转量
	 */
	public String getAnnualTurnover() {
		return annualTurnover;
	}
	/**
	 * 设置：挥发性有机物处理工艺
	 */
	public void setTreatmentProcess1(String treatmentProcess1) {
		this.treatmentProcess1 = treatmentProcess1;
	}
	/**
	 * 获取：挥发性有机物处理工艺
	 */
	public String getTreatmentProcess1() {
		return treatmentProcess1;
	}
	/**
	 * 设置：年装载量
	 */
	public void setAnnualLoadingCapacity(String annualLoadingCapacity) {
		this.annualLoadingCapacity = annualLoadingCapacity;
	}
	/**
	 * 获取：年装载量
	 */
	public String getAnnualLoadingCapacity() {
		return annualLoadingCapacity;
	}
	/**
	 * 设置：其中：汽车/火车装载量
	 */
	public void setCarTrainLoad(String carTrainLoad) {
		this.carTrainLoad = carTrainLoad;
	}
	/**
	 * 获取：其中：汽车/火车装载量
	 */
	public String getCarTrainLoad() {
		return carTrainLoad;
	}
	/**
	 * 设置：汽车/火车装载方式
	 */
	public void setCarTrainLoadMode(String carTrainLoadMode) {
		this.carTrainLoadMode = carTrainLoadMode;
	}
	/**
	 * 获取：汽车/火车装载方式
	 */
	public String getCarTrainLoadMode() {
		return carTrainLoadMode;
	}
	/**
	 * 设置：船舶装载量
	 */
	public void setShipLoad(String shipLoad) {
		this.shipLoad = shipLoad;
	}
	/**
	 * 获取：船舶装载量
	 */
	public String getShipLoad() {
		return shipLoad;
	}
	/**
	 * 设置：船舶装载方式
	 */
	public void setShipLoadMode(String shipLoadMode) {
		this.shipLoadMode = shipLoadMode;
	}
	/**
	 * 获取：船舶装载方式
	 */
	public String getShipLoadMode() {
		return shipLoadMode;
	}
	/**
	 * 设置：挥发性有机物处理工艺
	 */
	public void setTreatmentProcess2(String treatmentProcess2) {
		this.treatmentProcess2 = treatmentProcess2;
	}
	/**
	 * 获取：挥发性有机物处理工艺
	 */
	public String getTreatmentProcess2() {
		return treatmentProcess2;
	}
	/**
	 * 设置：挥发性有机物产生量
	 */
	public void setOutput(String output) {
		this.output = output;
	}
	/**
	 * 获取：挥发性有机物产生量
	 */
	public String getOutput() {
		return output;
	}
	/**
	 * 设置：挥发性有机物排放量
	 */
	public void setEmissions(String emissions) {
		this.emissions = emissions;
	}
	/**
	 * 获取：挥发性有机物排放量
	 */
	public String getEmissions() {
		return emissions;
	}
	/**
	 * 设置：数据时间
	 */
	public void setDataTime(String dataTime) {
		this.dataTime = dataTime;
	}
	/**
	 * 获取：数据时间
	 */
	public String getDataTime() {
		return dataTime;
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
	 * 设置：更新时间
	 */
	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	/**
	 * 获取：更新时间
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
