<%-- 
    Document   : homepage
    Created on : 07 13, 14, 3:59:32 PM
    Author     : marksantiago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Start of Day | Sales Force Management</title>
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"/>
        <script src="js/jquery-1.11.1.min.js"></script>

        <link rel="stylesheet" href="css/navbar.css" type="text/css"/>
        <link rel="stylesheet" href="css/overview.css" type="text/css"/>
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
                        <!--<ul class="nav navbar-nav" style="display: block;">-->
                        <li class="active"><a href="initializeHomepage">Home</a></li>
                        <li><a href="accounts_page.jsp">Accounts</a></li>
                        <li><a href="initializeSalesAnalysis">Sales Analysis</a></li>
                        <li><a href="products_page.jsp">Products</a></li>
                        <li><a href="calls_page.jsp">Calls</a></li>

                        <!--</ul>-->
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
                        <li class="active"><a href="sd_overview.jsp">Overview</a></li>
                        <li><a href="sd_objectives.jsp">Objectives</a></li>
                        <li><a href="sd_sales.jsp">Sales</a></li>
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

        <div class="container" style="margin-top: 120px">
            <div class="header">
                <h3><small>Start of Day</small></h3>
            </div>
        </div>

        <div class="container" id="body">
            <div class="row">

                <div class="col-md-6">
                    <div class="panel panel-default" onclick="location.href = 'sd_objectives.jsp';" style="cursor: pointer;">
                        <div class="panel-body">
                            <div id="logo">
                                <a><img class="img-responsive" src="images/objectives_logo.png"></a>
                            </div>
                            <div id="text-title">
                                <h4>Today's Objectives</h4>
                            </div>
                            <div id="text-body">
                                <%
                                    int obj_count = (int) session.getAttribute("ObjectivesCount");
                                %>
                                <h5 style="margin-top: 20px">You have <%=obj_count%> objectives</h5>
                                <!--<h5 style="margin-top: 2px">0 objectives</h5>-->
                                <!--<h3><small>You have 0 objectives</small></h3>-->

                            </div>

                        </div>
                        <div class="panel-footer">View Details</div>
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div id="logo">
                                <a><img class="img-responsive" src="images/products_logo.png"></a>
                            </div>
                            <div id="text-title">
                                <h4>Product Updates</h4>
                            </div>
                            <div id="text-body">
                                <h5 style="margin-top: 10px">There are no product </h5>
                                <h5 style="margin-top: 2px">updates at the moment</h5>

                            </div>

                        </div>
                        <div class="panel-footer">View Details</div>
                    </div>
                </div>

            </div>

            <div class="row">
                <div class="col-md-6">
                    <div class="panel panel-default" onclick="location.href = 'sd_sales.jsp';" style="cursor: pointer;">
                        <div class="panel-body">
                            <div class="demo" id="logo">
                                <%
                                    long SalesPerformance = (long) session.getAttribute("SalesPerformance");
                                %>
                                <input data-width="100%" class="knob" data-fgColor="#46b8da" style="color: #46b8da" data-thickness=".4" readonly value="<%=SalesPerformance%>">
                            </div>

                            <%
                                String month = (String) session.getAttribute("CurrentMonth");
                                long MTDSales = (long) session.getAttribute("MTDSales");
                                long MonthTarget = (long) session.getAttribute("MonthTarget");
                                
                            %>
                            <div id="text-title">
                                <h5>My Sales achievement this</h5>
                                <h4 style="margin-top: 10px"><%=month%>:</h4>
                            </div>
                            <div id="text-body">
                                <!--<h5 style="margin-top: 10px">As of </h5>-->
                                <br>
                                <h3 style="margin-top: 2px"><%=MTDSales%> Baht</h3>
                            </div>

                        </div>
                        <div class="panel-footer">View Details</div>
                    </div>    
                </div>
                <div class="col-md-6">
                    <div class="panel panel-default" onclick="location.href = 'sd_calls.jsp';" style="cursor: pointer;">
                        <div class="panel-body">
                            <div class="demo" id="logo">
                                <%
                                    int CallPerformance = (int) session.getAttribute("CallPerformance");
                                %>
                                <input data-width="100%" class="knob" data-fgColor="#66CC66" style="color: #46b8da" data-thickness=".4" readonly value="<%=CallPerformance%>">
                            </div>
                            <div id="text-title">
                                <h5>My Call performance this</h5>
                                <h4 style="margin-top: 10px"><%=month%>:</h4>
                            </div>
                            <div id="text-body">
                                <%
                                    int CoveredCalls = (int) session.getAttribute("CoveredCalls");
                                    int TotalCalls = (int) session.getAttribute("TotalCalls");
                                %>
                                <!--<h5 style="margin-top: 10px">As of </h5>-->
                                <BR>
                                <h3 style="margin-top: 2px"><%=CoveredCalls%> Calls</h3>
                                <!--<h5>2000 / 10000 </h5>-->
                                <!--<h3><small>2000 / 10000 Sales achieved</small></h3>-->
                            </div>

                        </div>
                        <div class="panel-footer">View Details</div>
                    </div>
                </div>
            </div>


        </div>




        <script src="js/jquery-1.11.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/docs.min.js"></script>

    </body>
</html>
