layui.define(['jquery'], function (exports) {
    var $1 = layui.jquery;
    var table = layui.table;
    var layer = layui.layer;
    var setter = layui.setter;
    var laydate = layui.laydate;
    var tableQuery = layui.tableQuery;
    var admin = layui.admin;
    var laytpl = layui.laytpl;
    var form = layui.form;
    var pageScaffolding=layui.pageScaffolding;
    var columnArr = [];  //用于存储编辑后的数据表格对象
    // 数据表格对象
    var dynamichHeads = {};


    /**
     *   数据表格可编辑，置顶，上移，下移等操作
     * @param t
     */
     //设置置顶
   var  setHot=function(t){
        var bar = 'showAndHide_box';
        //var obj = $(t).parents('.'+bar).clone(true);
        //$(t).parents('.'+bar).remove();
        var obj = $(t).parents('.'+bar);//操作自己，不在克隆
        $(".showAndHide_list_box").prepend(obj);
    };
    //设置上移
    var setUp= function(t){
        var bar = 'showAndHide_box';
        if($(t).parents('.'+ bar).prev('.'+bar).html() != undefined){
           // var obj = $(t).parents('.'+bar).clone(true);
            var obj = $(t).parents('.'+bar);//操作自己，不在克隆
            $(t).parents('.'+bar).prev().before(obj);
         //   $(t).parents('.'+bar).remove();
        }else{
            layer.msg("已移至最上！")
        }
    };

    //设置下移
   var setDown=function(t){
        var bar = 'showAndHide_box';
        if($(t).parents('.'+bar).next('.'+bar).html() != undefined){
         //   var obj = $(t).parents('.'+bar).clone(true);
            var obj = $(t).parents('.'+bar);//操作自己，不在克隆
            $(t).parents('.'+bar).next().after(obj);
            //$(t).parents('.'+bar).remove();
        }else{
            layer.msg("已移至最下！")
        }
    }


    var obj = {
        /**
         * ldar可编辑表头导出    待优化  暂时不用
         * @param buttonId
         * @param url
         * @param formId
         * @param title
         * @param column
         */
        exportByFormIdEdit:function (buttonId,url,formId,title,column) {
            $1("#"+buttonId).unbind();//解除双页面共用一个导出按钮的绑定事件
            //导出excel试卷排名表
            $1("#"+buttonId).bind("click", function () {
                var criteriass=  pageScaffolding.getQueryCriteria(formId);
                criteriass.title=title
                var equalColumns = criteriass.equalColumns;
                criteriass.equalColumns=[];
                if (title==="当前泄漏"){
                    for (var i=0;i<equalColumns.length;i++){
                        if (equalColumns[i].column != "regionCode") {
                            criteriass.equalColumns.push(equalColumns[i]);
                        }

                    }
                } else {
                    for (var i=0;i<equalColumns.length;i++){
                        if (equalColumns[i].column != "regionCode") {
                            criteriass.equalColumns.push(equalColumns[i]);
                        }

                    }
                }
                // TODO 表头可编辑相关
                if (columnArr.length==0){
                    var dynamichHeads=column
                } else if(columnArr.length==1){
                    var dynamichHeads=column
                }else {
                    var dynamichHeads=columnArr
                }
                var header = "";
                var headerfield = "";
                // 生成字段和表头
                for (var i = 0; i < dynamichHeads.length; i++) {
                    if (dynamichHeads[i].title != undefined && dynamichHeads[i].title != "") {
                        header += dynamichHeads[i].title + ",";
                        headerfield += dynamichHeads[i].field + ",";
                    }
                }
                criteriass.headers = header.substring(0, header.length - 1);
                criteriass.headerFields = headerfield.substring(0, headerfield.length - 1).toLowerCase();

                console.log(criteriass);
                admin.req({
                    url:url,
                    data: criteriass
                    , done: function (result) {
                        if (result.code == 0) {
                            location.href = setter.remoteServiceAddress + result.data.src;
                            layer.msg("导出成功！")
                            columnArr=[]   //导出成功后，清空上次数据表格编辑的数据
                        }
                    }
                });
            });
        },
        /**
         * LDAR导出，通过formID 获取 eqCloumn 和likeCloumn   表头不可编辑
         * @param buttonId
         * @param url
         * @param formId
         * @param headerName
         * @param headerfields
         * @param title
         */
        exportByFormId:function (buttonId,url,formId,headerName,headerfields,title) {
            $1("#"+buttonId).unbind();//解除双页面共用一个导出按钮的绑定事件
            //导出excel试卷排名表
            $1("#"+buttonId).bind("click", function () {
                var criteriass=  pageScaffolding.getQueryCriteria(formId);
                criteriass.title=title
                var equalColumns = criteriass.equalColumns;
                criteriass.equalColumns=[];
                if (title==="当前泄漏"){
                    for (var i=0;i<equalColumns.length;i++){
                        if (equalColumns[i].column != "regionCode") {
                            criteriass.equalColumns.push(equalColumns[i]);
                        }

                    }
                } else {
                    for (var i=0;i<equalColumns.length;i++){
                        if (equalColumns[i].column != "regionCode") {
                            criteriass.equalColumns.push(equalColumns[i]);
                        }

                    }
                }



                console.log(criteriass);
                var header=headerName
                var headerfield=headerfields
                criteriass.headers = header;
                criteriass.headerFields = headerfield;
                var loadindex = layer.load(1);
                admin.req({
                    url:url,
                    data: criteriass
                    , done: function (result) {
                        if (result.code == 0) {
                            location.href = setter.remoteServiceAddress + result.data.src;
                            layer.close(loadindex);
                        }
                    }
                });
            });
        },
        /**  导出全部数据    无表头编辑时 使用
         *
         * @param buttonId    导出按钮的  ID
         * @param url         导出的请求路径
         * @param criterias   数据源（包括Excel的title）
         * @param headerName  Excel导出的列名
         * @param headerfields  对应的字段名
         */
        exportAll:function (buttonId,url,criterias,headerName,headerfields) {
            var criteriass=criterias;
            $1("#"+buttonId).unbind();//解除双页面共用一个导出按钮的绑定事件
            //导出excel试卷排名表
            $1("#"+buttonId).bind("click", function () {
                var header=headerName
                var headerfield=headerfields
                criteriass.headers = header;
                criteriass.headerFields = headerfield;
                admin.req({
                    url:url,
                    data: criteriass
                    , done: function (result) {
                        if (result.code == 0) {
                            location.href = setter.remoteServiceAddress + result.data.src;
                        }
                    }
                });
            });
        },



        /**    表格可排序，置顶
         * @param  btnId            表头标记按钮ID
         * @param column            表格数据源
         * @param elem
         * @param url                查询列表信息URL
         * @param tablewhere        携带参数，可缺省
         */
        showCols:function (btnId,column,elem,url,tablewhere) {
            var dynamichHeads_one = column;//每次点击按钮，所有字段默认全部选中
            var orginCols = column;
            $1("#"+btnId).unbind();//解除双页面共用一个导出按钮的绑定事件
            $1("#"+btnId).bind("click", function () {
              layer.open({
                    type: 1
                    , title: '设置表列'
                    , area: admin.screen() < 2 ? ['80%', '300px'] : ['600px', '500px']
                    , content: colset_win.innerHTML
                });

                for (var j=0;j<orginCols.length;j++) {
                    $1("#headercols").append('<div class="showAndHide_box"> ' +
                        '<h2 class="title clearfix"> ' +
                        '<input name="'+orginCols[j].field+'" lay-skin="primary" title="'+orginCols[j].title+'" type="checkbox" lay-filter="colcheck"> ' +
                        '<a href="javascript:void(0)" class="operation" id="Hot'+[j]+'">置顶</a> ' +
                        '<a href="javascript:void(0)" class="operation" id="up'+[j]+'">上移</a> ' +
                        '<a href="javascript:void(0)" class="operation" id="down'+[j]+'">下移</a> ' +
                        '</h2> ' +
                        '</div>')
                    $1("#headercols #Hot"+[j]).click(function(){
                      setHot(this)
                    });
                    $1("#headercols #up"+[j]).click(function(){
                        setUp(this)
                    });

                    $1("#headercols #down"+[j]).click(function(){
                        setDown(this)
                    });
                }
                form.render("checkbox");
                form.render(null, "component-form-element");
                for (var i = 0; i < dynamichHeads_one.length; i++) {
                    $1('#headercols [name=' + dynamichHeads_one[i].field + ']').attr("checked", true);
                }
                if (dynamichHeads_one.length == column.length) {
                    $1('#allchecked').attr("checked", true);
                } else {
                    $1('#allchecked').attr("checked", false);
                }
                form.render(null, "component-form-element");

                form.on('checkbox(allchecked)', function (data) {
                    if (data.elem.checked) {
                        $1('#headercols input').each(function () {
                            $1(this).next().addClass("layui-form-checked");
                            $1(this).attr("checked", true);
                        });
                    } else {
                        $1('#headercols input').each(function () {
                            $1(this).next().removeClass("layui-form-checked");
                            $1(this).attr("checked", false);
                        });
                    }
                });
                $1('#set_btn').on('click', function () {
                    dynamichHeads = [];
                    var setcols = [];
                    $1('.layui-form-checked').each(function () {
                        var fidldName=   $1(this).prev().attr("name")
                        for (var i = 0; i < column.length; i++) {
                            if (fidldName == column[i].field) {
                                dynamichHeads.push(column[i]);
                                columnArr.push(column[i]);
                            }
                        }

                    });
                    layer.closeAll();
                    setcols.push(dynamichHeads);
                   // console.log(dynamichHeads)
                    table.render({//查询列表信息
                        elem: '#' + elem
                        , url: url
                        , page: true
                        , where: tablewhere
                        , headers: {
                            access_token: layui.data(setter.tableName).access_token
                        }
                        , cols: setcols
                        , skin: 'line'
                        , done: function (res, curr, count) {
                            console.log(dynamichHeads)
                            delete this.where.likeColumns;
                        }
                    });
                });

            });

            return dynamichHeads;//将数据表格对象返回,返回的是编辑过后的数据表格对象
        },

        /**  导出全部数据，表头可升降排序
         *
         * @param buttonId    导出按钮的  ID
         * @param url         导出的请求路径
         * @param criterias   数据源（包括Excel的title）
         * @param column  数据表格对象（可从中获得header ,headerfield）
         */
        columnExportAll:function (buttonId,url,criterias,column) {
            var criteriass=criterias;

            $1("#"+buttonId).unbind();//解除双页面共用一个导出按钮的绑定事件
            //导出excel试卷排名表
            $1("#"+buttonId).bind("click", function () {
                if (columnArr.length==0){
                    var dynamichHeads=column
                } else if(columnArr.length==1){
                    var dynamichHeads=column
                }else {
                    var dynamichHeads=columnArr
                }
                var header = "";
                var headerfield = "";
               // 生成字段和表头
                for (var i = 0; i < dynamichHeads.length; i++) {
                    if (dynamichHeads[i].title != undefined && dynamichHeads[i].title != "") {
                        header += dynamichHeads[i].title + ",";
                        headerfield += dynamichHeads[i].field + ",";
                    }
                }

                criteriass.headers = header.substring(0, header.length - 1);
                criteriass.headerFields = headerfield.substring(0, headerfield.length - 1);
                admin.req({
                    url:url,
                    data: criteriass
                    , done: function (result) {
                        if (result.code == 0) {
                            location.href = setter.remoteServiceAddress + result.data.src;
                            layer.msg("导出成功！")
                            columnArr=[]   //导出成功后，清空上次数据表格编辑的数据
                        }
                    }
                });
            });
        }
    };



    exports('exportAllComponent', obj);
});
