layui.define(['jquery'], function (exports) {
    var $ = layui.jquery;
    var setter = layui.setter;
    var socketServer = setter.socketServer;
    var socket;
    var obj = {
        /**
         * 与socket服务器建立长连接
         * @param callback
         */
        connect: function (callback) {
            socket = io.connect(socketServer);
            socket.on('connect', function () {
                // 发送登录消息
                socket.emit('onLogin', setter.userId);
                if (callback) {
                    callback();
                }
            });
        },
        /**
         * 断开连接操作
         * @param callback
         */
        disconnect: function (callback) {
            socket.on('disconnect', function () {
                if (callback) {
                    callback();
                }
            });
        },
        /**
         * 系统消息监听器，如接收到新消息弹出提示框等
         * @param callback
         */
        addSysListener: function (callback) {
            socket.on('sysMessage', function (data) {
                if (callback) {
                    callback(data);

                }
            });
        },
        /**
         * 添加监听器，获取
         * @param event
         * @param action
         */
        addListener: function (event, action) {
            socket.on(event, function (data) {
                if (action) {
                    action(data);
                }
            });
        },
        /**
         * 发送消息
         * @param event
         * @param message
         */
        sendMessage:function (event,message) {
            socket.emit(event, message);
        }

    };
    exports('socketIo', obj);
});
