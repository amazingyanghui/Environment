package com.tengdi.environmentalprotectionint.modules.common.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tengdi.environmentalprotectionint.modules.common.entity.ExportExcelData;
import java.util.List;
import java.util.Map;

/**
 * 项目建设审批情况
 *
 * @author tengdi
 * @email
 * @date 2018-08-22 10:03:40
 */
public interface ExportExcelDao extends BaseMapper<ExportExcelData> {

    //导出excel star
    List<Map<String,Object>> queryList(ExportExcelData criterias);

    int queryListCount(ExportExcelData criterias);

    List<Map<String,Object>> querySumList(ExportExcelData criterias);

    int querySumListCount(ExportExcelData criterias);
    //导出excel end

}
