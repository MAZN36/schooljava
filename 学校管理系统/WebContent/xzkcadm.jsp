<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新增课程</title>
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
.layui-form-select dl{max-height: 300px;}
.layui-input-block { margin-left: 750px; min-height: 36px;}
#demo1{
	width: 140px;
    height: 170px;
}
#tp{
	position:absolute;
	left:980px;
	 top: 60px;
}
.rig{width:1155px;
   }
</style>
</head>
<body>  
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">课程管理</a></li>
    <li><a href="#">新增课程</a></li>
    </ul>
    </div>
   	<br/>
   	<div class="rig">
   	<form class="layui-form">
  
  	<div class="layui-form-item">
	    
	    <label class="layui-form-label" >课程名称：</label>
	    <div class="layui-input-inline">
	      <input type="text" name="course_name" id="course_name" required lay-verify="required" placeholder="课程名称" autocomplete="off" class="layui-input">   
	    </div>
	    <label class="layui-form-label">课程数量：</label>
	    <div class="layui-input-inline">
	      <input type="text" name="course_number" id="course_number" maxlength="18"  required lay-verify="required" placeholder="课程数量" autocomplete="off" class="layui-input">   
	    </div>
	    <label class="layui-form-label">总学分：</label>
    		<div class="layui-input-inline">
      			<input type="text" name="course_sum" id="course_sum" required lay-verify="required"  autocomplete="off" class="layui-input" placeholder="总学分">
    		</div>
  	</div>
     <div class="layui-form-item">
    		 <label class="layui-form-label">其他备注：</label>
			  <div class="layui-input-inline">
			      <textarea cols="80" rows="10" id="details" style="width:810px" ></textarea>
			  </div>
  		 </div>
 <br>
  <div class="layui-form-item">
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
 var form
layui.use('form', function(){
  form= layui.form;
  
  //监听提交
  form.on('submit(formDemo)', function(data){
	  insert();
    return false;
  });
  function insert(){
	  console.log()
		 $.ajax({
				type:"get",
				url:"Course?action=add" //请求路径
				,data:{
					//课程名称
					Course_name:  $("#course_name").val() ,
					 //课程数量,
					   Course_number:  $("#course_number").val()         , 
					  //总学分，
					  Course_sum: $("#course_sum").val()		
				}
				,beforeSend:function(){//请求前的事件
					
				}
				,success:function(data){
	    			if(data>0){
	    				
	    				$("#course_name").val("")
	    				$("#course_number").val("");
	    				$("#course_sum").val("");
	    				editor.html("");
	    				
	    				layer.msg("添加成功");
	    			}
	    			else{
	    				layer.msg("添加失败");
	    			}
				}
		})
	}

});
//日期
layui.use('laydate', function(){
	  var laydate = layui.laydate;
	  laydate.render({
	    elem: '#test'
	  });
});
//日期
layui.use('laydate', function(){
	  var laydate = layui.laydate;
	  laydate.render({
	    elem: '#test2'
	  });
});
</script>
 <script>
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