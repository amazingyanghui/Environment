package com.tengdi.environmentalprotectionint.modules.cominfo.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.SysHangyedaimaEntity;
import com.tengdi.environmentalprotectionint.modules.common.entity.SelectEntity;
import net.sf.json.JSONArray;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author tengdi
 * @email 
 * @date 2018-09-11 14:56:09
 */
public interface SysHangyedaimaService extends IService<SysHangyedaimaEntity> {

    PageUtils queryPage(Map<String, Object> params);

    JSONArray getHangYeLieBiao(String code);

    List<SysHangyedaimaEntity> queryList(Map map);

    List<SysHangyedaimaEntity> dataByCode(String code);

    List<String> getList(List<SysHangyedaimaEntity> list,List<String> strList,Integer hangbiaoshi);

    List<String> getIndustryList(Map map);
    /**
     * 获取行业列表下拉框
     */
    List<SelectEntity> selectGetHangYeLieBiao();
}

