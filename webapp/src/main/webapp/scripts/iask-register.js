$('#submitbutton').click(function(event) {       

    //Get the data from all the fields
    var username = $('#username');
    var password = $('#password');
    var firstname = $('#firstname');
    var lastname = $('lastname');
    var email = $('email');

    $.post('http://localhost:8075/signup', { 	username: "username.val()", 
    											password: "password.val()", 
    											firstname: "firstname.val()",
    											lastname: "lastname.val()",
    											email: "email.val()"}, 
    											function () {
            $('.success_msg').append("Signup successful").fadeIn();
        });
        event.preventDefault();
    }); 