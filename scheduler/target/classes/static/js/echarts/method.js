//折线图
function mycharts(x,y){
	var dom = document.getElementById("showEcharts");
	var myChart = echarts.init(dom);
	var app = {};
	option = null;
	option = {
		xAxis : {
			type : 'category',
			data : x
		},
		yAxis : {
			type : 'value'
		},
		series : [ {
			data : y,
			type : 'line'
		} ]
	};
	if (option && typeof option === "object") {
		myChart.setOption(option, true);
	}
}