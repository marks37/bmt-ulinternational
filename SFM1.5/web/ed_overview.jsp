<%-- 
    Document   : ed_overview
    Created on : 11 8, 14, 12:46:22 PM
    Author     : Mark
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>End of Day | Sales Force Management</title>
        <!--        <link rel="stylesheet" href="css/bootstrap-theme.css" type="text/css"/>
                <link rel="stylesheet" href="css/bootstrap-theme.min.css" type="text/css"/>
                <link rel="stylesheet" href="css/bootstrap.css" type="text/css">-->
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"/>
        <script src="js/jquery-1.11.1.min.js"></script>


        <!--<link rel="stylesheet" href="css/theme.css" type="text/css"/>-->
        <!--<link rel="stylesheet" href="css/dashboard.css" type="text/css"/>-->
        <link rel="stylesheet" href="css/navbar.css" type="text/css"/>
        <link rel="stylesheet" href="css/overview.css" type="text/css"/>
        <link rel="shortcut icon" href="images/unilab_icon.ico" type="image/x-icon">
        <link rel="icon" href="images/unilab_icon.ico" type="image/x-icon">

        
        <script src="js/jquery.knob.min.js"></script>
        <script>
            $(function ($) {

                $(".knob").knob({
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
                    <a class="navbar-brand" href="#">Project name</a>
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
                                Mark Santiago</a>
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
                        <li class="active"><a href="#">Overview</a></li>
                        <li><a href="ed_analyseperf.jsp">Analyze Today's Performance</a></li>
                        <li><a href="ed_nextdaypreps.jsp">Next Day Preps</a></li>
                    </ul>

                </div><!--/.nav-collapse -->
            </div>
        </div>

        <div class="container-fluid">
            <div class="sidebar_buttons">
                <a href="sd_overview.jsp"><img class="img-responsive" src="images/Start_of_Day_Logo.png"></a>
                <a href="ce_review_plans.jsp"><img class="img-responsive" src="images/Customer_Engagement_Logo.png"></a>
                <a href="#.jsp"><img class="img-responsive" src="images/End_of_Day_Logo.png"></a>
            </div>
        </div>

        <div class="container" style="margin-top: 120px">
            <div class="header">
                <h3><small>End of Day</small></h3>
            </div>
        </div>

        <div class="container" id="body">
            <div class="row">

                <div class="col-md-6">
                    <div class="panel panel-default" onclick="location.href = 'ed_analyseperf.jsp';" style="cursor: pointer;">
                        <div class="panel-body">
                            <div id="logo">
                                <a><img class="img-responsive" src="images/todays_perf.png"></a>
                            </div>
                            <div id="text-title">
                                <h4>Today's Performance</h4>
                            </div>
                            <div id="text-body">
                                <h5 style="margin-top: 20px">Analyze today's performance</h5>
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
                                <h4>Next Day Preps</h4>
                            </div>
                            <div id="text-body">
                                <h5 style="margin-top: 20px">You have 0 objectives tomorrow</h5>
                            </div>

                        </div>
                        <div class="panel-footer">View Details</div>
                    </div>
                </div>
            </div>
            
            <div class="row">
                <div class="col-md-6">
                    <div class="panel panel-default" onclick="location.href = 'ed_analyseperf.jsp';" style="cursor: pointer;">
                        <div class="panel-body">
                            <div class="demo" id="logo">
                                <input data-width="100%" class="knob" data-fgColor="#46b8da" style="color: #46b8da" data-thickness=".4" readonly value="90">
                            </div>
                            <div id="text-title">
                                <h4>Today's Sales Performance</h4>
                            </div>
                            <div id="text-body">
                                <h5 style="margin-top: 10px">9,000/10,000 Sales</h5>
                                <h5 style="margin-top: 2px">15,000/20,000 MTD Sales</h5>
                                <!--<h5>2000 / 10000 </h5>-->
                                <!--<h3><small>2000 / 10000 Sales achieved</small></h3>-->
                            </div>

                        </div>
                        <div class="panel-footer">View Details</div>
                    </div>    
                </div>
                <div class="col-md-6">
                    <div class="panel panel-default" onclick="location.href = 'ed_analyseperf.jsp';" style="cursor: pointer;">
                        <div class="panel-body">
                            <div class="demo" id="logo">
                                <!--<a><img class="img-responsive" src="images/objectives_logo.png"></a>-->
                                <!--<div class="demo">-->
                                <input data-width="100%" class="knob" data-fgColor="#66CC66" style="color: #46b8da" data-thickness=".4" readonly value="90">
                                <!--</div>-->
                            </div>
                            <div id="text-title">
                                <h4>Today's Call Performance</h4>
                            </div>
                            <div id="text-body">
                                <h5 style="margin-top: 10px">10/10 Calls</h5>
                                <h5 style="margin-top: 2px">162/180 MTD Calls</h5>
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
