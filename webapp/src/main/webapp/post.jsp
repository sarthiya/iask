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
<table>
<tr>
<td class="ask-title-cell-key">
<label for="title">Title</label></td>
<td>
<input type="text" id="title" name="Title" rows="4" cols="50">
<!--<input type="submit" value="Submit">-->
</td>

</tr>
<tr>
<td>
<label for="Des" id="des">Description</label></td>
</td>
<td>
<textarea id="description" rows="12" cols="50">
</textarea>
</td>

</tr>
<tr>
<td>

</td>
</tr>
</table>
<input name="regbutton" id="postqu" type="button" class="button" value="Post Question" />
<script>

    $("#postqu").click(function(){  
    	
	/* $.post("http://localhost:8075/login",{Authorization:function make_base_auth(user, password) {
  var tok = user + ':' + password;
  var hash = btoa(tok);
  return "Basic " + hash;
}},  function(data, status){
        alert("Data: " + data + "\nStatus: " + status);
    });*/
    	var title = $("#title").val();
        var description = $("#description").val();
        var username = "admin1";
        var answers = 0;
        var email = $("#email").val();
        $.ajax({
        	url: 'http://localhost:8073/question/create',
        	type: 'POST',
            data: {id: null, 
            	title:title, 
            	description:description,
            	username:username, 
				answers:answers,
				datetime:null}
        });
	});
    </script>
</body>
</head>
</html>