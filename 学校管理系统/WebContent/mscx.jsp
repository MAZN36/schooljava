<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>面试查询</title>
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
	</style>
	</head>
<body><div class="place" >
    <span>位置：</span>
    <ul class="placeul">
   <li><a href="home.jsp">首页</a></li>
     <li><a href="#">信息查询</a></li>
    <li><a href="#">面试安排查询</a></li>
    </ul>
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
		    ,url: 'Stulnfo' //数据接口
		    ,cellMinWidth: 100
		    ,cols: [[ //表头
		    	{field:'cid', title: '序号',fixed: 'left',align:'center'}
		      ,{field: 'sstudentName', title: '姓名',align:'center'}
		      ,{field: 'Class', title: '班级', align:'center'}
		      ,{field: 'state', title: '企业名称', align:'center'}
		      ,{field: 'money', title: '面试职位', align:'center'}
		      ,{field: 'home', title: '面试时间', align:'center'}
		      ,{field: 'academic', title: '面试结果', align:'center'}
		      ,{field: 'idcart', title: '推荐老师',width:102, align:'center'}
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