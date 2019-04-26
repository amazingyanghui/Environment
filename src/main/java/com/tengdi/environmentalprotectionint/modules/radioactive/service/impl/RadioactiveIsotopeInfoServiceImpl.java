package com.tengdi.environmentalprotectionint.modules.radioactive.service.impl;

import com.tengdi.environmentalprotectionint.modules.radioactive.entity.RadioactiveIsotopeInfoEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;
import com.tengdi.environmentalprotectionint.modules.radioactive.dao.RadioactiveIsotopeInfoDao;
import com.tengdi.environmentalprotectionint.modules.radioactive.service.RadioactiveIsotopeInfoService;


@Service("radioactiveIsotopeInfoService")
public class RadioactiveIsotopeInfoServiceImpl extends ServiceImpl<RadioactiveIsotopeInfoDao, RadioactiveIsotopeInfoEntity> implements RadioactiveIsotopeInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        int page =Integer.parseInt((String)params.get("page"));
        int limit =Integer.parseInt((String)params.get("limit"));
        Query query = new Query(params);
        List<RadioactiveIsotopeInfoEntity> list =baseMapper.queryPage(query);
        int totalCount =baseMapper.queryPagesum(params);
        return new PageUtils(list,totalCount,limit,page);
    }

    @Override
    public List<RadioactiveIsotopeInfoEntity> queryList(Map<String, Object> params) {
        return baseMapper.queryPage(params);
    }

    @Override
    public List<RadioactiveIsotopeInfoEntity> dataById(String cid) {
        return baseMapper.dataById(cid);
    }

    @Override
    public List<RadioactiveIsotopeInfoEntity> queryName(Map<String, Object> params) {
        return baseMapper.queryName(params);
    }

}
