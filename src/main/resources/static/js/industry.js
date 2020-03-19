$(function() {
    var dom = document.getElementById("container3");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;
    option = {
        color: ['#3398DB'],
        tooltip: {
            trigger: 'axis',
            axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis : [
            {
                type: 'category',
                z: 10,
                boundaryGap : false,
                axisLine: {
                    onZero: false,
                    lineStyle: {
                        color: '#09a9a0'
                    }
                },
                data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
            }
        ],

        yAxis : [
            {
                type : 'value',
                axisLine: {
                    onZero: false,
                    lineStyle: {
                        color: '#4b87a9'
                    }
                },
                splitLine: { //网格线
                    show: false
                }
            }
        ],
        series: [{
            data: vm.week,
            name: '播放量',
            barWidth: '40%',
            type: 'bar'
        }]
    };


    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }
});