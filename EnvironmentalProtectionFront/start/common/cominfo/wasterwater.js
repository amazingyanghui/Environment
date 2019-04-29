var wasterWater={
    editWin:function (admin,setter,$,table,form,baseurl,laytpl,laydate,element,differType,global_obj,pid,cid) {
        var showAndHide=function () {
            $("#wasteWater0").removeClass("layui-hide");
            $("#wasteWater1").removeClass("layui-hide");
            $("#wasteWater2").removeClass("layui-hide");
            $("#wasteWater3").removeClass("layui-hide");
            $("#wasteWater4").removeClass("layui-hide");
            $("#cominfoMeasureWastewater0").addClass("layui-hide");
            $("#cominfoMeasureWastewater1").addClass("layui-hide");
            $("#cominfoMeasureWastewater2").addClass("layui-hide");
            $("#cominfoMeasureWastewater3").addClass("layui-hide");
            $("#cominfoMeasureWastewater4").addClass("layui-hide");
            $("#add").removeClass("layui-hide");
            $("#mod").removeClass("layui-hide");
            $("#del").removeClass("layui-hide");
            $("#link").removeClass("layui-hide");
        };
        var dateTime=function () {
            laydate.render({
                elem: '#deliveryDate'+differType //或 elem: document.getElementById('test')、elem: lay('#test') 等
                ,type: 'date'
                // ,value:new Date()
            });

        };
        var getBaseInfo = editcominfoMeasureWastewater.innerHTML;

        //废水类别
        var wastewaterCategoryTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/wastewater_category_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,wastewaterCategory = document.getElementById('wastewaterCategory');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        wastewaterCategory.innerHTML = html;
                        if(data.wastewaterCategory!=null&data.wastewaterCategory!==''){
                            $("#wastewaterCategory").val(data.wastewaterCategory);
                        }
                    });
                    form.render(null, 'component-form-element');
                }
            });
        };

        if(differType==1){
            getBaseInfo = editcominfoMeasureWastegas.innerHTML;
        }
        if(differType==2){
            getBaseInfo = editcominfoMeasureWastevocs.innerHTML;
        }
        if(differType==3){
            //治理方式
            var governanceTpl=function (data) {
                admin.req({//获取字典请求
                    url: setter.remoteServiceAddress + "/market/sysdict/dicts/governance_mode_type"
                    , done: function (result) {
                        var getDictTpl = SelectDictTpl.innerHTML
                            ,governanceMode = document.getElementById('governanceMode');
                        laytpl(getDictTpl).render(result.dicts, function(html){
                            governanceMode.innerHTML = html;
                            if(data.governanceMode!=null&data.governanceMode!==''){
                                $("#governanceMode").val(data.governanceMode);
                            }
                        });
                        form.render(null, 'component-form-element');
                    }
                });
            };
            getBaseInfo = editcominfoMeasureSolidwaste.innerHTML;
        }else {
            var url=setter.remoteServiceAddress + "/online/onlinemonitorportinfo/selectList/"+cid+"/"+differType;
            if(differType==4){
                url=setter.remoteServiceAddress + "/online/onlinemonitorportinfo/selectList/"+cid+"/-1";
            }
            var blowdownOutletTpl=function (data) {
                admin.req({//获取字典请求
                    url: url
                    , done: function (result) {
                        var getSelectTpl = SelectTpl.innerHTML
                            ,blowdownOutlet = document.getElementById('blowdownOutlet'+differType);
                        laytpl(getSelectTpl).render(result.data, function(html){
                            blowdownOutlet.innerHTML = html;
                            if(data.blowdownOutlet!=null&data.blowdownOutlet!==''){
                                $("#blowdownOutlet"+differType).val(data.blowdownOutlet);
                            }
                        });
                        form.render(null, 'component-form-element');
                    }
                });
            }
        }
        if(differType==4){
            getBaseInfo = editcominfoMeasureOtherwaste.innerHTML;
        }
        if(pid!=null&pid!="undefined"){
            admin.req({//根据id获取该记录的详细信息
                url: baseurl + "/" + pid
                ,done: function(result){
                    if(result.code == 0){//成功
                        afterLoad(result.cominfoMeasureWastewater);
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
            //需要占位，否则为空没法渲染
            afterLoad(1)
        }

        function afterLoad(data) {
            var laboratorytechnician = document.getElementById('cominfoMeasureWastewater'+differType);
            laytpl(getBaseInfo).render(data, function(html){
                laboratorytechnician.innerHTML = html;
                if(differType==3){
                    governanceTpl(data);
                }else{
                    blowdownOutletTpl(data);
                }
                dateTime();
            });
            if(differType==0){
                wastewaterCategoryTpl(data);
                setFuzzySearch(data);
                jQuery("#materialSel").val(data.removalOfMaterialName);
            }
            $("[name='wasterHome"+differType+"']").on("click",function () {
                showAndHide();
                table.reload("LAY-market-cominfoMeasureWastewater"+differType); //刷新表格
            });
            form.render(null, 'component-form-element');
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
                        rootPId: 1
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

            var removalOfMaterial=null;
            if(data.removalOfMaterial!='' & data.removalOfMaterial!=undefined){
                removalOfMaterial=data.removalOfMaterial;
            }
            admin.req({//根据id获取该记录的详细信息
                url: setter.remoteServiceAddress + "/sys/sysshuiwuranwu/getLieBiao/" + removalOfMaterial
                ,done: function(result){
                    if(result.code == 0){//成功
                        jQuery.fn.zTree.init(jQuery("#treeMaterial"), setting, result.data);
                        // onCheck();
                        fuzzySearch('treeMaterial','#materialKey',null,true); //初始化模糊搜索方法
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
            var zTree = jQuery.fn.zTree.getZTreeObj("treeMaterial");
            zTree.checkNode(treeNode, !treeNode.checked, null, true);
            return false;
        }

        function onCheck(e, treeId, treeNode) {
            var zTree = jQuery.fn.zTree.getZTreeObj("treeMaterial"),
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
            jQuery("#materialSel").val(v);
            if (industrys.length > 0 ) industrys = industrys.substring(0, industrys.length-1);
            jQuery("[name='removalOfMaterial']").val(industrys);
        }

    }
    ,
    showMenu : function() {
        var cityObj = jQuery("#materialSel");
        var cityOffset = jQuery("#materialSel").offset();
        jQuery("#menuMaterial").css({right:"0px", top:"105px","background-color": "white","z-index": "1",overflow:"auto"}).slideDown("fast");

        jQuery("body").bind("mousedown", wasterWater.onBodyDown);
    }
    ,hideMenu : function() {
        jQuery("#menuMaterial").fadeOut("fast");
        jQuery("body").unbind("mousedown", wasterWater.onBodyDown);
    }
    ,onBodyDown : function(event) {
        if (!(event.target.id == "menuBtn" || event.target.id == "materialSel" || event.target.id == "menuMaterial" || jQuery(event.target).parents("#menuMaterial").length>0)) {
            wasterWater.hideMenu();
        }
    }
};
