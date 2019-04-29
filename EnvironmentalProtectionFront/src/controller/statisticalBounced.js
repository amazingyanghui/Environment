layui.define(['jquery'], function (exports) {
    var $ = layui.jquery;
    var admin = layui.admin;
    var layer = layui.layer;
    var setter = layui.setter;
    var table = layui.table;
    var statisticalBounced={
        /**
         * 信息统计页面-页头统计数据-统一弹出列表框功能
         * @param element(table的Id),cols(列表框内容例cols)where(条件)，url(请求数据后台url接口),title(弹框标题)
         * @param cols
         * @param where
         * @param url
         * @param title
         */
        bounced:function(element,cols,where,url,title){
            if(title==null || title==""){
                title="列表信息"
            }
            //弹出页面
            layer.open({
                type: 1
                ,title: title
                ,area: ['1100px', '660px']
                // offset: '120px',
                ,content: editCommonTotalData.innerHTML
            });
            table.render({//查询列表信息
                elem: "#"+element
                ,url:  url
                ,page: true
                ,event:true
                ,where: where
                ,headers: {
                    access_token: layui.data(setter.tableName).access_token
                }
                ,cols: cols
                ,skin: 'line'
            });
         }
    };
    exports('statisticalBounced', statisticalBounced);
});