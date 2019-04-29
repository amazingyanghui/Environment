var HighChartsUtil = {
    initCompanyLevel : function (data) {
        Highcharts.setOptions({
            colors: ['#058DC7', '#50B432', '#ED561B', '#DDDF00', '#24CBE5', '#64E572', '#FF9655', '#FFF263', '#6AF9C4']
        });
        var chart = Highcharts.chart('container', {
            chart: {
              plotBackgroundColor: null,
              plotBorderWidth: null,
              plotShadow: false,
              marginRight: 180,
              height:200
            },
            credits: {
              enabled: false
            },
            legend: {
              align: 'right',
              symbolHeight: 12,
              symbolWidth: 12,
              symbolRadius: 2,
              verticalAlign: 'middle',
              x: 20,
              y: 0,
              width:180,
              labelFormat: '<span style="{color}">{name} {y}家 {percentage:.1f}%</span>'
            },
            title: {
              floating:true,
              text: null
            },
            tooltip: {
              pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
            },
            plotOptions: {
              pie: {
                  showInLegend:true,
                  allowPointSelect: true,
                  cursor: 'pointer',
                  dataLabels: {
                      enabled: false,
                      format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                      style: {
                          color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                      }
                  },
                  point: {
                      events: {
                          // mouseOver: function(e) {  // 鼠标滑过时动态更新标题
                          //     // 标题更新函数，API 地址：https://api.hcharts.cn/highcharts#Chart.setTitle
                          //     chart.setTitle({
                          //         text: e.target.name+ '\t'+ e.target.y + ' %'
                          //     });
                          // }
                          //,
                          // click: function(e) { // 同样的可以在点击事件里处理
                          //     chart.setTitle({
                          //         text: e.point.name+ '\t'+ e.point.y + ' %'
                          //     });
                          // }
                      }
                  },
              }
            },
            series: [{
              type: 'pie',
              innerSize: '80%',
              name: '企业占比',
              data: data
            }]
            }, function(c) {
            // 环形图圆心
            var centerY = c.series[0].center[1],
              titleHeight = parseInt(c.title.styles.fontSize);
            c.setTitle({
              y:centerY + titleHeight/2
            });
            chart = c;
            });
  }
    // ,title : '江北新区污染排放在线监控'
    ,yTitle : '污染排放量'
    ,differType : 0
    ,list:[]
    ,reqGetMonitorInfo:function ($,remoteServiceAddress, pid ,mid) {
        //排口下拉框
        $.ajax({
            type: 'GET',
            url: remoteServiceAddress+"/online/onlinemonitorportinfo/selectList/"+pid,
            beforeSend: function (XMLHttpRequest) {
                XMLHttpRequest.setRequestHeader("access_token",JSON.parse(localStorage["layuiAdmin"]).access_token);
            },
            success: function (result) {
                $("#searchStatus").html("");
                var searchStatus=$("#searchStatus");
                var data=JSON.parse(result).data;
                for(var i=0;i<data.length;i++){
                    var optionb=$("<option>").val(data[i].id).text(data[i].name);
                    searchStatus.append(optionb);
                }
                $("#searchStatus").change(function () {
                    var status=$("#searchStatus").val();
                    HighChartsUtil.list=[];
                    HighChartsUtil.pointFactor($,remoteServiceAddress,status);
                });
                if(mid){
                    $("#searchStatus").val(mid);
                    $("#searchStatus").trigger("change");
                }

                HighChartsUtil.firstClick($,remoteServiceAddress,pid);
            }
            ,error:function () {
            }
        });
    }
    ,pointFactor: function ($,remoteServiceAddress,mid) {
        //因子
        $.ajax({
            type: 'GET',
            url: remoteServiceAddress+"/online/onlinemonitorpointfactor/dataByMid/"+mid,
            beforeSend: function (XMLHttpRequest) {
                XMLHttpRequest.setRequestHeader("access_token",JSON.parse(localStorage["layuiAdmin"]).access_token);
            },
            success: function (result) {
                $("#pointFactor").html("");
                var pointFactor=$("#pointFactor");
                var factorList=result.factorList;
                var labela=$("<label>").attr("style","margin-left:50px;margin-right:16px;").text("因子：");
                pointFactor.append(labela);
                for(var i=0;i<factorList.length;i++){
                    var input=$("<input>").attr("value",factorList[i].fid).attr("type","checkbox").attr("id","checkbox-"+i).attr("style","display: none;");
                    // var input=$("<input>").attr("value",factorList[i].fid).attr("type","checkbox").attr("id","checkbox-"+i);
                    var labelb=$("<label>").attr("style","margin-left:5px").attr("for","checkbox-"+i);
                    var span=$("<span>").text(factorList[i].factorName).attr("style","margin-left:2px;");
                    pointFactor.append(input);
                    pointFactor.append(labelb);
                    pointFactor.append(span);

                }
                $("#pointFactor [for^='checkbox-']").bind("click",function () {
                    var checkboxFor=$(this).attr("for");
                    var isChecked=$("#pointFactor #"+checkboxFor+":checked").prop("checked");
                    var factor=$("#pointFactor #"+checkboxFor).val();
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
    ,    //删除
    removeByValue: function(arr, val) {
        for(var i=0; i<arr.length; i++) {
            if(arr[i] == val) {
                arr.splice(i, 1);
                break;
            }
        }
    }
    ,comInfoReload : function ($,pid,remoteServiceAddress) {
        var likeColumns=[{"cid":pid},{"dataType":"cou"}];
        var searchStatus=$("#searchStatus").val();
        var startDate=$("#startDate").val();
        var endDate=$("#endDate").val();
        var likeColumnStart={"startDate":startDate};
        var likeColumnEnd={"endDate":endDate};
        likeColumns.push(likeColumnStart);
        likeColumns.push(likeColumnEnd);
        var type= $("#com-info .layui-this").val();
        if(searchStatus.length>0){
            var likeColumn={"mid":searchStatus};
            likeColumns.push(likeColumn);
        }
        var url=remoteServiceAddress+"/online/onlinemonitorhourdata/testData";
        if(type==1){
            url=remoteServiceAddress+"/online/onlinemonitordaydata/testData";
        }
        HighChartsUtil.highChart($,url,likeColumns,startDate);
    }
    ,firstClick:function($,remoteServiceAddress,pid) {
        $('#com-info li').bind('click', function(){
            var mid=$("#searchStatus").val();
            var likeColumns=[{"cid":pid},{"dataType":"cou"},{"mid":mid}];
            HighChartsUtil.differType = $(this).attr("value");
            var startDate=$("#startDate").val();
            var endDate=$("#endDate").val();
            var likeColumnStart={"startDate":startDate};
            var likeColumnEnd={"endDate":endDate};
            likeColumns.push(likeColumnStart);
            likeColumns.push(likeColumnEnd);
            if(HighChartsUtil.list.length>0){

            }
            var url=remoteServiceAddress+"/online/onlinemonitorhourdata/testData";
            if(HighChartsUtil.differType==1){
                url=remoteServiceAddress+"/online/onlinemonitordaydata/testData";
            }

            HighChartsUtil.highChart($,url,likeColumns,startDate);
        });

        $("#firstClick").trigger('click');
    }
    ,
    highChart: function($,url,likeColumns,startDate) {
//        var categories=[];
        var series=[];
        var names=[];
        //x轴起始时间
        var year=new Date(startDate).getFullYear();
        var month=new Date(startDate).getMonth();
        var day=new Date(startDate).getDate();
        var pointStart=Date.UTC(year, month, day, 0, 0, 0);
        //x轴时间间隔
        var pointInterval=3600000;
        if(HighChartsUtil.differType==1){
            pointInterval=3600000*24;
        }
        $.ajax({
            type: 'POST',
            url: url,
            data:{"likeColumns":likeColumns,"factorList":JSON.stringify(HighChartsUtil.list)},
            beforeSend: function (XMLHttpRequest) {
                XMLHttpRequest.setRequestHeader("access_token",JSON.parse(localStorage["layuiAdmin"]).access_token);
            },
            success: function (result) {
                for(var i=0;i<result.testData.length;i++){
                    var data=result.testData[i];
    //                    categories=result.categories[i];
                    names=result.names[i];
                    var serie={name:names,data:data};
                    series.push(serie);
                }
                HighChartsUtil.drawChartOnline('on-line-monitoring'+HighChartsUtil.differType, pointInterval, pointStart, series);
            }
            ,error:function () {
            }
        });
    }
    ,drawChartOnline:function ($dom, pointInterval, pointStart, series) {
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
          yAxis: {
              title: {
                  text: HighChartsUtil.yTitle
              }
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
};