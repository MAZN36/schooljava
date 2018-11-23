
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
	th .layui-table-cell,td {text-align:center;}
	form{
		
		border:1px solid #D2D2D2;
	}
</style>
</head>
<body>  
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">个人设置</a></li>
    <li><a href="#">修改密码</a></li>
    </ul>
    </div>
    
   <form>
    	<div style="height:30px"></div>
		<div class="layui-form-item">
    		<label class="layui-form-label">用户名：</label>
    		<div class="layui-input-inline">
      			<input type="text" name="name" required lay-verify="required"  autocomplete="off" class="layui-input">
    		</div>
  		
    		<label class="layui-form-label">旧密码：</label>
    		<div class="layui-input-inline">
      			<input type="password" name="password" required lay-verify="required" placeholder="请输入旧密码" autocomplete="off" class="layui-input">
    		</div>
  		</div>
  		<div class="layui-form-item">
    		<label class="layui-form-label">新密码：</label>
    		<div class="layui-input-inline">
      			<input type="password" name="password" required lay-verify="required" placeholder="请输入新密码" autocomplete="off" class="layui-input">
    		</div>
    		
  		
    		<label class="layui-form-label">确认新密码：</label>
    		<div class="layui-input-inline">
      			<input type="password" name="password" required lay-verify="required" placeholder="再次输入新密码" autocomplete="off" class="layui-input">
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
