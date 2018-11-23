<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>无标题文档</title>
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
.layui-form-label { width: 52px;}
.layui-form-radio{margin:0px;}
table {
	
	background-color:#ffffff;
}
tr,td
{
   width:1143px;
	height:38px;
	border:1px solid #e6e6e6;
}
.tr{background-color:#f2f2f2;}
.check{width:18px;height:18px;}

.divtable1{
	width:1144px;
	height:461px;
	overflow:auto;
	position:relative;
	margin:auto;
	top:5px;
}
.hover{
	background-color:#f2f2f2;
	
}
.Table_1 td{
	font-align:left;
}
</style>
</head>
<body>  
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">成绩管理</a></li>
    <li><a href="#">录入成绩</a></li>
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
	 	 考试 日期：
		<div class="layui-inline" style="width:190px">
		    <input class="layui-input" name="test" id="test" placeholder="年-月-日" > 
		</div>
	    <button class="layui-btn layui-btns layui-btn-normal"  id="xzxy">录入成绩</button>
	    </div>
	    </div>
   
  <div class="divtable1">
	<table class="Table_1"> 
	<tr class="tr" > 
			 <td style="width:124px">序号</td> 
			 <td style="width:138px">班级</td>  
			 <td style="width:129px">姓名</td>  
			 <td style="width:188px">学号</td> 
			 <td style="width:132px">机试</td> 
			 <td style="width:132px">笔试</td> 
			 <td style="width:150px">是否通过</td> 
		 </tr> 
		 
	</table>
</div>
<script>
var table=null;
var form=null;
layui.use('form', function(){
	  form= layui.form;
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
	})
})
//日期
layui.use('laydate', function(){
	  var laydate = layui.laydate;
	  laydate.render({
	    elem: '#test'
	  });
});
//鼠标事件
$(".Table_1 tr").hover( //$(".table_1 tr")选择table的class为table_1的tr绑定事件
    function () { 
        $(this).addClass("hover"); //鼠标悬停时，改变li的class样式
    }, 
    function () { 
        $(this).removeClass("hover"); //鼠标离开时，取消tr的class样式
    } 
);

</script>
<script>


//进行按班级查询
var form
layui.use('form', function(){
form= layui.form;
form.on('select(classselect)', function(data){
	$.ajax({
	type:"get",
	url:"Studentinfo?action=Pagingsclasss&zt=在读&sclasss="+data.value 
	,success:function(data){//请求成功后的事件
		$("table tr:gt(0)").remove();
			$.each(data.data,function(index,obj){
				var tr=$("<tr/>");
				var input=$("<input type=\"checkbox\" name=\"close\" class=\"check\" checked=\"checked\">");
				$("<td/>").html(index+1).appendTo(tr);
				$("<td/>").html(obj.cName).appendTo(tr);
				$("<td/>").html(obj.sname).appendTo(tr);
				$("<td/>").html(obj.studentid).appendTo(tr);
				$("<td contenteditable=\"true\"/>").appendTo(tr);
				$("<td contenteditable=\"true\"/>").appendTo(tr);
				$("<td/>").html(input).appendTo(tr);
				$("table").append(tr);
			})
		}
	})
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

	</script>
	<script>
	$("#xzxy").click(function(){
			alert("数据出现异常");
			});


	</script>
</body>
</html>