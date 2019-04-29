var mapshow={
    getCompanyLocationForMap:function (admin,setter,$,baseurl,featureList,regulatoryLevel,companyName,global_obj) {
        var loadindex = layer.load(0);
        admin.req({//
            url: baseurl + "/queryCominfoList"
            ,data:{
                regulatoryLevel:global_obj.regulatoryLevel
                ,companyName:companyName
                ,wasteType:global_obj.wasteType
                ,creditEvaluation:global_obj.creditEvaluation
                ,otherCondition:global_obj.otherCondition

            }
            , done: function (result) {
                BaiduMap.addPointsInMap(admin,setter,$,result.data,featureList,0);
                layer.close(loadindex);
                if(global_obj.differType>=0){
                    var resultDiv = "";
                    if(BaiduMap.map_level == 0){
                        if ($("#resultDivOnline")) {
                            $("#resultDivOnline").empty();
                            $("#resultDivOnline").remove();
                        }
                        resultDiv = $("<div>").attr("id", "resultDivOnline").addClass("resultDivOnline").css({height: '' + ($("#LAY_app_body").height() - 80) + ''});
                        $("#searchResultDivOnline").append(resultDiv);
                    }else {//公司
                        if($("#resultDiv")){
                            $("#resultDiv").empty();
                            $("#resultDiv").remove();
                        }
                        resultDiv = $("<div>").attr("id","resultDiv").addClass("resultDiv").css({height:''+($("#LAY_app_body").height() -330)+''});
                        $("#searchResultDiv").append(resultDiv);
                    }
                    var divtip = $("<div>").text("查询结果（"+result.data.length+"）");
                    resultDiv.append(divtip);
                    for(var i = 0 ; i < result.data.length; i++){
                        var dataobj = result.data[i];
                        var pointDiv = $("<div>").attr("id",dataobj.pid+""+ BaiduMap.map_level).attr("longitude",dataobj.longitude).attr("latitude",dataobj.latitude).css({"cursor":"pointer"});
                        resultDiv.append(pointDiv);
                        var divCompany = $("<div>").css({"font-weight":"bold","color":"black"}).text(dataobj.companyName);
                        var divAddress = $("<div>").text("地址："+dataobj.companyAddress);
                        var htemp = $("<hr>").css({height:"1px"});
                        pointDiv.append(divCompany).append(divAddress).append(htemp);
                        $("#"+dataobj.pid +""+ BaiduMap.map_level).bind('click',function () {
                            // alert($(this).attr("id"))
                            BaiduMap.highlight($(this).attr("longitude"),$(this).attr("latitude"));
                        });
                    }
                }
            }
            ,complete:function (res) {
                layer.close(loadindex);
            }
        });
    }
    ,getTotalCompanyLevel:function (admin,setter,$,baseurl,featureList) {
        admin.req({//
            url: baseurl + "/totalCompanyLevel"
            , done: function (result) {
                HighChartsUtil.initCompanyLevel(result.data);
            }
        });
    }
    ,getMonitorCompanyLocationForMap:function (admin,setter,$,baseurl,featureList,monitorType,type,companyName) {
        var loadindex = layer.load(0);
        admin.req({//
            url: baseurl + "/getMonitorInfo"
            ,data:{
                monitorType:monitorType
                ,companyName:companyName
                ,monitorUseFlag:1
            }
            , done: function (result) {
                BaiduMap.addPointsInMap(admin,setter,$,result.data,featureList,1);
                layer.close(loadindex);
                if(monitorType>=0){
                    if($("#resultDivOnline")){
                        $("#resultDivOnline").empty();
                        $("#resultDivOnline").remove();
                    }
                    var resultDiv = $("<div>").attr("id","resultDivOnline").addClass("resultDivOnline").css({height:''+($("#LAY_app_body").height() -80)+''});
                    $("#searchResultDivOnline").append(resultDiv);
                    var divtip = $("<div>").text("查询结果（"+result.data.length+"）");
                    resultDiv.append(divtip);
                    for(var i = 0 ; i < result.data.length; i++){
                        var dataobj = result.data[i];
                        var pointDiv = $("<div>").attr("id",dataobj.pid).attr("longitude",dataobj.longitude).attr("latitude",dataobj.latitude).css({"cursor":"pointer"});
                        resultDiv.append(pointDiv);
                        var divCompany = $("<div>").css({"font-weight":"bold","color":"black"}).text(dataobj.companyName);
                        var divAddress = $("<div>").text("监控点："+dataobj.monitorName);
                        var htemp = $("<hr>").css({height:"1px"});
                        pointDiv.append(divCompany).append(divAddress).append(htemp);
                        $("#"+dataobj.pid).bind('click',function () {
                            // alert($(this).attr("id"))
                            BaiduMap.highlight($(this).attr("longitude"),$(this).attr("latitude"));
                        });
                    }
                }
            }
            ,complete:function (res) {
                layer.close(loadindex);
            }
        });
    }
    ,getMonitorLocationForMap:function (admin,setter,$,baseurl,featureList,monitorType,type,companyName) {
        var loadindex = layer.load(0);
        admin.req({//
            url: baseurl + "/getMonitorInfo"
            ,data:{
                monitorType:monitorType
                ,companyName:companyName
                ,monitorUseFlag:1
            }
            , done: function (result) {
                BaiduMap.addPointsInMap(admin,setter,$,result.data,featureList,1);
                layer.close(loadindex);
                if(monitorType>=0){
                    if($("#resultDivOnline")){
                        $("#resultDivOnline").empty();
                        $("#resultDivOnline").remove();
                    }
                    var resultDiv = $("<div>").attr("id","resultDivOnline").addClass("resultDivOnline").css({height:''+($("#LAY_app_body").height() -80)+''});
                    $("#searchResultDivOnline").append(resultDiv);
                    var divtip = $("<div>").text("查询结果（"+result.data.length+"）");
                    resultDiv.append(divtip);
                    for(var i = 0 ; i < result.data.length; i++){
                        var dataobj = result.data[i];
                        var pointDiv = $("<div>").attr("id",dataobj.pid).attr("longitude",dataobj.longitude).attr("latitude",dataobj.latitude).css({"cursor":"pointer"});
                        resultDiv.append(pointDiv);
                        var divCompany = $("<div>").css({"font-weight":"bold","color":"black"}).text(dataobj.companyName);
                        var divAddress = $("<div>").text("监控点："+dataobj.monitorName);
                        var htemp = $("<hr>").css({height:"1px"});
                        pointDiv.append(divCompany).append(divAddress).append(htemp);
                        $("#"+dataobj.pid).bind('click',function () {
                            // alert($(this).attr("id"))
                            BaiduMap.highlight($(this).attr("longitude"),$(this).attr("latitude"));
                        });
                    }
                }
            }
            ,complete:function (res) {
                layer.close(loadindex);
            }
        });
    }
    ,getRiskSourceForMap: function (admin,setter,$,baseurl,featureList,risktabType,riskRating,companyNameRisk) {
        var loadindex = layer.load(0);
        admin.req({//
            url: baseurl + "/getRiskSourceList"
            ,data:{
                riskRating:riskRating
                ,companyName:companyNameRisk
            }
            , done: function (result) {
                BaiduMap.addPointsInMap(admin,setter,$,result.data,featureList,risktabType);
                layer.close(loadindex);
                if(riskRating){
                    if($("#resultDivRisk")){
                        $("#resultDivRisk").empty();
                        $("#resultDivRisk").remove();
                    }
                    var resultDiv = $("<div>").attr("id","resultDivRisk").addClass("resultDivRisk").css({height:''+($("#LAY_app_body").height() -230)+''});
                    $("#searchResultRisk").append(resultDiv);
                    var divtip = $("<div>").text("查询结果（"+result.data.length+"）");
                    resultDiv.append(divtip);
                    for(var i = 0 ; i < result.data.length; i++){
                        var dataobj = result.data[i];
                        var pointDiv = $("<div>").attr("id",dataobj.pid).attr("longitude",dataobj.longitude).attr("latitude",dataobj.latitude).css({"cursor":"pointer"});
                        resultDiv.append(pointDiv);
                        var divCompany = $("<div>").css({"font-weight":"bold","color":"black"}).text(dataobj.companyName);
                        var divAddress = $("<div>").text("地址："+dataobj.companyAddress);
                        var htemp = $("<hr>").css({height:"1px"});
                        pointDiv.append(divCompany).append(divAddress).append(htemp)
                        $("#"+dataobj.pid).bind('click',function () {
                            // alert($(this).attr("id"))
                            BaiduMap.highlight($(this).attr("longitude"),$(this).attr("latitude"));
                        });
                    }
                }
            }
            ,complete:function (res) {
                layer.close(loadindex);
            }
        });
    }
    ,getIsotopeForMap: function (admin,setter,$,baseurl,featureList,radioactiveCategory,companyName) {
        var loadindex = layer.load(0);
        admin.req({//
            url: baseurl + "/getIsotopeSourceList"
            ,data:{
                radioactiveCategory:radioactiveCategory
                ,companyName:companyName
            }
            , done: function (result) {
                BaiduMap.addPointsInMap(admin,setter,$,result.data,featureList,4);
                layer.close(loadindex);
                if(radioactiveCategory>0){
                    if($("#resultDivIsotope")){
                        $("#resultDivIsotope").empty();
                        $("#resultDivIsotope").remove();
                    }
                    var resultDiv = $("<div>").attr("id","resultDivIsotope").addClass("resultDivIsotope");
                    $("#searchResultIsotope").append(resultDiv);
                    var divtip = $("<div>").text("查询结果（"+result.data.length+"）");
                    resultDiv.append(divtip);
                    for(var i = 0 ; i < result.data.length; i++){
                        var dataobj = result.data[i];
                        var pointDiv = $("<div>").attr("id",dataobj.pid).attr("longitude",dataobj.longitude).attr("latitude",dataobj.latitude).css({"cursor":"pointer"});
                        resultDiv.append(pointDiv);
                        var divCompany = $("<div>").css({"font-weight":"bold","color":"black"}).text(dataobj.companyName);
                        var divAddress = $("<div>").text("地址："+dataobj.companyAddress);
                        var htemp = $("<hr>").css({height:"1px"});
                        pointDiv.append(divCompany).append(divAddress).append(htemp);
                        $("#"+dataobj.pid).bind('click',function () {
                            // alert($(this).attr("id"))
                            BaiduMap.highlight($(this).attr("longitude"),$(this).attr("latitude"));
                        });
                    }
                }
            }
            ,complete:function (res) {
                layer.close(loadindex);
            }
        });
    }
    ,getDangerSourceForMap: function (admin,setter,$,baseurl,featureList,risktabType,companyNameDanger) {
        var loadindex = layer.load(0);
        admin.req({//
            url: baseurl + "/getDangerSourceList"
            ,data:{
                companyName:companyNameDanger
            }
            , done: function (result) {
                BaiduMap.addPointsInMap(admin,setter,$,result.data,featureList,risktabType);
                layer.close(loadindex);
                if(risktabType){
                    if($("#resultDivDanger")){
                        $("#resultDivDanger").empty();
                        $("#resultDivDanger").remove();
                    }
                    var resultDiv = $("<div>").attr("id","resultDivDanger").addClass("resultDivRisk").css({height:''+($("#LAY_app_body").height() -80)+''});
                    $("#searchResultDanger").append(resultDiv);
                    var divtip = $("<div>").text("查询结果（"+result.data.length+"）");
                    resultDiv.append(divtip);
                    for(var i = 0 ; i < result.data.length; i++){
                        var dataobj = result.data[i];
                        var pointDiv = $("<div>").attr("id",dataobj.pid).attr("longitude",dataobj.longitude).attr("latitude",dataobj.latitude).css({"cursor":"pointer"});
                        resultDiv.append(pointDiv);
                        var divCompany = $("<div>").css({"font-weight":"bold","color":"black"}).text(dataobj.companyName);
                        var divAddress = $("<div>").text("地址："+dataobj.companyAddress);
                        var htemp = $("<hr>").css({height:"1px"});
                        pointDiv.append(divCompany).append(divAddress).append(htemp);
                        $("#"+dataobj.pid).bind('click',function () {
                            // alert($(this).attr("id"))
                            BaiduMap.highlight($(this).attr("longitude"),$(this).attr("latitude"));
                        });
                    }
                }
            }
            ,complete:function (res) {
                layer.close(loadindex);
            }
        });
    }
    ,getRiskData:function (admin,setter,$,cid,$dom) {//应急物资数据
        var loadindex = layer.load(0);
        admin.req({//
            url: setter.remoteServiceAddress + "/emergency/emergencysystemsupplies/list"
            ,data:{
                cid:cid
            }
            , done: function (result) {
                layer.close(loadindex);
                var riskTable=$("#"+$dom);
                for(var i=0;i<result.data.length;i++){
                    var tr=$("<tr>");
                    var tda=$("<td class='tdCenter'>").text(i+1);
                    var tdb=$("<td class='tdCenter'>").text(result.data[i].suppliesName);
                    var tdc=$("<td class='tdCenter'>").text(result.data[i].suppliesTypeName);
                    var tdd=$("<td class='tdCenter'>").text(result.data[i].suppliesNumber);
                    tr.append(tda);
                    tr.append(tdb);
                    tr.append(tdc);
                    tr.append(tdd);
                    riskTable.append(tr);
                }
            }
            ,complete:function (res) {
                layer.close(loadindex);
            }
        });
    }
    ,getDangerData:function (admin,setter,$,cid,$dom) {//危险化学品数据
        var loadindex = layer.load(0);
        admin.req({//
            url: setter.remoteServiceAddress + "/emergency/emergencysystemdangerous/list"
            ,data:{
                cid:cid
            }
            , done: function (result) {
                layer.close(loadindex);
                var dangerTable=$("#"+$dom);
                for(var i=0;i<result.data.length;i++){
                    var tr=$("<tr>");
                    var tda=$("<td class='tdCenter'>").text(i+1);
                    var tdb=$("<td class='tdCenter'>").text(result.data[i].dangerousName);
                    var tdc=$("<td class='tdCenter'>").text(result.data[i].casNumber);
                    var tdd=$("<td class='tdCenter'>").text(result.data[i].amount);
                    tr.append(tda);
                    tr.append(tdb);
                    tr.append(tdc);
                    tr.append(tdd);
                    dangerTable.append(tr);
                }
            }
            ,complete:function (res) {
                layer.close(loadindex);
            }
        });
    }
    ,getIsotopeData:function (admin,setter,$,cid,$dom) {//危险化学品数据
        var loadindex = layer.load(0);
        admin.req({//
            url: setter.remoteServiceAddress + "/radioactive/radioactiveisotopeinfo/list"
            ,data:{
                cid:cid
            }
            , done: function (result) {
                layer.close(loadindex);
                var isotopeTable=$("#"+$dom);
                for(var i=0;i<result.data.length;i++){
                    var tr=$("<tr>");
                    var tda=$("<td class='tdCenter'>").text(i+1);
                    var tdb=$("<td class='tdCenter'>").text(result.data[i].isotopeName);
                    var tdc=$("<td class='tdCenter'>").text(result.data[i].radioactiveCategoryName);
                    var tdd=$("<td class='tdCenter'>").text(result.data[i].amount);
                    tr.append(tda);
                    tr.append(tdb);
                    tr.append(tdc);
                    tr.append(tdd);
                    isotopeTable.append(tr);
                }
            }
            ,complete:function (res) {
                layer.close(loadindex);
            }
        });
    }
};
