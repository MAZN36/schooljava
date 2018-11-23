
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
	body{
		background-color: #f5f5f5;
	}
	th .layui-table-cell,td {text-align:center;}
	form{
		
		border:1px solid #D2D2D2;
	}
	.but_dz{
		height:40px;
		width:500px;
		border:1px solid #D2D2D2;
	}
</style>
</head>
<body>  
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">个人设置</a></li>
    <li><a href="#">修改个人资料</a></li>
    </ul>
    </div>
    
   <form>
    	<div style="height:30px"></div>
		<div class="layui-form-item">
    		<label class="layui-form-label">学号：</label>
    		<div class="layui-input-inline">
      			<input type="text" name="id" required lay-verify="required"  autocomplete="off" class="layui-input" placeholder="只能读" disabled= "true " >
    		</div>
    		<label class="layui-form-label">姓名：</label>
    		<div class="layui-input-inline">
      			<input type="text" name="name" required lay-verify="required"  autocomplete="off" class="layui-input" placeholder="只能读" disabled= "true " >
    		</div>
    		<label class="layui-form-label">姓名拼音：</label>
    		<div class="layui-input-inline">
      			<input type="text" name="name" required lay-verify="required"  autocomplete="off" class="layui-input" placeholder="只能读" disabled= "true " >
    		</div>
  		</div>
  		
  		<div class="layui-form-item">
    		<label class="layui-form-label">性别：</label>
    		<div class="layui-input-inline">
      			<input type="text" name="sex" required lay-verify="required"  autocomplete="off" class="layui-input" placeholder="只能读" disabled= "true " >
    		</div>
    		<label class="layui-form-label">身份证号：</label>
    		<div class="layui-input-inline">
      			<input type="text" name="id_number" required lay-verify="required"  autocomplete="off" class="layui-input" placeholder="只能读" disabled= "true " >
    		</div>
    		<label class="layui-form-label">籍贯：</label>
    		<div class="layui-input-inline">
      			<input type="text" name="place" required lay-verify="required"  autocomplete="off" class="layui-input">
    		</div>
  		</div>
  		
  		<div class="layui-form-item">
  			<label class="layui-form-label">当前班级：</label>
    		<div class="layui-input-inline">
      			<input type="text" name="id_number" required lay-verify="required"  autocomplete="off" class="layui-input" placeholder="只能读" disabled= "true " >
    		</div>
  			<label class="layui-form-label">宿舍号：</label>
    		<div class="layui-input-inline">
      			<input type="text" name="id_number" required lay-verify="required"  autocomplete="off" class="layui-input" placeholder="只能读" disabled= "true " >
    		</div>
    		<label class="layui-form-label">毕业院校：</label>
    		<div class="layui-input-inline">
      			<input type="text" name="password" required lay-verify="required"  autocomplete="off" class="layui-input">
    		</div>
  		</div>
  		
  		
  		<div class="layui-form-item">
    		<label class="layui-form-label">QQ：</label>
    		<div class="layui-input-inline">
      			<input type="text" name="password" required lay-verify="required"  autocomplete="off" class="layui-input">
    		</div>
    		<label class="layui-form-label">微信：</label>
    		<div class="layui-input-inline">
      			<input type="text" name="password" required lay-verify="required"  autocomplete="off" class="layui-input">
    		</div>
    		<label class="layui-form-label">电子邮件：</label>
    		<div class="layui-input-inline">
      			<input type="text" name="password" required lay-verify="required"  autocomplete="off" class="layui-input">
    		</div>
  		</div>
  		
  		<div class="layui-form-item">
    		<label class="layui-form-label">一卡通卡号：</label>
    		<div class="layui-input-inline">
      			<input type="text" name="password" required lay-verify="required"  autocomplete="off" class="layui-input">
    		</div>
    		
  		</div>
  		
  		
		  
		  <div class="layui-form-item">
    		<label class="layui-form-label">电话：</label>
    		<div class="layui-input-inline">
      			<input type="text" name="password" required lay-verify="required"  autocomplete="off" class="layui-input">
    		</div>
    		<label class="layui-form-label">地址：</label>
    		<div class="layui-input-inline">
      			<input type="text" name="title" class="but_dz" required  lay-verify="required"  autocomplete="off" class="layui-input">
    		</div>
  		 </div>
  		 
  		 <div class="layui-form-item">
    		<label class="layui-form-label">家庭电话：</label>
    		<div class="layui-input-inline">
      			<input type="text" name="password"  required lay-verify="required"  autocomplete="off" class="layui-input">
    		</div>
    		<label class="layui-form-label">家庭地址：</label>
    		<div class="layui-input-inline">
      			<input type="text" name="title" class="but_dz" required  lay-verify="required"  autocomplete="off" class="layui-input">
    		</div>
  		 </div>
		
  		
  		 <div class="layui-form-item">
		    <div class="layui-input-block">
		      <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
		      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
		    </div>
		  </div>
    </form>
    
    

	


</body>
</html>
