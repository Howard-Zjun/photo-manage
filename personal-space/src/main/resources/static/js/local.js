function getCookie(name) {
    var cookieObj = {},
        cookieSplit = [],
        // 以分号（;）分组
        cookieArr = document.cookie.split(";");
    for (var i = 0, len = cookieArr.length; i < len; i++)
        if (cookieArr[i]) {
            // 以等号（=）分组
            cookieSplit = cookieArr[i].split("=");
            // Trim() 是自定义的函数，用来删除字符串两边的空格
            cookieObj[cookieSplit[0].trim()] = cookieSplit[1].trim();
        }
    return cookieObj[name];
}