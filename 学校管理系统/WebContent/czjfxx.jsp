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
.rigtop { width: 1143px; height: 40px;border: 1px solid #b7d5df;line-height: 40px;margin:auto;margin-top:5px;text-align:center;}
.layui-btns {width: 100px;height: 32px;line-height: 32px;position:relative;float:right;border-radius: 20px;top:5px}
.divtable{width:1145px;margin:auto;margin-top:-5px;}
.rigtop a{font-size:14px;}
.input{width:275px;}

</style>
</head>
<body>  
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">充值缴费</a></li>
    <li><a href="#">费用详细</a></li>
    </ul>
    </div>
    <div class="rigtop">
   <a>当前数据仅作为参考,有问题请及时反馈,谢谢!</a> 
    </div>
    <div class="divtable">
<table id="demo" lay-filter="demo" ></table>
</div>
<script>
var table=null;
var form=null;
layui.use(['table','form'], function(){
	table= layui.table;
	form=layui.form;
  //第一个实例
  table.render({
    elem: '#demo'
    ,height: 471
    ,page:true
    ,url: 'XfCost?action=select' //数据接口
    ,cols: [[ //表头
    	{type:'numbers', title: '序号'}
      ,{field: 'jysj', title: '交易时间',align:'center'}
      ,{field: 'danhao', title: '订单号',align:'center'}
      ,{field: 'jyqyr', title: '交易前余额',align:'center'}
      ,{field: 'jyhyr', title: '交易后余额',align:'center'}
      ,{field: 'jyyr', title: '交易余额',align:'center'}
      ,{field: 'jyfs', title: '交易方式',align:'center'}
      ,{field: 'jylx', title: '交易类型',align:'center'}
    
    ]],
  });

});

</script>
<script>
layui.use('table', function(){
  var table = layui.table;
  //监听工具条
  table.on('tool(demo)', function(obj){
    var data = obj.data;
      if(obj.event === 'edit'){
    	  $("#Tname").val(data.gname)
 		 $("#TMremarks").val(data.gnote)
    	  upda(data.gid);
    } 
      else if(obj.event === 'del'){
	      layer.confirm('真的删除行么', function(index){
	    	  del(data.gid);
	      });
      }
  });
  
});
function del(Tid){
	$.ajax({
		type:"get"
		,url:"Grade?action=delete"
		,data:{GId:Tid
			}
		,success:function(data){
			if(data>0){
				//关闭
  				 layer.closeAll();
				layer.msg("删除成功",{time: 1000});
				//重载
				table.reload('demo', {
			        page: {
			          curr: 1 //重新从第 1 页开始
			        }
				});
			}
			else{
				layer.msg("demo",{time: 1000});
			}
		}
	});
}

</script>
<form class="layui-form" style="background-color: ghostwhite;" id="form" hidden="hidden">
	<table>
	<tr><td><div style="height:30px"></div></td></tr>
		<tr>
			<td><div class="layui-form-item">
			    <label class="layui-form-label" style="font-size:18px" >年级名称:</label>
			      <div class="layui-input-inline">
			        <input type="tel" name="phone" id="Tname" lay-verify="required|phone" autocomplete="off" class="layui-input input">
			      </div>
  			</div></td>
		</tr>
		<tr>
			<td><div class="layui-form-item layui-form-text">
			    <label class="layui-form-label"  style="font-size:18px">备注:</label>
			    <div class="layui-input-inline">
			      <textarea placeholder="请输入内容" id="TMremarks" class="layui-textarea input"></textarea>
			    </div>
			  </div></td>
		</tr>
	</table>
</form>	
</body>
</html>