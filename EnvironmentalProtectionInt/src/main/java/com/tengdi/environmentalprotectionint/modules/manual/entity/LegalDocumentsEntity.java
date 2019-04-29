package com.tengdi.environmentalprotectionint.modules.manual.entity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.tengdi.core.utils.DateUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * 法律法规文件路径
 *
 * @author tengdi
 * @email
 * @date 2018-10-10 15:30:56
 */
@TableName("legal_documents")
public class LegalDocumentsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private String pid;
	/**
	 * 编码
	 */
	private String code;
	/**
	 * 文件路径
	 */
	private String path;
	/**
	 * 文件名称
	 */
	private String fileName;
	/**
	 * 文件大小
	 */
	private String fileSize;
	/**
	 * 上传人
	 */
	private String heir;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 创建时间
	 */
	@TableField(exist = false)
	private String  createTimeStr;
	/**
	 * 文本内容
	 */
	private String content;

	/**
	 * 设置：主键
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}
	/**
	 * 获取：主键
	 */
	public String getPid() {
		return pid;
	}
	/**
	 * 设置：编码
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取：编码
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 设置：文件路径
	 */
	public void setPath(String path) {
		this.path = path;
	}
	/**
	 * 获取：文件路径
	 */
	public String getPath() {
		return path;
	}
	/**
	 * 设置：文件名称
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * 获取：文件名称
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * 设置：文件大小
	 */
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	/**
	 * 获取：文件大小
	 */
	public String getFileSize() {
		return fileSize;
	}
	/**
	 * 设置：上传人
	 */
	public void setHeir(String heir) {
		this.heir = heir;
	}
	/**
	 * 获取：上传人
	 */
	public String getHeir() {
		return heir;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreateTimeStr() {
		return DateUtils.format(createTime);
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}
}
