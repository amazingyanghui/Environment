package com.tengdi.environmentalprotectionint.modules.greentax.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Date;
/**
 * 固体废物基础信息采集-污染防治措施表
 * 
 * @author tengdi
 * @email 
 * @date 2019-03-06 10:20:29
 */
@TableName("ep_solid_waste_measures")
public class EpSolidWasteMeasuresEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 企业ID
	 */
	private String companyId;
	/**
	 * 主表ID
	 */
	private String mainId;
	/**
	 * 设施编号
	 */
	private String measuresCode;
	/**
	 * 设施名称
	 */
	private String measuresName;
	/**
	 * 设施基本情况（贮存设施）
	 */
	private String measuresBasic;
	/**
	 * 固体废物名或编码
	 */
	private String waste;
	/**
	 * 八位码
	 */
	private String eightCode;
	/**
	 * 综合利用和处置废物的废物来源
	 */
	private String wasteSource;
	/**
	 * 综合利用产物
	 */
	private String product;
	/**
	 * 综合利用方式/处置方式
	 */
	private String mode;
	/**
	 * 综合处理能力/处置能力/贮存容量)
	 */
	private String processingCapacity;
	/**
	 * 1 合规综合利用设施 2.合规处置设施 3.合规贮存设施
	 */
	private Integer type;

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
	 * 设置：企业ID
	 */
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	/**
	 * 获取：企业ID
	 */
	public String getCompanyId() {
		return companyId;
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
	 * 设置：设施编号
	 */
	public void setMeasuresCode(String measuresCode) {
		this.measuresCode = measuresCode;
	}
	/**
	 * 获取：设施编号
	 */
	public String getMeasuresCode() {
		return measuresCode;
	}
	/**
	 * 设置：设施名称
	 */
	public void setMeasuresName(String measuresName) {
		this.measuresName = measuresName;
	}
	/**
	 * 获取：设施名称
	 */
	public String getMeasuresName() {
		return measuresName;
	}
	/**
	 * 设置：设施基本情况（贮存设施）
	 */
	public void setMeasuresBasic(String measuresBasic) {
		this.measuresBasic = measuresBasic;
	}
	/**
	 * 获取：设施基本情况（贮存设施）
	 */
	public String getMeasuresBasic() {
		return measuresBasic;
	}
	/**
	 * 设置：固体废物名或编码
	 */
	public void setWaste(String waste) {
		this.waste = waste;
	}
	/**
	 * 获取：固体废物名或编码
	 */
	public String getWaste() {
		return waste;
	}
	/**
	 * 设置：综合利用和处置废物的废物来源
	 */
	public void setWasteSource(String wasteSource) {
		this.wasteSource = wasteSource;
	}
	/**
	 * 获取：综合利用和处置废物的废物来源
	 */
	public String getWasteSource() {
		return wasteSource;
	}
	/**
	 * 设置：综合利用产物
	 */
	public void setProduct(String product) {
		this.product = product;
	}
	/**
	 * 获取：综合利用产物
	 */
	public String getProduct() {
		return product;
	}
	/**
	 * 设置：综合利用方式/处置方式
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	/**
	 * 获取：综合利用方式/处置方式
	 */
	public String getMode() {
		return mode;
	}
	/**
	 * 设置：综合处理能力/处置能力/贮存容量)
	 */
	public void setProcessingCapacity(String processingCapacity) {
		this.processingCapacity = processingCapacity;
	}
	/**
	 * 获取：综合处理能力/处置能力/贮存容量)
	 */
	public String getProcessingCapacity() {
		return processingCapacity;
	}
	/**
	 * 设置：1 合规综合利用设施 2.合规处置设施 3.合规贮存设施
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：1 合规综合利用设施 2.合规处置设施 3.合规贮存设施
	 */
	public Integer getType() {
		return type;
	}

	public String getEightCode() {
		return eightCode;
	}

	public void setEightCode(String eightCode) {
		this.eightCode = eightCode;
	}
}
