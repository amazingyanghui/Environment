layui.define(['jquery'], function (exports) {
    var $ = layui.jquery;
    var admin = layui.admin;
    var layer = layui.layer;
    var setter = layui.setter;
    var object={
        /**
         * 排放点污染物新增修改页面
         * @param pid
         */
        getBaseInfo:null
        ,editWin:function (admin,setter,$,table,form,baseurl,laytpl,laydate,element,differType,global_obj,pid,cid) {
            //加载下时间类型选项
            var dateTime=function () {
                laydate.render({
                    elem: '#produceYear'+differType//或 elem: document.getElementById('test')、elem: lay('#test')
                    ,type: 'year'
                });
            }
            var booleanTpl=function (isWasteType) {
                var type='waste_type';
                admin.req({//获取字典请求
                    url: setter.remoteServiceAddress + "/online/onlinewasteproduce/wasteType/"+type
                    , done: function (result) {
                        var getDictTpl = SelectDictTpl.innerHTML
                            ,monitorUseflag = document.getElementById('isWaste'+differType);
                        laytpl(getDictTpl).render(result.data, function(html){
                            monitorUseflag.innerHTML = html;
                            if(isWasteType!=null){
                                $('#isWaste'+differType).val(isWasteType);
                            }
                        });
                        form.render(null, 'component-form-element');
                    }
                });
            }

            //查询当前企业的排口
            var url=setter.remoteServiceAddress + "/online/onlinemonitorportinfo/selectList/"+cid;
            var blowdownOutletTpl=function (data) {
                admin.req({//获取字典请求
                    url: url
                    , done: function (result) {
                        var getSelectTpl = SelectTpl.innerHTML
                            ,blowdownOutlet = document.getElementById('mid'+differType);
                        laytpl(getSelectTpl).render(result.data, function(html){
                            blowdownOutlet.innerHTML = html;
                            if(data.mid!=null&data.mid!==''){
                                $("#mid"+differType).val(data.mid);
                            }
                        });
                        form.render(null, 'component-form-element');
                    }
                });
            }

            //加载的模板
            object.getBaseInfo=editonlineMonitorPortinfo6.innerHTML;
            //通过pid判断是修改还是新增
            if(pid!=null&pid!="undefined"){
                admin.req({//根据id获取该记录的详细信息
                    url: baseurl + "/" + pid
                    ,done: function(result){
                        if(result.code == 0){//成功
                            var laboratorytechnician = document.getElementById('onlineMonitorPortinfo'+differType);
                            laytpl(object.getBaseInfo).render(result.onlineMonitorStoreinfo, function(html){
                                laboratorytechnician.innerHTML = html;
                                // doCallback(differType,result.onlineMonitorPortinfo);
                               // dateTime();
                               // booleanTpl(result.onlineWasteProduce.isWaste);
                                blowdownOutletTpl(result.onlineMonitorStoreinfo);
                            });

                            $("[name='portInfoHome']").on("click",function () {
                                object.showAndHide();
                                table.reload("LAY-online-onlineMonitorPortinfo"+differType); //刷新表格
                            });
                            form.render(null, 'component-form-element');
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
                var data=null;
                if(differType==3){
                    data={useType:0};
                }else{
                    data={useType:1};
                }
                //需要占位，否则为空没法渲染
                var laboratorytechnician = document.getElementById('onlineMonitorPortinfo'+differType);
                laytpl(object.getBaseInfo).render(data, function(html){
                    laboratorytechnician.innerHTML = html;
                    // doCallback(differType,data);
                   // dateTime();
                   // booleanTpl();
                    blowdownOutletTpl(data);
                });


                $("[name='portInfoHome']").on("click",function () {
                    object.showAndHide();
                    table.reload("LAY-online-onlineMonitorPortinfo"+differType); //刷新表格
                });
                form.render(null, 'component-form-element');
            }
        }
        ,showAndHide:function () {
          $("#monitorPortinfo6").removeClass("layui-hide");
           // $("#monitorPortinfo4").removeClass("layui-hide");
           // $("#onlineMonitorPortinfo3").addClass("layui-hide");
            $("#onlineMonitorPortinfo6").addClass("layui-hide");
            $("#add").removeClass("layui-hide");
            $("#mod").removeClass("layui-hide");
            $("#del").removeClass("layui-hide");
        }
        //动态加载下拉框
        ,yearQuery:function(element){
            admin.req({
                url:setter.remoteServiceAddress + "/mobile/mobileenforcementscene/statisticalYearQuery"
                ,async: false
                , done: function (result) {
                    if(result.code == 0){
                        var data=result.dicts;
                        for(var i=0;i<data.length;i++){
                            $("#"+element).append("<span >"+data[i].value+"</span>")
                        }
                    }
                }
            });
        }
    }
    exports('wasteInfo', object);
});