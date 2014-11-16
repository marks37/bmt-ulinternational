<%-- 
    Document   : login
    Created on : 07 13, 14, 3:58:15 PM
    Author     : mark
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="stylesheet" href="css/login.css" type="text/css"/>
        <link rel="shortcut icon" href="images/unilab_icon.ico" type="image/x-icon">
        <link rel="icon" href="images/unilab_icon.ico" type="image/x-icon">

        <title>Login | Sales Force Management</title>

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/signin.css" rel="stylesheet">

    </head>

    <body>

        <div id="container">

            <div id="logo" >

            </div>

            <div id="login">
                <form class="form-signin" role="form" action="login" method="post">
                    <div id="username">
                        Username
                        <br>
                        <input type="text" class="form-control" name="Username" required autofocus>
                    </div>
                    <div id="password">
                        Password
                        <br>
                        <input type="password" class="form-control"  name="Password" required>
                    </div>

                    <div id="container2">
                        <div id="checkbox">
                            <label class="checkbox">
                                <input type="checkbox" value="remember-me"> Remember me
                            </label>
                        </div>
                        <div id="login_button">
                            <input type="submit" id="submitButton" value="">
                        </div>
                    </div>
                </form>
            </div>

        </div> <!-- /container -->


        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
</html>
