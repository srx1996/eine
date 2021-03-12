//默认获取艾因直播间信息,时间间隔为60-120s
var globalRoomId = 21403601

var user = {
    user: {
        uid: 421267475,
        uname: "艾因Eine",
        face: "https://i0.hdslb.com/bfs/face/627b9390be6481d4a88ff1e4808a7d7f8b6b3bbe.jpg"
    },
    item: {
        rp_id: 500538692726868825,
        uid: 421267475,
        content: "🎩老时间21点见！ 我端了一碗螺蛳粉在房间里，我很后悔……",
        ctrl: "",
        orig_dy_id: 0,
        pre_dy_id: 0,
        timestamp: 1615379146,
        reply: 33
    }
}


$(function () {
    setTimeout(function () {
        getUrlList()
        getLiveInfo(globalRoomId)
        setTime()
        bindUpdateDetailsInfo(["#last-time", "#startup-time", "#hot-val", "#attention-val"])
    }, 200)
})

//获取所有url并渲染成按钮
function getUrlList() {
    $.get("/all/url", function (data, status) {
        $.each(data.urlList, function (i, e) {
            var el = `<div>
                        <button url-type=${e.webUri} type="button" class="btn btn-lg" style="background-color:${e.color}">
                            ${e.description}
                        </button>
                      </div>`
            $(".nav-btn").append($(el))
        })
        $(".btn-loading").remove()
        bindBtnClick()
    })
}

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
function bindBtnClick() {
    $(".btn").each(function (i, e) {
        $(e).on("click", function () {
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
        //闲置
        $headImg.removeClass("head-img-rotate head-img-active head-img-playback")
        $headImg.addClass("head-img-off")
        //人气值
        $($("#hot-val").children()[1]).text(0)
        //开播时间
        $($("#startup-time").children()[1]).text("未开播")
    } else if (info.live_status === 1) {
        //直播中
        $headImg.removeClass("head-img-off head-img-playback")
        $headImg.addClass("head-img-active head-img-rotate")
        //人气值
        $($("#hot-val").children()[1]).text(info.online)
        //开播时间
        $($("#startup-time").children()[1]).text(info.live_time)
    } else if (info.live_status === 2) {
        //回放
        $headImg.removeClass("head-img-off head-img-active")
        $headImg.addClass("head-img-playback head-img-rotate")
        //人气值
        $($("#hot-val").children()[1]).text(0)
        //开播时间
        $($("#startup-time").children()[1]).text("回放中")
    }
    //标题
    $(".room-title").text(info.title)
    //关注
    $($("#attention-val").children()[1]).text(info.attention)
    if (info.last_time === null || info.last_time === "" || info.last_time === undefined || info.last_time === "0000-00-00 00:00:00") {
        $($("#last-time").children()[1]).text("无记录")
    } else {
        $($("#last-time").children()[1]).text(info.last_time)
    }

}

//绑定直播信息详细事件
function bindUpdateDetailsInfo(elementArr) {
    $(elementArr).each(function (i, e) {
        var $e = $(e);
        $e.mouseover(function (event) {
            event.stopPropagation()
            $($(this).children()[0]).fadeOut(0)
            $($(this).children()[1]).fadeIn(0)
        })
        $e.mouseout(function (event) {
            event.stopPropagation()
            $($(this).children()[1]).fadeOut(0)
            $($(this).children()[0]).fadeIn(0)
        })
    })
}