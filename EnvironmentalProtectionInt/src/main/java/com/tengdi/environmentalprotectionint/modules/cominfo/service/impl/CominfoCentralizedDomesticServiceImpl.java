package com.tengdi.environmentalprotectionint.modules.cominfo.service.impl;

import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineMonitorPortinfoEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.apache.commons.lang.StringUtils;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.mapper.BaseMapper;
//import com.tengdi.core.utils.BeanHump;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;
import com.tengdi.environmentalprotectionint.modules.common.entity.QueryCriterias ;
import com.tengdi.core.utils.MapUtils;

import com.tengdi.environmentalprotectionint.modules.cominfo.dao.CominfoCentralizedDomesticDao;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoCentralizedDomesticEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoCentralizedDomesticService;



@Service("cominfoCentralizedDomesticService")
public class CominfoCentralizedDomesticServiceImpl extends ServiceImpl<CominfoCentralizedDomesticDao, CominfoCentralizedDomesticEntity> implements CominfoCentralizedDomesticService {

//    @Override
//    public PageUtils queryPage(Map<String, Object> params) {
//        String cominfoCentralizedDomesticName = (String)params.get("cominfoCentralizedDomesticName");
//        Page<CominfoCentralizedDomesticEntity> page = this.selectPage(
//                new Query<CominfoCentralizedDomesticEntity>(params).getPage(),
//                new EntityWrapper<CominfoCentralizedDomesticEntity>()
//                        .like(StringUtils.isNotBlank(cominfoCentralizedDomesticName),"cominfoCentralizedDomesticName", cominfoCentralizedDomesticName)
//        );
//
//        return new PageUtils(page);
//    }

    @Override
    public PageUtils queryTableData(Map<String, Object> params) {
        Integer limit = Integer.parseInt((String)params.get("limit"));
        Integer page = Integer.parseInt((String)params.get("page"));
        Query query = new Query(params);
        List<Map<String,Object>> list = new ArrayList<>();
        int count = 0;
        list = baseMapper.queryList(query);
        count = baseMapper.queryCount(query);
        return new PageUtils(list,count,limit,page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Query query=new Query(params);
        List<CominfoCentralizedDomesticEntity> list=baseMapper.queryList(query);
        int total=baseMapper.queryCount(query);
        PageUtils page = new PageUtils(list, total, query.getLimit(), query.getCurrPage());
        return page;
    }


//
//    @Override
//    public PageUtils queryTableData(QueryCriterias criterias) {
//        Integer limit = criterias.getLimit();
//        Integer page = criterias.getPage();
//        Integer offset = (page-1) * limit;
//        criterias.setPagenumber(offset);
//        criterias.setPagesize(limit);
//        List<Map<String,Object>> list = new ArrayList<>();
//        int count = 0;
//        // 非汇总表调用普通通用查询接口
//        if (StringUtils.isEmpty(criterias.getSumCols())) {
//            list = baseMapper.queryList(criterias);
//            count = baseMapper.queryListCount(criterias);
//        }
//        //return new PageUtils(BeanHump.listUnderlineKeyToCamel(list),count,limit,page);
//    }

}
