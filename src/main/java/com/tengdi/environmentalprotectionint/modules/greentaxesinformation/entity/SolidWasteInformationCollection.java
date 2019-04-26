package com.tengdi.environmentalprotectionint.modules.greentaxesinformation.entity;

import com.tengdi.environmentalprotectionint.modules.greentax.entity.EpSolidWasteClientEntity;
import com.tengdi.environmentalprotectionint.modules.greentax.entity.EpSolidWasteMainEntity;
import com.tengdi.environmentalprotectionint.modules.greentax.entity.EpSolidWasteMeasuresEntity;

import java.io.Serializable;
import java.util.List;

/**
 * 固体废物基础信息采集
 *
 * @author tengdi
 * @email
 * @date 2019-03-04 11:14:18
 */
public class SolidWasteInformationCollection implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 所在行政区划
     */
    private String localCity;
    /**
     * 所在街道乡镇
     */
    private String streetOrTown;

    /**
     * 固废表单创建者，也是当前登录用户的企业名
     */
    private String createName;
    /**
     * 固体废物基础信息采集主表
     */
    private EpSolidWasteMainEntity epSolidWasteMainEntity;

    /**
     * 接受或委托方
     */
    private EpSolidWasteClientEntity epSolidWasteClientEntities;


    /**
     * 固体废物基础信息采集-污染防治措施表
     */
    private List<EpSolidWasteMeasuresEntity> list;

    public EpSolidWasteMainEntity getEpSolidWasteMainEntity() {
        return epSolidWasteMainEntity;
    }

    public void setEpSolidWasteMainEntity(EpSolidWasteMainEntity epSolidWasteMainEntity) {
        this.epSolidWasteMainEntity = epSolidWasteMainEntity;
    }


    public EpSolidWasteClientEntity getEpSolidWasteClientEntities() {
        return epSolidWasteClientEntities;
    }

    public void setEpSolidWasteClientEntities(EpSolidWasteClientEntity epSolidWasteClientEntities) {
        this.epSolidWasteClientEntities = epSolidWasteClientEntities;
    }

    public List<EpSolidWasteMeasuresEntity> getList() {
        return list;
    }

    public void setList(List<EpSolidWasteMeasuresEntity> list) {
        this.list = list;
    }

    public String getLocalCity() {
        return localCity;
    }

    public void setLocalCity(String localCity) {
        this.localCity = localCity;
    }

    public String getStreetOrTown() {
        return streetOrTown;
    }

    public void setStreetOrTown(String streetOrTown) {
        this.streetOrTown = streetOrTown;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }
}
