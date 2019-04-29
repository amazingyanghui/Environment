var commonReload={
    //公司名称验证(value:公司名称)
    stripScript:function (value) {
        var pattern = new RegExp("[`~!@#$^&*()=|{}':;',\\[\\].<>/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？]");
        var rs = "";
        for (var i = 0; i < value.length; i++) {
            rs = rs + rs.substr(i, 1).replace(pattern, '');
        }
        return rs;
    }
    //进入界面需要拼接高级查询的界面（$:layui的$,$divPanel:用来拼接界面的父id,html:拼接的界面,$select：公司名称模糊查select的id）
    ,firstInReload:function ($,$divPanel,html,$select) {
        var divContent = $("<div>").addClass("layui-layer-btn-c").html(html);
        $("#"+$divPanel).append(divContent);
        $("#"+$select).animate({height:'0px'},"fast");
        $("#"+$select).addClass("layui-hide");
    }
    //查询
    ,companyNameReload:function ($,admin,url,global_obj,form,table,$companyName,$select,$form,$divPanel,$searchHide,$searchShow,$reset,$table,$search,$labelTip,flag) {
        global_obj.companyList = [];
        $("#"+$companyName).keyup(function(){
            var companyName=null;
            companyName=  $.trim($("#"+$companyName).val());
            commonReload.stripScript(companyName);
            var data=commonReload.serializeObject($,$divPanel);
            var onlineMonitoring=$("#onlineMonitoringNameReload").val();
            if(onlineMonitoring!=null & onlineMonitoring!=undefined & onlineMonitoring!=""){
                data.onlineMonitoring=onlineMonitoring;
            }
            data.companyName=companyName;
            if(companyName.length>0&&companyName!==null&&companyName!==""){
                admin.req({//公司名称模糊查询
                    url: url
                    ,data:data
                    ,done: function(result){
                        $("#"+$select).empty();
                        global_obj.companyList = result.data;
                        var html="";
                        if(global_obj.companyList!=""){
                            if(global_obj.companyList.length<8){
                                for(var i=0; i<global_obj.companyList.length;i++){
                                    html = '<option  style="margin-left: 15px;">'+global_obj.companyList[i].companyName+'</option >'+html;
                                }
                            }else {
                                for(var i=0; i<8;i++){
                                    html = '<option  style="margin-left: 15px;">'+global_obj.companyList[i].companyName+'</option >'+html;
                                }
                            }
                        }else{
                            //html= '<option style="text-align:center;">没有匹配项</option >' ;
                            $("#"+$select).animate({height:'0px'},"fast");
                            $("#"+$select).addClass("layui-hide");
                        }
                        $("#"+$select).append(html);
                        if(html!=""){
                            $("#"+$select).removeClass("layui-hide");
                            $("#"+$select).addClass("demo").animate({height:'158px'},"fast");
                        }else{
                            $("#"+$select).animate({height:'0px'},"fast");
                            $("#"+$select).addClass("layui-hide");
                        }

                    }
                });

            }else{
                $("#"+$select).animate({height:'0px'},"fast");
                $("#"+$select).addClass("layui-hide");
                $("#"+$select).empty();
                $("#"+$select).find("option").remove();

            }

        });
        $("#"+$select).change(function(){
            $("#"+$select).css("background-color","#ffffff");
            $("#"+$companyName).val($("#"+$select).find("option:selected").text());
            $("#"+$form).trigger("click");
            $("#"+$select).empty();
            $("#"+$select).animate({height:'0px'},"fast");
            $("#"+$select).addClass("layui-hide");
            // $("#"+$labelTip).hide();
        });
        //模糊查询,由于创表名字问题,其中查询字段根据实际修改
        var active = {
            searchReload: function(data){
                var companyName = $("#"+$companyName).val();
                var searchContent ="";
                for(var id in data){
                    var flag=true;
                    var type=$("[name='"+id+"']").attr("type");
                    if(type=="select-one" || type==undefined || id=="industryids"){
                        flag=false;
                    }
                    if(flag==true){
                        searchContent=searchContent+" "+data[id];
                    }
                    if(id=="searchTime"){
                        if(data[id]!=null&&data[id]!=undefined){
                            var searchTime=data[id].split('~');
                            var startTime=$.trim(searchTime[0]);
                            var endTime=$.trim(searchTime[1]);
                            data.startTime=startTime;
                            data.endTime=endTime;
                        }
                    }
                }
                var content="";
                if(searchContent!=""){
                    content=content+" "+searchContent;
                }
                if(searchContent!=''){
                    $("#"+$labelTip).text(content);
                    $("#"+$labelTip).attr("title",content);
                }else {
                    $("#"+$labelTip).text("");
                    $("#"+$labelTip).removeAttr("title");
                }
                data.companyName=companyName;
                //执行重载
                table.reload($table, {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    ,where: data
                });
            }
            ,
            searchShow: function(){
                $("#"+$divPanel).removeClass("layui-hide");
                if(flag){
                    $("#"+$divPanel).addClass("divPanel").animate({height:'250px'},"fast");
                }else {
                    $("#"+$divPanel).addClass("divPanel").animate({height:'150px'},"fast");
                }
                $("#"+$searchShow).addClass("layui-hide");
                $("#"+$searchHide).removeClass("layui-hide");
                form.render(null, $form);
                $("#"+$select).animate({height:'0px'},"fast");
                $("#"+$select).addClass("layui-hide");
            }
            ,searchHide: function(){
                $("#"+$divPanel).addClass("layui-hide");
                $("#"+$divPanel).animate({height:'0px'},"fast");
                $("#"+$searchHide).addClass("layui-hide");
                $("#"+$searchShow).removeClass("layui-hide");
                $("#"+$select).animate({height:'0px'},"fast");
                $("#"+$select).addClass("layui-hide");
            }
            ,reset:function () {
                form.render(null, $form);
                $("#"+$divPanel+" input").val("");
                $("#"+$divPanel+" select").val("");
                $("#"+$companyName).val("");
                $("#"+$form).trigger("click");
                $("#"+$labelTip).text("");
                $("#"+$select).animate({height:'0px'},"fast");
                $("#"+$select).addClass("layui-hide");
                // if(global_obj.industryList!=undefined & global_obj.industryList!=null){
                //     layui.each(global_obj.industryList, function(index, item){
                //         item.nocheck=false;
                //         item.checked=false;
                //     });
                //     jQuery.fn.zTree.init(jQuery("#treeIndustry"), setting, global_obj.industryList);
                // }
                // form.render(null, $form);
            }
        };


        $('#'+$search).bind('click', function(){
            $("#"+$select).animate({height:'0px'},"fast");
            $("#"+$select).addClass("layui-hide");
            $("#"+$form).trigger("click");
        });

        $("#"+$searchShow).bind('click', function(){
            active.searchShow();
        });

        $("#"+$searchHide).bind('click', function(){
            active.searchHide();
        });

        $("#"+$reset).bind("click",function () {
            active.reset();
        });

        $("#resetReload").bind("click",function () {
           active.reset();
        });

        //修改和增加
        form.on('submit('+$form+')', function(data){
            active.searchReload(data.field);
            return false
        });
    }
    ,serializeObject:function ($,form) {
        var o={};
        $("#"+form+" input").each(function (index) { //取得整个页面的input值
            var key = $(this).attr("name");
            if(key!="searchTime"){
                o[key]=$("#"+form+" [name='"+key+"']").val();
            }else{
                var time=$("#"+form+" [name='"+key+"']").val();
                if(time!=null && time!=undefined && time!=""){
                    var searchTime=time.split('~');
                    var startTime=$.trim(searchTime[0]);
                    var endTime=$.trim(searchTime[1]);
                    o.startTime=startTime;
                    o.endTime=endTime;
                }
            }
        });
        $("#"+form+" select").each(function (index) { //取得整个页面的select值
            var key = $(this).attr("name");
            o[key]=$("#"+form+" [name='"+key+"']").val();
        });
        return o;
    }
    ,exportCommon:function ($,criterias,likeColumns,equalColumns,$divPanel,dateColumn) {
        $("#"+$divPanel+" input").each(function (index) { //取得整个页面的input值
            var key = $(this).attr("name");
            var type=$(this).attr("type");
            debugger;
            if(key!=null&&key!=""&&key!=undefined&&type!="hidden"&key!="industrySel"){
                if(key!="searchTime"){
                    if(key!="batchTime"){
                        var value=$("#"+$divPanel+" [name='"+key+"']").val();
                        if(value!=null && value!=undefined && value!=""){
                            var likeColumn={column:key,value:value};
                            likeColumns.push(likeColumn);

                        }
                    }else{
                        var value=$("#"+$divPanel+" [name='"+key+"']").val();
                        if(value!=null&&value!=undefined&&value!=""){
                            var equalColumn={column:key,value:value};
                            equalColumns.push(equalColumn);
                        }
                    }
                }else{
                    var time=$("#"+$divPanel+" [name='"+key+"']").val();
                    if(time!=null&&time!=undefined&&time!=''){
                        var searchTime=time.split('~');
                        var startTime=$.trim(searchTime[0]);
                        var endTime=$.trim(searchTime[1]);

                        if (startTime == null || endTime == '') {
                            dateColumn = null;
                        }
                        criterias.startDate = startTime;
                        criterias.endDate = endTime;
                        criterias.dateColumn = dateColumn;
                    }
                }
            }
        });

        $("#"+$divPanel+" select").each(function (index) { //取得整个页面的select值
            var key = $(this).attr("name");
            var value=$("#"+$divPanel+" [name='"+key+"']").val();
            if(key!=null&&key!=""&&key!=undefined){
                if(key!="lawEnforcementType"){
                    if(value!=null&&value!=undefined&&value!=""){
                        var equalColumn={column:key,value:value};
                        equalColumns.push(equalColumn);
                    }
                }else{
                    if(value!=null&&value!=undefined&&value!=""){
                        criterias.backup="FIND_IN_SET('"+value+"',lawEnforcementType)";
                    }else {
                        criterias.backup=null;
                    }
                }
            }
        });
    }
};