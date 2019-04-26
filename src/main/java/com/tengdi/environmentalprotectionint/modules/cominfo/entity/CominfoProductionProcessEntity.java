package com.tengdi.environmentalprotectionint.modules.cominfo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;

import java.io.Serializable;
import java.util.Date;

/**
 * 生产工艺
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-02 17:42:28
 */
@TableName("cominfo_production_process")
public class CominfoProductionProcessEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键UUID
	 */
	@TableId
	private String pid;
	/**
	 * 映射基本信息表主键（UUID）
	 */
	private String cid;
	/**
	 * 工艺名称
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String processName;
	/**
	 * 工艺简介
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String processIntroduction;

	/**
	 * 产品代码
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String productCode;
	/**
	 * 产品名称
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String productName;
	/**
	 * 年产量
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String annualOutput;
	/**
	 * 实际年产量
	 */
	private String actualAnnualOutput;
	/**
	 * 计量单位
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String unit;

	/**
	 * 备注
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String remarks;
	/**
	 * 创建时间
	 */
	private Date createdate;
	/**
	 * 修改时间
	 */
	private Date updatedate;
	/**
	 * 删除时间
	 */
	private Date deletedate;
	/**
	 * 生产工艺流程图
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

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
	 * 设置：映射基本信息表主键（UUID）
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}
	/**
	 * 获取：映射基本信息表主键（UUID）
	 */
	public String getCid() {
		return cid;
	}
	/**
	 * 设置：工艺名称
	 */
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	/**
	 * 获取：工艺名称
	 */
	public String getProcessName() {
		return processName;
	}
	/**
	 * 设置：工艺简介
	 */
	public void setProcessIntroduction(String processIntroduction) {
		this.processIntroduction = processIntroduction;
	}
	/**
	 * 获取：工艺简介
	 */
	public String getProcessIntroduction() {
		return processIntroduction;
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
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreatedate() {
		return createdate;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdatedate() {
		return updatedate;
	}
	/**
	 * 设置：删除时间
	 */
	public void setDeletedate(Date deletedate) {
		this.deletedate = deletedate;
	}
	/**
	 * 获取：删除时间
	 */
	public Date getDeletedate() {
		return deletedate;
	}


	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getAnnualOutput() {
		return annualOutput;
	}

	public void setAnnualOutput(String annualOutput) {
		this.annualOutput = annualOutput;
	}

	public String getActualAnnualOutput() {
		return actualAnnualOutput;
	}

	public void setActualAnnualOutput(String actualAnnualOutput) {
		this.actualAnnualOutput = actualAnnualOutput;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
}
