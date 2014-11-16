<%-- 
    Document   : homepage
    Created on : 07 13, 14, 3:59:32 PM
    Author     : marksantiago
--%>

<%@page import="Entities.DailyObjectives"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Review Plans | Sales Force Management</title>
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"/>
        <link rel="stylesheet" type="text/css" href="css/dataTables.tableTools.css">
        <link rel="stylesheet" type="text/css" href="css/jquery.dataTables.css">

        <link rel="stylesheet" href="css/navbar.css" type="text/css"/>
        <link rel="stylesheet" href="css/objectives.css" type="text/css"/>
        <link rel="shortcut icon" href="images/unilab_icon.ico" type="image/x-icon">
        <link rel="icon" href="images/unilab_icon.ico" type="image/x-icon">

    </head>
    <body>

        <!-- Fixed navbar -->
        <div class="navbar navbar-inverse navbar-fixed-top shadow" id="main_navbar" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Sales Force Management</a>
                </div>
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <ul class="nav navbar-nav" style="display: block;">
                            <li class="active"><a href="sd_overview.jsp">Home</a></li>
                            <li><a href="accounts_page.jsp">Accounts</a></li>
                            <li><a href="initializeSalesAnalysis">Sales Analysis</a></li>
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


        <!-- Fixed navbar -->
        <div class="navbar navbar-default navbar-fixed-top" id="homepage_navbar" role="navigation">
            <div class="container">

                <div class="navbar-collapse collapse" id="inner_wrapper">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">Review Plans</a></li>
                        <li><a href="#">Sales Objective</a></li>
                        <li><a href="#">Purchase History</a></li>
                        <li><a href="#">Trending Products</a></li>
                        <li><a href="#">Product List</a></li>
                        <li><a href="#">Suggested Orders</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </div>

        <div class="container-fluid">
            <div class="sidebar_buttons">
                <a href="sd_overview.jsp"><img class="img-responsive" src="images/Start_of_Day_Logo.png"></a>
                <a href="#"><img class="img-responsive" src="images/Customer_Engagement_Logo.png"></a>
                <a href="ed_overview.jsp"><img class="img-responsive" src="images/End_of_Day_Logo.png"></a>
            </div>
        </div>

        <div class="header container" style="margin-top: 120px">
            <div>
                <h3><small>Customer Engagement</small></h3>
            </div>
        </div>

        <div class="container" id="body">
            <div class="row">

                <div class="col-md-12">
                    <div class="panel panel-default">
                        <!--                        <div class="panel-heading">
                                                    Objectives
                                                </div>-->

                        <div class="panel-body">

                            <div class="table-responsive">

                                <form method="post" action="initiateCustomerEngagement" id="accounts">

                                    <table class="table display" cellspacing="0" id="list_accounts">
                                        <%
                                            ArrayList<DailyObjectives> objectives = (ArrayList<DailyObjectives>) session.getAttribute("Objectives");
                                        %>
                                        <thead>
                                            <tr>
                                                <th style="width: 100px;" class="text-center">Status</font></th>
                                                <th>Customer Code</th>
                                                <th>Customer Name</th>
                                                <th>Address</th>
                                                <th>Contact</th>
                                                <th>Activity Type</th>
                                                <th>Sales Target</th>
                                                <th>Availability Target</th>
                                            </tr>
                                        </thead>

                                        <tbody>
                                            <%
                                                for (int a = 0; a < objectives.size(); a++) {
                                                    int index = a + 1;
                                                    String CallNo = objectives.get(a).getCallNo();
                                                    String AccountCode = objectives.get(a).getAccountCode();
                                                    String EnglishName = objectives.get(a).getEnglishName();
                                                    String Address = objectives.get(a).getAddress();
                                                    String CallStatus = objectives.get(a).getCallStatus();
                                                    String Contact = objectives.get(a).getContact();
                                                    String ActivityType = objectives.get(a).getActivityType();
                                                    String SalesTarget = objectives.get(a).getSalesTarget();
                                                    String AvailabilityTarget = objectives.get(a).getAvailabilityTarget();
                                                    String src = "";
                                                    if (CallStatus.equalsIgnoreCase("New")) {
                                                        src = "images/redb.png";
                                                    } else {
                                                        src = "images/greenb.png";
                                                    }
                                            %>

                                            <tr data-target="#myModal" data-toggle="modal">
                                                <td class="text-center"><img width="17" height="17" src="<%=src%>"></td>
                                                <td><input style="display: none" type="radio" name="AccountCode" value="<%=AccountCode%>"><%=AccountCode%></td>
                                                <td><input style="display: none" type="radio" name="CallNo" value="<%=CallNo%>"><%=EnglishName%></td>
                                                <td><%=Address%></td>
                                                <td><%=Contact%></td>
                                                <td><%=ActivityType%></td>
                                                <td><%=SalesTarget%></td>
                                                <td><%=AvailabilityTarget%></td>
                                            </tr>
                                            <%
                                                }
                                            %>
                                        </tbody>
                                    </table>
                                </form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <!-- Modal -->
        <div class="modal" tabindex="-1" id="myModal" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog" style="width: 300px; height: 10px;">
                <div class="modal-content">
                    <div class="modal-body">
                        <span class="glyphicon glyphicon-question-sign"></span>
                        Do you want to proceed with the Call?
                        <div class="modal-footer">
                            <button type="button" class="btn btn-primary" onclick="submit()">&nbsp Yes &nbsp</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">No</button>
                        </div>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->



        <script src="js/jquery-1.11.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/jquery.dataTables.js"></script>
        <script type="text/javascript" src="js/dataTables.tableTools.js"></script>
        <script type="text/javascript" src="js/modal.js"></script>
        <script type="text/javascript" src="js/doc.min.js"></script>

        <script>
                                $(document).ready(function () {
                                    var table = $('#list_accounts').DataTable({
                                        "paging": false,
                                        "ordering": false,
                                        "info": false,
                                        "filter": false
                                    });

                                    $('#list_accounts tbody').on('click', 'tr', function () {
                                        $('#myModal').modal('show');
                                        $(':radio', this).each(function () {
                                            this.checked = true;
                                        });
                                    });

                                });

                                function submit() {
                                    document.getElementById("accounts").submit();
                                }

        </script>

    </body>
</html>
