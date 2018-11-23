<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教员信息</title>
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
		.input{width:192px;}
	</style>
	</head>
	<body>  
		<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
		    <li><a href="#">首页</a></li>
		    <li><a href="#">日常工作</a></li>
		    <li><a href="#">成功就业</a></li>
	    </ul>
   		 </div>
	   <div class="rigtop">
    	<div class="layui-form-item layui-form">
	    <div class="layui-inline" >
	      <label class="layui-form-label" style="width: 28px;">班级:</label>
	      <div class="layui-input-inline">
	        <select name="quiz">
	          <option value="">请选择班级</option>
	          <optgroup label="高一">
	            <option value="你工作的第一个城市">143</option>
	          </optgroup>
	          <optgroup label="高二">
	            <option value="你的工号">144</option>
	            <option value="你最喜欢的老师">134</option>
	          </optgroup>
	        </select>
	      </div>
	 	 <label class="layui-form-label" style="width: 28px;">姓名:</label>
		<div class="layui-inline">
		    <input class="layui-input input" name="name" id="demoReload" autocomplete="off">
		</div>
		</div>
		<button class="layui-btn layui-btn-normal layui-btns" data-type="getCheckData">模糊查询</button>
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
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
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
		    ,height: 462
		    ,url: 'Stulnfo' //数据接口
		    ,cellMinWidth: 120 
		    ,cols: [[ //表头
		    	{field:'cid', title: '序号',fixed: 'left',align:'center'}
		      ,{field: 'sstudentName', title: '姓      名',align:'center'}
		      ,{field: 'studentSex', title: '性      别',align:'center'}
		      ,{field: 'right', title: '出      勤     情     况', align:'center',  toolbar: '#barDemo1'}
		      ,{field: 'right', title: '操作',width:'235', align:'center',  toolbar: '#barDemo'}
		    ]]
		  ,id:"idsw"
		  });
		  
		});
	</script>
	<script>
				layui.use(['form', 'layedit', 'laydate'], function(){
				  var form = layui.form
				  ,layer = layui.layer
				  ,layedit = layui.layedit
				  ,laydate = layui.laydate;
				  
				  //日期
				  laydate.render({
				    elem: '#date'
				  });
				  laydate.render({
				    elem: '#date1'
				  });
				})
	</script>
</body>
</html>