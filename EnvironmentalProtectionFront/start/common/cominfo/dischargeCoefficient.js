var dischargeCoefficient={
    editWin:function (admin,setter,$,table,form,baseurl,laytpl,laydate,element,differType,global_obj,pid,cid,getBaseInfo) {
        var showAndHide=function () {
            $("#monitorPortinfo0").removeClass("layui-hide");
            $("#monitorPortinfo1").removeClass("layui-hide");
            $("#monitorPortinfo2").removeClass("layui-hide");
            $("#monitorPortinfo3").removeClass("layui-hide");
            $("#monitorPortinfo4").removeClass("layui-hide");
            $("#monitorPortinfo5").removeClass("layui-hide");
            $("#monitorPortinfo6").removeClass("layui-hide");
            $("#monitorPortinfo7").removeClass("layui-hide");
            $("#onlineMonitorPortinfo0").addClass("layui-hide");
            $("#onlineMonitorPortinfo1").addClass("layui-hide");
            $("#onlineMonitorPortinfo2").addClass("layui-hide");
            $("#onlineMonitorPortinfo3").addClass("layui-hide");
            $("#onlineMonitorPortinfo4").addClass("layui-hide");
            $("#onlineMonitorPortinfo5").addClass("layui-hide");
            $("#onlineMonitorPortinfo6").addClass("layui-hide");
            $("#onlineMonitorPortinfo7").addClass("layui-hide");
            $("#add").removeClass("layui-hide");
            $("#mod").removeClass("layui-hide");
            $("#del").removeClass("layui-hide");
            /* $("#link").removeClass("layui-hide");*/
        };

        var midTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/online/onlinemonitorportinfo/selectList/"+cid
                , done: function (result) {
                    var getSelectTpl = SelectTpl.innerHTML
                        ,mid_select = document.getElementById('mid_select');
                    laytpl(getSelectTpl).render(result.data, function(html){
                        mid_select.innerHTML = html;
                        if(data.mid!=null&data.mid!==''){
                            $("#mid_select").val(data.mid);
                        }
                    });
                    form.render(null, 'component-form-element');
                }
            });
        }

        if(pid!=null&pid!="undefined"){
            admin.req({//根据id获取该记录的详细信息
                url: baseurl + "/" + pid
                ,done: function(result){
                    if(result.code == 0){//成功
                        afterLoad(result.enterprisesDischargeCoefficient);
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
            var laboratorytechnician = document.getElementById('onlineMonitorPortinfo'+differType);
            laytpl(getBaseInfo).render(data, function(html){
                laboratorytechnician.innerHTML = html;
            });

            midTpl(data);

            //年选择器
            laydate.render({
                elem: '[name="year"]'
                ,type: 'year'
            });

            $("[name='coefficientHome']").unbind();
            $("[name='coefficientHome']").on("click",function () {
                showAndHide();
                table.reload("LAY-online-onlineMonitorPortinfo"+differType); //刷新表格
            });
            form.render(null, 'component-form-element');
        }

    }
};
