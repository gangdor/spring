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
function display(input){
	Highcharts.chart('container', {
	    chart: {
	        type: 'variablepie'
	    },
	    title: {
	        text: '2016, 2015 범죄 소분류에 의한 총합'
	    },
	    tooltip: {
	        headerFormat: '',
	        pointFormat: '<span style="color:{point.color}">\u25CF</span> <b> {point.name}</b><br/>' +
	            'Area (square km): <b>{point.y}</b><br/>' +
	            'Population density (people per square km): <b>{point.z}</b><br/>'
	    },
	    series: [{
	        minPointSize: 10,
	        innerSize: '20%',
	        zMin: 0,
	        name: 'countries',
	       	data : input
	        
	    }]
	});
}
$(document).ready(function(){
	// Server에 데이터를 요청한다.
	// AJAX로
	$.ajax({
		url:'chart2impl.do',
		success:function(data){
			alert(data);
			display(data);
		},
		error:function(){
			alert("돌아가세요");
		}
	});
	/* var datas = [
		{name:'덕춘',y:3245,z:70.5},
		{name:'순자',y:3245,z:70.5},
		{name:'말숙',y:3245,z:70.5},
		{name:'말자',y:3245,z:70.5},
		{name:'창렬',y:3245,z:70.5},
		{name:'지훈',y:3245,z:70.5},
		{name:'경민',y:3245,z:70.5},
		{name:'경휘',y:3245,z:70.5},
		{name:'미경',y:3245,z:70.5},
		{name:'한필',y:3245,z:70.5},
		];
	alert(datas);
	display(datas); */
});
</script>
<div id="main_center">
<h1>Main Center</h1>
<div id="container" style="min-width: 300px; height: 400px; margin: 0 auto"></div>
</div>


