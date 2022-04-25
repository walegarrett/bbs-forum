//js 函数
function formatDate(date) {
    var d = new Date(date),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();
    if (month.length < 2) month = '0' + month;
    if (day.length < 2) day = '0' + day;
    return [year, month, day].join('-');
}
//js 函数
function formatDateHourAndMinute(date) {
    var d = new Date(date);
    var hour = '' + d.getHours();
    var minute = '' + d.getMinutes();
    if(hour.length<2)
        hour='0'+hour;
    if(minute.length<2)
        minute='0'+minute;
    return [hour, minute].join(':');
}
//获取json数组长度
function getJsonLength(jsonData){
    var jsonLength = 0;
    for(var item in jsonData){
        jsonLength++;
    }
    return jsonLength;
}

