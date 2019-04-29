var emergencysystem={
    editWin:function (admin,setter,$,table,form,baseurl,laytpl,laydate,element,differType,global_obj,pid,getBaseInfo,baseInfoAttachment) {
        var showAndHide=function () {
            $("#emergencysystem0").removeClass("layui-hide");
            $("#emergencysystem1").removeClass("layui-hide");
            $("#emergencysystem2").removeClass("layui-hide");
            $("#emergencysystem3").removeClass("layui-hide");
            $("#emergencysystem4").removeClass("layui-hide");
            $("#emergencysystem5").removeClass("layui-hide");
            $("#emergencysystem6").removeClass("layui-hide");
            $("#emergencysystem7").removeClass("layui-hide");
            $("#emergencyEmergencysystem0").addClass("layui-hide");
            $("#emergencyEmergencysystem1").addClass("layui-hide");
            $("#emergencyEmergencysystem2").addClass("layui-hide");
            $("#emergencyEmergencysystem3").addClass("layui-hide");
            $("#emergencyEmergencysystem4").addClass("layui-hide");
            $("#emergencyEmergencysystem5").addClass("layui-hide");
            $("#emergencyEmergencysystem6").addClass("layui-hide");
            $("#emergencyEmergencysystem7").addClass("layui-hide");
            $("#add").removeClass("layui-hide");
            $("#mod").removeClass("layui-hide");
            $("#del").removeClass("layui-hide");
        };

        //危险属性下拉框
        var dangerousTypeTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/dangerous_type_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,dangerousType = document.getElementById('dangerousType');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        dangerousType.innerHTML = html;
                        if(data.dangerousType!=null&data.dangerousType!==''){
                            $("#dangerousType").val(data.dangerousType);
                        }
                    });
                    form.render(null, 'component-form-element');
                }
            });
        };

        //物资类型下拉框
        var suppliesTypeTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/supplies_type_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,suppliesType = document.getElementById('suppliesType');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        suppliesType.innerHTML = html;
                        if(data.suppliesType!=null&data.suppliesType!==''){
                            $("#suppliesType").val(data.suppliesType);
                        }
                    });
                    form.render(null, 'component-form-element');
                }
            });
        };

        //预案类型下拉框
        var planTypeTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/plan_type_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,planType = document.getElementById('planType');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        planType.innerHTML = html;
                        if(data.planType!=null&data.planType!==''){
                            $("#planType").val(data.planType);
                        }
                    });
                    form.render(null, 'component-form-element');
                }
            });
        };

        //预案状态下拉框
        var planStatusTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/plan_status_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,planStatus = document.getElementById('planStatus');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        planStatus.innerHTML = html;
                        if(data.status!=null&data.status!==''){
                            $("#planStatus").val(data.status);
                        }
                    });
                    form.render(null, 'component-form-element');
                }
            });
        };

        //演练类型下拉框
        var drillTypeTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/drill_type_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,drillType = document.getElementById('drillType');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        drillType.innerHTML = html;
                        if(data.drillType!=null&data.drillType!==''){
                            $("#drillType").val(data.drillType);
                        }
                    });
                    form.render(null, 'component-form-element');
                }
            });
        };

        //事件等级下拉框
        var eventLevelTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/event_level_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,eventLevel = document.getElementById('eventLevel');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        eventLevel.innerHTML = html;
                        if(data.eventLevel!=null&data.eventLevel!==''){
                            $("#eventLevel").val(data.eventLevel);
                        }
                    });
                    form.render(null, 'component-form-element');
                }
            });
        };

        //性别下拉框
        var sexTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/sex_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,sex = document.getElementById('sex');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        sex.innerHTML = html;
                        if(data.sex!=null&data.sex!==''){
                            $("#sex").val(data.sex);
                        }
                    });
                    form.render(null, 'component-form-element');
                }
            });
        };

        //处置状态下拉框
        var disposalStatusTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/disposal_status_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,disposalstatus = document.getElementById('disposalstatus');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        disposalstatus.innerHTML = html;
                        if(data.disposalstatus!=null&data.disposalstatus!==''){
                            $("#disposalstatus").val(data.disposalstatus);
                        }
                    });
                    form.render(null, 'component-form-element');
                }
            });
        };

        //污染程度下拉框
        var pollutionLevelTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/pollution_level_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,pollutionlevel = document.getElementById('pollutionlevel');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        pollutionlevel.innerHTML = html;
                        if(data.pollutionlevel!=null&data.pollutionlevel!==''){
                            $("#pollutionlevel").val(data.pollutionlevel);
                        }
                    });
                    form.render(null, 'component-form-element');
                }
            });
        };

        //风险防范措施相关下拉 start
        //围堰
        var cofferdamTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/haveOrNot_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,cofferdam = document.getElementById('cofferdam');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        cofferdam.innerHTML = html;
                        if(data.cofferdam!=null&data.cofferdam!==''){
                            $("#cofferdam").val(data.cofferdam);
                        }
                    });
                    form.render(null, 'component-form-element');
                }
            });
        };

        //专用排泄沟
        var specialDrainageDitchTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/haveOrNot_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,specialDrainageDitch = document.getElementById('specialDrainageDitch');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        specialDrainageDitch.innerHTML = html;
                        if(data.specialDrainageDitch!=null&data.specialDrainageDitch!==''){
                            $("#specialDrainageDitch").val(data.specialDrainageDitch);
                        }
                    });
                    form.render(null, 'component-form-element');
                }
            });
        };

        //地面防渗
        var groundSeepageControlTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/haveOrNot_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,groundSeepageControl = document.getElementById('groundSeepageControl');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        groundSeepageControl.innerHTML = html;
                        if(data.groundSeepageControl!=null&data.groundSeepageControl!==''){
                            $("#groundSeepageControl").val(data.groundSeepageControl);
                        }
                    });
                    form.render(null, 'component-form-element');
                }
            });
        };

        //气/液体泄漏侦测(
        var leakDetectionTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/haveOrNot_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,leakDetection = document.getElementById('leakDetection');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        leakDetection.innerHTML = html;
                        if(data.leakDetection!=null&data.leakDetection!==''){
                            $("#leakDetection").val(data.leakDetection);
                        }
                    });
                    form.render(null, 'component-form-element');
                }
            });
        };

        //报警系统是否接入远程监控网
        var isRemoteMonitorTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/haveOrNot_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,isRemoteMonitor = document.getElementById('isRemoteMonitor');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        isRemoteMonitor.innerHTML = html;
                        if(data.isRemoteMonitor!=null&data.isRemoteMonitor!==''){
                            $("#isRemoteMonitor").val(data.isRemoteMonitor);
                        }
                    });
                    form.render(null, 'component-form-element');
                }
            });
        };

        //事故应急池
        var emergencyPoolTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/haveOrNot_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,emergencyPool = document.getElementById('emergencyPool');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        emergencyPool.innerHTML = html;
                        if(data.emergencyPool!=null&data.emergencyPool!==''){
                            $("#emergencyPool").val(data.emergencyPool);
                        }
                    });
                    form.render(null, 'component-form-element');
                }
            });
        };

        //清净下水排放切换阀门
        var isChangeValveTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/haveOrNot_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,isChangeValve = document.getElementById('isChangeValve');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        isChangeValve.innerHTML = html;
                        if(data.isChangeValve!=null&data.isChangeValve!==''){
                            $("#isChangeValve").val(data.isChangeValve);
                        }
                    });
                    form.render(null, 'component-form-element');
                }
            });
        };

        //清净下水排水缓冲池
        var isBufferPoolTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/haveOrNot_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,isBufferPool = document.getElementById('isBufferPool');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        isBufferPool.innerHTML = html;
                        if(data.isBufferPool!=null&data.isBufferPool!==''){
                            $("#isBufferPool").val(data.isBufferPool);
                        }
                    });
                    form.render(null, 'component-form-element');
                }
            });
        };

        //风险特征
        var riskProfilesTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/riskProfiles_type  "
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,riskProfiles = document.getElementById('riskProfiles');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        riskProfiles.innerHTML = html;
                        if(data.riskProfiles!=null&data.riskProfiles!==''){
                            $("#riskProfiles").val(data.riskProfiles);
                        }
                    });
                    form.render(null, 'component-form-element');
                }
            });
        };

        //事故废水排放去向
        var fateTypeTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/fate_type  "
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,fateType = document.getElementById('fateType');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        fateType.innerHTML = html;
                        if(data.fateType!=null&data.fateType!==''){
                            $("#fateType").val(data.fateType);
                        }
                    });
                    form.render(null, 'component-form-element');
                }
            });
        };

        //毒性气体泄漏监控预警措施
        var gasLeakMonitorwarningMeasuresTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/gasLeakMonitorwarningMeasures_type  "
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,gasLeakMonitorwarningMeasures = document.getElementById('gasLeakMonitorwarningMeasures');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        gasLeakMonitorwarningMeasures.innerHTML = html;
                        if(data.gasLeakMonitorwarningMeasures!=null&data.gasLeakMonitorwarningMeasures!==''){
                            $("#gasLeakMonitorwarningMeasures").val(data.gasLeakMonitorwarningMeasures);
                        }
                    });
                    form.render(null, 'component-form-element');
                }
            });
        };

        //依法获取污水排入排水管网许可
        var productionWastewaterPreventionMeasuresTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/boolean_type  "
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,productionWastewaterPreventionMeasures = document.getElementById('productionWastewaterPreventionMeasures');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        productionWastewaterPreventionMeasures.innerHTML = html;
                        if(data.productionWastewaterPreventionMeasures!=null&data.productionWastewaterPreventionMeasures!==''){
                            $("#productionWastewaterPreventionMeasures").val(data.productionWastewaterPreventionMeasures);
                        }
                    });
                    form.render(null, 'component-form-element');
                }
            });
        };

        //厂内危险废物环境管理
        var environmentalManagementTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/environmentalManagement_type  "
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,environmentalManagement = document.getElementById('environmentalManagement');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        environmentalManagement.innerHTML = html;
                        if(data.environmentalManagement!=null&data.environmentalManagement!==''){
                            $("#environmentalManagement").val(data.environmentalManagement);
                        }
                    });
                    form.render(null, 'component-form-element');
                }
            });
        };

        //风险防范措施下拉相关 end

        var afterLoad = function(data){
            //需要占位，否则为空没法渲染
            var laboratorytechnician = document.getElementById('emergencyEmergencysystem'+differType);
            laytpl(getBaseInfo).render(data, function(html){
                laboratorytechnician.innerHTML = html;
            });
            $("[name='emergencyHome"+differType+"']").on("click",function () {
                showAndHide();
                table.reload("LAY-emergency-emergencysystem"+differType); //刷新表格
            });
            if(differType==0){
                suppliesTypeTpl(data);
                laydate.render({
                    elem: '[name="admissibilityTime"]'
                    ,type: 'date'
                    // ,value:new Date()
                });
            }
            if(differType==1){
                $("#showPlan").removeClass("layui-hide");
                var url=setter.remoteServiceAddress + "/emergency/emergencysystemplanfile";
                if(data==1){
                    baseInfoAttachment.multiUpload("plan_div","11","",url,null,"attachment_upload_btn"+differType,"upload_file_bizcode"+differType);
                }else{
                    baseInfoAttachment.multiUpload("plan_div","11",data.pid,url,null,"attachment_upload_btn"+differType,"upload_file_bizcode"+differType);
                }
                $("#showPlan").on("click",function () {
                    $("#showPlan").addClass("layui-hide");
                    $("#showPlanInfo").removeClass("layui-hide");
                    $("#hidePlan").removeClass("layui-hide");
                });

                $("#hidePlan").on("click",function () {
                    $("#hidePlan").addClass("layui-hide");
                    $("#showPlanInfo").addClass("layui-hide");
                    $("#showPlan").removeClass("layui-hide");
                });
                planTypeTpl(data);
                planStatusTpl(data);
                laydate.render({
                    elem: '[name="recordDate"]'
                    ,type: 'date'
                    // ,value:new Date()
                });

                laydate.render({
                    elem: '[name="batchDate"]'
                    ,type: 'date'
                    // ,value:new Date()
                });
                laydate.render({
                    elem: '[name="implementationTime"]'
                    ,type: 'date'
                    // ,value:new Date()
                });
                form.render(null, 'component-form-element');
            }
            if(differType==2){
                $("#showDrill").removeClass("layui-hide");
                var url=setter.remoteServiceAddress + "/emergency/emergencysystemdrillfile";
                if(data==1){
                    baseInfoAttachment.multiUpload("drill_div","12","",url,null,"attachment_upload_btn"+differType,"upload_file_bizcode"+differType);
                }else{
                    baseInfoAttachment.multiUpload("drill_div","12",data.pid,url,null,"attachment_upload_btn"+differType,"upload_file_bizcode"+differType);
                }
                $("#showDrill").on("click",function () {
                    $("#showDrill").addClass("layui-hide");
                    $("#showDrillInfo").removeClass("layui-hide");
                    $("#hideDrill").removeClass("layui-hide");
                });

                $("#hideDrill").on("click",function () {
                    $("#hideDrill").addClass("layui-hide");
                    $("#showDrillInfo").addClass("layui-hide");
                    $("#showDrill").removeClass("layui-hide");
                });
                drillTypeTpl(data);
                laydate.render({
                    elem: '[name="drillDate"]'
                    ,type: 'date'
                    // ,value:new Date()
                });

                laydate.render({
                    elem: '[name="publishDate"]'
                    ,type: 'date'
                    // ,value:new Date()
                });

                form.render(null, 'component-form-element');
            }
            if(differType==3){
            }
            if(differType==4){

                sexTpl(data);

                laydate.render({
                    elem: '[name="birthday"]'
                    ,type: 'date'
                    // ,value:new Date()
                });

                laydate.render({
                    elem: '[name="appointmentStarttime"]'
                    ,type: 'date'
                    // ,value:new Date()
                });

                laydate.render({
                    elem: '[name="appointmentEndtime"]'
                    ,type: 'date'
                    // ,value:new Date()
                });

                form.render(null, 'component-form-element');
            }
            if(differType==5){
                laydate.render({
                    elem: '[name="occurrenceDate"]'
                    ,type: 'date'
                    // ,value:new Date()
                });
                eventLevelTpl(data);
                disposalStatusTpl(data);
                pollutionLevelTpl(data);
                form.render(null, 'component-form-element');
            }
            if(differType==6){
                dangerousTypeTpl(data);
            }
            if(differType==7){
                cofferdamTpl(data);//围堰(0无； 1有)
                specialDrainageDitchTpl(data);//专用排泄沟/管(0无1有)
                groundSeepageControlTpl(data);//地面防渗(0无1有)
                leakDetectionTpl(data);//气/液体泄漏侦测(0无;1有)
                isRemoteMonitorTpl(data);//报警系统是否接入远程监控网(0无1有)
                emergencyPoolTpl(data);//事故应急池(0无1有)
                isChangeValveTpl(data);//清净下水排放切换阀门(0无 1有)
                isBufferPoolTpl(data);//清净下水排水缓冲池(0无1有)
                riskProfilesTpl(data)//风险特征
                fateTypeTpl(data)//事故废水排放去向
                gasLeakMonitorwarningMeasuresTpl(data)//毒性气体泄漏监控预警措施
                productionWastewaterPreventionMeasuresTpl(data)//依法获取污水排入排水管网许可(0无1有)
                environmentalManagementTpl(data)//厂内危险废物环境管理

                laydate.render({
                    elem: '[name="createdate"]'
                    ,type: 'datetime'
                    // ,value:new Date()
                });
            }
            form.render(null, 'component-form-element');
        }
        if(pid!=null&pid!="undefined"){
            admin.req({//根据id获取该记录的详细信息
                url: baseurl + "/" + pid
                ,done: function(result){
                    if(result.code == 0){//成功
                        var datatemp = result.emergencySystemSupplies;

                        if(differType==1){
                            datatemp = result.emergencySystemPlan;
                        }
                        if(differType==2){
                            datatemp = result.emergencySystemDrill;
                        }
                        if(differType==3){
                            datatemp = result.emergencySystemRanks;
                        }
                        if(differType==4){
                            datatemp = result.emergencySystemExpert;
                        }
                        if(differType==5){
                            datatemp = result.emergencySystemEvent;
                        }
                        if(differType==6){
                            datatemp=result.emergencySystemDangerous;
                        }
                        if(differType==7){
                            datatemp=result.riskPreventionMeasures;
                        }
                        afterLoad(datatemp);
                    }else{
                        layer.alert(result.msg, {
                            skin: 'layui-layer-lan',
                            offset: 't',
                            anim: 6
                        });
                    }
                }
            });
        }else {
            afterLoad(1);
        }

    }
};
