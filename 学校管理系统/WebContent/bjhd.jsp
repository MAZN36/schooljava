<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>班级信息查询</title>
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
.input{width:190px;}
.layui-textarea {min-height: 135px;min-width:455px;margin-left: -96px;}
.layui-textareas {min-height: 145px;min-width:455px;margin-left: -103px;}
.item {width: 680px;margin-bottom: 15px; clear: both;}
.layui-form-select dl{height:150px;}
.layui-form-label{width:55px;}
#form{height:300px;}
#form2{height:300px;}
</style>
</head>
<body>  
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">信息查询</a></li>
    <li><a href="#">班级信息查询</a></li>
    </ul>
    </div>
    <div class="rigtop">
    	<div class="layui-form-item layui-form" >
	    <div class="layui-inline" >
	      <label class="layui-form-label">班级名称:</label>
	      <div class="layui-input-inline">
	        <select name="quiz" lay-verify="classselect" lay-search="" lay-filter="cName" id="cName"  >
	          <option value="">请选择</option>
	        </select>
	      </div>
	    </div>
  <button class="layui-btn layui-btn-normal layui-btns"  id="select">查询</button>
    </div>
    </div>
    <div class="divtable">
<table id="demo" lay-filter="demo" lay-filter="test"></table>
</div>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">升学</a>
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">结业</a>
</script>

<script>

var table=null;
var form=null;
layui.use(['table','form'], function(){
	table= layui.table;
	form= layui.form;
	//加载年级
	$.ajax({
		type:"get",
		url:"Grade?action=selectAll",//请求路径
		success:function(data){//请求成功后的事件
				$.each(data.data,function(index,obj){
					var option=$("<option value='"+obj.gid+"'>"+obj.gname+"</option>");
					$("#classselect").append(option);
				})
				$.each(data.data,function(index,obj){
					var option=$("<option value='"+obj.gid+"'>"+obj.gname+"</option>");
					$("#cTypeName").append(option);
					
				})
				form.render(); 
			}
		})
		//加载班主任
		$.ajax({
		type:"get",
		url:"Teacher?action=PagingtPosition&tPosition=1",//请求路径
		success:function(data){//请求成功后的事件
				$.each(data.data,function(index,obj){
					var option=$("<option value='"+obj.tid+"'>"+obj.tname+"</option>");
					$("#cTeacher").append(option);
					
				})
				form.render(); 
			}
		})
		form.on('select(classselect)', function(data){
			  table.render({
				    elem: '#demo'
				    ,height: 471
				    ,page:false
				    ,url: 'Classs_Activity?action=select' //数据接口
				        ,cols: [[ //表头
				        	{type:'numbers', title: '序号'}
				            ,{field: 'act_Classs', title: '班级',align:'center'}
				            ,{field: 'act_Teme', title: '活动主题',align:'center'}
				            ,{field: 'act_Time', title: '时间',align:'center'}
				            ,{field: 'act_Location', title: '地点',align:'center'}
				          ,{field: 'act_Content', title: '内容',align:'center'}
				          ,{field: 'act_Note', title: '备注',align:'center'}
				        ]]
					  ,id:"idsw"
					  });
			}); 
  //第一
  table.render({
    elem: '#demo'
    ,height: 471
    ,page:true
    ,url: 'Classs_Activity?action=select' //数据接口
    ,cols: [[ //表头
    	{type:'numbers', title: '序号'}
        ,{field: 'act_Classs', title: '班级',align:'center'}
        ,{field: 'act_Teme', title: '活动主题',align:'center'}
        ,{field: 'act_Time', title: '时间',align:'center'}
        ,{field: 'act_Location', title: '地点',align:'center'}
      ,{field: 'act_Content', title: '内容',align:'center'}
      ,{field: 'act_Note', title: '备注',align:'center'}
    ]]
  });
//监听工具条
  table.on('tool(demo)', function(obj){
    var data = obj.data;
    if(obj.event === 'detail'){
      upda();
    } else if(obj.event === 'del'){
      layer.confirm('真的删除行么', function(index){
        obj.del();
        layer.close(index);
      });
    } else if(obj.event === 'edit'){
      layer.alert('编辑行：<br>'+ JSON.stringify(data))
    }
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
    elem: '#cGtime1'
  });
});
</script>
</body>
</html>