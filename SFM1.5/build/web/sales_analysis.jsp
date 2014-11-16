<%-- 
    Document   : sales_analysis
    Created on : 11 10, 14, 4:06:50 AM
    Author     : Mark
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sales Analysis | Sales Force Management</title>
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"/>
        <script src="js/jquery-1.11.1.min.js"></script>

        <link rel="stylesheet" href="css/navbar.css" type="text/css"/>
        <link rel="shortcut icon" href="images/unilab_icon.ico" type="image/x-icon">
        <link rel="icon" href="images/unilab_icon.ico" type="image/x-icon">
    </head>
    <body>

        <!-- Fixed navbar -->
        <div class="navbar navbar-inverse navbar-fixed-top shadow" id="main_navbar" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Business Management Tool</a>
                </div>
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <ul class="nav navbar-nav" style="display: block;">
                            <li><a href="sd_overview.jsp">Home</a></li>
                            <li><a href="accounts_page.jsp">Accounts</a></li>
                            <li class="active"><a href="sales_analysis.jsp">Sales Analysis</a></li>
                            <li><a href="products_page.jsp">Products</a></li>
                            <li><a href="calls_page.jsp">Calls</a></li>

                        </ul>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown ">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                <span class="glyphicon glyphicon-user"></span>
                                <%
                                    String fullname = (String) session.getAttribute("SalesRepName");
                                    out.print(fullname);
                                %>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="profile.jsp"><span class="glyphicon glyphicon-user"></span> &nbsp Profile</a></li>
                                <li><a href="login.jsp"><span class="glyphicon glyphicon-share-alt"></span> &nbsp Log out</a></li>
                            </ul>
                        </li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </div>



        <div class="navbar navbar-default navbar-fixed-top" id="homepage_navbar" role="navigation">
            <div class="container">

                <div class="navbar-collapse collapse" id="inner_wrapper">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">Total Sales</a></li>
                        <li class="active"><a href="#">Accounts</a></li>
                        <li><a href="sales_products.jsp">Products</a></li>
                        <li><a href="sales_forecast.jsp">Forecast</a></li>
                    </ul>

                </div><!--/.nav-collapse -->
            </div>
        </div>

        <div class="container-fluid">
            <div class="sidebar_buttons">
                <a href="sd_overview.jsp"><img class="img-responsive" src="images/Start_of_Day_Logo.png"></a>
                <a href="ce_review_plans.jsp"><img class="img-responsive" src="images/Customer_Engagement_Logo.png"></a>
                <a href="ed_overview.jsp"><img class="img-responsive" src="images/End_of_Day_Logo.png"></a>
            </div>
        </div>

        <div class="container" style="margin-top: 120px">
            <div class="header">
                <h3><small>Sales</small></h3>
            </div>
        </div>

        <div class="container" id="body">
            <div class="row">
                <div class="col-md-12">
                    <div class="">
                        
                    </div>
                </div>
                
            </div>
        </div>

        <script src="js/jquery-1.11.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/docs.min.js"></script>
    </body>
</html>