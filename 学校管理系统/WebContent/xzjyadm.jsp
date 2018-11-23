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
.layui-form-select dl{max-height: 300px;}

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
    <li><a href="#">学员管理</a></li>
    <li><a href="#">添加教员</a></li>
    </ul>
    </div>
   	<br/>
   	<div class="rig">
   	<form class="layui-form">
  
  	<div class="layui-form-item">
	    
	    <label class="layui-form-label" >姓名：</label>
	    <div class="layui-input-inline">
	      <input type="text" name="tName" id="tName" required lay-verify="required" placeholder="姓名" autocomplete="off" class="layui-input">   
	    </div>
	    <label class="layui-form-label">身份证：</label>
	    <div class="layui-input-inline">
	      <input type="text" name="tid_card" id="tid_card" maxlength="18"  required lay-verify="required" placeholder="身份证号码" autocomplete="off" class="layui-input">   
	    </div>
	    <label class="layui-form-label">籍贯：</label>
    		<div class="layui-input-inline">
      			<input type="text" name="tNative" id="tNative" required lay-verify="required"  autocomplete="off" class="layui-input" placeholder="自动识别" >
    		</div>
  	</div>
 
  <div id="tp">		
 	<div id="divimg"><img class="layui-upload-img" id="demo1"></div><br/>
 	<p><a>&nbsp;&nbsp;&nbsp; &nbsp; &nbsp;&nbsp;</a><button type="button" class="layui-btn" id="test1">上传图片</button></p>
  </div>
  
  	<div class="layui-form-item">
  			<label class="layui-form-label">工号：</label>
    		<div class="layui-input-inline">
      			<input type="text" name="tJNumber" id="tJNumber" required lay-verify="required"  autocomplete="off" class="layui-input"  disabled="true ">
    		</div>
     		<label class="layui-form-label">学历：</label>
		    <div class="layui-input-inline">
		        <select name="tEducation" id="tEducation" lay-verify="required" lay-search="">
		          <option value="">直接选择或搜索选择</option>
		          <option value="高中毕业">大专毕业</option>
		          <option value="大学毕业">本科毕业</option>
		          <option value="中专毕业">研究生毕业</option>
		          <option value="研究生毕业">博士毕业</option>
		        </select>
     	 	</div>
    		<label class="layui-form-label">性别：</label>
    		<div class="layui-input-inline">
      			<input type="text" name="tsex" id="tsex" required lay-verify="required"  autocomplete="off" class="layui-input" placeholder="自动识别" disabled="true ">
    		</div>
  		</div>
  	
  	<div class="layui-form-item">
  		<label class="layui-form-label">职位：</label>
    		<div class="layui-input-inline">
		        <select name="tPosition" id="tPosition" lay-verify="required" >
		        <option value="">请选择职位</option>
		        
		        </select>
     	 	</div>
  			<label class="layui-form-label">民族：</label>
    		<div class="layui-input-inline">
		        <select name="tNation" id="tNation" lay-verify="required" lay-search="">
		           <option value="汉族">汉族</option>
		          <option value="壮族">壮族</option>
		          <option value="藏族">藏族</option>
		          <option value="裕固族">裕固族</option>
		          <option value="彝族">彝族</option>
		          <option value="瑶族">瑶族</option>
		          <option value="锡伯族">锡伯族</option>
		          <option value="乌孜别克族">乌孜别克族</option>
		          <option value="维吾尔族">维吾尔族</option>
		          <option value="佤族">佤族</option>
		          <option value="土家族">土家族</option>
		          <option value="哈萨克族">哈萨克族</option>
		        </select>
     	 	</div>
    		<label class="layui-form-label">出生日期：</label>
    		<div class="layui-input-inline">
		       <input type="text" name="tBirthday" id="tBirthday" lay-verify="date" placeholder="自动识别" autocomplete="off" class="layui-input" disabled="true ">
		    </div>	
  		</div>
  	
  		<div class="layui-form-item">
    		<label class="layui-form-label">联系电话：</label>
    		<div class="layui-input-inline">
      			<input type="text" name="tTelephone" id="tTelephone"   autocomplete="off" class="layui-input" placeholder="联系电话">
    		</div>
    		<label class="layui-form-label">政治面貌：</label>
    		<div class="layui-input-inline">
		        <select name="tPolitical" id="tPolitical" lay-verify="required" lay-search="">
		          <option value="">直接选择或搜索选择</option>
		          <option value="1">团员</option>
		          <option value="2">党员</option>
		          <option value="3">群众</option>
		        </select>
     	 	</div>
    		<label class="layui-form-label">家庭住址：</label>
    		<div class="layui-input-inline">
      			<input type="text" name="tHome" id="tHome" required lay-verify="required"  autocomplete="off" class="layui-input" placeholder="自动识别" >
    		</div>
  		</div>
  		<br><br>
     <div class="layui-form-item">
    		 <label class="layui-form-label">其他备注：</label>
			  <div class="layui-input-block">
			      <textarea cols="80" rows="10" id="details" style="width:1020px" ></textarea>
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
		 $.ajax({
				type:"get",
				url:"Teacher?action=add" //请求路径
				,data:{
					TJNumber:  $("#tJNumber").val() ,
					 //姓名,
					   TName:  $("#tName").val()         , 
					  //职位，
					  TPosition: $("#tPosition").val()		,
					  //学历,
					  TEducation:$("#tEducation").val()		,
					 //性别,
					    Tsex:  $("#tsex").val()             ,
					 //民族,
					   TBirthday:  $("#tNation").val()    ,
					 //出生日期,
					    TBirthday:  $("#tBirthday").val()            ,
					 //身份证号,
					    Tid_card:  $("#tid_card").val()               ,
					 //籍贯,
					 TNative:  $("#tNative").val()     ,
					 //家庭住址,
					 THome:  $("#tHome").val(),
					 //政治面貌,
					 TPolitical:  $("#tPolitical").val(),
					 //手机号码,
					 TTelephone:  $("#tTelephone").val(),
					 //图片,
					 Img:  pic,
					 SState:"在职",
					 TPassword:"686868",
					 //备注,
					  tNote:  editor.html()
				}
				,beforeSend:function(){//请求前的事件
					
				}
				,success:function(data){
	    			if(data>0){
	    				$("#tName").val("自动识别");$("#tsex").val("自动识别");tBirthday:  $("#tBirthday").val("自动识别");$("#tNative").val("自动识别");$("#tHome").val("自动识别");
	    				$("#tid_card").val("");
	    				$("#tName").val("")
	    				$("#tTelephone").val("");
	    				$("#tEducation").val("");
	    				editor.html("");
	    				$("#tJNumber").val(times());
	    				
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


var pic;
layui.use('upload', function(){
	  var $ = layui.jquery,upload = layui.upload;
	  //图片上传
	  var uploadInst = upload.render({
	    elem: '#test1'
	    ,url: 'UploadFile?Id='+$("#tJNumber").val()+"&Path=teaimage"
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
    var editor;
    KindEditor.ready(function(K) {
       editor = K.create('#details',{
           uploadJson : 'js/Kindeditor/jsp/upload_json.jsp',  //上传程序
           fileManagerJson : 'js/Kindeditor/jsp/file_manager_json.jsp',  //文件管理
           allowFileManager : true  //是否允许上传
        });  //创建一个富文本编辑器
    });
    //设置工号
    $("#tJNumber").val(times());
    
  //身份证自动识别
    $("#tid_card").change(function(){
		sfzbd($("#tid_card").val(),$("#tBirthday"),$("#tsex"),$("#tNative"),$("#tHome"));
				})
	//身份证自动识别
	function sfzbd(sfz,csrq,xb,jk,dz){
	  if(sfz.length==18){
		  var cheng=[7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2];var xym=[1,0,'X',9,8,7,6,5,4,3,2];
		  var sum=0;for(var i=0;i<sfz.length-1;i++){sum+=cheng[i]*sfz[i];}
		  var sum=xym[sum%11];if(sfz[17]==sum)
		  {$(csrq).val(sfz.substring(6,10)+"-"+sfz.substring(10,12)+"-"+sfz.substring(12,14));
		  $(xb).val("男");if(sfz.substring(16,17)%2===0)$(xb).val("女");$.ajax({type:"get",url:"go.do",data:{areaCode:sfz.substring(0,6)},success:function(data){$.each(data.data,function(index,obj){$(jk).val(obj.province.substring(0,2)+obj.city.substring(0,2));$(dz).val(obj.detail);})}})}else{layer.msg("身份证有误");$(jk).val("自动识别");$(dz).val("自动识别");$(csrq).val("自动识别");$(xb).val("自动识别");}}else{layer.msg("身份证有误");$(jk).val("自动识别");$(dz).val("自动识别");$(csrq).val("自动识别");$(xb).val("自动识别");}}
    
  //查询职位
	var list=function(){
	$.ajax({
		type:"get",
		url:"Position?action=selectAll",//请求路径
		beforeSend:function(){//请求前的事件
			
		},
		success:function(data){//请求成功后的事件
				$.each(data.data,function(index,obj){
					var option=$("<option value='"+obj.pid+"'>"+obj.pname+"</option>");
					$("#tPosition").append(option);
				})
			}
		})
		
	}
	list();
    </script>

</body>
</html>