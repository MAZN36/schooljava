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
	}.layui-btns {
		width: 132px;
	    height: 40px;
	    line-height: 40px;
	    position:relative;
		float:right;
	    border-radius: 35px;
	}.input{width:190px;}
	.layui-form-label{width:30px}
	</style>
	</head>
	<body>  
		<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
	    <li><a href="#">首页</a></li>
	    <li><a href="#">信息查询</a></li>
	    <li><a href="#">班级信息查询</a></li>
	    </ul>
	    </div>
	    <div class="rigtop">
	   	<div class="layui-form-item layui-form" >
	    <div class="layui-inline" >
	      <label class="layui-form-label input">班级:</label>
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
	     </div>
		<button class="layui-btn layui-btn-normal layui-btns" data-type="getCheckData">模糊查询</button>
	    </div>
	    </div>
	<table id="demo" lay-filter="test" style="text-align:center"></table>
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
	    ,height: 430
	    ,url: 'Teacher' //数据接口
	    ,cellMinWidth: 80
	    ,page: true
	    ,cols: [[ //表头
	    	{field:'cid', title: '序号',fixed: 'left',align:'center'}
	      ,{field: 'tclassName', title: '班级名称',align:'center'}
	      ,{field: 'state', title: '状态', align:'center'}
	      ,{field: 'grade', title: '学期', align:'center'}
	      ,{field: 'kxtime', title: '开学日期', align:'center'}
	      ,{field: 'jytime', title: '结业日期', align:'center'}
	      ,{field: 'content', title: '备注',width:102, align:'center'}
	      ,{field: 'right', title: '操作', align:'center',  toolbar: '#barDemo'}
	    ]]
	  ,id:"idsw"
	  });
	  
	});
	</script>
</body>
</html>