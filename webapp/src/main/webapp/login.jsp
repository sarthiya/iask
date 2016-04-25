<html>
<head>
<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/themes/pepper-grinder/jquery-ui.css" media="screen" rel="stylesheet" type="text/css">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.0/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js" type="text/javascript"></script>
<script type="text/javascript" src="scripts/jquery.ui.core.js"></script>
<script type="text/javascript" src="scripts/jquery.ui.widget.js"></script>
<script src="jquery-2.1.3.js"></script>
<link rel="stylesheet" href="style.css" />
<h1> myquestions.com</h1>
<body>

<div id="login-form">
    <form action="" method="post" name="signup/login" class="register">
        <fieldset>
            <div class="login-form">
                <label for="usernname"><b>Username:</b></label>
                <input name="username" id="username" />
            </div>
            <div class="login-form">
                <label for="password"><b>Password:</b></label>
                <input name="password" type="password" id="password"  />
            </div>
			<input name="login" type="button" id="post-btn" class="button" value="login" />
			

        </fieldset>
    </form>
</div>

<script>
var username = $('#username').val();
var password = $('#password').val();




    $("#post-btn").click(function(){   
	/* $.post("http://localhost:8075/login",{Authorization:function make_base_auth(user, password) {
  var tok = user + ':' + password;
  var hash = btoa(tok);
  return "Basic " + hash;
}},  function(data, status){
        alert("Data: " + data + "\nStatus: " + status);
    });*/
 $.ajax({
         type: "post",
         url: "http://localhost:8075/login",
		 contentType: "text/plain",
         headers:{
		 Authorization: "Basic dXNlcjpwYXNz",
		 },
         success: function () {
         alert("success");
     },
        dataType: 'json',
		success: function (data) {
        console.info(data);
    }
        });
	});
</script>
</body>
</head>
</html>