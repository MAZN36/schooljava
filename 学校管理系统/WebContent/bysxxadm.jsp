<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>毕业生信息</title>
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
.rigtop a{font-size:14px;}
#xzxy{position:relative;top:4px;}
	</style>
	</head>
	<body>  
		<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
	    <li><a href="#">首页</a></li>
	    <li><a href="#">年级管理</a></li>
	    <li><a href="#">毕业信息</a></li>
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
	    <button class="layui-btn layui-btns layui-btn-normal"  id="xzxy">导出xls</button>
	    </div>
	    </div>
	  
	 <div class="divtable">
<table id="demo" lay-filter="demo"  ></table>
</div>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">详细</a>
</script>
<script>
//进行按班级查询
var form
layui.use('form', function(){
  form= layui.form;
  form.on('select(classselect)', function(data){
	  table.render({
		    elem: '#demo'
		    ,height: 471
		    ,page:false
		    ,url: 'Studentinfo?action=Pagingsclasss&zt=毕业&sclasss='+data.value //数据接口
		    ,cellMinWidth: 120
		    ,cols: [[ //表头
		    	{type:'numbers', title: '序号'}
				      ,{field: 'studentid', title: '学号',align:'center'}
				      ,{field: 'studentid', title: '班级',align:'center'}
				      ,{field: 'sname', title: '姓名',align:'center'}
				      ,{field: 'ssex', title: '性别',align:'center'}
				      ,{field: 'snumber', title: '手机号码', align:'center'}
				      ,{field: 'sparentsNumber', title: '家长电话', align:'center'}
				      ,{field: 'sdate', title: '入学日期',align:'center'}
				      ,{field: 'right', title: '操作',width:'178', align:'center',  toolbar: '#barDemo'}
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
layui.use('table', function(){
	table= layui.table;
	//监听工具条
	table.on('tool(demo)', function(obj){
	  var data = obj.data;
	  if(obj.event === 'detail'){
	    layer.msg('进行详细查询');
	  } else if(obj.event === 'del'){
	    layer.confirm('真的删除行么', function(index){
	    	del(data.studentid);
	      layer.close(index);
	    });
	  } else if(obj.event === 'edit'){
	    layer.alert('编辑行：<br>'+ JSON.stringify(data))
	  }
	});
  //进行渲染
  table.render({
    elem: '#demo'
    ,height: 471
    ,page:true
    ,url: 'Studentinfo?action=select&zt=毕业' //数据接口
    ,cellMinWidth: 120
    ,cols: [[ //表头
    	{type:'numbers', title: '序号'}
		      ,{field: 'studentid', title: '学号',align:'center'}
		      ,{field: 'cName', title: '班级',align:'center'}
		      ,{field: 'sname', title: '姓名',align:'center'}
		      ,{field: 'ssex', title: '性别',align:'center'}
		      ,{field: 'snumber', title: '手机号码', align:'center'}
		      ,{field: 'sparentsNumber', title: '家长电话', align:'center'}
		      ,{field: 'sdate', title: '入学日期',align:'center'}
		      ,{field: 'right', title: '操作',width:'178', align:'center',  toolbar: '#barDemo'}
	    ]]
	  ,id:"idsw"
	  });
	  
	});
	
	</script>
	<script>
	$("#snamesele").click(function(){
		 table.render({
			    elem: '#demo'
			    ,height: 471
			    ,page:false
			    ,url: 'Studentinfo?action=selectsname&zt=毕业&sname='+$("#demoReload").val() //数据接口
			    ,cellMinWidth: 120
			    ,cols: [[ //表头
			    	{type:'numbers', title: '序号'}
					      ,{field: 'studentid', title: '学号',align:'center'}
					      ,{field: 'studentid', title: '班级',align:'center'}
					      ,{field: 'sname', title: '姓名',align:'center'}
					      ,{field: 'ssex', title: '性别',align:'center'}
					      ,{field: 'snumber', title: '手机号码', align:'center'}
					      ,{field: 'sparentsNumber', title: '家长电话', align:'center'}
					      ,{field: 'sdate', title: '入学日期',align:'center'}
					      ,{field: 'right', title: '操作',width:'178', align:'center',  toolbar: '#barDemo'}
				    ]]
				  ,id:"idsw"
				  });
	})

	</script>
</body>
</html>