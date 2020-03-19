function queryVideo() {
    var dom = document.getElementById("queryVid");
    var myChart = echarts.init(dom);
    var videoName = $("#videoName option:selected").val()
    var danwei = 2
    if(videoName==""){
        alert("请选择视频名称")
        return;
    }
    var obj={};
    obj.videoName =videoName;
    obj.danwei =danwei;
    $.ajax({
        //请求方式
        type : "POST",
        //请求的媒体类型
        contentType: "application/json;charset=UTF-8",
        //请求地址
        url : "/queryVideo",
        //数据，json字符串
        data : JSON.stringify(obj),
        //请求成功
        success : function(result) {
            vm.hour=[];
            vm.playNum=[];
            vm.isComment=[];
            vm.isForward=[];
            vm.isLike=[];
            if(result.map.length>0){
                $.each(result.map,function(index, item){
                    vm.hour[index]=item.hour;
                    vm.playNum[index]=item.cnt;
                    vm.isComment[index]=item.comment;
                    vm.isForward[index]=item.forward;
                    vm.isLike[index]=item.isLike;


                })
            }
            myChart.setOption({        //加载数据图表
                xAxis: {
                    axisLine: {
                        lineStyle: {
                            // 设置x轴颜色
                            color: '#912CEE'
                        }
                    },
                    // 设置X轴数据旋转倾斜
                    axisLabel: {
                        interval: 0  //设置X轴数据间隔几个显示一个，为0表示都显示
                    },
                    data: vm.hour
                },
                series: [
                    {
                        name: '视频播放量',
                        type: 'line',
                        stack: '总量',
                        smooth:true,
                        data: vm.playNum
                    },
                    {
                        name: '视频评论量',
                        type: 'line',
                        stack: '总量',
                        smooth:true,
                        data: vm.isComment
                    },
                    {
                        name: '视频转发量',
                        type: 'line',
                        stack: '总量',
                        smooth:true,
                        data: vm.isForward
                    },
                    {
                        name: '视频点赞量',
                        type: 'line',
                        stack: '总量',
                        smooth:true,
                        data: vm.isLike
                    }

                ]
            });

        },
        //请求失败，包含具体的错误信息
        error : function(e){
            console.log(e.status);
            console.log(e.responseText);
        }
    });


};
function queryVideoDay() {
    var dom = document.getElementById("queryVidDay");
    var myChartDay = echarts.init(dom);
    var videoName = $("#videoNameDay option:selected").val()
    var danwei = 1
    if(videoName==""){
        alert("请选择视频名称")
        return;
    }
    var obj={};
    obj.videoName =videoName;
    obj.danwei =danwei;
    $.ajax({
        //请求方式
        type : "POST",
        //请求的媒体类型
        contentType: "application/json;charset=UTF-8",
        //请求地址
        url : "/queryVideo",
        //数据，json字符串
        data : JSON.stringify(obj),
        //请求成功
        success : function(result) {
            vm.hour=[];
            vm.playNum=[];
            vm.isComment=[];
            vm.isForward=[];
            vm.isLike=[];
            if(result.map.length>0){
                $.each(result.map,function(index, item){
                    vm.hour[index]=item.hour;
                    vm.playNum[index]=item.cnt;
                    vm.isComment[index]=item.comment;
                    vm.isForward[index]=item.forward;
                    vm.isLike[index]=item.isLike;


                })
            }
            myChartDay.setOption({        //加载数据图表
                xAxis: {
                    axisLine: {
                        lineStyle: {
                            // 设置x轴颜色
                            color: '#912CEE'
                        }
                    },
                    // 设置X轴数据旋转倾斜
                    axisLabel: {
                        interval: 4  //设置X轴数据间隔几个显示一个，为0表示都显示
                    },
                    data: vm.hour
                },
                series: [
                    {
                        name: '视频播放量',
                        type: 'line',
                        stack: '总量',
                        smooth:true,
                        data: vm.playNum
                    },
                    {
                        name: '视频评论量',
                        type: 'line',
                        stack: '总量',
                        smooth:true,
                        data: vm.isComment
                    },
                    {
                        name: '视频转发量',
                        type: 'line',
                        stack: '总量',
                        smooth:true,
                        data: vm.isForward
                    },
                    {
                        name: '视频点赞量',
                        type: 'line',
                        stack: '总量',
                        smooth:true,
                        data: vm.isLike
                    }

                ]
            });

        },
        //请求失败，包含具体的错误信息
        error : function(e){
            console.log(e.status);
            console.log(e.responseText);
        }
    });


}
function queryVideoMonth() {
    var dom = document.getElementById("queryVidMonth");
    var myChartMonth = echarts.init(dom);
    var videoName = $("#videoNameMonth option:selected").val()
    var danwei = 3
    if(videoName==""){
        alert("请选择视频名称")
        return;
    }
    var obj={};
    obj.videoName =videoName;
    obj.danwei =danwei;
    $.ajax({
        //请求方式
        type : "POST",
        //请求的媒体类型
        contentType: "application/json;charset=UTF-8",
        //请求地址
        url : "/queryVideo",
        //数据，json字符串
        data : JSON.stringify(obj),
        //请求成功
        success : function(result) {
            vm.hour=[];
            vm.playNum=[];
            vm.isComment=[];
            vm.isForward=[];
            vm.isLike=[];
            if(result.map.length>0){
                $.each(result.map,function(index, item){
                    vm.hour[index]=item.hour;
                    vm.playNum[index]=item.cnt;
                    vm.isComment[index]=item.comment;
                    vm.isForward[index]=item.forward;
                    vm.isLike[index]=item.isLike;


                })
            }
            myChartMonth.setOption({        //加载数据图表
                xAxis: {

                    axisLine: {
                        lineStyle: {
                            // 设置x轴颜色
                            color: '#912CEE'
                        }
                    },
                    // 设置X轴数据旋转倾斜
                    axisLabel: {
                        interval: 0  //设置X轴数据间隔几个显示一个，为0表示都显示
                    },
                    data: vm.hour
                },
                series: [
                    {
                        name: '视频播放量',
                        type: 'line',
                        stack: '总量',
                        smooth:true,
                        data: vm.playNum
                    },
                    {
                        name: '视频评论量',
                        type: 'line',
                        stack: '总量',
                        smooth:true,
                        data: vm.isComment
                    },
                    {
                        name: '视频转发量',
                        type: 'line',
                        stack: '总量',
                        smooth:true,
                        data: vm.isForward
                    },
                    {
                        name: '视频点赞量',
                        type: 'line',
                        stack: '总量',
                        smooth:true,
                        data: vm.isLike
                    }

                ]
            });

        },
        //请求失败，包含具体的错误信息
        error : function(e){
            console.log(e.status);
            console.log(e.responseText);
        }
    });

}
function searchHive() {
    alert("过程较慢，请耐心等待")
    $.ajax({
        //请求方式
        type : "POST",
        //请求的媒体类型
        contentType: "application/json;charset=UTF-8",
        //请求地址
        url : "/searchHive",
        //数据，json字符串

        //请求成功
        success : function(result) {
            alert("分析完成,请手动刷新页面")
        },
        //请求失败，包含具体的错误信息
        error : function(e){
            console.log(e.status);
            console.log(e.responseText);
        }
    });
}