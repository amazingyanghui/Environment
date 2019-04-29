
var statistics = {
    baseurl: "/market/cominfobaseinfo/"
    ,baseurl2 : "/online/onlinemonitorpointfactor/selFactorByStatisticalType"
    ,baseurl3 : "/online/onlinemonitorpointfactor"
    ,baseurl4 : "/online/onlinemonitorpointfactor/selFactorByPort"
    ,potencyUnit : "" //浓度单位
    ,potencyName : "浓度单位"
    ,emissionUnit : ""  //排放量单位
    ,emission : "排放量单位"
    /**
     * 展示在线监测企业统计图
     * @param pid
     */
    ,admin:{}
    ,setter:{}
    ,pid:{}
    ,init:function (admin,setter,pid) {
        statistics.admin = admin;
        statistics.setter = setter;
        statistics.pid = pid
        statistics.showStatistic()
    }
    ,showStatistic : function () {
        statistics.admin.req({//获取企业详细信息
            url: statistics.setter.remoteServiceAddress +statistics.baseurl+ statistics.pid
            , done: function (result) {
                if(result.code == 0){
                    var data=result.cominfoBaseinfo;
                    statistics.doStatistic(data);

                }
            }
        });
    }
    ,/**
     *  请求返回之后的数据处理
     * */
    doStatistic:function(data) {
        var year_ = '' ;
        var year=[];
        var totalType=[];
        var pid = data.pid ;
        var companyAddress = data.companyAddress ;
        var companyRepresentative = data.companyRepresentative ;
        var environmentalProtectionName = data.environmentalProtectionName ;
        var companyName = data.companyName;
        layer.open({
            type: 1,
            title: "企业在线监测统计",
            area: ['1300px', '750px'],
            content:baseInfor.innerHTML
        });
        var myDate = new Date;
        var year = myDate.getFullYear();
        var html_ ="" ;
        for(var i=year;i>=year-1;i--){
            html_ += '<span title="'+i+'">'+i+'</span>' ;
        }
        $('#year').append(html_);
        $('#aDownLoad').attr("href","../src/views/cominfo/companyshow/slider.html?pid="+pid);
        $('#addressName').text(companyAddress);
        $('#personName').text(companyRepresentative);
        $('#linkman').text(environmentalProtectionName);
        var company_title ="";
        var company_name = "" ;
        company_title = companyName ;
        if(companyName.length>12){
            company_name = companyName.substring(0,12) +"......";
            $('#companyName_').attr("title",company_title);
            $('#companyName_').text(company_name);
        }else{
            $('#companyName_').text(companyName);
        }
        totalType = $("#totalType span").attr("title");
         statistics.getDrainsBaseInfo(pid) ;
        $("#year span").bind("click",function () {
            $("#year span").attr("style","background-color:#CCCCCC");
            $(this).attr("style","background-color:#0099FF");
            year=$(this).attr("title");
            year_ = $(this).text();

        });
        $("#year span:first-child").trigger("click"); //初始点击事件
         //  $("#chartType span:nth-child(2)").trigger("click");
       // var monitorProject=$("#monitorProject [name='monitorProject']:checked").val();

        $("#chartType span").bind("click",function () {
            $("#chartType span").attr("style","border: 1px solid #CCCCCC;color:#CCCCCC;");
            $(this).attr("style","border: 1px solid #0099FF;color:#0099FF;");
            totalType=$(this).attr("title");
            // alert(totalType==);
            if(totalType==1){
                $('#monthTotal').show();
                $('#lbtable').hide();
            }else{
                $('#monthTotal').hide();
                $('#lbtable').show();
            }
        });
        //统计类型点击事件
        $("#totalType span").bind("click",function () {
            $("#totalType span").attr("style","border: 1px solid #CCCCCC;color:#CCCCCC;");
            $(this).attr("style","border: 1px solid #0099FF;color:#0099FF;");
            totalType=$(this).attr("title");
           // totalType=$(this).text();
            //统计类型选中后要联动获取该类型的污染因子
            statistics.getDrains(pid,totalType,year_);
          //
        });

        $("#portType").change(function(){
            var tablename ="" ;
            tablename = $(this).val();
            if(tablename!=="-1"){
                statistics.selFactorbyPort(tablename,year_,totalType,pid);
            }else{
                //重新加载所有类型
                statistics.selTestItems(totalType,year_,pid);
            }

        });


      $("#totalType span:first-child").trigger("click"); //统计类型初始点击
       //$("#monitorProject input:first-child").trigger("click");
       // $("#monitorProject [name='mymonitorProject']:first").click();

        statistics.getDrains(pid,totalType,year_);

        $("#monitorProject [name='mymonitorProject']:first").trigger("click").focus();

    }
    ,//查询企业不同类型排口数量
     getDrainsBaseInfo : function(pid){
         statistics.admin.req({
        url: statistics.setter.remoteServiceAddress +statistics.baseurl3 +"/baseInfoStatic/"+ pid
        , done: function (result) {
            if(result.code == 0){
                var data=result.data;
                if(data!==""&&data.length>0){
                    for(var i=0;i<=2;i++){
                        if(data[i].name=="air"){
                            $("#totalEmphasis").text(data[i].count);
                        } else if(data[i].name=="water"){
                            $("#totalWater").text(data[i].count);
                        }else if(data[i].name=="vocs"){
                            $("#totalVOCs").text(data[i].count);
                        }

                    }

                }

            }
        }
    });
}
    ,
    //根据统计类型联动获取该类型的污染因子
    selTestItems:function (totalType,year_,pid){
        statistics.admin.req({
        url: statistics.setter.remoteServiceAddress +statistics.baseurl2 +"/"+ totalType
        , done: function (result) {
            if(result.code == 0){
                $("#monitorProject").empty();
                var data=result.data;
                var defaultFidCode ="";
                var defaultName = "";
                if(data.length>0){

                    for(var i=0;i<data.length;i++){

                        if(i!==0 && i%5==0){
                            $("#monitorProject").append(
                                '<br/>'
                            );
                            $("#monitorProject").append(
                                '<label><input type="radio" name="mymonitorProject"  value="'+data[i].factorCode +'" style="margin-left: 50px;" ><span  style=" display:inline-block;width: 80px;cursor:pointer">'+data[i].factorName+'</span></label>'
                            );
                        }else{
                            $("#monitorProject").append(
                                '<label><input type="radio" name="mymonitorProject"  value="'+data[i].factorCode +'" style="margin-left: 50px;" ><span  style=" display:inline-block;width: 80px;cursor:pointer">'+data[i].factorName+'</span></label>'
                            );
                        }

                    }
                    defaultFidCode = data[0].factorCode ;
                    defaultName = "  ( "+data[0].factorName+" )" ;
                    $("#factor").text(defaultName);
                    if(data[0].unit!=null){
                        statistics.potencyUnit = statistics.potencyName+"("+data[0].unit+")" ;
                    }
                    if(data[0].emissionUnit!=null){
                        statistics.emissionUnit =statistics.emission +"("+ data[0].emissionUnit+")" ;
                    }else {
                        statistics.emissionUnit =statistics.emission +"( 无 )";
                    }


                }

                $("#bodySize2").height($("#bodySize").height());

                $("#monitorProject label").bind("click",function () {
                    debugger
                   // $(this).prev().attr("checked",true);
                    var  monitorProject=$("#monitorProject [name='monitorProject']:checked").val();
                    var fid =   $("#monitorProject input:radio[name='mymonitorProject']:checked").val();
                    if(fid==undefined){
                        fid = defaultFidCode ;//因子初始默认值
                    }

                    for(var i=0;i<data.length;i++){
                        if(data[i].factorCode==fid){
                            defaultName = " ( "+data[i].factorName+" )";
                            statistics.potencyUnit = statistics.potencyName+"("+data[i].unit+")" ;
                            if(data[i].emissionUnit!=null){
                                statistics.emissionUnit =statistics.emission +"("+ data[i].emissionUnit+")" ;
                            }else {
                                statistics.emissionUnit =statistics.emission +"( 无 )";
                            }
                            break;
                        }
                    }
                    $("#factor").text(defaultName);

                    var tablename =  $("#portType").val();
                    if(tablename=="-1"){ //如果选择全部就是查询某个因子所有的排口
                        //查询全部排口
                        statistics.getMonthAllDrainsFactor(totalType,year_,fid,pid);

                    }else{//如果选择某个排口展示的就是某排口排放的统计数据。
                        if(tablename!=null&&year_!=null&&fid!=null){
                            statistics.getMonthDrainsFactor(tablename,year_,fid);
                        }

                    }
                    //var port_value = $('#portType').val();
                    statistics.queryRanking(pid,year_,totalType,fid) ;

                });
                $("#monitorProject [name='mymonitorProject']:first").trigger("click").focus();


            }
        }
    });
}
    //根据选择的排口查询排口下对应的因子
    ,selFactorbyPort:function (tableName,year_,totalType,pid) {
        statistics.admin.req({
            url: statistics.setter.remoteServiceAddress +statistics.baseurl4 +"/"+ tableName+"/"+ totalType
            , done: function (result) {

                if(result.code == 0){
                    $("#monitorProject").empty();
                    var data=result.data;
                    var defaultPortfactor = "" ;
                    var defaultName = "";
                    if(data.length>0){
                        for(var i=0;i<data.length;i++){
                            if(i!==0 && i%5==0){
                                $("#monitorProject").append(
                                    '<br/>'
                                );
                                $("#monitorProject").append(
                                    '<label><input type="radio" name="mymonitorProject"  value="'+data[i].factorCode +'" style="margin-left: 50px;" ><span  style=" display:inline-block;width: 80px;cursor:pointer">'+data[i].factorName+'</span></label>'
                                );

                            }else{
                                $("#monitorProject").append(
                                    '<label><input type="radio" name="mymonitorProject"  value="'+data[i].factorCode +'" style="margin-left: 50px;" ><span  style=" display:inline-block;width: 80px;cursor:pointer">'+data[i].factorName+'</span></label>'                            );
                            }
                        }

                        defaultPortfactor = data[0].factorCode ;
                        defaultName = "  (  "+data[0].factorName+"   )" ;
                        statistics.potencyUnit = statistics.potencyName+"("+data[0].unit+")" ;
                        if(data[0].emissionUnit!=null){
                            statistics.emissionUnit =statistics.emission +"("+ data[0].emissionUnit+")" ;
                        }else {
                            statistics.emissionUnit =statistics.emission +"( 无 )";
                        }
                        $("#factor").text(defaultName);
                    }

                    $("#bodySize2").height($("#bodySize").height());

                    $("#monitorProject label").bind("click",function () {
                        $(this).prev().attr("checked",true);
                        var  monitorProject=$("#monitorProject [name='monitorProject']:checked").val();
                        //var fid = $("input[name='monitorProject']:checked").val();
                        var fid =   $("#monitorProject input:radio[name='mymonitorProject']:checked").val();
                       if(fid==undefined){
                           fid = defaultPortfactor ;
                       }
                        for(var i=0;i<data.length;i++){
                            if(data[i].factorCode==fid){
                                defaultName = "  (  "+data[i].factorName+" )";
                                statistics.potencyUnit = statistics.potencyName+"("+data[i].unit+")" ;
                                if(data[i].emissionUnit!=null){
                                    statistics.emissionUnit =statistics.emission +"("+ data[i].emissionUnit+")" ;
                                }else {
                                    statistics.emissionUnit =statistics.emission +"( 无 )";
                                }
                                break;
                            }
                        }
                        $("#factor").text(defaultName);
                        var tablename =  $("#portType").val();
                        if(tablename=="-1"){ //如果选择全部就是查询某个因子所有的排口
                            //查询全部排口
                            statistics.getMonthAllDrainsFactor(type,year_,fid,pid);

                        }else{//如果选择某个排口展示的就是某排口排放的统计数据。
                            if(tablename!=null&&year_!=null&&fid!=null){
                                statistics.getMonthDrainsFactor(tablename,year_,fid);
                            }

                        }
                        statistics.queryRanking(pid,year_,totalType,fid) ;
                    });

                    $("#monitorProject [name='mymonitorProject']:first").trigger("click");
                }
            }
        });
    }
    //根据统计类型查询对应排口(下拉框)
    ,getDrains:function(pid,totalType,years){
            statistics.admin.req({
                url: statistics.setter.remoteServiceAddress +statistics.baseurl3 +"/drainsByType/"+ pid+"/"+ totalType
                , done: function (result) {
                    if(result.code == 0){
                        $("#portType").empty();
                        var data=result.data;
                        var html= "<option  name='' value='-1'title=''> 全部</option>"
                        for(var i=0;i<data.length;i++){
                            html+=' <option  name="rid" value="'+data[i].tableName +'" title="">'+data[i].monitorName+'</option>>';
                        }
                        $("#portType").append(html);
                        $("#monitorProject [name='monitorProject']").bind("click",function () {
                            $("#monitorProject input:first-child").attr("checked",true);
                            var  monitorProject=$("#monitorProject [name='monitorProject']:checked").val();
                            var fid = $("input[name='monitorProject']:checked").val();
                            var tablename = $("#portType ").val();
                            if(tablename==-1){
                                tablename="";
                            }
                           // statistics.getMonthDrainsFactor(tablename,years,fid);
                        });
                        /*$("#monitorProject input:first-child").trigger("click");*/
                        statistics.selTestItems(totalType,years,pid);
                    }
                }
            });

}
    //前三个统计图查询接口（单排口情况）
    ,getMonthDrainsFactor:function(tableName,year,fid) {
        if(tableName!==""&&tableName!==null&&year!==""&&year!==null&&fid!==""&&fid!==null){
            statistics.admin.req({
                url: statistics.setter.remoteServiceAddress +statistics.baseurl3 +"/monthDrainsFactor/"+ tableName+"/"+ year+"/"+fid
                , done: function (result) {
                    if(result.code == 0){
                        var datatemp=result.data;
                        statistics.monthTotal(datatemp);
                        statistics.HighchartsToTable(datatemp);
                        $('#lbtable').hide();

                    }
                }
            });
            statistics.admin.req({
                url: statistics.setter.remoteServiceAddress +statistics.baseurl3 +"/yearDrainsFactor/"+ tableName+"/"+ year+"/"+fid
                , done: function (result) {
                    if(result.code == 0){
                        var datatemp=result.data;
                        statistics.compareTotal(datatemp);

                    }
                }
            });
            statistics.admin.req({
                url: statistics.setter.remoteServiceAddress +statistics.baseurl3 +"/monthDrainsFactorPotency/"+ tableName+"/"+ year+"/"+fid
                , done: function (result) {
                    if(result.code == 0){
                        var datatemp=result.data;
                        statistics.potency(datatemp) ;

                    }
                }
            });

        }

    }
    //前三个统计图查询接口（所有排口情况）
    ,getMonthAllDrainsFactor:function (type,year,fid,cid) {
        if(type!==""&&type!==null&&year!==""&&year!==null&&fid!==""&&fid!==null&&fid!==undefined){
            statistics.admin.req({
                url: statistics.setter.remoteServiceAddress +statistics.baseurl3 +"/monthAllDrainsFactor/"+ type+"/"+ year+"/"+fid+"/"+cid
                , done: function (result) {
                    if(result.code == 0){
                        var datatemp=result.data;
                        statistics.monthTotal(datatemp);
                        statistics.HighchartsToTable(datatemp);
                        $('#lbtable').hide();

                    }
                }
            });
            statistics.admin.req({
                url: statistics.setter.remoteServiceAddress +statistics.baseurl3 +"/yearAllDrainsFactor/"+ type+"/"+ year+"/"+fid+"/"+cid
                , done: function (result) {
                    if(result.code == 0){
                        var datatemp=result.data;
                        statistics.compareTotal(datatemp);

                    }
                }
            });
            statistics.admin.req({
                url: statistics.setter.remoteServiceAddress +statistics.baseurl3 +"/monthAllDrainsFactorPotency/"+ type+"/"+ year+"/"+fid+"/"+cid
                , done: function (result) {
                    if(result.code == 0){
                        var datatemp=result.data;
                        statistics.potency(datatemp) ;

                    }
                }
            });

        }
    }

    ,queryRanking:function(cid,year,type,fid){
        if(year!==""&&fid!==undefined){
            statistics.admin.req({
                url: statistics.setter.remoteServiceAddress +statistics.baseurl3 +"/selFactorByStatisticalFactoRanking/"+cid+"/"+year+"/"+type+"/"+fid
                , done: function (result) {
                    if(result.code == 0) {
                        var countarray = [];
                        var namesarray = [];

                        if(result.data.length<5){
                            for(var i=0;i<result.data.length;i++){
                                countarray.push(result.data[i].key);
                                namesarray.push(result.data[i].value);
                            }
                        }else {

                            for(var i=0;i<5;i++){
                                countarray.push(result.data[i].key);
                                namesarray.push(result.data[i].value);
                            }


                        }

                        statistics.discharge(namesarray, countarray);
                    }
                }
            });
        }

    }

    ,queryCurOnlyPort:function(tableName,year,fid,portText){
        statistics.admin.req({
            url: statistics.setter.remoteServiceAddress +statistics.baseurl3 +"/yearDrainsFactor/"+ tableName+"/"+ year+"/"+fid
            , done: function (result) {
                if(result.code == 0){
                    var datatemp=result.data;
                    var couts = [];
                    var names = [];
                    couts.push(datatemp[0].yearVauleCount) ;
                    names.push(portText);
                    statistics.discharge(couts,names);

                }
            }
        });
    }

    ,monthTotal:function(data) {
        var months = ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月'];
        var monthsCount = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
        if(data!==""&&data.length>0){
            for(var i = 0; i < data.length; i++){
                monthsCount[(data[i].month-1)] = data[i].monthVauleCount;
            }
        }
        var chart = Highcharts.chart('monthTotal', {
            credits: {
                enabled: false
            },
            exporting:{
                enabled:false
            },
            title: {
                text: ''
            },
            tooltip: {
                // head + 每个 point + footer 拼接成完整的 table
                headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                    '<td style="padding:0"><b>{point.y:.2f}</b></td></tr>',
                footerFormat: '</table>',
                shared: true,
                useHTML: true
            },
            exporting:{
                enabled:false
            },
            xAxis: {
                categories: months,
                crosshair: true
            },
            yAxis: {
                title: {
                    text: statistics.emissionUnit
                }
            },
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'middle'
            },
            colors: ['#7cb5ec', '#434348', '#90ed7d', '#f7a35c', '#8085e9', '#f15c80', '#e4d354', '#8085e8', '#8d4653', '#91e8e1'],
            series: [{
                name: '排放量',
                data: monthsCount
            }],
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

    ,compareTotal:function(data) {
        var yearNumber = [] ;
        if(data!==""&&data!==undefined&&data.length>0){
            yearNumber.push(data[0].yearVauleCount);
            yearNumber.push(data[1].lastyearVauleCount);
        }else {
            yearNumber.push(0);
            yearNumber.push(0);
        }

        var chart = Highcharts.chart('compareTotal',{
            credits: {
                enabled: false
            },
            legend: {
                enabled: false
            },
            exporting:{
                enabled:false
            },
            chart: {
                type: 'column'
            },
            title: {
                text: '' //本年排放量与去年对比
            },
            xAxis: {
                categories: [
                    '今年','去年'
                ],
                crosshair: true
            },
            yAxis: {
                min: 0,
                title: {
                    text: statistics.emissionUnit
                }
            },
            tooltip: {
                // head + 每个 point + footer 拼接成完整的 table
                headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                    '<td style="padding:0"><b>{point.y:.2f}</b></td></tr>',
                footerFormat: '</table>',
                shared: true,
                useHTML: true
            },
            plotOptions: {
                column: {
                    borderWidth: 0
                }
            },
            colors: ['#7cb5ec', '#434348', '#90ed7d', '#f7a35c', '#8085e9', '#f15c80', '#e4d354', '#8085e8', '#8d4653', '#91e8e1'],
            series: [{
                name: '排放量',
                data: yearNumber
            }]
        });
    }

    ,discharge:function(counts,names) {
        var chart = Highcharts.chart('discharge', {
            credits: {
                enabled: false
            },
            chart: {
                type: 'bar'
            },
            exporting:{
                enabled:false
            },
            title: {
                text: '' //排放量排行榜
            },
            xAxis: {
                categories: names,
                title: {
                    text: null
                },
                labels: {
                    useHTML: true,
                    enabled: true,
                    style :{
                        'display':'inline-block',
                        'max-width':'150px',
                        'overflow':'hidden',
                        'text-overflow':'ellipsis',
                        'white-space':'nowrap',
                        'padding-right':'15px'
                    }
                },
            },
            yAxis: {
                min: 0,
                title: {
                    text: statistics.emissionUnit,
                    align: 'high'
                },
                // labels: {
                //     overflow: 'justify'
                // }
                labels: {
                    useHTML: true,
                    enabled: true,
                    style :{
                        'display':'inline-block',
                        'max-width':'80px',
                        'overflow':'hidden',
                        'text-overflow':'ellipsis',
                        'white-space':'nowrap',
                        'padding-right':'15px'
                    }
                },
            },
            tooltip: {
                valueSuffix: ' '
            },
            plotOptions: {
                bar: {
                    dataLabels: {
                        enabled: true,
                        allowOverlap: true // 允许数据标签重叠
                    }
                }
            },
            legend: {
                enabled: false
            },
            // legend: {
            //     itemHoverStyle : {
            //         color : 'red'
            //     },
            //     layout: 'vertical',
            //     align: 'right',
            //     verticalAlign: 'top',
            //     x: -20,
            //     y: 100,
            //     floating: true,
            //     borderWidth: 1,
            //     backgroundColor: ((Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'),
            //     shadow: true
            // },
            colors: ['#7cb5ec', '#434348', '#90ed7d', '#f7a35c', '#8085e9', '#f15c80', '#e4d354', '#8085e8', '#8d4653', '#91e8e1'],
            series: [{
                name: '排放量',
                data: counts
            }]
        });
    }

    ,potency:function(data){
        var months = ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月'];
        var monthsCount = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];

        if(data!==""&&data.length>0){
            for(var i = 0; i < data.length; i++){
                monthsCount[(data[i].month-1)] = data[i].potencyCount;
            }
        }
        // var chart = Highcharts.chart('potency', {
        //     credits: {
        //         enabled: false
        //     },
        //     chart: {
        //         type: 'line'
        //     },
        //     title: {
        //         text: ''
        //     },
        //     subtitle: {
        //         text: ''
        //     },
        //     xAxis: {
        //         categories: months
        //     },
        //     yAxis: {
        //         title: {
        //             text: ' '
        //         }
        //     },
        //     plotOptions: {
        //         line: {
        //             dataLabels: {
        //                 // 开启数据标签
        //                 enabled: true
        //             },
        //             // 关闭鼠标跟踪，对应的提示框、点击事件会失效
        //             enableMouseTracking: false
        //         }
        //     },
        //     series: [{
        //         name: '平均浓度/值',
        //         data: monthsCount
        //     }]
        // });

        var chart = Highcharts.chart('potency', {
            credits: {
                enabled: false
            },
            title: {
                text: ''
            },
            exporting:{
                enabled:false
            },
            tooltip: {
                // head + 每个 point + footer 拼接成完整的 table
                headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                    '<td style="padding:0"><b>{point.y:.2f}</b></td></tr>',
                footerFormat: '</table>',
                shared: true,
                useHTML: true
            },
            xAxis: {
                categories: months,
                crosshair: true
            },
            yAxis: {
                title: {
                    text:statistics.potencyUnit
                }
            },
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'middle'
            },
            colors: ['#7cb5ec', '#434348', '#90ed7d', '#f7a35c', '#8085e9', '#f15c80', '#e4d354', '#8085e8', '#8d4653', '#91e8e1'],
            series: [{
                name: '平均浓度/值',
                data: monthsCount
            }],
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

    ,HighchartsToTable:function(data) {
    var yearmonthscounts = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
    for(var i = 0; i < data.length; i++){
        yearmonthscounts[(data[i].month-1)] = data[i].monthVauleCount;
    }
    var trStr = '';
    for (var i = 0; i < yearmonthscounts.length; i++) {//循环遍历出json对象中的每一个数据并显示在对应的td中
        trStr += '<tr class="example">';//拼接处规范的表格形式
        trStr += '<td width="30%" style="display:none" id="user">' + (i+1) + '</td>';//数据表的主键值
        trStr += '<td width="30%"  align="center" >' + (i+1) + '月</td>';
        trStr += '<td width="30%" align="center">' + yearmonthscounts[i]+ '</td>';
        trStr += '</tr>';
    }
    $("#tbody").html(trStr);
    $('#lbtable').hide();
}
}

