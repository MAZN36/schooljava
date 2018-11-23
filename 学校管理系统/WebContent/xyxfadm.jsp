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
	.layui-form-label{width:30px}
	
	.layui-btns {
		width: 132px;
	    height: 38px;
	    line-height: 35px;
	    position:relative;
		right:0px;
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
	    <li><a href="#">学员管理</a></li>
	    <li><a href="#">学员学分</a></li>
	    </ul>
	    </div>
	     <div class="rigtop">
	   	<div class="layui-form-item layui-form" >
	    <div class="layui-inline" >
	      <label class="layui-form-label" style="width: 28px;">班级:</label>
	      <div class="layui-input-inline">
	        <select name="quiz" lay-verify="classselect" lay-search="" lay-filter="classselect" id="classselect">
	          <option value="">请选择班级</option>
	        </select>
	      </div>
	    </div>
	 	   姓名：
		<div class="layui-inline" style="width:190px">
		    <input class="layui-input" name="name" id="demoReload" autocomplete="off"> 
		</div>
		<div class="layui-inline">
		    <button class="layui-btn layui-btns layui-btn-normal" id="snamesele" data-type="getCheckData" >模糊查询</button>
		</div>
	    <button class="layui-btn layui-btns layui-btn-normal"  id="xzxy">导出xls</button>
	    </div>
	    </div>
	<table id="demo" lay-filter="test" style="text-align:center"></table>
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
	    ,cellMinWidth: 110
	    ,url: '' //数据接口
	    ,cols: [[ //表头
	    		{type:'checkbox',fixed:'did'}
	    	  ,{field:'cid', title: '序号',fixed: 'left',align:'center',width:'50px'}
		      ,{field: 'sstudentName', title: '学号',align:'center'}
		      ,{field: 'sstudentName', title: '班级',align:'center',}
		      ,{field: 'sstudentName', title: '姓名',align:'center'}
		      ,{field: 'sNumber', title: '性别',align:'center'}
		      ,{field: 'Class', title: '课程', align:'center'}
		      ,{field: 'state', title: '已修学分', align:'center'}
		      ,{field: 'money', title: '备注', align:'center'}
		      ,{field: 'home', title: '操作员', align:'center'}
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