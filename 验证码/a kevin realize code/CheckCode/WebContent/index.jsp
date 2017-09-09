<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function reloadCode(){
		var time = new Date().getTime();
		document.getElementById("imageCode").src="<%=request.getContextPath() %>/servlet/ImageServlet?date="+time;
	}
</script>
</head>
<body>
	<input type="text" name="checkcode"/> 
	<img alt="验证码" id="imageCode" src="<%=request.getContextPath() %>/servlet/ImageServlet" onclick="reloadCode()">
	<a href="javascript:reloadCode()">看不清，换一张</a>
</body>
</html>