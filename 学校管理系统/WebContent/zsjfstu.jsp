<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>无标题文档</title>
<meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="js/layui/css/layui.css"  media="all">
  <link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script language="javascript">
$(function(){	
	//导航切换
	$(".imglist li").click(function(){
		$(".imglist li.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>
<style>
th .layui-table-cell,td {text-align:center;}
.rigtop { width: 1143px; height: 40px;border: 1px solid #b7d5df;line-height: 40px;margin:auto;margin-top:5px;}
.layui-btns {width: 100px;height: 32px;line-height: 32px;position:relative;float:right;border-radius: 20px;top:5px}
.divtable{width:1145px;margin:auto;margin-top:-5px;}
.rigtop a{font-size:14px;}
.input{width:275px;}
</style>
</head>
<body>  
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">信息查询</a></li>
    <li><a href="#">个人住宿缴费查询</a></li>
    </ul>
    </div>
    <div class="rigtop">
    
    </div>
<div class="divtable">
<table id="demo" lay-filter="demo" lay-filter="test"></table>
</div>
<script src="js/layui/layui.js" charset="utf-8"></script>
<script>
var table=null;
var form=null;
layui.use(['table','form'], function(){
	table= layui.table;
	form=layui.form;
  //第一个实例
  table.render({
    elem: '#demo'
    ,height: 471
    ,page:true
    ,url: 'Studentinfo?action=select' //数据接口
    ,cellMinWidth: 80
    ,cols: [[ //表头
    	{type:'numbers', title: '序号'}
        ,{field: 'username', title: '姓名'}
        ,{field: 'sex1', title: '班级',  sort: true}
        ,{field: 'city', title: '宿舍号'} 
        ,{field: 'sign', title: '交费日期'}
        ,{field: 'experience', title: '住宿费费',  sort: true}
        ,{field: 'score1', title: '水电费', sort: true}
        ,{field: 'score2', title: '网络费', sort: true}
        ,{field: 'score3', title: '其他费用', sort: true}
        ,{field: 'score4', title: '开票人', sort: true}
        ,{field: 'score5', title: '备注', }
    ]]
  ,id:"idsw"
  });
  
});

</script>



</body>
</html>

</body>
</html>