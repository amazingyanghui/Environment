var baseInfo={
    editWin:function (admin,setter,$,form,baseurl,laytpl,laydate,element,differType,global_obj,pid,risksource) {
        if(risksource!=null&risksource!="undefined"){
            risksource=1;
        }else{
            risksource=0;
        }

        //隶属关系下拉框
        var governanceTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/affiliation_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,affiliation = document.getElementById('affiliation');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        affiliation.innerHTML = html;
                        if(data.affiliation!=null&data.affiliation!==''){
                            $("#affiliation").val(data.affiliation);
                        }
                    });
                    form.render(null, 'component-form-element');
                    showOrHide();
                }
            });
        };

        //登记注册类型下拉框
        var registrationTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/registration_type_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,registrationType = document.getElementById('registrationType');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        registrationType.innerHTML = html;
                        if(data.registrationType!=null&data.registrationType!==''){
                            $("#registrationType").val(data.registrationType);
                        }
                    });
                    form.render(null, 'component-form-element');
                    showOrHide();
                }
            });
        };

        //企业规模下拉框
        var enterpriseTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/enterprise_scale_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,enterpriseScale = document.getElementById('enterpriseScale');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        enterpriseScale.innerHTML = html;
                        if(data.enterpriseScale!=null&data.enterpriseScale!==''){
                            $("#enterpriseScale").val(data.enterpriseScale);
                        }
                    });
                    form.render(null, 'component-form-element');
                    showOrHide();
                }
            });
        };

        //企业类型下拉框
        var pollutionTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/pollution_source_category_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,pollutionSourceCategory = document.getElementById('pollutionSourceCategory');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        pollutionSourceCategory.innerHTML = html;
                        if(data.pollutionSourceCategory!=null&data.pollutionSourceCategory!==''){
                            $("#pollutionSourceCategory").val(data.pollutionSourceCategory);
                        }
                    });
                    form.render(null, 'component-form-element');
                    showOrHide();
                }
            });
        };

        //生产状态下拉框
        var productionStateTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/production_state_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,productionState = document.getElementById('productionState');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        productionState.innerHTML = html;
                        if(data.productionState!=null&data.productionState!==''){
                            $("#productionState").val(data.productionState);
                        }
                    });
                    form.render(null, 'component-form-element');
                    showOrHide();
                }
            });
        };

        //所属地市下拉框
        // var localCityTpl=function (data) {
        //     admin.req({//获取字典请求
        //         url: setter.remoteServiceAddress + "/market/sysdict/dicts/local_city_type"
        //         , done: function (result) {
        //             var getDictTpl = SelectDictTpl.innerHTML
        //                 ,localCity = document.getElementById('localCity');
        //             laytpl(getDictTpl).render(result.dicts, function(html){
        //                 localCity.innerHTML = html;
        //                 if(data.localCity!=null&data.localCity!=''){
        //                     $("#localCity").val(data.localCity);
        //                 }
        //             });
        //             form.render(null, 'component-form-element');
        //             showOrHide();
        //         }
        //     });
        // };

        // //所属区县下拉框
        // var districtAndCountyTpl=function (data) {
        //     admin.req({//获取字典请求
        //         url: setter.remoteServiceAddress + "/market/sysdict/dicts/district_and_county_type"
        //         , done: function (result) {
        //             var getDictTpl = SelectDictTpl.innerHTML
        //                 ,districtAndCounty = document.getElementById('districtAndCounty');
        //             laytpl(getDictTpl).render(result.dicts, function(html){
        //                 districtAndCounty.innerHTML = html;
        //                 if(data.districtAndCounty!=null&data.districtAndCounty!=''){
        //                     $("#districtAndCounty").val(data.districtAndCounty);
        //                 }
        //             });
        //             form.render(null, 'component-form-element');
        //             showOrHide();
        //         }
        //     });
        // };

        // //所属街道/乡镇下拉框
        // var streetTpl=function (data) {
        //     admin.req({//获取字典请求
        //         url: setter.remoteServiceAddress + "/market/sysdict/dicts/street_or_town_type"
        //         , done: function (result) {
        //             var getDictTpl = SelectDictTpl.innerHTML
        //                 ,streetOrTown = document.getElementById('streetOrTown');
        //             laytpl(getDictTpl).render(result.dicts, function(html){
        //                 streetOrTown.innerHTML = html;
        //                 if(data.streetOrTown!=null&data.streetOrTown!=''){
        //                     $("#streetOrTown").val(data.streetOrTown);
        //                 }
        //             });
        //             form.render(null, 'component-form-element');
        //             showOrHide();
        //         }
        //     });
        // };

        //是否下拉框
        var booleanTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/boolean_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,supervise = document.getElementById('supervise')
                        ,ecologicArea = document.getElementById('ecologicArea')
                        ,talk = document.getElementById('talk')
                        ,quotedCompany = document.getElementById('quotedCompany')
                    isSubsidiaryCompany = document.getElementById('isSubsidiaryCompany');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        supervise.innerHTML = html;
                        ecologicArea.innerHTML = html;
                        talk.innerHTML = html;
                        quotedCompany.innerHTML = html;
                        isSubsidiaryCompany.innerHTML = html;
                        $("#supervise").val(data.supervise);
                        $("#ecologicArea").val(data.ecologicArea);
                        $("#talk").val(data.talk);
                        var   quo ="", isSub = " ";
                        if(data.isSubsidiaryCompany=="否"){
                            isSub = 0 ;
                        }else if(data.isSubsidiaryCompany=="是"){
                            isSub = 1 ;
                        }
                        if(data.quotedCompany=="否"){
                            quo = 0 ;
                        }else if(data.quotedCompany=="是"){
                            quo = 1 ;
                        }
                        $("#quotedCompany").val(quo);

                        $("#isSubsidiaryCompany").val(isSub);
                    });
                    form.render(null, 'component-form-element');
                    showOrHide();
                }
            });
        };

        //隐藏的其他信息
        var showAndHide=function (data) {

            governanceTpl(data);
            registrationTpl(data);
            enterpriseTpl(data);
            productionStateTpl(data);

            $("#showOther").on("click",function () {
                $("#hiddenInfo").removeClass("layui-hide");
                $("#hideOther").removeClass("layui-hide");
                $("#showOther").addClass("layui-hide");


                laydate.render({
                    elem: '#openingDate' //或 elem: document.getElementById('test')、elem: lay('#test') 等
                    ,type: 'date'
                    // ,value:new Date()
                });

                laydate.render({
                    elem: '#stopDate' //或 elem: document.getElementById('test')、elem: lay('#test') 等
                    ,type: 'date'
                    // ,value:new Date()
                });

                laydate.render({
                    elem: '#latestDate' //或 elem: document.getElementById('test')、elem: lay('#test') 等
                    ,type: 'date'
                    // ,value:new Date()
                });
            });

            $("#hideOther").on("click",function () {
                $("#hiddenInfo").addClass("layui-hide");
                $("#hideOther").addClass("layui-hide");
                $("#showOther").removeClass("layui-hide");
            });
        };

        //以下为其他类型下拉框（待补充）
        if(pid!=null&pid!="undefined"){
            admin.req({//根据id获取该记录的详细信息
                url: baseurl + "/" + pid
                ,done: function(result){
                    if(result.code == 0){//成功
                        initLayout(result.cominfoBaseinfo)
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
            var data=[];
            // data=1;//需要占位，否则为空没法渲染
            initLayout(data)
        }

        function initLayout(data) {
            var getBaseinfo = editcominfoBaseinfo.innerHTML
                ,laboratorytechnician = document.getElementById('LAY-market-cominfoBaseinfo'+differType);
            laytpl(getBaseinfo).render(data, function(html){
                laboratorytechnician.innerHTML = html;
                // localCityTpl(data);
                // districtAndCountyTpl(data);
                // streetTpl(data);
                pollutionTpl(data);
                booleanTpl(data);
                if(risksource==1){
                    $("#test").addClass("layui-hide");
                    $("#home").addClass("layui-hide");
                    $("#showOther").addClass("layui-hide");
                    form.render(null, 'component-form-element');
                }else{
                    showAndHide(data);
                    form.render(null, 'component-form-element');
                    showOrHide();
                }

                // BaiduMap.init(1,null,setter,null,data);
                initMapForAdd('container',$("[name='companyAddress']").val(),'txtMonitorName','searchResultPanel',true,$("[name='longitude']").val(),$("[name='latitude']").val());
                setMapTpl(data);
                setFuzzySearch(data);
                jQuery("#industrySel").val(data.industry);
                // jQuery("[name='industryids']").val(data.industrys);

            });
        }

        function setMapTpl(data) {
            var mapHtmlTpl =
                '<div class="wrapper"> ' +
                '   <div class="newmap" id="simpleMapTpl"></div>' +
                '</div>' +
                '    <div id="bamboo">' +
                '        <div class="banni" id="bannibutton">' +
                '            <input type="text" id="queryText" value="" style="width:150px;"/> &nbsp;&nbsp;' +
                '            <input type="button" value="查询" style="width:80px;" onclick="TDTMap.query(1);"/>' +
                '            <input type="button" value="修改" id="updatePosition" style="width:80px;" onclick="TDTMap.updatePoint(TDTMap.lon_temp,TDTMap.lat_temp);"/>' +
                '            <input type="button" value="确定" style="width:80px;" id="confirmButton" onclick="TDTMap.confirmPoint();"/>' +
                '        </div>' +
                '    </div>' +
                '    <div id="dialog" class="dialog hadai">' +
                '    <div class="hadu" id="dine">' +
                '        <img style="cursor:hand;display:none;cursor: pointer;margin-right:16px;margin-top:16px;" id="openD" class="kaji" onclick="TDTMap.openDialog(this)" src="TDTNJApi/profile/images/openD.png">' +
                '        <img style="cursor:hand;cursor: pointer;" id="closeD" class="kaji"  onclick="TDTMap.closeDialog(this)" src="TDTNJApi/profile/images/closeD.png">' +
                '    </div>' +
                '    <div id="resultDIV" class="juma"></div>' +
                '</div>';
            $("#setPoint").bind("click",function () {
                layer.open({
                    type: 1
                    , title: "查看"
                    , area: ['700px', '500px']
                    // offset: '120px',
                    , content: mapHtmlTpl
                    ,success: function(layero, index){
                        TDTMap.initMapTpl(1,null,setter,null,data,"simpleMapTpl");
                        $("#confirmButton").bind("click",function () {
                            layer.close(index);
                            var longitude=$("#cominfoBaseinfoedit [name='longitude']").val();
                            var latitude=$("#cominfoBaseinfoedit [name='latitude']").val();
                            if(data==1){
                                data={"longitude":longitude,"latitude":latitude};
                            }else {
                                data.longitude=longitude;
                                data.latitude=latitude;
                            }
                            $("#simpleMap").html("");
                            TDTMap.init(1,null,setter,null,data);
                        });
                    }
                });
            });
        }

        function setFuzzySearch(data) {

            var setting = {
                check: {
                    enable: true,
                    chkboxType: {"Y":"", "N":""}
                },
                edit: {
                    enable: false,
                    editNameSelectAll: false
                },
                view: {
                    dblClickExpand: false,
                    nameIsHTML: true, //允许name支持html
                    selectedMulti: false
                },
                data: {
                    simpleData: {
                        enable: true,
                        idKey: "biaoshi",
                        pIdKey: "fujidaimabiaoshi",
                        rootPId: 0
                    }
                    ,key: {
                        name: "mingcheng"
                        ,checked:"checked"
                    }
                },
                callback: {
                    beforeClick: beforeClick,
                    onCheck: onCheck
                }
            };

            var industryids=null;
            if(data.industryids!='' & data.industryids!=undefined){
                industryids=data.industryids;
            }
            admin.req({//根据id获取该记录的详细信息
                url: setter.remoteServiceAddress + "/sys/syshangyedaima/getHangYeLieBiao/" + industryids
                ,done: function(result){
                    if(result.code == 0){//成功
                        jQuery.fn.zTree.init(jQuery("#treeIndustry"), setting, result.data);
                        // onCheck();
                        fuzzySearch('treeIndustry','#key',null,true); //初始化模糊搜索方法
                    }else{
                        layer.alert(result.msg, {
                            skin: 'layui-layer-lan',
                            offset: 't',
                            anim: 6
                        });
                    }
                }
            });
        }

        function beforeClick(treeId, treeNode) {
            var zTree = jQuery.fn.zTree.getZTreeObj("treeIndustry");
            zTree.checkNode(treeNode, !treeNode.checked, null, true);
            return false;
        }

        function onCheck(e, treeId, treeNode) {
            var zTree = jQuery.fn.zTree.getZTreeObj("treeIndustry"),
                nodes = zTree.getCheckedNodes(true),
                v = "",
                industrys = "";
            for (var i=0, l=nodes.length; i<l; i++) {
                var mingcheng=nodes[i].mingcheng;
                if(nodes[i].oldname!=undefined&nodes[i].oldname!=null){
                    mingcheng=nodes[i].oldname;
                }
                v += mingcheng + ",";
                industrys +=  nodes[i].daimazhi + ",";
            }
            if (v.length > 0 ) v = v.substring(0, v.length-1);
            jQuery("#industrySel").val(v);
            if (industrys.length > 0 ) industrys = industrys.substring(0, industrys.length-1);
            jQuery("[name='industryids']").val(industrys);
        }


        function showOrHide() {
            if(layui.data(setter.userRoles).userRoles.indexOf(setter.companyRoleId) !== -1){
                $("#aCite").text("企业维护");
                $("#aCite").attr("lay-href","cominfo/baseinfo/index");
                // $("#cite").addClass("layui-hide");
                // $("#cite+span").addClass("layui-hide");
                $("#home").addClass("layui-hide");
            }
        }

    }
    ,
    showMenu : function() {
        var cityObj = jQuery("#industrySel");
        var cityOffset = jQuery("#industrySel").offset();
        jQuery("#menuContent").css({left:cityObj.left + "px", top:"351px","background-color": "white","z-index": "1",overflow:"auto"}).slideDown("fast");

        jQuery("body").bind("mousedown", baseInfo.onBodyDown);
    }
    ,hideMenu : function() {
        jQuery("#menuContent").fadeOut("fast");
        jQuery("body").unbind("mousedown", baseInfo.onBodyDown);
    }
    ,onBodyDown : function(event) {
        if (!(event.target.id == "menuBtn" || event.target.id == "industrySel" || event.target.id == "menuContent" || jQuery(event.target).parents("#menuContent").length>0)) {
            baseInfo.hideMenu();
        }
    }
};
