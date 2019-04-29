package com.tengdi.environmentalprotectionint.modules.cominfo.service.impl;

import com.tengdi.environmentalprotectionint.modules.common.entity.SelectEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.BeanHump;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;
import com.tengdi.core.utils.QueryCriterias;
import com.tengdi.environmentalprotectionint.modules.cominfo.dao.CominfoWasteProcessPlaceDao;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoWasteProcessPlaceEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoWasteProcessPlaceService;

@Service("cominfoWasteProcessPlaceService")
public class CominfoWasteProcessPlaceServiceImpl extends ServiceImpl<CominfoWasteProcessPlaceDao, CominfoWasteProcessPlaceEntity> implements CominfoWasteProcessPlaceService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String cid = (String)params.get("cid");
        String wasteCategoryType = (String)params.get("wasteCategoryType");
        Page<CominfoWasteProcessPlaceEntity> page = this.selectPage(
                new Query<CominfoWasteProcessPlaceEntity>(params).getPage(),
                new EntityWrapper<CominfoWasteProcessPlaceEntity>()
                        .eq(StringUtils.isNotBlank(wasteCategoryType),"waste_category_type", wasteCategoryType)
                        .eq(StringUtils.isNotBlank(cid),"cid", cid)
        );

        return new PageUtils(page);
    }


    @Override
    public List<CominfoWasteProcessPlaceEntity> queryList(Map<String, Object> params) {
        String cid=(String)params.get("cid");
        String wasteCategoryType = (String)params.get("wasteCategoryType");
        List<CominfoWasteProcessPlaceEntity> list=this.selectList(
                new EntityWrapper<CominfoWasteProcessPlaceEntity>()
                        .eq(StringUtils.isNotBlank(wasteCategoryType),"waste_category_type", wasteCategoryType)
                        .eq(StringUtils.isNotBlank(cid),"cid",cid));

        return list;
    }

    @Override
    public PageUtils queryTableData(QueryCriterias criterias) {
        Integer limit = criterias.getLimit();
        Integer page = criterias.getPage();
        Integer offset = (page-1) * limit;
        criterias.setPagenumber(offset);
        criterias.setPagesize(limit);
        List<Map<String,Object>> list = new ArrayList<>();
        int count = 0;
        // 非汇总表调用普通通用查询接口
        if (StringUtils.isEmpty(criterias.getSumCols())) {
            list = baseMapper.queryList(criterias);
            count = baseMapper.queryListCount(criterias);
        }
        return new PageUtils(BeanHump.listUnderlineKeyToCamel(list),count,limit,page);
    }

    @Override
    public List<SelectEntity> list(String wasteCategoryType,String cid) {
        List<CominfoWasteProcessPlaceEntity> list =
                this.selectList(new EntityWrapper<CominfoWasteProcessPlaceEntity>()
                        .eq(StringUtils.isNotBlank(cid),"cid", cid)
                        .eq(StringUtils.isNotBlank(wasteCategoryType),"waste_category_type", wasteCategoryType)
                );

        List<SelectEntity> selectlist = new ArrayList<SelectEntity>();
        for(CominfoWasteProcessPlaceEntity entity : list){
            SelectEntity select = new SelectEntity();
            select.setId(entity.getPid());
            select.setName(entity.getWasteProcessPlaceName());
            selectlist.add(select);
        }

        return selectlist;
    }

}
