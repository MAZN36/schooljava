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
</style>
</head>
<body>  
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">信息查询</a></li>
    <li><a href="#">个人学分查询</a></li>
    </ul>
    </div>
    
    
    <div class="layui-form-item layui-form" style="margin-top: 10px;margin-bottom: 0px;margin-right: 10px;">
     <div class="layui-inline" >
      <label class="layui-form-label"  >班级:</label>
      <div class="layui-input-inline">
        <select name="quiz">
          <option value="">S1S143</option>
          <option value="">S2S143</option>
        </select>
      </div>
     </div>
    </div>
    
   <canvas id="a_canvas" width="800" height="400"></canvas>  
    

<script src="js/layui/layui.js" charset="utf-8"></script>
<script>
var table=null;
var form=null;
layui.use(['table','form'], function(){
	table= layui.table;
	form=layui.form;
 
  
});

</script>

<script>    
    (function (){    
     
        window.addEventListener("load", function(){    
     
          var data = [50,30,20,30,20,20,10,50,20,50,10,10];    
          var xinforma = ['HTML5与CSS3网页设计','项目实战','专业英语','4月','5月','6月','7月','8月','9月','10月','11月','12月'];    
     
          // 获取上下文    
          var a_canvas = document.getElementById('a_canvas');    
          var context = a_canvas.getContext("2d");    
     
     
          // 绘制背景    
          var gradient = context.createLinearGradient(0,0,0,300);    
     
     
         // gradient.addColorStop(0,"#e0e0e0");    
          //gradient.addColorStop(1,"#ffffff");    
     
     
          context.fillStyle = gradient;    
     
          context.fillRect(0,0,a_canvas.width,a_canvas.height);    
     
          var realheight = a_canvas.height-15;    
          var realwidth = a_canvas.width-40;    
          // 描绘边框    
          var grid_cols = data.length + 1;    
          var grid_rows = 4;    
          var cell_height = realheight / grid_rows;    
          var cell_width = realwidth / grid_cols;    
          context.lineWidth = 1;    
          context.strokeStyle = "#a0a0a0";    
     
          // 结束边框描绘    
          context.beginPath();    
          // 准备画横线    
          /*for(var row = 1; row <= grid_rows; row++){    
            var y = row * cell_height;    
            context.moveTo(0,y);    
            context.lineTo(a_canvas.width, y);    
          }*/    
              
            //划横线    
            context.moveTo(0,realheight);    
            context.lineTo(realwidth,realheight);    
                    
                 
            //画竖线    
          context.moveTo(0,20);    
           context.lineTo(0,realheight);    
          context.lineWidth = 1;    
          context.strokeStyle = "black";    
          context.stroke();    
                  
     
          var max_v =0;    
              
          for(var i = 0; i<data.length; i++){    
            if (data[i] > max_v) { max_v =data[i]};    
          }    
          max_vmax_v = max_v * 1.1;    
          // 将数据换算为坐标    
          var points = [];    
          for( var i=0; i < data.length; i++){    
            var v= data[i];    
            var px = cell_width *　(i +1);    
            var py = realheight - realheight*(v / max_v);    
            //alert(py);    
            points.push({"x":px,"y":py});    
          }    
     
          //绘制坐标图形    
          for(var i in points){    
            var p = points[i];    
            context.beginPath();    
            context.fillStyle="green";    
            context.fillRect(p.x,p.y,15,realheight-p.y);    
                 
            context.fill();    
          }    
          //添加文字    
          for(var i in points)    
          {  var p = points[i];    
            context.beginPath();    
            context.fillStyle="black";    
            context.fillText(data[i], p.x + 1, p.y - 15);    
             context.fillText(xinforma[i],p.x + 1,realheight+12);    
             context.fillText('月份',realwidth,realheight+12);    
             context.fillText('资金量',0,10);    
              }    
        },false);    
      })();    
           
</script>    

</body>
</html>
