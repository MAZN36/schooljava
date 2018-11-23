<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>课程信息</title>
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
	    <li><a href="#">课程管理</a></li>
	    <li><a href="#">课程信息</a></li>
	    </ul>
	    </div>
	    <div class="rigtop">
	   	<div class="layui-form-item layui-form" >
	    <div class="layui-inline" >
	      <label class="layui-form-label" style="width: 28px;">课程:</label>
	      <div class="layui-input-inline">
	        <select name="quiz" lay-verify="classselect" lay-search="" lay-filter="classselect" id="classselect">
	          <option value="">请选择课程</option>
	        </select>
	      </div>
	    </div>
	    </div>
	    </div>
	  
	 <div class="divtable">
<table id="demo" lay-filter="demo"  ></table>
</div>
<script>


var form
layui.use('form', function(){
  form= layui.form;
  form.on('select(classselect)', function(data){
	  
	  table.render({
		    elem: '#demo'
		    ,height: 471
		    ,page:false
		    ,url: 'Course' //数据接口
		    ,cellMinWidth: 260
		    ,cols: [[ //表头
		    	{type:'numbers', title: '序号'}
				      ,{field: 'course_name', title: '课程名称',align:'center'}
				      ,{field: 'course_number', title: '课程数量',align:'center'}
				      ,{field: 'course_sum', title: '总学分',align:'center'}
			    ]]
			  ,id:"idsw"
			  });
	});
  $.ajax({
		type:"get",
		url:"Course?action=selectAll",//请求路径
		success:function(data){//请求成功后的事件
				$.each(data.data,function(index,obj){
					var option=$("<option value='"+obj.course_id+"'>"+obj.course_name+"</option>");
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
	
  //第一个实例
  table.render({
    elem: '#demo'
    ,height: 471
    ,page:true
    ,url: 'Course?action=select' //数据接口
    ,cellMinWidth: 260
    ,cols: [[ //表头
    	{type:'numbers', title: '序号'}
    	,{field: 'course_name', title: '课程名称',align:'center'}
	      ,{field: 'course_number', title: '课程数量',align:'center'}
	      ,{field: 'course_sum', title: '总学分',align:'center'}
	    ]]
	  ,id:"idsw"
	  });
	  
	});
	
		//删除操作
		
		 function del(Studentid){
				$.ajax({
					url:"Studentinfo?action=delete"
		    		,data:{Studentid:Studentid}
		    		,success:function(data){
		    			if(data>0){
		    				//关闭
		      				 layer.closeAll();
		    				layer.msg("删除成功",{time: 1000});
		    				//重载
		    				table.reload('idsw', {
		    			        page: {
		    			          curr: 1 //重新从第 1 页开始
		    			        }
		    				});
		    				}
		    			else{
		    				layer.msg("删除失败",{time: 1000});
		    			}
		    		}
		    	});
		}
	</script>
	<script>
	$("#snamesele").click(function(){
		 table.render({
			    elem: '#demo'
			    ,height: 471
			    ,page:false
			    ,url: 'Course' //数据接口
			    ,cellMinWidth: 260
			    ,cols: [[ //表头
			    	{type:'numbers', title: '序号'}
			    	,{field: 'course_name', title: '课程名称',align:'center'}
				      ,{field: 'course_number', title: '课程数量',align:'center'}
				      ,{field: 'course_sum', title: '总学分',align:'center'}
				    ]]
				  ,id:"idsw"
				  });
	})
	$("#xzxy").click(function(){
		$.ajax({
			url:"Studentinfo?action=downFile"
    		,success:function(data){
    			if(data>0){
    				//关闭
      				 layer.closeAll();
    				layer.msg("删除成功",{time: 1000});
    				//重载
    				table.reload('idsw', {
    			        page: {
    			          curr: 1 //重新从第 1 页开始
    			        }
    				});
    				}
    			else{
    				layer.msg("删除失败",{time: 1000});
    			}
    		}
    	});
})

	</script>
</body>
</html>