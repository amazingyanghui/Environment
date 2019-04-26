package com.tengdi.environmentalprotectionint.modules.cominfo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;

import java.io.Serializable;
import java.util.Date;

/**
 * 企业总量控制计划
 * 
 * @author tengdi
 * @email 
 * @date 2018-12-03 17:54:50
 */
@TableName("cominfo_total_controlplan")
public class CominfoTotalControlplanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键（UUID）
	 */
	@TableId
	private String pid;

	/**
	 * 关联的企业ID
	 */
	private String cid;
	/**
	 * 公司名称
	 */
	@TableField(exist = false)
	private String companyName;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * 年度
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String year;
	/**
	 * 因子
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String factor;
	/**
	 * 总量
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String total;
	/**
	 * 单位
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String unit;
	/**
	 * 附件url
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String attachment;
	/**
	 * 创建时间
	 */
	private Date createdate;
	/**
	 * 更新时间
	 */
	private Date updatedate;
	/**
	 * 
	 */
	private Date deletedate;

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

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
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
	 * 设置：因子
	 */
	public void setFactor(String factor) {
		this.factor = factor;
	}
	/**
	 * 获取：因子
	 */
	public String getFactor() {
		return factor;
	}
	/**
	 * 设置：总量
	 */
	public void setTotal(String total) {
		this.total = total;
	}
	/**
	 * 获取：总量
	 */
	public String getTotal() {
		return total;
	}
	/**
	 * 设置：单位
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	/**
	 * 获取：单位
	 */
	public String getUnit() {
		return unit;
	}
	/**
	 * 设置：附件url
	 */
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	/**
	 * 获取：附件url
	 */
	public String getAttachment() {
		return attachment;
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
	 * 设置：更新时间
	 */
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdatedate() {
		return updatedate;
	}
	/**
	 * 设置：
	 */
	public void setDeletedate(Date deletedate) {
		this.deletedate = deletedate;
	}
	/**
	 * 获取：
	 */
	public Date getDeletedate() {
		return deletedate;
	}
}
