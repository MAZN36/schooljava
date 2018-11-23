<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <link href="css/style1.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>

<style type="text/css">
td {
    font-family: 宋体;
    font-size: 9pt;
    table-layout: fixed;
    word-break: break-all;
}table,td{
    border:1px solid #b7d5df;
    text-align:center;
}

</style>
</head>
<body>
<table id="tables"width="100%" border='1' cellspacing='0' cellpadding='0' >
		<tbody>
		<tr >
			<td width="10%" align="center">序号</td>
			<td width="13%" align="center">时段</td>
			<td width="15%" align="center">节序</td>
			<td width="30%" align="center">时间</td>
			<td width="32%" align="center" >备注</td>
		</tr>
		</tbody>
	</table>

</body>
<script>
	$.ajax({
		url:'Worktime?action=selectAll'
		,success:function(data){
			if(data.code==3){
				alert(data.msg);
				window.parent.parent.index();
			}
			$.each(data.data,function(index,obj){
				var tr=$("<tr/>");
				$("<td/>").html(obj.serial).appendTo(tr);
				$("<td/>").html(obj.interval).appendTo(tr);
				$("<td/>").html(obj.section).appendTo(tr);
				$("<td/>").html(obj.wtime).appendTo(tr);
				$("<td/>").html(obj.wnote).appendTo(tr);
				$("#tables").append(tr);
			})
		}
	})
</script>
</html>