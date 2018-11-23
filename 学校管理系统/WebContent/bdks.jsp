<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>补登课时</title>
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
.input{width:275px;}
</style>
	</head>
<body><div class="place" >
    <span>位置：</span>
    <ul class="placeul">
   <li><a href="home.jsp">首页</a></li>
     <li><a href="#">信息维护</a></li>
    <li><a href="#">补登课时</a></li>
    </ul>
</div>
	 <div class="rigtop">
	   	<div class="layui-form-item layui-form" >
		  <button class="layui-btn layui-btn-normal layui-btns"  id="delete">删除</button>
	      <button class="layui-btn layui-btn-normal layui-btns"  id="insert">添加</button>
		</div>
	 </div>
	<div class="divtable">
<table id="demo" lay-filter="demo" lay-filter="test"></table>
</div>
 <script type="text/html" id="barDemo1">
<form>
    <input type="radio" name="{{d.id}}" value="正常" title="正常" checked >
     <input type="radio" name="{{d.id}}" value="迟到" title="迟到">
      <input type="radio" name="{{d.id}}" value="旷课" title="旷课">
      <input type="radio" name="{{d.id}}" value="请假" title="请假">
</form>
</script>
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
		    ,height: 230
		    ,url: 'Stulnfo' //数据接口
		    ,cellMinWidth: 100
		    ,cols: [[ //表头
		    	{field:'cid', title: '序号',fixed: 'left',align:'center'}
		        ,{field: 'Class', title: '上课日期',align:'center'}
		        ,{field: 'studentName', title: '班级名称',align:'center'}
		        ,{field: 'studentSex', title: '课时名称',align:'center'}
		        ,{field: 'Phone', title: '课时进度',align:'center'}
		        ,{field: 'one', title: '上课时间',align:'center'}
		        ,{field: 'two', title: '上课地点',align:'center'}
		        ,{field: 'right', title: '操作',width:'190', align:'center',  toolbar: '#barDemo'}
		    ]]
		  ,id:"idsw"
		  });
		});
		
	</script>
</body>
</html>