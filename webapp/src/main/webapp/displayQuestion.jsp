<html>
<head>
<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/themes/pepper-grinder/jquery-ui.css" media="screen" rel="stylesheet" type="text/css">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.0/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js" type="text/javascript"></script>
<script type="text/javascript" src="scripts/jquery.ui.core.js"></script>
<script type="text/javascript" src="scripts/jquery.ui.widget.js"></script>
<script src="jquery-2.1.3.js"></script>
<link rel="stylesheet" href="style.css" />
<style>
body{
 margin-left: 175px;
 left:50%;
 text-align: center;
 padding: 100px; 
 vertical-align: middle; 
 height: 300px;
 width: 800px;
 top: 50%;
}

#QuestionText{
border: 1px ;
border-style: solid none;
}


.TitleAndDescriptionTable{
border: 1px ;
//border: 5px green;
border-bottom: 1px solid black;
}

#AnswerText{
/* border: 5px; */
/* border-style: solid none; */
}

</style>

<body>
<%@include file="mainmenu.jsp" %>
<table width="900">
<h1> myquestions.com</h1>
<tr>
<td class="TitleAndDescriptionTable" height="50">
<label> Title: </label>
<label id="formatQuestion"></label>
</td>
</tr>

<tr> 
<td height="150">
<label> Question: </label>
<div id ="QuestionText"></div>
</td>
</tr>

<tr>
<td height="50">
<label id="Answers" id="formatAnswes">Answers:</label>
</td>
</tr>
<tr>  <td height="50">
<div id ="AnswerText"> </div>
</td>
</tr>

</table>
<input name="regbutton" id="postqu" type="button" class="button" value="Post Your Answer" />
</body>
<script>

	$(document).ready(function(){
	 	//http://localhost:8080/test/rest/question
	   $.getJSON("array.json", function(data) {
	       var output="<table style='width:100%'><tr><td height='100'><ul> "+data.question+"</ul></td></tr></table>";
	       document.getElementById("QuestionText").innerHTML=output;
		   
		   var question="<table style='width:100%'><tr><td><ul>"+data.title+"</ul></td></tr></table>";
	       document.getElementById("formatQuestion").innerHTML=question;
	
	       var ansOutput="<table style='width:100%' border=1px>";
	         for (var i in data.answersarray) {
	        	 ansOutput+="<tr><td height='75'><ul>"+data.answersarray[i].answer + "</ul></td></tr>";
	        	 //document.getElementById("AnswerText").innerHTML=ansOutput;
	         }
	         ansOutput+="</table>";
	         document.getElementById("AnswerText").innerHTML=ansOutput;
	       
	       
	       
	   });

	});
</script>

</head>
</html>