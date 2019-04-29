var processingPlace={
    editWin:function (admin,setter,$,table,form,baseurl,laytpl,laydate,element,differType,global_obj,pid,cid,getBaseInfo) {
        var showAndHide=function () {
            $("#processingPlace0").removeClass("layui-hide");
            $("#processingPlace1").removeClass("layui-hide");
            $("#comInfoProcessingPlace0").addClass("layui-hide");
            $("#comInfoProcessingPlace1").addClass("layui-hide");
            $("#add").removeClass("layui-hide");
            $("#mod").removeClass("layui-hide");
            $("#del").removeClass("layui-hide");
        };

        if(pid!=null&pid!="undefined"){
            admin.req({//根据id获取该记录的详细信息
                url: baseurl + "/" + pid
                ,done: function(result){
                    if(result.code == 0){//成功
                        afterLoad(result.cominfoWasteProcessPlace);
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
            var laboratorytechnician = document.getElementById('comInfoProcessingPlace'+differType);
            laytpl(getBaseInfo).render(data, function(html){
                laboratorytechnician.innerHTML = html;
            });
            //年选择器
            laydate.render({
                elem: '[name="year"]'
                ,type: 'year'
            });

            //年选择器
            laydate.render({
                elem: '[name="riskDelineationYear"]'
                ,type: 'year'
            });

            $("[name='processingPlace']").unbind();
            $("[name='processingPlace']").on("click",function () {
                showAndHide();
                table.reload("LAY-comInfo-processingPlace"+differType); //刷新表格
            });
            form.render(null, 'component-form-element');
        }

    }
};
