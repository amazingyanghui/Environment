package com.tengdi.environmentalprotectionint.modules.manual.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tengdi.environmentalprotectionint.modules.manual.entity.EnvironmentalProtectionManualEntity;
import com.tengdi.environmentalprotectionint.modules.manual.entity.LegalDocumentsEntity;

import java.util.List;
import java.util.Map;

/**
 * 环保手册法律目录
 * 
 * @author tengdi
 * @email 
 * @date 2018-10-08 09:44:23
 */
public interface EnvironmentalProtectionManualDao extends BaseMapper<EnvironmentalProtectionManualEntity> {
    /**
     * 获取法律法律规目录列表
     */
    List<EnvironmentalProtectionManualEntity> sellist();
    /**
     * 获取法律法规文件列表数据
     */
    List<LegalDocumentsEntity> queryPage(Map<String, Object>  query);
    /**
     * 获取法律法规文件列表总数
     */
    Integer queryPageSum(Map<String, Object> query);
    /**
     * 获取文件，写入数据库
     */
    void insertFile(LegalDocumentsEntity legalDocumentsEntity);
    /**
     *插入环保手册目录节点（获取节点自增长id）
     */
    long addAndGetId(EnvironmentalProtectionManualEntity environmentalProtectionManualEntity);
    /**
     *根据id更新环保手册法律法规目录-目录编码字段
     */
    int updateCode(EnvironmentalProtectionManualEntity environmentalProtectionManualEntity);
    /**
     * 删除文件
     */
    void dellaw(String [] ids);
    /**
     * 查询节点下是否存在子节点
     */
    Map<String,Object>  nodeSel(String pid);
}
