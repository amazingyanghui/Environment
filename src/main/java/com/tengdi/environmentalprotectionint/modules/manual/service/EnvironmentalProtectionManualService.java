package com.tengdi.environmentalprotectionint.modules.manual.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.environmentalprotectionint.modules.manual.entity.EnvironmentalProtectionManualEntity;
import com.tengdi.environmentalprotectionint.modules.manual.entity.LegalDocumentsEntity;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.userauthenuuid.modules.sys.entity.SysUserEntity;
import net.sf.json.JSONArray;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 环保手册法律树目录
 *
 * @author tengdi
 * @email 
 * @date 2018-10-08 09:44:23
 */
public interface EnvironmentalProtectionManualService extends IService<EnvironmentalProtectionManualEntity> {
    /**
     * 列表
     */
    PageUtils queryPage(Map<String, Object> params);
    /**
     * 选择仓库(添加、修改菜单)
     */
    JSONArray getProductionProductionStorageEntityJSONArray(String type);

    /**
     * 将获取的目录拼成TREE需要的格式
     * @param codeList
     * @param parentId
     * @param type
     * @return
     */
    JSONArray getStorageJsonArray(List<EnvironmentalProtectionManualEntity> codeList, String parentId, String type);
    /**
     * 获取菜单目录列表
     * @param params
     * @return
     */
    List<EnvironmentalProtectionManualEntity> queryList(Map<String, Object> params);
    /**
     *  获取文件，写入数据库
     */
    void insertFile(LegalDocumentsEntity  legalDocumentsEntity);
    /**
     * 获取HttpServletRequest 请求中token的用户信息
     */
      SysUserEntity getUserByToken(HttpServletRequest request);
    /**
     * 插入环保手册目录节点（获取节点自增长id）
     */
    String addAndGetId(EnvironmentalProtectionManualEntity environmentalProtectionManualEntity);
    /**
     *根据id更新环保手册法律法规目录-目录编码字段
     */
    void updateCode(EnvironmentalProtectionManualEntity environmentalProtectionManualEntity);
    /**
     * 删除文件
     */
     void dellaw(String [] ids);
    /**
     * 查询节点下是否存在子节点
     */
    Map<String,Integer> nodeSel(String pid);
    /**
     * 删除文件
     */
     String delFile(String path);
}

