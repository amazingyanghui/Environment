package com.tengdi.environmentalprotectionint.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.tengdi.core.utils.DateUtils;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 系统公告
 * 
 * @author tengdi
 * @email 
 * @date 2019-03-07 11:01:21
 */
@TableName("sys_notice")
public class SysNoticeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 公告标题
	 */
	private String title;
	/**
	 * 公告内容
	 */
	private String content;
	/**
	 * 公告图片
	 */
	private String file;
	/**
	 * 是否显示 （0. 否，1.是 ）
	 */
	private Integer show;
	/**
	 * 发布时间
	 */
	private Date createTime;

	@TableField(exist = false)
	private String createTimeStr;

	public String getCreateTimeStr() {
		String dateString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(createTime);
		return dateString;
	}

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
	 * 设置：公告标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：公告标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：公告内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：公告内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：公告图片
	 */
	public void setFile(String file) {
		this.file = file;
	}
	/**
	 * 获取：公告图片
	 */
	public String getFile() {
		return file;
	}
	/**
	 * 设置：是否显示 （0. 否，1.是 ）
	 */
	public void setShow(Integer show) {
		this.show = show;
	}
	/**
	 * 获取：是否显示 （0. 否，1.是 ）
	 */
	public Integer getShow() {
		return show;
	}
	/**
	 * 设置：发布时间
	 */
	public void setCreateTime(Date createtime) {
		this.createTime = createtime;
	}
	/**
	 * 获取：发布时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
}
