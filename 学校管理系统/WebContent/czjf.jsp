<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>年级信息</title>
<meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="js/layui/css/layui.css"  media="all">
  <link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script src="js/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="js/utf.js"></script>
<script type="text/javascript" src="js/jquery.qrcode.js"></script>
<script language="javascript">
var xh=0;
$.ajax({
	url:'GetSuccess?sf=xy',
	success:function(data){
		if(data.code==3){
			alert(data.msg);
			window.parent.index();
		}
		else{
			xh=data.msg;
		}
	}
})
$(function(){	
	//导航切换
	$(".imglist li").click(function(){
		$(".imglist li.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
	$("#wx").click(function(){
	$("#wxr").attr("checked",true);
})
$("#zfb").click(function(){
	$("#zfbr").attr("checked",true);
})

$("#ddddss").click(function(){
	var je=$("#je").val();
	window.location.href='test?xh='+xh+'&zffs='+tie+'&ddh='+ddh+'&je='+je;
})
$("#btn").click(function(){
	var je=$("#je").val();
	var src='images/weix.jpeg';
	if($("#wxr").attr("checked")){
			src='images/weix.jpeg';
	}
	else{
		src='images/zhifb.jpg';
	}
	url='http://banggang.xyz/test?xh='+xh+'&zffs='+tie+'&ddh='+ddh+'&je='+je;
	if(je.length>0&&je!="0"){
	$("#div1").html("");
		$("#div1").qrcode({
			render : "canvas",    //设置渲染方式，有table和canvas，使用canvas方式渲染性能相对来说比较好
			text : url,    //在这里也可以直接填一个网址，扫描二维码后
			width : "200",               //二维码的宽度
			height : "200",              //二维码的高度
			background : "#ffffff",       //二维码的后景色
			foreground : "#000000",        //二维码的前景色
			src: src             //二维码中间的图片
		});
		sxz();
	}
		})


})	

</script>
<style>
th .layui-table-cell,td {text-align:center;}
.rigtop { width: 1143px; height: 100px;line-height: 100px;margin:auto;margin-top:5px;font-size: 40px;text-align: center;color: #3eafe0;}
.layui-btns {width: 450px;height: 45px;line-height: 32px;position:relative;border-radius: 20px;top:5px}
.divtable{width:1145px;margin:auto;margin-top:-5px;}
.rigtop a{font-size:14px;}
.input{width:275px;}
#tables{width:1000px;height:300px;margin:auto;margin-top:5px;}
#tables,td,th{border:1px solid #3eafe0;}
.sh,#qx{cursor:pointer;}
#div1{margin:auto;width: 200px;padding-top:20px;}
#div2{margin:auto;height:200px;text-align:center;}
</style>
</head>
<body>  
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">充值缴费</a></li>
    <li><a href="#">充值缴费</a></li>
    </ul>
    </div>
    <div class="rigtop">
 南方学院管理系统自动充值中心
    </div>
    <table id="tables">
    <tr>
    <th style="width:200px">选择支付方式</th>
    <th>
      <input type="radio" class="sh"name="zf" id="wxr" checked/><img src='images/wx.png'id="wx" class="sh"width="180px" height="60px"/>
    </th>
    <th>
    <input type="radio"class="sh" name="zf"   id="zfbr"/><img src='images/zfb.jpg' id="zfb" class="sh" width="180px" height="60px"/>
    </th>
    </tr>
      <tr>
    <th>充值金额</th>
    <th colspan=2><input type="text" id="je" onkeyup="value=value.replace(/[^\d]/g,'') " ng-pattern="/[^a-zA-Z]/" style="width:500px;height:50px;font-size:20px;"/><b style="font-size:20px;margin-left:10px">元</b></th>
    </tr>
     <tr>
    <th colspan=3><button class="layui-btn layui-btn-normal layui-btns" id="btn" data-type="getCheckData">充值</button></th>
   
    </tr>
     <tr>
   
    </tr>
    </table>
    <div class="divtable">
</div>


<script>
//充值操作
layui.use('layer', function(){ //独立版的layer无需执行这一句
  var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句

});

var ddh=0;
var coun=0;
var tie="支付宝充值";
var tc;
$("#btn").click(function(){
	var je=$("#je").val();
	if(je.length>0&&je!="0"){
	ddh=xh+times();
	$.ajax({
		url:"XfCost?action=count&Stuidxf="+xh,
		success:function(data){
			coun=data;
		}
	}) 
	if($("#wxr").attr("checked")){
		tie="微信充值"
	}
	else{
		tie="支付宝充值"
	}
		
	  tc=layer.open({
		type:1
		,title:tie
		,content:$("#form")
		,area:['600px','500px']
    })
	}
	else{
		alert("充值金额必须大于0");
	}
	});
	
$(function(){
	$("#sx").click(function(){
		$("#sx").html("刷新成功!请确认是否成功充值!");
		cks();
	})
	$("#qx").click(function(){
		location.reload();
	})
})

function cks(){
	$.ajax({
		url:"XfCost?action=count&Stuidxf="+xh,
		success:function(data){
			if(coun==data){
				
			}
			else{
				remainTime();
			}
		}
	})
}

var i = 5;  
function remainTime(){  
    if(i==0){  
    	location.reload();
       i=5;
    }  
    $("#ewm").html("充值成功,"+i--+"秒后关闭");
    setTimeout("remainTime()",1000);  
}
function sxz(){
	cks();
	 setTimeout("sxz()",3000);
}
</script>
<form  style="background-color: ghostwhite;" id="form" hidden="hidden">
	<div id="div1"></div>
	<div id="div2">
	<br/>
	<br/>
	<p id="ewm">请用手机扫描二维码！<p>
	<br/>
	<p><a href="#" id="sx"><b>已经充值成功？刷新</b></a></p>
	<br/>
	<img  id="qx" src="images/qxs.png"/>
	</div>
</form>	
</body>
</html>
