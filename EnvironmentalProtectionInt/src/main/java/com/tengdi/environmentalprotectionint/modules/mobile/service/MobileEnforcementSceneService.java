package com.tengdi.environmentalprotectionint.modules.mobile.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.environmentalprotectionint.modules.mobile.entity.MobileEnforcementSceneEntity;
import com.tengdi.userauthenuuid.modules.sys.entity.SysDictEntity;
import net.sf.json.JSONArray;
import java.util.List;
import java.util.Map;

/**
 * 移动执法现场执法
 *
 * @author tengdi
 * @email 
 * @date 2018-08-23 11:57:35
 */
public interface MobileEnforcementSceneService extends IService<MobileEnforcementSceneEntity> {
    PageUtils queryPage(Map<String, Object> params);

    List<MobileEnforcementSceneEntity> queryList(Map<String, Object> params);

    List<MobileEnforcementSceneEntity> queryName(Map<String, Object> params);

    List<MobileEnforcementSceneEntity> dataById(String cid) ;

    String insertData(MobileEnforcementSceneEntity entity);

    MobileEnforcementSceneEntity entityById(String pid);

    List<MobileEnforcementSceneEntity> getList(List<MobileEnforcementSceneEntity> list) ;
    /**
     * 移动执法记录列表
     */
    PageUtils mobilelist(Map<String, Object> params);
    /**
     * 移动执法统计：该年累计值法人次、执法人员总数、发现问题总数、相比去年执法总数增加百分比
     */
    Map<String,Object> comprehensiveStatistical(Map<String, Object> params);
    /**
    * 移动执法图表统计:月执法统计
    */
    int [] statistical(Map<String, Object> params);
    /**
     * 移动执法统计：去年执法次数与今年对比
     */
    int [] statisticalLastyearAndThisyear(Map<String, Object> params);
    /**
     * 移动执法统计：检查结果
     */
    JSONArray checkTheResultStatistical(Map<String, Object> params);
    /**
     * 移动执法统计：问题类型
     */
    JSONArray statisticalProblemType(Map<String, Object> params);
    /**
     * 移动执法统计：本年度执法类型统计
     */
    JSONArray lawEnforcementTypeStatistical(Map<String, Object> params);
    /**
     * 企业统计-企业所属行业类型统计
     */
    Map<String,Object> industryidStatic1();
    /**
     * 按照JSONArray中JSONObject的某一属性进行排序
     */
    JSONArray storByJSONArrayToJSONObject(JSONArray arr);
    /**
     *按照List中的某一属性进行排序
     */
     List<SysDictEntity> storByList(List dicts);
    /**
     * 环保执法监察
     */
    Map<String,Object> environmentalLawEnforcementMonitoring(String type);
    /**
     * 移动执法页头弹框列表查询接口
     */
    PageUtils playListBox(Map<String, Object> params);
}

