var environmentalAttributes={
    editWin:function (admin,setter,$,form,baseurl,laytpl,laydate,element,differType,global_obj,pid) {

        //噪声功能区级别
        var noiseTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/noise_level_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,noiseLevel = document.getElementById('noiseLevel');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        noiseLevel.innerHTML = html;
                        if(data.noiseLevel!=null&data.noiseLevel!==''){
                            $("#noiseLevel").val(data.noiseLevel);
                        }else{
                            $("#noiseLevel").val("");
                        }
                    });
                    form.render(null, 'component-form-element');
                    showOrHide();
                }
            });
        };

        //水域功能区级别
        var waterTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/water_level_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,waterLevel = document.getElementById('waterLevel');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        waterLevel.innerHTML = html;
                        if(data.waterLevel!=null&data.waterLevel!==''){
                            $("#waterLevel").val(data.waterLevel);
                        }else{
                            $("#waterLevel").val("");
                        }
                    });
                    form.render(null, 'component-form-element');
                    showOrHide();
                }
            });
        };

        //空气功能区级别
        var airTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/air_level_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,airLevel = document.getElementById('airLevel');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        airLevel.innerHTML = html;
                        if(data.airLevel!=null&data.airLevel!==''){
                            $("#airLevel").val(data.airLevel);
                        }else{
                            $("#airLevel").val("");
                        }
                    });
                    form.render(null, 'component-form-element');
                    showOrHide();
                }
            });
        };

        //海域功能区级别
        var seaTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/sea_level_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,seaLevel = document.getElementById('seaLevel');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        seaLevel.innerHTML = html;
                        if(data.seaLevel!=null&data.seaLevel!==''){
                            $("#seaLevel").val(data.seaLevel);
                        }else{
                            $("#seaLevel").val("");
                        }
                    });
                    form.render(null, 'component-form-element');
                    showOrHide();
                }
            });
        };

        //监控年份
        var yearTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/regulatory_year_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,regulatoryYear = document.getElementById('regulatoryYear');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        regulatoryYear.innerHTML = html;
                        if(data.regulatoryYear!=null&data.regulatoryYear!==''){
                            $("#regulatoryYear").val(data.regulatoryYear);
                        }else{
                            $("#regulatoryYear").val("");
                        }
                    });
                    form.render(null, 'component-form-element');
                    yearAndLevel();
                    showOrHide();
                }
            });
        };

        //监控级别
        var levelTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/regulatory_level_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,regulatoryLevel = document.getElementById('regulatoryLevel');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        regulatoryLevel.innerHTML = html;
                        if(data.regulatoryLevel!=null&data.regulatoryLevel!==''){
                            $("#regulatoryLevel").val(data.regulatoryLevel);
                        }else{
                            $("#regulatoryLevel").val("");
                        }
                    });
                    form.render(null, 'component-form-element');
                    yearAndLevel();
                    showOrHide();
                }
            });
        };

        //污染源信用评价等级
        var evaluationTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/credit_evaluation_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,creditEvaluation = document.getElementById('creditEvaluation');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        creditEvaluation.innerHTML = html;
                        if(data.creditEvaluation!=null&data.creditEvaluation!==''){
                            $("#creditEvaluation").val(data.creditEvaluation);
                        }else{
                            $("#creditEvaluation").val("");
                        }
                    });
                    form.render(null, 'component-form-element');
                    yearAndLevel();
                    showOrHide();
                }
            });
        };

        //污染源标签
        var sourceLabelTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/source_label_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,sourceLabel = document.getElementById('sourceLabel');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        sourceLabel.innerHTML = html;
                        if(data.sourceLabel!=null&data.sourceLabel!==''){
                            $("#sourceLabel").val(data.sourceLabel);
                        }else{
                            $("#sourceLabel").val("");
                        }
                    });
                    form.render(null, 'component-form-element');
                    yearAndLevel();
                    showOrHide();
                }
            });
        };
        //污染源标签
        var riskRatingTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/risk_rating"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,riskRating = document.getElementById('riskRating');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        riskRating.innerHTML = html;
                        if(data.riskRating!=null&data.riskRating!==''){
                            $("#riskRating").val(data.riskRating);
                        }else{
                            $("#riskRating").val("");
                        }
                    });
                    form.render(null, 'component-form-element');
                    showOrHide();
                }
            });
        };

        //是否下拉框
        var booleanTpl=function (data) {
            global_obj.booleanList = [];//创建字典对象
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/boolean_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML;
                    if(differType==1){
                        var waterSourceArea = document.getElementById('waterSourceArea')
                            ,sotwoArea = document.getElementById('sotwoArea')
                            ,acidRainArea = document.getElementById('acidRainArea');

                    }
                    if(differType==0){
                        var keySource = document.getElementById('keySource')
                            ,riskSource = document.getElementById('riskSource')
                            ,sewagePlant = document.getElementById('sewagePlant')
                            ,wasteWater = document.getElementById('wasteWater')
                            ,emissionEnterprises = document.getElementById('emissionEnterprises')
                            ,vocEnterprises = document.getElementById('vocEnterprises')
                            ,sourceUnit = document.getElementById('sourceUnit')
                            ,heavyMetal = document.getElementById('heavyMetal')
                            ,cleanerProduction = document.getElementById('cleanerProduction')
                            ,environmentalStatistics = document.getElementById('environmentalStatistics')
                            ,onlineMonitoring = document.getElementById('onlineMonitoring')
                            ,dischargeFee = document.getElementById('dischargeFee')
                            ,emissionDeclaration = document.getElementById('emissionDeclaration')
                            ,wasteManagement = document.getElementById('wasteManagement')
                            ,wasteGeneration = document.getElementById('wasteGeneration')
                            ,thirtykwCompany = document.getElementById('thirtykwCompany')
                            ,randomCheck = document.getElementById('randomCheck')
                            ,specialSource = document.getElementById('specialSource')
                            ,isiso = document.getElementById('isiso')
                            ,cancelManagement = document.getElementById('cancelManagement')
                            ,isSampling = document.getElementById('isSampling')
                            ,isOceaneering = document.getElementById('isOceaneering')
                            ,isBoilerOrGasTurbine = document.getElementById('isBoilerOrGasTurbine')
                            ,isIndustrialFurnace = document.getElementById('isIndustrialFurnace')
                            ,isCokingProcess = document.getElementById('isCokingProcess')
                            ,isSinterOrpelletizProcess = document.getElementById('isSinterOrpelletizProcess')
                            ,isIronmakingProcess = document.getElementById('isIronmakingProcess')
                            ,isSteelmakingProcess = document.getElementById('isSteelmakingProcess')
                            ,isClinkerProduction = document.getElementById('isClinkerProduction')
                            ,isPetrochemicalEnterprises = document.getElementById('isPetrochemicalEnterprises')
                            ,isOrganicLiquidTankOrLoad = document.getElementById('isOrganicLiquidTankOrLoad')
                            ,isContainOrganicMaterialUse = document.getElementById('isContainOrganicMaterialUse')
                            ,isSolidMaterialStorage = document.getElementById('isSolidMaterialStorage')
                            ,isOtherWasteGasProduction = document.getElementById('isOtherWasteGasProduction')
                            ,isGeneralIndustrialSolidWaste = document.getElementById('isGeneralIndustrialSolidWaste')
                            ,isInvolvingMinerals = document.getElementById('isInvolvingMinerals')
                            ,isGrantDischargePermit = document.getElementById('isGrantDischargePermit')
                        ;
                    }
                    laytpl(getDictTpl).render(result.dicts, function(html){

                        if(differType==1){
                            waterSourceArea.innerHTML = html;
                            sotwoArea.innerHTML = html;
                            acidRainArea.innerHTML = html;
                            $("#waterSourceArea").val(data.waterSourceArea);
                            $("#sotwoArea").val(data.sotwoArea);
                            $("#acidRainArea").val(data.acidRainArea);
                        }
                        if(differType==0){
                            keySource.innerHTML = html;
                            riskSource.innerHTML = html;
                            sewagePlant.innerHTML = html;
                            wasteWater.innerHTML = html;
                            emissionEnterprises.innerHTML = html;
                            vocEnterprises.innerHTML=html;
                            sourceUnit.innerHTML = html;
                            heavyMetal.innerHTML = html;
                            cleanerProduction.innerHTML = html;
                            environmentalStatistics.innerHTML = html;
                            onlineMonitoring.innerHTML = html;
                            dischargeFee.innerHTML = html;
                            emissionDeclaration.innerHTML = html;
                            wasteManagement.innerHTML = html;
                            wasteGeneration.innerHTML=html;
                            thirtykwCompany.innerHTML = html;
                            randomCheck.innerHTML = html;
                            specialSource.innerHTML = html;
                            isiso.innerHTML = html;
                            cancelManagement.innerHTML = html;
                            isSampling.innerHTML = html;
                            isOceaneering.innerHTML = html;
                            isBoilerOrGasTurbine.innerHTML = html;
                            isIndustrialFurnace.innerHTML = html;
                            isCokingProcess.innerHTML = html;
                            isSinterOrpelletizProcess.innerHTML = html;
                            isIronmakingProcess.innerHTML = html;
                            isSteelmakingProcess.innerHTML = html;
                            isClinkerProduction.innerHTML = html;
                            isPetrochemicalEnterprises.innerHTML = html;
                            isOrganicLiquidTankOrLoad.innerHTML = html;
                            isContainOrganicMaterialUse.innerHTML = html;
                            isSolidMaterialStorage.innerHTML = html;
                            isOtherWasteGasProduction.innerHTML = html;
                            isGeneralIndustrialSolidWaste.innerHTML = html;
                            isInvolvingMinerals.innerHTML = html;
                            isGrantDischargePermit.innerHTML = html;
                            $("#keySource").val(data.keySource);
                            $("#riskSource").val(data.riskSource);
                            $("#sewagePlant").val(data.sewagePlant);
                            $("#wasteWater").val(data.wasteWater);
                            $("#emissionEnterprises").val(data.emissionEnterprises);
                            $("#vocEnterprises").val(data.vocEnterprises);
                            $("#sourceUnit").val(data.sourceUnit);
                            $("#heavyMetal").val(data.heavyMetal);
                            $("#cleanerProduction").val(data.cleanerProduction);
                            $("#environmentalStatistics").val(data.environmentalStatistics);
                            $("#onlineMonitoring").val(data.onlineMonitoring);
                            $("#dischargeFee").val(data.dischargeFee);
                            $("#emissionDeclaration").val(data.emissionDeclaration);
                            $("#wasteManagement").val(data.wasteManagement);
                            $("#wasteGeneration").val(data.wasteGeneration);
                            $("#thirtykwCompany").val(data.thirtykwCompany);
                            $("#randomCheck").val(data.randomCheck);
                            $("#specialSource").val(data.specialSource);
                            $("#cancelManagement").val(data.cancelManagement);
                            $("#isSampling").val(data.isSampling);
                            $("#isOceaneering").val(data.isOceaneering);
                            $("#isIndustrialFurnace").val(data.isIndustrialFurnace);
                            $("#isCokingProcess").val(data.isCokingProcess);
                            $("#isSinterOrpelletizProcess").val(data.isSinterOrpelletizProcess);
                            $("#isIronmakingProcess").val(data.isIronmakingProcess);
                            $("#isSteelmakingProcess").val(data.isSteelmakingProcess);
                            $("#isClinkerProduction").val(data.isClinkerProduction);
                            $("#isPetrochemicalEnterprises").val(data.isPetrochemicalEnterprises);
                            $("#isOrganicLiquidTankOrLoad").val(data.isOrganicLiquidTankOrLoad);
                            $("#isContainOrganicMaterialUse").val(data.isContainOrganicMaterialUse);
                            $("#isSolidMaterialStorage").val(data.isSolidMaterialStorage);
                            $("#isOtherWasteGasProduction").val(data.isOtherWasteGasProduction);
                            $("#isGeneralIndustrialSolidWaste").val(data.isGeneralIndustrialSolidWaste);
                            $("#isInvolvingMinerals").val(data.isInvolvingMinerals);
                            $("#isGrantDischargePermit").val(data.isGrantDischargePermit);
                            $("#isBoilerOrGasTurbine").val(data.isBoilerOrGasTurbine);
                            $("#isiso").val(data.isiso);
                        }
                    });
                    form.render(null, 'component-form-element');
                    yearAndLevel();
                    showOrHide();
                }
            });
        };

        admin.req({//根据id获取该记录的详细信息
            url: baseurl + "/" + pid
            ,done: function(result){
                if(result.code == 0){//成功
                    //数据为空占位
                    var cominfoEnvironmental=result.cominfoEnvironmental;
                    if(cominfoEnvironmental==null){
                        cominfoEnvironmental=1;
                    }
                    var getBaseInfo = editcominfoEnvironmentalAttributes.innerHTML;
                    if(differType==0){
                        getBaseInfo = editcominfoEnvironmentalManage.innerHTML;
                    }
                    var laboratorytechnician = document.getElementById('LAY-market-cominfoEnvironmentalAttributes'+differType);
                    laytpl(getBaseInfo).render(cominfoEnvironmental, function(html){
                        laboratorytechnician.innerHTML = html;
                        booleanTpl(cominfoEnvironmental);
                        if(differType==1){
                            noiseTpl(cominfoEnvironmental);
                            waterTpl(cominfoEnvironmental);
                            airTpl(cominfoEnvironmental);
                            seaTpl(cominfoEnvironmental);
                        }
                        if(differType==0){
                            evaluationTpl(cominfoEnvironmental);
                            sourceLabelTpl(cominfoEnvironmental);
                            riskRatingTpl(cominfoEnvironmental);
                            yearTpl(cominfoEnvironmental);
                            levelTpl(cominfoEnvironmental);
                        }
                    });
                    form.render(null, 'component-form-element');
                    yearAndLevel();
                    showOrHide();
                }else{
                    layer.alert(result.msg, {
                        skin: 'layui-layer-lan',
                        offset: 't',
                        anim: 6
                    });
                }
            }
        });
        function yearAndLevel() {
            // $("#yearAndLevel .layui-form-select:eq(0)").attr("style","width: 100px;display: inline-block;float: left;");
            // $("#yearAndLevel .layui-form-select:eq(1)").attr("style","width: 100px;display: inline-block;");
        }
        function showOrHide() {
            if(layui.data(setter.userRoles).userRoles.indexOf(setter.companyRoleId) !== -1){
                $("#aCite").text("企业维护");
                $("#aCite").attr("lay-href","cominfo/baseinfo/index");
                // $("#cite").addClass("layui-hide");
                // $("#cite+span").addClass("layui-hide");
            }
        }

    }
};
