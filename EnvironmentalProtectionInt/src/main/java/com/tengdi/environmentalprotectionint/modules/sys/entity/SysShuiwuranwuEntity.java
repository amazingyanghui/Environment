package com.tengdi.environmentalprotectionint.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 水污染代码表
 * 
 * @author tengdi
 * @email 
 * @date 2018-10-23 11:23:18
 */
@TableName("sys_shuiwuranwu")
public class SysShuiwuranwuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer hangbiaoshi;
	/**
	 * 
	 */
	private Integer biaoshi;
	/**
	 * 
	 */
	private Integer xianshi;
	/**
	 * 
	 */
	private Integer jiluleixing;
	/**
	 * 
	 */
	private String mingcheng;
	/**
	 * 
	 */
	private String daimazhi;
	/**
	 * 
	 */
	private Integer yijifenleibiaoshi;
	/**
	 * 
	 */
	private Integer erjifenleibiaoshi;
	/**
	 * 
	 */
	private Integer sanjifenleibiaoshi;
	/**
	 * 
	 */
	private Integer sijifenleibiaoshi;
	/**
	 * 
	 */
	private Integer wujifenleibiaoshi;
	/**
	 * 
	 */
	private Integer liujifenleibiaoshi;
	/**
	 * 
	 */
	private Integer fujidaimabiaoshi;
	/**
	 * 
	 */
	private String daimazifu;
	/**
	 * 
	 */
	private Integer cixu;
	/**
	 * 
	 */
	private Integer banbenhao;
	/**
	 * 
	 */
	private String beiyongzifu;
	/**
	 * 
	 */
	private Integer beiyongzi;
	/**
	 * 
	 */
	private String chuangjianshijian;
	/**
	 * 
	 */
	private String xiugaishijian;
	/**
	 * 
	 */
	private Integer symbol;
	@TableField(exist = false)
	private Boolean nocheck;
	/**
	 *
	 */
	@TableField(exist = false)
	private Boolean checked;

	public Boolean getNocheck() {
		return nocheck;
	}

	public void setNocheck(Boolean nocheck) {
		this.nocheck = nocheck;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	/**
	 * 设置：
	 */
	public void setHangbiaoshi(Integer hangbiaoshi) {
		this.hangbiaoshi = hangbiaoshi;
	}
	/**
	 * 获取：
	 */
	public Integer getHangbiaoshi() {
		return hangbiaoshi;
	}
	/**
	 * 设置：
	 */
	public void setBiaoshi(Integer biaoshi) {
		this.biaoshi = biaoshi;
	}
	/**
	 * 获取：
	 */
	public Integer getBiaoshi() {
		return biaoshi;
	}
	/**
	 * 设置：
	 */
	public void setXianshi(Integer xianshi) {
		this.xianshi = xianshi;
	}
	/**
	 * 获取：
	 */
	public Integer getXianshi() {
		return xianshi;
	}
	/**
	 * 设置：
	 */
	public void setJiluleixing(Integer jiluleixing) {
		this.jiluleixing = jiluleixing;
	}
	/**
	 * 获取：
	 */
	public Integer getJiluleixing() {
		return jiluleixing;
	}
	/**
	 * 设置：
	 */
	public void setMingcheng(String mingcheng) {
		this.mingcheng = mingcheng;
	}
	/**
	 * 获取：
	 */
	public String getMingcheng() {
		return mingcheng;
	}
	/**
	 * 设置：
	 */
	public void setDaimazhi(String daimazhi) {
		this.daimazhi = daimazhi;
	}
	/**
	 * 获取：
	 */
	public String getDaimazhi() {
		return daimazhi;
	}
	/**
	 * 设置：
	 */
	public void setYijifenleibiaoshi(Integer yijifenleibiaoshi) {
		this.yijifenleibiaoshi = yijifenleibiaoshi;
	}
	/**
	 * 获取：
	 */
	public Integer getYijifenleibiaoshi() {
		return yijifenleibiaoshi;
	}
	/**
	 * 设置：
	 */
	public void setErjifenleibiaoshi(Integer erjifenleibiaoshi) {
		this.erjifenleibiaoshi = erjifenleibiaoshi;
	}
	/**
	 * 获取：
	 */
	public Integer getErjifenleibiaoshi() {
		return erjifenleibiaoshi;
	}
	/**
	 * 设置：
	 */
	public void setSanjifenleibiaoshi(Integer sanjifenleibiaoshi) {
		this.sanjifenleibiaoshi = sanjifenleibiaoshi;
	}
	/**
	 * 获取：
	 */
	public Integer getSanjifenleibiaoshi() {
		return sanjifenleibiaoshi;
	}
	/**
	 * 设置：
	 */
	public void setSijifenleibiaoshi(Integer sijifenleibiaoshi) {
		this.sijifenleibiaoshi = sijifenleibiaoshi;
	}
	/**
	 * 获取：
	 */
	public Integer getSijifenleibiaoshi() {
		return sijifenleibiaoshi;
	}
	/**
	 * 设置：
	 */
	public void setWujifenleibiaoshi(Integer wujifenleibiaoshi) {
		this.wujifenleibiaoshi = wujifenleibiaoshi;
	}
	/**
	 * 获取：
	 */
	public Integer getWujifenleibiaoshi() {
		return wujifenleibiaoshi;
	}
	/**
	 * 设置：
	 */
	public void setLiujifenleibiaoshi(Integer liujifenleibiaoshi) {
		this.liujifenleibiaoshi = liujifenleibiaoshi;
	}
	/**
	 * 获取：
	 */
	public Integer getLiujifenleibiaoshi() {
		return liujifenleibiaoshi;
	}
	/**
	 * 设置：
	 */
	public void setFujidaimabiaoshi(Integer fujidaimabiaoshi) {
		this.fujidaimabiaoshi = fujidaimabiaoshi;
	}
	/**
	 * 获取：
	 */
	public Integer getFujidaimabiaoshi() {
		return fujidaimabiaoshi;
	}
	/**
	 * 设置：
	 */
	public void setDaimazifu(String daimazifu) {
		this.daimazifu = daimazifu;
	}
	/**
	 * 获取：
	 */
	public String getDaimazifu() {
		return daimazifu;
	}
	/**
	 * 设置：
	 */
	public void setCixu(Integer cixu) {
		this.cixu = cixu;
	}
	/**
	 * 获取：
	 */
	public Integer getCixu() {
		return cixu;
	}
	/**
	 * 设置：
	 */
	public void setBanbenhao(Integer banbenhao) {
		this.banbenhao = banbenhao;
	}
	/**
	 * 获取：
	 */
	public Integer getBanbenhao() {
		return banbenhao;
	}
	/**
	 * 设置：
	 */
	public void setBeiyongzifu(String beiyongzifu) {
		this.beiyongzifu = beiyongzifu;
	}
	/**
	 * 获取：
	 */
	public String getBeiyongzifu() {
		return beiyongzifu;
	}
	/**
	 * 设置：
	 */
	public void setBeiyongzi(Integer beiyongzi) {
		this.beiyongzi = beiyongzi;
	}
	/**
	 * 获取：
	 */
	public Integer getBeiyongzi() {
		return beiyongzi;
	}
	/**
	 * 设置：
	 */
	public void setChuangjianshijian(String chuangjianshijian) {
		this.chuangjianshijian = chuangjianshijian;
	}
	/**
	 * 获取：
	 */
	public String getChuangjianshijian() {
		return chuangjianshijian;
	}
	/**
	 * 设置：
	 */
	public void setXiugaishijian(String xiugaishijian) {
		this.xiugaishijian = xiugaishijian;
	}
	/**
	 * 获取：
	 */
	public String getXiugaishijian() {
		return xiugaishijian;
	}
	/**
	 * 设置：
	 */
	public void setSymbol(Integer symbol) {
		this.symbol = symbol;
	}
	/**
	 * 获取：
	 */
	public Integer getSymbol() {
		return symbol;
	}
}
