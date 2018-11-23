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
	.rigtop {
	    width: 100%;
	    height: 40px;
	    border-bottom: 1px solid #b7d5df;
	    line-height: 40px;
	}.layui-btn {
		width: 150px;
	    height: 40px;
	    line-height: 40px;
	    float:right;
	}
	.input{width:190px;}
	.layui-form-label{width:30px}
	.layui-btns {
		width: 132px;
	    height: 38px;
	    line-height: 35px;
	    border-radius: 35px;
	     background-color:#1E9FFF;
	}
	
	</style>
	</head>
	<body>  
		<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
	    <li><a href="#">首页</a></li>
	    <li><a href="#">信息查询</a></li>
	    <li><a href="#">学员信息查询</a></li>
	    </ul>
	    </div>
	    <div class="rigtop">
	   	<div class="layui-form-item layui-form" >
	    <div class="layui-inline" >
	      <label class="layui-form-label"  >班级:</label>
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
	 	 <label class="layui-form-label"  >姓名:</label>
		<div class="layui-inline input">
		    <input class="layui-input" name="name" id="demoReload" autocomplete="off">
		</div>
		</div>
		 <div class="layui-inline" >
		<label class="layui-form-label"  >性别:</label>
	      <div class="layui-input-inline">
	        <select>
	          <option value="">请选择性别</option>
	            <option value="1">男</option>
	            <option value="2">女</option>
	        </select>
	      </div>
		 </div>
	    <button class="layui-btn layui-btns" data-type="getCheckData">模糊查询</button>
	    </div>
	    </div>
	<table id="demo" lay-filter="test" style="text-align:center"></table>
	<script type="text/html" id="barDemo">
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
	    ,height: 430
	    ,url: 'Stulnfo' //数据接口
	    ,cellMinWidth: 70 
	    ,cols: [[ //表头
	    	{field:'cid', title: '序号',fixed: 'left',align:'center'}
		      ,{field: 'sstudentName', title: '学号',align:'center'}
		      ,{field: 'sstudentName', title: '班级',align:'center'}
		      ,{field: 'sstudentName', title: '姓名',align:'center'}
		      ,{field: 'sNumber', title: '性别',align:'center'}
		      ,{field: 'Class', title: '出生日期', align:'center'}
		      ,{field: 'state', title: '民族', align:'center'}
		      ,{field: 'idcart', title: '电话', align:'center'}
		      ,{field: 'phone', title: '家长姓名', align:'center'}
		      ,{field: 'homePhone', title: '家长电话', align:'center'}
		      ,{field: 'sstudentName', title: '籍贯',align:'center'}
		      ,{field: 'sstudentName', title: '入学日期',align:'center'}
	      ,{field: 'right', title: '操作',width:'178', align:'center',  toolbar: '#barDemo'}
	    ]]
	  ,id:"idsw"
	  });
	  
	});
	$("#subs").click(function(){
		// 遍历所有的table数据  
	    $('table tbody').each(function (data) { 
	          $("td[data-field=right] div input:checked").each(function(){
	        	 //获取学号和状态
	        	console.log("学号:"+$(this).attr("name")+"   出勤情况:"+$(this).val()+"   上课类型:"+$("#quiz").val());
	        })   
	           return false;    
	       });  
	})
	</script>
</body>
</html>