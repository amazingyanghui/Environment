package com.tengdi.environmentalprotectionint.modules.task.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("checkrecord")
public class CheckRecord {
    @TableId
    private Integer rid;
    private Integer checktype;
    private String companyName;
    private String companyAddress;
    private String registeredAddress;
    private String chargePerson;
    private String chargePersonpost;
    private String personNumber;
    private String productionState;
    private String commisSioningTime;
    private String signingTime;
    private Integer pollutantType;
    private Integer enterpriseTrocedures;
    private Integer drainagediRection;
    private Integer treatmentFacilities;
    private Integer efflux;
    private String waterRemark;
    private Integer gasTreatment;
    private Integer siteconditions;
    private String gasRemark;
    private Integer wastestorage;
    private Integer hazardouStorage;
    private Integer warehouse;
    private Integer ledger;
    private Integer noise;
    private Integer canteen;
    private Integer dormitory;
    private Integer protectionFacilitie;
    private Integer complaint;
    private String complaintRemark;
    private Integer conclusion;
    private String rectification;
    private String taskid;

    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getChecktype() {
        return checktype;
    }

    public void setChecktype(Integer checktype) {
        this.checktype = checktype;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getRegisteredAddress() {
        return registeredAddress;
    }

    public void setRegisteredAddress(String registeredAddress) {
        this.registeredAddress = registeredAddress;
    }

    public String getChargePerson() {
        return chargePerson;
    }

    public void setChargePerson(String chargePerson) {
        this.chargePerson = chargePerson;
    }

    public String getChargePersonpost() {
        return chargePersonpost;
    }

    public void setChargePersonpost(String chargePersonpost) {
        this.chargePersonpost = chargePersonpost;
    }

    public String getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(String personNumber) {
        this.personNumber = personNumber;
    }

    public String getProductionState() {
        return productionState;
    }

    public void setProductionState(String productionState) {
        this.productionState = productionState;
    }

    public String getCommisSioningTime() {
        return commisSioningTime;
    }

    public void setCommisSioningTime(String commisSioningTime) {
        this.commisSioningTime = commisSioningTime;
    }

    public String getSigningTime() {
        return signingTime;
    }

    public void setSigningTime(String signingTime) {
        this.signingTime = signingTime;
    }

    public Integer getPollutantType() {
        return pollutantType;
    }

    public void setPollutantType(Integer pollutantType) {
        this.pollutantType = pollutantType;
    }

    public Integer getEnterpriseTrocedures() {
        return enterpriseTrocedures;
    }

    public void setEnterpriseTrocedures(Integer enterpriseTrocedures) {
        this.enterpriseTrocedures = enterpriseTrocedures;
    }

    public Integer getDrainagediRection() {
        return drainagediRection;
    }

    public void setDrainagediRection(Integer drainagediRection) {
        this.drainagediRection = drainagediRection;
    }

    public Integer getTreatmentFacilities() {
        return treatmentFacilities;
    }

    public void setTreatmentFacilities(Integer treatmentFacilities) {
        this.treatmentFacilities = treatmentFacilities;
    }

    public Integer getEfflux() {
        return efflux;
    }

    public void setEfflux(Integer efflux) {
        this.efflux = efflux;
    }

    public String getWaterRemark() {
        return waterRemark;
    }

    public void setWaterRemark(String waterRemark) {
        this.waterRemark = waterRemark;
    }

    public Integer getGasTreatment() {
        return gasTreatment;
    }

    public void setGasTreatment(Integer gasTreatment) {
        this.gasTreatment = gasTreatment;
    }

    public Integer getSiteconditions() {
        return siteconditions;
    }

    public void setSiteconditions(Integer siteconditions) {
        this.siteconditions = siteconditions;
    }

    public String getGasRemark() {
        return gasRemark;
    }

    public void setGasRemark(String gasRemark) {
        this.gasRemark = gasRemark;
    }

    public Integer getWastestorage() {
        return wastestorage;
    }

    public void setWastestorage(Integer wastestorage) {
        this.wastestorage = wastestorage;
    }

    public Integer getHazardouStorage() {
        return hazardouStorage;
    }

    public void setHazardouStorage(Integer hazardouStorage) {
        this.hazardouStorage = hazardouStorage;
    }

    public Integer getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Integer warehouse) {
        this.warehouse = warehouse;
    }

    public Integer getLedger() {
        return ledger;
    }

    public void setLedger(Integer ledger) {
        this.ledger = ledger;
    }

    public Integer getNoise() {
        return noise;
    }

    public void setNoise(Integer noise) {
        this.noise = noise;
    }

    public Integer getCanteen() {
        return canteen;
    }

    public void setCanteen(Integer canteen) {
        this.canteen = canteen;
    }

    public Integer getDormitory() {
        return dormitory;
    }

    public void setDormitory(Integer dormitory) {
        this.dormitory = dormitory;
    }

    public Integer getProtectionFacilitie() {
        return protectionFacilitie;
    }

    public void setProtectionFacilitie(Integer protectionFacilitie) {
        this.protectionFacilitie = protectionFacilitie;
    }

    public Integer getComplaint() {
        return complaint;
    }

    public void setComplaint(Integer complaint) {
        this.complaint = complaint;
    }

    public String getComplaintRemark() {
        return complaintRemark;
    }

    public void setComplaintRemark(String complaintRemark) {
        this.complaintRemark = complaintRemark;
    }

    public Integer getConclusion() {
        return conclusion;
    }

    public void setConclusion(Integer conclusion) {
        this.conclusion = conclusion;
    }

    public String getRectification() {
        return rectification;
    }

    public void setRectification(String rectification) {
        this.rectification = rectification;
    }

    public CheckRecord() {
    }

    public CheckRecord(Integer rid, Integer checktype, String companyName, String companyAddress, String registeredAddress, String chargePerson, String chargePersonpost, String personNumber, String productionState, String commisSioningTime, String signingTime, Integer pollutantType, Integer enterpriseTrocedures, Integer drainagediRection, Integer treatmentFacilities, Integer efflux, String waterRemark, Integer gasTreatment, Integer siteconditions, String gasRemark, Integer wastestorage, Integer hazardouStorage, Integer warehouse, Integer ledger, Integer noise, Integer canteen, Integer dormitory, Integer protectionFacilitie, Integer complaint, String complaintRemark, Integer conclusion, String rectification) {
        this.rid = rid;
        this.checktype = checktype;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.registeredAddress = registeredAddress;
        this.chargePerson = chargePerson;
        this.chargePersonpost = chargePersonpost;
        this.personNumber = personNumber;
        this.productionState = productionState;
        this.commisSioningTime = commisSioningTime;
        this.signingTime = signingTime;
        this.pollutantType = pollutantType;
        this.enterpriseTrocedures = enterpriseTrocedures;
        this.drainagediRection = drainagediRection;
        this.treatmentFacilities = treatmentFacilities;
        this.efflux = efflux;
        this.waterRemark = waterRemark;
        this.gasTreatment = gasTreatment;
        this.siteconditions = siteconditions;
        this.gasRemark = gasRemark;
        this.wastestorage = wastestorage;
        this.hazardouStorage = hazardouStorage;
        this.warehouse = warehouse;
        this.ledger = ledger;
        this.noise = noise;
        this.canteen = canteen;
        this.dormitory = dormitory;
        this.protectionFacilitie = protectionFacilitie;
        this.complaint = complaint;
        this.complaintRemark = complaintRemark;
        this.conclusion = conclusion;
        this.rectification = rectification;
    }
}
