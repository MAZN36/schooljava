<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>年级信息</title>
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
.layui-btns {width: 100px;height: 32px;line-height: 32px;position:relative;float:right;border-radius: 20px;top:5px}
.divtable{width:1145px;margin:auto;margin-top:-5px;}
.rigtop a{font-size:14px;}
.input{width:275px;}
</style>
</head>
<body>  
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">选课方向管理</a></li>
    <li><a href="#">选课信息</a></li>
    </ul>
    </div>
    <div class="rigtop">
    <button class="layui-btn layui-btn-normal layui-btns"  id="subs">一键备份</button>
    </div>
    <div class="divtable">
<table id="demo" lay-filter="demo" lay-filter="test"></table>
</div>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">还原</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
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
    ,cellMinWidth: 120
    ,url: 'Bf?action=select' //数据接口
    ,cols: [[ //表头
    	{type:'numbers', title: '序号'}
      ,{field: 'bfsj', title: '备份时间',align:'center'}
      ,{field: 'bflq', title: '备份路径',align:'center'}
      ,{field: 'hysj', title: '还原时间',align:'center'}
      ,{field: 'right', title: '操作',align:'center',toolbar: '#barDemo'}
    ]],
  id:"demo"
  }); 
  table.on('tool(demo)', function(obj){
	  var data = obj.data;
	  if(obj.event === 'detail'){
		  layer.confirm('是否还原?', function(index){
				 layer.closeAll();
				 upda(data.id,data.bflq);
			  })
	  }
	  else if(obj.event === 'del'){
		  layer.confirm('是否删除?', function(index){
				 layer.closeAll();
		  del(data.id);
		  })
	  }
	  })
  
});
$("#subs").click(function(){
	$.ajax({
		type:"get"
		,url:"Bf?action=add"
		,data:{sj:times()}
	,success:function(data){
		if(data>0){
			 layer.msg("备份成功",{time: 1000});
			//重载
				table.reload('demo', {
			        page: {
			          curr: 1 //重新从第 1 页开始
			        }
				});
			}
		else{
			layer.msg("备份失败",{time: 1000});
		}
	}
})
})
</script>

<script>
function del(e){
	$.ajax({
		type:"get"
		,url:"Bf?action=delete"
		,data:{Id:e}
	,success:function(data){
		if(data>0){
			 layer.msg("删除成功",{time: 1000});
			//重载
				table.reload('demo', {
			        page: {
			          curr: 1 //重新从第 1 页开始
			        }
				});
			}
		else{
			layer.msg("删除失败",{time: 1000});
		}
	}
})
}
function upda(e,lq){
	$.ajax({
		type:"get"
		,url:"Bf?action=update"
		,data:{Id:e,lq:lq}
	,success:function(data){
		if(data>0){
			 layer.msg("还原成功",{time: 1000});
			//重载
				table.reload('demo', {
			        page: {
			          curr: 1 //重新从第 1 页开始
			        }
				});
			}
		else{
			layer.msg("还原失败",{time: 1000});
		}
	}
})
}
function empty(){
	$("#Tname").val("");
	$("#TMremarks").val("");
}
</script>
		
</body>
</html>