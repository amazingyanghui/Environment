package com.tengdi.environmentalprotectionint.modules.cominfo.service.impl;

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

import com.tengdi.environmentalprotectionint.modules.cominfo.dao.CominfoCentralizedSewageDao;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoCentralizedSewageEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoCentralizedSewageService;



@Service("cominfoCentralizedSewageService")
public class CominfoCentralizedSewageServiceImpl extends ServiceImpl<CominfoCentralizedSewageDao, CominfoCentralizedSewageEntity> implements CominfoCentralizedSewageService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String cominfoCentralizedSewageName = (String)params.get("cominfoCentralizedSewageName");
        Page<CominfoCentralizedSewageEntity> page = this.selectPage(
                new Query<CominfoCentralizedSewageEntity>(params).getPage(),
                new EntityWrapper<CominfoCentralizedSewageEntity>()
                        .like(StringUtils.isNotBlank(cominfoCentralizedSewageName),"cominfoCentralizedSewageName", cominfoCentralizedSewageName)
        );

        return new PageUtils(page);
    }

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
