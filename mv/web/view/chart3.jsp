<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<style>
#main_center{
	margin:0 20px;
	width:760px;
	height:480px;
	background:white;
}
</style>    
<script>
function display(input, input2){
	Highcharts.chart('container', {
	    chart: {
	        type: 'column'
	    },
	    title: {
	        text: '각 도시 별 인구 10만명 당 범죄율'
	    },
	    subtitle: {
	        text: '클릭시 상세 범죄 항목을 조회할 수 있습니다'
	    },
	    xAxis: {
	        type: 'category'
	    },
	    yAxis: {
	        title: {
	            text: '도시별 범죄 건의 총합 / 도시인구'
	        }

	    },
	    legend: {
	        enabled: false
	    },
	    plotOptions: {
	        series: {
	            borderWidth: 0,
	            dataLabels: {
	                enabled: true,
	                format: '{point.y:.1f}'
	            }
	        }
	    },
	    tooltip: {
	        headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
	        pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}</b> of total<br/>'
	    },
	    "series": [
	        {
	            "name": "Browsers",
	            "colorByPoint": true,
	            "data": input
	         }
	    ],
	    "drilldown": {
	        "series": input2
	    }
	});
}

$(document).ready(function(){
	// Server에 데이터를 요청한다.
	// AJAX로
	$.ajax({
		url:'chart3impl.do',
		success:function(data){
			alert("잠시만요");
			$.ajax({
				url:'chart3impl2.do',
				success:function(data2){
					alert("눌러주세요");
					display(data, data2);
				},
				error:function(){
					alert('fail');
				}
			});
		},
		error:function(){
			alert('fail');
		}
	});
	
});
</script>
<div id="main_center">
<h1>Main Center</h1>
<div id="container" style="min-width: 300px; height: 400px; margin: 0 auto"></div>
</div>


