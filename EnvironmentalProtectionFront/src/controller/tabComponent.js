layui.define(['jquery'], function (exports) {
    var $ = layui.jquery;
    var setter = layui.setter;
    var admin = layui.admin;
    var element =layui.element;
    var $tab ;

    /**
     * 创建选项卡对象
     */
    var objTab = {};
    /**
     * Tabobj 用于内部封装生成
     */
    var obj = {
        /**
         * 创建Tab
         * @param divId  // Tab依存div的id
         * @param type   //不同风格的Tab 1:默认样式 2:简洁风格 3:卡片风格
         * @param tabs   //卡片项配置
         */
        createTab:function (divId,type,tabs,contentShow,callback){
            debugger
            objTab.tab =  tabs ;
            if(typeof(tabs)=="object"){
                if(divId != null){
                    /**
                     *  情况一：直接给出创建个数
                     */
                    var layuicard = $("<div>").addClass("layui-card");
                    if(divId){
                        $("#"+divId+"").append(layuicard);
                    }
                    var layuitab = "" ;
                    if (type==null){  //默认样式
                        layuitab = $("<div>").addClass("layui-tab");
                    }else{
                        if(type ==1){
                            layuitab = $("<div>").addClass("layui-tab");
                            layuitab.attr("lay-filter","Demo");
                        }else if(type ==2){
                            layuitab =  $("<div>").addClass("layui-tab layui-tab-card");
                            layuitab.attr("lay-filter","Demo");
                        }else if(type ==3){
                            layuitab = $("<div>").addClass("layui-tab layui-tab-brief");
                            layuitab.attr("lay-filter","Demo");
                        }
                    }
                    layuicard.append(layuitab);
                    var ul = $("<ul>").addClass("layui-tab-title");

                    ul.attr("id","base") ;
                    layuitab.append(ul);

                    var tabArr = [];
                    /**
                     * 情况二 直接将配置好的tab以json数组的配置形式放入参数形式里传过去
                     */
                    if(objTab.tab!=null){

                        for(var i = 0 ; i < objTab.tab.length; i++){
                            var tabobj = tabs[i];
                            var li = $("<li>");
                            li.attr("value",(i)) ;
                            var a = $("<a>").text(tabobj.name);
                            li.append(a);
                            ul.append(li);
                        }
                        if(contentShow){
                            var content_div =  $("<div>").addClass("layui-tab-content");
                            var contentStr = "" ;
                            for(var j = 0 ; j < objTab.tab.length; j++){
                                var content_ = $("<div>").addClass("layui-tab-item");
                                contentStr += '<div class="layui-tab-item">内容3</div>' ;
                            }
                            content_div.append(contentStr);
                            ul.parent().append(content_div);
                        }

                    }else{
                        //不配置选项卡
                        tabArr = tabArrTemp;
                        for(var i = 0 ; i < tabArr.length; i++){
                            var tabobj = tabArr[i];
                            var li = $("<li>");
                            li.attr("value",(i)) ;
                            var a = $("<a>").text(tabobj.name);
                            li.append(a);
                            ul.append(li);
                        }
                        if(contentShow){
                            var content_div =  $("<div>").addClass("layui-tab-content");
                            var contentStr = "" ;
                            for(var j = 0 ; j < tabArr.length; j++){
                                var content_ = $("<div>").addClass("layui-tab-item");
                                contentStr += '<div class="layui-tab-item">内容'+j+'</div>' ;
                            }
                            content_div.append(contentStr);
                            ul.parent().append(content_div);
                        }

                    }
                }
            }else if(typeof(tabs)=="number"){
                debugger
                if(objTab.tab!=null){
                    for(var i = 0 ; i < tabs; i++){
                        var tabobj = tabs[i];
                        var li = $("<li>");
                        li.attr("value",(i)) ;
                        var a = $("<a>").text(tabobj.name);
                        li.append(a);
                        ul.append(li);
                    }
                    var content_div =  $("<div>").addClass("layui-tab-content");
                    var contentStr = "" ;
                    for(var j = 0 ; j < tabs; j++){
                        var content_ = $("<div>").addClass("layui-tab-item");
                        contentStr += '<div class="layui-tab-item">内容'+j+'</div>' ;
                    }
                    content_div.append(contentStr);
                    ul.parent().append(content_div);
                }else{
                    //不配置选项卡
                    tabArr = tabArrTemp;
                    for(var i = 0 ; i < tabArr.length; i++){
                        var tabobj = tabs[i];
                        var li = $("<li>");
                        li.attr("value",(i)) ;
                        //var a = $("<a>").attr("value",(i)).text(tabobj.name);
                        var a = $("<a>").text(tabobj.name);
                        li.append(a);
                        ul.append(li);
                    }
                    var content_div =  $("<div>").addClass("layui-tab-content");
                    var contentStr = "" ;
                    for(var j = 0 ; j < tabArr.length; j++){
                        var content_ = $("<div>").addClass("layui-tab-item").css("height: 100px;");
                        contentStr += '<div class="layui-tab-item">内容'+j+'</div>' ;
                    }
                    content_div.append(contentStr);
                    ul.parent().append(content_div);

                }
                //  alert("直接设置创建个数");
            }

            $("#"+divId+" li").each(function (i) {
                if(i == 0){
                    $(this).trigger('click'); //初始默认点击
                }
            });
            obj.onClicks(callback);
        }
        ,
        /**
         * 点击监听事件回调
         */
        onClicks:function(callback){
            var tabObjs={};
            //回调函数
            element.on('tab(Demo)', function(data){
                debugger
                if (callback!=undefined) {
                    tabObjs.value = data.elem.context.value;
                    tabObjs.self = this ;
                    tabObjs.index = data.index ;
                    tabObjs.elem =  data.elem ;
                   // return tabObjs;


                    //callback(tabObjs);
                    console.log("当前Tab标题所在的原始DOM元素 == "+this); //当前Tab标题所在的原始DOM元素
                    console.log("得到当前Tab的所在下标  == "+data.index); //得到当前Tab的所在下标
                    console.log("得到当前的Tab大容器 =="+data.elem); //得到当前的Tab大容器
                    console.log("活动当前点击的li值 ==" +data.elem.context.value);

                    callback(tabObjs);

                }
            });
            //return tabObjs ;
        }
    };
    exports('tabComponent', obj);

})