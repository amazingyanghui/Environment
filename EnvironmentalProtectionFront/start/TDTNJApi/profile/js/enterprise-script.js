var TDTMap = {
    map:{}
    ,vectorlayer:{}
    ,coding : {}
    ,Cfg:{}
    ,select:{}
    ,dragPan : {}
    ,navigation : {}
    ,selectedFeature:{}
    ,markersLayer : {}
    ,geoMarker : null
    ,mousePosition : null
    ,lon_temp : 0
    ,lat_temp : 0
    ,zoom_temp : 0
    ,monitorType : 0
    ,wasteType : 0
    ,map_level:0
    ,iflag : true
    ,maptype : 0
    ,
    init : function(type,admin,setter,$,data) {
        TDTMap.Cfg.host = window.location.host;
        TDTMap.Cfg.projectName = window.location.pathname.split("/")[1];
        var proxyHostUrl = setter.remoteServiceAddress + "/proxy?url=";
        Geo.Request.setProxyHost(proxyHostUrl);
        TDTMap.dragPan = new Geo.View2D.Control.DragPan();
        TDTMap.navigation = new Geo.View2D.Control.Navigation({
            zoomWheelEnabled:true
        })
        TDTMap.map = new Geo.View2D.Map("simpleMap", {
            layerGroupLoaded: true,
            controls:[TDTMap.navigation,TDTMap.dragPan],
            minResolution:5,
            minScale:5,
            eventListeners: {
                "zoomend": function(event){
                    if(type == 0){//0:一张图；（其余：信息维护）
                        TDTMap.mapEvent(event,admin,setter,$)
                    }
                }
                ,"click" : TDTMap.mapClick
            }
        });
        TDTMap.lon_temp = 119.278027;
        TDTMap.lat_temp = 35.096744;
        TDTMap.zoom_temp = 13;
        if(data){
            if(data.longitude){
                TDTMap.lon_temp = data.longitude;
                TDTMap.zoom_temp = 16;
            }
            if(data.latitude){
                TDTMap.lat_temp = data.latitude;
                TDTMap.zoom_temp = 16;
            }
        }
        TDTMap.map.setCenter(new Geo.LonLat(TDTMap.lon_temp , TDTMap.lat_temp),TDTMap.zoom_temp);
        var stylemap = new Geo.StyleMap({
            'default': new Geo.Style({
                pointRadius: 5,
                fillColor: "#ee0000",
                fillOpacity: 0.7,
                strokeColor: "#666666",
                strokeWidth: 1,
                strokeOpacity: 1,
                graphicZIndex: 1
            })
        });
        TDTMap.vectorlayer = new Geo.View2D.Layer.Vector('南京底图', {styleMap: stylemap, strategies: []});
        TDTMap.map.addLayers([TDTMap.vectorlayer]);
        TDTMap.coding = new Geo.Query.GeoCodingQuery("http://services.njmap.gov.cn/NJCoding0314/geocoding", {
            version: "1.1.0"
        });
        TDTMap.createSelectFeature(); //创建选择要素控件
        TDTMap.clearFeatures(true,true);
        //计算位置
        if(data){
            if(data.longitude != 0 && data.latitude != 0){
                var imgPath = "http://" +  TDTMap.Cfg.host  +  "/" + TDTMap.Cfg.projectName + "/start/TDTNJApi/profile/images/marker.png";
                var pointFeature = new Geo.Feature.Vector(new Geo.Geometry.Point(TDTMap.lon_temp,TDTMap.lat_temp), {clazz:"A"}, {
                    externalGraphic:imgPath,
                    graphicWidth:32,
                    graphicHeight:32
                });
                if(data){
                    pointFeature.basedata = data;
                }
                //添加要素到矢量图层
                TDTMap.vectorlayer.addFeatures([pointFeature]);
            }
        }
        TDTMap.select.activate();

        TDTMap.mousePosition = new Geo.View2D.Control.MousePosition({displayClass:"mousePositionCtrl"});
        TDTMap.map.addControl(TDTMap.mousePosition);

        TDTMap.dragPan.activate();

    }
    ,initMapTpl : function(type,admin,setter,$,data,$simpleMap) {
        TDTMap.Cfg.host = window.location.host;
        TDTMap.Cfg.projectName = window.location.pathname.split("/")[1];
        var proxyHostUrl = setter.remoteServiceAddress + "/proxy?url=";
        Geo.Request.setProxyHost(proxyHostUrl);
        TDTMap.map = {};
        TDTMap.dragPan = {};
        TDTMap.navigation = {};
        TDTMap.vectorlayer = {};
        TDTMap.coding = {};
        TDTMap.mousePosition = {};
        TDTMap.dragPan = new Geo.View2D.Control.DragPan();
        TDTMap.navigation = new Geo.View2D.Control.Navigation({
            zoomWheelEnabled:true
        })
        TDTMap.map = new Geo.View2D.Map($simpleMap, {
            layerGroupLoaded: true,
            controls:[TDTMap.navigation,TDTMap.dragPan],
            minResolution:5,
            minScale:5,
            eventListeners: {
                "zoomend": function(event){
                    if(type == 0){//0:一张图；（其余：信息维护）
                        TDTMap.mapEvent(event,admin,setter,$)
                    }
                }
                ,"click" : TDTMap.mapClick
            }
        });
        TDTMap.lon_temp = 119.278027;
        TDTMap.lat_temp = 35.096744;
        TDTMap.zoom_temp = 13;
        if(data){
            if(data.longitude){
                TDTMap.lon_temp = data.longitude;
                TDTMap.zoom_temp = 16;
            }
            if(data.latitude){
                TDTMap.lat_temp = data.latitude;
                TDTMap.zoom_temp = 16;
            }
        }
        TDTMap.map.setCenter(new Geo.LonLat(TDTMap.lon_temp , TDTMap.lat_temp),TDTMap.zoom_temp);
        var stylemap = new Geo.StyleMap({
            'default': new Geo.Style({
                pointRadius: 5,
                fillColor: "#ee0000",
                fillOpacity: 0.7,
                strokeColor: "#666666",
                strokeWidth: 1,
                strokeOpacity: 1,
                graphicZIndex: 1
            })
        });
        TDTMap.vectorlayer = new Geo.View2D.Layer.Vector('南京底图', {styleMap: stylemap, strategies: []});
        TDTMap.map.addLayers([TDTMap.vectorlayer]);
        TDTMap.coding = new Geo.Query.GeoCodingQuery("http://services.njmap.gov.cn/NJCoding0314/geocoding", {
            version: "1.1.0"
        });
        TDTMap.createSelectFeature(); //创建选择要素控件
        TDTMap.clearFeatures(true,true);
        //计算位置
        if(data){
            if(data.longitude != 0 && data.latitude != 0){
                var imgPath = "http://" +  TDTMap.Cfg.host  +  "/" + TDTMap.Cfg.projectName + "/start/TDTNJApi/profile/images/marker.png";
                var pointFeature = new Geo.Feature.Vector(new Geo.Geometry.Point(TDTMap.lon_temp,TDTMap.lat_temp), {clazz:"A"}, {
                    externalGraphic:imgPath,
                    graphicWidth:32,
                    graphicHeight:32
                });
                if(data){
                    pointFeature.basedata = data;
                }
                //添加要素到矢量图层
                TDTMap.vectorlayer.addFeatures([pointFeature]);
            }
        }
        // TDTMap.select.activate();

        TDTMap.mousePosition = new Geo.View2D.Control.MousePosition({displayClass:"mousePositionCtrl"});
        TDTMap.map.addControl(TDTMap.mousePosition);

        // TDTMap.dragPan.activate();

    }
    ,mapEvent:function(event,admin,setter,$){
        if(TDTMap.maptype == 1){
            var zoom = Number(TDTMap.map.getRealZoom());
            var baseurl = setter.remoteServiceAddress + "/map";
            var companyNameOnline = $("#companyNameOnline").val();
            if(TDTMap.iflag){
                if(zoom >= 17 ) {
                    TDTMap.map_level = 1;
                    TDTMap.zoom_temp = (zoom - 1);
                    var lonlat = TDTMap.map.getCenter();
                    TDTMap.lon_temp = lonlat.lon;
                    TDTMap.lat_temp = lonlat.lat;
                    // alert(TDTMap.map.getRealZoom())
                    mapshow.getMonitorLocationForMap(admin, setter, $, baseurl, [], TDTMap.monitorType,1,companyNameOnline)
                    TDTMap.iflag = false;
                }
            }
            if(!TDTMap.iflag) {
                if (zoom == 16 || zoom == 15 || zoom == 14) {
                    TDTMap.map_level = 0
                    TDTMap.zoom_temp = (zoom - 1);
                    var lonlat = TDTMap.map.getCenter();
                    TDTMap.lon_temp = lonlat.lon;
                    TDTMap.lat_temp = lonlat.lat;
                    // alert(TDTMap.map.getRealZoom())
                    var global_obj = {};
                    global_obj.wasteType = TDTMap.wasteType;
                    global_obj.differType = 1;
                    mapshow.getCompanyLocationForMap(admin, setter, $, baseurl, [], null, companyNameOnline, global_obj);
                    TDTMap.iflag = true;
                }
            }
        }
    }
    ,mapClick : function (evt) {
        if(TDTMap.geoMarker){
            if(TDTMap.geoMarker.icon.url.indexOf("坐标动画") === -1){
                TDTMap.markersLayer.removeMarker(TDTMap.geoMarker);
                var mousePosition = TDTMap.mousePosition;
                var xy_temp = mousePosition.element.innerText;
                var x_temp = xy_temp.split(",")[0];
                var y_temp = xy_temp.split(",")[1];
                var size = new Geo.Size(32,32);
                var offset = new Geo.Pixel(-(size.w/2), -(size.h/2));
                var url = "http://" +  TDTMap.Cfg.host  +  "/" + TDTMap.Cfg.projectName + "/start/TDTNJApi/profile/images/marker-blue.png";
                var icon = new Geo.View2D.Icon(url, size, offset);
                TDTMap.geoMarker = new Geo.GeoMarker(new Geo.LonLat(x_temp, y_temp),icon)
                TDTMap.markersLayer.addMarker(TDTMap.geoMarker);

                var checked = $("input[name='radiolocation']:checked")[0];
                if(checked){
                    $(checked).removeAttr("checked")
                }
            }
        }
    }
    ,createSelectFeature: function (admin,setter,$,maptype) {
        //创建选择要素控件
        TDTMap.select = new Geo.View2D.Control.SelectFeature(TDTMap.vectorlayer,{
                //用户选择要素后，执行的回调函数
                onSelect: function(feature) {
                    TDTMap.selectedFeature = feature;
                    if(maptype == 0){
                        TDTMap.popupCompanyLocation(admin,setter,$,feature);
                    }else if(maptype == 1){
                        TDTMap.popupMonitorLocation(admin,setter,$,feature);
                    }else if(maptype == 2){
                        TDTMap.popupRiskSource(admin,setter,$,feature);
                    }else if(maptype == 3){
                        TDTMap.popupDangerousRisk(admin,setter,$,feature);
                    }else if(maptype == 4){
                        TDTMap.popupIsotopeRisk(admin,setter,$,feature);
                    // }else{
                    //     TDTMap.add(feature);
                    }

                    $("#showInfo").on("click",function(){
                        pid = feature.basedata.cid;
                        statistics.init(admin,setter,pid)
                    });
                },
                onUnselect:function(feature) {
                    //取消选择后，要素与浮云框断开关联
                    TDTMap.map.removePopup(feature.popup);
                    feature.popup.destroy();
                    feature.popup = null;
                }
            }
        );
        TDTMap.map.addControl(TDTMap.select);
        //激活选择要素控件
        TDTMap.select.activate();
    }
    ,//根据地址匹配查询参数查询匹配的地址信息
    query : function(pageNum){
        var queryText = document.getElementById("queryText").value;
        if(queryText === ""){
            return;
        };
        TDTMap.vectorlayer.removeFeatures(TDTMap.vectorlayer.features);
        document.getElementById("resultDIV").innerHTML = "";
        var htmlStr = "";
        //根据坐标查询
        TDTMap.coding.addressesToLocations({
            address: queryText,
            semanticAnalysis: true,
            resultType: "hits"
        }, function(GeoCodingResult){
            if (GeoCodingResult.status == "NO_RESULTS" || GeoCodingResult.status == "INVALID_REQUEST" || GeoCodingResult.status == "UNKNOWN_ERROR") {
                htmlStr += "没有查询到任何数据。";
                document.getElementById("resultDIV").innerHTML = htmlStr;
                return;
            };
            var total = GeoCodingResult.results[0].count;
            TDTMap.coding.addressesToLocations({
                address: queryText,
                semanticAnalysis: true,
                customWeight: false,
                resultType: "result",
                maxCount: 3,
                startPosition: (pageNum - 1) * 3 + 1
            }, function(GeoCodingResult){
                TDTMap.querySuccessFn(GeoCodingResult, total, pageNum);
            }, function(){
                alert("查询失败！");
            });
        }, function(){
            alert("查询失败！");
        });
    }
    ,updatePoint: function (longitude,latitude) {
        TDTMap.clearFeatures(true,true);
        if(TDTMap.geoMarker != null){
            TDTMap.markersLayer.removeMarker(TDTMap.geoMarker);
            // TDTMap.map.setCenter(new Geo.LonLat(longitude, latitude));
        }
        if(longitude == 0 ){
            longitude = TDTMap.lon_temp;
        }
        if(latitude == 0 ){
            latitude = TDTMap.lat_temp;
        }
        TDTMap.map.panTo(new Geo.LonLat(longitude, latitude));//移动地图
        TDTMap.markersLayer = new Geo.View2D.Layer.Markers("Markers");
        TDTMap.map.addLayer(TDTMap.markersLayer);
        var size = new Geo.Size(32,32);
        var offset = new Geo.Pixel(-(size.w/2), -(size.h/2));
        var url = "http://" +  TDTMap.Cfg.host  +  "/" + TDTMap.Cfg.projectName + "/start/TDTNJApi/profile/images/marker-blue.png";
        var icon = new Geo.View2D.Icon(url, size, offset);
        TDTMap.geoMarker = new Geo.GeoMarker(new Geo.LonLat(longitude, latitude),icon)
        TDTMap.markersLayer.addMarker(TDTMap.geoMarker);

        if($("#dialog").css("display") != "none"){
            if($("#closeD").css("display") != "none"){
                $("#closeD").trigger("click");
            }
        }
    }
    ,confirmPointMonitor: function (type) {
        var radiolocation = $("input[name='radiolocation']:checked")[0];
        if(radiolocation){
            var radiolocationarr = radiolocation.attributes.lonlat.value.split(",");
            document.getElementById('longitude'+type).value = radiolocationarr[0];
            document.getElementById('latitude'+type).value = radiolocationarr[1];
        }else{
            if(TDTMap.geoMarker != null){
                var x_temp = TDTMap.geoMarker.lonlat.lon;
                var y_temp = TDTMap.geoMarker.lonlat.lat;
                document.getElementById('longitude'+type).value = x_temp;
                document.getElementById('latitude'+type).value = y_temp;
                TDTMap.markersLayer.removeMarker(TDTMap.geoMarker);
                TDTMap.geoMarker = null;
                //计算位置
                var imgPath = "http://" +  TDTMap.Cfg.host  +  "/" + TDTMap.Cfg.projectName + "/start/TDTNJApi/profile/images/marker.png";
                var pointFeature = new Geo.Feature.Vector(new Geo.Geometry.Point(x_temp,y_temp), {clazz:"A"}, {
                    externalGraphic:imgPath,
                    graphicWidth:32,
                    graphicHeight:32
                });

                //添加要素到矢量图层
                TDTMap.vectorlayer.addFeatures([pointFeature]);

                $("#updatePosition"+type).unbind("click");
                $("#updatePosition"+type).bind("click",function () {
                    TDTMap.updatePoint(x_temp,y_temp);
                });
            }
        }
    }
    ,confirmPoint: function () {
        var radiolocation = $("input[name='radiolocation']:checked")[0];
        if(radiolocation){
            var radiolocationarr = radiolocation.attributes.lonlat.value.split(",");
            document.getElementsByName('longitude')[0].value = radiolocationarr[0];
            document.getElementsByName('latitude')[0].value = radiolocationarr[1];
        }else{
            if(TDTMap.geoMarker != null){
                var x_temp = TDTMap.geoMarker.lonlat.lon;
                var y_temp = TDTMap.geoMarker.lonlat.lat;
                document.getElementsByName('longitude')[0].value = x_temp;
                document.getElementsByName('latitude')[0].value = y_temp;
                TDTMap.markersLayer.removeMarker(TDTMap.geoMarker);
                TDTMap.geoMarker = null;
                //计算位置
                var imgPath = "http://" +  TDTMap.Cfg.host  +  "/" + TDTMap.Cfg.projectName + "/start/TDTNJApi/profile/images/marker.png";
                var pointFeature = new Geo.Feature.Vector(new Geo.Geometry.Point(x_temp,y_temp), {clazz:"A"}, {
                    externalGraphic:imgPath,
                    graphicWidth:32,
                    graphicHeight:32
                });

                //添加要素到矢量图层
                TDTMap.vectorlayer.addFeatures([pointFeature]);

                $("#updatePosition").unbind("click");
                $("#updatePosition").bind("click",function () {
                    TDTMap.updatePoint(x_temp,y_temp);
                });
            }
        }
    }
    ,openDialog: function () {
        $("#resultDIV").css({"display":"block"});
        $("#dialog").addClass("dialog");
        $("#dialog").addClass("hadai");
        $("#closeD").css({"display":"block"});
        $("#openD").css({"display":"none"});
    }
    ,closeDialog: function () {
        $("#resultDIV").css({"display":"none"});
        $("#dialog").removeClass("dialog");
        $("#dialog").removeClass("hadai");
        $("#openD").css({"display":"block"});
        $("#closeD").css({"display":"none"});
        var checked = $("input[name='radiolocation']:checked")[0];
        $(checked).removeAttr("checked")
    }
    ,
    //查询成功回调
    querySuccessFn : function(GeoCodingResult, total, pageNum){
        var htmlStr = "",  features = [];
        var resultArr = GeoCodingResult.results[0].result;
        document.getElementById("dialog").style.display = "block";
        for(var i=0; i < resultArr.length; i++){
            var imgPath = "http://" +  TDTMap.Cfg.host  +  "/" + TDTMap.Cfg.projectName + "/start/TDTNJApi/profile/images/" + i + ".png";
            var style = {
                externalGraphic: imgPath,
                graphicWidth: 32,
                graphicHeight: 32,
                graphicXOffset: -15,
                graphicYOffset: -16
            };

            if(resultArr[i]["resultType"]=="poi"){
                var poi = resultArr[i];
                var poi_single = poi["poiArray"][0];
                var name = poi_single["name"];
                var categoryName = poi_single["categoryName"];
                geometryType = poi_single["geometryType"];
                //线、面
                if(geometryType === "GeometryPolyline"){
                    var ljson =poi_single["geometry"];
                    var obj = JSON.parse(ljson);
                    var pArray = [];
                    for(var p=0;p<obj.paths[0].length;p++){
                        pArray.push(new Geo.Geometry.Point(obj.paths[0][p][0],obj.paths[0][p][1]));
                    }
                    var Polyline = new Geo.Geometry.LineString(pArray);
                    var feature = new Geo.Feature.Vector(Polyline);
                    feature.style = {
                        fillOpacity: 0.7,
                        fillColor: "#D9E2EF",
                        strokeColor: "#488DF8",
                        strokeWidth: 10,
                        strokeOpacity: 0.8,
                        graphicZIndex: 1
                    };
                    features.push(feature);
                }else if(geometryType === "GeometryPolygon"){
                    var pArray = [];
                    var gjson =poi_single["geometry"];
                    var obj = JSON.parse(gjson);
                    var pArray = [];
                    for(var p=0;p<obj.rings[0].length;p++){
                        pArray.push(new Geo.Geometry.Point(obj.rings[0][p][0],obj.rings[0][p][1]));
                    }
                    var linearRing = new Geo.Geometry.LinearRing(pArray);
                    var Polygon = new Geo.Geometry.Polygon([linearRing]);
                    var feature = new Geo.Feature.Vector(Polygon);
                    feature.style = {
                        fillOpacity: 0.7,
                        fillColor: "#D9E2EF",
                        strokeColor: "#488DF8",
                        strokeWidth: 1,
                        strokeOpacity: 0.8,
                        graphicZIndex: 1
                    };
                    features.push(feature);
                };
                var lng = poi_single["location"].lng;
                var lat = poi_single["location"].lat;
                var score = poi.score;

                //标注点
                var point = new Geo.Geometry.Point(lng,lat);
                var labFeature = new Geo.Feature.Vector(point);
                labFeature.style = style;
                features.push(labFeature);
                htmlStr += "<input type='radio' style='float:left;cursor:pointer;margin-top:3px;display:block;width:16px;height:16px;' name='radiolocation' lonlat='"+ lng + "," + lat +"' id='radio"+i+"'/> ";
                htmlStr += "<img id='img"+i+"'' src="+imgPath+" style='width:25px;height:25px;'/> ";
                htmlStr += "<span style='cursor:pointer'><b>" + name + "</b><br/>";
                htmlStr += "分类名称：" + categoryName + "<br/>";
                htmlStr += "坐标：" + lng + "," + lat + "<br/>";

                if(score == 100){
                    htmlStr += "匹配度：精确匹配(" + score + "%)<br/></span>";
                }else{
                    htmlStr += "匹配度：模糊匹配(" + score + "%)<br/></span>";
                };
            }//地址处理
            else if(resultArr[i]["resultType"]=="address"){
                var address = TDTMap.getAddress(resultArr[i].addressComponent);
                var location = resultArr[i].location;
                var score = resultArr[i].score;
                var point = new Geo.Geometry.Point(location.lng,location.lat);
                var feature = new Geo.Feature.Vector(point);
                feature.style = style;
                features.push(feature);
                htmlStr += "<img id='img"+i+"'' src="+imgPath+" style='width:25px;height:25px;'/> ";
                htmlStr += "<span><b>" + address + "</b><br/>";
                htmlStr += "坐标：" + location.lng + "," + location.lat + "<br/>";

                if(score == 100){
                    htmlStr += "匹配度：精确匹配(" + score + "%)<br/></span>";
                }else{
                    htmlStr += "匹配度：模糊匹配(" + score + "%)<br/></span>";
                };
            }
        }
        htmlStr += TDTMap.getPageFooterHTML(total, pageNum);
        //将features加入矢量图层
        TDTMap.vectorlayer.addFeatures(features);
        document.getElementById("resultDIV").innerHTML = htmlStr;
        TDTMap.map.zoomToExtent(TDTMap.vectorlayer.getDataExtent());

        var radiolocations = document.getElementsByName('radiolocation');
        for(var i=0;i<radiolocations.length;i++){
            var radiolocation=radiolocations[i];
            radiolocation.onclick = function () {
                if(TDTMap.geoMarker != null){
                    TDTMap.markersLayer.removeMarker(TDTMap.geoMarker);
                }
            }
        }
    }

    ,//获取查询结果下分页的HTML
    getPageFooterHTML : function(total, pageNum){
        var html = "<div style='text-align:center;'>";
        //分页的页数
        var pageNums = parseInt(total / 3) + 1;
        //实际分页的页数可能大于10页，但本示例分页的页数保持在10页之内。
        pageNums = pageNums > 10 ? 10 :pageNums;
        for (var i = 0; i < pageNums; i++) {
            html += "<span style='margin:0 8px 0 8px;cursor:pointer'>";
            if(pageNum == (i + 1)){
                html += (i + 1);
            }else{
                html += "<label style='cursor: pointer;text-decoration:underline;' onclick='TDTMap.query("+(i + 1)+");'>" + (i + 1) + "</label>";
            }
            html += "</span>";
        }
        html += "</div>";
        return html;
    }
    ,
    //地址解析
    getAddress : function(addressComponent){
        var address = "";
        if(addressComponent["country"]){
            address += addressComponent["country"];
        }
        if(addressComponent["province"]){
            address += addressComponent["province"];
        }
        if(addressComponent["city"]){
            address += addressComponent["city"];
        }
        if(addressComponent["district"]){
            address += addressComponent["district"];
        }
        if(addressComponent["street"]){
            if(addressComponent["street"]["name"]){
                address += addressComponent["street"]["name"];
            }
            if(addressComponent["street"]["streetNumber"]){
                address += addressComponent["street"]["streetNumber"]+"号";//门牌号
            }
        }
        return address
    }
    ,//添加浮云框到地图
    add : function(feature) {
        var shadowOptions = {};
        shadowOptions.isShowShadow = false;
        var anchor = null;
        var closeBox = true;
        //依据不同的属性，创建不同的浮云框
        var size = new Geo.Size(160,102);
        var borderStyle = Geo.View2D.Popup.GeoFrameCloud.CORNER;
        var contentDiv  = "<div style='margin-top: 12px;'>" + feature.basedata.companyName + "</div>";
        //设置浮云框为自适应方式，用户能自定义浮云框大小
        Geo.View2D.Popup.GeoFrameCloud.prototype.autoSize = false;
        //创建带有阴影的浮云框对象
        var popup = new Geo.View2D.Popup.GeoFrameCloud("featureInfo",
            //坐标位置
            new Geo.LonLat(feature.geometry.x,feature.geometry.y),
            //浮云框内容大小
            size,
            //浮云框内容
            contentDiv,
            anchor,
            closeBox,
            function(){
                //点击浮云框关闭按钮调用此方法
                TDTMap.select.unselect(TDTMap.selectedFeature);
            },
            shadowOptions,
            borderStyle
        );
        //将要素与浮云框关联
        feature.popup = popup;
        //添加浮云框到地图
        TDTMap.map.addPopup(popup);
    }
    ,//删除点要素
    clearFeatures : function(hasPopup,hasSelect,featureList) {
        if(hasPopup){
            for(var i = 0; i < TDTMap.vectorlayer.features.length; i++) {
                if(TDTMap.vectorlayer.features[i].popup) {
                    TDTMap.vectorlayer.features[i].popup.destroy();
                    TDTMap.vectorlayer.features[i].popup = null;
                }
            }
        }
        TDTMap.vectorlayer.removeAllFeatures();
        if(hasSelect){
            TDTMap.select.deactivate();
            TDTMap.map.removeControl(TDTMap.select)
        }
        if(featureList){
            featureList = [];
            return featureList;
        }
    }
    ,addPointsInMap: function (admin,setter,$,arraydata,featureList,maptype) {
        var imgPath = "http://" +  TDTMap.Cfg.host  +  "/" + TDTMap.Cfg.projectName + "/start/TDTNJApi/profile/images/marker.png";
        if(maptype == 1){
            imgPath = "http://" +  TDTMap.Cfg.host  +  "/" + TDTMap.Cfg.projectName + "/start/TDTNJApi/profile/images/marker-blue.png";
        }else if(maptype == 2){
            imgPath = "http://" +  TDTMap.Cfg.host  +  "/" + TDTMap.Cfg.projectName + "/start/TDTNJApi/profile/images/5.png";
        }else if(maptype == 3){
            imgPath = "http://" +  TDTMap.Cfg.host  +  "/" + TDTMap.Cfg.projectName + "/start/TDTNJApi/profile/images/guibi.png";
        }else if(maptype == 4){
            imgPath = "http://" +  TDTMap.Cfg.host  +  "/" + TDTMap.Cfg.projectName + "/start/TDTNJApi/profile/images/endStation.png";
        }
        featureList = TDTMap.clearFeatures(true,true,featureList);
        for(var i=0; i<arraydata.length; i++ ) {
            var px = arraydata[i].longitude;
            var py = arraydata[i].latitude;
            if(px != 0 && py != 0){
                var newPoint = new Geo.Geometry.Point(px, py);
                var pointFeature = new Geo.Feature.Vector(newPoint, {clazz:"A"}, {
                    externalGraphic:imgPath,
                    graphicWidth:32,
                    graphicHeight:32
                });
                pointFeature.basedata = arraydata[i];
                featureList.push(pointFeature);
            }
        };
        TDTMap.vectorlayer.addFeatures(featureList);
        TDTMap.createSelectFeature(admin,setter,$,maptype); //创建选择要素控件
        TDTMap.map.setCenter(new Geo.LonLat(TDTMap.lon_temp , TDTMap.lat_temp),TDTMap.zoom_temp);
        if(TDTMap.geoMarker != null){
            TDTMap.markersLayer.removeMarker(TDTMap.geoMarker);
        }
    }
    ,//添加浮动框到地图（企业信息）
    popupCompanyLocation : function(admin,setter,$,feature) {
        var shadowOptions = {};
        shadowOptions.isShowShadow = false;
        var anchor = null;
        var closeBox = true;
        //依据不同的属性，创建不同的浮云框
        var size = new Geo.Size(500,230);
        var borderStyle = Geo.View2D.Popup.GeoFrameCloud.CORNER;
        var contentDiv  = "<div class='contentDiv'><div class='suled'>"+feature.basedata.companyName + "</div><br/>"+
            "<table><tr><td class='tdleft'>企业名称：</td><td colspan='3'>"+feature.basedata.companyName +"</td></tr>" +
            "<tr><td class='tdleft'>单位地址：</td><td colspan='3'>"+feature.basedata.companyAddress +"</td></tr>" +
            "<tr><td class='tdleft'>法人代表：</td><td>"+feature.basedata.companyRepresentative +"</td><td class='tdleft'>联系电话：</td><td>"+feature.basedata.representativePhone +"</td></tr>" +
            "<tr><td class='tdleft'>环保联系人：</td><td>"+feature.basedata.environmentalProtectionName +"</td><td class='tdleft'>企业类型：</td><td>"+feature.basedata.pollutionSourceCategoryText +"</td></tr>" +
            "<tr><td class='tdleft'>监控级别：</td><td>"+feature.basedata.regulatoryLevel +"</td><td class='tdleft'>行政区：</td><td>"+feature.basedata.localCity +"</td></tr><table>"+
            "<br/><a href=\'../src/views/cominfo/companyshow/slider.html?pid="+feature.basedata.pid+"\' target=\'_blank\'>查看企业档案>></a></div>";

        //设置浮云框为自适应方式，用户能自定义浮云框大小
        Geo.View2D.Popup.GeoFrameCloud.prototype.autoSize = false;
        //创建带有阴影的浮云框对象
        var popup = new Geo.View2D.Popup.GeoFrameCloud("featureInfo",
            //坐标位置
            new Geo.LonLat(feature.geometry.x,feature.geometry.y),
            //浮云框内容大小
            size,
            //浮云框内容
            contentDiv,
            anchor,
            closeBox,
            function(){
                //点击浮云框关闭按钮调用此方法
                TDTMap.select.unselect(TDTMap.selectedFeature);
            },
            shadowOptions,
            borderStyle
        );
        //将要素与浮云框关联
        feature.popup = popup;
        //添加浮云框到地图
        TDTMap.map.addPopup(popup);
    }
    ,//添加浮动框到地图（在线监测）
    popupMonitorLocation : function(admin,setter,$,feature) {
        var shadowOptions = {};
        shadowOptions.isShowShadow = false;
        var anchor = null;
        var closeBox = true;
        //依据不同的属性，创建不同的浮云框
        var size = new Geo.Size(500,260);
        var borderStyle = Geo.View2D.Popup.GeoFrameCloud.CORNER;
        /*var contentDiv  = "<div class='contentDiv' id='contentDivOnline'><div class='suled'>"+feature.basedata.companyName + "</div>" +
            "<div style='margin-left: 35px;'>" +
            "<div id='tab1' name='contentDivTabOnline' class='contentDivTab'><div style='background-color: #FFF;font-weight: bold;border: 1px solid #ccc'><label>基本信息</label></div></div>" +
            "<div id='tab2' name='contentDivTabOnline' class='contentDivTab'><div style='border: 1px solid #ccc'><label>在线监测</label></div></div></div>"+
            "<div class='divTables'><table id='table1'><tr><td class='tdleft'>企业名称：</td><td>"+feature.basedata.companyName +"</td><td class='tdleft'>排口名称：</td><td>"+feature.basedata.companyName +"</td></tr>" +
            "<tr><td class='tdleft'>单位地址：</td><td colspan='3'>"+feature.basedata.companyAddress +"</td></tr>" +
            "<tr><td class='tdleft'>运维联系人：</td><td>"+feature.basedata.companyRepresentative +"</td><td class='tdleft'>联系电话：</td><td>"+feature.basedata.representativePhone +"</td></tr>" +
            "<tr><td class='tdleft'>环保联系人：</td><td>"+feature.basedata.environmentalProtectionName +"</td><td class='tdleft'>联系电话：</td><td>"+feature.basedata.pollutionSourceCategoryText +"</td></tr>" +
            "<tr><td class='tdleft'>监控级别：</td><td>"+feature.basedata.riskRating +"</td><td class='tdleft'>行政区：</td><td>"+feature.basedata.localCity +"</td></tr></table>"+
            "<table id='table2' style='display: none;'><tr><th class='tdleft1'>序号</th><th class='tdleft2'>风险物质名称</th><th class='tdleft3'>CAS号</th><th class='tdleft4'>数量（吨）</th></tr>" +
            "<tr><td>1</td><td>测试1</td><td>32323</td><td>10</td></tr>" +
            "<tr><td>2</td><td class='tdleft'>测试2</td><td>23223</td><td>13</td></tr>" +
            "<tr><td>3</td><td class='tdleft'>测试3</td><td>434554</td><td>20</td></tr></table>"+
            "</div><a href=\'../src/views/cominfo/companyshow/slider.html?pid="+feature.basedata.pid+"\' target=\'_blank\'>查看企业档案>></a></div>";*/
        var contentDiv  = "<div class='contentDiv' id='contentDivOnline'><div class='suled'>"+feature.basedata.companyName + "</div>" +
            "<div style=''>" +
            "<div id='tab1' pid='"+feature.basedata.pid+"' cid='"+feature.basedata.cid+"' name='contentDivTabOnline' class='contentDivTab'></div>" +
            // "<div id='tab1' pid='"+feature.basedata.pid+"' cid='"+feature.basedata.cid+"' name='contentDivTabOnline' class='contentDivTab'><div style='background-color: #FFF;font-weight: bold;border: 1px solid #ccc'><label>基本信息</label></div></div>" +
            // "<div id='tab2' pid='"+feature.basedata.pid+"' cid='"+feature.basedata.cid+"' name='contentDivTabOnline' class='contentDivTab'><div style='border: 1px solid #ccc'><label>在线监测</label></div></div></div>"+
            "<div class='divPopup' id='divPopup'>"+
             "</div><a id='showInfo' style='cursor: pointer' title="+feature.basedata.cid+">更多</a></div>"  ;

        //设置浮云框为自适应方式，用户能自定义浮云框大小
        Geo.View2D.Popup.GeoFrameCloud.prototype.autoSize = false;

        //创建带有阴影的浮云框对象
        var popup = new Geo.View2D.Popup.GeoFrameCloud("featureInfo",
            //坐标位置
            new Geo.LonLat(feature.geometry.x,feature.geometry.y),
            //浮云框内容大小
            size,
            //浮云框内容
            contentDiv,
            anchor,
            closeBox,
            function(){
                //点击浮云框关闭按钮调用此方法
                TDTMap.select.unselect(TDTMap.selectedFeature);
            },
            shadowOptions,
            borderStyle
        );
        //将要素与浮云框关联
        feature.popup = popup;
        //添加浮云框到地图
        TDTMap.map.addPopup(popup);

        $("[name='contentDivTabOnline']").each(function () {
            $(this).bind("click",function () {
                var pid = $(this).attr("pid");
                var cid = $(this).attr("cid");
                if($(this).attr("id") == "tab1"){
                    admin.req({//获取字典请求
                        url: setter.remoteServiceAddress + "/map/getCompanyInfoByMonitorId/" + pid
                        , done: function (result) {
                            if($("#divOnline")){
                                $("#divOnline").empty();
                                $("#divOnline").remove();
                            }
                            var div = $("<div>").attr("id","divOnline").addClass('divTables');
                            $("#divPopup").append(div);
                            var table = $("<table>");
                            div.append(table);
                            var tr1 = $("<tr>");
                            var td11 = $("<td>").text("企业名称：").addClass('tdleft');
                            var td12 = $("<td>").text(result.onlineMonitorPortinfo.companyName == null?"":result.onlineMonitorPortinfo.companyName);
                            var td13 = $("<td>").text("排口名称：").addClass('tdleft');
                            var td14 = $("<td>").text(result.onlineMonitorPortinfo.monitorName == null?"":result.onlineMonitorPortinfo.monitorName);
                            tr1.append(td11).append(td12).append(td13).append(td14);

                            var tr2 = $("<tr>");
                            var td21 = $("<td>").text("单位地址：").addClass('tdleft');
                            var td22 = $("<td>").attr("colspan",3).text(result.onlineMonitorPortinfo.companyAddress == null?"":result.onlineMonitorPortinfo.companyAddress);
                            tr2.append(td21).append(td22);

                            var tr3 = $("<tr>");
                            var td31 = $("<td>").text("运维联系人：").addClass('tdleft');
                            var td32 = $("<td>").text(result.onlineMonitorPortinfo.linkmen == null?"":result.onlineMonitorPortinfo.linkmen);
                            var td33 = $("<td>").text("联系电话：").addClass('tdleft');
                            var td34 = $("<td>").text(result.onlineMonitorPortinfo.linkphone == null?"":result.onlineMonitorPortinfo.linkphone);
                            tr3.append(td31).append(td32).append(td33).append(td34);

                            var tr4 = $("<tr>");
                            var td41 = $("<td>").text("环保联系人：").addClass('tdleft');
                            var td42 = $("<td>").text(result.onlineMonitorPortinfo.environmentalProtectionName == null?"":result.onlineMonitorPortinfo.environmentalProtectionName);
                            var td43 = $("<td>").text("联系电话：").addClass('tdleft');
                            var td44 = $("<td>").text(result.onlineMonitorPortinfo.environmentalProtectionPhone == null?"":result.onlineMonitorPortinfo.environmentalProtectionPhone);
                            tr4.append(td41).append(td42).append(td43).append(td44);

                            var tr5 = $("<tr>");
                            var td51 = $("<td>").text("监管级别：").addClass('tdleft');
                            var td52 = $("<td>").text(result.onlineMonitorPortinfo.regulatoryLevel == null?"":result.onlineMonitorPortinfo.regulatoryLevel);
                            var td53 = $("<td>").text("行政区：").addClass('tdleft');
                            var td54 = $("<td>").text(result.onlineMonitorPortinfo.localCity == null?"":result.onlineMonitorPortinfo.localCity);
                            tr5.append(td51).append(td52).append(td53).append(td54);
                            table.append(tr1).append(tr2).append(tr3).append(tr4).append(tr5);
                        }
                    });

                }else{
                    if($("#divOnline")){
                        $("#divOnline").empty();
                        $("#divOnline").remove();
                    }
                    var div = $("<div>").attr("id","divOnline").addClass('divOnlineChart');
                    $("#divPopup").append(div);

                    var comtenttemp = '<div>'+
                    '<label style="margin-left: 50px">机组：</label>'+
                    '<select id="searchStatus" class="show-select">'+
                    '    </select>'+
                    '    <label style="margin-left: 20px">开始时间：</label>'+
                    '<input class="show-input" id="startDate">'+
                    '    <label style="margin-left: 20px">结束时间：</label>'+
                    '<input class="show-input" id="endDate">'+
                    '    <button style="margin-left: 20px" class="layui-btn" data-type="comInfoReload" id="comInfoReload">'+
                    '    搜索'+
                    '    </button>'+
                    '    </div>'+
                    '    <div id="pointFactor" style="margin-top: 5px">'+
                    '    </div>'+
                    '    <div class="layui-tab layui-tab-card" style="margin-right: 20px">'+
                    '    <ul class="layui-tab-title" id="com-info">'+
                    '    <li id="firstClick" value="0">时均</li>'+
                    '    <li  value="1">日均</li>'+
                    '    </ul>'+
                    '    <div class="layui-tab-content">'+
                    '    <div class="layui-tab-item layui-show">'+
                    '    <div id="on-line-monitoring0" style="max-width:98%;height:220px"></div>'+
                    '    </div>'+
                    '    <div class="layui-tab-item">'+
                    '    <div id="on-line-monitoring1" style="max-width:98%;height:220px"></div>'+
                    '    </div>'+
                    '    </div>'+
                    '    </div>;'
                    div.append($(comtenttemp));
                    HighChartsUtil.reqGetMonitorInfo($,setter.remoteServiceAddress, cid,pid);

                    $("#comInfoReload").bind("click",function () {
                        HighChartsUtil.comInfoReload($,cid,setter.remoteServiceAddress);
                    });
                }
            });
        });

        $("#tab1").trigger("click");


    }
    ,//添加浮动框到地图（涉源企业）
    popupRiskSource : function(admin,setter,$,feature,maptype) {
        var shadowOptions = {};
        shadowOptions.isShowShadow = false;
        var anchor = null;
        var closeBox = true;
        //依据不同的属性，创建不同的浮云框
        var size = new Geo.Size(500,260);
        var borderStyle = Geo.View2D.Popup.GeoFrameCloud.CORNER;
        var contentDiv  = "<div class='contentDiv' id='contentDivRisk'><div class='suled'>"+feature.basedata.companyName + "</div>" +
            "<div style='margin-left: 35px;'>" +
            "<div id='tab1' name='contentDivTab' class='contentDivTab' style='margin-left: -25px;'><div style='background-color: #FFF;font-weight: bold;border: 1px solid #ccc'><label>基本信息</label></div></div>" +
            "<div id='tab2' name='contentDivTab' class='contentDivTab'><div style='border: 1px solid #ccc;padding-right: 10px'><label>危险化学品</label></div></div>" +
            "<div id='tab3' name='contentDivTab' class='contentDivTab'><div style='border: 1px solid #ccc'><label>应急物资</label></div></div></div>"+
            "<div class='divTablesNew'><table id='riskTable1'><tr><td class='tdleft'>企业名称：</td><td colspan='3'>"+feature.basedata.companyName +"</td></tr>" +
            "<tr><td class='tdleft'>单位地址：</td><td colspan='3'>"+feature.basedata.companyAddress +"</td></tr>" +
            "<tr><td class='tdleft'>法人代表：</td><td>"+feature.basedata.companyRepresentative +"</td><td class='tdleft'>联系电话：</td><td>"+feature.basedata.representativePhone +"</td></tr>" +
            "<tr><td class='tdleft'>环保联系人：</td><td>"+feature.basedata.environmentalProtectionName +"</td><td class='tdleft'>企业类型：</td><td>"+feature.basedata.pollutionSourceCategoryText +"</td></tr>" +
            "<tr><td class='tdleft'>风险等级：</td><td>"+feature.basedata.riskRatingName +"</td><td class='tdleft'>行政区：</td><td>"+feature.basedata.localCity +"</td></tr></table>"+
            "<table id='riskTable2' style='display: none;'><tr><th class='tdCenter'>序号</th><th class='tdCenter' style='width: 180px;'>风险物资名称</th><th class='tdCenter'>CAS号</th><th class='tdCenter'>数量（吨）</th></tr>" +
            // "<tr><td>1</td><td>测试1</td><td>32323</td><td>10</td></tr>" +
            // "<tr><td>2</td><td class='tdleft'>测试2</td><td>23223</td><td>13</td></tr>" +
            // "<tr><td>3</td><td class='tdleft'>测试3</td><td>434554</td><td>20</td></tr>" +
            "</table>"+
            "<table id='riskTable3' style='display: none;'><tr><th class='tdCenter'>序号</th><th class='tdCenter' style='width: 180px;'>物资名称</th><th class='tdCenter'>物资类型</th><th class='tdCenter'>数量</th></tr>" +
            // "<tr><td>1</td><td>测试设施1</td><td>5432323</td><td>20</td></tr>" +
            // "<tr><td>2</td><td>测试设施2</td><td>132323</td><td>12</td></tr>" +
            // "<tr><td>3</td><td>测试设施3</td><td>323223</td><td>30</td></tr>" +
            // "<tr><td>4</td><td>设施4</td><td>656776</td><td>29</td></tr>" +
            "</table>"+
            "</div><a href=\'../src/views/cominfo/companyshow/slider.html?pid="+feature.basedata.pid+"\' target=\'_blank\'>查看企业档案>></a></div>";

        //设置浮云框为自适应方式，用户能自定义浮云框大小
        Geo.View2D.Popup.GeoFrameCloud.prototype.autoSize = false;
        //创建带有阴影的浮云框对象
        var popup = new Geo.View2D.Popup.GeoFrameCloud("featureInfo",
            //坐标位置
            new Geo.LonLat(feature.geometry.x,feature.geometry.y),
            //浮云框内容大小
            size,
            //浮云框内容
            contentDiv,
            anchor,
            closeBox,
            function(){
                //点击浮云框关闭按钮调用此方法
                TDTMap.select.unselect(TDTMap.selectedFeature);
            },
            shadowOptions,
            borderStyle
        );
        //将要素与浮云框关联
        feature.popup = popup;
        //添加浮云框到地图
        TDTMap.map.addPopup(popup);
        var contentDivTabs = document.getElementsByName("contentDivTab");
        for(var i = 0 ; i < contentDivTabs.length; i++){
            var contentDivTab = contentDivTabs[i];
            contentDivTab.onclick = function () {
                var table1 = document.getElementById("riskTable1");
                table1.style.display = "none";

                var table2 = document.getElementById("riskTable2");
                table2.style.display = "none";

                var table3 = document.getElementById("riskTable3");
                table3.style.display = "none";

                var tab1 = document.getElementById("tab1");
                tab1.children[0].style.backgroundColor = "#CCC";
                tab1.children[0].style.fontWeight = "normal";
                tab1.children[0].style.cursor = "pointer";
                tab1.children[0].children[0].style.cursor = "pointer";

                var tab2 = document.getElementById("tab2");
                tab2.children[0].style.backgroundColor = "#CCC";
                tab2.children[0].style.fontWeight = "normal";
                tab2.children[0].style.cursor = "pointer";
                tab2.children[0].children[0].style.cursor = "pointer";

                var tab3 = document.getElementById("tab3");
                tab3.children[0].style.backgroundColor = "#CCC";
                tab3.children[0].style.fontWeight = "normal";
                tab3.children[0].style.cursor = "pointer";
                tab3.children[0].children[0].style.cursor = "pointer";

                this.children[0].style.backgroundColor = "#FFF";
                this.children[0].style.fontWeight = "bold";
                this.children[0].style.borderStyle = "solid";
                this.children[0].style.borderWidth = "1px";
                this.children[0].style.borderColor = "#ccc";
                this.children[0].style.cursor = "auto";
                this.children[0].children[0].style.cursor = "auto";
                var id = this.id;
                var index = id.substring(3);
                var table = document.getElementById("riskTable" + index);
                table.style.display = "block";
                table.style.height="160px";
                table.style.overflow="auto";
            };
            contentDivTab.onmouseenter = function () {
                this.children[0].style.fontWeight = "bold";
            }
            contentDivTab.onmouseout = function () {
                this.children[0].style.fontWeight = "normal";
            }
        }
        mapshow.getRiskData(admin,setter,$,feature.basedata.pid,"riskTable3");
        mapshow.getDangerData(admin,setter,$,feature.basedata.pid,"riskTable2");
    }
    ,//添加浮动框到地图（涉危企业）
    popupDangerousRisk : function(admin,setter,$,feature,maptype) {
        var shadowOptions = {};
        shadowOptions.isShowShadow = false;
        var anchor = null;
        var closeBox = true;
        //依据不同的属性，创建不同的浮云框
        var size = new Geo.Size(500,260);
        var borderStyle = Geo.View2D.Popup.GeoFrameCloud.CORNER;
        var contentDiv  = "<div class='contentDiv' id='contentDivRisk'><div class='suled'>"+feature.basedata.companyName + "</div>" +
            "<div style='margin-left: 35px;'>" +
            "<div id='tab1' name='contentDivTab' class='contentDivTab' style='margin-left: -25px;'><div style='background-color: #FFF;font-weight: bold;border: 1px solid #ccc'><label>基本信息</label></div></div>" +
            "<div id='tab2' name='contentDivTab' class='contentDivTab'><div style='border: 1px solid #ccc;width: 110px'><label>危险化学品</label></div></div></div>"+
            "<div class='divTablesNew'><table id='dangerTable1'><tr><td class='tdleft'>企业名称：</td><td colspan='3'>"+feature.basedata.companyName +"</td></tr>" +
            "<tr><td class='tdleft'>单位地址：</td><td colspan='3'>"+feature.basedata.companyAddress +"</td></tr>" +
            "<tr><td class='tdleft'>法人代表：</td><td>"+feature.basedata.companyRepresentative +"</td><td class='tdleft'>联系电话：</td><td>"+feature.basedata.representativePhone +"</td></tr>" +
            "<tr><td class='tdleft'>环保联系人：</td><td>"+feature.basedata.environmentalProtectionName +"</td><td class='tdleft'>企业类型：</td><td>"+feature.basedata.pollutionSourceCategoryText +"</td></tr>" +
            "<tr><td class='tdleft'>风险等级：</td><td>"+feature.basedata.riskRatingName +"</td><td class='tdleft'>行政区：</td><td>"+feature.basedata.localCity +"</td></tr></table>"+
            "<table id='dangerTable2' style='display: none;height: 160px;'><tr><th class='tdCenter'>序号</th><th class='tdCenter' style='width: 180px'>风险物质名称</th><th class='tdCenter'>CAS号</th><th class='tdCenter'>数量（吨）</th></tr>" +
            // "<tr><td>1</td><td>测试1</td><td>32323</td><td>10</td></tr>" +
            // "<tr><td>2</td><td class='tdleft'>测试2</td><td>23223</td><td>13</td></tr>" +
            // "<tr><td>3</td><td class='tdleft'>测试3</td><td>434554</td><td>20</td></tr>" +
            "</table>"+
            "</div><a href=\'../src/views/cominfo/companyshow/slider.html?pid="+feature.basedata.pid+"\' target=\'_blank\'>查看企业档案>></a></div>";

        //设置浮云框为自适应方式，用户能自定义浮云框大小
        Geo.View2D.Popup.GeoFrameCloud.prototype.autoSize = false;
        //创建带有阴影的浮云框对象
        var popup = new Geo.View2D.Popup.GeoFrameCloud("featureInfo",
            //坐标位置
            new Geo.LonLat(feature.geometry.x,feature.geometry.y),
            //浮云框内容大小
            size,
            //浮云框内容
            contentDiv,
            anchor,
            closeBox,
            function(){
                //点击浮云框关闭按钮调用此方法
                TDTMap.select.unselect(TDTMap.selectedFeature);
            },
            shadowOptions,
            borderStyle
        );
        //将要素与浮云框关联
        feature.popup = popup;
        //添加浮云框到地图
        TDTMap.map.addPopup(popup);
        var contentDivTabs = document.getElementsByName("contentDivTab");
        for(var i = 0 ; i < contentDivTabs.length; i++){
            var contentDivTab = contentDivTabs[i];
            contentDivTab.onclick = function () {
                var table1 = document.getElementById("dangerTable1");
                table1.style.display = "none";

                var table2 = document.getElementById("dangerTable2");
                table2.style.display = "none";

                var tab1 = document.getElementById("tab1");
                tab1.children[0].style.backgroundColor = "#CCC";
                tab1.children[0].style.fontWeight = "normal";
                tab1.children[0].style.cursor = "pointer";
                tab1.children[0].children[0].style.cursor = "pointer";

                var tab2 = document.getElementById("tab2");
                tab2.children[0].style.backgroundColor = "#CCC";
                tab2.children[0].style.fontWeight = "normal";
                tab2.children[0].style.cursor = "pointer";
                tab2.children[0].children[0].style.cursor = "pointer";

                this.children[0].style.backgroundColor = "#FFF";
                this.children[0].style.fontWeight = "bold";
                this.children[0].style.borderStyle = "solid";
                this.children[0].style.borderWidth = "1px";
                this.children[0].style.borderColor = "#ccc";
                this.children[0].style.cursor = "auto";
                this.children[0].children[0].style.cursor = "auto";
                var id = this.id;
                var index = id.substring(3);
                var table = document.getElementById("dangerTable" + index);
                table.style.display = "block";
                table.style.height="160px";
                table.style.overflow="auto";
            };
            contentDivTab.onmouseenter = function () {
                this.children[0].style.fontWeight = "bold";
            }
            contentDivTab.onmouseout = function () {
                this.children[0].style.fontWeight = "normal";
            }
        }
        mapshow.getDangerData(admin,setter,$,feature.basedata.pid,"dangerTable2");
    }
    ,//添加浮动框到地图（涉放射性企业）
    popupIsotopeRisk : function(admin,setter,$,feature) {
        var shadowOptions = {};
        shadowOptions.isShowShadow = false;
        var anchor = null;
        var closeBox = true;
        //依据不同的属性，创建不同的浮云框
        var size = new Geo.Size(500,260);
        var borderStyle = Geo.View2D.Popup.GeoFrameCloud.CORNER;
        var contentDiv  = "<div class='contentDiv' id='contentDivRisk'><div class='suled'>"+feature.basedata.companyName + "</div>" +
            "<div style='margin-left: 35px;'>" +
            "<div id='tab1' name='contentDivTab' class='contentDivTab' style='margin-left: -25px;'><div style='background-color: #FFF;font-weight: bold;border: 1px solid #ccc'><label>基本信息</label></div></div>" +
            "<div id='tab2' name='contentDivTab' class='contentDivTab'><div style='border: 1px solid #ccc;width: 120px;padding-right: 5px'><label style='width: 90px'>放射性同位素</label></div></div></div>"+
            "<div class='divTablesNew'><table id='isotopeTable1'><tr><td class='tdleft'>企业名称：</td><td colspan='3'>"+feature.basedata.companyName +"</td></tr>" +
            "<tr><td class='tdleft'>单位地址：</td><td colspan='3'>"+feature.basedata.companyAddress +"</td></tr>" +
            "<tr><td class='tdleft'>法人代表：</td><td>"+feature.basedata.companyRepresentative +"</td><td class='tdleft'>联系电话：</td><td>"+feature.basedata.representativePhone +"</td></tr>" +
            "<tr><td class='tdleft'>环保联系人：</td><td>"+feature.basedata.environmentalProtectionName +"</td><td class='tdleft'>企业类型：</td><td>"+feature.basedata.pollutionSourceCategoryText +"</td></tr>" +
            "<tr><td class='tdleft'>风险等级：</td><td>"+feature.basedata.riskRatingName +"</td><td class='tdleft'>行政区：</td><td>"+feature.basedata.localCity +"</td></tr></table>"+
            "<table id='isotopeTable2' style='display: none;'><tr><th class='tdCenter'>序号</th><th class='tdCenter' style='width: 180px'>核素名称</th><th class='tdCenter'>放射性类别</th><th class='tdCenter'>数量（吨）</th></tr>" +
            // "<tr><td>1</td><td>测试1</td><td>密封放射源Ⅲ</td><td>10</td></tr>" +
            // "<tr><td>2</td><td class='tdleft'>测试2</td><td>密封放射源Ⅲ</td><td>13</td></tr>" +
            // "<tr><td>3</td><td class='tdleft'>测试3</td><td>密封放射源Ⅲ</td><td>20</td></tr>" +
            "</table>"+
            "</div><a href=\'../src/views/cominfo/companyshow/slider.html?pid="+feature.basedata.pid+"\' target=\'_blank\'>查看企业档案>></a></div>";

        //设置浮云框为自适应方式，用户能自定义浮云框大小
        Geo.View2D.Popup.GeoFrameCloud.prototype.autoSize = false;
        //创建带有阴影的浮云框对象
        var popup = new Geo.View2D.Popup.GeoFrameCloud("featureInfo",
            //坐标位置
            new Geo.LonLat(feature.geometry.x,feature.geometry.y),
            //浮云框内容大小
            size,
            //浮云框内容
            contentDiv,
            anchor,
            closeBox,
            function(){
                //点击浮云框关闭按钮调用此方法
                TDTMap.select.unselect(TDTMap.selectedFeature);
            },
            shadowOptions,
            borderStyle
        );
        //将要素与浮云框关联
        feature.popup = popup;
        //添加浮云框到地图
        TDTMap.map.addPopup(popup);
        var contentDivTabs = document.getElementsByName("contentDivTab");
        for(var i = 0 ; i < contentDivTabs.length; i++){
            var contentDivTab = contentDivTabs[i];
            contentDivTab.onclick = function () {
                var table1 = document.getElementById("isotopeTable1");
                table1.style.display = "none";

                var table2 = document.getElementById("isotopeTable2");
                table2.style.display = "none";

                var tab1 = document.getElementById("tab1");
                tab1.children[0].style.backgroundColor = "#CCC";
                tab1.children[0].style.fontWeight = "normal";
                tab1.children[0].style.cursor = "pointer";
                tab1.children[0].children[0].style.cursor = "pointer";

                var tab2 = document.getElementById("tab2");
                tab2.children[0].style.backgroundColor = "#CCC";
                tab2.children[0].style.fontWeight = "normal";
                tab2.children[0].style.cursor = "pointer";
                tab2.children[0].children[0].style.cursor = "pointer";

                this.children[0].style.backgroundColor = "#FFF";
                this.children[0].style.fontWeight = "bold";
                this.children[0].style.borderStyle = "solid";
                this.children[0].style.borderWidth = "1px";
                this.children[0].style.borderColor = "#ccc";
                this.children[0].style.cursor = "auto";
                this.children[0].children[0].style.cursor = "auto";
                var id = this.id;
                var index = id.substring(3);
                var table = document.getElementById("isotopeTable" + index);
                table.style.display = "block";
                table.style.height="160px";
                table.style.overflow="auto";
            };
            contentDivTab.onmouseenter = function () {
                this.children[0].style.fontWeight = "bold";
            }
            contentDivTab.onmouseout = function () {
                this.children[0].style.fontWeight = "normal";
            }
        }
        mapshow.getIsotopeData(admin,setter,$,feature.basedata.pid,"isotopeTable2");
    }
    ,highlight:function (longitude,latitude) {
        // var lon_temp = 118.77;
        // var lat_temp = 32.05;
        // if(longitude != 0){
        //     lon_temp = longitude;
        // }
        // if(latitude != 0){
        //     lat_temp = latitude;
        // }
        if(longitude !=0 && latitude !=0){
            if(TDTMap.geoMarker != null){
                TDTMap.markersLayer.removeMarker(TDTMap.geoMarker);
            }
            // TDTMap.map.setCenter(new Geo.LonLat(longitude, latitude));
            TDTMap.map.panTo(new Geo.LonLat(longitude, latitude));//移动地图
            TDTMap.markersLayer = new Geo.View2D.Layer.Markers("Markers");
            TDTMap.map.addLayer(TDTMap.markersLayer);
            var size = new Geo.Size(32,32);
            var offset = new Geo.Pixel(-(size.w/2), -(size.h/4));
            var url = "http://" +  TDTMap.Cfg.host  +  "/" + TDTMap.Cfg.projectName + "/start/TDTNJApi/profile/images/坐标动画.gif";
            var icon = new Geo.View2D.Icon(url, size, offset);
            TDTMap.geoMarker = new Geo.GeoMarker(new Geo.LonLat(longitude, latitude),icon)
            TDTMap.markersLayer.addMarker(TDTMap.geoMarker);
            // TDTMap.geoMarker.setAnimation(Geo.GeoMarker.ANIMATION_BOUNCE, 5, 50);//单次跳动是Geo.GeoMarker.ANIMATION_DROP
            // setTimeout(function () {
            //     TDTMap.markersLayer.removeMarker(TDTMap.geoMarker);
            // },5000)
            var dom = TDTMap.geoMarker.icon.imageDiv;
            $(dom).hover(function () {
                TDTMap.markersLayer.removeMarker(TDTMap.geoMarker);
            });
        }
    }
};


