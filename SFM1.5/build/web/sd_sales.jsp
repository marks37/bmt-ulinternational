<%-- 
    Document   : homepage
    Created on : 07 13, 14, 3:59:32 PM
    Author     : marksantiago
--%>

<%@page import="Entities.SalesProgress"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sales | Sales Force Management</title>
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"/>
        <link rel="stylesheet" type="text/css" href="css/dataTables.tableTools.css">
        <link rel="stylesheet" type="text/css" href="css/jquery.dataTables.css">
        <script src="js/jquery-1.11.1.min.js"></script>

        <link rel="stylesheet" href="css/navbar.css" type="text/css"/>
        <link rel="stylesheet" href="css/sales_perf.css" type="text/css"/>
        <link rel="shortcut icon" href="images/unilab_icon.ico" type="image/x-icon">
        <link rel="icon" href="images/unilab_icon.ico" type="image/x-icon">

        <script src="js/jquery.knob.min.js"></script>
        <script>
            $(function ($) {

                $(".knob").knob({
                    format: function (value) {
                        return value + '%';
                    },
                    change: function (value) {
                        //console.log("change : " + value);
                    },
                    release: function (value) {
                        //console.log(this.$.attr('value'));
                        console.log("release : " + value);
                    },
                    cancel: function () {
                        console.log("cancel : ", this);
                    },
                    /*format : function (value) {
                     return value + '%';
                     },*/
                    draw: function () {

                        // "tron" case
                        if (this.$.data('skin') == 'tron') {

                            this.cursorExt = 0.3;

                            var a = this.arc(this.cv)  // Arc
                                    , pa                   // Previous arc
                                    , r = 1;

                            this.g.lineWidth = this.lineWidth;

                            if (this.o.displayPrevious) {
                                pa = this.arc(this.v);
                                this.g.beginPath();
                                this.g.strokeStyle = this.pColor;
                                this.g.arc(this.xy, this.xy, this.radius - this.lineWidth, pa.s, pa.e, pa.d);
                                this.g.stroke();
                            }

                            this.g.beginPath();
                            this.g.strokeStyle = r ? this.o.fgColor : this.fgColor;
                            this.g.arc(this.xy, this.xy, this.radius - this.lineWidth, a.s, a.e, a.d);
                            this.g.stroke();

                            this.g.lineWidth = 2;
                            this.g.beginPath();
                            this.g.strokeStyle = this.o.fgColor;
                            this.g.arc(this.xy, this.xy, this.radius - this.lineWidth + 1 + this.lineWidth * 2 / 3, 0, 2 * Math.PI, false);
                            this.g.stroke();

                            return false;
                        }
                    }
                });

                // Example of infinite knob, iPod click wheel
                var v, up = 0, down = 0, i = 0
                        , $idir = $("div.idir")
                        , $ival = $("div.ival")
                        , incr = function () {
                            i++;
                            $idir.show().html("+").fadeOut();
                            $ival.html(i);
                        }
                , decr = function () {
                    i--;
                    $idir.show().html("-").fadeOut();
                    $ival.html(i);
                };
                $("input.infinite").knob(
                        {
                            min: 0
                            , max: 20
                            , stopper: false
                            , change: function () {
                                if (v > this.cv) {
                                    if (up) {
                                        decr();
                                        up = 0;
                                    } else {
                                        up = 1;
                                        down = 0;
                                    }
                                } else {
                                    if (v < this.cv) {
                                        if (down) {
                                            incr();
                                            down = 0;
                                        } else {
                                            down = 1;
                                            up = 0;
                                        }
                                    }
                                }
                                v = this.cv;
                            }
                        });
            });
        </script>

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
                            <li class="active"><a href="initializeHomepage">Home</a></li>
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



        <div class="navbar navbar-default navbar-fixed-top" id="homepage_navbar" role="navigation">
            <div class="container">

                <div class="navbar-collapse collapse" id="inner_wrapper">
                    <ul class="nav navbar-nav">
                        <li><a href="sd_overview.jsp">Overview</a></li>
                        <li><a href="sd_objectives.jsp">Objectives</a></li>
                        <li class="active"><a href="sd_sales.jsp">Sales</a></li>
                        <li><a href="sd_calls.jsp">Calls</a></li>
                    </ul>

                </div><!--/.nav-collapse -->
            </div>
        </div>

        <div class="container-fluid">
            <div class="sidebar_buttons">
                <a href="initializeHomepage"><img class="img-responsive" src="images/Start_of_Day_Logo.png"></a>
                <a href="initializeCustomerEngagement"><img class="img-responsive" src="images/Customer_Engagement_Logo.png"></a>
                <a href="ed_overview.jsp"><img class="img-responsive" src="images/End_of_Day_Logo.png"></a>
            </div>
        </div>

        <div class="header container" style="margin-top: 120px">
            <div>
                <h3><small>Start of Day</small></h3>
            </div>
        </div>

        <div class="container" id="body">
            <div class="row">

                <div class="col-md-10">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table display" cellspacing="0" id="sales_forecast">
                                    <%
                                        ArrayList<SalesProgress> SalesProgress = (ArrayList<SalesProgress>) session.getAttribute("SalesProgress");
                                    %>
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Customer Code</th>
                                            <th>Customer Name</th>
                                            <th>Actual Sales</th>
                                            <th>Month Target</th>
                                            <th>Progress</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            for (int a = 0; a < SalesProgress.size(); a++) {
                                                int index = a + 1;
                                                String AccountCode = SalesProgress.get(a).getAccountCode();
                                                String EnglishName = SalesProgress.get(a).getEnglishName();
                                                double ActualSales = SalesProgress.get(a).getActualSales();
                                                double MonthTarget = SalesProgress.get(a).getSalesTarget();
                                                long MTDSales2 = Math.round(ActualSales);
                                                long MonthTarget2 = Math.round(MonthTarget);
                                                long SalesPerformance = Math.round((ActualSales * 100.0f) / MonthTarget);

                                        %>

                                        <tr>
                                            <td><%=index%></td>
                                            <td><%=AccountCode%></td>
                                            <td><%=EnglishName%></td>
                                            <td><%=MTDSales2%></td>
                                            <td><%=MonthTarget2%></td>
                                            <td>
                                                <div class="progress">
                                                    <div class="progress-bar" role="progressbar" aria-valuenow="<%=SalesPerformance%>" aria-valuemin="0" aria-valuemax="100" style="width: <%=SalesPerformance%>%;">
                                                        <span class="sr-only"><%=SalesPerformance%>% Complete</span>
                                                    </div>
                                                </div>
                                            </td>
                                        </tr>

                                        <%
                                            }
                                        %>
                                    </tbody>
                                </table>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="col-md-2">
                    <div class="panel panel-default">

                        <div class="panel-heading">
                            <h4>Sales</h4>
                            <h4>Performance</h4>
                        </div>

                        <div class="panel-body" id="sales_perf">

                            <div id="text-title">
                                <!--<h3><small>Sales Performance</small></h3>-->

                            </div>
                            <!--<hr>-->
                            <div class="demo" id="logo">
                                <%
                                    long SalesPerformance = (long) session.getAttribute("SalesPerformance");
                                %>
                                <input data-width="100%" class="knob" data-fgColor="#46b8da" style="color: #46b8da" data-thickness=".4" readonly value="<%=SalesPerformance%>">
                            </div>
                            <!--<hr>-->
                            <div id="text-body">
                                <!--                                <h4 style="margin-bottom: 10px"><small>As of Nov. 5, 2014</small></h4>
                                                                <h5>Actual Sales:</h5>
                                                                <h5 style="margin-top: 2px">P 9,000 (-1,000)</h5>
                                                                <h5 style="margin-top: 2px"></h5>
                                                                <h5>2000 / 10000 </h5>
                                                                <h5 style="margin-top: 10px">Target Sales:</h5>
                                                                <h5 style="margin-top: 2px">P 10,000 (+1,000)</h5>
                                                                <h5 style="margin-top: 2px"></h5>
                                                                <h5>2000 / 10000 </h5>
                                                                <h3><small>2000 / 10000 Sales achieved</small></h3>-->
                            </div>

                        </div>

                        <div class="panel-footer" id="sales_perf_footer">
                            <%
                                String date = (String) session.getAttribute("CurrentDate");
                                long MTDSales = (long) session.getAttribute("MTDSales");
                                long MonthTarget = (long) session.getAttribute("MonthTarget");
                                long difference = MonthTarget - MTDSales;
                            %>
                            <h4 style="margin-bottom: 10px"><small>As of <%=date%></small></h4>
                            <h5>Actual Sales:</h5>
                            <h5 style="margin-top: 2px"><%=MTDSales%> (-<%=difference%>)</h5>
                            <h5 style="margin-top: 10px">Target Sales:</h5>
                            <h5 style="margin-top: 2px"><%=MonthTarget%> (+<%=difference%>)</h5>
                        </div>

                    </div>
                </div>

            </div>



        </div>




        <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" charset="utf8" src="js/jquery.dataTables.js"></script>
        <script type="text/javascript" charset="utf8" src="js/dataTables.tableTools.js"></script>


        <script>
            $(document).ready(function () {
                $('#sales_progress').DataTable();
            });
        </script>

    </body>
</html>
