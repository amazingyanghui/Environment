package com.tengdi.environmentalprotectionint.modules.penalty.dao;

import com.tengdi.environmentalprotectionint.modules.penalty.entity.AdministrativePenaltyFileEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * 处罚资料文件
 * 
 * @author tengdi
 * @email 
 * @date 2018-10-29 14:27:40
 */
public interface AdministrativePenaltyFileDao extends BaseMapper<AdministrativePenaltyFileEntity> {
    /**
     * 根据行政处罚id查附件
     * @param aid
     * @return
     */
    List<AdministrativePenaltyFileEntity> dataByFile(String aid);
}
