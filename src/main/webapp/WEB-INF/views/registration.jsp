<%@page contentType="text/html" isELIgnored="false" pageEncoding="windows-1252"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Registration</title>
        <!-- Meta-Tags -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta charset="utf-8">
        <meta name="keywords" content="Business Login Form a Responsive Web Template, Bootstrap Web Templates, Flat Web Templates, Android Compatible Web Template, Smartphone Compatible Web Template, Free Webdesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design">
        <script>
            addEventListener("load", function () {
                setTimeout(hideURLbar, 0);
            }, false);

            function hideURLbar() {
                window.scrollTo(0, 1);
            }
        </script>
        <spring:url value="/resources" var="mres" />  

        <!-- //Meta-Tags -->
        <!-- Font Awesome -->
        <link rel="stylesheet" href="${mres}/plugins/fontawesome-free/css/all.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
        <!-- icheck bootstrap -->
        <link rel="stylesheet" href="${mres}/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
        <!-- Google Font: Source Sans Pro -->
        <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
        <!-- css files -->
        <link href="${mres}/plugins/login-css/style.css" rel="stylesheet" type="text/css" media="all"/>
        <!-- //css files -->

    </head>
    <body>

        <div class="signupform">
            <div class="container">
                <!-- main content -->
                <div class="agile_info">
                    <div class="w3l_form">
                        <div class="left_grid_info">
                            <h1>Class Net</h1>
                            <p>Perhaps Join us</p>
                            <img src="${mres}/images/DAIICT_logo.png" alt="class-net" />
                        </div>
                    </div>
                    <div class="w3_info">
                        <h2>Registration </h2>
                        <!-- <p>Enter your DAIICT email id.</p> -->
                        <h3 style="color:red;"> ${err_msg} </h3>

                        <form action="registration" method="post">
                            <!-- <label>Email Address</label> -->
                            <div class="input-group">
                                <span class="fa fa-envelope" aria-hidden="true"></span>
                                <input type="email" placeholder="Enter Your DAIICT Email" name="email" required=""> 
                            </div>

                            <div class="input-group">
                                <span class="fa fa-user" aria-hidden="true"></span>
                                <input type="text" placeholder="Enter Your Name" name="name" required=""> 
                            </div>


                            <p style="color: green;"> ${success_msg} </p>

                            <button class="btn btn-danger btn-block" type="submit">Register</button >                
                        </form>
                        
                        <p class="account1">Already have a account ? <a href="./login">Login here</a></p>
                    </div>
                </div>
                <!-- //main content -->
            </div>
            <!-- footer -->
            <div class="footer">
                <p>&copy; 2019 Business login form. All Rights Reserved | Design by <a href="https://w3layouts.com/" target="blank">W3layouts</a></p>
            </div>
            <!-- footer -->
        </div>

    </body>
</html>