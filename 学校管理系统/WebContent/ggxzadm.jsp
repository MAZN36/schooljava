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
  <script src="js/layui/layui.js" charset="utf-8"></script>
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
</style>
</head>
<body>  
	<div class="place">
    <span>当前位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">上传文件</a></li>
    </ul>
    </div>
     <div class="rigtop" >
      
  <div class="layui-form-item">
    <label class="layui-form-label" style="width:30px">标题</label>
    <div class="layui-input-inline">
      <input type="text" name="text" required lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
     
    </div>
 <button class="layui-btn layui-btn-normal layui-btns" style="float:left"  id="subs" >模糊查询</button>
   <button class="layui-btn layui-btn-normal layui-btns"  id="tzggxs" style="float:right;">上传文件</button>
  </div>
  
  
    </div>
<div class="divtable">
<table id="demo" lay-filter="demo" lay-filter="test"></table>
</div>
 <script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit">修改标题</a>
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
		    ,height: 471
		    ,page:true
    ,url: 'Download?action=select' //数据接口
    ,cellMinWidth: 120 
    ,cols: [[ //表头
    	{type:'numbers', title: '序号'}
      ,{field: 'title', title: '标题',align:'center'}
      ,{field: 'reletime', title: '发布时间',align:'center'}
      ,{field: 'right', title: '操    作', align:'center',  toolbar: '#barDemo'}
    ]]
  ,id:"idsw"
  });
//监听工具条
  table.on('tool(demo)', function(obj){
    var data = obj.data;
   if(obj.event === 'edit'){
  	  $("#titles").val(data.title)
      upda(data.id);
    }
   else if(obj.event === 'del'){
  	    layer.confirm('真的删除行么', function(index){
  	    	del(data.id);
  	      layer.close(index);
  	    });
  	  }
  });
});


</script>
<script>
var lin=null;
var id=times();
layui.use('upload', function(){
	  var $ = layui.jquery,upload = layui.upload;
	//拖拽上传
	  upload.render({
	    elem: '#test10',
	    accept: 'file' //普通文件
		 ,url: 'filesz?Path=wenjian&pas='+ id
	    ,done: function(res){
	    	//如果上传失败
			if (res.code > 0) {return layer.msg('上传失败');}
			//上传成功
			layer.msg(res.msg);
			lin=res.data.name;
			//location.reload();刷新页面
	    }
	  });
	  });
$("#tzggxs").click(function(){
	 var that = this; 
	 layer.open({
			type:1
			,title:"上传文件"
			,content:$("#form11")
			,area:['500px','300px']
		 ,btn: ['添加', '取消'] //只是为了演示
	    ,yes: function(){
	    	$.ajax({
	    		type:"get"
	    		,url:"Download?action=add"
	    		,data:{
	    			Id:id,
	    			Title:$("#titles").val(),
	    			Link:lin,
	    			Relepeople:1
	    			}
	    		,success:function(data){
	    			if(data>0){
	    				alert("添加成功");
	    				//关闭
	    				 layer.closeAll();
	    				//清空
	    				shuax();
	    				}
	    			else{
	    				layer.msg("添加失败",{time: 1000});
	    			}
	    		}
	    	});
			},btn2: function(){
				  layer.closeAll();
				  shuax();
				},cancel: function(index, layero){ 
				//清空
				shuax();
		      	 layer.closeAll();
		      		  return false; 
		      		} 
	 })
	 })
	 function del(e){
		$.ajax({
    		type:"get"
    		,url:"Download?action=delete"
    		,data:{Id:e}
    	,success:function(data){
			if(data>0){
				//关闭
				 layer.closeAll();
				 alert("删除成功");
				//清空
				shuax();
				}
			else{
				layer.msg("删除失败",{time: 1000});
			}
		}
	})
	}
function upda(e){
	layer.open({
		type:1
		,title:"修改作息"
		,content:$("#form12")
		,area:['300px','160px']
	 ,btn: ['修改', '取消'] //只是为了演示
    ,yes: function(){
    	$.ajax({
    		type:"get"
    		,url:"Download?action=update"
    		,data:{Title:$("#tit").val(),Id:e}
    	,success:function(data){
			if(data>0){
				//关闭
				 layer.closeAll();
				layer.msg("修改成功",{time: 1000});
				shuax();
				}
			else{
				layer.msg("修改失败",{time: 1000});
				
			}
		}
	});
}
,btn2: function(){
  layer.closeAll();
  shuax();
}
});
}
	function shuax(){
	location.reload();//刷新页面
	}
</script>
<form  class="layui-form" style="background-color: ghostwhite; margin:auto;" id="form11" hidden="hidden" >
<div class="layui-form-item">
    <label class="layui-form-label" style="width:30px">标题</label>
    <div class="layui-input-inline">
      <input type="text" name="text" id="titles" required lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input"/>
    </div>
    </div>
<div class="layui-upload-drag" style="width:438px;height:85px;margin:auto;"id="test10">
  <i class="layui-icon"></i>
  <p>点击上传，或将文件拖拽到此处</p>
</div>
</form>
<form  class="layui-form" style="background-color: ghostwhite; margin:auto;" id="form12" hidden="hidden" >
<div class="layui-form-item">
    <label class="layui-form-label" style="width:30px">标题</label>
    <div class="layui-input-inline">
      <input type="text" name="text" id="tit" required lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input"/>
    </div>
    </div>
</form>

</body>
</html>