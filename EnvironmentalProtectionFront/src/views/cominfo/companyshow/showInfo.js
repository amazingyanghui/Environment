function showFileView(viewfile,remoteServiceAddress) {

    if(viewfile==null || viewfile=="undefined" ||viewfile==""){
        layer.msg('附件没有上传！');
        return false;
    }
    var content='<div class="layui-fluid">\n' +
        '        <div class="layui-row layui-col-space15">\n' +
        '            <div class="layui-card-body">\n' +
        '                <div class="layui-col-md12">\n' +
        '                    <!--火狐浏览器兼容-->\n' +
        '                    <iframe id="pdf_frame"  name="pdf_frame" style="width:100%;height: 600px;display: none"></iframe>\n' +
        '                    <div id="attachment_file"></div>\n' +
        '                </div>\n' +
        '                <a id="common_download_btn" class="layui-btn layui-btn-sm" style="float: right;text-align: center;font-size:12px"><i class="layui-icon layui-icon-download-circle"></i>&nbsp;下载</a>\n' +
        '            </div>\n' +
        '        </div>\n' +
        '    </div>';
    var height = (window.innerHeight ) + 'px';
    var index = layui.layer.open({
        type: 1
        , title: '附件预览'
        , area: ['70%', '90%']
        // offset: '120px',
        , content: content
    });

    $("#common_download_btn").bind('click', function () {
        location.href = remoteServiceAddress + "/sys/file/download?file=" + encodeURI(viewfile);
    });

    var viewfile_array = viewfile.split(".");
    var type = viewfile_array[viewfile_array.length - 1];
    if (type == null || type == undefined) {
        layer.msg('附件的文件名错误!');
        return false;
    }
    if (type == 'pdf') {
        $('#doc_attachment').remove();
        $('#attachment_file').html();
        var options = {
            height: height,
            pdfOpenParams: {
                pagemode: "thumbs",
                navpanes: 0,
                toolbar: 0,
                scrollbar: 700,
                statusbar: 0
            }
        };
        PDFObject.embed(remoteServiceAddress + viewfile, "#attachment_file", options);
    } else if (type == 'doc' || type == 'docx' ||type == 'xlsx'|| type == 'xls') {
        $.ajax({
            type:"GET"
            ,beforeSend: function (XMLHttpRequest) {
                XMLHttpRequest.setRequestHeader("access_token",token);
            }
            ,url: remoteServiceAddress + "/cominfo/cominfobaseinfoattachment/view",
            data: {
                "filepath": viewfile
            },
            success: function (result) {
                if (result.htmlfile.src == '') {
                    layer.msg('附件不存在!');
                } else {
                    $('#attachment_file').html('');
                    $('#doc_attachment').remove();
                    $('#attachment_file').after('<iframe src=' + remoteServiceAddress + result.htmlfile.src + ' style="width:100%;height:'+height+'" id="doc_attachment" ></iframe>');
                }
            }
        });
    } else if (type == 'jpg' || type == 'jpeg' || type == 'png' || type == 'gif') {
        $('#attachment_file').after('<iframe src=' + remoteServiceAddress + viewfile + ' style="width:100%;height:'+height+'" id="doc_attachment" ></iframe>');
    } else {
        alert(type + '类型的附件暂不支持预览！');
        // layer.close(index);
    }
}
//排放情况取值
function measureData(url,pid) {
    $.ajax({
        type: 'GET',
        url: url+"/"+pid,
        beforeSend: function (XMLHttpRequest) {
            XMLHttpRequest.setRequestHeader("access_token",JSON.parse(localStorage["layuiAdmin"]).access_token);
        },
        success: function (result) {
            for(var id in result.onlineMonitorPortinfo){
                $("#LAY-online-MeasureWaste"+pid+" [name="+id+"]").val(result.onlineMonitorPortinfo[id]);
            }
            $("#LAY-online-MeasureWaste"+pid+" .reporttable input").attr("readonly","readonly").attr("style","border:none");
        }
        ,error:function () {
        }
    });
}
function pointFactorTpl($,remoteServiceAddress,mid,measureType) {
    //因子
    $.ajax({
        type: 'GET',
        url: remoteServiceAddress+"/online/onlinemonitorpointfactor/dataByMid/"+mid,
        beforeSend: function (XMLHttpRequest) {
            XMLHttpRequest.setRequestHeader("access_token",JSON.parse(localStorage["layuiAdmin"]).access_token);
        },
        success: function (result) {
            $("#pointFactor"+measureType).html("");
            var pointFactor=$("#pointFactor"+measureType);
            var factorList=result.factorList;
            var labela=$("<label>").attr("style","margin-left:50px;margin-right:16px;").text("因子：");
            pointFactor.append(labela);
            for(var i=0;i<factorList.length;i++){
                var input=$("<input>").attr("value",factorList[i].fid).attr("type","checkbox").attr("id","checkbox-"+i+measureType).attr("style","display: none;");
                // var input=$("<input>").attr("value",factorList[i].fid).attr("type","checkbox").attr("id","checkbox-"+i);
                var labelb=$("<label>").attr("style","margin-left:10px").attr("for","checkbox-"+i+measureType);
                var span=$("<span>").text(factorList[i].factorName).attr("style","margin-left:5px;");
                pointFactor.append(input);
                pointFactor.append(labelb);
                pointFactor.append(span);

            }
            $("#pointFactor"+measureType+" [for^='checkbox-']").bind("click",function () {
                var checkboxFor=$(this).attr("for");
                var isChecked=$("#pointFactor"+measureType+" #"+checkboxFor+":checked").prop("checked");
                var factor=$("#pointFactor"+measureType+" #"+checkboxFor).val();
                if(isChecked==true){
                    HighChartsUtil.removeByValue(HighChartsUtil.list,factor);
                }else {
                    HighChartsUtil.list.push(factor);
                }
            });
        }
        ,error:function () {
        }
    });
}
function comInfoReloadTpl($,pid,remoteServiceAddress,measureType) {
    // var likeColumns=[{"cid":pid}];
    var searchStatus=$("#measure-info"+measureType+" .layui-this").attr("name");
    // var startDate=$("#startDate"+measureType).val();
    // var endDate=$("#endDate"+measureType).val();
    // var likeColumnStart={"startDate":startDate};
    // var likeColumnEnd={"endDate":endDate};
    // likeColumns.push(likeColumnStart);
    // likeColumns.push(likeColumnEnd);
    var type= 1;
    // if(searchStatus.length>0){
    //     var likeColumn={"mid":searchStatus};
    //     likeColumns.push(likeColumn);
    // }
    var url=remoteServiceAddress+"/online/onlinemonitorhourdata/testData";
    if(type==1){
        url=remoteServiceAddress+"/online/onlinemonitordaydata/testData";
    }
    measureHighChart($,url,pid,searchStatus,measureType,type);
}
function firstClickTpl($,remoteServiceAddress,pid,measureType,mid) {
    // var likeColumns=[{"cid":pid},{"mid":mid}];
    var differType= 1;
    // var startDate=$("#startDate"+measureType).val();
    // var endDate=$("#endDate"+measureType).val();
    // var likeColumnStart={"startDate":startDate};
    // var likeColumnEnd={"endDate":endDate};
    // likeColumns.push(likeColumnStart);
    // likeColumns.push(likeColumnEnd);
    if(HighChartsUtil.list.length>0){

    }
    var url=remoteServiceAddress+"/online/onlinemonitorhourdata/testData";
    if(differType==1){
        url=remoteServiceAddress+"/online/onlinemonitordaydata/testData";
    }

    measureHighChart($,url,pid,mid,measureType,differType);
    // $('#com-info'+measureType+' li').bind('click', function(){
    //     // var mid=$("#measure-info"+measureType+" .layui-this").attr("name");
    // });
    //
    // $("#firstClick0").trigger('click');
    // $("#firstClick1").trigger('click');
    // $("#firstClick2").trigger('click');
}

function measureHighChart($,url,pid,mid,measureType,differType) {
//        var categories=[];
    var startDate=$("#startDate"+measureType).val();
    var endDate=$("#endDate"+measureType).val();
    var series=[];
    var names=[];
    //x轴起始时间
    var year=new Date(startDate).getFullYear();
    var month=new Date(startDate).getMonth();
    var day=new Date(startDate).getDate();
    var pointStart=Date.UTC(year, month, day, 0, 0, 0);
    //x轴时间间隔
    var pointInterval=3600000;
    if(differType==1){
        pointInterval=3600000*24;
    }
    $.ajax({
        type: 'POST',
        url: url,
        data:{"cid":pid,"mid":mid,"startDate":startDate,"endDate":endDate,"factorList":JSON.stringify(HighChartsUtil.list)},
        beforeSend: function (XMLHttpRequest) {
            XMLHttpRequest.setRequestHeader("access_token",JSON.parse(localStorage["layuiAdmin"]).access_token);
        },
        success: function (result) {
            for(var i=0;i<result.testData.length;i++){
                var data=result.testData[i];
                //                    categories=result.categories[i];
                names=result.names[i];
                if(result.isEnvironmentFactorList[i]==0){
                    var serie={name:names,data:data,yAxis:1};
                    series.push(serie);
                }else{
                    var serie={name:names,data:data,yAxis:0};
                    series.push(serie);
                }
            }
            var elem='on-line-monitoring'+differType+measureType;
            drawChartOnlineTpl(elem, pointInterval, pointStart, series);
        }
        ,error:function () {
        }
    });
}

function onlineTableTpl(type) {
    var onlineTable='<div>\n' +
        '                    <label style="margin-left: 20px">开始时间：</label>\n' +
        '                    <input class="show-input" id="startDate'+type+'">\n' +
        '                    <label style="margin-left: 20px">结束时间：</label>\n' +
        '                    <input class="show-input" id="endDate'+type+'">\n' +
        '                    <button style="margin-left: 20px" class="layui-btn" data-type="comInfoReload'+type+'" id="comInfoReload'+type+'">\n' +
        '                        搜索\n' +
        '                    </button>\n' +
        '                </div>\n' +
        // '                <div id="pointFactor'+type+'" style="margin-top: 10px">\n' +
        // '                </div>\n' +
        '                <div class="layui-tab layui-tab-card" style="margin-top: 10px">\n' +
        // '                    <ul class="layui-tab-title" id="com-info'+type+'">\n' +
        // '                        <li id="firstClick'+type+'" value="1">在线监控</li>\n' +
        // // '                        <li  value="1">日均</li>\n' +
        // '                    </ul>\n' +
        '                    <div class="layui-tab-content">\n' +
        '                        <div class="layui-tab-item layui-show">\n' +
        '                            <div id="on-line-monitoring1'+type+'" style="max-width:98%;height:400px"></div>\n' +
        '                        </div>\n' +
        // '                        <div class="layui-tab-item">\n' +
        // '                            <div id="on-line-monitoring1'+type+'" style="max-width:98%;height:400px"></div>\n' +
        // '                        </div>\n' +
        '                    </div>\n' +
        '                </div>';
    return onlineTable;
}

//在线监控时间
function onlineDate() {
    layui.laydate.render({
        elem: '#startDate0' //或 elem: document.getElementById('test')、elem: lay('#test') 等
        ,type: 'date'
        ,value:new Date(new Date()-1000*60*60*24*7)
        // ,done: function(value, date){
        //     var year=new Date(value).getFullYear();
        //     var month=new Date(value).getMonth();
        //     var day=new Date(value).getDate();
        //     var date_value=Date.UTC(year, month, day, 0, 0, 0)+1000*60*60*24*7;
        //     layui.laydate.render({
        //         elem: '#endDate0' //或 elem: document.getElementById('test')、elem: lay('#test') 等
        //         ,type: 'date'
        //         ,value:new Date(date_value)
        //     });
        // }
    });

    layui.laydate.render({
        elem: '#endDate0' //或 elem: document.getElementById('test')、elem: lay('#test') 等
        ,type: 'date'
        ,value:new Date()
        // ,done: function(value, date){
        //     var year=new Date(value).getFullYear();
        //     var month=new Date(value).getMonth();
        //     var day=new Date(value).getDate();
        //     var date_value=Date.UTC(year, month, day, 0, 0, 0)-1000*60*60*24*7;
        //     layui.laydate.render({
        //         elem: '#startDate0' //或 elem: document.getElementById('test')、elem: lay('#test') 等
        //         ,type: 'date'
        //         ,value:new Date(date_value)
        //     });
        // }
    });
    layui.laydate.render({
        elem: '#startDate1' //或 elem: document.getElementById('test')、elem: lay('#test') 等
        ,type: 'date'
        ,value:new Date(new Date()-1000*60*60*24*7)
        // ,done: function(value, date){
        //     var year=new Date(value).getFullYear();
        //     var month=new Date(value).getMonth();
        //     var day=new Date(value).getDate();
        //     var date_value=Date.UTC(year, month, day, 0, 0, 0)+1000*60*60*24*7;
        //     layui.laydate.render({
        //         elem: '#endDate1' //或 elem: document.getElementById('test')、elem: lay('#test') 等
        //         ,type: 'date'
        //         ,value:new Date(date_value)
        //     });
        // }
    });

    layui.laydate.render({
        elem: '#endDate1' //或 elem: document.getElementById('test')、elem: lay('#test') 等
        ,type: 'date'
        ,value:new Date()
        // ,done: function(value, date){
        //     var year=new Date(value).getFullYear();
        //     var month=new Date(value).getMonth();
        //     var day=new Date(value).getDate();
        //     var date_value=Date.UTC(year, month, day, 0, 0, 0)-1000*60*60*24*7;
        //     layui.laydate.render({
        //         elem: '#startDate1' //或 elem: document.getElementById('test')、elem: lay('#test') 等
        //         ,type: 'date'
        //         ,value:new Date(date_value)
        //     });
        // }
    });
    layui.laydate.render({
        elem: '#startDate2' //或 elem: document.getElementById('test')、elem: lay('#test') 等
        ,type: 'date'
        ,value:new Date(new Date()-1000*60*60*24*7)
        // ,done: function(value, date){
        //     var year=new Date(value).getFullYear();
        //     var month=new Date(value).getMonth();
        //     var day=new Date(value).getDate();
        //     var date_value=Date.UTC(year, month, day, 0, 0, 0)+1000*60*60*24*7;
        //     layui.laydate.render({
        //         elem: '#endDate2' //或 elem: document.getElementById('test')、elem: lay('#test') 等
        //         ,type: 'date'
        //         ,value:new Date(date_value)
        //     });
        // }
    });

    layui.laydate.render({
        elem: '#endDate2' //或 elem: document.getElementById('test')、elem: lay('#test') 等
        ,type: 'date'
        ,value:new Date()
        // ,done: function(value, date){
        //     var year=new Date(value).getFullYear();
        //     var month=new Date(value).getMonth();
        //     var day=new Date(value).getDate();
        //     var date_value=Date.UTC(year, month, day, 0, 0, 0)-1000*60*60*24*7;
        //     layui.laydate.render({
        //         elem: '#startDate2' //或 elem: document.getElementById('test')、elem: lay('#test') 等
        //         ,type: 'date'
        //         ,value:new Date(date_value)
        //     });
        // }
    });
}

function drawChartOnlineTpl($dom, pointInterval, pointStart, series) {
    var chart = Highcharts.chart($dom, {
        chart: {
            type: 'spline'
        },
        title: {
            text: HighChartsUtil.title
        },
        xAxis: {
            type: 'datetime',
            labels: {
                overflow: 'justify'
            }
        },
        yAxis:[{
            lineWidth : 1,
            title:{
                text :"浓度"
            }
        },{
            title:{
                text :'排放量'
            },
            lineWidth : 1,
            opposite:true
        }],
        tooltip: {
            crosshairs: true,
            shared: true
        },
        plotOptions: {
            spline: {
                lineWidth: 2,
                states: {
                    hover: {
                        lineWidth: 3
                    }
                },
                marker: {
                    enabled: false
                },
                pointInterval: pointInterval, // one hour
                pointStart: pointStart
            }
        },
        series: series,
        credits: {
            enabled: false
        },
        responsive: {
            rules: [{
                condition: {
                    maxWidth: 500
                },
                chartOptions: {
                    legend: {
                        layout: 'horizontal',
                        align: 'center',
                        verticalAlign: 'bottom'
                    }
                }
            }]
        }
    });
}

function comInfoPortTpl(data,count,measureInfo,measureWaste,remoteServiceAddress) {
    var table='<div class="layui-tab layui-tab-brief">\n' +
        '                        <ul class="layui-tab-title" id="center_measure_info'+data.id+'">\n' +
        '                            <li id="center_measure_firstClick'+data.id+'" value="0" class="layui-this">基本信息</li>\n' +
        '                            <li value="1">治理设施</li>\n' +
        '                            <li value="2">维护记录</li>\n' +
        '                            <li value="3">排口照片</li>'+
        '                            <li value="4" name="hideLiFourOnline'+data.id+'">监测数据</li>'+
        '                            <li value="5">排污系数</li>'+
        '                        </ul>\n' +
        '                        <div class="layui-tab-content">\n' +
        '                            <div class="layui-tab-item layui-show">\n' +
        '                                <div id="Lay_measure_center_content'+data.id+'0"></div>\n' +
        '                            </div>\n' +
        '                            <div class="layui-tab-item">\n' +
        '                                <table id="Lay_measure_center_content'+data.id+'1" lay-filter="Lay_measure_center_content'+data.id+'1"></table>\n' +
        '                            </div>\n' +
        '                            <div class="layui-tab-item">\n' +
        '                                <div class="layui-inline" style="margin-bottom: 10px">\n'+
        '                                   <span>治理设施：</span>'+
        '                                   <div class="layui-inline" style="margin-right: 10px;">'+
        '                                       <select id="governFacility'+data.id+'" style="width: 150px;height: 32px;border-color:#e6e6e6;cursor: pointer">'+
        '                                       </select>'+
        '                                   </div>'+
        '                                   <span>维护时间：</span>'+
        '                                   <div class="layui-inline">' +
        '                                       <input  class="layui-input myinput" id="startTime'+data.id+'"  name="startTime" autocomplete="off" placeholder="请选择日期" style="width:150px;">'+
        '                                   </div>'+
        '                                   <button style="margin-left: 20px" value="'+data.id+'" class="layui-btn" id="governFacilityReload'+data.id+'">搜索</button>'+
        '                                </div>\n'+
        '                                <table id="Lay_measure_center_content'+data.id+'2" lay-filter="Lay_measure_center_content'+data.id+'2"></table>\n' +
        '                            </div>\n' +
        '                            <div class="layui-tab-item">\n' +
        '                              <div style="height: 265px">\n' +
        '                                 <div class="layui-col-md12" style="margin-top: 10px;">\n' +
        '                                    <img name="hideImg'+data.id+'" src="'+remoteServiceAddress+data.code+'" style="height: 254px">\n' +
        '                                 </div>\n' +
        '                              </div>' +
        '                            </div>\n' +
        '                            <div class="layui-tab-item" name="hideDivFourOnline'+data.id+'">\n' +
        '                              <div style="height: 265px">\n' +
        '                                 <div class="layui-col-md12" style="margin-top: 10px;">\n' +
        '                                    <table id="Lay_measure_center_content'+data.id+'4" lay-filter="Lay_measure_center_content'+data.id+'4"></table>\n' +
        '                                 </div>\n' +
        '                              </div>' +
        '                            </div>\n' +
        '                            <div class="layui-tab-item">\n' +
        '                              <div style="height: 265px">\n' +
        '                                 <div class="layui-col-md12" style="margin-top: 10px;">\n' +
        '                                    <table id="Lay_measure_center_content'+data.id+'5" lay-filter="Lay_measure_center_content'+data.id+'5"></table>\n' +
        '                                 </div>\n' +
        '                              </div>' +
        '                            </div>\n' +
        '                        </div>\n' +
        '                    </div>';
    var li=$("<li>").val(count).text(data.name).attr("id","measureClick"+data.type).attr("name",data.id);
    var div=$("<div>").addClass("layui-tab-item layui-show");
    var divChildren=$("<div>").attr("id","LAY-online-MeasureWaste"+data.id);
    if(count>0){
        li=$("<li>").val(count).text(data.name).attr("name",data.id);
        div=$("<div>").addClass("layui-tab-item");
    }
    div.append(divChildren);
    measureInfo.append(li);
    measureWaste.append(div);
    var divChildrenChildren=$("#LAY-online-MeasureWaste"+data.id);
    divChildrenChildren.html(table);
    if(data.code=="undefined" || data.code==null || data.code==''){
        $("[name='hideImg"+data.id+"']").addClass("layui-hide");
    }
}

//治理设施取值
function wasteData(remoteServiceAddress,mid,value,differType) {
    layui.laydate.render({
        elem: '#startTime'+mid
        ,type: 'month'
        ,value:new Date()
    });
    var url=remoteServiceAddress+"/market/cominfomeasurewastewater/list";
    var cols=[[
        {type: 'numbers', unresize: true, title: '序号'}
        ,{field: 'measureName', title: '设施名称', width: 120,unresize: true,event:"setName",style:"color:blue;cursor:pointer;"}
        // ,{field: 'blowDownOutLetName', title: '对应排污口', width: 110,unresize: true}
        ,{field: 'model', title: '规格型号', width: 100,unresize: true}
        ,{field: 'process', title: '处理工艺', width: 100,unresize: true}
        ,{field: 'wastewaterCategoryName', title: '废水类别', width: 100,unresize: true}
        ,{field: 'removalOfMaterialName', title: '主要去除物质', minWidth: 120,unresize: true}
        // ,{field: 'totalInvestment', title: '总投资额（万元）', minWidth: 150,unresize: true}
        ,{field: 'deliveryDate', title: '投运日期', minWidth: 180,unresize: true}
        // ,{field: 'processingCapacity', title: '设计处理能力（吨/天）', minWidth: 180,unresize: true}
        // ,{field: 'actualProcessing', title: '实际处理能力（吨/天）', minWidth: 180,unresize: true}
        ,{field: 'runningState', title: '运行状态', width: 100,unresize: true}
        // ,{field: 'yearThroughput', title: '年处理量（吨）', minWidth: 130,unresize: true}
        // ,{field: 'yearOperatingCost', title: '年运行费用（万元）', minWidth: 170,unresize: true}
        // ,{field: 'remarks', title: '备注', width: 100,unresize: true}
    ]];
    var height="254px";
    var data={"mid":mid};
    if(differType==1&value==1){
        url=remoteServiceAddress+"/market/cominfomeasurewastegas/list";
        cols=[[
            {type: 'numbers', unresize: true, title: '序号'}
            ,{field: 'measureName', title: '设施名称', minWidth: 100,unresize: true,event:"setName",style:"color:blue;cursor:pointer;"}
            // ,{field: 'blowDownOutLetName', title: '对应排污口', width: 110,unresize: true}
            ,{field: 'model', title: '规格型号', minWidth: 100,unresize: true}
            ,{field: 'process', title: '处理工艺', minWidth: 100,unresize: true}
            // ,{field: 'totalInvestment', title: '总投资额（万元）', minWidth: 150,unresize: true}
            ,{field: 'deliveryDate', title: '投运日期', minWidth: 180,unresize: true}
            // ,{field: 'processingCapacity', title: '设计处理能力（标立方米/小时）', minWidth: 240,unresize: true}
            // ,{field: 'actualProcessing', title: '实际处理能力（标立方米/小时）', minWidth: 240,unresize: true}
            ,{field: 'runningState', title: '运行状态', minWidth: 100,unresize: true}
            // ,{field: 'yearThroughput', title: '年处理量（吨）', minWidth: 130,unresize: true}
            // ,{field: 'yearOperatingCost', title: '年运行费用（万元）', minWidth: 170,unresize: true}
            // ,{field: 'remarks', title: '备注',width:100,unresize: true}
        ]];
    }
    if(differType==2&value==1){
        url=remoteServiceAddress+"/market/cominfomeasurewastevocs/list";
        cols=[[
            {type: 'numbers', unresize: true, title: '序号'}
            ,{field: 'measureName', title: '设施名称', minWidth: 100,unresize: true,event:"setName",style:"color:blue;cursor:pointer;"}
            // ,{field: 'blowDownOutLetName', title: '对应排污口', width: 110,unresize: true}
            ,{field: 'model', title: '规格型号', minWidth: 100,unresize: true}
            ,{field: 'process', title: '处理工艺', minWidth: 100,unresize: true}
            // ,{field: 'totalInvestment', title: '总投资额（万元）', minWidth: 150,unresize: true}
            ,{field: 'deliveryDate', title: '投运日期', minWidth: 180,unresize: true}
            // ,{field: 'processingCapacity', title: '设计处理能力（标立方米/小时）', minWidth: 240,unresize: true}
            // ,{field: 'actualProcessing', title: '实际处理能力（标立方米/小时）', minWidth: 240,unresize: true}
            ,{field: 'runningState', title: '运行状态', minWidth: 100,unresize: true}
            // ,{field: 'yearThroughput', title: '年处理量（吨）', minWidth: 130,unresize: true}
            // ,{field: 'yearOperatingCost', title: '年运行费用（万元）', minWidth: 170,unresize: true}
            // ,{field: 'remarks', title: '备注',width:100,unresize: true}
        ]];
    }
    if(value==2){
        url=remoteServiceAddress+"/cominfo/cominforepairrecord";
        cols=[[
            {type: 'numbers', unresize: true, title: '序号'}
            ,{field: 'repairPerson', title: '维护人', minWidth: 100,unresize: true}
            ,{field: 'repairContent', title: '维护内容', minWidth: 100,unresize: true}
            ,{field: 'repairCondition', title: '维护情况', minWidth: 100,unresize: true}
            ,{field: 'repairDate', title: '维护时间', minWidth: 100,unresize: true}
        ]];
        height='212px';
        var startTime=$("#startTime"+mid).val();
        data={"mid":mid,"startTime":startTime}
    }
    if(differType==0 || differType==1){
        if(value==4){
            url=remoteServiceAddress+"/online/onlinemonitorwastewater/list";
            cols=[[
                {type: 'numbers', unresize: true, title: '序号'}
                ,{field: 'year', title: '年度', minWidth: 100}
                ,{field: 'fidName', title: '因子名称', minWidth: 100,event:"setName",style:"color:blue;cursor:pointer;"}
                ,{field: 'censusCode', title: '普查表号', minWidth: 100}
                ,{field: 'inletConcentration', title: '进口浓度', minWidth: 100}
                ,{field: 'outletConcentration', title: '出口浓度', minWidth: 100}
            ]];
            data={"mid":mid,type:differType};
        }
    }
    if(value==5){
        url=remoteServiceAddress+"/comInfo/enterprisesdischargecoefficient/queryData";
        cols=[[
            {type: 'numbers', unresize: true, title: '序号'}
            ,{field: 'accountingLink', title: '核算环节名称', minWidth: 110,unresize: true,event:"setName",style:"color:blue;cursor:pointer"}
            // ,{field: 'censusCode', title: '普查表号', minWidth: 110,unresize: true}
            // ,{field: 'monitorName', title: '排放口名称', minWidth: 110,unresize: true}
            ,{field: 'materialName', title: '原料名称', minWidth: 110,unresize: true}
            ,{field: 'productName', title: '产品名称', minWidth: 110,unresize: true}
            ,{field: 'processName', title: '工艺名称', minWidth: 110,unresize: true}
            ,{field: 'pollutantName', title: '污染物名称', minWidth: 110,unresize: true}
        ]]
        data={"mid":mid};
    }
    $.ajax({
        type: 'GET',
        url: url,
        data:data,
        beforeSend: function (XMLHttpRequest) {
            XMLHttpRequest.setRequestHeader("access_token",JSON.parse(localStorage["layuiAdmin"]).access_token);
        },
        success: function (result) {
            var data=JSON.parse(result).data;
            layui.table.render({//查询列表信息
                elem: '#Lay_measure_center_content'+mid+value
                ,page: false
                // ,event:true
                ,cols: cols
                ,skin: 'line'
                ,height:height
                // ,limit:5
                // ,limits:[5,10,15,20,25,30,35,40,45,50]
                ,done:function () {
                    $('#LAY-online-MeasureWaste'+mid+' tr th').css({'background-color': '#DBE8F8', 'color': '#4D77A3'});
                }
            });
            layui.table.reload("Lay_measure_center_content"+mid+value,{//查询列表信息
                data: data
            });

            layui.table.on("tool(Lay_measure_center_content"+mid+value+")",function (obj) {

                var data=obj.data;
                if (obj.event == 'setName') {

                    var table='<div class="layui-fluid">\n' +
                        '      <div class="layui-row layui-col-space15">\n' +
                        '        <!--<div class="layui-card-header">响应式组合</div>-->\n' +
                        '        <div class="layui-card-body">\n' +
                        '          <form class="layui-form" id="cominfoMeasureWastewateredit" action="" lay-filter="component-form-element">\n' +
                        '            <table class="reporttable">\n' +
                        '              <tr>\n' +
                        '                <td>设施名称：</td>\n' +
                        '                <td>\n' +
                        '                  <input type="text" name="measureName" lay-verify="required" readonly="readonly" value="'+data.measureName+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                        '                </td>\n' +
                        '                <td>对应排污口：</td>\n' +
                        '                <td>\n' +
                        '                  <input type="text" name="blowDownOutLetName" lay-verify="required" readonly="readonly" value="'+data.blowDownOutLetName+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                        '                </td>\n' +
                        '              </tr>\n' +
                        '              <tr>\n' +
                        '                <td>规格型号：</td>\n' +
                        '                <td>\n' +
                        '                  <input type="text" name="model" value="'+data.model+'" placeholder="" readonly="readonly" autocomplete="off" class="layui-input">\n' +
                        '                </td>\n' +
                        '                <td>处理工艺：</td>\n' +
                        '                <td>\n' +
                        '                  <input type="text" name="process" value="'+data.process+'" placeholder="" readonly="readonly" autocomplete="off" class="layui-input">\n' +
                        '                </td>\n' +
                        '              </tr>\n' +
                        '              <tr>\n' +
                        '                <td>废水类别：</td>\n' +
                        '                <td>\n' +
                        '                  <input type="text" name="wastewaterCategoryName" value="'+data.wastewaterCategoryName+'" readonly="readonly" placeholder="" autocomplete="off" class="layui-input">\n' +
                        '                </td>\n' +
                        '                <td>主要去除物质：</td>\n' +
                        '                <td>\n' +
                        '                  <input type="text" name="removalOfMaterialName" value="'+data.removalOfMaterialName+'" readonly="readonly" placeholder="" autocomplete="off" class="layui-input">\n' +
                        '                </td>\n' +
                        '              </tr>\n' +
                        '              <tr>\n' +
                        '                <td>总投资额（万元）：</td>\n' +
                        '                <td>\n' +
                        '                  <input type="text" name="totalInvestment" value="'+data.totalInvestment+'" readonly="readonly" placeholder="" autocomplete="off" class="layui-input">\n' +
                        '                </td>\n' +
                        '                <td>投运日期：</td>\n' +
                        '                <td>\n' +
                        '                  <input type="text" name="deliveryDate" value="'+data.deliveryDate+'" placeholder="" readonly="readonly" autocomplete="off" class="layui-input">\n' +
                        '                </td>\n' +
                        '              </tr>\n' +
                        '              <tr>\n' +
                        '                <td>设计处理能力（吨/天）：</td>\n' +
                        '                <td>\n' +
                        '                  <input type="text" name="processingCapacity" value="'+data.processingCapacity+'" readonly="readonly" placeholder="" autocomplete="off" class="layui-input">\n' +
                        '                </td>\n' +
                        '                <td>实际处理能力（吨/天）：</td>\n' +
                        '                <td>\n' +
                        '                  <input type="text" name="actualProcessing" value="'+data.actualProcessing+'" readonly="readonly" placeholder="" autocomplete="off" class="layui-input">\n' +
                        '                </td>\n' +
                        '              </tr>\n' +
                        '              <tr>\n' +
                        '                <td>运行状态：</td>\n' +
                        '                <td>\n' +
                        '                  <input type="text" name="runningState" value="'+data.runningState+'" readonly="readonly" placeholder="" autocomplete="off" class="layui-input">\n' +
                        '                </td>\n' +
                        '                <td>年处理量（吨）：</td>\n' +
                        '                <td>\n' +
                        '                  <input type="text" name="yearThroughput" value="'+data.yearThroughput+'" readonly="readonly" placeholder="" autocomplete="off" class="layui-input">\n' +
                        '                </td>\n' +
                        '              </tr>\n' +
                        '              <tr>\n' +
                        '                <td>年运行费用（万元）：</td>\n' +
                        '                <td>\n' +
                        '                  <input type="text" name="yearOperatingCost" value="'+data.yearOperatingCost+'" readonly="readonly" placeholder="" autocomplete="off" class="layui-input">\n' +
                        '                </td>\n' +
                        '                <td>日平均运行时间（小时）：</td>\n' +
                        '                <td>\n' +
                        '                  <input type="text" name="dayRuntime" value="'+data.dayRuntime+'" readonly="readonly" placeholder="" autocomplete="off" class="layui-input">\n' +
                        '                </td>\n' +
                        '              </tr>\n' +
                        '              <tr>\n' +
                        '                <td>治理期限：</td>\n' +
                        '                <td>\n' +
                        '                  <input type="text" name="governanceLimit" value="'+data.governanceLimit+'" readonly="readonly" placeholder="" autocomplete="off" class="layui-input">\n' +
                        '                </td>\n' +
                        '                <td>单台设计能力：</td>\n' +
                        '                <td>\n' +
                        '                  <input type="text" name="singleDesignCapability" value="'+data.singleDesignCapability+'" readonly="readonly" placeholder="" autocomplete="off" class="layui-input">\n' +
                        '                </td>\n' +
                        '              </tr>\n' +
                        '<tr>\n' +
                        '                            <td>其中：处理其他单位水量：</td>\n' +
                        '                            <td>\n' +
                        '                                <input type="text" name="handleOtherUnitwater" value="'+data.handleOtherUnitwater+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                        '                            </td>\n' +
                        '                            <td>加盖密闭情况：</td>\n' +
                        '                            <td>\n' +
                        '                                <input type="text" name="airtightSituation" value="'+data.airtightSituation+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                        '                            </td>\n' +
                        '                        </tr>\n' +
                        '                        <tr>\n' +
                        '                            <td>处理后废水去向：</td>\n' +
                        '                            <td>\n' +
                        '                                <input type="text" name="handleWhereabouts" value="'+data.handleWhereabouts+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                        '                            </td>\n' +
                        '                            <td>年运行小时：</td>\n' +
                        '                            <td>\n' +
                        '                                <input type="text" name="annualoPeratingHours" value="'+data.annualoPeratingHours+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                        '                            </td>\n' +
                        '                        </tr>'+
                        '              <tr>\n' +
                        '                <td>验收意见：</td>\n' +
                        '                <td colspan="3">\n' +
                        '                  <textarea type="text" name="acceptanceOpinion" style="resize: none;" readonly="readonly" placeholder="" autocomplete="off" class="layui-textarea">'+data.acceptanceOpinion+'</textarea>\n' +
                        '                </td>\n' +
                        '              </tr>\n' +
                        '              <tr>\n' +
                        '                <td>备注：</td>\n' +
                        '                <td colspan="3">\n' +
                        '                  <textarea type="text" name="remarks" style="resize: none;" readonly="readonly" placeholder="" autocomplete="off" class="layui-textarea">'+data.remarks+'</textarea>\n' +
                        '                </td>\n' +
                        '              </tr>\n' +
                        '            </table>\n' +
                        '          </form>\n' +
                        '        </div>\n' +
                        '      </div>\n' +
                        '    </div>';
                    if(differType!=0){
                        var editInfo='cominfoMeasureWastegasedit';
                        table='';
                        if(differType==2){
                            editInfo='cominfoMeasureWastevocsedit';
                        }
                        table+='<div class="layui-fluid">\n' +
                            '      <div class="layui-row layui-col-space15">\n' +
                            '        <!--<div class="layui-card-header">响应式组合</div>-->\n' +
                            '        <div class="layui-card-body">\n' +
                            '          <form class="layui-form" id="'+editInfo+'" action="" lay-filter="component-form-element">\n' +
                            '            <table class="reporttable">\n' +
                            '              <tr>\n' +
                            '                <td>设施名称：</td>\n' +
                            '                <td>\n' +
                            '                  <input type="text" name="measureName" lay-verify="required" readonly="readonly" value="'+data.measureName+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                </td>\n' +
                            '                <td>对应排污口：</td>\n' +
                            '                <td>\n' +
                            '                  <input type="text" name="blowDownOutLetName" lay-verify="required" readonly="readonly" value="'+data.blowDownOutLetName+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                </td>\n' +
                            '              </tr>\n' +
                            '              <tr>\n' +
                            '                <td>规格型号：</td>\n' +
                            '                <td>\n' +
                            '                  <input type="text" name="model" value="'+data.model+'" placeholder="" readonly="readonly" autocomplete="off" class="layui-input">\n' +
                            '                </td>\n' +
                            '                <td>处理工艺：</td>\n' +
                            '                <td>\n' +
                            '                  <input type="text" name="process" value="'+data.process+'" placeholder="" readonly="readonly" autocomplete="off" class="layui-input">\n' +
                            '                </td>\n' +
                            '              </tr>\n' +
                            '              <tr>\n' +
                            '                <td>总投资额（万元）：</td>\n' +
                            '                <td>\n' +
                            '                  <input type="text" name="totalInvestment" value="'+data.totalInvestment+'" readonly="readonly" placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                </td>\n' +
                            '                <td>投运日期：</td>\n' +
                            '                <td>\n' +
                            '                  <input type="text" id="deliveryDate1" name="deliveryDate" value="'+data.deliveryDate+'" readonly="readonly" placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                </td>\n' +
                            '              </tr>\n' +
                            '              <tr>\n' +
                            '                <td>设计处理能力（标立方米/小时）：</td>\n' +
                            '                <td>\n' +
                            '                  <input type="text" name="processingCapacity" value="'+data.processingCapacity+'" readonly="readonly" placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                </td>\n' +
                            '                <td>实际处理能力（标立方米/小时）：</td>\n' +
                            '                <td>\n' +
                            '                  <input type="text" name="actualProcessing" value="'+data.actualProcessing+'" readonly="readonly" placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                </td>\n' +
                            '              </tr>\n' +
                            '              <tr>\n' +
                            '                <td>运行状态：</td>\n' +
                            '                <td>\n' +
                            '                  <input type="text" name="runningState" value="'+data.runningState+'" readonly="readonly" placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                </td>\n' +
                            '                <td>年处理量（吨）：</td>\n' +
                            '                <td>\n' +
                            '                  <input type="text" name="yearThroughput" value="'+data.yearThroughput+'" readonly="readonly" placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                </td>\n' +
                            '              </tr>\n' +
                            '              <tr>\n' +
                            '                <td>年运行费用（万元）：</td>\n' +
                            '                <td>\n' +
                            '                  <input type="text" name="yearOperatingCost" value="'+data.yearOperatingCost+'" readonly="readonly" placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                </td>\n' +
                            '               <td>日平均运行时间（小时）：</td>\n' +
                            '               <td>\n' +
                            '                  <input type="text" name="dayRuntime" value="'+data.dayRuntime+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '               </td>' +
                            '              </tr>\n' +
                            '               <tr>\n' +
                            '                <td>治理期限：</td>\n' +
                            '                <td>\n' +
                            '                   <input type="text" name="governanceLimit" value="'+data.governanceLimit+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                </td>\n' +
                            '                <td>单台设计能力：</td>\n' +
                            '                <td>\n' +
                            '                   <input type="text" name="singleDesignCapability" value="'+data.singleDesignCapability+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                </td>\n' +
                            '               </tr>';
                        if(differType==1){
                            table+='<tr>\n' +
                                '                            <td>年运行时间：</td>\n' +
                                '                            <td>\n' +
                                '                                <input type="text" name="annualOperatingHours" value="'+data.annualOperatingHours+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                                '                            </td>\n' +
                                '                            <td>脱硫处理设施编号：</td>\n' +
                                '                            <td>\n' +
                                '                                <input type="text" name="sulfurRemoveDeviceCode" value="'+data.sulfurRemoveDeviceCode+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                                '                            </td>\n' +
                                '                        </tr>\n' +
                                '\n' +
                                '                        <tr>\n' +
                                '                            <td>脱硫处理工艺：</td>\n' +
                                '                            <td>\n' +
                                '                                <input type="text" name="sulfurEmoveTech" value="'+data.sulfurEmoveTech+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                                '                            </td>\n' +
                                '                            <td>脱硫处理效率：</td>\n' +
                                '                            <td>\n' +
                                '                                <input type="text" name="sulfurRemoveEfficiency" value="'+data.sulfurRemoveEfficiency+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                                '                            </td>\n' +
                                '                        </tr>\n' +
                                '\n' +
                                '\n' +
                                '                        <tr>\n' +
                                '                            <td>脱硫处理剂名称：</td>\n' +
                                '                            <td>\n' +
                                '                                <input type="text" name="sulfurRemoveChemical" value="'+data.sulfurRemoveChemical+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                                '                            </td>\n' +
                                '                            <td>脱硫处理剂使用量：</td>\n' +
                                '                            <td>\n' +
                                '                                <input type="text" name="sulfurRemoveAgent" value="'+data.sulfurRemoveAgent+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                                '                            </td>\n' +
                                '                        </tr>\n' +
                                '\n' +
                                '                        <tr>\n' +
                                '                            <td>是否采用低氮燃烧技术脱硫：</td>\n' +
                                '                            <td>\n' +
                                '                                <input type="text" name="isOwBurnRemoveSulfur" value="'+data.isOwBurnRemoveSulfur+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                                '                            </td>\n' +
                                '                            <td>脱硝处理设施编号：</td>\n' +
                                '                            <td>\n' +
                                '                                <input type="text" name="nitreRemoveDeviceCode" value="'+data.nitreRemoveDeviceCode+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                                '                            </td>\n' +
                                '                        </tr>\n' +
                                '\n' +
                                '                        <tr>\n' +
                                '                            <td>脱硝处理工艺：</td>\n' +
                                '                            <td>\n' +
                                '                                <input type="text" name="nitreRemoveTech" value="'+data.nitreRemoveTech+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                                '                            </td>\n' +
                                '                            <td>脱硝处理效率：</td>\n' +
                                '                            <td>\n' +
                                '                                <input type="text" name="nitreRemoveEfficiency" value="'+data.nitreRemoveEfficiency+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                                '                            </td>\n' +
                                '                        </tr>\n' +
                                '\n' +
                                '                        <tr>\n' +
                                '                            <td>脱硝处理剂名称：</td>\n' +
                                '                            <td>\n' +
                                '                                <input type="text" name="nitreRemoveChemical" value="'+data.nitreRemoveChemical+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                                '                            </td>\n' +
                                '                            <td>脱硝处理剂使用量：</td>\n' +
                                '                            <td>\n' +
                                '                                <input type="text" name="nitreRemoveAgent" value="'+data.nitreRemoveAgent+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                                '                            </td>\n' +
                                '                        </tr>\n' +
                                '\n' +
                                '                        <tr>\n' +
                                '                            <td>是否采用低氮燃烧技术脱硝：</td>\n' +
                                '                            <td>\n' +
                                '                                <input type="text" name="islowBurnRemovenitre" value="'+data.islowBurnRemovenitre+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                                '                            </td>\n' +
                                '                            <td>除尘处理设施编号：</td>\n' +
                                '                            <td>\n' +
                                '                                <input type="text" name="dustRemoveDeviceCode" value="'+data.dustRemoveDeviceCode+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                                '                            </td>\n' +
                                '                        </tr>\n' +
                                '\n' +
                                '                        <tr>\n' +
                                '                            <td>除尘处理工艺：</td>\n' +
                                '                            <td>\n' +
                                '                                <input type="text" name="dustRemoveTech" value="'+data.dustRemoveTech+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                                '                            </td>\n' +
                                '                            <td>除尘处理效率：</td>\n' +
                                '                            <td>\n' +
                                '                                <input type="text" name="dustRemoveEfficiency" value="'+data.dustRemoveEfficiency+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                                '                            </td>\n' +
                                '                        </tr>';
                        }
                            table+='              <tr>\n' +
                                '                <td>验收意见：</td>\n' +
                                '                <td colspan="3">\n' +
                                '                  <textarea type="text" name="acceptanceOpinion" style="resize: none;" readonly="readonly" placeholder="" autocomplete="off" class="layui-textarea">'+data.acceptanceOpinion+'</textarea>\n' +
                                '                </td>\n' +
                                '              </tr>\n' +
                            '              <tr>\n' +
                            '                <td>备注：</td>\n' +
                            '                <td colspan="3">\n' +
                            '                  <textarea type="text" name="remarks" style="resize: none;" readonly="readonly" placeholder="" autocomplete="off" class="layui-textarea">'+data.remarks+'</textarea>\n' +
                            '                </td>\n' +
                            '              </tr>\n' +
                            '            </table>\n' +
                            '          </form>\n' +
                            '        </div>\n' +
                            '      </div>\n' +
                            '    </div>'
                    }

                    if(differType==0 && value==4){
                        var year0=data.year==null?'':data.year;
                        var monitorName0=data.monitorName==null?'':data.monitorName;
                        var censusCode0=data.censusCode==null?'':data.censusCode;
                        var importWaterVolume=data.importWaterVolume==null?'':data.importWaterVolume;
                        var exportWaterVolume=data.exportWaterVolume==null?'':data.exportWaterVolume;
                        var fidName0=data.fidName==null?'':data.fidName;
                        var inletConcentration0=data.inletConcentration==null?'':data.inletConcentration;
                        var outletConcentration0=data.outletConcentration==null?'':data.outletConcentration;
                        var totalDisplacement=data.totalDisplacement==null?'':data.totalDisplacement;
                        var remarks0=data.remarks==null?'':data.remarks;
                        table='<div class="layui-fluid">\n' +
                            '        <div class="layui-row layui-col-space15">\n' +
                            '            <!--<div class="layui-card-header">响应式组合</div>-->\n' +
                            '            <div class="layui-card-body">\n' +
                            '                <form class="layui-form" id="onlineMonitorWasteWaterShow" action="" lay-filter="component-form-element">\n' +
                            '                    <table class="reporttable">\n' +
                            '                        <tr>\n' +
                            '                            <td>年度：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="year" value="'+year0+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                            <td>对应排污口：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="monitorName" value="'+monitorName0+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                        </tr>\n' +
                            '                        <tr>\n' +
                            '                            <td>普查表号：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="censusCode" value="'+censusCode0+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                            <td>因子名称：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="fidName" value="'+fidName0+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                        </tr>\n' +
                            '                        <tr>\n' +
                            '                            <td>进口水量：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="importWaterVolume" value="'+importWaterVolume+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                            <td>出口水量：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="exportWaterVolume" value="'+exportWaterVolume+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                        </tr>\n' +
                            '                        <tr>\n' +
                            '                            <td>进口浓度：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="inletConcentration" value="'+inletConcentration0+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                            <td>出口浓度：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="outletConcentration" value="'+outletConcentration0+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                        </tr>\n' +
                            '                        <tr>\n' +
                            '                            <td>经总排放口排放的水量：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="totalDisplacement" value="'+totalDisplacement+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                            <td></td>'+
                            '                            <td></td>'+
                            '                        </tr>\n' +
                            '                        <tr>\n' +
                            '                            <td>备注：</td>\n' +
                            '                            <td colspan="3">\n' +
                            '                                <textarea type="text" name="remarks" style="resize: none;" readonly placeholder="" autocomplete="off" class="layui-textarea">'+remarks0+'</textarea>\n' +
                            '                            </td>\n' +
                            '                        </tr>\n' +
                            '\n' +
                            '                    </table>\n' +
                            '                </form>\n' +
                            '            </div>\n' +
                            '        </div>\n' +
                            '    </div>';
                    }

                    if(differType==1 && value==4){
                        var year=data.year==null?'':data.year;
                        var monitorName=data.monitorName==null?'':data.monitorName;
                        var censusCode=data.censusCode==null?'':data.censusCode;
                        var fidName=data.fidName==null?'':data.fidName;
                        var displacement=data.displacement==null?'':data.displacement;
                        var annualEmissionTime=data.annualEmissionTime==null?'':data.annualEmissionTime;
                        var inletConcentration=data.inletConcentration==null?'':data.inletConcentration;
                        var outletConcentration=data.outletConcentration==null?'':data.outletConcentration;
                        var remarks=data.remarks==null?'':data.remarks;
                        table='<div class="layui-fluid">\n' +
                            '        <div class="layui-row layui-col-space15">\n' +
                            '            <!--<div class="layui-card-header">响应式组合</div>-->\n' +
                            '            <div class="layui-card-body">\n' +
                            '                <form class="layui-form" id="onlineMonitorWasteGasShow" action="" lay-filter="component-form-element">\n' +
                            '                    <table class="reporttable">\n' +
                            '                        <tr>\n' +
                            '                            <td>年度：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="year" value="'+year+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                            <td>对应排污口：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="monitorName" value="'+monitorName+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                        </tr>\n' +
                            '                        <tr>\n' +
                            '                            <td>普查表号：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="censusCode" value="'+censusCode+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                            <td>因子名称：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="fidName" value="'+fidName+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                        </tr>\n' +
                            '                        <tr>\n' +
                            '                            <td>平均流量：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="displacement" value="'+displacement+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                            <td>年排放天数：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="annualEmissionTime" value="'+annualEmissionTime+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '\n' +
                            '                        </tr>\n' +
                            '\n' +
                            '                        <tr>\n' +
                            '                            <td>进口浓度：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="inletConcentration" value="'+inletConcentration+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                            <td>出口浓度：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="outletConcentration" value="'+outletConcentration+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                        </tr>\n' +
                            '                        <tr>\n' +
                            '                            <td>备注：</td>\n' +
                            '                            <td colspan="3">\n' +
                            '                                <textarea type="text" name="remarks" style="resize: none;" placeholder="" autocomplete="off" class="layui-textarea">'+remarks+'</textarea>\n' +
                            '                            </td>\n' +
                            '                        </tr>\n' +
                            '                    </table>\n' +
                            '                </form>\n' +
                            '            </div>\n' +
                            '        </div>\n' +
                            '    </div>';
                    }
                    if(value==5){
                        var accountingLink5=data.accountingLink==null?'':data.accountingLink;
                        var monitorName5=data.monitorName==null?'':data.monitorName;
                        var censusCode5=data.censusCode==null?'':data.censusCode;
                        var materialName5=data.materialName==null?'':data.materialName;
                        var productName5=data.productName==null?'':data.productName;
                        var processName5=data.processName==null?'':data.processName;
                        var year5=data.year==null?'':data.year;
                        var productionGrade5=data.productionGrade==null?'':data.productionGrade;
                        var productOutput5=data.productOutput==null?'':data.productOutput;
                        var productOutputUnit5=data.productOutputUnit==null?'':data.productOutputUnit;
                        var rawMaterialConsumption5=data.rawMaterialConsumption==null?'':data.rawMaterialConsumption;
                        var rawMaterialConsumptionUnit5=data.rawMaterialConsumptionUnit==null?'':data.rawMaterialConsumptionUnit;
                        var pollutantName5=data.pollutantName==null?'':data.pollutantName;
                        var pollutantsCoefficient5=data.pollutantsCoefficient==null?'':data.pollutantsCoefficient;
                        var pollutantUnit5=data.pollutantUnit==null?'':data.pollutantUnit;
                        var pollutantsCoefficientParamValue5=data.pollutantsCoefficientParamValue==null?'':data.pollutantsCoefficientParamValue;
                        var pollutantProduction5=data.pollutantProduction==null?'':data.pollutantProduction;
                        var pollutantProductionUnit5=data.pollutantProductionUnit==null?'':data.pollutantProductionUnit;
                        var pollutantTreatmentProcess5=data.pollutantTreatmentProcess==null?'':data.pollutantTreatmentProcess;
                        var pollutantsRemovalEfficiency5=data.pollutantsRemovalEfficiency==null?'':data.pollutantsRemovalEfficiency;
                        var pollutantsRemovalEfficiencyUnit5=data.pollutantsRemovalEfficiencyUnit==null?'':data.pollutantsRemovalEfficiencyUnit;
                        var actualOperatingParametersName1=data.actualOperatingParametersName1==null?'':data.actualOperatingParametersName1;
                        var actualOperatingParametersValue1=data.actualOperatingParametersValue1==null?'':data.actualOperatingParametersValue1;
                        var actualOperatingParametersUnit1=data.actualOperatingParametersUnit1==null?'':data.actualOperatingParametersUnit1;
                        var actualOperatingParametersName2=data.actualOperatingParametersName2==null?'':data.actualOperatingParametersName2;
                        var actualOperatingParametersValue2=data.actualOperatingParametersValue2==null?'':data.actualOperatingParametersValue2;
                        var actualOperatingParametersUnit2=data.actualOperatingParametersUnit2==null?'':data.actualOperatingParametersUnit2;
                        var actualOperatingParametersName3=data.actualOperatingParametersName3==null?'':data.actualOperatingParametersName3;
                        var actualOperatingParametersValue3=data.actualOperatingParametersValue3==null?'':data.actualOperatingParametersValue3;
                        var actualOperatingParametersUnit3=data.actualOperatingParametersUnit3==null?'':data.actualOperatingParametersUnit3;
                        var permitExecutionReporCounts=data.permitExecutionReporCounts==null?'':data.permitExecutionReporCounts;
                        var pollutantDischargeCounts=data.pollutantDischargeCounts==null?'':data.pollutantDischargeCounts;
                        var pollutantDischargeCountsUnit=data.pollutantDischargeCountsUnit==null?'':data.pollutantDischargeCountsUnit;
                        var remarks5=data.remarks==null?'':data.remarks;
                        table='<div class="layui-fluid">\n' +
                            '        <div class="layui-row layui-col-space15">\n' +
                            '            <!--<div class="layui-card-header">响应式组合</div>-->\n' +
                            '            <div class="layui-card-body">\n' +
                            '                <form class="layui-form" id="dischargeCoefficientShow" action="" lay-filter="component-form-element">\n' +
                            '                    <table class="reporttable">\n' +
                            '                        <tr>\n' +
                            '                            <td>核算环节名称：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="accountingLink" value="'+accountingLink5+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                            <td>排污口名称：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="monitorName" value="'+monitorName5+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                        </tr>\n' +
                            '                        <tr>\n' +
                            '                            <td>普查表号：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="censusCode" value="'+censusCode5+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                            <td>原料名称：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="materialName" value="'+materialName5+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                        </tr>\n' +
                            '                        <tr>\n' +
                            '                            <td>产品名称：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="productName" value="'+productName5+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                            <td>工艺名称：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="processName" value="'+processName5+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                        </tr>\n' +
                            '                        <tr>\n' +
                            '                            <td>年度：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="year" value="'+year5+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                            <td>生产规模等级：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="productionGrade" value="'+productionGrade5+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                        </tr>\n' +
                            '                        <tr>\n' +
                            '                            <td>产品产量：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="productOutput" value="'+productOutput5+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                            <td>产品产量的计量单位：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="productOutputUnit" value="'+productOutputUnit5+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                        </tr>\n' +
                            '                        <tr>\n' +
                            '                            <td>原料/燃料用量：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="rawMaterialConsumption" value="'+rawMaterialConsumption5+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                            <td>原料/燃料用量的计量单位：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="rawMaterialConsumptionUnit" value="'+rawMaterialConsumptionUnit5+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                        </tr>\n' +
                            '                        <tr>\n' +
                            '                            <td>污染物名称：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="pollutantName" value="'+pollutantName5+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                            <td>污染物产污系数：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="pollutantsCoefficient" value="'+pollutantsCoefficient5+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                        </tr>\n' +
                            '                        <tr>\n' +
                            '                            <td>污染物计量单位：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="pollutantUnit" value="'+pollutantUnit5+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                            <td>污染物产污系数中参数取值：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="pollutantsCoefficientParamValue" value="'+pollutantsCoefficientParamValue5+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                        </tr>\n' +
                            '                        <tr>\n' +
                            '                            <td>污染物产生量：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="pollutantProduction" value="'+pollutantProduction5+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                            <td>污染物产生量计量单位：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="pollutantProductionUnit" value="'+pollutantProductionUnit5+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                        </tr>\n' +
                            '                        <tr>\n' +
                            '                            <td>污染物处理工艺名称：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="pollutantTreatmentProcess" value="'+pollutantTreatmentProcess5+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                            <td></td>\n' +
                            '                            <td></td>\n' +
                            '                        </tr>\n' +
                            '                        <tr>\n' +
                            '                            <td>污染物去除效率/排污系数：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="pollutantsRemovalEfficiency" value="'+pollutantsRemovalEfficiency5+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                            <td>污染物去除效率/排污系数计量单位：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="pollutantsRemovalEfficiencyUnit" value="'+pollutantsRemovalEfficiencyUnit5+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                        </tr>\n' +
                            '                        <tr>\n' +
                            '                            <td>污染治理设施实际运行参数一名称：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="actualOperatingParametersName1" value="'+actualOperatingParametersName1+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                            <td>污染治理设施实际运行参数一数值：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="actualOperatingParametersValue1" value="'+actualOperatingParametersValue1+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                        </tr>\n' +
                            '                        <tr>\n' +
                            '                            <td>污染治理设施实际运行参数一计量单位：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="actualOperatingParametersUnit1" value="'+actualOperatingParametersUnit1+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                            <td>污染治理设施实际运行参数二名称：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="actualOperatingParametersName2" value="'+actualOperatingParametersName2+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                        </tr>\n' +
                            '                        <tr>\n' +
                            '                            <td>污染治理设施实际运行参数二数值：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="actualOperatingParametersValue2" value="'+actualOperatingParametersValue2+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                            <td>污染治理设施实际运行参数二计量单位：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="actualOperatingParametersUnit2" value="'+actualOperatingParametersUnit2+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                        </tr>\n' +
                            '                        <tr>\n' +
                            '                            <td>污染治理设施实际运行参数三名称：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="actualOperatingParametersName3" value="'+actualOperatingParametersName3+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                            <td>污染治理设施实际运行参数三数值：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="actualOperatingParametersValue3" value="'+actualOperatingParametersValue3+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                        </tr>\n' +
                            '                        <tr>\n' +
                            '                            <td>污染治理设施实际运行参数三计量单位：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="actualOperatingParametersUnit3" value="'+actualOperatingParametersUnit3+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                            <td>排污许可证执行报告排放量：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="permitExecutionReporCounts" value="'+permitExecutionReporCounts+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                        </tr>\n' +
                            '                        <tr>\n' +
                            '                            <td>污染物排放量：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="pollutantDischargeCounts" value="'+pollutantDischargeCounts+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                            <td>污染物排放量计量单位：</td>\n' +
                            '                            <td>\n' +
                            '                                <input type="text" name="pollutantDischargeCountsUnit" value="'+pollutantDischargeCountsUnit+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                            '                            </td>\n' +
                            '                        </tr>\n' +
                            '                        <tr>\n' +
                            '                            <td>备注：</td>\n' +
                            '                            <td colspan="3">\n' +
                            '                                <textarea type="text" name="remarks" style="resize: none;" readonly placeholder="" autocomplete="off" class="layui-textarea">'+remarks5+'</textarea>\n' +
                            '                            </td>\n' +
                            '                        </tr>\n' +
                            '                    </table>\n' +
                            '                </form>\n' +
                            '            </div>\n' +
                            '        </div>\n' +
                            '    </div>';
                    }
                    layui.layer.open({
                        type: 1
                        ,title: "查看"
                        ,area: ['1100px', '530px']
                        // offset: '120px',
                        ,content: table
                    });
                    // if(differType==0){
                    //     for(var id in data){
                    //         $("#cominfoMeasureWastewateredit [name='"+id+"']").val(data[id]);
                    //         $("#cominfoMeasureWastewateredit [name='"+id+"']").attr("readonly","readonly");
                    //     }
                    // }
                    // if(differType==1){
                    //     for(var id in data){
                    //         $("#cominfoMeasureWastegasedit [name='"+id+"']").val(data[id]);
                    //         $("#cominfoMeasureWastegasedit [name='"+id+"']").attr("readonly","readonly");
                    //     }
                    // }
                    // if(differType==2){
                    //     for(var id in data){
                    //         $("#cominfoMeasureWastevocsedit [name='"+id+"']").val(data[id]);
                    //         $("#cominfoMeasureWastevocsedit [name='"+id+"']").attr("readonly","readonly");
                    //     }
                    // }
                }
            });
        }
        ,error:function () {
        }
    });


    //治理设施下拉框
    var wasteUrl=remoteServiceAddress+"/market/cominfomeasurewastewater/list";
    if(differType==1){
        wasteUrl=remoteServiceAddress+"/market/cominfomeasurewastegas/list";
    }
    if(differType==2){
        wasteUrl=remoteServiceAddress+"/market/cominfomeasurewastevocs/list";
    }
    $.ajax({
        type: 'GET',
        url: wasteUrl,
        data:{"mid":mid},
        beforeSend: function (XMLHttpRequest) {
            XMLHttpRequest.setRequestHeader("access_token",JSON.parse(localStorage["layuiAdmin"]).access_token);
        },
        success: function (result) {
            $("#governFacility"+mid).html("");
            var data=JSON.parse(result).data;
            var governFacility=$("#governFacility"+mid);
            var optiona=$("<option>").text("全部").val("");
            governFacility.append(optiona);
            for(var i=0;i<data.length;i++){
                var optionb=$("<option>").text(data[i].measureName).val(data[i].pid);
                governFacility.append(optionb);
            }
        }
        ,error:function () {
        }
    });

    $("#governFacilityReload"+mid).unbind();
    $("#governFacilityReload"+mid).on("click",function () {
        var value= $(this).attr("value");
        var governFacility=$("#governFacility"+value).val();
        var center_measure_info=$("#center_measure_info"+value+" .layui-this").val();
        var startTime=$("#startTime"+value).val();
        $.ajax({
            type: 'GET',
            url: url,
            data:{"mid":value,"wid":governFacility,"startTime":startTime},
            beforeSend: function (XMLHttpRequest) {
                XMLHttpRequest.setRequestHeader("access_token",JSON.parse(localStorage["layuiAdmin"]).access_token);
            },
            success: function (result) {
                var data=JSON.parse(result).data;
                layui.table.reload("Lay_measure_center_content"+value+center_measure_info,{//查询列表信息
                    data: data
                });
            }
            ,error:function () {
            }
        });
    });
}

function comInfoPortShow(differType,remoteServiceAddress,waterTable,url,pid) {
    $("#measure-info"+differType+" li").on("click",function () {
        var mid=$(this).attr("name");
        if(!(differType==0 || differType==1)){
            $("[name='hideLiFourOnline"+mid+"']").addClass("layui-hide");
            $("[name='hideDivFourOnline"+mid+"']").addClass("layui-hide");
        }
        $("#center_measure_info"+mid+" li").on("click",function () {
            var value=$(this).val();
            if(value==0){
                $("#Lay_measure_center_content"+mid+value).html(waterTable);
                measureData(url,mid);
            }
            if(value==1){
                wasteData(remoteServiceAddress,mid,value,differType);
            }
            if(value==2){
                wasteData(remoteServiceAddress,mid,value,differType);
            }
            if(differType==0 || differType==1){
                if(value==4){
                    wasteData(remoteServiceAddress,mid,value,differType);
                }
            }
            if(value==5){
                wasteData(remoteServiceAddress,mid,value,differType);
            }
        });
        $("#center_measure_firstClick"+mid).trigger("click");
        pointFactorTpl($,remoteServiceAddress,mid,differType);
        firstClickTpl($,remoteServiceAddress,pid,differType,mid);
    });
    $("#measureClick"+differType).trigger("click");
}

//排放情况
function comInfoMeasure(data,url,remoteServiceAddress) {
    var waterTable='<table class="reporttable">\n' +
        '              <tr>\n' +
        '                <td>监控点编号：</td>\n' +
        '                <td>\n' +
        '                  <input type="text" name="monitorCode" lay-verify="required" value="" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                </td>\n' +
        '                <td></td>\n' +
        '                <td></td>\n' +
        '              </tr>\n' +
        '              <tr>\n' +
        '                <td>监控点名称：</td>\n' +
        '                <td>\n' +
        '                  <input type="text" name="monitorName" lay-verify="required" value="" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                </td>\n' +
        '                <td>监控点是否使用：</td>\n' +
        '                <td>\n' +
        '                  <input type="text" name="monitorUseFlagName" lay-verify="required" value="" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                </td>\n' +
        '              </tr>\n' +
        '              <tr>\n' +
        '                <td>联系人：</td>\n' +
        '                <td>\n' +
        '                  <input type="text" name="linkmen" value="" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                </td>\n' +
        '                <td>联系电话：</td>\n' +
        '                <td>\n' +
        '                  <input type="text" name="linkphone" value="" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                </td>\n' +
        '              </tr>\n' +
        '              <tr>\n' +
        '                <td>监控点位置：</td>\n' +
        '                <td>\n' +
        '                  <input type="text" name="monitorPosition" value="" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                </td>\n' +
        '                <td>主要污染物：</td>\n' +
        '                <td>\n' +
        '                  <input type="text" name="mainPollution" value="" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                </td>\n' +
        '              </tr>\n' +
        '              <tr>\n' +
        '                <td>排放方式：</td>\n' +
        '                <td>\n' +
        '                  <input type="text" name="emissionMode" value="" placeholder="" autocomplete="off" class="layui-input">' +
        '                </td>\n' +
        '                <td>排放去向：</td>\n' +
        '                <td>\n' +
        '                  <input type="text" name="emissionDirection" value="" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                </td>\n' +
        '              </tr>\n' +
        '              <tr>\n' +
        '                <td>受纳水体：</td>\n' +
        '                <td>\n' +
        '                  <input type="text" name="receivingWater" value="" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                </td>\n' +
        '                <td>运维单位：</td>\n' +
        '                <td>\n' +
        '                  <input type="text" name="operationUnit" value="" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                </td>\n' +
        '              </tr>\n' +
        '              <tr>\n' +
        // '                <td>排口照片：</td>\n' +
        // '                <td>\n' +
        // '                  <input type="text" name="photoPath" value="" placeholder="" autocomplete="off" class="layui-input">\n' +
        // '                </td>\n' +
        '                <td>排放类型：</td>\n' +
        '                <td>\n' +
        '                  <input type="text" name="emissionTypeName" value="" placeholder="" autocomplete="off" class="layui-input">' +
        '                </td>\n' +
        '                <td>联网日期：</td>\n' +
        '                <td>\n' +
        '                  <input type="text" name="networkingDate" lay-verify="required" value="" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                </td>\n' +
        '              </tr>\n' +
        '              <tr>\n' +
        '                <td>经度：</td>\n' +
        '                <td>\n' +
        '                  <input type="text" name="longitude" value="" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                </td>\n' +
        '                <td>纬度：</td>\n' +
        '                <td>\n' +
        '                  <input type="text" name="latitude" value="" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                </td>\n' +
        '              </tr>\n' +
        // '              <tr>\n' +
        // '                <td></td>\n' +
        // '                <td></td>\n' +
        // '              </tr>\n' +
        '            </table>';
    var waterTable5='<table class="reporttable">\n' +
        '              <tr>\n' +
        '                <td>监控点编号：</td>\n' +
        '                <td>\n' +
        '                  <input type="text" name="monitorCode" lay-verify="required" value="" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                </td>\n' +
        '                <td></td>\n' +
        '                <td></td>\n' +
        '              </tr>\n' +
        '              <tr>\n' +
        '                <td>监控点名称：</td>\n' +
        '                <td>\n' +
        '                  <input type="text" name="monitorName" lay-verify="required" value="" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                </td>\n' +
        '                <td>监控点是否使用：</td>\n' +
        '                <td>\n' +
        '                  <input type="text" name="monitorUseFlagName" lay-verify="required" value="" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                </td>\n' +
        '              </tr>\n' +
        '              <tr>\n' +
        '                <td>联系人：</td>\n' +
        '                <td>\n' +
        '                  <input type="text" name="linkmen" value="" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                </td>\n' +
        '                <td>联系电话：</td>\n' +
        '                <td>\n' +
        '                  <input type="text" name="linkphone" value="" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                </td>\n' +
        '              </tr>\n' +
        '              <tr>\n' +
        '                <td>噪声源位置：</td>\n' +
        '                <td>\n' +
        '                  <input type="text" name="monitorPosition" value="" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                </td>\n' +
        '                <td>主要污染物：</td>\n' +
        '                <td>\n' +
        '                  <input type="text" name="mainPollution" value="" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                </td>\n' +
        '              </tr>\n' +
        '              <tr>\n' +
        '                <td>是否昼夜产生：</td>\n' +
        '                <td>\n' +
        '                  <input type="text" name="dayAndNightName" value="" placeholder="" autocomplete="off" class="layui-input">' +
        '                </td>\n' +
        '                <td>昼间：</td>\n' +
        '                <td>\n' +
        '                  <input type="text" name="standardLimitsDay" value="" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                </td>\n' +
        '              </tr>\n' +
        '              <tr>\n' +
        '                <td>夜间：</td>\n' +
        '                <td>\n' +
        '                  <input type="text" name="standardLimitsNight" value="" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                </td>\n' +
        '                <td>运维单位：</td>\n' +
        '                <td>\n' +
        '                  <input type="text" name="operationUnit" value="" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                </td>\n' +
        '              </tr>\n' +
        '              <tr>\n' +
        // '                <td>排口照片：</td>\n' +
        // '                <td>\n' +
        // '                  <input type="text" name="photoPath" value="" placeholder="" autocomplete="off" class="layui-input">\n' +
        // '                </td>\n' +
        '                <td>执行标准：</td>\n' +
        '                <td>\n' +
        '                  <input type="text" name="executiveStandard" value="" placeholder="" autocomplete="off" class="layui-input">' +
        '                </td>\n' +
        '                <td>联网日期：</td>\n' +
        '                <td>\n' +
        '                  <input type="text" name="networkingDate" lay-verify="required" value="" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                </td>\n' +
        '              </tr>\n' +
        '              <tr>\n' +
        '                <td>经度：</td>\n' +
        '                <td>\n' +
        '                  <input type="text" name="longitude" value="" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                </td>\n' +
        '                <td>纬度：</td>\n' +
        '                <td>\n' +
        '                  <input type="text" name="latitude" value="" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                </td>\n' +
        '              </tr>\n' +
        // '              <tr>\n' +
        // '                <td></td>\n' +
        // '                <td></td>\n' +
        // '              </tr>\n' +
        '            </table>';
    var waterCount=0;
    var airCount=0;
    var VOCsCount=0;
    var NoiceCount=0;
    for(var i=0;i<data.length;i++){
        var measureInfo=$("#measure-info"+data[i].type);
        var measureWaste=$("#measure-waste"+data[i].type);
        if(data[i].type==0){
            comInfoPortTpl(data[i],waterCount,measureInfo,measureWaste,remoteServiceAddress);
            waterCount++;
        }
        if(data[i].type==1){
            comInfoPortTpl(data[i],airCount,measureInfo,measureWaste,remoteServiceAddress);
            airCount++;
        }
        if(data[i].type==2){
            comInfoPortTpl(data[i],VOCsCount,measureInfo,measureWaste,remoteServiceAddress);
            VOCsCount++;
        }
        if(data[i].type==5){
            comInfoPortTpl(data[i],NoiceCount,measureInfo,measureWaste,remoteServiceAddress);
            NoiceCount++;
        }
    }

    if(waterCount>0){
        var onlineTable=onlineTableTpl(0);
        $("#measure-online0").html(onlineTable);
    }else{
        $("#tableInfo1").attr("style","display:none;");
    }

    if(airCount>0){
        var onlineTable1=onlineTableTpl(1);
        $("#measure-online1").html(onlineTable1);
    }else{
        $("#tableInfo2").attr("style","display:none;");
    }

    if(VOCsCount>0){
        var onlineTable2=onlineTableTpl(2);
        $("#measure-online2").html(onlineTable2);
    }else {
        $("#tableInfo3").attr("style","display:none;");
    }

    if(NoiceCount>0){
        var onlineTable5=onlineTableTpl(5);
        $("#measure-online5").html(onlineTable5);
    }else {
        $("#tableInfo4").attr("style","display:none;");
    }

    onlineDate();

    if(waterCount>=0){
        comInfoPortShow(0,remoteServiceAddress,waterTable,url,pid);
    }

    if(airCount>=0){
        comInfoPortShow(1,remoteServiceAddress,waterTable,url,pid);
    }

    if(VOCsCount>=0){
        comInfoPortShow(2,remoteServiceAddress,waterTable,url,pid);
    }

    if(NoiceCount>=0){
        comInfoPortShow(5,remoteServiceAddress,waterTable5,url,pid);
    }

    $("#comInfoReload0").on("click",function () {
        comInfoReloadTpl($,pid,remoteServiceAddress,0);
    });
    $("#comInfoReload1").on("click",function () {
        comInfoReloadTpl($,pid,remoteServiceAddress,1);
    });
    $("#comInfoReload2").on("click",function () {
        comInfoReloadTpl($,pid,remoteServiceAddress,2);
    });
    // firstClickTpl($,remoteServiceAddress,pid,0);
    // firstClickTpl($,remoteServiceAddress,pid,1);
    // firstClickTpl($,remoteServiceAddress,pid,2);
}

function tableCss($dom,flag) {
    if(flag){
        $("#"+$dom+" tr:gt(0)").mouseover(function () {
            $(this).attr("style","background:#F2F2F2");
        });

        $("#"+$dom+" tr:gt(0)").mouseout(function () {
            $(this).removeAttr("style");
        });
    }else {
        $("#"+$dom+" tr:gt(0)").mouseover(function () {
            $(this).attr("style","cursor:pointer;color:blue;background:#F2F2F2");
        });

        $("#"+$dom+" tr:gt(0)").mouseout(function () {
            $(this).removeAttr("style");
        });
    }
}

function showInfo(pid,token,remoteServiceAddress) {
    var baseurl = remoteServiceAddress + "/market/cominfobaseinfo"
        ,baseurl21 = remoteServiceAddress + "/building/buildingprojectapproval"
        ,baseurl22 = remoteServiceAddress + "/permit/pollutantdischargepermit"
        ,baseurl23 = remoteServiceAddress + "/petition/petitionsystemcomplain"
        ,baseurl24 = remoteServiceAddress + "/mobile/mobileenforcementscene"
        ,baseurl25 = remoteServiceAddress + "/penalty/administrativepenaltyinfo"
        ,baseurl26 = remoteServiceAddress + "/mobile/mobileenforcementaskrecord"
        ,baseurl31 = remoteServiceAddress + "/emergency/emergencysystemdangerous"
        ,baseurl32 = remoteServiceAddress + "/emergency/emergencysystemsupplies"
        ,baseurl33 = remoteServiceAddress + "/emergency/emergencysystemplan"
        ,baseurl34 = remoteServiceAddress + "/emergency/emergencysystemdrill"
        ,baseurl35 = remoteServiceAddress + "/emergency/emergencysystemranks"
        ,baseurl36 = remoteServiceAddress + "/emergency/emergencysystemexpert"
        ,baseurl37 = remoteServiceAddress + "/emergency/emergencysystemevent"
        ,baseurl38 = remoteServiceAddress + "/emergency/riskpreventionmeasures"
        ,baseurl1 = remoteServiceAddress + "/market/cominfoenvironmentalattributes"
        ,baseurl2 = remoteServiceAddress + "/market/cominfoenvironmentalmanage"
        ,baseurl3 = remoteServiceAddress + "/market/cominfoproductionprocess"
        ,baseurl4 = remoteServiceAddress + "/market/cominfoproductionequipment"
        ,baseurl5 = remoteServiceAddress + "/market/cominfoproductionmaterials"
        ,baseurl6 = remoteServiceAddress + "/market/cominfoproductionwater"
        ,baseurl7 = remoteServiceAddress + "/market/cominfoproductionenergy"
        ,baseurl8 = remoteServiceAddress + "/market/cominfoproductionproduct"
        ,baseurl9 = remoteServiceAddress + "/market/cominfomeasurewastewater"
        ,baseurl10 = remoteServiceAddress + "/market/cominfomeasurewastegas"
        ,baseurl11 = remoteServiceAddress + "/market/cominfomeasuresolidwaste"
        ,baseurl12 = remoteServiceAddress + "/market/cominfomeasureotherwaste"
        ,baseurl13 = remoteServiceAddress + "/online/onlinemonitorportinfo"
        ,baseurl14 = remoteServiceAddress + "/cominfo/organicliquidstorageload"
        ,baseurl61 = remoteServiceAddress + "/comInfo/cominfowasteprocessplace"
        ,baseurl62 = remoteServiceAddress + "/online/onlinewasteproduce"
        ,baseurl63 = remoteServiceAddress + "/market/cominforadioactiveore"
        ,baseurl64 = remoteServiceAddress + "/market/cominforadioactiveoremonitor";


    var subTitleDoms = $(".headline-2");
    var array = [];
    subTitleDoms.each(function () {
        array.push(this.innerText);
    });
    var title = "基本信息";
    if(getShowFlag(title,array)){
        //基本信息
        $.ajax({
            type: 'GET',
            url: baseurl+"/"+pid,
            beforeSend: function (XMLHttpRequest) {
                XMLHttpRequest.setRequestHeader("access_token",token);
            },
            success: function (result) {
                $("#companyTitle").text( result.cominfoBaseinfo.companyName);
                for(var id in result.cominfoBaseinfo ){
                    if(result.cominfoBaseinfo[id]!=null){
                        $("#LAY-market-cominfoBaseinfo0 .reporttable [data-name='"+id+"']").text(result.cominfoBaseinfo[id])
                    }
                }
                var setter = {};
                setter.remoteServiceAddress = remoteServiceAddress;
                BaiduMap.init(1,null,setter,null,result.cominfoBaseinfo);
            }
            ,error:function () {
            }
        });
    }

    title = "排放情况";
    if(getShowFlag(title,array)){
        //排放情况
        $.ajax({
            type: 'GET',
            url: baseurl13+"/selectList/"+pid,
            beforeSend: function (XMLHttpRequest) {
                XMLHttpRequest.setRequestHeader("access_token",JSON.parse(localStorage["layuiAdmin"]).access_token);
            },
            success: function (result) {
                var data=JSON.parse(result).data;
                comInfoMeasure(data,baseurl13,remoteServiceAddress);
                var flag0=true;
                var flag1=true;
                var flag2=true;
                var flag3=true;
                for(var i=0;i<data.length;i++){
                    if(data[i].type==0){
                        flag0=false;
                    }
                    if(data[i].type==1){
                        flag1=false;
                    }
                    if(data[i].type==2){
                        flag2=false;
                    }if(data[i].type==5){
                        flag3=false;
                    }
                }
                if(flag0){
                    setVisibility("水排放情况",subTitleDoms);
                }
                if(flag1){
                    setVisibility("气排放情况",subTitleDoms);
                }
                if(flag2){
                    setVisibility("VOCs排放情况",subTitleDoms);
                }
                if(flag3){
                    setVisibility("噪声排放情况",subTitleDoms);
                }
            }
            ,error:function () {
            }
        });
    }

    title = "环境管理属性";
    if(getShowFlag(title,array)){
        //管理属性
        $.ajax({
            type: 'GET',
            url: baseurl2+"/"+pid,
            beforeSend: function (XMLHttpRequest) {
                XMLHttpRequest.setRequestHeader("access_token",token);
            },
            success: function (result) {
                for(var id in result.cominfoEnvironmental ){
                    if(result.cominfoEnvironmental[id]!=null){
                        $("#LAY-market-cominfoEnvironmentalAttributes1 .reporttable [data-name='"+id+"']").text(result.cominfoEnvironmental[id])
                    }
                }
            }
            ,error:function () {
            }
        });
        //环境属性
        $.ajax({
            type: 'GET',
            url: baseurl1+"/"+pid,
            beforeSend: function (XMLHttpRequest) {
                XMLHttpRequest.setRequestHeader("access_token",token);
            },
            success: function (result) {
                for(var id in result.cominfoEnvironmental ){
                    if(result.cominfoEnvironmental[id]!=null){
                        $("#LAY-market-cominfoEnvironmentalAttributes0 .reporttable [data-name='"+id+"']").text(result.cominfoEnvironmental[id])
                    }
                }
            }
            ,error:function () {
            }
        });
    }

    // title = "环境属性";
    // if(getShowFlag(title,array)){
    //
    // }

    title = "危险化学品";
    if(getShowFlag(title,array)){
        //危险化学品
        $.ajax({
            type: 'GET',
            url: baseurl31+"/list",
            data:{"cid":pid},
            beforeSend: function (XMLHttpRequest) {

                XMLHttpRequest.setRequestHeader("access_token",token);
            },
            success: function (result) {
                var data=JSON.parse(result).data;
                if(data != undefined && data.length > 0){
                    var table=$("<table>").attr("class","emergencytable");
                    var tr=$("<tr>");
                    var tdd=$("<td style='width: 50px'>").text("序号");
                    var tdf=$("<td>").text("品名");
                    var tdl=$("<td>").text("别名");
                    var tds=$("<td>").text("CAS号");
                    var tdg=$("<td>").text("UN号");
                    var tdt=$("<td>").text("数量（吨）");
                    var tdh=$("<td>").text("活动属性");
                    tr.append(tdd);
                    tr.append(tdf)
                    tr.append(tdl);
                    tr.append(tds);
                    tr.append(tdg);
                    tr.append(tdt);
                    tr.append(tdh);
                    table.append(tr);
                    for(var i=0;i<data.length;i++){
                        var trf=$("<tr>").attr("id",data[i].pid).attr("name","administrativepenaltyinfo_hxp");
                        var tdfd=$("<td>").text(i+1);
                        var tdff=$("<td>").text(data[i].dangerousName);
                        var tdfl=$("<td>").text(data[i].dangerousAnotherName);
                        var tdfs=$("<td>").text(data[i].casNumber);
                        var tdfg=$("<td>").text(data[i].unNumer);
                        var tdft=$("<td>").text(data[i].amount);
                        var tdfh=$("<td>").text(data[i].dangerousTypeName);
                        trf.append(tdfd);
                        trf.append(tdff);
                        trf.append(tdfl);
                        trf.append(tdfs);
                        trf.append(tdfg);
                        trf.append(tdft);
                        trf.append(tdfh);
                        table.append(trf);
                    }
                    $("#LAY-emergency-emergencysystem1").append(table);
                    //alert(" div宽度 "+$('.para').width());
                    // if(data.length>5){
                    //     $("#LAY-emergency-emergencysystem1").addClass("scroll");
                    // }
                    setWidthForWin(data,"LAY-emergency-emergencysystem1");
                    $("[name='administrativepenaltyinfo_hxp']").each(function () {
                        $(this).bind('click',function () {
                            setHazardousChemical($,$(this).attr("id"),baseurl31,token)
                        });
                    });
                    tableCss("LAY-emergency-emergencysystem1");
                }else{
                    setVisibility("危险化学品",subTitleDoms);
                }
            }
            ,error:function () {
            }
        });
    }

    title = "应急物资";
    if(getShowFlag(title,array)){
        //应急物资
        $.ajax({
            type: 'GET',
            url: baseurl32+"/list",
            data:{"cid":pid},
            beforeSend: function (XMLHttpRequest) {
                XMLHttpRequest.setRequestHeader("access_token",token);
            },
            success: function (result) {

                var data=JSON.parse(result).data;
                if(data != undefined && data.length > 0){
                    var table=$("<table>").attr("class","emergencytable");
                    var tr=$("<tr>");
                    var tdd=$("<td style='width: 50px'>").text("序号");
                    var tdf=$("<td>").text("物资名称");
                    var tdl=$("<td>").text("物资类型");
                    var tds=$("<td>").text("物资数量");
                    var tdg=$("<td>").text("物资单位");
                    // var tdm=$("<td>").text("存放地址");
                    // var tdt=$("<td>").text("联系人");
                    // var tdh=$("<td>").text("联系电话");
                    tr.append(tdd);
                    tr.append(tdf);
                    tr.append(tdl);
                    tr.append(tds);
                    tr.append(tdg);
                    // tr.append(tdm);
                    // tr.append(tdt);
                    // tr.append(tdh);
                    table.append(tr);
                    for(var i=0;i<data.length;i++){
                        var trf =  $("<tr>").attr("id",data[i].pid).attr("name","emergencysupplies_tr");
                        // var trf=$("<tr>");
                        var tdfd=$("<td>").text(i+1);
                        var tdff=$("<td>").text(data[i].suppliesName);
                        var tdfl=$("<td>").text(data[i].suppliesTypeName);
                        var tdfs=$("<td>").text(data[i].suppliesNumber);
                        var tdfg=$("<td>").text(data[i].suppliesUnit);
                        // var tdfm=$("<td>").text(data[i].storeAddress);
                        // var tdft=$("<td>").text(data[i].linkmen);
                        // var tdfh=$("<td>").text(data[i].linkphone);
                        trf.append(tdfd);
                        trf.append(tdff);
                        trf.append(tdfl);
                        trf.append(tdfs);
                        trf.append(tdfg);
                        // trf.append(tdfm);
                        // trf.append(tdft);
                        // trf.append(tdfh);
                        table.append(trf);
                    }
                    $("#LAY-emergency-emergencysystem2").append(table);
                    // if(data.length>5){
                    //     $("#LAY-emergency-emergencysystem2").addClass("scroll");
                    // }
                    setWidthForWin(data,"LAY-emergency-emergencysystem2");
                    $("[name='emergencysupplies_tr']").each(function () {
                        $(this).bind('click',function () {
                            setemergencysupplies($(this).attr("id"),baseurl32,token)
                        });
                    });
                    tableCss("LAY-emergency-emergencysystem2");
                }else{
                    setVisibility("应急物资",subTitleDoms);
                }
            }
            ,error:function () {
            }
        });
    }

    title = "应急预案";
    if(getShowFlag(title,array)){
        //应急预案
        $.ajax({
            type: 'GET',
            url: baseurl33+"/list",
            data:{"cid":pid},
            beforeSend: function (XMLHttpRequest) {
                XMLHttpRequest.setRequestHeader("access_token",token);
            },
            success: function (result) {
                var data=JSON.parse(result).data;
                if(data != undefined && data.length > 0){
                    var table=$("<table>").attr("class","emergencytable");
                    var tr=$("<tr>");
                    var tdd=$("<td style='width: 50px'>").text("序号");
                    var tdf=$("<td>").text("预案标题");
                    var tds=$("<td>").text("预案类型");
                    // var tdg=$("<td>").text("备案日期");
                    var tdl=$("<td>").text("批复单位");
                    var tdm=$("<td>").text("批复时间");
                    // var tdn=$("<td>").text("预案文档地址");
                    var tdo=$("<td>").text("状态");
                    tr.append(tdd);
                    tr.append(tdf);
                    tr.append(tds);
                    // tr.append(tdg);
                    tr.append(tdl);
                    tr.append(tdm);
                    tr.append(tdo);
                    // tr.append(tdt);
                    table.append(tr);
                    for(var i=0;i<data.length;i++){
                        //var trf=$("<tr>");
                        var trf =  $("<tr>").attr("id",data[i].pid).attr("name","contingencyplan_tr");
                        var tdfd=$("<td>").text(i+1);
                        var tdff=$("<td>").text(data[i].planTitle);
                        var tdfs=$("<td>").text(data[i].planTypeName);
                        // var tdfg=$("<td>").text(data[i].recordDate);
                        var tdfl=$("<td>").text(data[i].batchCompany);
                        var tdfm=$("<td>").text(data[i].batchDate);
                        var tdfo=$("<td>").text(data[i].statusName);
                        // var tdft=$("<td>").text(data[i].preplanCompany);
                        trf.append(tdfd);
                        trf.append(tdff);
                        trf.append(tdfs);
                        // trf.append(tdfg);
                        trf.append(tdfl);
                        trf.append(tdfm);
                        trf.append(tdfo);
                        // trf.append(tdft);
                        table.append(trf);
                    }
                    $("#LAY-emergency-emergencysystem3").append(table);
                    // if(data.length>5){
                    //     $("#LAY-emergency-emergencysystem3").addClass("scroll");
                    // }
                    setWidthForWin(data,"LAY-emergency-emergencysystem3");
                    $("[name='contingencyplan_tr']").each(function () {
                        $(this).bind('click',function () {
                            setcontingencyplan($(this).attr("id"),baseurl33,token,remoteServiceAddress)
                        });
                    });
                    tableCss("LAY-emergency-emergencysystem3");
                }else{
                    setVisibility("应急预案",subTitleDoms);
                }
            }
            ,error:function () {
            }
        });
    }

    title = "应急演练";
    if(getShowFlag(title,array)){
        //应急演练
        $.ajax({
            type: 'GET',
            url: baseurl34+"/list",
            data:{"cid":pid},
            beforeSend: function (XMLHttpRequest) {
                XMLHttpRequest.setRequestHeader("access_token",token);
            },
            success: function (result) {
                var data=JSON.parse(result).data;
                if(data != undefined && data.length > 0){
                    var table=$("<table>").attr("class","emergencytable");
                    var tr=$("<tr>");
                    var tdd=$("<td style='width:50px;'>").text("序号");
                    var tdf=$("<td>").text("演练标题");
                    var tdl=$("<td>").text("演练类型");
                    var tds=$("<td>").text("演练地点");
                    var tdg=$("<td>").text("演练日期");
                    // var tdt=$("<td>").text("演练单位（企业）");
                    tr.append(tdd);
                    tr.append(tdf);
                    tr.append(tdl);
                    tr.append(tds);
                    tr.append(tdg);
                    // tr.append(tdt);
                    table.append(tr);
                    for(var i=0;i<data.length;i++){
                        //var trf=$("<tr>");
                        var trf =  $("<tr>").attr("id",data[i].pid).attr("name","emergencydrilling_tr");
                        var tdfd=$("<td>").text(i+1);
                        var tdff=$("<td>").text(data[i].drillTitle);
                        var tdfl=$("<td>").text(data[i].drillTypeName);
                        var tdfs=$("<td>").text(data[i].drillPoint);
                        var tdfg=$("<td>").text(data[i].drillDate);
                        // var tdft=$("<td>").text(data[i].drillCompany);
                        trf.append(tdfd);
                        trf.append(tdff);
                        trf.append(tdfl);
                        trf.append(tdfs);
                        trf.append(tdfg);
                        // trf.append(tdft);
                        table.append(trf);
                    }
                    $("#LAY-emergency-emergencysystem4").append(table);
                    // if(data.length>5){
                    //     $("#LAY-emergency-emergencysystem4").addClass("scroll");
                    // }
                    // $("#LAY-emergency-emergencysystem4").style.height = (data.length*31)+1 ;
                    // $("#LAY-emergency-emergencysystem4").height((data.length*31)+10 );
                    //$("#LAY-emergency-emergencysystem4").css('height',(data.length*31)+1)
                    setWidthForWin(data,"LAY-emergency-emergencysystem4");


                    $("[name='emergencydrilling_tr']").each(function () {
                        $(this).bind('click',function () {
                            setemergencydrilling($(this).attr("id"),baseurl34,token,remoteServiceAddress)
                        });
                    });
                    tableCss("LAY-emergency-emergencysystem4");
                }else{
                    setVisibility("应急演练",subTitleDoms);
                }
            }
            ,error:function () {
            }
        });
    }

    title = "应急队伍";
    if(getShowFlag(title,array)){
        //应急队伍
        $.ajax({
            type: 'GET',
            url: baseurl35+"/list",
            data:{"cid":pid},
            beforeSend: function (XMLHttpRequest) {
                XMLHttpRequest.setRequestHeader("access_token",token);
            },
            success: function (result) {
                var data=JSON.parse(result).data;
                if(data != undefined && data.length > 0){
                    var table=$("<table>").attr("class","emergencytable");
                    var tr=$("<tr>");
                    var tdd=$("<td style='width:50px;'>").text("序号");
                    var tdf=$("<td>").text("队伍名称");
                    var tds=$("<td>").text("队伍人数");
                    var tdg=$("<td>").text("联系人");
                    var tdh=$("<td>").text("联系电话");
                    // var tdt=$("<td>").text("所属单位（企业）");
                    tr.append(tdd);
                    tr.append(tdf);
                    tr.append(tds);
                    tr.append(tdg);
                    tr.append(tdh);
                    // tr.append(tdt);
                    table.append(tr);
                    for(var i=0;i<data.length;i++){
                        // var trf=$("<tr>");
                        var trf =  $("<tr>").attr("id",data[i].pid).attr("name","emergencyanks_tr");
                        var tdfd=$("<td>").text(i+1);
                        var tdff=$("<td>").text(data[i].ranksName);
                        var tdfs=$("<td>").text(data[i].ranksNumber);
                        var tdfg=$("<td>").text(data[i].linkmen);
                        var tdfh=$("<td>").text(data[i].linkphone);
                        // var tdft=$("<td style='color:blue;cursor:pointer;'>").text(data[i].ranksCompany);
                        trf.append(tdfd);
                        trf.append(tdff);
                        trf.append(tdfs);
                        trf.append(tdfg);
                        trf.append(tdfh);
                        // trf.append(tdft);
                        table.append(trf);
                    }
                    $("#LAY-emergency-emergencysystem5").append(table);
                    // if(data.length>5){
                    //     $("#LAY-emergency-emergencysystem5").addClass("scroll");
                    // }
                    setWidthForWin(data,"LAY-emergency-emergencysystem5");
                    $("[name='emergencyanks_tr']").each(function () {
                        $(this).bind('click',function () {
                            setemergencyranks($(this).attr("id"),baseurl35,token)
                        });
                    });
                    tableCss("LAY-emergency-emergencysystem5");
                }else{
                    setVisibility("应急队伍",subTitleDoms);
                }
            }
            ,error:function () {
            }
        });
    }

    title = "专家信息";
    if(getShowFlag(title,array)){
        //专家信息
        $.ajax({
            type: 'GET',
            url: baseurl36+"/list",
            data:{"cid":pid},
            beforeSend: function (XMLHttpRequest) {
                XMLHttpRequest.setRequestHeader("access_token",token);
            },
            success: function (result) {
                var data=JSON.parse(result).data;
                if(data != undefined && data.length > 0){
                    var table=$("<table>").attr("class","emergencytable");
                    var tr=$("<tr>");
                    var tdd=$("<td style='width: 50px'>").text("序号");
                    var tdf=$("<td>").text("姓名");
                    var tds=$("<td>").text("性别");
                    var tdg=$("<td>").text("联系电话");
                    var tdh=$("<td>").text("擅长领域");
                    // var tdt=$("<td>").text("工作单位（企业）");
                    tr.append(tdd);
                    tr.append(tdf);
                    tr.append(tds);
                    tr.append(tdg);
                    tr.append(tdh);
                    // tr.append(tdt);
                    table.append(tr);
                    for(var i=0;i<data.length;i++){
                        // var trf=$("<tr >");
                        var trf =  $("<tr>").attr("id",data[i].pid).attr("name","emergencyexpert_tr");
                        var tdfd=$("<td>").text(i+1);
                        var tdff=$("<td>").text(data[i].expertName);
                        var tdfs=$("<td>").text(data[i].sexName);
                        var tdfg=$("<td>").text(data[i].linkphone);
                        var tdfh=$("<td>").text(data[i].field);
                        // var tdft=$("<td style='color:blue;cursor:pointer;'>").text(data[i].company);
                        trf.append(tdfd);
                        trf.append(tdff);
                        trf.append(tdfs);
                        trf.append(tdfg);
                        trf.append(tdfh);
                        // trf.append(tdft);
                        table.append(trf);
                    }
                    $("#LAY-emergency-emergencysystem6").append(table);
                    // if(data.length>5){
                    //     $("#LAY-emergency-emergencysystem6").addClass("scroll");
                    // }
                    setWidthForWin(data,"LAY-emergency-emergencysystem6");
                    $("[name='emergencyexpert_tr']").each(function () {
                        $(this).bind('click',function () {
                            setemergencyexpert($(this).attr("id"),baseurl36,token)
                        });
                    });
                    tableCss("LAY-emergency-emergencysystem6");
                }else{
                    setVisibility("专家信息",subTitleDoms);
                }
            }
            ,error:function () {
            }
        });
    }

    title = "应急事件";
    if(getShowFlag(title,array)){
        //应急事件
        $.ajax({
            type: 'GET',
            url: baseurl37+"/list",
            data:{"cid":pid},
            beforeSend: function (XMLHttpRequest) {
                XMLHttpRequest.setRequestHeader("access_token",token);
            },
            success: function (result) {
                var data=JSON.parse(result).data;
                if(data != undefined && data.length > 0){
                    var table=$("<table>").attr("class","emergencytable");
                    var tr=$("<tr>");
                    var tdd=$("<td style='width: 50px'>").text("序号");
                    var tdf=$("<td >").text("事件标题");
                    var tds=$("<td>").text("发生日期");
                    var tdg=$("<td>").text("发生地点");
                    var tdh=$("<td>").text("事件等级");
                    // var tdt=$("<td>").text("企业名称");
                    tr.append(tdd);
                    tr.append(tdf);
                    tr.append(tds);
                    tr.append(tdg);
                    tr.append(tdh);
                    // tr.append(tdt);
                    table.append(tr);
                    for(var i=0;i<data.length;i++){
                        // var trf=$("<tr>");
                        var trf =  $("<tr>").attr("id",data[i].pid).attr("name","emergencyevent_tr");
                        var tdfd=$("<td>").text(i+1);
                        var tdff=$("<td>").text(data[i].eventTitle);
                        var tdfs=$("<td>").text(data[i].occurrenceDate);
                        var tdfg=$("<td>").text(data[i].occurrencePoint);
                        var tdfh=$("<td>").text(data[i].eventLevelName);
                        // var tdft=$("<td>").text(data[i].companyName);
                        trf.append(tdfd);
                        trf.append(tdff);
                        trf.append(tdfs);
                        trf.append(tdfg);
                        trf.append(tdfh);
                        // trf.append(tdft);
                        table.append(trf);
                    }
                    $("#LAY-emergency-emergencysystem7").append(table);
                    // if(data.length>5){
                    //     $("#LAY-emergency-emergencysystem7").addClass("scroll");
                    // }
                    setWidthForWin(data,"LAY-emergency-emergencysystem7");
                    $("[name='emergencyevent_tr']").each(function () {
                        $(this).bind('click',function () {
                            setemergencyevent($(this).attr("id"),baseurl37,token)
                        });
                    });
                    tableCss("LAY-emergency-emergencysystem7");
                }else{
                    setVisibility("应急事件",subTitleDoms);
                }
            }
            ,error:function () {
            }
        });
    }

    title = "风险防范措施";
    if(getShowFlag(title,array)){
        //应急事件
        $.ajax({
            type: 'GET',
            url: baseurl38+"/list",
            data:{"cid":pid},
            beforeSend: function (XMLHttpRequest) {
                XMLHttpRequest.setRequestHeader("access_token",token);
            },
            success: function (result) {
                var data=JSON.parse(result).data;
                if(data != undefined && data.length > 0){
                    var table=$("<table>").attr("class","emergencytable");
                    var tr=$("<tr>");
                    var tdd=$("<td style='width: 50px'>").text("序号");
                    var tdf=$("<td >").text("风险单元名称");
                    var tds=$("<td>").text("主要化学物质");
                    var tdg=$("<td>").text("现存量");
                    var tdh=$("<td>").text("最大存储量");
                    var tdt=$("<td>").text("风险特征");
                    tr.append(tdd);
                    tr.append(tdf);
                    tr.append(tds);
                    tr.append(tdg);
                    tr.append(tdh);
                    tr.append(tdt);
                    table.append(tr);
                    for(var i=0;i<data.length;i++){
                        // var trf=$("<tr>");
                        var trf =  $("<tr>").attr("id",data[i].pid).attr("name","emergencyevent_tr");
                        var tdfd=$("<td>").text(i+1);
                        var tdff=$("<td>").text(data[i].unitName);
                        var tdfs=$("<td>").text(data[i].mainChemicalName);
                        var tdfg=$("<td>").text(data[i].mainChemicalStock);
                        var tdfh=$("<td>").text(data[i].maxStorageCapacity);
                        var tdft=$("<td>").text(data[i].riskProfiles);
                        trf.append(tdfd);
                        trf.append(tdff);
                        trf.append(tdfs);
                        trf.append(tdfg);
                        trf.append(tdfh);
                        trf.append(tdft);
                        table.append(trf);
                    }
                    $("#LAY-emergency-emergencysystem8").append(table);
                    // if(data.length>5){
                    //     $("#LAY-emergency-emergencysystem7").addClass("scroll");
                    // }
                    setWidthForWin(data,"LAY-emergency-emergencysystem8");
                    $("[name='emergencyevent_tr']").each(function () {
                        $(this).bind('click',function () {
                            setemergencyevent($(this).attr("id"),baseurl38,token)
                        });
                    });
                    tableCss("LAY-emergency-emergencysystem8");
                }else{
                    setVisibility("风险防范措施",subTitleDoms);
                }
            }
            ,error:function () {
            }
        });
    }

    title = "生产工艺";
    if(getShowFlag(title,array)){
        //生产工艺
        $.ajax({
            type: 'GET',
            url: baseurl3+"/list",
            data:{"cid":pid},
            beforeSend: function (XMLHttpRequest) {
                XMLHttpRequest.setRequestHeader("access_token",token);
            },
            success: function (result) {
                var data=JSON.parse(result).data;
                if(data != undefined && data.length > 0){
                    var height=null;
                    if(data.length>5){
                        height="270px";
                    }

                    var cols=[[
                        {type: 'numbers', unresize: true, title: '序号'}
                        ,{field: 'processName', title: '工艺名称', minWidth: 100,unresize: true,event:'setProcessName',style:'color:blue;cursor:pointer;'}
                        ,{field: 'processIntroduction', title: '工艺简介', minWidth: 100,unresize: true}
                        ,{field: 'remarks', title: '备注', minWidth: 100,unresize: true}
                    ]];
                    layui.table.render({//查询列表信息
                        elem: '#LAY-market-cominfoProductionProcess'
                        ,page: false
                        // ,event:true
                        ,cols: cols
                        ,skin: 'line'
                        ,height:height
                        ,done:function () {
                            $('#LAY-market-cominfoProductionProcess1 tr th').css({
                                'background-color': '#DBE8F8',
                                'color': '#4D77A3'
                            });
                        }

                    });
                    layui.table.reload("LAY-market-cominfoProductionProcess",{//查询列表信息
                        data: data
                    });

                    layui.table.on('tool(LAY-market-cominfoProductionProcess)',function (obj) {
                        var data=obj.data;
                        if(obj.event=="setProcessName"){
                            if(data.url!=null){
                                showFileView(data.url,remoteServiceAddress);
                            }else{
                                return layer.msg('附件没有上传!');
                            }
                        }
                    });
                }else{
                    setVisibility("生产工艺",subTitleDoms);
                }
            }
            ,error:function () {
            }
        });
    }

    title = "生产设备";
    if(getShowFlag(title,array)){
        //生产设备
        $.ajax({
            type: 'GET',
            url: baseurl4+"/list",
            data:{"cid":pid},
            beforeSend: function (XMLHttpRequest) {
                XMLHttpRequest.setRequestHeader("access_token",token);
            },
            success: function (result) {
                var data=JSON.parse(result).data;
                if(data != undefined && data.length > 0){
                    var table=$("<table>").attr("class","equipmenttable");
                    var tr=$("<tr>");
                    var tdg=$("<td style='width: 50px'>").text("序号");
                    var tda=$("<td>").text("设备名称");
                    var tdb=$("<td>").text("设备车间");
                    var tdc=$("<td>").text("设备型号");
                    var tdd=$("<td>").text("数量");
                    var tde=$("<td>").text("单位");
                    var tdf=$("<td>").text("设备使用情况");
                    var tdk=$("<td>").text("备注");
                    tr.append(tdg);
                    tr.append(tda);
                    tr.append(tdb);
                    tr.append(tdc);
                    tr.append(tdd);
                    tr.append(tde);
                    tr.append(tdf);
                    tr.append(tdk);
                    table.append(tr);
                    for(var i=0;i<data.length;i++){
                        //var tra=$("<tr>");
                        var tra=$("<tr>").attr("id",data[i].pid).attr("name","productionfacility_tr");
                        var tdag=$("<td>").text(i+1);
                        var tdaa=$("<td>").text(data[i].equipmentName);
                        var tdab=$("<td>").text(data[i].equipmentWorkshop);
                        var tdac=$("<td>").text(data[i].equipmentModel);
                        var tdad=$("<td>").text(data[i].number);
                        var tdae=$("<td>").text(data[i].unit);
                        var tdaf=$("<td>").text(data[i].equipmentUsage);
                        var tdkf=$("<td>").text(data[i].remarks);
                        tra.append(tdag);
                        tra.append(tdaa);
                        tra.append(tdab);
                        tra.append(tdac);
                        tra.append(tdad);
                        tra.append(tdae);
                        tra.append(tdaf);
                        tra.append(tdkf);
                        table.append(tra);
                    }
                    $("#LAY-market-cominfoProductionProcess2").append(table);
                    // if(data.length>5){
                    //     $("#LAY-market-cominfoProductionProcess2").addClass("scroll");
                    // }
                    setWidthForWin(data,"LAY-market-cominfoProductionProcess2");
                    // $("[name='productionfacility_tr']").each(function () {
                    //     $(this).bind('click',function () {
                    //         setproductionfacility($(this).attr("id"),baseurl4,token)
                    //     });
                    // });
                    //
                    // tableCss();
                    tableCss("LAY-market-cominfoProductionProcess2",true);
                }else {
                    setVisibility("生产设备",subTitleDoms);
                }
            }
            ,error:function () {
            }
        });
    }

    title = "主要原辅助材料";
    if(getShowFlag(title,array)){
        //主要原辅助材料
        $.ajax({
            type: 'GET',
            url: baseurl5+"/list",
            data:{"cid":pid},
            beforeSend: function (XMLHttpRequest) {
                XMLHttpRequest.setRequestHeader("access_token",token);
            },
            success: function (result) {
                var data=JSON.parse(result).data;
                if(data != undefined && data.length > 0){
                    var table=$("<table>").attr("class","equipmenttable");
                    var tr=$("<tr>");
                    var tdg=$("<td style='width: 50px'>").text("序号");
                    var tda=$("<td>").text("原辅材料名称");
                    var tdb=$("<td>").text("原辅材料编码");
                    var tdc=$("<td>").text("计划年用量");
                    var tdd=$("<td>").text("实际年用量");
                    var tde=$("<td>").text("单位");
                    var tdf=$("<td>").text("备注");
                    tr.append(tdg);
                    tr.append(tda);
                    tr.append(tdb);
                    tr.append(tdc);
                    tr.append(tdd);
                    tr.append(tde);
                    tr.append(tdf);
                    table.append(tr);
                    for(var i=0;i<data.length;i++){
                        var tra=$("<tr>").attr("id",data[i].pid).attr("name","accessorymaterial_tr");
                        var tdag=$("<td>").text(i+1);
                        var tdaa=$("<td>").text(data[i].materialsName);
                        var tdab=$("<td>").text(data[i].materialsCode);
                        var tdac=$("<td>").text(data[i].plannedAnnualAmount);
                        var tdad=$("<td>").text(data[i].actualAnnualAmount);
                        var tdae=$("<td>").text(data[i].unit);
                        var tdaf=$("<td>").text(data[i].remarks);
                        tra.append(tdag);
                        tra.append(tdaa);
                        tra.append(tdab);
                        tra.append(tdac);
                        tra.append(tdad);
                        tra.append(tdae);
                        tra.append(tdaf);
                        table.append(tra);
                    }
                    var cominfoProductionProcess=$("#LAY-market-cominfoProductionProcess3");

                    cominfoProductionProcess.append(table);
                    // if(data.length>5){
                    //     $("#LAY-market-cominfoProductionProcess3").addClass("scroll");
                    // }
                    setWidthForWin(data,"LAY-market-cominfoProductionProcess3");
                    // $("[name='accessorymaterial_tr']").each(function () {
                    //     $(this).bind('click',function () {
                    //         setaccessorymaterial($(this).attr("id"),baseurl5,token)
                    //     });
                    // });
                    // tableCss();
                    tableCss("LAY-market-cominfoProductionProcess3",true);
                }else {
                    setVisibility("主要原辅助材料",subTitleDoms);
                }
            }
            ,error:function () {
            }
        });
    }

    title = "用水情况";
    if(getShowFlag(title,array)){
        //用水情况
        $.ajax({
            type: 'GET',
            url: baseurl6+"/list",
            data:{"cid":pid},
            beforeSend: function (XMLHttpRequest) {
                XMLHttpRequest.setRequestHeader("access_token",token);
            },
            success: function (result) {
                var data=JSON.parse(result).data;
                if(data != undefined && data.length > 0){
                    var table=$("<table>").attr("class","equipmenttable");
                    var tr=$("<tr>");
                    var tdg=$("<td style='width: 50px'>").text("序号");
                    var tda=$("<td>").text("用水总量");
                    var tdb=$("<td>").text("新鲜用水量");
                    var tdc=$("<td>").text("再生用水量");
                    var tdd=$("<td>").text("自备水量");
                    var tde=$("<td>").text("单位");
                    var tdf=$("<td>").text("备注");
                    tr.append(tdg);
                    tr.append(tda);
                    tr.append(tdb);
                    tr.append(tdc);
                    tr.append(tdd);
                    tr.append(tde);
                    tr.append(tdf);
                    table.append(tr);
                    for(var i=0;i<data.length;i++){
                        var tra=$("<tr>");
                        var tdag=$("<td>").text(i+1);
                        var tdaa=$("<td>").text(data[i].totalWater);
                        var tdab=$("<td>").text(data[i].freshWater);
                        var tdac=$("<td>").text(data[i].regeneratedWater);
                        var tdad=$("<td>").text(data[i].selfcontainedWater);
                        var tdae=$("<td>").text(data[i].unit);
                        var tdaf=$("<td>").text(data[i].remarks);
                        tra.append(tdag);
                        tra.append(tdaa);
                        tra.append(tdab);
                        tra.append(tdac);
                        tra.append(tdad);
                        tra.append(tdae);
                        tra.append(tdaf);
                        table.append(tra);
                    }
                    var cominfoProductionProcess=$("#LAY-market-cominfoProductionProcess4");
                    // $("#LAY-market-cominfoProductionProcess4").addClass("scroll");
                    setWidthForWin(data,"LAY-market-cominfoProductionProcess4");
                    cominfoProductionProcess.append(table);
                    tableCss("LAY-market-cominfoProductionProcess4",true);
                    // tableCss();
                }else {
                    setVisibility("用水情况",subTitleDoms);
                }
            }
            ,error:function () {
            }
        });
    }

    title = "能源消耗";
    if(getShowFlag(title,array)){
        //能源消耗
        $.ajax({
            type: 'GET',
            url: baseurl7+"/list",
            data:{"cid":pid},
            beforeSend: function (XMLHttpRequest) {
                XMLHttpRequest.setRequestHeader("access_token",token);
            },
            success: function (result) {
                var data=JSON.parse(result).data;
                if(data != undefined && data.length > 0){
                    var table=$("<table>").attr("class","equipmenttable");
                    var tr=$("<tr>");
                    var tdg=$("<td style='width: 50px'>").text("序号");
                    var tda=$("<td>").text("能源代码");
                    var tdb=$("<td>").text("能源名称");
                    var tdc=$("<td>").text("能源消耗量");
                    var tde=$("<td>").text("单位");
                    var tdk=$("<td>").text("年度");
                    var tdf=$("<td>").text("备注");
                    tr.append(tdg);
                    tr.append(tda);
                    tr.append(tdb);
                    tr.append(tdc);
                    tr.append(tde);
                    tr.append(tdk);
                    tr.append(tdf);
                    table.append(tr);
                    for(var i=0;i<data.length;i++){
                        var tra=$("<tr>").attr("id",data[i].pid).attr("name","energyconsumption_tr");
                        var tdag=$("<td>").text(i+1);
                        var tdaa=$("<td>").text(data[i].energyCode);
                        var tdab=$("<td>").text(data[i].energyName);
                        var tdac=$("<td>").text(data[i].energyConsumption);
                        var tdae=$("<td>").text(data[i].unit);
                        var tdak=$("<td>").text(data[i].year);
                        var tdaf=$("<td>").text(data[i].remarks);
                        tra.append(tdag);
                        tra.append(tdaa);
                        tra.append(tdab);
                        tra.append(tdac);
                        tra.append(tdae);
                        tra.append(tdak);
                        tra.append(tdaf);
                        table.append(tra);
                    }
                    var cominfoProductionProcess=$("#LAY-market-cominfoProductionProcess5");

                    cominfoProductionProcess.append(table);
                    // if(data.length>5){
                    //     $("#LAY-market-cominfoProductionProcess5").addClass("scroll");
                    // }
                    setWidthForWin(data,"LAY-market-cominfoProductionProcess5");
                    // $("[name='energyconsumption_tr']").each(function () {
                    //     $(this).bind('click',function () {
                    //         setenergyconsumption($(this).attr("id"),baseurl7,token)
                    //     });
                    // });
                    tableCss("LAY-market-cominfoProductionProcess5",true);
                }else {
                    setVisibility("能源消耗",subTitleDoms);
                }
            }
            ,error:function () {
            }
        });
    }

    title = "主要产品";
    if(getShowFlag(title,array)){
        //主要产品
        $.ajax({
            type: 'GET',
            url: baseurl8+"/list",
            data:{"cid":pid},
            beforeSend: function (XMLHttpRequest) {
                XMLHttpRequest.setRequestHeader("access_token",token);
            },
            success: function (result) {
                var data=JSON.parse(result).data;
                if(data != undefined && data.length > 0){
                    var table=$("<table>").attr("class","equipmenttable");
                    var tr=$("<tr>");
                    var tdg=$("<td style='width: 50px'>").text("序号");
                    var tda=$("<td>").text("产品代码");
                    var tdb=$("<td>").text("产品名称");
                    var tdc=$("<td>").text("年产量");
                    var tdd=$("<td>").text("实际年产量");
                    var tde=$("<td>").text("单位");
                    var tdf=$("<td>").text("备注");
                    tr.append(tdg);
                    tr.append(tda);
                    tr.append(tdb);
                    tr.append(tdc);
                    tr.append(tdd);
                    tr.append(tde);
                    tr.append(tdf);
                    table.append(tr);
                    for(var i=0;i<data.length;i++){
                        var tra=$("<tr>").attr("id",data[i].pid).attr("name","mainproducts_tr");
                        var tdag=$("<td>").text(i+1);
                        var tdaa=$("<td>").text(data[i].productCode);
                        var tdab=$("<td>").text(data[i].productName);
                        var tdac=$("<td>").text(data[i].annualOutput);
                        var tdad=$("<td>").text(data[i].actualAnnualOutput);
                        var tdae=$("<td>").text(data[i].unit);
                        var tdaf=$("<td>").text(data[i].remarks);
                        tra.append(tdag);
                        tra.append(tdaa);
                        tra.append(tdab);
                        tra.append(tdac);
                        tra.append(tdad);
                        tra.append(tdae);
                        tra.append(tdaf);
                        table.append(tra);
                    }
                    var cominfoProductionProcess=$("#LAY-market-cominfoProductionProcess6");
                    cominfoProductionProcess.append(table);
                    // if(data.length>5){
                    //     $("#LAY-market-cominfoProductionProcess6").addClass("scroll");
                    // }
                    setWidthForWin(data,"LAY-market-cominfoProductionProcess6");
                    // $("[name='mainproducts_tr']").each(function () {
                    //     $(this).bind('click',function () {
                    //         setmainproducts($(this).attr("id"),baseurl8,token)
                    //     });
                    // });
                    tableCss("LAY-market-cominfoProductionProcess6",true);
                }else {
                    setVisibility("主要产品",subTitleDoms);
                }
            }
            ,error:function () {
            }
        });
    }

    title = "液体储罐信息";
    if(getShowFlag(title,array)){
        //液体储罐信息
        $.ajax({
            type: 'GET',
            url: baseurl14+"/list",
            data:{"cid":pid},
            beforeSend: function (XMLHttpRequest) {
                XMLHttpRequest.setRequestHeader("access_token",token);
            },
            success: function (result) {
                var data=JSON.parse(result).data;
                if(data != undefined && data.length > 0){
                    var table=$("<table>").attr("class","equipmenttable");
                    var tr=$("<tr>");
                    var tdg=$("<td style='width: 50px'>").text("序号");
                    var tda=$("<td>").text("物料名称");
                    var tdb=$("<td>").text("物料代码");
                    var tdc=$("<td>").text("储罐类型");
                    var tdd=$("<td>").text("储罐容积");
                    var tde=$("<td>").text("年装载量");
                    tr.append(tdg);
                    tr.append(tda);
                    tr.append(tdb);
                    tr.append(tdc);
                    tr.append(tdd);
                    tr.append(tde);
                    table.append(tr);
                    for(var i=0;i<data.length;i++){
                        var tra=$("<tr>").attr("id",data[i].pid).attr("name","mainproducts_tr");
                        var tdag=$("<td>").text(i+1);
                        var tdaa=$("<td>").text(data[i].materielName);
                        var tdab=$("<td>").text(data[i].materielCode);
                        var tdac=$("<td>").text(data[i].storageTankTypeStr);
                        var tdad=$("<td>").text(data[i].storageTankVolume);
                        var tdae=$("<td>").text(data[i].annualTurnover);
                        tra.append(tdag);
                        tra.append(tdaa);
                        tra.append(tdab);
                        tra.append(tdac);
                        tra.append(tdad);
                        tra.append(tdae);
                        table.append(tra);
                    }
                    var cominfoProductionProcess=$("#LAY-market-cominfoProductionProcess7");
                    cominfoProductionProcess.append(table);
                    // if(data.length>5){
                    //     $("#LAY-market-cominfoProductionProcess6").addClass("scroll");
                    // }
                    setWidthForWin(data,"LAY-market-cominfoProductionProcess7");
                    $("[name='mainproducts_tr']").each(function () {
                        $(this).bind('click',function () {
                            setmainproducts($(this).attr("id"),baseurl14,token)
                        });
                    });
                    tableCss("LAY-market-cominfoProductionProcess7");
                }else {
                    setVisibility("液体储罐信息",subTitleDoms);
                }
            }
            ,error:function () {
            }
        });
    }

    title = "建设项目";
    if(getShowFlag(title,array)){
        //建设项目
        $.ajax({
            type: 'GET',
            url: baseurl21 + "/list",
            data:{"cid":pid},
            beforeSend: function (XMLHttpRequest) {
                XMLHttpRequest.setRequestHeader("access_token",token);
            },
            success: function (result) {
                var data=JSON.parse(result).data;
                if(data != undefined && data.length > 0){
                    var table=$("<table>").attr("class","equipmenttable");
                    var tr=$("<tr>");
                    var tdg=$("<td style='width: 50px'>").text("序号");
                    var tda=$("<td>").text("项目名称");
                    var tdb=$("<td>").text("文件类型");
                    var tdc=$("<td>").text("审批单位");
                    var tdd=$("<td>").text("批复时间");
                    var tde=$("<td>").text("验收申请时间");
                    var tdf=$("<td>").text("验收批复时间");
                    tr.append(tdg);
                    tr.append(tda);
                    tr.append(tdb);
                    tr.append(tdc);
                    tr.append(tdd);
                    tr.append(tde);
                    tr.append(tdf);
                    table.append(tr);
                    for(var i=0;i<data.length;i++){
                        var tra=$("<tr>").attr("id",data[i].pid).attr("name","buildingprojectapproval_tr");
                        var tdag=$("<td>").text(i+1);
                        var tdaa=$("<td>").text(data[i].projectName);
                        var tdab=$("<td>").text(data[i].fileTypeName);
                        var tdac=$("<td>").text(data[i].approvalUnitName);
                        var tdad=$("<td>").text(data[i].batchTime);
                        var tdae=$("<td>").text(data[i].acceptanceRequestTime);
                        var tdaf=$("<td>").text(data[i].acceptanceBatchTime);
                        tra.append(tdag);
                        tra.append(tdaa);
                        tra.append(tdab);
                        tra.append(tdac);
                        tra.append(tdad);
                        tra.append(tdae);
                        tra.append(tdaf);
                        table.append(tra);
                    }

                    var environmenttraffic=$("#LAY-building-environmenttraffic1");
                    environmenttraffic.append(table);
                    // $("#LAY-building-environmenttraffic1").addClass("scroll");

                    setWidthForWin(data,"LAY-building-environmenttraffic1");
                    $("[name='buildingprojectapproval_tr']").each(function () {
                        $(this).bind('click',function () {
                            setBuildingProjectApprovalHtml($(this).attr("id"),baseurl21,token,remoteServiceAddress)
                        });
                    });
                    tableCss("LAY-building-environmenttraffic1");
                }else {
                    setVisibility("建设项目",subTitleDoms);
                }
            }
            ,error:function () {
            }
        });
    }

    title = "排污许可证";
    if(getShowFlag(title,array)){

        //排污许可证
        $.ajax({
            type: 'GET',
            url: baseurl22 + "/list",
            data:{"cid":pid},
            beforeSend: function (XMLHttpRequest) {
                XMLHttpRequest.setRequestHeader("access_token",token);
            },
            success: function (result) {
                var data=JSON.parse(result).data;
                if(data != undefined && data.length > 0){

                    var cols=[[
                        {type: 'numbers', unresize: true, title: '序号'}
                        ,{field: 'permitCode', unresize: true, title: '许可证编号',event:'setPollutantDischargePermit',style:'color:blue;cursor:pointer;'}
                        ,{field: 'industry', title: '行业类别', minWidth: 100,unresize: true,style:'color:#000;'}
                        ,{field: 'startDate', title: '有效期开始日期', minWidth: 100,unresize: true,style:'color:#000;'}
                        ,{field: 'endDate', title: '有效期结束日期', minWidth: 100,unresize: true,style:'color:#000;'}
                        ,{field: 'issueDate', title: '发证日期', minWidth: 100,unresize: true,style:'color:#000'}
                        ,{
                            field: 'optzhengben',
                            title: '正本',
                            unresize: true,
                            width: 80,
                            event: 'optzhengben',
                            templet: function (item, index) {
                                return '<span class="layui-btn layui-btn-xs layui-bg-blue">查看</span>';
                            }
                        }
                        ,{
                            field: 'optfuben',
                            title: '副本',
                            unresize: true,
                            width: 80,
                            event: 'optfuben',
                            templet: function (item, index) {
                                return '<span class="layui-btn layui-btn-xs layui-bg-gray">查看</span>';
                            }
                        }
                    ]];
                    layui.table.render({//查询列表信息
                        elem: '#LAY-building-environmenttraffic'
                        ,page: false
                        // ,event:true
                        ,cols: cols
                        // ,skin: 'row'
                        ,size: "sm"
                        // ,height:350
                        ,done:function () {
                            $('#LAY-building-environmenttraffic2 tr th').css({
                                'background-color': '#DBE8F8',
                                'color': '#4D77A3'
                            });
                            $('#LAY-building-environmenttraffic2 tr th').css({
                                'font-size':'15px'
                            });
                            $('#LAY-building-environmenttraffic2 tr td').css({
                                'font-size':'15px',
                                // 'color':'#000'
                            });
                        }

                    });

                    layui.table.reload("LAY-building-environmenttraffic",{//查询列表信息
                        data: data
                    });

                    layui.table.on('tool(LAY-building-environmenttraffic)',function (obj) {
                        var data=obj.data;
                        // var originalDocument=data.originalDocument==null?'':data.originalDocument;
                        // var copyFile=data.copyFile==null?'':data.copyFile;
                        if(obj.event=="setPollutantDischargePermit"){
                            setPollutantDischargePermitHtml(data.pid,baseurl22,token,remoteServiceAddress)
                        }
                        if(obj.event=="optzhengben"){
                            if(data.originalDocument!=null){
                                showFileView(data.originalDocument,remoteServiceAddress);
                            }else{
                                return layer.msg('正本没有上传!');
                            }
                        }
                        if(obj.event=="optfuben"){
                            if(data.copyFile!=null){
                                showFileView(data.copyFile,remoteServiceAddress);
                            }else{
                                return layer.msg('副本没有上传!');
                            }
                        }
                    });


                    // var table=$("<table>").attr("class","equipmenttable");
                    // var tr=$("<tr>");
                    // var tdg=$("<td style='width: 50px'>").text("序号");
                    // // var tda=$("<td>").text("单位名称");
                    // var tdb=$("<td>").text("许可证编号");
                    // var tdc=$("<td>").text("行业类别");
                    // var tdd=$("<td>").text("有效期开始日期");
                    // var tde=$("<td>").text("有效期结束日期");
                    // var tdf=$("<td>").text("发证日期");
                    // tr.append(tdg);
                    // // tr.append(tda);
                    // tr.append(tdb);
                    // tr.append(tdc);
                    // tr.append(tdd);
                    // tr.append(tde);
                    // tr.append(tdf);
                    // table.append(tr);
                    // for(var i=0;i<data.length;i++){
                    //     var tra=$("<tr>").attr("id",data[i].pid).attr("name","pollutantdischargepermit_tr");
                    //     var tdag=$("<td>").text(i+1);
                    //     // var tdaa=$("<td>").text(data[i].companyName);
                    //     var tdab=$("<td>").text(data[i].permitCode);
                    //     var tdac=$("<td>").text(data[i].industry);
                    //     var tdad=$("<td>").text(data[i].startDate);
                    //     var tdae=$("<td>").text(data[i].endDate);
                    //     var tdaf=$("<td>").text(data[i].issueDate);
                    //     tra.append(tdag);
                    //     // tra.append(tdaa);
                    //     tra.append(tdab);
                    //     tra.append(tdac);
                    //     tra.append(tdad);
                    //     tra.append(tdae);
                    //     tra.append(tdaf);
                    //     table.append(tra);
                    // }
                    //
                    // var environmenttraffic=$("#LAY-building-environmenttraffic2");
                    // environmenttraffic.append(table);
                    // // $("#LAY-building-environmenttraffic1").addClass("scroll");
                    //
                    // setWidthForWin(data,"LAY-building-environmenttraffic2");
                    // $("[name='pollutantdischargepermit_tr']").each(function () {
                    //     $(this).bind('click',function () {
                    //         setPollutantDischargePermitHtml($(this).attr("id"),baseurl22,token,remoteServiceAddress)
                    //     });
                    // });
                    // tableCss("LAY-building-environmenttraffic2");
                }else {
                    setVisibility("排污许可证",subTitleDoms);
                }
            }
            ,error:function () {
            }
        });
    }

    title = "环境信访";
    if(getShowFlag(title,array)){
        //环境信访
        $.ajax({
            type: 'GET',
            url: baseurl23+"/list",
            data:{"cid":pid},
            beforeSend: function (XMLHttpRequest) {
                XMLHttpRequest.setRequestHeader("access_token",token);
            },
            success: function (result) {
                var data=JSON.parse(result).data;
                if(data != undefined && data.length > 0){
                    var table=$("<table>").attr("class","equipmenttable");
                    var tr=$("<tr>");
                    var tdg=$("<td style='width: 50px'>").text("序号");
                    var tda=$("<td>").text("举报主题");
                    // var tdb=$("<td>").text("被举报单位");
                    var tdc=$("<td>").text("举报人");
                    var tdd=$("<td>").text("举报方式");
                    var tde=$("<td>").text("举报日期");
                    var tdf=$("<td>").text("联系电话");
                    tr.append(tdg);
                    tr.append(tda);
                    // tr.append(tdb);
                    tr.append(tdc);
                    tr.append(tdd);
                    tr.append(tde);
                    tr.append(tdf);
                    table.append(tr);
                    for(var i=0;i<data.length;i++){
                        var tra=$("<tr>").attr("id",data[i].pid).attr("name","petitionSystemComplain_tr_temp");
                        var tdag=$("<td>").text(i+1);
                        var tdaa=$("<td>").text(data[i].informTitle);
                        // var tdab=$("<td>").text(data[i].companyName);
                        var tdac=$("<td>").text(data[i].informPerson);
                        var tdad=$("<td>").text(data[i].informTypeName);
                        var tdae=$("<td>").text(data[i].informDate);
                        var tdaf=$("<td>").text(data[i].linkPhone);
                        tra.append(tdag);
                        tra.append(tdaa);
                        // tra.append(tdab);
                        tra.append(tdac);
                        tra.append(tdad);
                        tra.append(tdae);
                        tra.append(tdaf);
                        table.append(tra);
                    }
                    var environmenttraffic=$("#LAY-building-environmenttraffic3");
                    environmenttraffic.append(table);
                    // if(data.length>5){
                    //     $("#LAY-LAY-building-environmenttraffic3").addClass("scroll");
                    // }
                    setWidthForWin(data,"LAY-building-environmenttraffic3");
                    $("[name='petitionSystemComplain_tr_temp']").each(function () {
                        $(this).bind('click',function () {
                            setPetitionSystemComplainHtml($(this).attr("id"),baseurl23,token,remoteServiceAddress);
                        });
                    });
                    tableCss("LAY-building-environmenttraffic3");
                }else {
                    setVisibility("环境信访",subTitleDoms);
                }
            }
            ,error:function () {
            }
        });
    }

    title = "现场检查";
    if(getShowFlag(title,array)){
        //现场检查
        $.ajax({
            type: 'GET',
            url: baseurl24+"/list",
            data:{"cid":pid},
            beforeSend: function (XMLHttpRequest) {
                XMLHttpRequest.setRequestHeader("access_token",token);
            },
            success: function (result) {
                var data=JSON.parse(result).data;
                if(data != undefined && data.length > 0){
                    var table=$("<table>").attr("class","equipmenttable");
                    var tr=$("<tr>");
                    var tdg=$("<td style='width: 50px'>").text("序号");
                    var tda=$("<td>").text("检查人");
                    var tdb=$("<td style='width:160px'>").text("检查时间");
                    var tdc=$("<td style='width:140px'>").text("检查单位");
                    var tde=$("<td>").text("执法类型");
                    var tdd=$("<td>").text("检查结果");
                    tr.append(tdg);
                    tr.append(tda);
                    tr.append(tdb);
                    tr.append(tdc);
                    tr.append(tde);
                    tr.append(tdd);
                    table.append(tr);
                    for(var i=0;i<data.length;i++){

                        var tra=$("<tr>").attr("id",data[i].pid).attr("name","mobileenforcementscene_tr");
                        var tdag=$("<td>").text(i+1);
                        var tdaa=$("<td>").text(data[i].checkPersonName);
                        var tdab=$("<td>").text(data[i].checkStarttime);
                        var tdac=$("<td>").text(data[i].checkCompany);
                        var tdae=$("<td>").text(data[i].lawEnforcementTypeName);
                        var tdad=$("<td>").text(data[i].examinationResultsName);
                        tra.append(tdag);
                        tra.append(tdaa);
                        tra.append(tdab);
                        tra.append(tdac);
                        tra.append(tdae);
                        tra.append(tdad);
                        table.append(tra);
                    }
                    var environmenttraffic=$("#LAY-building-environmenttraffic4");
                    environmenttraffic.append(table);
                    // $("#LAY-building-environmenttraffic4").addClass("scroll");
                    setWidthForWin(data,"LAY-building-environmenttraffic4");
                    $("[name='mobileenforcementscene_tr']").each(function () {

                        $(this).bind('click',function () {
                            setMobileEnforcementSceneHtml($(this).attr("id"),baseurl24,token)
                        });
                    });
                    tableCss("LAY-building-environmenttraffic4");
                }else {
                    setVisibility("现场检查",subTitleDoms);
                }
            }
            ,error:function () {
            }
        });
    }

    title = "行政处罚";
    if(getShowFlag(title,array)){
        //行政处罚
        $.ajax({
            type: 'GET',
            url: baseurl25 + "/list",
            data:{"cid":pid},
            beforeSend: function (XMLHttpRequest) {
                XMLHttpRequest.setRequestHeader("access_token",token);
            },
            success: function (result) {
                var data=JSON.parse(result).data;
                if(data != undefined && data.length > 0){
                    var table=$("<table>").attr("class","equipmenttable");
                    var tr=$("<tr>");
                    var tdg=$("<td style='width: 50px'>").text("序号");
                    var tda=$("<td>").text("违法行为");
                    var tdb=$("<td>").text("违法类型");
                    var tdc=$("<td style='width:160px;'>").text("立案时间");
                    var tdd=$("<td style='width:160px;'>").text("结案时间");
                    tr.append(tdg);
                    tr.append(tda);
                    tr.append(tdb);
                    tr.append(tdc);
                    tr.append(tdd);
                    table.append(tr);
                    for(var i=0;i<data.length;i++){
                        var title = data[i].illegalActivities ;
                        var show = data[i].illegalActivities ;
                        var filingTime_ = "" ;
                        var closingTime_ = "" ;
                        if(show.length>30){
                            show = title.substring(0,30);
                        }
                        if(data[i].filingTime!=null){
                            filingTime_ = data[i].filingTime.substring(0,19);
                        }
                        if(data[i].closingTime!=null){
                            closingTime_ = data[i].closingTime.substring(0,19);
                        }
                        var tra=$("<tr>").attr("id",data[i].pid).attr("name","administrativepenaltyinfo_tr");
                        var tdag=$("<td>").text(i+1);
                        var tdaa=$("<td title="+title+"'>").text(show);
                        var tdab=$("<td>").text(data[i].illegalTypeName);
                        var tdac=$("<td>").text(filingTime_);
                        var tdad=$("<td>").text(closingTime_);
                        tra.append(tdag);
                        tra.append(tdaa);
                        tra.append(tdab);
                        tra.append(tdac);
                        tra.append(tdad);
                        table.append(tra);
                    }

                    var environmenttraffic=$("#LAY-building-environmenttraffic5");
                    environmenttraffic.append(table);
                    // if(data.length>5){
                    //     $("#LAY-building-environmenttraffic5").addClass("scroll");
                    // }
                    setWidthForWin(data,"LAY-building-environmenttraffic5");
                    $("[name='administrativepenaltyinfo_tr']").each(function () {
                        $(this).bind('click',function () {
                            setAdministrativepenaltyinfoHtml($(this).attr("id"),baseurl25,token,remoteServiceAddress)
                        });
                    });
                    tableCss("LAY-building-environmenttraffic5");
                }else {
                    setVisibility("行政处罚",subTitleDoms);
                }
            }
            ,error:function () {
            }
        });
    }

    title = "案件记录";
    if(getShowFlag(title,array)){
        //案件记录
        $.ajax({
            type: 'GET',
            url: baseurl26 + "/list",
            data:{"cid":pid},
            beforeSend: function (XMLHttpRequest) {
                XMLHttpRequest.setRequestHeader("access_token",token);
            },
            success: function (result) {
                var data=JSON.parse(result).data;
                if(data != undefined && data.length > 0){
                    var table=$("<table>").attr("class","equipmenttable");
                    var tr=$("<tr>");
                    var tdg=$("<td style='width: 50px'>").text("序号");
                    // var tda=$("<td>").text("被调查单位");
                    // var tdb=$("<td style='width:420px'>").text("被调查单位地址");
                    var tdc=$("<td>").text("调查单位");
                    var tde=$("<td>").text("询问人");
                    var tdd=$("<td>").text("调查时间");
                    tr.append(tdg);
                    // tr.append(tda);
                    // tr.append(tdb);
                    tr.append(tdc);
                    tr.append(tde);
                    tr.append(tdd);
                    table.append(tr);
                    for(var i=0;i<data.length;i++){
                        var tra=$("<tr>").attr("id",data[i].pid).attr("name","mobileenforcementaskrecord_tr");
                        var tdag=$("<td>").text(i+1);
                        // var tdaa=$("<td>").text(data[i].investigatedCompanyName);
                        // var tdab=$("<td>").text(data[i].investigatedCompanyAddress);
                        var tdac=$("<td>").text(data[i].investigateCompany);
                        var tdae=$("<td>").text(data[i].inquirerPersonName);
                        var tdad=$("<td>").text(data[i].investigateStarttime);
                        tra.append(tdag);
                        // tra.append(tdaa);
                        // tra.append(tdab);
                        tra.append(tdac);
                        tra.append(tdae);
                        tra.append(tdad);
                        table.append(tra);
                    }
                    var environmenttraffic=$("#LAY-building-environmenttraffic6");
                    environmenttraffic.append(table);
                    setWidthForWin(data,"LAY-building-environmenttraffic6");
                    $("[name='mobileenforcementaskrecord_tr']").each(function () {

                        $(this).bind('click',function () {
                            setMobileEnforcementAskrecordHtml($(this).attr("id"),baseurl26,token)
                        });
                    });
                    tableCss("LAY-building-environmenttraffic6");
                }else {
                    setVisibility("案件记录",subTitleDoms);
                }
            }
            ,error:function () {
            }
        });
    }

    title = "固体物料及废物";
    if(getShowFlag(title,array)){
        //固体物料及废物
        $.ajax({
            type: 'GET',
            url: baseurl63 + "/list",
            data:{"cid":pid},
            beforeSend: function (XMLHttpRequest) {
                XMLHttpRequest.setRequestHeader("access_token",token);
            },
            success: function (result) {
                var data=JSON.parse(result).data;
                if(data != undefined && data.length > 0){
                    var table=$("<table>").attr("class","equipmenttable");
                    var tr=$("<tr>");
                    var tdg=$("<td style='width: 50px'>").text("序号");
                    var tda=$("<td>").text("年度");
                    var tdb=$("<td>").text("原矿");
                    var tdc=$("<td>").text("原矿产生量");
                    var tde=$("<td>").text("精矿");
                    var tdd=$("<td>").text("精矿产生量");
                    var tdl=$("<td>").text("固体废物");
                    var tdm=$("<td>").text("固体废物产生量");
                    tr.append(tdg);
                    tr.append(tda);
                    tr.append(tdb);
                    tr.append(tdc);
                    tr.append(tde);
                    tr.append(tdd);
                    tr.append(tdl);
                    tr.append(tdm);
                    table.append(tr);
                    for(var i=0;i<data.length;i++){
                        var tra=$("<tr>").attr("id",data[i].pid).attr("name","radioactiveore1_tr");
                        var tdag=$("<td>").text(i+1);
                        var tdaa=$("<td>").text(data[i].year);
                        var tdab=$("<td>").text(data[i].rawOreStr);
                        var tdac=$("<td>").text(data[i].rawOreQuantity);
                        var tdae=$("<td>").text(data[i].concentrateStr);
                        var tdad=$("<td>").text(data[i].concentrateQuantity);
                        var tdal=$("<td>").text(data[i].solidWasteStr);
                        var tdam=$("<td>").text(data[i].solidWasteQuantity);
                        tra.append(tdag);
                        tra.append(tdaa);
                        tra.append(tdab);
                        tra.append(tdac);
                        tra.append(tdae);
                        tra.append(tdad);
                        tra.append(tdal);
                        tra.append(tdam);
                        table.append(tra);
                    }
                    var environmenttraffic=$("#LAY-radioactiveore1");
                    environmenttraffic.append(table);
                    setWidthForWin(data,"LAY-radioactiveore1");
                    $("[name='radioactiveore1_tr']").each(function () {

                        $(this).bind('click',function () {
                            setradioactiveore1Html($(this).attr("id"),baseurl63,token)
                        });
                    });
                    tableCss("LAY-radioactiveore1");
                }else {
                    setVisibility("固体物料及废物",subTitleDoms);
                }
            }
            ,error:function () {
            }
        });
    }

    title = "固废处理场所";
    if(getShowFlag(title,array)){
        //固废处理场所
        $.ajax({
            type: 'GET',
            url: baseurl61 + "/list",
            data:{"cid":pid},
            beforeSend: function (XMLHttpRequest) {
                XMLHttpRequest.setRequestHeader("access_token",token);
            },
            success: function (result) {
                var data=JSON.parse(result).data;
                if(data != undefined && data.length > 0){
                    solidWasteDisposeTpl($,baseurl61,data,baseurl62);
                    tableCss("LAY-wasteProcessPlace0");
                }else {
                    setVisibility("固废处理场所",subTitleDoms);
                }
            }
            ,error:function () {
            }
        });
    }

    title = "危废处理场所";
    if(getShowFlag(title,array)){
        //固废处理场所
        $.ajax({
            type: 'GET',
            url: baseurl61 + "/list",
            data:{"cid":pid,"wasteCategoryType":1},
            beforeSend: function (XMLHttpRequest) {
                XMLHttpRequest.setRequestHeader("access_token",token);
            },
            success: function (result) {
                var data=JSON.parse(result).data;
                if(data != undefined && data.length > 0){
                }else {
                    setVisibility("固废处理场所",subTitleDoms);
                }
            }
            ,error:function () {
            }
        });
    }

    title = "废水监测";
    if(getShowFlag(title,array)){
        //废水监测
        $.ajax({
            type: 'GET',
            url: baseurl64 + "/list",
            data:{"cid":pid,"category":0},
            beforeSend: function (XMLHttpRequest) {
                XMLHttpRequest.setRequestHeader("access_token",token);
            },
            success: function (result) {
                var data=JSON.parse(result).data;
                if(data != undefined && data.length > 0){
                    getRadioactiveOreDataTpl($,baseurl64,data,0,token);
                    // tableCss("LAY-radioactiveore2");
                }else {
                    setVisibility("废水监测",subTitleDoms);
                }
            }
            ,error:function () {
            }
        });
    }

    title = "固体物料及废物监测";
    if(getShowFlag(title,array)){
        //固体物料及废物监测
        $.ajax({
            type: 'GET',
            url: baseurl64 + "/list",
            data:{"cid":pid,"category":1},
            beforeSend: function (XMLHttpRequest) {
                XMLHttpRequest.setRequestHeader("access_token",token);
            },
            success: function (result) {
                var data=JSON.parse(result).data;
                if(data != undefined && data.length > 0){
                    getRadioactiveOreDataTpl($,baseurl64,data,1,token);
                }else {
                    setVisibility("固体物料及废物监测",subTitleDoms);
                }
            }
            ,error:function () {
            }
        });
    }

    window.onload=function(){
        $("#comInfoReload0").trigger("click");
        $("#comInfoReload1").trigger("click");
        $("#comInfoReload2").trigger("click");
        layer.close(loadindex);
    };

}

function getRadioactiveOreDataTpl($,url,data,differ,token) {
    var count=0;
    for(var i=0;i<data.length;i++){
        var li=$("<li>").text(data[i].monitorName).attr("class","layui-this").attr("data-name",i).attr("id","radioactiveOreClick"+differ).attr("value",data[i].pid);
        var div=$("<div>").addClass("layui-tab-item layui-show");
        var divChildren=$("<div>").attr("id","LAY-solid-radioactiveOre"+data[i].pid);

        if(count>0){
            li=$("<li>").text(data[i].monitorName).attr("data-name",i).attr("value",data[i].pid);
            div=$("<div>").addClass("layui-tab-item");
        }
        $("#radioactiveOre-info"+differ).append(li);
        div.append(divChildren);
        $("#radioactiveOre-waste"+differ).append(div);
        count+=1;
    }

    $("#radioactiveOre-info"+differ+" li").on("click",function () {
        var value=$(this).attr("value");
        var i=$(this).attr("data-name");
        getRadioactiveOreHtmlTpl($,url,value,token,data[i]);
    });

    $("#radioactiveOreClick"+differ).trigger("click");
}

function getRadioactiveOreHtmlTpl($,url,mid,token,data) {
    var table='<div class="layui-tab layui-tab-brief">' +
        ' <ul class="layui-tab-title" id="center_radioactiveOre_info'+mid+'">' +
        '   <li id="center_radioactiveOre_firstClick'+mid+'" value="0" class="layui-this">基本信息</li>' +
        '   <li value="1">检测项目</li>' +
        '</ul>' +
        '<div class="layui-tab-content">' +
        '   <div class="layui-tab-item layui-show">' +
        '      <div id="Lay_radioactiveOre_center_content'+mid+'0">' +
        '      </div>' +
        '   </div>' +
        '   <div class="layui-tab-item">' +
        '      <div style="height:539px;">' +
        '          <div id="Lay_radioactiveOre_center_content'+mid+'1"></div>' +
        '      </div>' +
        '   </div>' +
        '</div>' +
        '</div>'
    ;
    $("#LAY-solid-radioactiveOre"+mid).html(table);
    $("#center_radioactiveOre_info"+mid+" li").unbind();
    $("#center_radioactiveOre_info"+mid+" li").on("click",function () {
        var value=$(this).attr("value");
        if(value==1){
            getRadioactiveOreProjectDataTpl($,url,mid,token,value);
        }
    });

    var year=data.year==null?'':data.year;
    var monitorTypeStr=data.monitorTypeStr==null?'':data.monitorTypeStr;
    var samplingDate=data.samplingDate==null?'':data.samplingDate;
    var monitorName=data.monitorName==null?'':data.monitorName;
    var monitorCode=data.monitorCode==null?'':data.monitorCode;
    var longitude=data.longitude==null?'':data.longitude;
    var latitude=data.latitude==null?'':data.latitude;
    var remarks=data.remarks==null?'':data.remarks;

    var html='<div class="layui-fluid">\n' +
        '        <div class="layui-row layui-col-space15">\n' +
        '            <!--<div class="layui-card-header">响应式组合</div>-->\n' +
        '            <div class="layui-card-body">\n' +
        '                <form class="layui-form" action="" lay-filter="component-form-element">\n' +
        '                    <table class="reporttable">\n' +
        '                        <tr>\n' +
        '                            <td>年度：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text" name="year" value="'+year+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                            <td></td>\n' +
        '                            <td></td>\n' +
        '                        </tr>\n' +
        '                        <tr>\n' +
        '                            <td>检测类型：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text" name="monitorType" value="'+monitorTypeStr+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                            <td>取样时间：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text" name="samplingDate" value="'+samplingDate+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                        </tr>\n' +
        '                        <tr>\n' +
        '                            <td>取样的名称：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text" name="monitorName" value="'+monitorName+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                            <td>取样的编号：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text" name="monitorCode" value="'+monitorCode+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                        </tr>\n' +
        '                        <tr>\n' +
        '                            <td>经度：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text" name="longitude" value="'+longitude+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                            <td>纬度：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text" name="latitude" value="'+latitude+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                        </tr>\n' +
        '                        <tr>\n' +
        '                            <td>备注：</td>\n' +
        '                            <td colspan="3">\n' +
        '                                <textarea type="text" name="remarks" readonly style="resize: none" class="layui-textarea">'+remarks+'</textarea>\n' +
        '                            </td>\n' +
        '                        </tr>\n' +
        '                    </table>\n' +
        '                </form>\n' +
        '            </div>\n' +
        '        </div>\n' +
        '    </div>';
    $("#Lay_radioactiveOre_center_content"+mid+"0").html(html);

}

function getRadioactiveOreProjectDataTpl($,url,mid,token,differ) {
    $.ajax({
        type: 'GET',
        url: url + "/getpollutantList",
        data:{"mid":mid},
        beforeSend: function (XMLHttpRequest) {
            XMLHttpRequest.setRequestHeader("access_token",token);
        },
        success: function (result) {
            var data=JSON.parse(result).data;
            var table=$("<table>").attr("class","equipmenttable");
            var tr=$("<tr>");
            var tdg=$("<td style='width: 50px'>").text("序号");
            var tda=$("<td>").text("放射性检测项目名称");
            var tdb=$("<td>").text("射性检测项目代码");
            var tdc=$("<td>").text("计量单位");
            var tde=$("<td>").text("指标值");
            tr.append(tdg);
            tr.append(tda);
            tr.append(tdb);
            tr.append(tdc);
            tr.append(tde);
            table.append(tr);
            for(var i=0;i<data.length;i++){
                var tra=$("<tr>").attr("id",data[i].pid);
                var tdag=$("<td>").text(i+1);
                var tdaa=$("<td>").text(data[i].pollutantName);
                var tdab=$("<td>").text(data[i].pollutantCode);
                var tdac=$("<td>").text(data[i].pollutantUnit);
                var tdae=$("<td>").text(data[i].desiredValue);
                tra.append(tdag);
                tra.append(tdaa);
                tra.append(tdab);
                tra.append(tdac);
                tra.append(tdae);
                table.append(tra);
            }
            var radioactiveOre=$("#Lay_radioactiveOre_center_content"+mid+differ);
            radioactiveOre.html("");
            radioactiveOre.append(table);
            setWidthForWin(data,"Lay_solid_center_content"+mid+differ);
            tableCss("Lay_radioactiveOre_center_content"+mid+differ,true);
        }
        ,error:function () {
        }
    });
}

function getSolidDisposeTpl($,data,count,differ) {
    var li=$("<li>").text(data.wasteProcessPlaceName).attr("class","layui-this").attr("id","solidClick"+differ).attr("value",data.pid);
    var div=$("<div>").addClass("layui-tab-item layui-show");
    var divChildren=$("<div>").attr("id","LAY-solid-wasteProcessPlace"+data.pid);

    if(count>0){
        li=$("<li>").text(data.wasteProcessPlaceName).attr("value",data.pid);
        div=$("<div>").addClass("layui-tab-item");
    }
    $("#solid-info"+differ).append(li);
    // divChildren.append(table);
    div.append(divChildren);
    count+=1;
    return count;
}

function setSolidWasteHtml(i,data) {
    var result=data[i];
    var useTypeStr=result.useTypeStr==null?'':result.useTypeStr;
    var produceYear=result.produceYear==null?'':result.produceYear;
    var wasteName=result.wasteName==null?'':result.wasteName;
    var wasteTypeName=result.wasteTypeName==null?'':result.wasteTypeName;
    var wasteCode=result.wasteCode==null?'':result.wasteCode;
    var disposeMethod=result.disposeMethod==null?'':result.disposeMethod;
    var yearCount=result.yearCount==null?'':result.yearCount;
    var totalCount=result.totalCount==null?'':result.totalCount;
    var wasteProduction=result.wasteProduction==null?'':result.wasteProduction;
    var wasteComprehensive=result.wasteComprehensive==null?'':result.wasteComprehensive;
    var selfComprehensive=result.selfComprehensive==null?'':result.selfComprehensive;
    var pastYearsComprehensive=result.pastYearsComprehensive==null?'':result.pastYearsComprehensive;
    var wasteDisposal=result.wasteDisposal==null?'':result.wasteDisposal;
    var selfDisposal=result.selfDisposal==null?'':result.selfDisposal;
    var pastYearsDisposal=result.pastYearsDisposal==null?'':result.pastYearsDisposal;
    var wasteStorage=result.wasteStorage==null?'':result.wasteStorage;
    var wasteDumpingDiscarding=result.wasteDumpingDiscarding==null?'':result.wasteDumpingDiscarding;
    var sendCertificatesUnitage=result.sendCertificatesUnitage==null?'':result.sendCertificatesUnitage;
    var receiveForeignDangerWaste=result.receiveForeignDangerWaste==null?'':result.receiveForeignDangerWaste;
    var isWasteName=result.isWasteName==null?'':result.isWasteName;
    var isTransferCoupletName=result.isTransferCoupletName==null?'':result.isTransferCoupletName;
    var storeFacilities=result.storeFacilities==null?'':result.storeFacilities;
    var disposeCompany=result.disposeCompany==null?'':result.disposeCompany;
    var remark=result.remark==null?'':result.remark;

    var htmlContent  =  '<div class="layui-fluid">\n' +
        '        <div class="layui-row layui-col-space15">\n' +
        '            <!--<div class="layui-card-header">响应式组合</div>-->\n' +
        '            <div class="layui-card-body">\n' +
        '                <form class="layui-form" action="" lay-filter="component-form-element">\n' +
        '                    <input type="hidden" name="pid" value="{{d.pid}}"/>\n' +
        '                    <input type="hidden" name="cid" value="{{d.cid}}"/>\n' +
        '                    <table class="reporttable">\n' +
        '                        <tr>\n' +
        '                            <td>分类：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text" name="useTypeStr" readonly value="'+useTypeStr+'" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                            <td>年度：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text" name="produceYear" readonly value="'+produceYear+'" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                        </tr>\n' +
        '                        <tr>\n' +
        '                            <td>废物名称：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text" name="wasteName" readonly value="'+wasteName+'" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                            <td>废物种类：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text" name="wasteTypeName" readonly value="'+wasteTypeName+'" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                        </tr>\n' +
        '                        <tr>\n' +
        '                            <td>废物小类代码：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text" name="wasteCode" readonly value="'+wasteCode+'" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                            <td>处置方法：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text" name="disposeMethod" readonly value="'+disposeMethod+'" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                        </tr>\n' +
        '                        <tr>\n' +
        '                            <td>当年产生量（吨）：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text" name="yearCount" readonly value="'+yearCount+'" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                            <td>历年储存总量（吨）：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text"  name="totalCount" readonly value="'+totalCount+'" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                        </tr>\n' +
        '                        <tr>\n' +
        '                            <td>废物产生量（吨）：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text" name="wasteProduction" readonly value="'+wasteProduction+'" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                            <td>废物综合利用量（吨）：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text"  name="wasteComprehensive" readonly value="'+wasteComprehensive+'" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                        </tr>\n' +
        '                        <tr>\n' +
        '                            <td>自行综合利用量（吨）：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text" name="selfComprehensive" readonly value="'+selfComprehensive+'" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                            <td>综合利用往年贮存量（吨）：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text"  name="pastYearsComprehensive" readonly value="'+pastYearsComprehensive+'" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                        </tr>\n' +
        '                        <tr>\n' +
        '                            <td>废物处置量（吨）：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text" name="wasteDisposal" readonly value="'+wasteDisposal+'" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                            <td>自行处置量（吨）：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text"  name="selfDisposal" readonly value="'+selfDisposal+'" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                        </tr>\n' +
        '                        <tr>\n' +
        '                            <td>处置往年贮存量（吨）：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text" name="pastYearsDisposal" readonly value="'+pastYearsDisposal+'" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                            <td>废物贮存量（吨）：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text"  name="wasteStorage" readonly value="'+wasteStorage+'" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                        </tr>\n' +
        '                        <tr>\n' +
        '                            <td>废物倾倒丢弃量（吨）：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text" name="wasteDumpingDiscarding" readonly value="'+wasteDumpingDiscarding+'" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                            <td>送持证单位量（吨）：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text"  name="sendCertificatesUnitage" readonly value="'+sendCertificatesUnitage+'" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                        </tr>\n' +
        '                        <tr>\n' +
        '                            <td>接收外来危险废物量（吨）：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text" name="receiveForeignDangerWaste" readonly value="'+receiveForeignDangerWaste+'" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                            <td></td>\n' +
        '                            <td></td>\n' +
        '                        </tr>\n' +
        '                        <tr>\n' +
        '                            <td>是否属于危险废物：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text" name="isWasteName" readonly value="'+isWasteName+'" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                            <td>是否办理转移联单：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text" name="isTransferCoupletName" readonly value="'+isTransferCoupletName+'" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                        </tr>\n' +
        '                        <tr>\n' +
        '                            <td>储存场所三防设施：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text" name="storeFacilities" readonly value="'+storeFacilities+'" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                            <td>处置单位：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text" name="disposeCompany" readonly value="'+disposeCompany+'" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                        </tr>\n' +
        '                        <tr>\n' +
        '                            <td>备注：</td>\n' +
        '                            <td colspan="3">\n' +
        '                                <textarea type="text" name="remark" readonly style="resize: none;" placeholder="" autocomplete="off" class="layui-textarea">'+remark+'</textarea>\n' +
        '                            </td>\n' +
        '                        </tr>\n' +
        '                    </table>\n' +
        '                </form>\n' +
        '            </div>\n' +
        '        </div>\n' +
        '    </div>' ;
    layui.layer.open({
        type: 1
        ,content: htmlContent
        ,scrollbar: false
        ,area: ['1100px', '550px']
    });

}

function setSolDataTpl($,url,pid,differ) {
    $("#center_solid_info"+pid+" li").unbind();
    $("#center_solid_info"+pid+" li").on("click",function () {
        var value=$(this).attr("value");
        if(value==1){
            $.ajax({
                type: 'GET',
                url: url+"/list",
                data:{"placeId":pid,"useType":differ},

                beforeSend: function (XMLHttpRequest) {
                    XMLHttpRequest.setRequestHeader("access_token",JSON.parse(localStorage["layuiAdmin"]).access_token);
                },
                success: function (result) {
                    var data=result.data;
                    var table=$("<table>").attr("class","equipmenttable").attr("style","width:95%");
                    var tr=$("<tr>");
                    var tdg=$("<td style='width: 50px'>").text("序号");
                    var tda=$("<td>").text("名称");
                    var tdb=$("<td>").text("废物种类");
                    var tdc=$("<td>").text("年度");
                    var tdd=$("<td>").text("是否属于危险废物");
                    var tde=$("<td>").text("备注");
                    tr.append(tdg);
                    tr.append(tda);
                    tr.append(tdb);
                    tr.append(tdc);
                    tr.append(tdd);
                    tr.append(tde);
                    table.append(tr);
                    for(var i=0;i<data.length;i++){
                        var tra=$("<tr>").attr("id",i).attr("name","wasteProcessPlace_tr");
                        var tdag=$("<td>").text(i+1);
                        var tdaa=$("<td>").text(data[i].wasteName);
                        var tdab=$("<td>").text(data[i].wasteTypeName);
                        var tdac=$("<td>").text(data[i].produceYear);
                        var tdad=$("<td>").text("否");
                        if(data[i].isWaste==1){
                            tdad=$("<td>").text("是");
                        }
                        var tdae=$("<td>").text(data[i].remark);
                        tra.append(tdag);
                        tra.append(tdaa);
                        tra.append(tdab);
                        tra.append(tdac);
                        tra.append(tdad);
                        tra.append(tdae);
                        table.append(tra);
                    }

                    var solidTraffic=$("#Lay_solid_center_content"+pid+value);
                    solidTraffic.html("");
                    solidTraffic.append(table);

                    setWidthForWin(data,"Lay_solid_center_content"+pid+value);
                    $("[name='wasteProcessPlace_tr']").each(function () {
                        $(this).unbind();
                        $(this).bind('click',function () {
                            setSolidWasteHtml($(this).attr("id"),data);
                        });
                    });
                    tableCss("Lay_solid_center_content"+pid+value);

                }
                ,error:function () {
                }
            });
        }
    });
}

function getSolidDataTpl($,url,pid,differ,wasteUrl) {
    $.ajax({
        type: 'GET',
        url: url+"/"+pid,
        beforeSend: function (XMLHttpRequest) {
            XMLHttpRequest.setRequestHeader("access_token",JSON.parse(localStorage["layuiAdmin"]).access_token);
        },
        success: function (result) {
            var data=result.cominfoWasteProcessPlace;
            var table=solidRenderTpl(data);
            $("#solid-waste"+differ).html(table);
            setSolDataTpl($,wasteUrl,pid,differ)
        }
        ,error:function () {
        }
    });
}

function solidWasteDisposeTpl($,url,data,wasteUrl) {
    //统计固废和危废不同次数
    var solidCount=0;
    var wasteCount=0;
    for(var i=0;i<data.length;i++){
        if(data[i].wasteCategoryType==0){
            solidCount=getSolidDisposeTpl($,data[i],solidCount,0);
        }
        if(data[i].wasteCategoryType==1){
            wasteCount=getSolidDisposeTpl($,data[i],wasteCount,1);
        }

    }

    if(solidCount>0){
        $("#solid-info0 li").on("click",function () {
            var value=$(this).attr("value");
            getSolidDataTpl($,url,value,0,wasteUrl);
        });
    }

    if(wasteCount>0){
        $("#solid-info1 li").on("click",function () {
            var value=$(this).attr("value");
            getSolidDataTpl($,url,value,1,wasteUrl);
        });
    }

    $("#solidClick0").trigger("click");
    $("#solidClick1").trigger("click");
}

function solidRenderTpl(data) {
    var pid=data.pid==null?'':data.pid;
    var wasteProcessPlaceCode=data.wasteProcessPlaceCode==null?'':data.wasteProcessPlaceCode;
    var wasteProcessPlaceName=data.wasteProcessPlaceName==null?'':data.wasteProcessPlaceName;
    var wasteProcessPlaceTypeName=data.wasteProcessPlaceTypeName==null?'':data.wasteProcessPlaceTypeName;
    var year=data.year==null?'':data.year;
    var wasteProcessPlacePosition=data.wasteProcessPlacePosition==null?'':data.wasteProcessPlacePosition;
    var placeLongitude=data.placeLongitude==null?'':data.placeLongitude;
    var placeLatitude=data.placeLatitude==null?'':data.placeLatitude;
    var placeDesignCapacity=data.placeDesignCapacity==null?'':data.placeDesignCapacity;
    var placeFilledCapacity=data.placeFilledCapacity==null?'':data.placeFilledCapacity;
    var placeDesignAbility=data.placeDesignAbility==null?'':data.placeDesignAbility;
    var riskLevel=data.riskLevel==null?'':data.riskLevel;
    var riskDelineationYear=data.riskDelineationYear==null?'':data.riskDelineationYear;
    var actualLandfillCapacity=data.actualLandfillCapacity==null?'':data.actualLandfillCapacity;
    var burnDeviceLongitude=data.burnDeviceLongitude==null?'':data.burnDeviceLongitude;
    var burnDeviceLatitude=data.burnDeviceLatitude==null?'':data.burnDeviceLatitude;
    var burnDevicePosition=data.burnDevicePosition==null?'':data.burnDevicePosition;
    var facilitiesNumber=data.facilitiesNumber==null?'':data.facilitiesNumber;
    var burnDisposalCapacity=data.burnDisposalCapacity==null?'':data.burnDisposalCapacity;
    var actualBurnDisposalCapacity=data.actualBurnDisposalCapacity==null?'':data.actualBurnDisposalCapacity;
    var comprehensiveModeName=data.comprehensiveModeName==null?'':data.comprehensiveModeName;
    var comprehensiveAbility=data.comprehensiveAbility==null?'':data.comprehensiveAbility;
    var actualComprehensiveAmount=data.actualComprehensiveAmount==null?'':data.actualComprehensiveAmount;
    var singleDesignCapability=data.singleDesignCapability==null?'':data.singleDesignCapability;
    var dayRuntime=data.dayRuntime==null?'':data.dayRuntime;
    var governanceLimit=data.governanceLimit==null?'':data.governanceLimit;
    var acceptanceOpinion=data.acceptanceOpinion==null?'':data.acceptanceOpinion;

    return '<div class="layui-tab layui-tab-brief">\n' +
        '                        <ul class="layui-tab-title" id="center_solid_info'+pid+'">\n' +
        '                            <li id="center_solid_firstClick'+pid+'" value="0" class="layui-this">基本信息</li>\n' +
        '                            <li value="1">固废危废</li>\n' +
        '                        </ul>\n' +
        '                        <div class="layui-tab-content">\n' +
        '                            <div class="layui-tab-item layui-show">\n' +
        '                                <div id="Lay_solid_center_content'+pid+'0">' +
        ' <div class="layui-fluid">\n' +
        '        <div class="layui-row layui-col-space15">\n' +
        '            <!--<div class="layui-card-header">响应式组合</div>-->\n' +
        '            <div class="layui-card-body">\n' +
        '                <form class="layui-form" action="">\n' +
        '                    <table class="reporttable">\n' +
        '                        <tr>\n' +
        '                            <td>处理场编号：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text" name="wasteProcessPlaceCode" readonly value="'+wasteProcessPlaceCode+'" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                            <td>处理场名称：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text" name="wasteProcessPlaceName" readonly value="'+wasteProcessPlaceName+'" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                        </tr>\n' +
        '                        <tr>\n' +
        '                            <td>处理场类型：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text" name="wasteProcessPlaceTypeName" readonly value="'+wasteProcessPlaceTypeName+'" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                            <td>年度：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text" name="year" readonly value="'+year+'" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                        </tr>\n' +
        '                        <tr>\n' +
        '                            <td>处理场地址：</td>\n' +
        '                            <td colspan="3">\n' +
        '                                <input type="text" name="wasteProcessPlacePosition" readonly value="'+wasteProcessPlacePosition+'" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                        </tr>\n' +
        '                        <tr>\n' +
        '                            <td>经度：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text" name="placeLongitude" readonly value="'+placeLongitude+'" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                            <td>纬度：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text" name="placeLatitude" readonly value="'+placeLatitude+'" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                        </tr>\n' +
        '                        <tr>\n' +
        '                            <td>处理场设计容量：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text" name="placeDesignCapacity" readonly value="'+placeDesignCapacity+'" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                            <td>处理场已填容量：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text" name="placeFilledCapacity" readonly value="'+placeFilledCapacity+'" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                        </tr>\n' +
        '                        <tr>\n' +
        '                            <td>处理场设计处置能力：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text" name="placeDesignAbility" readonly value="'+placeDesignAbility+'" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                            <td>尾矿库环境风险等级：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text" name="riskLevel" readonly value="'+riskLevel+'" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                        </tr>\n' +
        '                        <tr>\n' +
        '                            <td>尾矿库环境风险等级划定年份：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text" name="riskDelineationYear" readonly value="'+riskDelineationYear+'" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                            <td>本年实际填埋处置量：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text" name="actualLandfillCapacity" readonly value="'+actualLandfillCapacity+'" lay-verify="phoneVerify" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                        </tr>\n' +
        '                        <tr>\n' +
        '                            <td>焚烧装置的地理坐标-经度：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text" name="burnDeviceLongitude" readonly value="'+burnDeviceLongitude+'" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                            <td>焚烧装置的地理坐标-纬度：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text" name="burnDeviceLatitude" readonly value="'+burnDeviceLatitude+'" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                        </tr>\n' +
        '                        <tr>\n' +
        '                            <td>焚烧装置的具体位置：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text" name="burnDevicePosition" readonly value="'+burnDevicePosition+'" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                            <td>设施数量：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text" name="facilitiesNumber" readonly value="'+facilitiesNumber+'" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                        </tr>\n' +
        '                        <tr>\n' +
        '                            <td>设计焚烧处置能力：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text" name="burnDisposalCapacity" readonly value="'+burnDisposalCapacity+'" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                            <td>本年实际焚烧处置量：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text" name="actualBurnDisposalCapacity" readonly value="'+actualBurnDisposalCapacity+'" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                        </tr>\n' +
        '                        <tr>\n' +
        '                            <td>综合利用方式：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text" name="comprehensiveModeName" readonly value="'+comprehensiveModeName+'" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                            <td>综合利用能力：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text" name="comprehensiveAbility" readonly value="'+comprehensiveAbility+'" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                        </tr>\n' +
        '                        <tr>\n' +
        '                            <td>本年实际综合利用量：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text" name="actualComprehensiveAmount" readonly value="'+actualComprehensiveAmount+'" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                            <td>单台设计能力：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text" name="singleDesignCapability" readonly value="'+singleDesignCapability+'" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                        </tr>\n' +
        '                        <tr>\n' +
        '                            <td>日平均运行时间（小时）：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text" name="dayRuntime" readonly value="'+dayRuntime+'" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                            <td>治理期限：</td>\n' +
        '                            <td>\n' +
        '                                <input type="text" name="governanceLimit" readonly value="'+governanceLimit+'" placeholder="" autocomplete="off" class="layui-input">\n' +
        '                            </td>\n' +
        '                        </tr>\n' +
        '                        <tr>\n' +
        '                            <td>验收意见：</td>\n' +
        '                            <td colspan="3">\n' +
        '                                <textarea style="resize: none;" readonly name="acceptanceOpinion" placeholder="" class="layui-textarea">'+acceptanceOpinion+'</textarea>\n' +
        '                            </td>\n' +
        '                        </tr>\n' +
        '                    </table>\n' +
        '                </form>\n' +
        '            </div>\n' +
        '        </div>\n' +
        '    </div>'+
        '</div>\n' +
        '                            </div>\n' +
        '                            <div class="layui-tab-item">\n' +
        '                             <div style="height:539px;">' +
        '                                <div id="Lay_solid_center_content'+pid+'1"></div>\n' +
        '                             </div>'+
        '                            </div>\n' +
        '                        </div>\n' +
        '                    </div>';
}

// function toObj(key,val){
//     var data = {};
//     data[key] = val;
//     return data;
// }

var loadTitleDom = function(doms,permissions) {
    var index = 1;
    var array = [];
    for(var i = 0 ; i < doms.length ; i++ ){
        var inputtext = $(doms[i]).attr("power");
        if( JSON.stringify(permissions).indexOf(inputtext) === -1){
            $("[power='"+inputtext+"']").empty();
            $("[power='"+inputtext+"']").remove();
        }else{
            $("[power='"+inputtext+"'] a").attr("name",index++)
            array.push({"name":inputtext,"index":0});
        }
    }
    return array;
}

function loadSubTitleDom(titleDoms,doms,permissions) {
    for(var i = 0 ; i < doms.length ; i++ ){
        var inputtext = $(doms[i]).attr("power");
        if( JSON.stringify(permissions).indexOf(inputtext) === -1){
            $("[power='"+inputtext+"']").empty();
            $("[power='"+inputtext+"']").remove();
        }else{
            var subindex = 0;
            var fatherdom = inputtext.split(":")[0];
            for(var j = 0 ; j < titleDoms.length ; j++ ){
                if(titleDoms[j].name == fatherdom){
                    var tempindex = titleDoms[j].index + 1;
                    titleDoms[j].index = tempindex;
                    subindex = tempindex;
                }
            }
            var fatherindex = $("[power='"+fatherdom+"'] a").attr("name");
            $("[power='"+inputtext+"'] a").attr("name",fatherindex + "-" + subindex);
        }
    }
}

/**
 * 根据权限加载界面内容
 */
function loadDivByPower(){
    var permissions = JSON.parse(localStorage["permissionName"]).permissionName;
    var titleDoms = $(".headline-1");
    var subTitleDoms = $(".headline-2");
    var titleDoms =loadTitleDom(titleDoms,permissions);//加载一级标题
    loadSubTitleDom(titleDoms,subTitleDoms,permissions);//加载二级标题和内容（子标题）
}

/**
 * 设置表格宽度
 * @param $dom
 */
function setWidthForWin(data,$dom){
    $("#"+$dom).width($('.para').width()-22);
    if(data.length>5){
        $("#"+$dom).addClass("myscroll");
    }
}

/**
 * 固体物料及废物
 * @param radioactiveore1_pid
 * @param url
 * @param token
 * @param remoteServiceAddress
 */
var setradioactiveore1Html=function(radioactiveore1_pid,url,token,remoteServiceAddress) {
    $.ajax({
        type: 'GET',
        url: url+"/"+radioactiveore1_pid,
        beforeSend: function (XMLHttpRequest) {
            XMLHttpRequest.setRequestHeader("access_token",token);
        },
        success: function (data) {
            var result=data.cominfoRadioactiveOre;
            var year=result.year==null?'':result.year;
            var rawOreStr=result.rawOreStr==null?'':result.rawOreStr;
            var rawOreQuantity=result.rawOreQuantity==null?'':result.rawOreQuantity;
            var concentrateStr=result.concentrateStr==null?'':result.concentrateStr;
            var concentrateQuantity=result.concentrateQuantity==null?'':result.concentrateQuantity;
            var solidWasteStr=result.solidWasteStr==null?'':result.solidWasteStr;
            var solidWasteQuantity=result.solidWasteQuantity==null?'':result.solidWasteQuantity;
            var solidWasteUtilize=result.solidWasteUtilize==null?'':result.solidWasteUtilize;
            var solidWasteInnerUtilize=result.solidWasteInnerUtilize==null?'':result.solidWasteInnerUtilize;
            var solidWasteReceiveUtilize=result.solidWasteReceiveUtilize==null?'':result.solidWasteReceiveUtilize;
            var solidWasteDeal=result.solidWasteDeal==null?'':result.solidWasteDeal;
            var solidWasteInnerDeal=result.solidWasteInnerDeal==null?'':result.solidWasteInnerDeal;
            var solidWasteOuterDeal=result.solidWasteOuterDeal==null?'':result.solidWasteOuterDeal;
            var solidWasteReceiveDeal=result.solidWasteReceiveDeal==null?'':result.solidWasteReceiveDeal;
            var solidWasteStorage=result.solidWasteStorage==null?'':result.solidWasteStorage;
            var remarks=result.remarks==null?'':result.remarks;

            var htmlContent  =  '<div class="layui-fluid">\n' +
                '        <div class="layui-row layui-col-space15">\n' +
                '            <!--<div class="layui-card-header">响应式组合</div>-->\n' +
                '            <div class="layui-card-body">\n' +
                '                <form class="layui-form" id="processingPlaceEdit" action="" lay-filter="component-form-element">\n' +
                '                    <table class="reporttable">\n' +
                '                        <tr >\n' +
                '                            <td>年度：</td>\n' +
                '                            <td>\n' +
                '                                <input type="text" name="year" value="'+year+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                '                            </td>\n' +
                '                            <td></td>\n' +
                '                            <td></td>\n' +
                '\n' +
                '                    </tr>\n' +
                '                        <tr>\n' +
                '                        <td>原矿：</td>\n' +
                '                        <td>\n' +
                '                            <input type="text" name="rawOre" value="'+rawOreStr+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                '                        </td>\n' +
                '                            <td>原矿产生量：</td>\n' +
                '                            <td>\n' +
                '                                <input type="text" name="rawOreQuantity" value="'+rawOreQuantity+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                '                            </td>\n' +
                '                        </tr>\n' +
                '                        <tr>\n' +
                '                            <td>精矿：</td>\n' +
                '                            <!-- <td colspan="3">-->\n' +
                '                            <td>\n' +
                '                                <input type="text" name="concentrate" value="'+concentrateStr+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                '                            </td>\n' +
                '                            <td>精矿产生量：</td>\n' +
                '                            <td>\n' +
                '                                <input type="text" name="concentrateQuantity" value="'+concentrateQuantity+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                '                            </td>\n' +
                '                        </tr>\n' +
                '                        <tr>\n' +
                '                            <td>固体废物：</td>\n' +
                '                            <td>\n' +
                '                                <input type="text" name="solidWaste" value="'+solidWasteStr+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                '                            </td>\n' +
                '                            <td>固体废物产生量：</td>\n' +
                '                            <td>\n' +
                '                                <input type="text" name="solidWasteQuantity" value="'+solidWasteQuantity+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                '                            </td>\n' +
                '\n' +
                '                        </tr>\n' +
                '                        <tr>\n' +
                '                            <td>固体废物综合利用量：</td>\n' +
                '                            <td>\n' +
                '                                <input type="text" name="solidWasteUtilize" value="'+solidWasteUtilize+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                '                            </td>\n' +
                '                            <td>内部综合利用量：</td>\n' +
                '                            <td>\n' +
                '                                <input type="text" name="solidWasteInnerUtilize" value="'+solidWasteInnerUtilize+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                '                            </td>\n' +
                '\n' +
                '                        </tr>\n' +
                '                        <tr>\n' +
                '                            <td>送外部综合利用量：</td>\n' +
                '                            <td>\n' +
                '                                <input type="text" name="solidWasteReceiveUtilize" value="'+solidWasteReceiveUtilize+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                '                            </td>\n' +
                '                            <td>固体废物处理处置量：</td>\n' +
                '                            <td>\n' +
                '                                <input type="text" name="solidWasteDeal" value="'+solidWasteDeal+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                '                            </td>\n' +
                '                        </tr>\n' +
                '                        <tr>\n' +
                '                            <td>固体废物内部处理处置量：</td>\n' +
                '                            <td>\n' +
                '                                <input type="text" name="solidWasteInnerDeal" value="'+solidWasteInnerDeal+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                '                            </td>\n' +
                '                            <td>固体废物送外部处理处置量：</td>\n' +
                '                            <td>\n' +
                '                                <input type="text" name="solidWasteOuterDeal" value="'+solidWasteOuterDeal+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                '                            </td>\n' +
                '                        </tr>\n' +
                '                        <tr>\n' +
                '                            <td>接收外来固体废物处理处置量：</td>\n' +
                '                            <td>\n' +
                '                                <input type="text" name="solidWasteReceiveDeal" value="'+solidWasteReceiveDeal+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                '                            </td>\n' +
                '                            <td>固体废物累计贮存量：</td>\n' +
                '                            <td>\n' +
                '                                <input type="text" name="solidWasteStorage" value="'+solidWasteStorage+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                '                            </td>\n' +
                '                        </tr>\n' +
                '                        <tr>\n' +
                '                            <td>备注：</td>\n' +
                '                            <td colspan="3">\n' +
                '                                <textarea style="resize: none;" name="remarks" placeholder="" class="layui-textarea">'+remarks+'</textarea>\n' +
                '                            </td>\n' +
                '                        </tr>\n' +
                '                    </table>\n' +
                '                </form>\n' +
                '            </div>\n' +
                '        </div>\n' +
                '    </div>' ;
            layui.layer.open({
                type: 1
                ,content: htmlContent
                ,scrollbar: false
                ,area: ['1100px', '550px']
            });

        }
    });

}

/**
 * 液体储罐信息
 * @param mainproducts_pid
 * @param url
 * @param token
 * @param remoteServiceAddress
 */
var setmainproducts=function(mainproducts_pid,url,token,remoteServiceAddress) {
    $.ajax({
        type: 'GET',
        url: url+"/"+mainproducts_pid,
        beforeSend: function (XMLHttpRequest) {
            XMLHttpRequest.setRequestHeader("access_token",token);
        },
        success: function (data) {
            var result=data.organicLiquidStorageLoad;
            var materielName=result.materielName==null?'':result.materielName;
            var materielCode=result.materielCode==null?'':result.materielCode;
            var storageTankTypeStr=result.storageTankTypeStr==null?'':result.storageTankTypeStr;
            var storageTankVolume=result.storageTankVolume==null?'':result.storageTankVolume;
            var annualLoadingCapacity=result.annualLoadingCapacity==null?'':result.annualLoadingCapacity;
            var temperature=result.temperature==null?'':result.temperature;
            var storageTankNumber=result.storageTankNumber==null?'':result.storageTankNumber;
            var treatmentProcess1=result.treatmentProcess1==null?'':result.treatmentProcess1;
            var carTrainLoad=result.carTrainLoad==null?'':result.carTrainLoad;
            var carTrainLoadModeStr=result.carTrainLoadModeStr==null?'':result.carTrainLoadModeStr;
            var shipLoad=result.shipLoad==null?'':result.shipLoad;
            var shipLoadModeStr=result.shipLoadModeStr==null?'':result.shipLoadModeStr;
            var treatmentProcess2=result.treatmentProcess2==null?'':result.treatmentProcess2;
            var output=result.output==null?'':result.output;
            var emissions=result.emissions==null?'':result.emissions;
            var annualTurnover=result.annualTurnover==null?'':result.annualTurnover;

            var htmlContent  =  '<div class="layui-fluid">\n' +
                '      <div class="layui-row layui-col-space15">\n' +
                '        <!--<div class="layui-card-header">响应式组合</div>-->\n' +
                '        <div class="layui-card-body">\n' +
                '          <form class="layui-form" action="" lay-filter="component-form-element">\n' +
                '            <table class="reporttable">\n' +
                '                <tr>\n' +
                '                    <td>物料名称：</td>\n' +
                '                    <td>\n' +
                '                        <input type="text" name="materielName" value="'+materielName+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                '                    </td>\n' +
                '                    <td>物料代码：</td>\n' +
                '                    <td>\n' +
                '                        <input type="text" name="materielCode" value="'+materielCode+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                '                    </td>\n' +
                '                </tr>\n' +
                '                <tr>\n' +
                '                    <td>储罐类型：</td>\n' +
                '                    <td>\n' +
                '                        <input type="text" name="storageTankType" value="'+storageTankTypeStr+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                '                    </td>\n' +
                '                    <td>储罐容积：</td>\n' +
                '                    <td>\n' +
                '                        <input type="text" name="storageTankVolume" value="'+storageTankVolume+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                '                    </td>\n' +
                '                </tr>\n' +
                '                <tr>\n' +
                '                    <td>年装载量：</td>\n' +
                '                    <td>\n' +
                '                        <input type="text" name="annualLoadingCapacity" value="'+annualLoadingCapacity+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                '                    </td>\n' +
                '                    <td>储存温度：</td>\n' +
                '                    <td>\n' +
                '                        <input type="text" name="temperature" value="'+temperature+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                '                    </td>\n' +
                '                </tr>\n' +
                '\n' +
                '                <tr>\n' +
                '                    <td>相同类型、容积、温度的储罐个数：</td>\n' +
                '                    <td>\n' +
                '                        <input type="text" name="storageTankNumber" value="'+storageTankNumber+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                '                    </td>\n' +
                '                    <td>挥发性有机物处理工艺：</td>\n' +
                '                    <td>\n' +
                '                        <input type="text" name="treatmentProcess1" value="'+treatmentProcess1+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                '                    </td>\n' +
                '                </tr>\n' +
                '                <tr>\n' +
                '                    <td>其中：汽车/火车装载量：</td>\n' +
                '                    <td>\n' +
                '                        <input type="text" name="carTrainLoad" value="'+carTrainLoad+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                '                    </td>\n' +
                '                    <td>汽车/火车装载方式：</td>\n' +
                '                    <td>\n' +
                '                        <input type="text" name="carTrainLoadMode" value="'+carTrainLoadModeStr+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                '                    </td>\n' +
                '                </tr>\n' +
                '\n' +
                '                <tr>\n' +
                '                    <td>船舶装载量：</td>\n' +
                '                    <td>\n' +
                '                        <input type="text" name="shipLoad" value="'+shipLoad+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                '                    </td>\n' +
                '                    <td> 船舶装载方式：</td>\n' +
                '                    <td>\n' +
                '                        <input type="text" name="shipLoadMode" value="'+shipLoadModeStr+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                '                    </td>\n' +
                '                </tr>\n' +
                '                <tr>\n' +
                '                    <td> 挥发性有机物处理工艺：</td>\n' +
                '                    <td>\n' +
                '                        <input type="text" name="treatmentProcess2" value="'+treatmentProcess2+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                '                    </td>\n' +
                '                    <td>挥发性有机物产生量：</td>\n' +
                '                    <td>\n' +
                '                        <input type="text" name="output" value="'+output+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                '                    </td>\n' +
                '                </tr>\n' +
                '                <tr>\n' +
                '                    <td>挥发性有机物排放量：</td>\n' +
                '                    <td>\n' +
                '                        <input type="text" name="emissions" value="'+emissions+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                '                    </td>\n' +
                '                    <td>\n' +
                '                        物料年周转量：</td>\n' +
                '                    <td>\n' +
                '                        <input type="text" name="annualTurnover" value="'+annualTurnover+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                '                    </td>\n' +
                '                </tr>\n' +
                '            </table>\n' +
                '          </form>\n' +
                '        </div>\n' +
                '      </div>\n' +
                '    </div>' ;
            layui.layer.open({
                type: 1
                ,content: htmlContent
                ,scrollbar: false
                ,area: ['1100px', '550px']
            });

        }
    });

};

/**
 * 点击移动执法弹窗内容
 * @param mobileenforcementscene_pid
 * @param url
 * @param token
 */
var setMobileEnforcementSceneHtml = function(mobileenforcementscene_pid,url,token){
    $.ajax({
        type: 'GET',
        url: url+"/"+mobileenforcementscene_pid,
        beforeSend: function (XMLHttpRequest) {
            XMLHttpRequest.setRequestHeader("access_token",token);
        },
        success: function (result) {
            var data=result.mobileEnforcementScene;
            var checkCompany=data.checkCompany==null?'':data.checkCompany;
            var checkPersonName=data.checkPersonName==null?'':data.checkPersonName;
            var companyName=data.companyName==null?'':data.companyName;
            var companyAddress=data.companyAddress==null?'':data.companyAddress;
            var companyRepresentative=data.companyRepresentative==null?'':data.companyRepresentative;
            var representativePhone=data.representativePhone==null?'':data.representativePhone;
            var checkStarttime=data.checkStarttime==null?'':data.checkStarttime;
            var checkEndtime=data.checkEndtime==null?'':data.checkEndtime;
            var checkedCompanyLeader=data.checkedCompanyLeader==null?'':data.checkedCompanyLeader;
            var checkedCompanyLeaderPhone=data.checkedCompanyLeaderPhone==null?'':data.checkedCompanyLeaderPhone;
            var recordPersonName=data.recordPersonName==null?'':data.recordPersonName;
            var lawEnforcementTypeName=data.lawEnforcementTypeName==null?'':data.lawEnforcementTypeName;
            var examinationResultsName=data.examinationResultsName==null?'':data.examinationResultsName;
            var resultTypeStr=data.resultTypeStr==null?'':data.resultTypeStr;
            var fieldSituation=data.fieldSituation==null?'':data.fieldSituation;
            var monitoringOpinion=data.monitoringOpinion==null?'':data.monitoringOpinion.replace(/<br\/>/g,"\n");

            var htmlcontent  =  '<div class="layui-fluid">' +
                '<div class="layui-row layui-col-space15">' +
                '<div class="layui-card-body">' +
                '<table class="reporttableshow">' +
                '<tr>' +
                '<td>检查单位：</td>' +
                '<td>' +
                '<input type="text" readonly name="checkCompany" value="'+checkCompany+'" placeholder="" autocomplete="off" class="layui-input">' +
                '</td>' +
                '<td></td>' +
                '<td>' +
                '</td>' +
                '</tr>' +
                '<tr>'+
                '<td>执法人及执法证号：</td>' +
                '<td colspan="3">' +
                '<input type="text" readonly name="checkPersonName" value="'+checkPersonName+'" placeholder="" autocomplete="off" class="layui-input">' +
                '</td>' +
                '</tr>'+
                '<tr>' +
                '<td>被检查单位：</td>' +
                '<td>' +
                '<input type="text" readonly name="companyName" value="'+companyName+'" placeholder="" autocomplete="off" class="layui-input">' +
                '</td>' +
                '<td>被检查单位地址：</td>' +
                '<td>' +
                '<input type="text" readonly name="companyAddress" value="'+companyAddress+'" placeholder="" autocomplete="off" class="layui-input">' +
                '</td>' +
                '</tr>' +
                '<tr>' +
                '<td>被检查单位法人：</td>' +
                '<td>' +
                '<input type="text" readonly name="companyRepresentative" value="'+companyRepresentative+'" placeholder="" autocomplete="off" class="layui-input">' +
                '</td>' +
                '<td>法人联系电话：</td>' +
                '<td>' +
                '<input type="text" readonly name="representativePhone" value="'+representativePhone+'" placeholder="" autocomplete="off" class="layui-input">' +
                '</td>' +
                '</tr>' +
                '<tr>' +
                '<td>检查开始时间：</td>' +
                '<td>' +
                '<input type="text" readonly name="checkStarttime" value="'+checkStarttime+'" placeholder="" autocomplete="off" class="layui-input">' +
                '</td>' +
                '<td>检查结束时间：</td>' +
                '<td>' +
                '<input type="text" readonly name="checkEndtime" value="'+checkEndtime+'" placeholder="" autocomplete="off" class="layui-input">' +
                '</td>' +
                '</tr>' +
                '<tr>' +
                '<td>现场负责人：</td>' +
                '<td>' +
                '<input type="text" readonly name="checkedCompanyLeader" value="'+checkedCompanyLeader+'" placeholder="" autocomplete="off" class="layui-input">' +
                '</td>' +
                '<td>负责人联系电话：</td>' +
                '<td>' +
                '<input type="text" readonly name="checkedCompanyLeaderPhone" value="'+checkedCompanyLeaderPhone+'" placeholder="" autocomplete="off" class="layui-input">' +
                '</td>' +
                '</tr>' +
                '<tr>' +
                '<td>记录人及执法证号：</td>' +
                '<td>' +
                '<input type="text" readonly name="recordPersonName" value="'+recordPersonName +'" placeholder="" autocomplete="off" class="layui-input">' +
                '</td>' +
                '<td>执法类型：</td>' +
                '<td>' +
                '<input type="text" readonly name="lawEnforcementTypeName" value="'+lawEnforcementTypeName+'" placeholder="" autocomplete="off" class="layui-input">' +
                '</td>' +
                '</tr>' +
                '<tr>' +
                '<td>检查结果：</td>' +
                '<td>' +
                '<input type="text" readonly name="examinationResultsName" value="'+examinationResultsName+'" placeholder="" autocomplete="off" class="layui-input">' +
                '</td>' +
                '<td>结果类型：</td>' +
                '<td>' +
                '<input type="text" readonly name="resultTypeStr"   value="'+resultTypeStr+'"  placeholder="" autocomplete="off" class="layui-input">'+
                '</td>' +
                '</tr>' +
                '<tr>' +
                '<td>现场情况：</td>' +
                '<td colspan="3">' +
                '<textarea type="text" readonly name="fieldSituation" placeholder="" autocomplete="off" class="layui-textarea" >' + fieldSituation + '</textarea>' +
                '</td>' +
                '</tr>' +
                '<tr>' +
                '<td>监测意见：</td>' +
                '<td colspan="3">' +
                '<textarea type="text" readonly name="monitoringOpinion" placeholder="" autocomplete="off" class="layui-textarea" >' + monitoringOpinion+'</textarea>' +
                '</td>' +
                '</tr>' +
                '</table>' +
                '</div>' +
                '</div>' +
                '</div>' ;
            layui.layer.open({
                type: 1
                ,content: htmlcontent
                ,scrollbar: false
                ,area: ['1100px', '520px']
            });
        }
        ,error:function () {
        }
    });
};

/**
 * 点击案件记录弹窗内容
 * @param mobileenforcementscene_pid
 * @param url
 * @param token
 */
var setMobileEnforcementAskrecordHtml = function(mobileenforcementscene_pid,url,token){
    $.ajax({
        type: 'GET',
        url: url+"/"+mobileenforcementscene_pid,
        beforeSend: function (XMLHttpRequest) {
            XMLHttpRequest.setRequestHeader("access_token",token);
        },
        success: function (result) {
            var data=result.mobileEnforcementAskrecord;
            var investigateStarttime=data.investigateStarttime==null?'':data.investigateStarttime;
            var investigateEndtime=data.investigateEndtime==null?'':data.investigateEndtime;
            var inquirerPersonName=data.inquirerPersonName==null?'':data.inquirerPersonName;
            var investigateCompany=data.investigateCompany==null?'':data.investigateCompany;
            var inquirerPersonNumber=data.inquirerPersonNumber==null?'':data.inquirerPersonNumber;
            var investigatedCompanyName=data.investigatedCompanyName==null?'':data.investigatedCompanyName;
            var investigatedCompanyCode=data.investigatedCompanyCode==null?'':data.investigatedCompanyCode;
            var investigatedCompanyAddress=data.investigatedCompanyAddress==null?'':data.investigatedCompanyAddress;
            var investigatedCompanyLegal=data.investigatedCompanyLegal==null?'':data.investigatedCompanyLegal;
            var investigatedCompanyLegalPhone=data.investigatedCompanyLegalPhone==null?'':data.investigatedCompanyLegalPhone;
            var investigatedInquirerName=data.investigatedInquirerName==null?'':data.investigatedInquirerName;
            var investigatedInquirerAge=data.investigatedInquirerAge==null?'':data.investigatedInquirerAge;
            var investigatedInquirerIdentity=data.investigatedInquirerIdentity==null?'':data.investigatedInquirerIdentity;
            var investigatedInquirerPhone=data.investigatedInquirerPhone==null?'':data.investigatedInquirerPhone;
            var recordPersonName=data.recordPersonName==null?'':data.recordPersonName;
            var recordPersonNumber=data.recordPersonNumber==null?'':data.recordPersonNumber;
            var investigateInquirerContent=data.investigateInquirerContent==null?'':data.investigateInquirerContent;

            var htmlcontent  =  '<div class="layui-fluid">' +
                '<div class="layui-row layui-col-space15">' +
                '<div class="layui-card-body">' +
                '<table class="reporttableshow">' +
                '<tr>' +
                '<td>调查开始时间：</td>' +
                '<td>' +
                '<input type="text" readonly name="investigateStarttime" value="'+investigateStarttime+'" placeholder="" autocomplete="off" class="layui-input">' +
                '</td>' +
                '<td>调查结束时间：</td>' +
                '<td>' +
                '<input type="text" readonly name="investigateEndtime" value="'+investigateEndtime+'" placeholder="" autocomplete="off" class="layui-input">' +
                '</td>' +
                '</tr>' +
                '<tr>'+
                '<td>询问人：</td>' +
                '<td colspan="3">' +
                '<input type="text" readonly name="inquirerPersonName" value="'+inquirerPersonName+'" placeholder="" autocomplete="off" class="layui-input">' +
                '</td>' +
                '</tr>'+
                '<tr>' +
                '<td>调查单位：</td>' +
                '<td>' +
                '<input type="text" readonly name="investigateCompany" value="'+investigateCompany+'" placeholder="" autocomplete="off" class="layui-input">' +
                '</td>' +
                '<td>询问人执法证号：</td>' +
                '<td>' +
                '<input type="text" readonly name="inquirerPersonNumber" value="'+inquirerPersonNumber+'" placeholder="" autocomplete="off" class="layui-input">' +
                '</td>' +
                '</tr>' +
                '<tr>' +
                '<td>被调查单位：</td>' +
                '<td>' +
                '<input type="text" readonly name="investigatedCompanyName" value="'+investigatedCompanyName+'" placeholder="" autocomplete="off" class="layui-input">' +
                '</td>' +
                '<td>被调查单位编号：</td>' +
                '<td>' +
                '<input type="text" readonly name="investigatedCompanyCode" value="'+investigatedCompanyCode+'" placeholder="" autocomplete="off" class="layui-input">' +
                '</td>' +
                '</tr>' +
                '<tr>' +
                '<td>被调查单位地址：</td>' +
                '<td colspan="3">' +
                '<input type="text" readonly name="investigatedCompanyAddress" value="'+investigatedCompanyAddress+'" placeholder="" autocomplete="off" class="layui-input">' +
                '</td>' +
                '</tr>' +
                '<tr>' +
                '<td>被调查单位法人：</td>' +
                '<td>' +
                '<input type="text" readonly name="investigatedCompanyLegal" value="'+investigatedCompanyLegal+'" placeholder="" autocomplete="off" class="layui-input">' +
                '</td>' +
                '<td>被调查单位联系电话：</td>' +
                '<td>' +
                '<input type="text" readonly name="investigatedCompanyLegalPhone" value="'+investigatedCompanyLegalPhone+'" placeholder="" autocomplete="off" class="layui-input">' +
                '</td>' +
                '</tr>' +
                '<tr>' +
                '<td>被调查询问人姓名：</td>' +
                '<td>' +
                '<input type="text" readonly name="investigatedInquirerName" value="'+investigatedInquirerName +'" placeholder="" autocomplete="off" class="layui-input">' +
                '</td>' +
                '<td>被调查询问人年龄：</td>' +
                '<td>' +
                '<input type="text" readonly name="investigatedInquirerAge" value="'+investigatedInquirerAge+'" placeholder="" autocomplete="off" class="layui-input">' +
                '</td>' +
                '</tr>' +
                '<tr>' +
                '<td>被调查询问人身份证号：</td>' +
                '<td>' +
                '<input type="text" readonly name="investigatedInquirerIdentity" value="'+investigatedInquirerIdentity+'" placeholder="" autocomplete="off" class="layui-input">' +
                '</td>' +
                '<td>被调查询问人联系电话：</td>' +
                '<td>' +
                '<input type="text" readonly name="investigatedInquirerPhone"   value="'+investigatedInquirerPhone+'"  placeholder="" autocomplete="off" class="layui-input">'+
                '</td>' +
                '</tr>' +
                '<tr>' +
                '<td>记录人：</td>' +
                '<td>' +
                '<input type="text" readonly name="recordPersonName" value="'+recordPersonName+'" placeholder="" autocomplete="off" class="layui-input">' +
                '</td>' +
                '<td>记录人执法证号：</td>' +
                '<td>' +
                '<input type="text" readonly name="recordPersonNumber"   value="'+recordPersonNumber+'"  placeholder="" autocomplete="off" class="layui-input">'+
                '</td>' +
                '</tr>' +
                '<tr>' +
                '<td>调查询问内容：</td>' +
                '<td colspan="3">' +
                '<textarea type="text" style="min-height: 150px;" readonly name="investigateInquirerContent" placeholder="" autocomplete="off" class="layui-textarea" >' + investigateInquirerContent+'</textarea>' +
                '</td>' +
                '</tr>' +
                '</table>' +
                '</div>' +
                '</div>' +
                '</div>' ;
            layui.layer.open({
                type: 1
                ,content: htmlcontent
                ,scrollbar: false
                ,area: ['1100px', '520px']
            });
        }
        ,error:function () {
        }
    });
};

/**
 * 点击环境信访弹窗内容
 * @param mobileenforcementscene_pid
 * @param url
 * @param token
 */
var setPetitionSystemComplainHtml = function(petitionSystemComplain_pid,url,token,remoteServiceAddress){
    $.ajax({
        type: 'GET',
        url: url+"/"+petitionSystemComplain_pid,
        beforeSend: function (XMLHttpRequest) {
            XMLHttpRequest.setRequestHeader("access_token",token);
        },
        success: function (result) {
            var data=result.petitionSystemComplain;
            var informTitle=data.informTitle==null?'':data.informTitle;
            var informPerson=data.informPerson==null?'':data.informPerson;
            var informTypeName=data.informTypeName==null?'':data.informTypeName;
            var informDate=data.informDate==null?'':data.informDate;
            var linkPhone=data.linkPhone==null?'':data.linkPhone;
            var linkEmail=data.linkEmail==null?'':data.linkEmail;
            var letterPersonNum=data.letterPersonNum==null?'':data.letterPersonNum;
            var companyName=data.companyName==null?'':data.companyName;
            var companyAddress=data.companyAddress==null?'':data.companyAddress;
            var handleCompany=data.handleCompany==null?'':data.handleCompany;
            var informIsTrueName=data.informIsTrueName==null?'':data.informIsTrueName;
            var informedAddress=data.informedAddress==null?'':data.informedAddress;
            var isReplyName=data.isReplyName==null?'':data.isReplyName;
            var isPenalizeName=data.isPenalizeName==null?'':data.isPenalizeName;
            var replyTypeName=data.replyTypeName==null?'':data.replyTypeName;
            var informContent=data.informContent==null?'':data.informContent;
            var replyContent=data.replyContent==null?'':data.replyContent;
            var replyLawContent=data.replyLawContent==null?'':data.replyLawContent;
            var informOpinion=data.informOpinion==null?'':data.informOpinion;

            var htmlcontent  =  '<div class="layui-fluid">\n' +
                '        <div class="layui-row layui-col-space15">\n' +
                '            <!--<div class="layui-card-header">响应式组合</div>-->\n' +
                '            <div class="layui-card-body">\n' +
                '                <form class="layui-form" id="petitionSystemComplainShow" action="" lay-filter="component-form-element">\n' +
                '                    <table class="reporttable">\n' +
                '                        <tr>\n' +
                '                            <td>举报主题：</td>\n' +
                '                            <td>\n' +
                '                                <input type="text" name="informTitle" readonly value="'+informTitle+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                            </td>\n' +
                '                            <td>举报人：</td>\n' +
                '                            <td>\n' +
                '                                <input type="text" name="informPerson" readonly value="'+informPerson+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                            </td>\n' +
                '                        </tr>\n' +
                '                        <tr>\n' +
                '                            <td>举报方式：</td>\n' +
                '                            <td>\n' +
                '                                <input type="text" name="informTypeName" readonly value="'+informTypeName+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                            </td>\n' +
                '                            <td>举报日期：</td>\n' +
                '                            <td>\n' +
                '                                <input type="text" name="informDate" readonly value="'+informDate+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                            </td>\n' +
                '                        </tr>\n' +
                '                        <tr>\n' +
                '                            <td>联系电话：</td>\n' +
                '                            <td>\n' +
                '                                <input type="text" name="linkPhone" readonly value="'+linkPhone+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                            </td>\n' +
                '                            <td>电子邮箱：</td>\n' +
                '                            <td>\n' +
                '                                <input type="text" name="linkEmail" readonly value="'+linkEmail+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                            </td>\n' +
                '                        </tr>\n' +
                '                        <tr>\n' +
                '                            <td>信访人数：</td>\n' +
                '                            <td>\n' +
                '                                <input type="text" name="letterPersonNum" readonly value="'+letterPersonNum+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                            </td>\n' +
                '                            <td>被举报单位：</td>\n' +
                '                            <td>\n' +
                '                                <input type="text" name="companyName" readonly value="'+companyName+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                            </td>\n' +
                '                        </tr>\n' +
                '                        <tr>\n' +
                '                            <td>处理单位：</td>\n' +
                '                            <td>\n' +
                '                                <input type="text" name="handleCompany" readonly value="'+handleCompany+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                            </td>\n' +
                '                            <td>举报内容是否属实：</td>\n' +
                '                            <td>\n' +
                '                                <input type="text" name="informIsTrueName" readonly value="'+informIsTrueName+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                            </td>\n' +
                '                        </tr>\n' +
                '                        <tr>\n' +
                '                            <td>被举报单位地址：</td>\n' +
                '                            <td colspan="3">\n' +
                '                                <input type="text" name="companyAddress" readonly value="'+companyAddress+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                            </td>\n' +
                '                        </tr>\n' +
                '                        <tr>\n' +
                '                            <td>是否反馈：</td>\n' +
                '                            <td>\n' +
                '                                <input type="text" name="isReplyName" readonly value="'+isReplyName+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                            </td>\n' +
                '                            <td>立案查处否：</td>\n' +
                '                            <td>\n' +
                '                                <input type="text" name="isPenalizeName" readonly value="'+isPenalizeName+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                            </td>\n' +
                '                        </tr>\n' +
                '                        <tr>\n' +
                '                            <td>反馈方式：</td>\n' +
                '                            <td>\n' +
                '                                <input type="text" name="replyTypeName" readonly value="'+replyTypeName+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                            </td>\n' +
                '                            <td></td>\n' +
                '                            <td></td>\n' +
                '                        </tr>\n' +
                '                        <tr>\n' +
                '                            <td>举报内容：</td>\n' +
                '                            <td colspan="3">\n' +
                '                                <textarea style="resize: none;" readonly name="informContent" placeholder="" class="layui-textarea">'+informContent+'</textarea>\n' +
                '                            </td>\n' +
                '                        </tr>\n' +
                '                        <tr>\n' +
                '                            <td>网上回复结果：</td>\n' +
                '                            <td colspan="3">\n' +
                '                                <textarea style="resize: none;" readonly name="replyContent" placeholder="" class="layui-textarea">'+replyContent+'</textarea>\n' +
                '                            </td>\n' +
                '                        </tr>\n' +
                '                        <tr>\n' +
                '                            <td>反馈违法情况：</td>\n' +
                '                            <td colspan="3">\n' +
                '                                <textarea style="resize: none;" readonly name="replyLawContent" placeholder="" class="layui-textarea">'+replyLawContent+'</textarea>\n' +
                '                            </td>\n' +
                '                        </tr>\n' +
                '                        <tr>\n' +
                '                            <td>举报人意见：</td>\n' +
                '                            <td colspan="3">\n' +
                '                                <textarea style="resize: none;" readonly name="informOpinion" placeholder="" class="layui-textarea">'+informOpinion+'</textarea>\n' +
                '                            </td>\n' +
                '                        </tr>\n' +
                '                    </table>\n' +
                '                </form>\n' +
                '            </div>\n' +
                '        </div>\n' +
                '    </div>' ;
            layui.layer.open({
                type: 1
                ,content: htmlcontent
                ,scrollbar: false
                ,area: ['1100px', '500px']
            });
        }
        ,error:function () {
        }
    });
};

/**
 * 点击行政处罚弹窗内容
 * @param administrativepenaltyinfo_pid
 * @param url
 * @param token
 * @param remoteServiceAddress
 */
var setAdministrativepenaltyinfoHtml = function(administrativepenaltyinfo_pid,url,token,remoteServiceAddress){
    $.ajax({
        type: 'GET',
        url: url+"/"+administrativepenaltyinfo_pid,
        beforeSend: function (XMLHttpRequest) {
            XMLHttpRequest.setRequestHeader("access_token",token);
        },
        success: function (result) {
            var data=result.administrativePenaltyInfo;

            var filingTime=data.filingTime==null?'':data.filingTime;
            var punishSubject=data.punishSubject==null?'':data.punishSubject;
            var companyName=data.companyName==null?'':data.companyName;
            var illegalTypeName=data.illegalTypeName==null?'':data.illegalTypeName;
            var closingTime=data.closingTime==null?'':data.closingTime;
            var illegalActivities=data.illegalActivities==null?'':data.illegalActivities;
            var punishmentExecution=data.punishmentExecution==null?'':data.punishmentExecution;
            var caseOverview=data.caseOverview==null?'':data.caseOverview;
            var punishmentBasis=data.punishmentBasis==null?'':data.punishmentBasis;
            var punishmentResult=data.punishmentResult==null?'':data.punishmentResult;
            var reconsideration=data.reconsideration==null?'':data.reconsideration;
            var appealSituation=data.appealSituation==null?'':data.appealSituation;
            var penaltyNumber=data.penaltyNumber==null?'':data.penaltyNumber;
            var business=data.business==null?'':data.business;
            var representative=data.representative==null?'':data.representative;
            var phone=data.phone==null?'':data.phone;
            var postcode=data.postcode==null?'':data.postcode;
            var researcher=data.researcher==null?'':data.researcher;
            var penaltySign=data.penaltySign==null?'':data.penaltySign;

            var htmlcontent='<div class="layui-tab layui-tab-brief " lay-filter="docDemoTabBrief">\n' +
                '        <ul class="layui-tab-title" id="com-info3">\n' +
                '            <li  id ="firstClick3" class="layui-this" value="0">处罚情况</li>\n' +
                '            <li value="1">处罚资料</li>\n' +
                '        </ul>\n' +
                '        <div class="layui-tab-content">\n' +
                '            <div class="layui-tab-item layui-show">\n' +
                '                <div class="layui-fluid">\n' +
                '                    <div class="layui-row layui-col-space15">\n' +
                '                        <div class="layui-card-body">\n' +
                '                            <form class="layui-form" id="administrativePenaltyShow" action="" lay-filter="component-form-element">\n' +
                '                                <input type="hidden" name="pid" value="undefined">\n' +
                '                                <input type="hidden" name="cid" value="undefined">\n' +
                '                                <table class="reporttable">\n' +
                '                                    <tbody>\n' +
                '                                    <tr>\n' +
                '                                        <td>立案时间：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" readonly name="filingTime" value="'+filingTime+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                        <td>处罚主体：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" readonly name="punishSubject" value="'+punishSubject+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>被处罚单位：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" readonly name="companyName" value="'+companyName+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                        <td>违法类型：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" readonly name="illegalTypeName" value="'+illegalTypeName+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>结案时间：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" readonly name="closingTime" value="'+closingTime+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                        <td>处罚编号：</td>\n' +
                '                                        <td>' +
                '                                            <input type="text" readonly name="penaltyNumber" value="'+penaltyNumber+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>营业执照注册号(身份证号)：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" readonly name="business" value="'+business+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                        <td>法定代表人：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" readonly name="representative" value="'+representative+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>联系电话：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" readonly name="phone" value="'+phone+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                        <td>邮政编码：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" readonly name="postcode" value="'+postcode+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>调查人员：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" readonly name="researcher" value="'+researcher+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                        <td>处罚决定文号：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" readonly name="penaltySign" value="'+penaltySign+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>违法行为：</td>\n' +
                '                                        <td colspan="3">\n' +
                '                                            <input type="text" readonly name="illegalActivities" value="'+illegalActivities+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>处罚执行情况：</td>\n' +
                '                                        <td colspan="3">\n' +
                '                                            <textarea type="text" readonly name="punishmentExecution" style="resize: none;" placeholder="" autocomplete="off" class="layui-textarea">'+punishmentExecution+'</textarea>\n'+
                // '                                            <input type="text" readonly name="punishmentExecution" value="'+punishmentExecution+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>案情概述：</td>\n' +
                '                                        <td colspan="3">\n' +
                '                                            <textarea type="text" readonly name="caseOverview" style="resize: none;" placeholder="" autocomplete="off" class="layui-textarea">'+caseOverview+'</textarea>\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>处罚依据：</td>\n' +
                '                                        <td colspan="3">\n' +
                '                                            <textarea type="text" readonly name="punishmentBasis" style="resize: none;" placeholder="" autocomplete="off" class="layui-textarea">'+punishmentBasis+'</textarea>\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>处罚结果：</td>\n' +
                '                                        <td colspan="3">\n' +
                '                                            <textarea type="text" readonly name="punishmentResult" style="resize: none;" placeholder="" autocomplete="off" class="layui-textarea">'+punishmentResult+'</textarea>\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>复议情况：</td>\n' +
                '                                        <td colspan="3">\n' +
                '                                            <textarea type="text" readonly name="reconsideration" style="resize: none;" placeholder="" autocomplete="off" class="layui-textarea">'+reconsideration+'</textarea>\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>申诉情况：</td>\n' +
                '                                        <td colspan="3">\n' +
                '                                            <textarea type="text" readonly name="appealSituation" style="resize: none;" placeholder="" autocomplete="off" class="layui-textarea">'+appealSituation+'</textarea>\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    </tbody>\n' +
                '                                </table>\n' +
                '                            </form>\n' +
                '                        </div>\n' +
                '                    </div>\n' +
                '                </div>\n' +
                '            </div>\n' +
                '            <div class="layui-tab-item">\n' +
                '                <div id="monitorPortinfo3">\n' +
                '                    <table id="LAY-online-onlineMonitorPortinfo3" lay-filter="LAY-online-onlineMonitorPortinfo3"></table>\n' +
                '                </div>\n' +
                '            </div>\n' +
                '        </div>\n' +
                '    </div>';
            layui.layer.open({
                type: 1
                ,content: htmlcontent
                ,scrollbar: false
                ,area: ['1100px', '500px']
                ,success:function () {
                    administrativeShowInfo();
                }
            });

            function administrativeShowInfo() {
                var differType=0;
                $('#com-info3 li').on('click', function(){
                    differType = $(this).attr("value");
                    if(differType==0){
                        for (var attr in data) {
                            $("#administrativePenaltyShow [name=" + attr + "]").val(data[attr]);
                        }
                    }
                    if(differType==1){
                        layui.table.render({//查询列表信息
                            elem: '#LAY-online-onlineMonitorPortinfo3'
                            // ,height: 'full-500'
                            ,cols: [[
                                {field: 'fileName', title: '资料名', minWidth: 100,unresize: true,event:'setFileName',style:'color:blue;cursor:pointer;'}
                                ,{field: 'attachmentSize', title: '大小',minWidth: 100,unresize: true}
                                ,{field: 'createdateStr', title: '上传时间', minWidth:100}
                                ,{field: 'attachmentFormat', title: '格式', minWidth: 100,unresize: true}
                            ]]
                            ,skin: 'line'
                            ,even: true //开启隔行背景
                            ,limit:5
                            ,limits:[5,10,15,20,25,30,35,40,45,50]
                        });

                        $.ajax({//
                            type: 'GET',
                            url: remoteServiceAddress + "/penalty/administrativepenaltyfile/dataByFile/" + data.pid,
                            beforeSend: function (XMLHttpRequest) {
                                XMLHttpRequest.setRequestHeader("access_token",token);
                            }
                            , success: function (result) {
                                if (result.code == 0 && result.fileAttachment.length > 0) {//成功
                                    layui.table.reload("LAY-online-onlineMonitorPortinfo3",{//查询列表信息
                                        data: result.fileAttachment
                                    });
                                }
                            }
                        });

                    }
                });
                $("#firstClick3").trigger('click');

                layui.table.on('tool(LAY-online-onlineMonitorPortinfo3)',function (obj) {
                    var data=obj.data;
                    if (obj.event == 'setFileName') {
                        showFileView(data.attachmentUrl,remoteServiceAddress);
                    }
                });
            }
        }
        ,error:function () {
        }
    });
};
/**
 * 点击排污许可证弹窗内容
 * @param environmenttraffic_pid
 * @param url
 * @param token
 * @param remoteServiceAddress
 */
var setPollutantDischargePermitHtml = function(environmenttraffic_pid,url,token,remoteServiceAddress){

    $.ajax({
        type: 'GET',
        url: url+"/"+environmenttraffic_pid,
        beforeSend: function (XMLHttpRequest) {
            XMLHttpRequest.setRequestHeader("access_token",token);
        },
        success: function (result) {
            var data=result.pollutantDischargePermit;
            var permitCode=data.permitCode==null?'':data.permitCode;
            var permitTypeName=data.permitTypeName==null?'':data.permitTypeName;
            var companyName=data.companyName==null?'':data.companyName;
            var companyAddress=data.companyAddress==null?'':data.companyAddress;
            var industry=data.industry==null?'':data.industry;
            var technologyLeader=data.technologyLeader==null?'':data.technologyLeader;
            var linkphone=data.linkphone==null?'':data.linkphone;
            var issueDate=data.issueDate==null?'':data.issueDate;
            var startDate=data.startDate==null?'':data.startDate;
            var endDate=data.endDate==null?'':data.endDate;
            var issueCompany=data.issueCompany==null?'':data.issueCompany;
            var mainWasteCategoryName=data.mainWasteCategoryName==null?'':data.mainWasteCategoryName;
            var airMainWaste=data.airMainWaste==null?'':data.airMainWaste;
            var airPollutantsRuleName=data.airPollutantsRuleName==null?'':data.airPollutantsRuleName;
            var airPollutantsStandard=data.airPollutantsStandard==null?'':data.airPollutantsStandard;
            var waterMainWaste=data.waterMainWaste==null?'':data.waterMainWaste;
            var waterPollutantsRule=data.waterPollutantsRule==null?'':data.waterPollutantsRule;
            var waterPollutantsStandard=data.waterPollutantsStandard==null?'':data.waterPollutantsStandard;
            var emissionsTrading=data.emissionsTrading==null?'':data.emissionsTrading;
            var originalDocument=data.originalDocument==null?'':data.originalDocument;
            var copyFile=data.copyFile==null?'':data.copyFile;

            var htmlcontent  =  '<div class="layui-tab layui-tab-brief " lay-filter="docDemoTabBrief">\n' +
                // '        <ul class="layui-tab-title" id="build-info">\n' +
                // '            <li  id ="com-info1" class="layui-this" value="0">排污许可证</li>\n' +
                // '            <li value="1">附件</li>\n' +
                // '        </ul>\n' +
                '        <div class="layui-tab-content">\n' +
                '            <div class="layui-tab-item layui-show">\n' +
                '                <div class="layui-fluid">\n' +
                '                    <div class="layui-row layui-col-space15">\n' +
                '                        <div class="layui-card-body">\n' +
                '                            <form class="layui-form" id="Permitedit" action="" lay-filter="component-form-element">\n' +
                '                                <input type="hidden" name="pid" value="undefined">\n' +
                '                                <input type="hidden" name="cid" value="undefined">\n' +
                '                                <table class="reporttableshow">\n' +
                '                                    <tbody>\n' +
                '                                    <tr>\n' +
                '                                        <td>排污许可证编号：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" name="permitCode" readonly value="'+permitCode+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                        <td>证书类型：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" name="permitTypeName" readonly value="'+permitTypeName+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>单位名称：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" name="companyName" readonly value="'+companyName+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                        <td></td>\n' +
                '                                        <td></td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>生产经营场所地址：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" readonly name="companyAddress" value="'+companyAddress+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                        <td>行业类别：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" readonly name="industry" value="'+industry+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>技术负责人：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" name="technologyLeader" readonly value="'+technologyLeader+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                        <td>联系电话：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" name="linkphone" readonly value="'+linkphone+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>发证日期：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" readonly name="issueDate" value="'+issueDate+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                        <td>发证单位：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" readonly name="issueCompany" value="'+issueCompany+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>有效期开始日期：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" name="startDate" readonly value="'+startDate+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                        <td>有效期结束日期：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" readonly name="endDate" value="'+endDate+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>主要污染物类别：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" readonly name="mainWasteCategoryName" value="'+mainWasteCategoryName+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                        <td>大气主要污染物种类：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" readonly name="airMainWaste" value="'+airMainWaste+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>大气污染物排放规律：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" readonly name="airPollutantsRuleName" value="'+airPollutantsRuleName+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                        <td>大气污染物排放执行标准：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" readonly name="airPollutantsStandard" value="'+airPollutantsStandard+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>废水主要污染物种类：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" readonly name="waterMainWaste" value="'+waterMainWaste+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                        <td>废水污染物排放规律：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" readonly name="waterPollutantsRule" value="'+waterPollutantsRule+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>废水污染物排放执行标准：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" readonly name="waterPollutantsStandard" value="'+waterPollutantsStandard+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                        <td>排污权使用和交易信息：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" readonly name="emissionsTrading" value="'+emissionsTrading+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                // '                                    <tr>\n' +
                // '                                        <td>正本：</td>\n' +
                // '                                        <td>\n' +
                // '                                            <a id="zhengben" style="margin-right: 120px;" class="layui-btn layui-btn-primary layui-btn-xs layui-bg-green">查看</a>\n' +
                // '                                        </td>\n' +
                // '                                        <td>副本：</td>\n' +
                // '                                        <td>\n' +
                // '                                            <a id="fuben" style="margin-right: 120px;" class="layui-btn layui-btn-primary layui-btn-xs layui-bg-green">查看</a>\n' +
                // '                                        </td>\n' +
                // '                                    </tr>\n' +
                '                                    </tbody>\n' +
                '                                </table>\n' +
                '                            </form>\n' +
                '                        </div>\n' +
                '                    </div>\n' +
                '                </div>\n' +
                '\n' +
                '            </div>\n' +
                '        </div>\n' +
                '    </div>' ;
            layui.layer.open({
                type: 1
                ,content: htmlcontent
                ,scrollbar: false
                ,area: ['1100px', '420px']
            });
        }
        ,error:function () {
        }
    });
}
/**
 * 点击建设项目弹窗内容
 * @param environmenttraffic_pid
 * @param url
 * @param token
 * @param remoteServiceAddress
 */
var setBuildingProjectApprovalHtml = function(environmenttraffic_pid,url,token,remoteServiceAddress){
    $.ajax({
        type: 'GET',
        url: url+"/"+environmenttraffic_pid,
        beforeSend: function (XMLHttpRequest) {
            XMLHttpRequest.setRequestHeader("access_token",token);
        },
        success: function (result) {
            var data=result.buildingProjectApproval;

            var projectName=data.projectName==null?'':data.projectName;
            var companyName=data.companyName==null?'':data.companyName;
            var projectAddress=data.projectAddress==null?'':data.projectAddress;
            var admissibilityTime=data.admissibilityTime==null?'':data.admissibilityTime;
            var approvalUnitName=data.approvalUnitName==null?'':data.approvalUnitName;
            var batchTime=data.batchTime==null?'':data.batchTime;
            var fileTypeName=data.fileTypeName==null?'':data.fileTypeName;
            var projectNatureName=data.projectNatureName==null?'':data.projectNatureName;
            var eiaUnit=data.eiaUnit==null?'':data.eiaUnit;
            var eiaApprovalAuthority=data.eiaApprovalAuthority==null?'':data.eiaApprovalAuthority;
            var totalInvestment=data.totalInvestment==null?'':data.totalInvestment;
            var environmentalProtectionInvestment=data.environmentalProtectionInvestment==null?'':data.environmentalProtectionInvestment;
            var acceptanceRequestTime=data.acceptanceRequestTime==null?'':data.acceptanceRequestTime;
            var acceptanceBatchTime =data.acceptanceBatchTime==null?'':data.acceptanceBatchTime;
            var linkman=data.linkman==null?'':data.linkman;
            var phone=data.phone==null?'':data.phone;
            var representative=data.representative==null?'':data.representative;
            var legalPersonPhone=data.legalPersonPhone==null?'':data.legalPersonPhone;
            var projectType=data.projectType==null?'':data.projectType;
            var approvalOpinion=data.approvalOpinion==null?'':data.approvalOpinion;
            var approvalNumbe=data.approvalNumbe==null?'':data.approvalNumbe;
            var operator=data.operator==null?'':data.operator;
            var environmentalAssessmentOpinion=data.environmentalAssessmentOpinion==null?'':data.environmentalAssessmentOpinion;
            var acceptanceOpinion=data.acceptanceOpinion==null?'':data.acceptanceOpinion;
            var postAssessment=data.postAssessment==null?'':data.postAssessment;
            var environmentalAssessmentAddopinion=data.environmentalAssessmentAddopinion==null?'':data.environmentalAssessmentAddopinion;
            var constructionContent = data.constructionContent==null?'':data.constructionContent;

            var htmlcontent  =  '<div class="layui-tab layui-tab-brief " lay-filter="docDemoTabBrief">\n' +
                '        <ul class="layui-tab-title" id="build-info">\n' +
                '            <li  id ="com-info1" class="layui-this" value="0">项目情况</li>\n' +
                '            <li value="1">审批资料</li>\n' +
                '        </ul>\n' +
                '        <div class="layui-tab-content">\n' +
                '            <div class="layui-tab-item layui-show">\n' +
                '                <div class="layui-fluid">\n' +
                '                    <div class="layui-row layui-col-space15">\n' +
                '                        <div class="layui-card-body">\n' +
                '                            <form class="layui-form" id="administrativePenaltyedit" action="" lay-filter="component-form-element">\n' +
                '                                <input type="hidden" name="pid" value="undefined">\n' +
                '                                <input type="hidden" name="cid" value="undefined">\n' +
                '                                <table class="reporttable">\n' +
                '                                    <tbody>\n' +
                '                                    <tr>\n' +
                '                                        <td>项目名称：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" name="projectName" readonly value="'+projectName+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                        <td>建设单位：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" name="companyName" readonly value="'+companyName+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>项目地址：</td>\n' +
                '                                        <td colspan="3">\n' +
                '                                            <input type="text" name="projectAddress" readonly value="'+projectAddress+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>审批单位：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" readonly name="approvalUnitName" value="'+approvalUnitName+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                        <td>批复时间：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" readonly name="batchTime" value="'+batchTime+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>项目类别：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" readonly name="projectType" value="'+projectType+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                        <td>受理时间：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" readonly name="admissibilityTime" value="'+admissibilityTime+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>文件类型：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" name="fileTypeName" readonly value="'+fileTypeName+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                        <td>项目性质：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" name="projectNatureName" readonly value="'+projectNatureName+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                            <!--<select id="projectNature" name="projectNature"></select>-->\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>环评单位：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" readonly name="eiaUnit" value="'+eiaUnit+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                        <td>环评审批机关：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" readonly name="eiaApprovalAuthority" value="'+eiaApprovalAuthority+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>项目总投资（万元）：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" name="totalInvestment" readonly value="'+totalInvestment+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                        <td>项目环保投资（万元）：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" readonly name="environmentalProtectionInvestment" value="'+environmentalProtectionInvestment+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>验收申请时间：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" readonly name="acceptanceRequestTime" value="'+acceptanceRequestTime+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                        <td>验收批复时间：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" readonly name="acceptanceBatchTime" value="'+acceptanceBatchTime+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>法人代表：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" readonly name="representative" value="'+representative+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                        <td>法人电话：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" readonly name="legalPersonPhone" value="'+legalPersonPhone+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>联系人：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" readonly name="linkman" value="'+linkman+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                        <td>联系电话：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" readonly name="phone" value="'+phone+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>审批文号：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" readonly name="approvalNumbe" value="'+approvalNumbe+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                        <td>经办人员：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" readonly name="operator" value="'+operator+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>建设内容：</td>\n' +
                '                                        <td colspan="3">\n' +
                '                                            <textarea  readonly style="resize: none;" name="constructionContent"  placeholder="" class="layui-textarea">'+constructionContent+'</textarea>\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>审批意见：</td>\n' +
                '                                        <td colspan="3">\n' +
                '                                            <textarea  readonly style="resize: none;" name="approvalOpinion"  placeholder="" class="layui-textarea">'+approvalOpinion+'</textarea>\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>环评意见：</td>\n' +
                '                                        <td colspan="3">\n' +
                '                                            <textarea  readonly style="resize: none;" name="environmentalAssessmentOpinion"  placeholder="" class="layui-textarea">'+environmentalAssessmentOpinion+'</textarea>\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>验收意见：</td>\n' +
                '                                        <td colspan="3">\n' +
                '                                            <textarea  readonly style="resize: none;" name="acceptanceOpinion"  placeholder="" class="layui-textarea">'+acceptanceOpinion+'</textarea>\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>后评价：</td>\n' +
                '                                        <td colspan="3">\n' +
                '                                            <textarea  readonly style="resize: none;" name="postAssessment"  placeholder="" class="layui-textarea">'+postAssessment+'</textarea>\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>环评补充意见：</td>\n' +
                '                                        <td colspan="3">\n' +
                '                                            <textarea  readonly style="resize: none;" name="environmentalAssessmentAddopinion"  placeholder="" class="layui-textarea">'+environmentalAssessmentAddopinion+'</textarea>\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    </tbody>\n' +
                '                                </table>\n' +
                '                            </form>\n' +
                '                        </div>\n' +
                '                    </div>\n' +
                '                </div>\n' +
                '\n' +
                '            </div>\n' +
                '\n' +
                '            <div class="layui-tab-item">\n' +
                '                <div id="monitorPortinfo0">\n' +
                '                    <table id="LAY-online-onlineMonitorPortinfo0" lay-filter="LAY-online-onlineMonitorPortinfo0"></table>\n' +
                '                </div>\n' +
                '            </div>\n' +
                '        </div>\n' +
                '    </div>' ;
            layui.layer.open({
                type: 1
                ,content: htmlcontent
                ,scrollbar: false
                ,area: ['1100px', '500px']
                ,success:function () {
                    buildShowInfo();
                }
            });

            function buildShowInfo() {
                var differType=0;
                $('#build-info li').on('click', function(){
                    differType = $(this).attr("value");
                    if(differType==0){
                        for (var attr in data) {
                            $("[name=" + attr + "]").val(data[attr]);
                        }
                    }
                    if(differType==1){
                        layui.table.render({//查询列表信息
                            elem: '#LAY-online-onlineMonitorPortinfo0'
                            // ,height: 'full-500'
                            ,cols: [[
                                {field: 'fileName', title: '资料名', minWidth: 100,unresize: true,event:'setFileName',style:'color:blue;cursor:pointer;'}
                                ,{field: 'attachmentSize', title: '大小',minWidth: 100,unresize: true}
                                ,{field: 'createdateStr', title: '上传时间', minWidth:100}
                                ,{field: 'attachmentFormat', title: '格式', minWidth: 100,unresize: true}
                            ]]
                            ,skin: 'line'
                            ,even: true //开启隔行背景
                            ,limit:5
                            ,limits:[5,10,15,20,25,30,35,40,45,50]
                        });

                        $.ajax({//
                            type: 'GET',
                            url: remoteServiceAddress + "/market/buildingprojectattachment/dataByFile/" + data.pid,
                            beforeSend: function (XMLHttpRequest) {
                                XMLHttpRequest.setRequestHeader("access_token",token);
                            }
                            , success: function (result) {
                                if (result.code == 0 && result.fileAttachment.length > 0) {//成功
                                    layui.table.reload("LAY-online-onlineMonitorPortinfo0",{//查询列表信息
                                        data: result.fileAttachment
                                    });
                                }
                            }
                        });
                    }
                });
                $("#com-info1").trigger('click');
                layui.table.on('tool(LAY-online-onlineMonitorPortinfo0)',function (obj) {
                    var data=obj.data;
                    if (obj.event == 'setFileName') {
                        showFileView(data.attachmentUrl,remoteServiceAddress);
                    }
                });
            }
        }
        ,error:function () {
        }
    });
}

/**
 * 危险化学品
 * @param $
 * @param pid
 * @param url
 * @param token
 */
var setHazardousChemical=function($,pid,url,token){
    $.ajax({
        type: 'GET',
        url: url+"/"+pid,
        beforeSend: function (XMLHttpRequest) {
            XMLHttpRequest.setRequestHeader("access_token",token);
        },
        success: function (result) {
            var data=result.emergencySystemDangerous;
            var dangerousName=data.dangerousName==null?'':data.dangerousName;
            var dangerousAnotherName=data.dangerousAnotherName==null?'':data.dangerousAnotherName;
            var casNumber=data.casNumber==null?'':data.casNumber;
            var unNumer=data.unNumer==null?'':data.unNumer;
            var dangerousTypeName=data.dangerousTypeName==null?'':data.dangerousTypeName;
            var amount=data.amount==null?'':data.amount;
            var dangerousAttribute=data.dangerousAttribute==null?'':data.dangerousAttribute;
            var purpose=data.purpose==null?'':data.purpose;
            var restrictedUses=data.restrictedUses==null?'':data.restrictedUses;
            var industryArea=data.industryArea==null?'':data.industryArea;
            var precautionaryNote=data.precautionaryNote==null?'':data.precautionaryNote;
            var emergencyDisposal=data.emergencyDisposal==null?'':data.emergencyDisposal;

            var htmlcontent  =  '<div class="layui-tab layui-tab-brief">\n' +
                '        <div class="layui-tab-content">\n' +
                '            <div class="layui-tab-item layui-show">\n' +
                '                <div class="layui-fluid">\n' +
                '                    <div class="layui-row layui-col-space15">\n' +
                '                        <div class="layui-card-body">\n' +
                '                            <form class="layui-form" id="emergencySystemDangerousShow" action="" lay-filter="component-form-element">\n' +
                '                                <table class="reporttable">\n' +
                '                                    <tbody>\n' +
                '                                    <tr>\n' +
                '                                        <td>品名：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" name="dangerousName" readonly lay-verify="required" value="'+dangerousName+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                        <td>别名：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" name="dangerousAnotherName" readonly value="'+dangerousAnotherName+'" lay-verify="required"  placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>CAS号：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" name="casNumber" lay-verify="required" readonly value="'+casNumber+'"  placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                        <td>UN号：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" name="unNumer" lay-verify="required" readonly value="'+unNumer+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>活动属性：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" name="dangerousTypeName" lay-verify="required" readonly value="'+dangerousTypeName+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                        <td>数量（吨）：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" name="amount" lay-verify="required" readonly value="'+amount+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>化学品属性：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" name="dangerousAttribute" lay-verify="required" readonly value="'+dangerousAttribute+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                        <td>用途：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" name="purpose" lay-verify="required" readonly value="'+purpose+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>限制的用途：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" name="restrictedUses" lay-verify="required" readonly value="'+restrictedUses+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                        <td>应用的行业领域：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" name="industryArea" lay-verify="required" readonly value="'+industryArea+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>防范说明：</td>\n' +
                '                                        <td colspan="3">\n' +
                '                                            <textarea name="precautionaryNote" readonly placeholder="" style="resize: none;" class="layui-textarea">'+precautionaryNote+'</textarea>\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>应急处置：</td>\n' +
                '                                        <td colspan="3">\n' +
                '                                            <textarea name="emergencyDisposal" readonly placeholder="" style="resize: none;" class="layui-textarea">'+emergencyDisposal+'</textarea>\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    </tbody>\n' +
                '                                </table>\n' +
                '                            </form>\n' +
                '                        </div>\n' +
                '                    </div>\n' +
                '                </div>\n' +
                '            </div>\n' +
                '        </div>\n' +
                '    </div>';
            layui.layer.open({
                type: 1
                ,content: htmlcontent
                ,scrollbar: false
                ,area: ['1100px', '500px']
            });

        }
        ,error:function () {
        }
    });
}

/**
 * emergencysupplies
 * 应急物资
 * @param emergencysupplies_pid
 * @param url
 * @param token
 */
var setemergencysupplies = function(emergencysupplies_pid,url,token){
    $.ajax({
        type: 'GET',
        url: url+"/"+emergencysupplies_pid,
        beforeSend: function (XMLHttpRequest) {
            XMLHttpRequest.setRequestHeader("access_token",token);
        },
        success: function (result) {
            var data=result.emergencySystemSupplies;

            var suppliesName=data.suppliesName==null?'':data.suppliesName;
            var suppliesNumber=data.suppliesNumber==null?'':data.suppliesNumber;
            var suppliesUnit=data.suppliesUnit==null?'':data.suppliesUnit;
            var suppliesTypeName=data.suppliesTypeName==null?'':data.suppliesTypeName;
            var storeAddress=data.storeAddress==null?'':data.storeAddress;
            var companyName=data.companyName==null?'':data.companyName;
            var linkmen=data.linkmen==null?'':data.linkmen;
            var linkphone=data.linkphone==null?'':data.linkphone;

            var htmlcontent  =  '<div class="layui-fluid">\n' +
                '      <div class="layui-row layui-col-space15">\n' +
                '        <div class="layui-card-body">\n' +
                '          <form class="layui-form" id="emergencysystemsuppliesshow" action="" lay-filter="component-form-element">\n' +
                '            <table class="reporttable">\n' +
                '              <tr>\n' +
                '                <td>物资名称：</td>\n' +
                '                <td>\n' +
                '                  <input type="text" name="suppliesName" readonly lay-verify="required" value="'+suppliesName+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                </td>\n' +
                '                <td>物资数量：</td>\n' +
                '                <td>\n' +
                '                  <input type="text" name="suppliesNumber" readonly value="'+suppliesNumber+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                </td>\n' +
                '              </tr>\n' +
                '              <tr>\n' +
                '                <td>物资单位：</td>\n' +
                '                <td>\n' +
                '                  <input type="text" name="suppliesUnit" readonly value="'+suppliesUnit+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                </td>\n' +
                '                <td>物资类型：</td>\n' +
                '                <td>\n' +
                '                  <input type="text" name="suppliesTypeName" readonly value="'+suppliesTypeName+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                </td>\n' +
                '              </tr>\n' +
                '              <tr>\n' +
                '                <td>存放单位：</td>\n' +
                '                <td>' +
                '                  <input type="text" name="companyName" readonly value="'+companyName+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                </td>\n' +
                '                <td>存放地址：</td>\n' +
                '                <td>\n' +
                '                  <input type="text" name="storeAddress" readonly value="'+storeAddress+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                </td>\n' +
                '              </tr>\n' +
                '              <tr>\n' +
                '                <td>联系人：</td>\n' +
                '                <td>\n' +
                '                  <input type="text" name="linkmen" readonly value="'+linkmen+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                </td>\n' +
                '                <td>联系人电话：</td>\n' +
                '                <td>\n' +
                '                  <input type="text" name="linkphone" readonly value="'+linkphone+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                </td>\n' +
                '              </tr>\n' +
                '            </table>\n' +
                '          </form>\n' +
                '        </div>\n' +
                '      </div>\n' +
                '    </div>' ;
            layui.layer.open({
                type: 1
                ,content: htmlcontent
                ,scrollbar: false
                ,area: ['1100px', '280px']
            });
        }
        ,error:function () {
        }
    });
}

/**
 * 应急预案
 * contingencyplan
 * @param contingencyplan_pid
 * @param url
 * @param token
 */
var setcontingencyplan = function(contingencyplan_pid,url,token,remoteServiceAddress){
    $.ajax({
        type: 'GET',
        url: url+"/"+contingencyplan_pid,
        beforeSend: function (XMLHttpRequest) {
            XMLHttpRequest.setRequestHeader("access_token",token);
        },
        success: function (result) {
            var data=result.emergencySystemPlan;
            var planTitle=data.planTitle==null?'':data.planTitle;
            var planTypeName=data.planTypeName==null?'':data.planTypeName;
            var companyName=data.companyName==null?'':data.companyName;
            var recordDate=data.recordDate==null?'':data.recordDate;
            var batchCompany=data.batchCompany==null?'':data.batchCompany;
            var batchDate=data.batchDate==null?'':data.batchDate;
            var statusName=data.statusName==null?'':data.statusName;
            var implementationTime=data.implementationTime==null?'':data.implementationTime;
            var recordDepartment=data.recordDepartment==null?'':data.recordDepartment;
            var planEvaluation=data.planEvaluation==null?'':data.planEvaluation;

            var htmlcontent  =  '<div class="layui-tab layui-tab-brief ">\n' +
                '        <ul class="layui-tab-title" id="plan-info">\n' +
                '            <li  id ="firstPlanClick" class="layui-this" value="0">应急预案</li>\n' +
                '            <li value="1">预案文档</li>\n' +
                '        </ul>\n' +
                '        <div class="layui-tab-content">\n' +
                '            <div class="layui-tab-item layui-show">\n' +
                '                <div class="layui-fluid">\n' +
                '                    <div class="layui-row layui-col-space15">\n' +
                '                        <div class="layui-card-body">\n' +
                '                            <form class="layui-form" id="planInfoShow" action="" lay-filter="component-form-element">\n' +
                '                                <table class="reporttable">\n' +
                '                                    <tr>\n' +
                '                                        <td>预案标题：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" name="planTitle" readonly lay-verify="required" value="'+planTitle+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                        <td>预案单位：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" name="companyName" readonly value="'+companyName+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>预案类型：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" name="planTypeName" readonly value="'+planTypeName+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                        <td>备案日期：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" name="recordDate" readonly value="'+recordDate+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>批复单位：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" name="batchCompany" readonly value="'+batchCompany+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                        <td>批复时间：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" name="batchDate" readonly value="'+batchDate+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>状态：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" name="statusName" readonly value="'+statusName+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                        <td>实施时间：</td>\n' +
                '                                        <td>' +
                '                                            <input type="text" name="implementationTime" readonly value="'+implementationTime+'" placeholder="" autocomplete="off" class="layui-input">'+
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>备案部门：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" name="recordDepartment"  value="'+recordDepartment+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                        <td></td>\n' +
                '                                        <td></td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>预案评估：</td>\n' +
                '                                        <td colspan="3">\n' +
                '                                            <textarea style="resize: none;" name="planEvaluation"  placeholder="" class="layui-textarea">'+planEvaluation+'</textarea>\n' +
                '                                        </td>\n' +
                '                                    </tr>'+
                '                                </table>\n' +
                '                            </form>\n' +
                '                        </div>\n' +
                '                    </div>\n' +
                '                </div>\n' +
                '            </div>\n' +
                '            <div class="layui-tab-item">\n' +
                '                <div id="systemPlan">\n' +
                '                    <table id="LAY-emergency-systemPlan" lay-filter="LAY-emergency-systemPlan"></table>\n' +
                '                </div>\n' +
                '            </div>\n' +
                '        </div>\n' +
                '    </div>' ;
            layui.layer.open({
                type: 1
                ,content: htmlcontent
                ,scrollbar: false
                ,area: ['1100px', '450px']
                ,success:function () {
                    planShowInfo();
                }
            });

            function planShowInfo() {
                var differType=0;
                $('#plan-info li').on('click', function(){
                    differType = $(this).attr("value");
                    if(differType==0){
                        for (var attr in data) {
                            $("[name=" + attr + "]").val(data[attr]);
                        }
                    }
                    if(differType==1){
                        layui.table.render({//查询列表信息
                            elem: '#LAY-emergency-systemPlan'
                            // ,height: 'full-500'
                            ,cols: [[
                                {field: 'fileName', title: '资料名', minWidth: 100,unresize: true,event:'setFileName',style:'color:blue;cursor:pointer;'}
                                ,{field: 'attachmentSize', title: '大小',minWidth: 100,unresize: true}
                                ,{field: 'createdateStr', title: '上传时间', minWidth:100}
                                ,{field: 'attachmentFormat', title: '格式', minWidth: 100,unresize: true}
                            ]]
                            ,skin: 'line'
                            ,even: true //开启隔行背景
                            ,limit:5
                            ,limits:[5,10,15,20,25,30,35,40,45,50]
                        });

                        $.ajax({//
                            type: 'GET',
                            url: remoteServiceAddress + "/emergency/emergencysystemplanfile/dataByFile/" + data.pid,
                            beforeSend: function (XMLHttpRequest) {
                                XMLHttpRequest.setRequestHeader("access_token",token);
                            }
                            , success: function (result) {
                                if (result.code == 0 && result.fileAttachment.length > 0) {//成功
                                    layui.table.reload("LAY-emergency-systemPlan",{//查询列表信息
                                        data: result.fileAttachment
                                    });
                                }
                            }
                        });
                    }
                });
                $("#firstPlanClick").trigger('click');
                layui.table.on('tool(LAY-emergency-systemPlan)',function (obj) {
                    var data=obj.data;
                    if (obj.event == 'setFileName') {
                        showFileView(data.attachmentUrl,remoteServiceAddress);
                    }
                });
            }
        }
        ,error:function () {
        }
    });
}

/**
 * emergencydrilling
 * 应急演练
 * @param emergencydrilling_pid
 * @param url
 * @param token
 */
var setemergencydrilling = function(emergencydrilling_pid,url,token,remoteServiceAddress){
    $.ajax({
        type: 'GET',
        url: url+"/"+emergencydrilling_pid,
        beforeSend: function (XMLHttpRequest) {
            XMLHttpRequest.setRequestHeader("access_token",token);
        },
        success: function (result) {
            var data=result.emergencySystemDrill;

            var drillTitle=data.drillTitle==null?'':data.drillTitle;
            var drillPoint=data.drillPoint==null?'':data.drillPoint;
            var companyName=data.companyName==null?'':data.companyName;
            var drillTypeName=data.drillTypeName==null?'':data.drillTypeName;
            var drillSituation=data.drillSituation==null?'':data.drillSituation;
            var drillDate=data.drillDate==null?'':data.drillDate;
            var publishDate=data.publishDate==null?'':data.publishDate;
            var planEvaluation=data.planEvaluation==null?'':data.planEvaluation;

            var htmlcontent  =  '<div class="layui-tab layui-tab-brief ">\n' +
                '        <ul class="layui-tab-title" id="drill-info">\n' +
                '            <li  id ="firstDrillClick" class="layui-this" value="0">应急演练</li>\n' +
                '            <li value="1">演练文档</li>\n' +
                '        </ul>\n' +
                '        <div class="layui-tab-content">\n' +
                '            <div class="layui-tab-item layui-show">\n' +
                '                <div class="layui-fluid">\n' +
                '                    <div class="layui-row layui-col-space15">\n' +
                '                        <div class="layui-card-body">\n' +
                '                            <form class="layui-form" id="drillInfoShow" action="" lay-filter="component-form-element">\n' +
                '                                <table class="reporttable">\n' +
                '                                    <tr>\n' +
                '                                        <td>演练标题：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" name="drillTitle" readonly lay-verify="required" value="'+drillTitle+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                        <td>演练地点：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" name="drillPoint" readonly value="'+drillPoint+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>演练单位：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" name="companyName" readonly value="'+companyName+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                        <td>演练类型：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" name="drillTypeName" readonly value="'+drillTypeName+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>演练日期：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" name="drillDate" readonly value="'+drillDate+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                        <td>发布日期：</td>\n' +
                '                                        <td>\n' +
                '                                            <input type="text" name="publishDate" readonly value="'+publishDate+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>演练情况：</td>\n' +
                '                                        <td colspan="3">\n' +
                '                                            <textarea type="text" readonly name="drillSituation" style="resize: none;" placeholder="" autocomplete="off" class="layui-textarea">'+drillSituation+'</textarea>\n' +
                '                                        </td>\n' +
                '                                    </tr>\n' +
                '                                    <tr>\n' +
                '                                        <td>预案评估：</td>\n' +
                '                                        <td colspan="3">\n' +
                '                                            <textarea type="text" readonly name="planEvaluation" style="resize: none;" placeholder="" autocomplete="off" class="layui-textarea">'+planEvaluation+'</textarea>\n' +
                '                                        </td>\n' +
                '                                    </tr>'+
                '                                </table>\n' +
                '                            </form>\n' +
                '                        </div>\n' +
                '                    </div>\n' +
                '                </div>\n' +
                '            </div>\n' +
                '            <div class="layui-tab-item">\n' +
                '                <div id="systemDrill">\n' +
                '                    <table id="LAY-emergency-systemDrill" lay-filter="LAY-emergency-systemDrill"></table>\n' +
                '                </div>\n' +
                '            </div>\n' +
                '        </div>\n' +
                '    </div>' ;
            layui.layer.open({
                type: 1
                ,content: htmlcontent
                ,scrollbar: false
                ,area: ['1100px', '450px']
                ,success:function () {
                    drillShowInfo();
                }
            });

            function drillShowInfo() {
                var differType=0;
                $('#drill-info li').on('click', function(){
                    differType = $(this).attr("value");
                    if(differType==0){
                        for (var attr in data) {
                            $("[name=" + attr + "]").val(data[attr]);
                        }
                    }
                    if(differType==1){
                        layui.table.render({//查询列表信息
                            elem: '#LAY-emergency-systemDrill'
                            // ,height: 'full-500'
                            ,cols: [[
                                {field: 'fileName', title: '资料名', minWidth: 100,unresize: true,event:'setFileName',style:'color:blue;cursor:pointer;'}
                                ,{field: 'attachmentSize', title: '大小',minWidth: 100,unresize: true}
                                ,{field: 'createdateStr', title: '上传时间', minWidth:100}
                                ,{field: 'attachmentFormat', title: '格式', minWidth: 100,unresize: true}
                            ]]
                            ,skin: 'line'
                            ,even: true //开启隔行背景
                            ,limit:5
                            ,limits:[5,10,15,20,25,30,35,40,45,50]
                        });

                        $.ajax({//
                            type: 'GET',
                            url: remoteServiceAddress + "/emergency/emergencysystemdrillfile/dataByFile/" + data.pid,
                            beforeSend: function (XMLHttpRequest) {
                                XMLHttpRequest.setRequestHeader("access_token",token);
                            }
                            , success: function (result) {
                                if (result.code == 0 && result.fileAttachment.length > 0) {//成功
                                    layui.table.reload("LAY-emergency-systemDrill",{//查询列表信息
                                        data: result.fileAttachment
                                    });
                                }
                            }
                        });
                    }
                });
                $("#firstDrillClick").trigger('click');
                layui.table.on('tool(LAY-emergency-systemDrill)',function (obj) {
                    var data=obj.data;
                    if (obj.event == 'setFileName') {
                        showFileView(data.attachmentUrl,remoteServiceAddress);
                    }
                });
            }
        }
        ,error:function () {
        }
    });
}

/**
 * 应急事件
 * @param emergencyevent_pid
 * @param url
 * @param token
 */
var setemergencyevent = function(emergencyevent_pid,url,token){
    $.ajax({
        type: 'GET',
        url: url+"/"+emergencyevent_pid,
        beforeSend: function (XMLHttpRequest) {
            XMLHttpRequest.setRequestHeader("access_token",token);
        },
        success: function (result) {
            var data=result.emergencySystemEvent;

            var eventTitle=data.eventTitle==null?'':data.eventTitle;
            var companyName=data.companyName==null?'':data.companyName;
            var occurrenceDate=data.occurrenceDate==null?'':data.occurrenceDate;
            var eventLevelName=data.eventLevelName==null?'':data.eventLevelName;
            var propertyLoss=data.propertyLoss==null?'':data.propertyLoss;
            var occurrencePoint=data.occurrencePoint==null?'':data.occurrencePoint;
            var transferMasses=data.transferMasses==null?'':data.transferMasses;
            var disposalStatusName=data.disposalStatusName==null?'':data.disposalStatusName;
            var pollutionrange=data.pollutionrange==null?'':data.pollutionrange;
            var pollutionLevelName=data.pollutionLevelName==null?'':data.pollutionLevelName;
            var pollutant=data.pollutant==null?'':data.pollutant;
            var casualties=data.casualties==null?'':data.casualties;
            var eventSketch=data.eventSketch==null?'':data.eventSketch;

            var htmlcontent  =  '<div class="layui-fluid">\n' +
                '        <div class="layui-row layui-col-space15">\n' +
                '            <div class="layui-card-body">\n' +
                '                <form class="layui-form" id="emergencysystemeventedit" action="" lay-filter="component-form-element">\n' +
                '                    <table class="reporttable">\n' +
                '                        <tr>\n' +
                '                            <td>事件标题：</td>\n' +
                '                            <td>\n' +
                '                                <input type="text" name="eventTitle" readonly lay-verify="required" value="'+eventTitle+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                            </td>\n' +
                '                            <td>单位名称：</td>\n' +
                '                            <td>\n' +
                '                                <input type="text" name="companyName" readonly value="'+companyName+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                            </td>\n' +
                '                        </tr>\n' +
                '                        <tr>\n' +
                '                            <td>发生日期：</td>\n' +
                '                            <td>\n' +
                '                                <input type="text" name="occurrenceDate" readonly value="'+occurrenceDate+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                            </td>\n' +
                '                            <td>事件等级：</td>\n' +
                '                            <td>\n' +
                '                                <input type="text" name="eventLevelName" readonly value="'+eventLevelName+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                            </td>\n' +
                '                        </tr>\n' +
                '                        <tr>\n' +
                '                            <td>财产损失（万元）：</td>\n' +
                '                            <td>\n' +
                '                                <input type="text" name="propertyLoss" readonly value="'+propertyLoss+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                            </td>\n' +
                '                            <td>发生地点：</td>\n' +
                '                            <td>\n' +
                '                                <input type="text" name="occurrencePoint" readonly value="'+occurrencePoint+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                            </td>\n' +
                '                        </tr>\n' +
                '                        <tr>\n' +
                '                            <td>转移群众：</td>\n' +
                '                            <td>\n' +
                '                                <input type="text" name="transferMasses" readonly value="'+transferMasses+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                            </td>\n' +
                '                            <td>处置状态：</td>\n' +
                '                            <td>\n' +
                '                                <input type="text" name="disposalStatusName" readonly value="'+disposalStatusName+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                            </td>\n' +
                '                        </tr>\n' +
                '                        <tr>\n' +
                '                            <td>污染范围：</td>\n' +
                '                            <td>\n' +
                '                                <input type="text" name="pollutionrange" readonly value="'+pollutionrange+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                            </td>\n' +
                '                            <td>污染程度：</td>\n' +
                '                            <td>\n' +
                '                                <input type="text" name="pollutionLevelName" readonly value="'+pollutionLevelName+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                            </td>\n' +
                '                        </tr>\n' +
                '                        <tr>\n' +
                '                            <td>污染物：</td>\n' +
                '                            <td>\n' +
                '                                <input type="text" name="pollutant" value="'+pollutant+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                '                            </td>\n' +
                '                            <td>伤亡人数：</td>\n' +
                '                            <td>\n' +
                '                                <input type="text" name="casualties" value="'+casualties+'" readonly placeholder="" autocomplete="off" class="layui-input">\n' +
                '                            </td>\n' +
                '                        </tr>\n' +
                '                        <tr>\n' +
                '                            <td>事件简述：</td>\n' +
                '                            <td colspan="3">\n' +
                '                                <textarea style="resize: none;" name="eventSketch" readonly placeholder="" class="layui-textarea">'+eventSketch+'</textarea>\n' +
                '                            </td>\n' +
                '                        </tr>\n' +
                '                    </table>\n' +
                '                </form>\n' +
                '            </div>\n' +
                '        </div>\n' +
                '    </div>' ;
            layui.layer.open({
                type: 1
                ,content: htmlcontent
                ,scrollbar: false
                ,area: ['1100px', '400px']
            });
        }
        ,error:function () {
        }
    });
}

/**
 * 应急队伍
 * @param emergencyanks_pid
 * @param url
 * @param token
 */
var setemergencyranks = function(emergencyanks_pid,url,token){
    $.ajax({
        type: 'GET',
        url: url+"/"+emergencyanks_pid,
        beforeSend: function (XMLHttpRequest) {
            XMLHttpRequest.setRequestHeader("access_token",token);
        },
        success: function (result) {
            var data=result.emergencySystemRanks;

            var ranksName=data.ranksName==null?'':data.ranksName;
            var ranksNumber=data.ranksNumber==null?'':data.ranksNumber;
            var companyName=data.companyName==null?'':data.companyName;
            var linkmen=data.linkmen==null?'':data.linkmen;
            var linkphone=data.linkphone==null?'':data.linkphone;
            var ranksSpeciality=data.ranksSpeciality==null?'':data.ranksSpeciality;
            var address=data.address==null?'':data.address;

            var htmlcontent  =  '<div class="layui-fluid">\n' +
                '      <div class="layui-row layui-col-space15">\n' +
                '        <div class="layui-card-body">\n' +
                '          <form class="layui-form" id="emergencysystemranksShow" action="" lay-filter="component-form-element">\n' +
                '            <table class="reporttable">\n' +
                '              <tr>\n' +
                '                <td>队伍名称：</td>\n' +
                '                <td>\n' +
                '                  <input type="text" name="ranksName" readonly lay-verify="required" value="'+ranksName+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                </td>\n' +
                '                <td>队伍人数：</td>\n' +
                '                <td>\n' +
                '                  <input type="text" name="ranksNumber" readonly value="'+ranksNumber+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                </td>\n' +
                '              </tr>\n' +
                '              <tr>\n' +
                '                <td>单位名称：</td>\n' +
                '                <td>\n' +
                '                  <input type="text" name="companyName" readonly lay-verify="required" value="'+companyName+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                </td>\n' +
                '                <td></td>\n' +
                '                <td>\n' +
                '                </td>\n' +
                '              </tr>\n' +
                '              <tr>\n' +
                '                <td>联系人：</td>\n' +
                '                <td>\n' +
                '                  <input type="text" name="linkmen" readonly value="'+linkmen+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                </td>\n' +
                '                <td>联系电话：</td>\n' +
                '                <td>\n' +
                '                  <input type="text" name="linkphone" readonly value="'+linkphone+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                </td>\n' +
                '              </tr>\n' +
                '              <tr>\n' +
                '                <td>队伍特长：</td>\n' +
                '                <td>\n' +
                '                  <input type="text" name="ranksSpeciality" readonly value="'+ranksSpeciality+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                </td>\n' +
                '                <td>地址：</td>\n' +
                '                <td>\n' +
                '                  <input type="text" name="address" readonly value="'+address+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                </td>\n' +
                '              </tr>\n' +
                '            </table>\n' +
                '          </form>\n' +
                '        </div>\n' +
                '      </div>\n' +
                '    </div>' ;
            layui.layer.open({
                type: 1
                ,content: htmlcontent
                ,scrollbar: false
                ,area: ['1100px', '280px']
            });
        }
        ,error:function () {
        }
    });
}

/**
 * 专家信息
 * @param emergencyexpert_pid
 * @param url
 * @param token
 */
var setemergencyexpert = function(emergencyexpert_pid,url,token){
    $.ajax({
        type: 'GET',
        url: url+"/"+emergencyexpert_pid,
        beforeSend: function (XMLHttpRequest) {
            XMLHttpRequest.setRequestHeader("access_token",token);
        },
        success: function (result) {
            var data=result.emergencySystemExpert;

            var expertName=data.expertName==null?'':data.expertName;
            var sexName=data.sexName==null?'':data.sexName;
            var companyName=data.companyName==null?'':data.companyName;
            var birthday=data.birthday==null?'':data.birthday;
            var nativePlace=data.nativePlace==null?'':data.nativePlace;
            var linkphone=data.linkphone==null?'':data.linkphone;
            var field=data.field==null?'':data.field;
            var appointmentStarttime=data.appointmentStarttime==null?'':data.appointmentStarttime;
            var appointmentEndtime=data.appointmentEndtime==null?'':data.appointmentEndtime;

            var htmlcontent  =  '<div class="layui-fluid">\n' +
                '      <div class="layui-row layui-col-space15">\n' +
                '        <div class="layui-card-body">\n' +
                '          <form class="layui-form" id="emergencysystemexpertShow" action="" lay-filter="component-form-element">\n' +
                '            <table class="reporttable">\n' +
                '              <tr>\n' +
                '                <td>姓名：</td>\n' +
                '                <td>\n' +
                '                  <input type="text" name="expertName" readonly lay-verify="required" value="'+expertName+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                </td>\n' +
                '                <td>性别：</td>\n' +
                '                <td>\n' +
                '                  <input type="text" name="sexName" readonly lay-verify="required" value="'+sexName+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                </td>\n' +
                '              </tr>\n' +
                '              <tr>\n' +
                '                <td>工作单位：</td>\n' +
                '                <td>\n' +
                '                  <input type="text" name="companyName" readonly lay-verify="required" value="'+companyName+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                </td>\n' +
                '                <td></td>\n' +
                '                <td>\n' +
                '                </td>\n' +
                '              </tr>\n' +
                '              <tr>\n' +
                '                <td>出生日期：</td>\n' +
                '                <td>\n' +
                '                  <input type="text" name="birthday" readonly value="'+birthday+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                </td>\n' +
                '                <td>籍贯：</td>\n' +
                '                <td>\n' +
                '                  <input type="text" name="nativePlace" readonly value="'+nativePlace+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                </td>\n' +
                '              </tr>\n' +
                '              <tr>\n' +
                '                <td>联系电话：</td>\n' +
                '                <td>\n' +
                '                  <input type="text" name="linkphone" readonly value="'+linkphone+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                </td>\n' +
                '                <td>擅长领域：</td>\n' +
                '                <td>\n' +
                '                  <input type="text" name="field" readonly value="'+field+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                </td>\n' +
                '              </tr>\n' +
                '              <tr>\n' +
                '                <td>聘任开始时间：</td>\n' +
                '                <td>\n' +
                '                  <input type="text" name="appointmentStarttime" readonly value="'+appointmentStarttime+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                </td>\n' +
                '                <td>聘任结束时间：</td>\n' +
                '                <td>\n' +
                '                  <input type="text" name="appointmentEndtime" readonly value="'+appointmentEndtime+'" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                </td>\n' +
                '              </tr>\n' +
                '            </table>\n' +
                '          </form>\n' +
                '        </div>\n' +
                '      </div>\n' +
                '    </div>' ;
            layui.layer.open({
                type: 1
                ,content: htmlcontent
                ,scrollbar: false
                ,area: ['1100px', '280px']
            });
        }
        ,error:function () {
        }
    });
};

var getShowFlag = function(tip,domtexts) {
    var thebigdom = domtexts;
    if(tip == "排放情况"){
        thebigdom = domtexts.toString();
    }
    if(thebigdom.indexOf(tip)!== -1){
        return true;
    }else{
        return false;
    }

}

function setVisibility(title,doms){
    doms.each(function () {
        // debugger
        var sideAnchor = $(this).find('.anchor-2').eq(0).attr('name');
        if(this.innerText == title){
            var tip = title + "（无）" ;
            $("[name='"+sideAnchor+"']").next().text("");
            var label = $("<label>").text(tip);
            $("[name='"+sideAnchor+"']").next().append(label);
            $("[title='part"+sideAnchor+"']").text(tip).addClass("noValue_grey");
            $("[title='part"+sideAnchor+"']").append($("<br>"));
        }
    });
}