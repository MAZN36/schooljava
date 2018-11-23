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
<script src="js/layui/layui.js" charset="utf-8"></script>
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
.layui-btns {width: 100px;height: 32px;line-height: 32px;position:relative;top:1px;float:right;border-radius: 20px;background-color:#1E9FFF;}
.divtable{width:1145px;margin:auto;margin-top:-5px;}
.input{width:190px;}
.layui-textarea {min-height: 65px;min-width:395px;}
.item {width: 680px;margin-bottom: 15px; clear: both;}
#xzxy{position:relative;top:4px;}
</style>
</head>
<body>  
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">年级管理</a></li>
    <li><a href="#">升学管理</a></li>
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
	   
	    </div>
	    </div>
    <div class="divtable">
<table id="demo" lay-filter="demo" lay-filter="test"></table>
</div>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">详细</a>
</script>

<script>

var table=null;
layui.use('table', function(){
	table= layui.table;
  //第一个实例
  table.render({
    elem: '#demo'
    ,height: 471
    ,page:true
    ,url: 'Sxcalss?action=select' //数据接口
    ,cols: [[ //表头
    	{type:'numbers', title: '序号'}
    	 ,{field: 'studentid', title: '学号',align:'center'}
    	 ,{field: 'sName', title: '姓名',align:'center'}
    	 ,{field: 'sxqbj', title: '升学前班级',align:'center'}
      ,{field: 'cName', title: '升学后班级',align:'center'}
      ,{field: 'zt', title: '状态',align:'center'}
      ,{field: 'sxsj', title: '升学时间',align:'center'}
      ,{field: 'right', title: '操    作', align:'center',  toolbar: '#barDemo'}
    ]]
  });
})
</script>
<script>
layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;
  
  //日期
  laydate.render({
    elem: '#cGtime'
  });
  laydate.render({
    elem: '#date1'
  });
});
</script>

<script>
	//查询班级
	var list=function(){
	$.ajax({
		type:"get",
		url:"Classs?action=selectAll&cGstate=结业",//请求路径
		success:function(data){//请求成功后的事件
				$.each(data.data,function(index,obj){
					var option=$("<option value='"+obj.cid+"'>"+obj.cName+"</option>");
					$("#cName").append(option);
					
				})
			}
		})
		 //layui.form('select').render();
	}
	list();
</script>

</body>
</html>