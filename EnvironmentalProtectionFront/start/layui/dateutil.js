var dateutil = {
    getCurDate:function(){
        var myDate = new Date();
        var month = myDate.getMonth()+1;
        var monthnew = (month) < 10? "0"+month.toString():month.toString();
        var hour = myDate.getHours();
        var minute = myDate.getMinutes();
        var second = myDate.getSeconds()
        var datetemp = myDate.getFullYear() + '-' + monthnew + '-'+ myDate.getDate()+" "+ hour +":" + minute +":"+second;
        return datetemp;
    }
}