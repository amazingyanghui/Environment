var markers = new Array();
var map;
function initMapForAdd(container,addressname,txtMonitorName,searchResultPanel,enableDragging,txtlongitude,txtlatitude) {
    requestData(container,addressname,txtMonitorName,searchResultPanel,enableDragging,txtlongitude,txtlatitude);
}
function requestData(container,addressname,txtMonitorName,searchResultPanel,enableDragging,txtlongitude,txtlatitude) {
    map = new BMap.Map(container);
    map.enableScrollWheelZoom();
    //设置默认鼠标样式
    map.setDefaultCursor("pointer");
    map.addControl(new BMap.NavigationControl());
    map.addControl(new BMap.ScaleControl());
    map.addControl(new BMap.OverviewMapControl());
    map.addControl(new BMap.MapTypeControl());

    var localSearch = new BMap.LocalSearch(map);
    localSearch.enableAutoViewport(); //允许自动调节窗体大小
    map.clearOverlays();//清空原来的标注
    // var keyword = $("[name='companyAddress']").val();
    var keyword = addressname;
    if ((txtlongitude == "" && txtlatitude == "")||
        (txtlongitude == "0" && txtlatitude == "0")) {
        map.centerAndZoom("柘汪镇赣榆区", 16);
        localSearch.setSearchCompleteCallback(function (searchResult) {

            var poi = searchResult.getPoi(0);
            if (poi != null && poi != "") {
                deletePoint();

                map.centerAndZoom(poi.point, 10);
                var marker = new BMap.Marker(new BMap.Point(poi.point.lng, poi.point.lat));
                map.addOverlay(marker);
                var content = keyword + "<br/>经度：" + poi.point.lng + "<br/>纬度：" + poi.point.lat;
                var infoWindow = new BMap.InfoWindow("<p style='font-size:14px;'>" + content + "</p>");

                //下面是拖动的代码 去掉就可以
                if(enableDragging){
                    marker.enableDragging();
                    marker.addEventListener("dragend", function (e) {  //拖动事件
                        var pt = e.point;
                        var dizhi;
                        content = keyword + "<br/>经度：" + pt.lng + "<br/>纬度：" + pt.lat;
                        infoWindow = new BMap.InfoWindow("<p style='font-size:14px;'>" + content + "</p>");
                        marker.openInfoWindow(infoWindow, map.getCenter());
                        WriteToCompanyDocument(pt);
                    });
                }

                marker.openInfoWindow(infoWindow, map.getCenter());
                //marker.addEventListener("click", function () { this.openInfoWindow(infoWindow); });
                WriteToCompanyDocument(poi.point);
                markers.push(marker);
            }
            else {
                if (txtlongitude != "" && txtlatitude != "") {

                    deletePoint();
                    var tempPoint = new BMap.Point(txtlongitude, txtlatitude);

                    map.centerAndZoom(tempPoint, 10);
                    var marker = new BMap.Marker(tempPoint);
                    map.addOverlay(marker);
                    var content = keyword + "<br/>经度：" + tempPoint.lng + "<br/>纬度：" + tempPoint.lat;
                    var infoWindow = new BMap.InfoWindow("<p style='font-size:14px;'>" + content + "</p>");

                    //下面是拖动的代码 去掉就可以
                    if(enableDragging){
                        marker.enableDragging();
                        marker.addEventListener("dragend", function (e) {  //拖动事件
                            var pt = e.point;
                            var dizhi;
                            content = keyword + "<br/>经度：" + pt.lng + "<br/>纬度：" + pt.lat;
                            infoWindow = new BMap.InfoWindow("<p style='font-size:14px;'>" + content + "</p>");
                            marker.openInfoWindow(infoWindow, map.getCenter());
                            WriteToCompanyDocument(pt);
                        });
                    }

                    marker.openInfoWindow(infoWindow, map.getCenter());
                    // marker.addEventListener("click", function () { this.openInfoWindow(infoWindow); });
                    WriteToCompanyDocument(tempPoint);
                    markers.push(marker);
                }
            }
        });
        if (keyword != "") {
            localSearch.search(keyword);
        }
    }
    else {
        if (txtlongitude != "" && txtlatitude != "") {

            deletePoint();
            var tempPoint = new BMap.Point(txtlongitude, txtlatitude);

            map.centerAndZoom(tempPoint, 10);
            var marker = new BMap.Marker(tempPoint);
            map.addOverlay(marker);
            var content = keyword + "<br/>经度：" + tempPoint.lng + "<br/>纬度：" + tempPoint.lat;
            var infoWindow = new BMap.InfoWindow("<p style='font-size:14px;'>" + content + "</p>");

            //下面是拖动的代码 去掉就可以
            if(enableDragging){
                marker.enableDragging();
                marker.addEventListener("dragend", function (e) {  //拖动事件
                    var pt = e.point;
                    var dizhi;
                    content = keyword + "<br/>经度：" + pt.lng + "<br/>纬度：" + pt.lat;
                    infoWindow = new BMap.InfoWindow("<p style='font-size:14px;'>" + content + "</p>");
                    marker.openInfoWindow(infoWindow, map.getCenter());
                    WriteToCompanyDocument(pt);
                });
            }

            marker.openInfoWindow(infoWindow, map.getCenter());
            // marker.addEventListener("click", function () { this.openInfoWindow(infoWindow); });
            WriteToCompanyDocument(tempPoint);
            markers.push(marker);
        }
    }
    if(enableDragging){
        map.addEventListener("click", function (e) {
            if (txtlongitude == fomatFloat(e.point.lng, 4) && txtlatitude == fomatFloat(e.point.lat, 4)) {
                //alert('xxx');
                return;
            }
            deletePoint();
            var mks = new BMap.Marker(e.point);
            map.addOverlay(mks);
            map.panTo(new BMap.Point(e.point.lng, e.point.lat));// map.panTo方法，把点击的点设置为地图中心点
            var contents = keyword + "<br/>经度：" + e.point.lng + "<br/>纬度：" + e.point.lat;
            var infoWindows = new BMap.InfoWindow("<p style='font-size:14px;'>" + contents + "</p>");
            //下面是拖动的代码 去掉就可以
            if(enableDragging){
                mks.enableDragging();
                mks.addEventListener("dragend", function (e) {  //拖动事件
                    var pt = e.point;
                    var dizhi;
                    content = keyword + "<br/>经度：" + pt.lng + "<br/>纬度：" + pt.lat;
                    infoWindows = new BMap.InfoWindow("<p style='font-size:14px;'>" + content + "</p>");
                    mks.openInfoWindow(infoWindows, map.getCenter());
                    //  map.centerAndZoom(pt, 15);
                    WriteToCompanyDocument(pt);
                });
            }

            mks.openInfoWindow(infoWindows, map.getCenter());
            //  mks.addEventListener("click", function () { alert(contents); this.openInfoWindow(infoWindows); }, true);
            WriteToCompanyDocument(e.point);
            markers.push(mks);
        });
    }

    var ac = new BMap.Autocomplete(    //建立一个自动完成的对象
        {
            "input": txtMonitorName
            , "location": map
        });

    ac.addEventListener("onhighlight", function (e) {  //鼠标放在下拉列表上的事件
        var str = "";
        var _value = e.fromitem.value;
        var value = "";
        if (e.fromitem.index > -1) {
            value = _value.province + _value.city + _value.district + _value.street + _value.business;
        }
        str = "FromItem<br />index = " + e.fromitem.index + "<br />value = " + value;

        value = "";
        if (e.toitem.index > -1) {
            _value = e.toitem.value;
            value = _value.province + _value.city + _value.district + _value.street + _value.business;
        }
        str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = " + value;
        G(searchResultPanel).innerHTML = str;
    });

    var myValue;
    ac.addEventListener("onconfirm", function (e) {    //鼠标点击下拉列表后的事件
        var _value = e.item.value;
        myValue = _value.province + _value.city + _value.district + _value.street + _value.business;
        G(searchResultPanel).innerHTML = "onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue;

        setPlace(myValue);
    });
}

function WriteToCompanyDocument(point) {
    $("[name='longitude']").val(point.lng);
    $("[name='latitude']").val(point.lat);
}

function TransferFormat(crood) {
    var Croods = new Array();
    var Fen = new Array();
    var Croodnate = new Array();
    Croods = crood.toString().split('.');
    var Fen1 = Number("0." + Croods[1]) * 60;
    Fen = Fen1.toString().split('.');
    var Seconds = Number("0." + Fen[1]) * 60;
    var Miao = fomatFloat(Seconds, 4).toString();
    Croodnate.push(Croods[0]);
    Croodnate.push(Fen[0]);
    Croodnate.push(Miao);
    return Croodnate;
}

function fomatFloat(src, pos) {
    return Math.round(src * Math.pow(10, pos)) / Math.pow(10, pos);
}

function deletePoint() {
    if (markers.length > 0) {
        for (var i = 0; i < markers.length; i++) {
            map.removeOverlay(markers[i]);
        }
    }
    map.clearOverlays();    //清除地图上所有覆盖物
}

function G(id) {
    return document.getElementById(id);
}

function setPlace(myValue) {
    map.clearOverlays();    //清除地图上所有覆盖物
    function myFun() {
        var pp = local.getResults().getPoi(0).point;    //获取第一个智能搜索的结果
        map.centerAndZoom(pp, 18);
        map.addOverlay(new BMap.Marker(pp));    //添加标注
        WriteToCompanyDocument(pp);
    }
    var local = new BMap.LocalSearch(map, { //智能搜索
        onSearchComplete: myFun
    });
    local.search(myValue);
}