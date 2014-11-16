<%-- 
    Document   : ed_nextdaypreps
    Created on : 11 8, 14, 8:28:52 PM
    Author     : Mark
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Next Day Preps | Sales Force Management</title>
        <!--        <link rel="stylesheet" href="css/bootstrap-theme.css" type="text/css"/>
                <link rel="stylesheet" href="css/bootstrap-theme.min.css" type="text/css"/>
                <link rel="stylesheet" href="css/bootstrap.css" type="text/css">-->
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"/>
        <link rel="stylesheet" type="text/css" href="css/dataTables.tableTools.css">
        <link rel="stylesheet" type="text/css" href="css/jquery.dataTables.css">
        

        <!--<link rel="stylesheet" href="css/theme.css" type="text/css"/>-->
        <!--<link rel="stylesheet" href="css/dashboard.css" type="text/css"/>-->
        <link rel="stylesheet" href="css/navbar.css" type="text/css"/>
        <link rel="stylesheet" href="css/objectives.css" type="text/css"/>
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
                        <li><a href="ed_overview.jsp">Overview</a></li>
                        <li><a href="ed_analyseperf.jsp">Analyze Today's Performance</a></li>
                        <li class="active"><a href="+">Next Day Preps</a></li>
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

        <div class="header container" style="margin-top: 120px;">
            <div>
                <h3><small>End of Day</small></h3>
            </div>
        </div>

        <div class="container" id="body">
            <div class="row">

                <div class="col-md-12">
                    <div class="panel panel-default">
<!--                        <div class="panel-heading">
                            Today's Objectives
                        </div>-->

                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table display" cellspacing="0" id="objectives">
                                    <thead>
                                        <tr>
                                            <th>#</th>
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
                                        <tr>
                                            <td>1</td>
                                            <td>1256</td>
                                            <td>Hongya Minburi</td>
                                            <td>64-66 Soi Ngamdupli 21, Sathorn, Rama IV, Bangkok</td>
                                            <td>086-3669228</td>
                                            <td>Booking</td>
                                            <td>1,000</td>
                                            <td>10</td>
                                        </tr>
                                        <tr>
                                            <td>2</td>
                                            <td>1256</td>
                                            <td>Hongya Minburi</td>
                                            <td>64-66 Soi Ngamdupli 21, Sathorn, Rama IV, Bangkok</td>
                                            <td>086-3669228</td>
                                            <td>Booking</td>
                                            <td>1,000</td>
                                            <td>10</td>
                                        </tr>
                                        <tr>
                                            <td>3</td>
                                            <td>1256</td>
                                            <td>Hongya Minburi</td>
                                            <td>64-66 Soi Ngamdupli 21, Sathorn, Rama IV, Bangkok</td>
                                            <td>086-3669228</td>
                                            <td>Booking</td>
                                            <td>1,000</td>
                                            <td>10</td>
                                        </tr>
                                        <tr>
                                            <td>4</td>
                                            <td>1256</td>
                                            <td>Hongya Minburi</td>
                                            <td>64-66 Soi Ngamdupli 21, Sathorn, Rama IV, Bangkok</td>
                                            <td>086-3669228</td>
                                            <td>Booking</td>
                                            <td>1,000</td>
                                            <td>10</td>
                                        </tr>
                                        <tr>
                                            <td>5</td>
                                            <td>1256</td>
                                            <td>Hongya Minburi</td>
                                            <td>64-66 Soi Ngamdupli 21, Sathorn, Rama IV, Bangkok</td>
                                            <td>086-3669228</td>
                                            <td>Booking</td>
                                            <td>1,000</td>
                                            <td>10</td>
                                        </tr>
                                        <tr>
                                            <td>6</td>
                                            <td>1256</td>
                                            <td>Hongya Minburi</td>
                                            <td>64-66 Soi Ngamdupli 21, Sathorn, Rama IV, Bangkok</td>
                                            <td>086-3669228</td>
                                            <td>Booking</td>
                                            <td>1,000</td>
                                            <td>10</td>
                                        </tr>
                                        <tr>
                                            <td>7</td>
                                            <td>1256</td>
                                            <td>Hongya Minburi</td>
                                            <td>64-66 Soi Ngamdupli 21, Sathorn, Rama IV, Bangkok</td>
                                            <td>086-3669228</td>
                                            <td>Booking</td>
                                            <td>1,000</td>
                                            <td>10</td>
                                        </tr>
                                        <tr>
                                            <td>8</td>
                                            <td>1256</td>
                                            <td>Hongya Minburi</td>
                                            <td>64-66 Soi Ngamdupli 21, Sathorn, Rama IV, Bangkok</td>
                                            <td>086-3669228</td>
                                            <td>Booking</td>
                                            <td>1,000</td>
                                            <td>10</td>
                                        </tr>
                                        <tr>
                                            <td>9</td>
                                            <td>1256</td>
                                            <td>Hongya Minburi</td>
                                            <td>64-66 Soi Ngamdupli 21, Sathorn, Rama IV, Bangkok</td>
                                            <td>086-3669228</td>
                                            <td>Booking</td>
                                            <td>1,000</td>
                                            <td>10</td>
                                        </tr>
                                        <tr>
                                            <td>10</td>
                                            <td>1256</td>
                                            <td>Hongya Minburi</td>
                                            <td>64-66 Soi Ngamdupli 21, Sathorn, Rama IV, Bangkok</td>
                                            <td>086-3669228</td>
                                            <td>Booking</td>
                                            <td>1,000</td>
                                            <td>10</td>
                                        </tr>
                                    </tbody>
                                </table>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>




        <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" charset="utf8" src="js/jquery.dataTables.js"></script>
        <script type="text/javascript" charset="utf8" src="js/dataTables.tableTools.js"></script>
        <script type="text/javascript" charset="utf8" src="js/modal.js"></script>
        
        <script>
            $(document).ready(function () {
                $('#objectives').DataTable();
            });
        </script>


    </body>
</html>
