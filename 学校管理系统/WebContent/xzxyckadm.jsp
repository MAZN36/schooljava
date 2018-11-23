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
</style>
</head>
<body>  
	<div class="rig">
   	<form class="layui-form" >
  
  	<div class="layui-form-item">
	    
	    <label class="layui-form-label">姓名：</label>
	    <div class="layui-input-inline">
	      <input type="text" name="sname" id="sname"  maxlength="8" required lay-verify="required"  autocomplete="off" class="layui-input" disabled="true ">   
	    </div>
	    <label class="layui-form-label">身份证：</label>
	    <div class="layui-input-inline">
	      <input type="text" name="scard" id="scard" maxlength="18" required lay-verify="required"   autocomplete="off" class="layui-input" disabled="true ">   
	    </div>
	    <label class="layui-form-label">性别：</label>
    		<div class="layui-input-inline">
      			<input type="text" name="ssex" id="ssex" required lay-verify="required"  autocomplete="off" class="layui-input"   disabled="true ">
    		</div>
  	</div>
 
  <div id="tp">		
 	<div id="divimg"><img class="layui-upload-img" id="demo1"></div><br/>
 	<p><a>&nbsp;&nbsp;&nbsp; &nbsp; &nbsp;</a><button type="button" class="layui-btn" id="test1">上传图片</button></p>
  </div>
  
  	<div class="layui-form-item">
        <label class="layui-form-label">联系电话：</label>
	    <div class="layui-input-inline">
	      <input type="text" name="snumber" id="snumber" maxlength="11" lay-verify="required" autocomplete="off" class="layui-input" disabled="true ">   
	    </div>
	     <label class="layui-form-label">民族：</label>
	    <div class="layui-input-inline">
	      <input type="text" name="snational" id="snational" maxlength="11" lay-verify="required"   autocomplete="off" class="layui-input" disabled="true ">   
	    </div>
	    
	    <label class="layui-form-label">籍贯：</label>
    		<div class="layui-input-inline">
      			<input type="text" name="snativeplace" id="snativeplace" required lay-verify="required"  autocomplete="off" class="layui-input"   disabled="true ">
    		</div>
  	</div>
  	
  	<div class="layui-form-item">
	    <label class="layui-form-label">QQ：</label>
	    <div class="layui-input-inline">
	      <input type="text" name="sqq" id="sqq"  lay-verify="required"  maxlength="12" autocomplete="off" class="layui-input"  disabled="true ">   
	    </div>
	     <label class="layui-form-label"  >班级：</label>
	     <div class="layui-input-inline">
	      <input type="text" name="sclasss" id="sclasss"  lay-verify="required"  maxlength="12" autocomplete="off" class="layui-input"  disabled="true ">   
	    </div>
	    
  		<label class="layui-form-label">出生日期：</label>
    		<div class="layui-input-inline">
		       <input type="text" name="sdate" id="sdate" lay-verify="date"   autocomplete="off" class="layui-input" disabled="true ">
		    </div>
	    
  	</div>
  	
  	<div class="layui-form-item">
  		 <label class="layui-form-label">家长姓名：</label>
	    <div class="layui-input-inline">
	      <input type="text" name="sparentsname" id="sparentsname" maxlength="8"  lay-verify="sparentsname"  disabled="true "autocomplete="off" class="layui-input">   
	    </div>
	    <label class="layui-form-label">政治面貌：</label>
	    <div class="layui-input-inline">
	      <input type="text" name="sface" id="sface" maxlength="8"  lay-verify="sparentsname"  disabled="true "autocomplete="off" class="layui-input">   
	    </div>
     	 	<label class="layui-form-label">家庭住址：</label>
    		<div class="layui-input-inline">
      			<input type="text" name="saddress" id="saddress" required lay-verify="required"  autocomplete="off" class="layui-input"   disabled="true ">
    		</div>
  	</div>
  	
  	<div class="layui-form-item">
  		<label class="layui-form-label">家长电话：</label>
	    <div class="layui-input-inline">
	      <input type="text" name="sparentsnumber" id="sparentsnumber" maxlength="11" lay-verify="required"  disabled="true " autocomplete="off" class="layui-input">   
	    </div>
	    <label class="layui-form-label">入学日期：</label>
	    <div class="layui-input-inline">
	       <input type="text" class="layui-input" name="sentrancedate" id="sentrancedate" required  disabled="true ">
	    </div>
  <label class="layui-form-label">学号：</label>
	    <div class="layui-input-inline">
	      <input type="text" name="studentid" id="studentid" required lay-verify="required"   autocomplete="off" class="layui-input" disabled="true ">   
	    </div>
	    
	     
    </div>
     <div class="layui-form-item">
    		 <label class="layui-form-label">其他备注：</label>
			  <div class="layui-input-block">
			      <textarea cols="80" rows="10" id="details" style="width:1020px"></textarea>
			  </div>
  		 </div>
 <br>
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" id="insert" lay-submit lay-filter="formDemo">关闭</button>
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

  }); 
 function insert(){
	 $.ajax({
			type:"get",
			url:"Studentinfo?action=add" //请求路径
			,data:{
				
			}
			,beforeSend:function(){//请求前的事件
				
			}
			,success:function(data){
				 Studentid:  $("#studentid").val() ,
				 //班级,
				    SClasss:  $("#sclasss").val()    ,
				 //姓名,
				    SName:  $("#sname").val()         , 
				 //性别,
				    SSex:  $("#ssex").val()             ,
				 //民族,
				   SNational:  $("#snational").val()    ,
				 //出生日期,
				    SDate:  $("#sdate").val()            ,
				 //身份证号,
				    SCard:  $("#scard").val()               ,
				 //籍贯,
				 SNativeplace:  $("#snativeplace").val()     ,
				 //家庭住址,
				 SAddress:  $("#saddress").val(),
				 //家长姓名,
				 SParentsName:  $("#sparentsname").val(),
				 //家长电话,
				 SParentsNumber:  $("#sparentsnumber").val(),
				 //政治面貌,
				 SFace:  $("#sface").val(),
				 //手机号码,
				 SNumber:  $("#snumber").val(),
				 //入学时间,
				 SEntranceDate:  $("#sentrancedate").val(),
				 //QQ号,
				    SQQ:  $("#sqq").val(),
				 //图片,
				 SPicture:  pic,
				 //备注,
				  SNote:  editor.html()
			}
	})
		
	
	
 }

})
var pic;
layui.use('upload', function(){
	  var $ = layui.jquery,upload = layui.upload;
	  //图片上传
	  var uploadInst = upload.render({
	    elem: '#test1'
	    ,url: 'UploadFile?Id='+$("#studentid").val()+"&Path=stuimage"
	    ,before: function(obj){
	      //预读本地文件示例，不支持ie8
	      obj.preview(function(index, file, result){
	        $('#demo1').attr('src', result); //图片链接（base64）
	      });  }
	    ,done: function(res){
	    	//如果上传失败
			if (res.code > 0) {return layer.msg('上传失败');}
			//上传成功
			src = res.data.src;layer.msg(res.msg);
			pic=res.data.name;
	    }
	    ,error: function(){
	      //演示失败状态，并实现重传
	      var demoText = $('#demoText');
	      demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
	      demoText.find('.demo-reload').on('click', function(){ uploadInst.upload(); });} 
	    }); 
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