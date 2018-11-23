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
#adNote{
	width:500px;
}
</style>
</head>
<body>  
		<div class="place">
    <span>当前位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">管理人员</a></li>
    </ul>
    </div>
      <div class="rigtop" >
     数据进行输出时是按照序号从小到大，请根据需要进行排序!
  <button class="layui-btn layui-btn-normal mar layui-btns"  id="subs" style="width:150px;float:right">新增人员</button>
    </div>
 <div class="divtable">
<table id="demo" lay-filter="demo" lay-filter="test"></table>
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
    ,url: 'Adm?action=selectAll' //数据接口
    ,cols: [[ //表头
    	{type:'numbers', title: '序号'}
      ,{field: 'department', title: '部门',align:'center'}
      ,{field: 'adname', title: '姓名',align:'center'}
      ,{field: 'adpost', title: '职务',align:'center'}
      ,{field: 'adphone', title: '办公电话',align:'center'}
      ,{field: 'mailbox', title: '电子邮件',align:'center'}
      ,{field: 'adNote', title: '岗位备注',align:'center'}
      ,{field: 'right', title: '操    作', align:'center',  toolbar: '#barDemo'}
    ]]
  ,id:"idsw"
  });
//监听工具条
  table.on('tool(demo)', function(obj){
    var data = obj.data;
   if(obj.event === 'edit'){
	  $("#department").val(data.department);
		$("#adname").val(data.adname);
		$("#adpost").val(data.adpost);
		$("#adphone").val(data.adphone);
		$("#Mailbox").val(data.mailbox);
		$("#adNote").val(data.adNote)
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
//添加操作
$("#subs").click(function(){
	layer.open({
		type:1
		,title:"新增人员"
		,content:$("#form")
		,area:['700px','390px']
	 ,btn: ['添加', '取消'] //只是为了演示
    ,yes: function(){
    	$.ajax({
    		type:"get"
    		,url:"Adm?action=add"
    		,data:{
    			Department:$("#department").val(),
    			Adname:$("#adname").val(),
    			Adpost:$("#adpost").val(),
    			Adphone:$("#adphone").val(),
    			Mailbox:$("#Mailbox").val(),
    			AdNote:$("#adNote").val()
    			}
    		,success:function(data){
    			if(data>0){
    				//关闭
    				 layer.closeAll();
    				 alert("添加成功");
    				//清空
    				shuax();
    				}
    			else{
    				layer.msg("添加失败",{time: 1000});
    			}
    		}
    	});
    }
    ,btn2: function(){
      layer.closeAll();
      shuax();
    },cancel: function(index, layero){ 
    	layer.closeAll();
    	shuax();
      		  return false; 
      		} 
	});
	});
	
function del(e){
	$.ajax({
		type:"get"
		,url:"Adm?action=delete"
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
			,content:$("#form")
			,area:['700px','390px']
	 ,btn: ['修改', '取消'] //只是为了演示
    ,yes: function(){
    	$.ajax({
    		type:"get"
    		,url:"Adm?action=update"
    		,data:{
    			Department:$("#department").val(),
    			Adname:$("#adname").val(),
    			Adpost:$("#adpost").val(),
    			Adphone:$("#adphone").val(),
    			Mailbox:$("#Mailbox").val(),
    			AdNote:$("#adNote").val(),
    				Id:e
    			}
    	,success:function(data){
			if(data>0){
				//关闭
				 layer.closeAll();
				layer.msg("修改成功",{time: 1000});
				location.reload();//刷新页面
				//清空
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
  location.reload();//刷新页面
},cancel: function(index, layero){ 
	layer.closeAll();
	shuax();
  		  return false; 
  		} 
});
}
	
function shuax(){
	location.reload();//刷新页面
	}
	
</script>
<form class="layui-form" style="background-color: ghostwhite;height:290px " id="form" hidden="hidden">
	<br>
	     <div class="layui-form-item">
			    <label class="layui-form-label" >部门:</label>
			      <div class="layui-input-inline">
			        <input type="tel" name="department" id="department" lay-verify="required|phone" autocomplete="off" class="layui-input input">
			      </div>
			      
			      <label class="layui-form-label"  >姓名:</label>
			      <div class="layui-input-inline">
			        <input type="tel" name="adname" id="adname" lay-verify="required|phone" autocomplete="off" class="layui-input input">
			      </div>
			      
			     
  			</div>
  		<div class="layui-form-item">
  				 <label class="layui-form-label" >职务:</label>
			      <div class="layui-input-inline">
			        <input type="tel" name="phone" id="adpost" lay-verify="required|phone" autocomplete="off" class="layui-input input">
			      </div>
  		
			    <label class="layui-form-label" >办公电话:</label>
			      <div class="layui-input-inline">
			        <input type="tel" name="phone" id="adphone" lay-verify="required|phone" autocomplete="off" class="layui-input input">
			      </div>
  
  			</div>
  			<div class="layui-form-item">
			    <label class="layui-form-label" >电子邮件:</label>
			      <div class="layui-input-inline">
			        <input type="tel" name="phone" id="Mailbox" lay-verify="required|phone" autocomplete="off" class="layui-input input">
			      </div>
  			</div>
  			
		<div class="layui-form-item layui-form-text">
			    <label class="layui-form-label"  >备注:</label>
			    <div class="layui-input-inline">
			      <textarea placeholder="请输入内容" id="adNote" class="layui-textarea input"></textarea>
			    </div>

			  </div>
</form>	
</body>
</html>