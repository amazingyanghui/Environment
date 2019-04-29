/**

 @Name：全局配置
 @Author：贤心
 @Site：http://www.layui.com/admin/
 @License：LPPL（layui付费产品协议）

 */

layui.define(['laytpl', 'layer', 'element', 'util'], function(exports){
    exports('setter', {
        container: 'LAY_app' //容器ID
        ,base: layui.cache.base //记录layuiAdmin文件夹所在路径
        ,views: layui.cache.base + 'views/' //视图所在目录
        ,entry: 'index' //默认视图文件名
        ,engine: '.html' //视图文件后缀名
        ,pageTabs: false //是否开启页面选项卡功能

        ,homepageId:-1//首页菜单id
        ,aMapId:"8801bedb88d44cd29d21eac681300701"//一张图菜单id
        ,officialDoc:"25ba5dab7d324244aa1cc06ba4ae3adb"//电子公文菜单id
        ,lawsRegulations:"f65cba0d0b6d456b897656bb59757126"//法律法规菜单id
        ,annulusRoleId:17//系统管理员id（安环部的人id,唯一的，特殊处理）
        ,leadAdmin:[3]//领导层（对于不用看待办事项的特殊处理,角色id）可以多个id【3,14,15】
        ,companyRoleId:"60d73880895149289bc2f634b6ba39cc"//是否企业用户；
        ,administrativeRoleId:"7f476fcaec2b446abe3d91c22f9bbb9b"//是否园区用户；
        ,EPARoleId:"91187b87ad0d4c8ea67679af567b956e"//是否水环局用户；
        ,superAdmin:'1'//超级管理员ID
        ,deptWinSize: ['350px', '400px']//部门选择框大小

        ,stompClient:null

        ,name: '兵团第十二师环保综合监管软件平台'
        ,tableName: 'layuiAdmin' //本地存储表名
        ,permissionName: 'permissionName' //本地存储权限名称
        ,userName:'userName'   //本地存储用户名
        ,userNickName:'userNickName'   //本地存储用户昵称
        ,userId:'userId'    //本地存储用户id
        ,userRoles:'userRoles'  //本地存储用户角色列表
        ,userDeptId:'userDeptId'    //本地存储部门id
        ,userDeptName:'userDeptName'    //本地存储部门
        ,superAdminStore:'superAdminStore'//本地存储超级管理员ID
        ,companyRoleIdStore:'companyRoleIdStore'//本地存储角色ID
        ,remoteServiceAddressStore:'remoteServiceAddressStore'    //本地存储远程地址
        ,MOD_NAME: 'admin' //模块事件名

        ,debug: false //是否开启调试模式。如开启，接口异常时会抛出异常 URL 等信息

        ,remoteServiceAddress:'http://localhost:8080/EnvironmentalProtectionInt'
        ,remoteServiceAddress2:'http://10.32.1.169:8082/tengdi-mysql-generator'
        ,remoteServiceAddress3:'http://localhost:8083/renren-sqlservergenerator'
        ,socketServer:'http://10.32.1.169:9092'
        ,getNetForMapUrl:'http://localhost:8003'//一张图.net接口

        ,getJavaForMapUrl:'http://localhost:8089'//一张图java接口

        ,onlineAirMonitorUrl:'/PictureWebService.asmx/GetDischargeList'//一张图空气质量和水质量检测站下拉框url
        ,onlineAirMonitorFactorUrl:'/PictureWebService.asmx/GetDischargeInfo'//一张图空气质量和水质量根据检测站查出因子数据表的url
        ,onlinePointUrl:'/PictureWebService.asmx/GetMonitorNetWorkCount'//一张图空气质量和水质量联网断网统计url
        ,getOnlineBaseInfoUrl:'/PictureWebService.asmx/GetDischargeCount'//一张图中空气监测站、水类监测站、水在线监控企业、气在线监控企业、水在线监控国控企业、水在线监控非国控企业、气在线监控国控企业、气在线监控非国控企业、水在线监控-污排、水在线监控-雨排、气在线监控 -废气排口、气在线监控 -VOC排口的基本数据url
        ,getWaterWasteTotalUrl:'/PictureWebService.asmx/GetMonitorFactorList'//一张图监测污染物统计（排放口）url
        ,getLDARInfoTotalUrl:'/LdarBackend/api/ldarStatistics/checkStatisticsALL?tdsourcetag=s_pctim_aiomsg'//一张图LDAR后台接口url
        ,getDischargeToUrl:'/PictureWebService.asmx/GetMonitorDischargeDirection'//一张图水排放去向统计（排放口）url
        ,getDischargeTypeUrl:'/PictureWebService.asmx/GetMonitorEmissionLaw'//一张图排放规律统计（排放口）url

        ,interceptor: true //是否开启未登入拦截

        //自定义请求字段
        ,request: {
            tokenName: 'access_token' //自动携带 token 的字段名。可设置 false 不携带。
        }

        //自定义响应字段
        ,response: {
            statusName: 'code' //数据状态的字段名称
            ,statusCode: {
                ok: 0 //数据状态一切正常的状态码
                ,tip: 1 // 数据正常但操作不成功，返回提示信息
                ,invalidToken: -1 //重复token
                ,logout: 1001 //登录状态失效的状态码
            }
            ,msgName: 'msg' //状态信息的字段名称
            ,dataName: 'data' //数据详情的字段名称
        }
        ,clientId : "7103b87abd9e4d9894620629d326988d" //统一认证框架的应用标识
        ,clientSecret : "3d9822f59ab54c369b93bc44a365d8e5"//统一认证框架的应用Key
        ,userAuthenServerAddress : "http://10.32.8.7:2010/"//统一认证服务器地址
        ,loginPage : 'OAuth/Authorize.aspx?client_id=7103b87abd9e4d9894620629d326988d&response_type=code&redirect=http://10.32.8.7:8080/EnvironmentalProtectionFront/start/index.html'//统一认证登录界面
        ,forGetUserInfo : "WebService/OAuthService.asmx/GetUserInfoWithDengLuDaiMa"//获取用户信息
        ,logoutPage: 'OAuth/SignOut.html?redirect=http://10.32.8.7:8080/EnvironmentalProtectionFront/start/index.html'//退出界面
        ,officialDocPage:'http://10.32.8.7:2026/Office/default.aspx'//电子公文页面
        ,lawsRegulationsPage:'http://10.32.8.7:2010/LawRegulation/default.aspx'//法律法规界面
        // ,logoutPageForAdministrative: 'http://10.32.1.26:8003/Intelligence/SignOut.html '//园区用户退出界面
        //独立页面路由，可随意添加（无需写参数）
        ,indPage: [
            '/user/login' //登入页
            ,'/user/nologin'//假登录页面
            ,'/user/callback'//统一认证登录回调页面
            ,'/user/reg' //注册页
            ,'/user/forget' //找回密码
            ,'/template/tips/test' //独立页的一个测试 demo
            ,'/screen/show' //独立页的一个测试 demo
            ,'/screen/showMap'//独立页的一个测试 demo
        ]

        //扩展的第三方模块
        ,extend: [
            'echarts', //echarts 核心包
            'echartsTheme' //echarts 主题
        ]

        ,changeSkin:false//开启换肤功能
        //主题配置
        ,theme: {
            //配色方案，如果用户未设置主题，第一个将作为默认
            color: [{
                main: '#202F4C' //主题色
                ,logo: '#1E345D'
                ,selected: '#3B91FF' //选中色
                ,button: '#009688' //普通列表操作按钮色
                ,winbutton: '#1E9FFF' //弹窗按钮色
                ,alias: 'default' //默认别名
            },{
                main: '#FFAEB9'
                ,logo: '#FF6EB4'
                ,selected: '#FFAEB9'
                ,button: '#FFAEB9' //普通列表操作按钮色
                ,winbutton: '#FFAEB9' //弹窗按钮色
                ,alias: 'girl-pink' //少女粉
            },{
                main: '#A48566'
                ,logo: '#2E241B'
                ,selected: '#A48566'
                ,button: '#A48566' //普通列表操作按钮色
                ,winbutton: '#A48566' //弹窗按钮色
                ,alias: 'coffee' //咖啡
            },{
                main: '#7A4D7B'
                ,logo: '#50314F'
                ,selected: '#7A4D7B'
                ,button: '#7A4D7B' //普通列表操作按钮色
                ,winbutton: '#7A4D7B' //弹窗按钮色
                ,alias: 'purple-red' //紫红
            },{
                main: '#086EBA'
                ,logo: '#086EBA'
                ,selected: '#1E9FFF'
                ,button: '#1E9FFF' //普通列表操作按钮色
                ,winbutton: '#1E9FFF' //弹窗按钮色
                ,alias: 'ocean' //海洋
            },{
                main: '#5FB878'
                ,logo: '#2F9688'
                ,selected: '#5FB878'
                ,button: '#5FB878' //普通列表操作按钮色
                ,winbutton: '#5FB878' //弹窗按钮色
                ,alias: 'green' //墨绿
            },{
                main: '#f7ad28'
                ,logo: '#F78400'
                ,selected: '#f7ad28'
                ,button: '#f7ad28' //普通列表操作按钮色
                ,winbutton: '#f7ad28' //弹窗按钮色
                ,alias: 'red' //橙色
            },{
                main: '#aa655c'
                ,logo: '#AA3130'
                ,selected: '#aa655c'
                ,button: '#aa655c' //普通列表操作按钮色
                ,winbutton: '#aa655c' //弹窗按钮色
                ,alias: 'fashion-red' //时尚红
            },{
                main: '#24262F'
                ,logo: '#3A3D49'
                ,selected: '#009688'
                ,button: '#24262F' //普通列表操作按钮色
                ,winbutton: '#24262F' //弹窗按钮色
                ,alias: 'classic-black' //经典黑
            }]
        }
    });
});
