<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/themes/pepper-grinder/jquery-ui.css" media="screen" rel="stylesheet" type="text/css">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.0/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js" type="text/javascript"></script>
<script type="text/javascript" src="scripts/jquery.ui.core.js"></script>
<script type="text/javascript" src="scripts/jquery.ui.widget.js"></script>
<script src="scripts/jquery-2.1.3.js"></script>
<script>
$(document).ready(function() {
	$('#loginbutton').click(function(event) {       
	    $.ajax({
	        xhrFields: {
	            withCredentials: true
	        },
	        dataType: "jsonp",
	        async: false,
	        crossDomain: true,
	        url: "http://localhost:8073/auth/login",
	        success: function (jsonData) {
	            console.log(jsonData);
	        },
	        error: function (request, textStatus, errorThrown) {
	            console.log(request.responseText);
	            console.log(textStatus);
	            console.log(errorThrown);
	        }
	    });
	});
});
</script>
<link rel="stylesheet" href="mystyle.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main Menu</title>

</head>

<body class="center">
	<p align="right">
		Welcome
		<%
	if(session.getAttribute("username")!=null){
	out.println(" "+(String) session.getAttribute("username"));
	}
	%>
	</p>
	<img src="iask.png" alt="iAsk.com ">
	<button onclick="imageClick('displayQuestion.jsp')">Questions</button>
	<button onclick="imageClick('post.jsp')">Ask</button>
	<button onclick="imageClick('signup.jsp')">Sign up</button>
	<div style='float: right;'>
		<button id="loginbutton">Login</button>
	</div>
	<div style='float: right;'>
		<button id="logoutbutton">Logout</button>
	</div>
  	<div class="container-1">
      <span class="icon"><i class="fa fa-search"></i></span>
      <input type="search" id="search" placeholder="Search Q&A..." align="right"/>
  	</div>
  	<br>
  	<br>
	

</body>
</html>