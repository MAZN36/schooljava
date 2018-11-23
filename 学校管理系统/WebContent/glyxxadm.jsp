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
.layui-btns {width: 100px;height: 32px;line-height: 32px;position:relative;float:right;border-radius: 20px;}
.divtable{width:1145px;margin:auto;margin-top:-5px;}
.input{width:275px;}
</style>
</head>
<body>  
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">管理员管理</a></li>
    <li><a href="#">管理员信息</a></li>
    </ul>
    </div>
    <div class="rigtop">
    	<div class="layui-form-item layui-form">
   		<div class="layui-inline">
		姓名:
		<div class="layui-inline" style="width:190px">
		    <input class="layui-input" name="name" id="demoReload" autocomplete="off"> 
		</div>
		<div class="layui-inline">
		    <button class="layui-btn layui-btns layui-btn-normal" id="snamesele" data-type="getCheckData" >模糊查询</button>
		</div>
  		</div>
    </div>
    </div>
    <div class="divtable">
<table id="demo" lay-filter="demo" lay-filter="test"></table>
</div>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script type="text/html" id="sexTpl">
  {{#  if(d.admin_State ==="可用"){ }}
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="shangjia" style="background-color: #5cb85c">使用中</a>
  {{#  } else { }}
     <a class="layui-btn layui-btn-danger layui-btn-xs"lay-event="xiajia"  style="background-color: #7266BA">不可用</a>
  {{#  } }}
</script>
<script>
var table=null;
var form=null;
layui.use(['table','form'], function(){
	table= layui.table;
	form=layui.form;
  //第一个实例
  table.render({
    elem: '#demo'
    ,height: 471
    ,page:true
    ,url: 'Administrator?action=select' //数据接口
    ,cols: [[ //表头
    	{type:'numbers', title: '序号'}
      ,{field: 'admin_Name', title: '姓名',align:'center'}
      ,{field: 'admin_Account', title: '账号',align:'center'}
      ,{field: 'admin_State', title: '状态',align:'center',templet : '#sexTpl',}
      ,{field: 'admin_Note', title: '备注',align:'center'}
      ,{field: 'right', title: '操    作', align:'center', toolbar: '#barDemo'}
    ]]
  ,id:"idsw"
  });
})
</script>
<script>
layui.use('table', function(){
  var table = layui.table;
  //监听工具条
  table.on('tool(demo)', function(obj){
    var data = obj.data;
  	 if(obj.event === 'del'){
  		 if(data.admin_Account=="manager"){
  			layer.msg("默认管理员不能修改!");
  			return;
  		 }
      layer.confirm('真的删除行么', function(index){
        layer.close(index);
        $.ajax({
			type : "get",
			url : "Administrator?action=delete",
			async : true,
			data : {
			"Admin_id" : data.admin_id
			},
			success : function(data) {
				if (data>0) {
					layer.msg("修改成功");
					//重载
    				table.reload('idsw', {
    			        page: {
    			          curr: 1 //重新从第 1 页开始
    			        }
    				});
				} else
					layer.msg("修改失败");
			}
		});
      });
    } 
    else if(obj.event === 'shangjia'){
    	if(data.admin_Account=="manager"){
  			layer.msg("默认管理员不能修改!");
  			return;
  		 }
		$.ajax({
			type : "get",
			url : "Administrator?action=update",
			async : true,
			data : {
			"Admin_id" : data.admin_id,
			"Admin_State" :"不可用"
			},
			success : function(data) {
				if (data>0) {
					layer.msg("修改成功");
					//重载
    				table.reload('idsw', {
    			        page: {
    			          curr: 1 //重新从第 1 页开始
    			        }
    				});
				} else
					layer.msg("修改失败");
			}
		});
	}
	else if(obj.event === 'xiajia'){
		if(data.admin_Account=="manager"){
  			layer.msg("默认管理员不能修改!");
  			return;
  		 }
		$.ajax({
			type : "get",
			url : "Administrator?action=update",
			async : true,
			data : {
				"Admin_id" :data.admin_id,
				"Admin_State" :"可用"
			},
			success : function(data) {
				if (data > 0) {
					layer.msg("修改成功");
					//重载
    				table.reload('idsw', {
    			        page: {
    			          curr: 1 //重新从第 1 页开始
    			        }
    				});
				} else
					layer.msg("修改失败");
			}
		});
	}
  	 
  });
});
</script>
</body>
</html>