
// 获取capabilities能力信息
var supportService = {
 "Mutil_WMTS": function(url){
        //var wmtsUrl = url+"?SERVICE=WMTS&VERSION=1.0.0&REQUEST=GetCapabilities";
        var newTUrl = Cfg.proxyHostUrl+url;
        //获取服务请求值
        //Cfg.url = url;
        var request = sendAjaxRequest(newTUrl,dataChange);
//            var format = new  Geo.Format.WMTSCapabilities();
        var doc = request.responseXML;
        var jsonOnj = xmlToJson(doc);
        var versionArr = [];
        if (jsonOnj.Versions) {
            var versions = jsonOnj.Versions.Version;
            if(versions instanceof Array) {
                for (var i = 0; i < versions.length; i++) {
                    var versionObj = {};
                    var extendedAttributes = [];
                    var versionContents = versions[i].VersionContent;
                    if(versionContents instanceof Array) {
                        for(var j = 0; j < versionContents.length; j++) {
                            var attrs = versionContents[j].ExtendedAttributes;
                            extendedAttributes.push(attrs);
                        }
                    }else {
                        var attrs = versionContents.ExtendedAttributes;
                        extendedAttributes.push(attrs);
                    }
                    versionObj.versionName = versions[i].VersionName;
                    versionObj.extendedAttributes = extendedAttributes;
                    versionArr.push(versionObj);
                }
            }else {
                var versionObj = {};
                var extendedAttributes = [];
                var versionContents = versions.VersionContent;
                if(versionContents instanceof Array) {
                    for(var j = 0; j < versionContents.length; j++) {
                        var attrs = versionContents[j].ExtendedAttributes;
                        extendedAttributes.push(attrs);
                    }
                }else {
                    var attrs = versionContents.ExtendedAttributes;
                    extendedAttributes.push(attrs);
                }
                versionObj.versionName = versions.VersionName;
                versionObj.extendedAttributes = extendedAttributes;
                versionArr.push(versionObj);
            }
        }
        return versionArr;
    },
    "OGC_WFS":function(url ){
        var wfsUrl = url+"?SERVICE=WFS&VERSION=1.0.0&REQUEST=GetFeature";
        var newTUrl = Cfg.proxyHostUrl+wfsUrl;
        debugger;
        //获取服务请求值
        Cfg.url = url;
        var request = sendAjaxRequest(newTUrl,dataChange);
        closeLoadingCapabilities();
        var doc = request.responseXML;
        var json = xmlToJson(doc);
        if (!doc || !doc.documentElement) {
            doc = request.responseText;
        }
        if(!doc){
            alert("服务不可用!");
            return;
        }

        var capabilities = json.WMT_MS_Capabilities;
        var Layer = capabilities.Capability.Layer.Layer;
        var request_service =capabilities.Capability.Request;
        var layers;
        if(Layer.length){
            layers = Layer[0];
        }else{
            layers = Layer;
        }
        Cfg.version = capabilities.attributes.version;
        Cfg.format = request_service.GetMap.Format[1].text;
        Cfg.layer = layers.Title.text;
        Cfg.bbox = layers.BoundingBox.attributes.SRS;

        Cfg.maxExtent = capabilities.Capability.Layer.LatLonBoundingBox.attributes;

    },
    "OGC_GeoCoder": function(url){
        var url = url;
        var datas;
        $.ajax({
            url: url,
            dataType:"json",
            cache:false,
            async:false,
            success : function(data) {
                datas = data;
            }
        });
        return datas;
    },
    "Reference_WMTS": function(url){
        var wmtsUrl = url+"?SERVICE=WMTS&VERSION=1.0.0&REQUEST=GetCapabilities";
        var newTUrl = Cfg.proxyHostUrl+wmtsUrl;
        //获取服务请求值
        Cfg.url = url;
        var request = sendAjaxRequest(newTUrl,dataChange);
//            var format = new  Geo.Format.WMTSCapabilities();
        var doc = request.responseXML;
        var json = xmlToJson(doc);
        var jsonOnj = json.Capabilities;
        var capab=doc.getElementsByTagName("Capabilities");
        //content
        var content = capab[0].getElementsByTagName("Contents");
        //layer
//        var layers =  content[0].firstElementChild.children;
        var docStr = request.responseText;
        if (!doc || !doc.documentElement) {
            doc = request.responseText;
        }
        if(content === undefined) {
            alert("服务不可用!");
            return;
        }
        var layers = jsonOnj.Contents.Layer;

        Cfg.version = jsonOnj.attributes.version;
        Cfg.layer = layers.Title.text;
        Cfg.LayerIdentifier = layers.Identifier.text;
        Cfg.StyleIdentifier =  layers.Style.Identifier.text;
        Cfg.MatrixSet = layers.TileMatrixSetLink[0].TileMatrixSet.text;
    },
    "OGC_WMTS": function(url,commonStr,id){
        var wmtsUrl = url+"?SERVICE=WMTS&VERSION=1.0.0&REQUEST=GetCapabilities";
        var newTUrl = Cfg.proxyHostUrl+wmtsUrl;
        //获取服务请求值
        Cfg.url = url;
        var request = sendAjaxRequest(newTUrl,dataChange);
        closeLoadingCapabilities();
//            var format = new  Geo.Format.WMTSCapabilities();
        var doc = request.responseXML;
        var json = xmlToJson(doc);
        var jsonOnj = json.Capabilities;
        var capab=doc.getElementsByTagName("Capabilities");
        //content
        var content = capab[0].getElementsByTagName("Contents");
        //layer
//        var layers =  content[0].firstElementChild.children;
        var docStr = request.responseText;
        if (!doc || !doc.documentElement) {
            doc = request.responseText;
        }
        if(content === undefined) {
            alert("服务不可用!");
            return;
        }
        var layers = jsonOnj.Contents.Layer;
//            alert(layers);

        Cfg.version = jsonOnj.attributes.version;
        var contents = jsonOnj.Contents;
        Cfg.layer = layers.Title.text;
        Cfg.LayerIdentifier = layers.Identifier.text;
        Cfg.StyleIdentifier =  layers.Style.Identifier.text;
        Cfg.MatrixSet = layers.TileMatrixSetLink[0].TileMatrixSet.text;
        Cfg.Format = layers.Format[1].text;
//            var TileFullExtent =  layer.bounds.left+ "," + layer.bounds .bottom + "," + layer.bounds .right + "," +layer.bounds .top;;
        var Scales = "";
        var matrixs = contents.TileMatrixSet[0].TileMatrix;
        if(matrixs.length > 0) {
//							for(var i = 0; i < matrixs.length; i++) {
            for(var i=0, len=matrixs.length; i<len; i++) {
                if(i == len){
                    break;
                }
                Scales += (matrixs[i].ScaleDenominator.text + ",");
            }
        }
        Cfg.Scales =  Scales.substr(0,Scales.length - 1);
        Cfg.zoomOffset = matrixs[0].Identifier.text;
        var topLevel = matrixs[0].Identifier;
        var bottomLevel = matrixs[matrixs.length - 1].Identifier;
        var projection = contents.TileMatrixSet[0].SupportedCRS;
        if(id != null && id.indexOf("geoWMTS_Url") >= 0){//二维视图(地图图层)->多时相WMTS图层
            $("#Cfg_geoWMTS_LayerIdentifier").val(Cfg.LayerIdentifier);
            $("#Cfg_geoWMTS_Layer").val(Cfg.layer);
            $("#Cfg_geoWMTS_LayerStyle").val(Cfg.StyleIdentifier);
            $("#Cfg_geoWMTS_LayerMatrixSet").val(Cfg.MatrixSet);
            $("#Cfg_geoWMTS_Format").val(Cfg.Format);
            $("#Cfg_mapWMTS__version").val(Cfg.version);
            $("#Cfg_geoWMTS_ZoomOffset").val(Cfg.zoomOffset);
            $("#Cfg_geoWMTS_Scales").val(Cfg.Scales);
        }
    },
    "OGC_WMS": function(id, url ){
        var wmsUrl = url+"?SERVICE=WMS&VERSION=1.1.1&REQUEST=GetCapabilities";
        var newTUrl = Cfg.proxyHostUrl+wmsUrl;
        //获取服务请求值
        Cfg.url = url;
        var request = sendAjaxRequest(newTUrl,dataChange);
        closeLoadingCapabilities();
        var doc = request.responseXML;
        var json = xmlToJson(doc);
        if (!doc || !doc.documentElement) {
            doc = request.responseText;
        }
        if(!doc){
            alert("服务不可用!");
            return;
        }

        var capabilities = json.WMT_MS_Capabilities;
        var Layer = capabilities.Capability.Layer.Layer;
        var request_service =capabilities.Capability.Request;
        var layers;
        if(Layer.length){
            layers = Layer[0];
        }else{
            layers = Layer;
        }
        Cfg.version = capabilities.attributes.version;
        Cfg.format = request_service.GetMap.Format[1].text;
        Cfg.layer = layers.Title.text;
        Cfg.bbox = layers.BoundingBox.attributes.SRS;

        Cfg.maxExtent = capabilities.Capability.Layer.LatLonBoundingBox.attributes;

//						var LayerIdentifier = layer.identifier;
//						var StyleIdentifier = layer.styles[0].identifier;
//						var MatrixSet = layer.tileMatrixSetLinks[0].tileMatrixSet;
//						var Cfg_map2DWMSLayer_project_JS = srs;
//						var Cfg_map2DWMSLayer_order_JS;
        //二维视图(地图图层)-->WMS图层(墨卡托投影)
        if(id.indexOf("mapWMS_Mercator_Url") >= 0){
            $("#Cfg_mapWMS_Mercator_version").val(Cfg.version);
            $("#Cfg_mapWMS_Mercator_Format").val(Cfg.format);
            $("#Cfg_mapWMS_Mercator_LayerIdentifier").val(Cfg.layer);
            $("#Cfg_geoWMS_Layer").val(Cfg.layer);
//                        $("#Cfg_mapWMS_Mercator_sertype").val("");
            $("#Cfg_mapWMS_Mercator_Projection").val(Cfg.bbox);
//                        $("#Cfg_mapWMS_Mercator_order").val("");
            //	$("#Cfg_mapWMS_Mercator_TopTileExtent").val("");
//                        $("#Cfg_mapWMS_Mercator_TileFullExtent").val(Cfg.maxExtent);
            $("#Cfg_mapWMS_Mercator_Unit").val("m");
        }
    },
    "OGC_VTS": function(id, url ){
        var x = Cfg.proxyHostUrl;
        var wmsUrl = url+"?SERVICE=WMTS&VERSION=1.0.0&REQUEST=GetCapabilities";
        var newTUrl = Cfg.proxyHostUrl+wmsUrl;
        //获取服务请求值
        Cfg.url = url;
        var request = sendAjaxRequest(newTUrl,dataChange);
        closeLoadingCapabilities();
        var doc = request.responseXML;
        var json = xmlToJson(doc);
        if (!doc || !doc.documentElement) {
            doc = request.responseText;
        }
        if(!doc){
            alert("服务不可用!");
            return;
        }

        var capabilities = json.Capabilities;
        var layers;
        if(capabilities.Contents.Layer.length){
            layers = capabilities.Contents.Layer[0];
        }else{
            layers = capabilities.Contents.Layer;
        }
        var request_service =capabilities.OperationsMetadata.Operation[4].attributes.name;
        var style_service = capabilities.OperationsMetadata.Operation[1].attributes.name;

        Cfg.version = capabilities.attributes.version;
        Cfg.format = layers.Format[4].text;
        Cfg.layer = layers.Title.text;
        Cfg.LayerIdentifier = layers.Identifier.text;
        Cfg.StyleIdentifier =  layers.Style.Identifier.text;
        Cfg.MatrixSet = layers.TileMatrixSetLink[0].TileMatrixSet.text;
        //Cfg.bbox = layers.BoundingBox.attributes.SRS;
        var Scales = "";
        var matrixs = capabilities.Contents.TileMatrixSet[0].TileMatrix;
        if(matrixs.length > 0) {
            for(var i=0, len=matrixs.length; i<len; i++) {
                if(i == len){
                    break;
                }
                Scales += (matrixs[i].ScaleDenominator.text + ",");
            }
            Cfg.Scales =  Scales.substr(0,Scales.length - 1);
            Cfg.zoomOffset = matrixs[0].Identifier.text;
        }else if(matrixs){
            Scales += (matrixs.ScaleDenominator.text + ",");
            Cfg.Scales =  Scales.substr(0,Scales.length - 1);
            Cfg.zoomOffset = matrixs.Identifier.text;
        }
        //Cfg.Scales =  Scales.substr(0,Scales.length - 1);
        //Cfg.zoomOffset = matrixs[0].Identifier.text;
        Cfg.styleUrl = url+"?SERVICE=WMTS&VERSION=1.0.0&REQUEST=GetStyle";
        //二维视图(地图图层)-->VTS图层
        if(id.indexOf("Cfg_geoVTS_Url") >= 0){
            $("#Cfg_geoVTS_Version").val(Cfg.version);
            $("#Cfg_geoVTS_Format").val(Cfg.format);
            $("#Cfg_geoVTS_LayerIdentifier").val(Cfg.LayerIdentifier);
            $("#Cfg_geoVTS_LayerStyle").val(Cfg.StyleIdentifier);
            $("#Cfg_geoVTS_LayerMatrixSet").val(Cfg.MatrixSet);
            $("#Cfg_geoVTS_ZoomOffset").val(Cfg.zoomOffset);
            $("#Cfg_geoVTS_Scales").val(Cfg.Scales);
        }
    },
    "Arcgis_WMS": function(id, url ){
        var wmsUrl = url+"?SERVICE=WMS&REQUEST=GetCapabilities";
        var newTUrl = Cfg.proxyHostUrl+wmsUrl;
        //获取服务请求值
        Cfg.url = url;
        var request = sendAjaxRequest(newTUrl,dataChange);
        closeLoadingCapabilities();
	var doc = request.responseXML;
        var json = xmlToJson(doc);
        if (!doc || !doc.documentElement) {
            doc = request.responseText;
        }
        if(!doc){
            alert("服务不可用!");
            return;
        }
        var capabilities = json.WMS_Capabilities;
        var Layer = capabilities.Capability.Layer.Layer;
        var layers;
        if(Layer.length){
            layers = Layer[0];
        }else{
            layers = Layer;
        }
        Cfg.version = capabilities.attributes.version;
        Cfg.format ="image/png";
        Cfg.layer = layers.Name.text;
        Cfg.bbox = layers.BoundingBox[0].attributes.CRS;
        //二维视图(地图图层)-->ArcGISWMS图层
        if(id.indexOf("mapWMS_ArcGIS_Url") >= 0){
            $("#Cfg_mapWMS_ArcGIS_version").val(Cfg.version);
            $("#Cfg_mapWMS_ArcGIS_Format").val(Cfg.format);
            $("#Cfg_mapWMS_ArcGIS_LayerIdentifier").val(Cfg.layer);
            $("#Cfg_geoWMS_ArcGIS_Layer").val(Cfg.layer);
            $("#Cfg_mapWMS_ArcGIS_Projection").val(Cfg.bbox);
            $("#Cfg_mapWMS_ArcGIS_Unit").val("m");
        }
    },
    "Arcgis_WMTS": function(id, url ){
        var wmsUrl = url+"/1.0.0/WMTSCapabilities.xml";
        var newTUrl = Cfg.proxyHostUrl+wmsUrl;
        //获取服务请求值
        Cfg.url = url;
        var request = sendAjaxRequest(newTUrl,dataChange);
        closeLoadingCapabilities();
        var doc = request.responseXML;
        var json = xmlToJson(doc);
        if (!doc || !doc.documentElement) {
            doc = request.responseText;
        }
        if(!doc){
            alert("服务不可用!");
            return;
        }
        var jsonOnj = json.Capabilities;
        var layers = jsonOnj.Contents.Layer;
        Cfg.version = jsonOnj.attributes.version;
        var contents = jsonOnj.Contents;
        Cfg.layer = layers.Title.text;
        Cfg.LayerIdentifier = layers.Identifier.text;
        Cfg.StyleIdentifier =  layers.Style.Identifier.text;
        Cfg.MatrixSet = layers.TileMatrixSetLink[0].TileMatrixSet.text;
        Cfg.Format = layers.Format.text;
        var Scales = "";
        var matrixs = contents.TileMatrixSet[0].TileMatrix;
        if(matrixs.length > 0) {
            for(var i=0, len=matrixs.length; i<len; i++) {
                if(i == len){
                    break;
                }
                Scales += (matrixs[i].ScaleDenominator.text + ",");
            }
        }
        Cfg.Scales =  Scales.substr(0,Scales.length - 1);
        Cfg.zoomOffset = matrixs[0].Identifier.text;
        var topLevel = matrixs[0].Identifier;
        var bottomLevel = matrixs[matrixs.length - 1].Identifier;
        var projection = contents.TileMatrixSet[0].SupportedCRS;
        //二维视图(地图图层)->多时相WMTS图层
        if(id.indexOf("Cfg_geoWMTS_ArcGIS_Url") >= 0) {
            $("#Cfg_geoWMTS_ArcGIS_LayerIdentifier").val(Cfg.LayerIdentifier);
            $("#Cfg_geoWMTS_ArcGIS_Layer").val(Cfg.layer);
            $("#Cfg_geoWMTS_ArcGIS_LayerStyle").val(Cfg.StyleIdentifier);
            $("#Cfg_geoWMTS_ArcGIS_LayerMatrixSet").val(Cfg.MatrixSet);
            $("#Cfg_geoWMTS_ArcGIS_Format").val(Cfg.Format);
            $("#Cfg_mapWMTS_ArcGIS_version").val(Cfg.version);
            $("#Cfg_geoWMTS_ArcGIS_ZoomOffset").val(Cfg.zoomOffset);
            $("#Cfg_geoWMTS_ArcGIS_Scales").val(Cfg.Scales);
        }
    }
};


// 加载状态
function loadingCapabilities(){
    var loading = $("#serviceLoading");
    loading.css("top", document.documentElement.clientHeight/2 - 50);
    loading.css("right", document.documentElement.clientWidth/2 - 100);
    if ("none" == loading.css("display")) {
        loading.show();
    }
    else {
        loading.hide();
    }
}

function closeLoadingCapabilities(){
    var loading = $("#serviceLoading");
    loading.hide();
}

//服务解析
function getXMLHttpRequestObject(){
    try{
        xmlRequest = new XMLHttpRequest(); //Firefox ,safari
    }catch(e){
        //IE
        try{
            xmlRequest = new ActiveXObject("Msxml2.XMLHTTP");
        }catch(e){
            xmlRequest = new ActiveXObject("Microsoft.XMLHTTP");
        }
    }
    return xmlRequest;
}

function sendAjaxRequest(url,callBackMethod){
    xmlRequest = getXMLHttpRequestObject();
    xmlRequest.onreadystatechange = callBackMethod;
    xmlRequest.open("GET",url,false);
    xmlRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset=UTF-8');
    xmlRequest.send(url);
    return xmlRequest;
}
function  dataChange(){
    if(xmlRequest.readyState==4){
        if(xmlRequest.status==200){
            if(xmlRequest.responseXML){
                parseXML(xmlRequest.responseXML);//已经可以正常接受数据
            }else{
                window.alert("您所请求的服务有异常。");
            }
            //return xmlRequest;
        }else { //页面不正常
            window.alert("您所请求的服务有异常。");
        }
    }
}
function  parseXML(capabilities){
    var contents = capabilities.contents;

}
var test = function(){
    var wmtsUrl = "http://192.168.31.113:9010/wwww/wmts?SERVICE=WMTS&REQUEST=GetCapabilities";
    var newTUrl = "http://127.0.0.1/Geo/proxy?url="+wmtsUrl;
    sendAjaxRequest(newTUrl,dataChange)
};

function xmlToJson(xml) {
    // Create the return object
    var obj = {};
    if (xml.nodeType == 1) { // element
        // do attributes
        if (xml.attributes.length > 0) {
            obj["attributes"] = {};
            for (var j = 0; j < xml.attributes.length; j++) {
                var attribute = xml.attributes.item(j);
                obj["attributes"][attribute.nodeName] = attribute.nodeValue;
            }
        }
    } else if (xml.nodeType == 3) { // text
        obj = xml.nodeValue;
    }
    // do children
    if (xml.hasChildNodes()) {
        for(var i = 0; i < xml.childNodes.length; i++) {
            var item = xml.childNodes.item(i);
            var nodeName = item.nodeName.replace('ows:','');
            nodeName = nodeName.replace('#','');
            if (typeof(obj[nodeName]) == "undefined") {
                obj[nodeName] = xmlToJson(item);
            } else {
                if (typeof(obj[nodeName].push) == "undefined") {
                    var old = obj[nodeName];
                    obj[nodeName] = [];
                    obj[nodeName].push(old);
                }
                obj[nodeName].push(xmlToJson(item));
            }
        }
    }
    return obj;
}

