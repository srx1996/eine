//默认获取艾因直播间信息,时间间隔为60-120s
var globalRoomId = 21403601
$(function () {
    getLiveInfo(globalRoomId)
    btnClick()
    setTime()
})

//设置定时器 每60秒获取直播间信息
function setTime() {
    let time
    try {
        time = setInterval(function () {
            getLiveInfo(globalRoomId)
        }, 30000);
    } catch (e) {
        console.log(e)
        clearInterval(time);
    }
}

//绑定按钮点击事件 跳转链接
function btnClick() {
    $(".btn").each(function (i, e) {
        $(e).click(function () {
            $.get("/go/" + $(this).attr("url-type"), function (data, status) {
                if (data.code !== 0) {
                    alert(data.msg)
                    return
                }
                window.location.href = data.eineUrl.linkUrl
            })
        })
    })
}

//获取直播间状态
function getLiveInfo(roomId) {
    console.log("获取直播间信息...")
    $.get("/live-info/" + roomId, function (data, status) {
        // var info = JSON.stringify(data.eineLive);
        updateLiveInfo(data.eineLive)
    })
}

//更新状态
function updateLiveInfo(info) {
    var $headImg = $(".head-img")
    console.log(info)
    if (info.live_status === 0) {
        $headImg.removeClass("head-img-rotate head-img-active head-img-playback")
        $headImg.addClass("head-img-off")
    } else if (info.live_status === 1) {
        $headImg.removeClass("head-img-off head-img-playback")
        $headImg.addClass("head-img-active head-img-rotate")
    } else if (info.live_status === 2) {
        $headImg.removeClass("head-img-off head-img-active")
        $headImg.addClass("head-img-playback head-img-rotate")
    }
    $(".room-title").text(info.title)
}