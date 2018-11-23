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
.rigtop { width: 1143px; height: 40px;border: 1px solid #b7d5df;line-height: 40px;margin:auto;margin-top:5px;}
.layui-btns {width: 100px;height: 32px;line-height: 32px;position:relative;float:right;border-radius: 20px;top:5px}
.divtable{width:1145px;margin:auto;margin-top:-5px;}
.input{width:275px;}
</style>
</head>
<body>  
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">日常工作</a></li>
    <li><a href="#">上课点名</a></li>
    </ul>
    </div>
      <div class="rigtop">
    	<div class="layui-form-item layui-form">
    <div class="layui-inline" >
      <label class="layui-form-label" style="width: 28px;">班级:</label>
      <div class="layui-input-inline">
           <select name="quiz" lay-verify="classselect" lay-search="" lay-filter="classselect" id="classselect">
	          <option value="">请选择班级</option>
	       
        </select>
      </div>
    </div>
    
    <div class="layui-inline">
      <label class="layui-form-label" style="width: 28px;">课程:</label>
      <div class="layui-input-inline">
        <select name="quiz" id="kc">
         <option value="">请选择课程</option>
        </select>
      </div>
    </div>
     <div class="layui-inline">
      <label class="layui-form-label" style="width: 70px;">点名类型:</label>
      <div class="layui-input-inline">
        <select name="quiz" id="quiz">
          <option value="上课">上课</option>
       	 <option value="自习">自习</option>
       	 <option value="活动">活动</option>
       	 <option value="其他">其他</option>
        </select>
      </div>
    </div>
  <button class="layui-btn layui-btn-normal layui-btns"  id="subs">提交</button>
    </div>
    </div>
<div class="divtable">
<table id="demo" lay-filter="demo" lay-filter="test"></table>
</div>
 <script type="text/html" id="barDemo1">
<form>
    <input type="radio" name="{{d.stuId}}" value="正常" title="正常" checked >
     <input type="radio" name="{{d.stuId}}" value="迟到" title="迟到">
      <input type="radio" name="{{d.stuId}}" value="旷课" title="旷课">
      <input type="radio" name="{{d.stuId}}" value="请假" title="请假">
</form>
</script>
<script src="js/layui/layui.js" charset="utf-8"></script>
<script>
//进行按班级查询
var form
layui.use(['form','table'], function(){
  form= layui.form;
  table= layui.table;
  form.on('select(classselect)', function(data){
	  table.render({
		    elem: '#demo'
		    ,height: 471
		    ,page:false
		    ,url: 'Studentinfo?action=Pagingsclasss&zt=在读&sclasss='+data.value //数据接口
		    ,cellMinWidth: 120
		    ,cols: [[ //表头
		    	{type:'numbers', title: '序号'}
		      ,{field: 'sname', title: '姓名',align:'center'}
		      ,{field: 'ssex', title: '性别',align:'center'}
		      ,{field: 'cqqk', title: '出勤情况', align:'center',  toolbar: '#barDemo1'}
		    ]]
			  ,id:"idsw"
			  });
	});
  $.ajax({
		type:"get",
		url:"Classs?action=selectAll&cGstate=开学",//请求路径
		success:function(data){//请求成功后的事件
				$.each(data.data,function(index,obj){
					var option=$("<option value='"+obj.cId+"'>"+obj.cName+"</option>");
					$("#classselect").append(option);
					form.render(); 
				})
			}
		}) ;
  $.ajax({
		type:"get",
		url:"Course?action=selectAll",//请求路径
		success:function(data){//请求成功后的事件
				$.each(data.data,function(index,obj){
					var option=$("<option value='"+obj.course_id+"'>"+obj.course_name+"</option>");
					$("#kc").append(option);
					form.render(); 
				})
			}
		})
		
});
$("#subs").click(function(){
	layer.msg("数据出错");
})
</script>

</body>
</html>