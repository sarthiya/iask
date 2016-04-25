<html>
<head>
<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/themes/pepper-grinder/jquery-ui.css" media="screen" rel="stylesheet" type="text/css">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.0/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js" type="text/javascript"></script>
<script type="text/javascript" src="scripts/jquery.ui.core.js"></script>
<script type="text/javascript" src="scripts/jquery.ui.widget.js"></script>
<script src="scripts/jquery-2.1.3.js"></script>
<link rel="stylesheet" href="style.css" />

<body>
<%@include file="mainmenu.jsp" %>

<div id="templates" style="display: none;">
<table>
<tr><td><ul><li>Questionid</td><td>Noofanswers</td><td>date</td><td>username</td></tr></li> </ul>
</table>
</div>
  <div id="content">
   <div id="tab-container">
      <ul>
	     <li ><a href="display.jsp">All questions</a></li>
         <li class="selected" ><a href="recentquestions.jsp">Recent Questions</a></li>
     
      </ul>
   </div>
   <div id="main-container">
   </div>
</div>
<script src="jquery-2.1.3.js"></script>
<script>

  $.getJSON("rest/question", function(data) {
        var output="<table border='1' style='width:100%'>";
        for (var i in data) {
          output+="<tr><td><ul><li>Title:<a href='"+data[i].id+"'>" + data[i].questions + "</a></li><li> Date/Time:" + new Date(data[i].timeval) + "</li><li>Username:" + data[i].username+"</li><li>No of Answers:" + data[i].noans+"</li></ul></td></tr>";
        }
        output+="</table>";
      document.getElementById("main-container").innerHTML=output;
  });



	</script>
</body>
</head>
</html>