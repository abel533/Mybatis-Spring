function ajax(method, url, async, datas, headers, success, failure) {
    var xmlhttp;
    if (window.XMLHttpRequest) {
        // code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
    }
    else {
        // code for IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    if (async) {
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4) {
                if (xmlhttp.status == 200) {
                    success(xmlhttp.responseText);
                } else {
                    failure(xmlhttp.responseText);
                }
            }
        }
    }

    xmlhttp.open(method, url, async);
    if (headers != undefined) {
        for (header in headers) {
            xmlhttp.setRequestHeader(header, headers[header]);
        }
    }
    //TODO 这里需要测试能否直接传js对象
    var data = '';
    if (datas != undefined) {
        for (d in datas) {
            if (data != '') {
                data = data + '&';
            }
            data = data + d + '=' + datas[d];
        }
    }
    try {
        if (data != '') {
            xmlhttp.send(data);
        } else {
            xmlhttp.send();
        }
    } catch (err) {
        failure(err);
    }

    if (!async) {
        if (xmlhttp.readyState == 4) {
            if (xmlhttp.status == 200) {
                success(xmlhttp.responseText);
            } else {
                failure(xmlhttp.responseText);
            }
        }
    }
}

function ajaxOptions(options) {
    //method, url, async, datas, headers, success, failure
    if (!('method' in options)) {
        options.method = 'GET';
    }
    if (!('success' in options)) {
        options.success = function (data) {
        };
    }
    if (!('async' in options)) {
        options.async = true;
    }
    if (!('failure' in options)) {
        options.failure = function (data) {
        };
    }
    ajax(options.method, options.url, options.async, options.datas, options.headers, options.success, options.failure);
}

function ajaxGet(options) {
    options.method = 'GET';
    ajaxOptions(options);
}

function ajaxPost(options) {
    options.method = 'POST';
    ajaxOptions(options);
}