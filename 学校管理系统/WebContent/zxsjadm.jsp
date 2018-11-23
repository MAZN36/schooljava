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
.layui-btns {width: 100px;height: 32px;line-height: 32px;position:relative;float:right;border-radius: 20px;top:5px}
.divtable{width:1145px;margin:auto;margin-top:-5px;}
.rigtop a{font-size:14px;}
.input{
	width:500px;
}
</style>
</head>
<body>  
	<div class="place">
    <span>当前位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">作息时间</a></li>
    </ul>
    </div>
      <div class="rigtop" >
      数据进行输出时是按照序号从小到大，请根据需要进行排序!</a>
  <button class="layui-btn layui-btn-normal mar layui-btns"  id="subs" style="width:150px;float:right">添加作息</button>
    </div>
 <div class="divtable">
<table id="demo" lay-filter="demo"></table>
</div>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
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
    ,url: 'Worktime?action=selectAll' //数据接口
    ,cols: [[ //表头
    	{field: 'serial', title: '序号'}
      ,{field: 'interval', title: '时段',align:'center'}
      ,{field: 'section', title: '节序',align:'center'}
      ,{field: 'wtime', title: '时间',align:'center'}
      ,{field: 'wnote', title: '备注',align:'center'}
      ,{field: 'right', title: '操作', align:'center',  toolbar: '#barDemo'}
    ]]
  ,id:"idsw"
  });
//监听工具条
  table.on('tool(demo)', function(obj){
    var data = obj.data;
   if(obj.event === 'edit'){
	   $("#serial").val(data.serial),
	   $("#interval").val(data.interval),
	   $("#section").val(data.section),
	   $("#wtime").val(data.wtime),
	   $("#wnote").val(data.wnote)
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
//添加操作
$("#subs").click(function(){
	layer.open({
		type:1
		,title:"添加作息"
		,content:$("#form")
		,area:['700px','350px']
	 ,btn: ['添加', '取消'] //只是为了演示
    ,yes: function(){
    	$.ajax({
    		type:"get"
    		,url:"Worktime?action=add"
    		,data:{
    	Serial:$("#serial").val(),
    	Interval:$("#interval").val(),
    	Section:$("#section").val(),
    	Wtime:$("#wtime").val(),
    	WNote:$("#wnote").val()
    			}
    		,success:function(data){
    			if(data.code==3){
    				alert(data.msg);
    				window.parent.index();
    			}
    			else if(data>0){
    				//关闭
    				 layer.closeAll();
    				layer.msg("添加成功",{time: 1000});
    				location.reload();//刷新页面
    				//清空
    				empty();
    				}
    			else{
    				layer.msg("添加失败",{time: 1000});
    			}
    		}
    	});
    }
    ,btn2: function(){
      layer.closeAll();
      empty();
    },cancel: function(index, layero){ 
    	 layer.closeAll();
         empty();
 		  return false; 
 		} 
	});
	});
	
	
	function del(e){
		$.ajax({
    		type:"get"
    		,url:"Worktime?action=delete"
    		,data:{Id:e}
    	,success:function(data){
    		if(data.code==3){
				alert(data.msg);
				window.parent.index();
			}
			else if(data>0){
				//关闭
				 layer.closeAll();
				layer.msg("删除成功",{time: 1000});
				location.reload();//刷新页面
				
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
		,content:$("#form")
		,area:['700px','350px']
	 ,btn: ['修改', '取消'] //只是为了演示
    ,yes: function(){
    	$.ajax({
    		type:"get"
    		,url:"Worktime?action=update"
    		,data:{
    	Serial:$("#serial").val(),
    	Interval:$("#interval").val(),
    	Section:$("#section").val(),
    	Wtime:$("#wtime").val(),
    	WNote:$("#wnote").val(),
    	Id:e
    			}
    	,success:function(data){
			if(data>0){
				//关闭
				 layer.closeAll();
				layer.msg("修改成功",{time: 1000});
				location.reload();//刷新页面
				//清空
				empty();
				}
			else{
				layer.msg("修改失败",{time: 1000});
			}
		}
	});
}
,btn2: function(){
  layer.closeAll();
  location.reload();//刷新页面
},cancel: function(index, layero){ 
	 layer.closeAll();
	  location.reload();//刷新页面
		  return false; 
		} 
});
}
	function empty(){
		 $("#form").attr("hidden","hidden").css("display","none");
		$("#serial").val("");
		$("#interval").val("");
		$("#section").val("");
		$("#wtime").val("");
		$("#wnote").val("");
		
	}
</script>
<form class="layui-form" style="background-color: ghostwhite;width:700px;height:250px" id="form" hidden="hidden">
<br>
		<div class="layui-form-item">
			    <label class="layui-form-label" style="font-size:15px" >序号:</label>
			      <div class="layui-input-inline">
			        <input type="text" name="serial" id="serial"  maxlength="8" onkeyup="value=value.replace(/[^\d]/g,'')" required lay-verify="required" placeholder="序号" autocomplete="off" class="layui-input">   
			      </div>
  		
			    <label class="layui-form-label" style="font-size:15px" >时段:</label>
			      <div class="layui-input-inline">
			        <input type="text" name="interval" id="interval"  maxlength="8" required lay-verify="required" placeholder="时段" autocomplete="off" class="layui-input">   
			      </div>
  			</div>
  	<div class="layui-form-item">
			    <label class="layui-form-label" style="font-size:15px" >节序:</label>
			      <div class="layui-input-inline">
			        <input type="text" name="section" id="section"  maxlength="8" required lay-verify="required" placeholder="节序" autocomplete="off" class="layui-input">   
			      </div>

			    <label class="layui-form-label" style="font-size:15px" >时间:</label>
			      <div class="layui-input-inline">
			        <input type="text" name="wtime" id="wtime"  maxlength="8" required lay-verify="required" placeholder="时间" autocomplete="off" class="layui-input">   
			      </div>
  			</div>

			<div class="layui-form-item layui-form-text">
			    <label class="layui-form-label"  style="font-size:15px">备注:</label>
			    <div class="layui-input-inline">
			      <textarea placeholder="请输入内容" id="wnote" class="layui-textarea input"></textarea>
			    </div>
			  </div>
</form>
</body>
</html>