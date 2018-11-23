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
.layui-btns {width: 100px;height: 32px;line-height: 32px;position:relative;top:5px;float:right;border-radius: 20px;background-color:#1E9FFF;}
.divtable{width:1145px;margin:auto;margin-top:-5px;}
.rigtop a{font-size:14px;}
#xzxy{position:relative;top:4px;}
	</style>
	</head>
	<body>  
		<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
		    <li><a href="#">首页</a></li>
		    <li><a href="#">信息查询</a></li>
		    <li><a href="#">课时查询</a></li>
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
		<div class="layui-inline">
	       <label class="layui-form-label" style="width: 28px;">开始</label>
	      <div class="layui-input-inline">
	        <input type="text" name="ksdate" id="date" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
	      </div>
	    </div>
	    <div class="layui-inline">
	      <label class="layui-form-label" style="width: 28px;">结束</label>
	      <div class="layui-input-inline">
	        <input type="text" name="jsdate" id="date" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
	      </div>
	    </div>
		    <button class="layui-btn layui-btns layui-btn-normal" id="snamesele" data-type="getCheckData" >查询</button>
	    </div>
	    </div>
	<div class="divtable">
<table id="demo" lay-filter="demo"  ></table>
</div>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
	<script src="js/layui/layui.js" charset="utf-8"></script>
	<script>
	layui.use('form', function(){
		  form= layui.form;
		  form.on('select(classselect)', function(data){
			  table.render({
				    elem: '#demo'
				    ,height: 471
				    ,page:false
				    ,url: 'Pperiod?action=select' 
				    ,cellMinWidth: 120
				    ,cols: [[ //表头
				    	{type:'numbers', title: '序号'}
					      ,{field: 'cName', title: '班级名称',align:'center'}
					      ,{field: 'course_name', title: '课程名称',align:'center'}
					      ,{field: 'pDate', title: '时间',align:'center'}
					    ]]
					  ,id:"idsw"
					  });
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
		var table=null;
		layui.use(['table','form'], function(){
			table= layui.table;
			form=layui.form;
		  //第一个实例
		  table.render({
		    elem: '#demo'
		    ,height: 430
		    ,url: 'Pperiod?action=select' 
		    ,cellMinWidth: 120 
		    ,page:true
		    ,cols: [[ 
		    	{type:'numbers', title: '序号'}
		      ,{field: 'cName', title: '班级名称',align:'center'}
		      ,{field: 'course_name', title: '课程名称',align:'center'}
		      ,{field: 'pDate', title: '时间',align:'center'}
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