var TDTMapNew = {
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
        TDTMapNew.Cfg.host = window.location.host;
        TDTMapNew.Cfg.projectName = window.location.pathname.split("/")[1];
        var proxyHostUrl = setter.remoteServiceAddress + "/proxy?url=";
        GeoGlobe.Request.setProxyHost(proxyHostUrl);
        // TDTMapNew.lon_temp = 118.808425;
        // TDTMapNew.lat_temp = 32.23416;
        TDTMapNew.lon_temp = 119.278027;
        TDTMapNew.lat_temp = 35.096744;
        TDTMapNew.zoom_temp = 13;
        if(data){
            if(data.longitude){
                TDTMapNew.lon_temp = data.longitude;
                TDTMapNew.zoom_temp = 16;
            }
            if(data.latitude){
                TDTMapNew.lat_temp = data.latitude;
                TDTMapNew.zoom_temp = 16;
            }
        }
        //1-18级WMTS矢量底图服务地址
        // TDTMapNew.Cfg.mapWMTSLayer_Url_JS = "http://59.83.223.35:7001/JB_DT/wmts";//
        // TDTMapNew.Cfg.mapWMTSLayer_Url_JS = "http://59.83.223.35:7001/JB_ZJ/wmts";//
        // TDTMapNew.Cfg.mapWMTSLayer_Url_JS = "http://59.83.223.35:7001/JB_YX/wmts";//
        // TDTMapNew.Cfg.mapWMTSLayer_Url_JS = "http://59.83.223.35:7001/JB_ZGQ/wmts";//
        // // TDTMapNew.Cfg.mapWMTSLayer_Url_JS = "http://59.83.223.35:7001/JB_JD/wmts";//
        // // TDTMapNew.Cfg.mapWMTSLayer_Url_JS = "http://59.83.223.35:7001/JB_SQ/wmts";//
        // // TDTMapNew.Cfg.mapWMTSLayer_Url_JS = "http://59.83.223.35:7001/JB_WG/wmts";//
        // // TDTMapNew.Cfg.mapWMTSLayer_Url_JS = "http://59.83.223.35:7001/JB_DP/wmts";//
        // TDTMapNew.map = new Geo.View2D.Map("simpleMap");
        // var format = new Geo.Util.Format.WMTS();
        // TDTMapNew.vectorlayer = format.createLayer(TDTMapNew.Cfg.mapWMTSLayer_Url_JS);
        // TDTMapNew.map.addLayers([TDTMapNew.vectorlayer]);
        // TDTMapNew.map.setCenter(new Geo.LonLat(TDTMapNew.lon_temp , TDTMapNew.lat_temp),3);
        var simple = {
            "version": 8,
            "sources": {},
            "layers": []
        };
        var wgs84_wgs84_mapcrs = {
            topTileExtent:[-180, -270, 180, 90],
            coordtransform:"none"
        };
        //构造地图对象实例,并添加到id为map的div容器中
        TDTMapNew.map = new GeoGlobe.Map({
            mapCRS:wgs84_wgs84_mapcrs,
            style:simple,
            container:'simpleMap',
            zoom: 9,
            center: [118.78,32.04],
            isIntScrollZoom: true//缩放级别是否为整数处理模式
        });
        //根据参数添加wmts图层
        var wmts_layer = new GeoGlobe.Layer.WMTS({
            url: "http://59.83.223.35:7001/JB_ZGQ/wmts",//地址
            layer: "JBBJ",//图层标识
            format: "image/tile",//格式
            matrixSet: "Matrix_JBBJ_0",//矩阵集名称
            style:"JBBJ",//样式标识(vts中不需要)
            version:"1.0.0"
        });

        //设置地图边界
        var bounds = new GeoGlobe.LngLatBounds(new GeoGlobe.LngLat(-180,-90), new GeoGlobe.LngLat(180,90));
        TDTMapNew.map.setMaxBounds(bounds);

        TDTMapNew.map.on("load", function(e) {
            TDTMapNew.map.addLayer(wmts_layer);
            // //加载矢量点要素
            // var pointjson = {
            //     "type": "geojson",
            //     "data": {
            //         "type": "Feature",
            //         "geometry": {
            //             "type": "Point",
            //             "coordinates": [118.78, 32.04]
            //         }
            //     }
            // };
            // TDTMapNew.map.addLayer({
            //     "id": "point",
            //     "type": "circle",
            //     "source": pointjson,
            //     "paint": {
            //         "circle-radius": 5,
            //         "circle-color": "red",
            //         "circle-opacity": 0.8
            //     }
            // });
            var loadindex = layer.load(0);
            admin.req({//
                url: setter.remoteServiceAddress + "/map/queryCominfoList"
                ,data:{
                    regulatoryLevel:null
                    ,companyName:null
                    ,wasteType:null
                    ,creditEvaluation:null
                    ,otherCondition:null

                }
                , done: function (result) {
                    layer.close(loadindex);
                    // TDTMapNew.addPointsInMapNewMap(admin,setter,$,result.data,[],0);
                    TDTMapNew.addddd(admin,setter,$,result.data,[],0);
                }
                ,complete:function (res) {
                    layer.close(loadindex);
                }
            });
        });

        //创建地图右键菜单
        var cm = new GeoGlobe.Control.MapContextMenu();
        TDTMapNew.map.addControl(cm);
        //创建菜单
        var menuItem1 = new GeoGlobe.MenuItem({
            text: "放大",
            width: 100,//宽度
            callback: function(e){
                e.map.flyTo({
                    speed:0.2,
                    center:[e.lngLat.lng,e.lngLat.lat],
                    zoom: e.map.getZoom()+1
                });
            }
        });
        var menuItem2 = new GeoGlobe.MenuItem({
            text: "缩小",
            width: 100,
            callback: function(e){
                e.map.flyTo({
                    speed:0.2,
                    center:[e.lngLat.lng,e.lngLat.lat],
                    zoom: e.map.getZoom()-1
                });
            }
        });
        //添加菜单选项
        cm.addItem(menuItem1);
        cm.addItem(menuItem2);

        /**设置鼠标右键拖动地图不弹出右键功能**/
        var downPoint,upPoint;
        TDTMapNew.map.on("mousedown",function (e) {
            downPoint = e.point;
        });
        TDTMapNew.map.on("mouseup",function (e) {
            upPoint = e.point;
        });
        TDTMapNew.map.on("contextmenu", function (e) {
            if(downPoint.x == upPoint.x && downPoint.y == upPoint.y){
                cm._showContextMenu(e);
            }else{
                cm.hide();
            }
        });

        //点击获取要素
        TDTMapNew.map.on("click",function(e){
            var features = TDTMapNew.map.queryRenderedFeatures(e.point, { layers: ["state-fills"] });
            debugger
            alert(2)

            // if (features.length) {
            //     document.getElementById('features').style.display='block';
            //     map.setFilter("state-fills-hover", ["==", "name", features[0].properties.name]);
            //     document.getElementById('features').innerHTML = JSON.stringify(features, null, 2);
            // } else {
            //     document.getElementById('features').style.display='none';
            //     map.setFilter("state-fills-hover", ["==", "name", ""]);
            // }
            // TDTMapNew.popupCompanyLocation(admin,setter,$,feature);
        });
    }
    ,mapEvent:function(event,admin,setter,$){
        if(TDTMapNew.maptype == 1){
            var zoom = Number(TDTMapNew.map.getRealZoom());
            var baseurl = setter.remoteServiceAddress + "/map";
            var companyNameOnline = $("#companyNameOnline").val();
            if(TDTMapNew.iflag){
                if(zoom >= 17 ) {
                    TDTMapNew.map_level = 1;
                    TDTMapNew.zoom_temp = (zoom - 1);
                    var lonlat = TDTMapNew.map.getCenter();
                    TDTMapNew.lon_temp = lonlat.lon;
                    TDTMapNew.lat_temp = lonlat.lat;
                    // alert(TDTMapNew.map.getRealZoom())
                    mapshow.getMonitorLocationForMap(admin, setter, $, baseurl, [], TDTMapNew.monitorType,1,companyNameOnline)
                    TDTMapNew.iflag = false;
                }
            }
            if(!TDTMapNew.iflag) {
                if (zoom == 16 || zoom == 15 || zoom == 14) {
                    TDTMapNew.map_level = 0
                    TDTMapNew.zoom_temp = (zoom - 1);
                    var lonlat = TDTMapNew.map.getCenter();
                    TDTMapNew.lon_temp = lonlat.lon;
                    TDTMapNew.lat_temp = lonlat.lat;
                    // alert(TDTMapNew.map.getRealZoom())
                    var global_obj = {};
                    global_obj.wasteType = TDTMapNew.wasteType;
                    global_obj.differType = 1;
                    mapshow.getCompanyLocationForMap(admin, setter, $, baseurl, [], null, companyNameOnline, global_obj);
                    TDTMapNew.iflag = true;
                }
            }
        }
    }
    ,mapClick : function (evt) {
        if(TDTMapNew.geoMarker){
            if(TDTMapNew.geoMarker.icon.url.indexOf("坐标动画") === -1){
                TDTMapNew.markersLayer.removeMarker(TDTMapNew.geoMarker);
                var mousePosition = TDTMapNew.mousePosition;
                var xy_temp = mousePosition.element.innerText;
                var x_temp = xy_temp.split(",")[0];
                var y_temp = xy_temp.split(",")[1];
                var size = new Geo.Size(32,32);
                var offset = new Geo.Pixel(-(size.w/2), -(size.h/2));
                var url = "http://" +  TDTMapNew.Cfg.host  +  "/" + TDTMapNew.Cfg.projectName + "/start/TDTNJApi/profile/images/marker-blue.png";
                var icon = new Geo.View2D.Icon(url, size, offset);
                TDTMapNew.geoMarker = new Geo.GeoMarker(new Geo.LonLat(x_temp, y_temp),icon)
                TDTMapNew.markersLayer.addMarker(TDTMapNew.geoMarker);

                var checked = $("input[name='radiolocation']:checked")[0];
                if(checked){
                    $(checked).removeAttr("checked")
                }
            }
        }
    }
    ,createSelectFeature: function (admin,setter,$,maptype) {
        //创建选择要素控件
        TDTMapNew.select = new Geo.View2D.Control.SelectFeature(TDTMapNew.vectorlayer,{
                //用户选择要素后，执行的回调函数
                onSelect: function(feature) {
                    TDTMapNew.selectedFeature = feature;
                    if(maptype == 0){
                        TDTMapNew.popupCompanyLocation(admin,setter,$,feature);
                    }else if(maptype == 1){
                        TDTMapNew.popupMonitorLocation(admin,setter,$,feature);
                    }else if(maptype == 2){
                        TDTMapNew.popupRiskSource(admin,setter,$,feature);
                    }else if(maptype == 3){
                        TDTMapNew.popupDangerousRisk(admin,setter,$,feature);
                    }else if(maptype == 4){
                        TDTMapNew.popupIsotopeRisk(admin,setter,$,feature);
                        // }else{
                        //     TDTMapNew.add(feature);
                    }

                    $("#showInfo").on("click",function(){
                        pid = feature.basedata.cid;
                        statistics.init(admin,setter,pid)
                    });
                },
                onUnselect:function(feature) {
                    //取消选择后，要素与浮云框断开关联
                    TDTMapNew.map.removePopup(feature.popup);
                    feature.popup.destroy();
                    feature.popup = null;
                }
            }
        );
        TDTMapNew.map.addControl(TDTMapNew.select);
        //激活选择要素控件
        TDTMapNew.select.activate();
    }
    ,addPointsInMapNewMap: function (admin,setter,$,arraydata,featureList,maptype) {
        var imgPath = "http://" +  TDTMapNew.Cfg.host  +  "/" + TDTMapNew.Cfg.projectName + "/start/TDTNJApi/profile/images/marker.png";
        if(maptype == 1){
            imgPath = "http://" +  TDTMapNew.Cfg.host  +  "/" + TDTMapNew.Cfg.projectName + "/start/TDTNJApi/profile/images/marker-blue.png";
        }else if(maptype == 2){
            imgPath = "http://" +  TDTMapNew.Cfg.host  +  "/" + TDTMapNew.Cfg.projectName + "/start/TDTNJApi/profile/images/5.png";
        }else if(maptype == 3){
            imgPath = "http://" +  TDTMapNew.Cfg.host  +  "/" + TDTMapNew.Cfg.projectName + "/start/TDTNJApi/profile/images/guibi.png";
        }else if(maptype == 4){
            imgPath = "http://" +  TDTMapNew.Cfg.host  +  "/" + TDTMapNew.Cfg.projectName + "/start/TDTNJApi/profile/images/endStation.png";
        }
        for(var i=0; i<arraydata.length; i++ ) {
            var px = arraydata[i].longitude;
            var py = arraydata[i].latitude;
            //加载矢量点要素
            var pointjson = {
                "type": "geojson",
                "data": {
                    "type": "Feature",
                    "geometry": {
                        "type": "Point",
                        "coordinates": [px, py]
                    }
                }
            };
            TDTMapNew.map.addLayer({
                "id": "point"+i,
                "type": "circle",
                "source": pointjson,
                "paint": {
                    "circle-radius": 5,
                    "circle-color": "red",
                    "circle-opacity": 0.8
                }
            });
        };

    }
    ,addddd :function (admin,setter,$,arraydata,featureList,maptype) {
        var imgPath = "http://" +  TDTMapNew.Cfg.host  +  "/" + TDTMapNew.Cfg.projectName + "/start/TDTNJApi/profile/images/marker.png";
        if(maptype == 1){
            imgPath = "http://" +  TDTMapNew.Cfg.host  +  "/" + TDTMapNew.Cfg.projectName + "/start/TDTNJApi/profile/images/marker-blue.png";
        }else if(maptype == 2){
            imgPath = "http://" +  TDTMapNew.Cfg.host  +  "/" + TDTMapNew.Cfg.projectName + "/start/TDTNJApi/profile/images/5.png";
        }else if(maptype == 3){
            imgPath = "http://" +  TDTMapNew.Cfg.host  +  "/" + TDTMapNew.Cfg.projectName + "/start/TDTNJApi/profile/images/guibi.png";
        }else if(maptype == 4){
            imgPath = "http://" +  TDTMapNew.Cfg.host  +  "/" + TDTMapNew.Cfg.projectName + "/start/TDTNJApi/profile/images/endStation.png";
        }
        for(var i=0; i<arraydata.length; i++ ) {
            var px = arraydata[i].longitude;
            var py = arraydata[i].latitude;
            var bigImg = document.createElement("img"); //创建一个img元素
            bigImg.src = imgPath; //给img元素的src属性赋值
            var myDiv = document.createElement('myDiv');  //获得dom对象
            myDiv.style.width = '32px';
            myDiv.style.height = '32px';
            myDiv.className = 'marker';
            myDiv.appendChild(bigImg);      //为dom添加子元素img
            var markers = new GeoGlobe.Marker(myDiv)
                .setLngLat([px ,py])
                .addTo(TDTMapNew.map);
        };
    }
    ,addPointsInMap: function (admin,setter,$,arraydata,featureList,maptype) {
        var imgPath = "http://" +  TDTMapNew.Cfg.host  +  "/" + TDTMapNew.Cfg.projectName + "/start/TDTNJApi/profile/images/marker.png";
        if(maptype == 1){
            imgPath = "http://" +  TDTMapNew.Cfg.host  +  "/" + TDTMapNew.Cfg.projectName + "/start/TDTNJApi/profile/images/marker-blue.png";
        }else if(maptype == 2){
            imgPath = "http://" +  TDTMapNew.Cfg.host  +  "/" + TDTMapNew.Cfg.projectName + "/start/TDTNJApi/profile/images/5.png";
        }else if(maptype == 3){
            imgPath = "http://" +  TDTMapNew.Cfg.host  +  "/" + TDTMapNew.Cfg.projectName + "/start/TDTNJApi/profile/images/guibi.png";
        }else if(maptype == 4){
            imgPath = "http://" +  TDTMapNew.Cfg.host  +  "/" + TDTMapNew.Cfg.projectName + "/start/TDTNJApi/profile/images/endStation.png";
        }
        featureList = TDTMapNew.clearFeatures(true,false,featureList);
        for(var i=0; i<arraydata.length; i++ ) {
            var px = arraydata[i].longitude;
            var py = arraydata[i].latitude;
            var newPoint = new Geo.Geometry.Point(px, py);
            var pointFeature = new Geo.Feature.Vector(newPoint, {clazz:"A"}, {
                externalGraphic:imgPath,
                graphicWidth:32,
                graphicHeight:32
            });
            pointFeature.basedata = arraydata[i];
            featureList.push(pointFeature);
        };
        debugger;
        TDTMapNew.vectorlayer.addFeatures(featureList);
        TDTMapNew.createSelectFeature(admin,setter,$,maptype); //创建选择要素控件
        TDTMapNew.map.setCenter(new Geo.LonLat(TDTMapNew.lon_temp , TDTMapNew.lat_temp),TDTMapNew.zoom_temp);
        if(TDTMapNew.geoMarker != null){
            TDTMapNew.markersLayer.removeMarker(TDTMapNew.geoMarker);
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
            // "<br/><a href=\'../src/views/cominfo/companyshow/slider.html?pid="+feature.basedata.pid+"\' target=\'_blank\'>查看企业档案>></a></div>";
            "<br/></div>";

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
                TDTMapNew.select.unselect(TDTMapNew.selectedFeature);
            },
            shadowOptions,
            borderStyle
        );
        //将要素与浮云框关联
        feature.popup = popup;
        //添加浮云框到地图
        TDTMapNew.map.addPopup(popup);
    }
};


