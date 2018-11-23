<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>专业方向选择结果</title>
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
	    <li><a href="#">专业选择结果</a></li>
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
	      <label class="layui-form-label" style="width: 28px;">姓名:</label>
			<div class="layui-inline">
		   	 <input class="layui-input input" name="name" id="demoReload" autocomplete="off">
			</div>
		</div>
		<button class="layui-btn layui-btn-normal layui-btns" data-type="getCheckLength">导出Excel</button>
		<button class="layui-btn layui-btn-normal layui-btns" data-type="getCheckData">模糊查询</button>
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
	    ,height: 462
	    ,page: true //开启分页
	    ,url: 'Direction?action=select' //数据接口
	    ,cellMinWidth: 130 
	    ,cols: [[ //表头
	    	{type:'numbers', title: '序号'}
	        ,{field: 'cName', title: '班级',align:'center'}
	        ,{field: 'sName', title: '姓名',align:'center'}
	        ,{field: 'ssex', title: '性别',align:'center'}
	        ,{field: 'dfirstchoice', title: '第一志愿',align:'center'}
	        ,{field: 'dsecondchoice', title: '第二志愿',align:'center'}
	        ,{field: 'ddate', title: '日期',align:'center'}
	        ,{field: 'right', title: '操作',width:'190', align:'center',  toolbar: '#barDemo'}
	    ]]
	  ,id:"idsw"
	  });
	  $.ajax({
			type:"get",
			url:"Classs?action=selectAll",//请求路径
			success:function(data){//请求成功后的事件
					$.each(data.data,function(index,obj){
						var option=$("<option value='"+obj.cId+"'>"+obj.cName+"</option>");
						$("#classselect").append(option);
						form.render(); 
					})
				}
			})
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