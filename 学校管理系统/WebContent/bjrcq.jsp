<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>班级日出勤统计</title>
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
<body>
<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
		    <li><a href="#">首页</a></li>
		    <li><a href="#">报表管理</a></li>
		    <li><a href="#">班级日出勤统计</a></li>
	    </ul>
    </div>
    <div class="rigtop">
	   	<div class="layui-form-item layui-form" >
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
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" style="width: 28px;">类型:</label>
	      <div class="layui-input-inline">
	        <select name="quiz" id="quiz">
	          <option value="上课">上课</option>
	       	 <option value="自习">自习</option>
	       	 <option value="活动">活动</option>
	       	 <option value="其他">其他</option>
	        </select>
	      </div>
		</div>
		<button class="layui-btn layui-btn-normal layui-btns" data-type="getCheckData">查询</button>
		<button class="layui-btn layui-btn-normal layui-btns" data-type="getCheckData">导出Excel</button>
	    </div>
	   </div>
	<div class="divtable">
<table id="demo" lay-filter="demo" lay-filter="test"></table>
</div>
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
		    ,url: 'Stulnfo' //数据接口
		    ,cellMinWidth: 60
		    ,cols: [[ //表头
		    	{field:'cid', title: '序号',fixed: 'left',align:'center'}
		      ,{field: 'Class', title: '班级', align:'center'}
		      ,{field: 'teacher', title: '班主任', align:'center'}
		      ,{field: 'type', title: '类型', align:'center'}
		      ,{field: 'time', title: '时间', align:'center'}
		      ,{field: 'people', title: '总人数', align:'center'}
		      ,{field: 'ycqrs', title: '应出勤人数', align:'center'}
		      ,{field: 'sjcqrs', title: '实际出勤人数', align:'center'}
		      ,{field: 'cql', title: '出勤率', align:'center'}
		      ,{field: 'cql', title: '出勤率(%)', align:'center'}
		      ,{field: 'cd', title: '迟到', align:'center'}
		      ,{field: 'zt', title: '早退', align:'center'}
		      ,{field: 'kk', title: '旷课', align:'center'}
		      ,{field: 'qj', title: '请假', align:'center'}
		      ,{field: 'right', title: '操作',width:'190', align:'center',  toolbar: '#barDemo'}
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