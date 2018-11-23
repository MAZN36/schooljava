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


#demo1{
	width: 150px;
    height: 170px;
}
#tp{
	position:absolute;
	left:980px;
	 top: 60px;
}
.rig{width:1155px;
   }

   .layui-input{
   		width:250px;
   }
   .input{
   		width:250px;
   }
 #inline{
 	width:250px;
 }
 #item{
 	width:300px;
 	position:relative;
 	left:800px;
 	
 }
</style>
</head>
<body>  
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">选课方向管理</a></li>
    <li><a href="#">设置选课信息</a></li>
    </ul>
    </div>
   	<br/>
   <div class="rig">
   	<form class="layui-form" >
  
  	<div class="layui-form-item">
	    
	    <label class="layui-form-label">课程名称：</label>
	    <div class="layui-input-inline" id="inline">
	      <input type="text" name="select_name" id="select_name"  maxlength="8" required lay-verify="required" placeholder="课程名称" autocomplete="off" class="layui-input">   
	    </div>
	   
			   <label class="layui-form-label">就业岗位：</label>
	    <div class="layui-input-inline" id="inline">
	       <input type="text" name="select_jobs" id="select_jobs"  maxlength="8" required lay-verify="required" placeholder="就业岗位" autocomplete="off" class="layui-input">   
	    </div>
	    <label class="layui-form-label">专业老师：</label>
	    <div class="layui-input-inline" id="inline">
	      <input type="text" name="select_teacher" id="select_teacher"  maxlength="8" required lay-verify="required" placeholder="专业老师" autocomplete="off" class="layui-input">   
	    </div>
	</div>    
	 
  
			<div class="layui-form-item">
			    <label class="layui-form-label"  >课程介绍:</label>
			    <div class="layui-input-inline" id="inline">
			      <textarea name="select_introduce" id="select_introduce" placeholder="请输入内容" id="wnote" class="layui-textarea input"></textarea>
			    </div>
			 
			    <label class="layui-form-label"  >课程目标:</label>
			    <div class="layui-input-inline" id="inline">
			      <textarea name="select_target" id="select_target" placeholder="请输入内容" id="wnote" class="layui-textarea input"></textarea>
			    </div>
			 
			    <label class="layui-form-label"  >具备能力:</label>
			    <div class="layui-input-inline" id="inline"> 
			      <textarea name="select_capacityv" id="select_capacityv" placeholder="请输入内容" id="wnote" class="layui-textarea input"></textarea>
			    </div>
			  </div>

	     
    </div>
     <div class="layui-form-item">
    		 <label class="layui-form-label">其他备注：</label>
			  <div class="layui-input-block">
			      <textarea cols="80" rows="10" id="details" style="width:990px"></textarea>
			  </div>
  		 </div>
 <br>
  <div id="item" >
    <div class="layui-input-block">
      <button class="layui-btn" id="insert" lay-submit lay-filter="formDemo">立即提交</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
 
</form>
 </div>

<script src="js/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript"
        src="js/Kindeditor/kindeditor-all-min.js"></script>
    <script type="text/javascript" src="js/Kindeditor/lang/zh-CN.js"></script>
<script>
//Demo
layui.use('form', function(){
  var form = layui.form;
  
  //监听提交
 form.on('submit(formDemo)', function(data){
	 insert();
    return false;
  }); 
 function insert(){
	 $.ajax({
			type:"post",
			url:"SelectCoursetype?action=add" //请求路径
			,data:{
				 Select_name:  $("#select_name").val(),
				 Select_target:  $("#select_target").val(),
				 Select_jobs:$("#select_jobs").val(),
				 Select_introduce:  $("#select_introduce").val(),
				 Select_capacityv:  $("#select_capacityv").val(),
				 Select_teacher:  $("#select_teacher").val(),
				 Select_Note:  editor.html()
			}
			,success:function(data){
    			if(data>0){
    				alert("添加成功");
    				location.reload();//刷新页面
    			}
    			else{
    				layer.msg("添加失败");
    			}
			}
	})
		
	
	
 }

});
 
 
</script>
 <script>
 //--------------------------------------------------------------编译器
 //获取文本的值editor.html()
    var editor;
    KindEditor.ready(function(K) {
       editor = K.create('#details',{
           uploadJson : 'js/Kindeditor/jsp/upload_json.jsp',  //上传程序
           fileManagerJson : 'js/Kindeditor/jsp/file_manager_json.jsp',  //文件管理
           allowFileManager : true  //是否允许上传
        });  //创建一个富文本编辑器
    });

    </script>

</body>
</html>