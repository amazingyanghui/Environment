;(function(){
    var scripts = document.getElementsByTagName("script"), src = scripts[0].src,
        queryStr = src.substring(src.indexOf("?")+1),
        getQueryString = function (name){
            var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"),
                r = queryStr.match(reg);
            if(r!=null)return  unescape(r[2]); return null;
        };
    var key = "TDTpluginNew";
    document.write("<link rel=\"stylesheet\" href=\"" + key + "/GeoGlobeJavaScriptSDK/Javascript/Mapbox/css/mapbox-gl.css\" type=\"text/css\"/>");
    document.write("<link rel=\"stylesheet\" href=\"" + key + "/GeoGlobeJavaScriptSDK/Javascript/GeoGlobe/mapcss.css\" type=\"text/css\"/>");
    document.write("<link rel=\"stylesheet\" href=\"" + key + "/GeoGlobeJavaScriptSDK/Javascript/GeoGlobe/mutilprash.css\" type=\"text/css\"/>");
    document.write("<link rel=\"stylesheet\" href=\"" + key + "/GeoGlobeJavaScriptSDK/Javascript/Mapbox/css/mapbox-gl-draw.css\" type=\"text/css\"/>");
    document.write("<script type=\"text/javascript\" src=\"" + key + "/GeoGlobeJavaScriptSDK/OpenLayers/OpenLayers-min.js\"></script>");
    document.write("<script type=\"text/javascript\" src=\"" + key + "/GeoGlobeJavaScriptSDK/Javascript/Mapbox/mapbox-gl.js\"></script>");
    document.write("<script type=\"text/javascript\" src=\"" + key + "/GeoGlobeJavaScriptSDK/Javascript/Mapbox/mapbox-gl-draw-0.18.1.js\"></script>");
    document.write("<script type=\"text/javascript\" src=\"" + key + "/GeoGlobeJavaScriptSDK/Javascript/Mapbox/turf.min.js\"></script>");
    document.write("<script type=\"text/javascript\" src=\"" + key +"/GeoGlobeJavaScriptSDK/Javascript/GeoGlobe/GeoGlobeJS.debug.js\"></script>");
    document.write("<script type=\"text/javascript\" src=\"" + key +"/GeoGlobeJavaScriptSDK/Javascript/GeoGlobe/NJserver.js\"></script>");
    document.write("<script type=\"text/javascript\" src=\"" + key +"/GeoGlobeJavaScriptSDK/Javascript/GeoGlobe/serverconfig.js\"></script>");
    document.write("<script type=\"text/javascript\" src=\"" + key +"/GeoGlobeJavaScriptSDK/Javascript/jQuery/jquery-1.11.2.min.js\"></script>");
    document.write("<script type=\"text/javascript\" src=\"" + key +"/GeoGlobeJavaScriptSDK/Javascript/GeoGlobe/geoglobe.js\"></script>");
})()