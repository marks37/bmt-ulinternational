<%-- 
    Document   : ce_suggestion
    Created on : 11 7, 14, 10:51:06 AM
    Author     : Mark
--%>

<%@page import="Entities.Accounts"%>
<%@page import="Entities.Trending_Products"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Suggested Orders | Sales Force Management</title>
        <!--        <link rel="stylesheet" href="css/bootstrap-theme.css" type="text/css"/>
                <link rel="stylesheet" href="css/bootstrap-theme.min.css" type="text/css"/>
                <link rel="stylesheet" href="css/bootstrap.css" type="text/css">-->
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"/>
        <link rel="stylesheet" type="text/css" href="css/dataTables.tableTools.css">
        <link rel="stylesheet" type="text/css" href="css/jquery.dataTables.css">
        <script src="js/jquery-1.11.1.min.js"></script>
        <script src="js/jquery.js"></script>


        <!--<link rel="stylesheet" href="css/theme.css" type="text/css"/>-->
        <!--<link rel="stylesheet" href="css/dashboard.css" type="text/css"/>-->
        <link rel="stylesheet" href="css/navbar.css" type="text/css"/>
        <link rel="stylesheet" href="css/ce_suggestion.css" type="text/css"/>
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
                        <li><a href="ce_review_plans.jsp">Review Plans</a></li>
                        <li><a href="ce_forecast.jsp">Sales Objective</a></li>
                        <li><a href="ce_purchase_history.jsp">Purchase History</a></li>
                        <li><a href="ce_trending_products.jsp">Trending Products</a></li>
                        <li><a href="ce_product_list.jsp">Product List</a></li>
                        <li class="active"><a href="#">Suggested Orders</a></li>
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
            <%
                Accounts account = (Accounts) session.getAttribute("Account");
            %>
            <h2><%out.print(account.getEnglishName());%></h2>
        </div>

        <div class="container" id="body">
            <div class="row">

                <div class="col-md-10">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table display" cellspacing="0" id="suggested_orders">
                                    <thead>
                                        <tr>
                                            <th rowspan="2">#</th>
                                            <th rowspan="2">Item Description</th>
                                            <th colspan="4">Historical Sales (Units)</th>
                                            <th></th>
                                            <th colspan="4">Suggested Order (Units)</th>
                                            <th></th>
                                            <th colspan="2">Order Plan</th>
                                        </tr>
                                        <tr>
                                            <th>Past 3mos</th>
                                            <th>Past 6mos</th>
                                            <th>Past 9mos</th>
                                            <th>Past 12mos</th>
                                            <th></th>
                                            <th>Ave 3mos</th>
                                            <th>Ave 6mos</th>
                                            <th>Ave 9mos</th>
                                            <th>Ave 12mos</th>
                                            <th></th>
                                            <th>Units</th>
                                            <th>Amount (Units*Price)</th>
                                        </tr>

                                    </thead>

                                    <tbody>

                                        <%
                                            int index = 0;
                                            ArrayList<Trending_Products> SuggestedOrders = (ArrayList<Trending_Products>) session.getAttribute("SuggestedOrders");
                                            for (int a = 0; a < SuggestedOrders.size(); a++) {
                                                index = index + 1;

                                        %>

                                        <tr class="rows">
                                            <td><%=index%></td>
                                            <td><%=SuggestedOrders.get(a).getDescription()%></td>
                                            <td><%=SuggestedOrders.get(a).getP3TotalUnits()%></td>
                                            <td><%=SuggestedOrders.get(a).getP6TotalUnits()%></td>
                                            <td><%=SuggestedOrders.get(a).getP9TotalUnits()%></td>
                                            <td><%=SuggestedOrders.get(a).getP12TotalUnits()%></td>
                                            <td></td>
                                            <td><%=SuggestedOrders.get(a).getP3AveUnits()%></td>
                                            <td><%=SuggestedOrders.get(a).getP6AveUnits()%></td>
                                            <td><%=SuggestedOrders.get(a).getP9AveUnits()%></td>
                                            <td><%=SuggestedOrders.get(a).getP12AveUnits()%></td>
                                            <td><input class="price" type="hidden" value='<%=SuggestedOrders.get(a).getPriceWithVat()%>'/></td>
                                            <td><input class="units" type="text" placeholder="Number of units"/></td>
                                            <td><input class="amount" type="text" placeholder="Amount" disabled/></td>
                                        </tr>

                                        <%
                                            }
                                        %>
                                    </tbody>


                                    <tfoot>
                                        <tr>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td>Total Order</td>
                                            <td><input class="totalorder" id='totalorder' type="text" placeholder="Total Orders" disabled/></td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td>% to target this month</td>
                                            <td><input class="totalmonth" id='totalmonth' type="text" placeholder="Total % to target this month" disabled/></td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td>% to target this call</td>
                                            <td><input class="totalcall" id='totalcall' type="text" placeholder="Total % to target this call" disabled/></td>
                                        </tr>

                                    </tfoot>
                                </table>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="col-md-2">
                    <div class="panel panel-default">

                        <div class="panel-heading">
                            <h4>Sales Performance</h4>
                        </div>

                        <div class="panel-body" id="sales_perf">

                            <div id="text-title">
                                <!--<h3><small>Sales Performance</small></h3>-->

                            </div>
                            <!--<hr>-->
                            <div class="demo" id="logo">
                                <%
                                    long SalesPerformance = (long) session.getAttribute("SalesPerformance_Account");
                                %>
                                <input data-width="100%" class="knob" data-fgColor="#46b8da" style="color: #46b8da" data-thickness=".4" readonly value="<%=SalesPerformance%>">
                            </div>
                            <div id="text-body">
                            </div>

                        </div>

                        <div class="panel-footer" id="sales_perf_footer">
                            <%
                                String date = (String) session.getAttribute("CurrentDate");
                                long MTDSales = (long) session.getAttribute("MTDSales_Account");
                                long MonthTarget = (long) session.getAttribute("MonthTarget_Account");
                                long difference = MonthTarget - MTDSales;
                            %>
                            <h4 style="margin-bottom: 10px"><small>As of <%=date%></small></h4>
                            <h5>Actual Sales:</h5>
                            <h5 style="margin-top: 2px"><%=MTDSales%> (-<%=difference%>)</h5>
                            <h5 style="margin-top: 10px">Target Sales:</h5>
                            <h5 style="margin-top: 2px"><%=MonthTarget%> (+<%=difference%>)</h5>
                        </div>

                    </div>

                    <div class="panel panel-default">

                        <div class="panel-heading">
                            <h4>Call Performance</h4>
                        </div>

                        <div class="panel-body" id="sales_perf">

                            <div id="text-title">
                                <!--<h3><small>Sales Performance</small></h3>-->

                            </div>
                            <!--<hr>-->
                            <div class="demo" id="logo">
                                <%
                                    int CallPerformance = (int) session.getAttribute("CallPerformance_Account");
                                %>
                                <input data-width="100%" class="knob" data-fgColor="#5B70C0" style="color: #46b8da" data-thickness=".4" readonly value="<%=CallPerformance%>">
                            </div>
                            <!--<hr>-->
                            <div id="text-body">

                            </div>

                        </div>

                        <div class="panel-footer" id="sales_perf_footer">
                            <%
                                int CoveredCalls = (int) session.getAttribute("CoveredCalls_Account");
                                int TotalCalls = (int) session.getAttribute("TotalCalls_Account");
                                int difference2 = TotalCalls - CoveredCalls;
                            %>
                            <h4 style="margin-bottom: 10px"><small>As of <%=date%></small></h4>
                            <h5>Completed Calls:</h5>
                            <h5 style="margin-top: 2px"><%=CoveredCalls%> (-<%=difference2%>)</h5>
                            <h5 style="margin-top: 10px">Target Call:</h5>
                            <h5 style="margin-top: 2px"><%=TotalCalls%> (+<%=difference2%>)</h5>
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
                $('#suggested_orders').DataTable();

                $(".units").each(function () {

                    $(this).keyup(function () {
                        calculateSum();
                    });
                });

            });

            function calculate(units, price) {

                return (units * price);
            }

            $('input').on('change', function () {
                var scope = $(this).closest('.rows'),
                        units = $('.units', scope).val(),
                        price = $('.price', scope).val(),
                        amount = $('.amount', scope);
                if ($.isNumeric(units) !== '') {
                    amount.val(calculate(units, price));

                } else {
                    amount.val('');
                }

                var sum = 0;
                //iterate through each textboxes and add the values
                $(".amount").each(function () {

                    //add only if the value is number
                    if (!isNaN(this.value) && this.value.length !== 0) {
                        sum += parseFloat(this.value);
                    }

                });
                //.toFixed() method will roundoff the final sum to 2 decimal places
                $(".totalorder").val(sum.toFixed(2));
                
                var result = parseFloat(parseInt(sum, 10) * 100)/ parseInt(<%=MonthTarget%>, 10);
                $(".totalmonth").val(Math.round(result)+'%');
                <%long CallTarget = (long) session.getAttribute("CallTarget");%>
                var result2 = parseFloat(parseInt(sum, 10) * 100)/ parseInt(<%=CallTarget%>, 10);
                $(".totalcall").val(Math.round(result2)+'%');
                



//                var $form = $('#suggested_orders'),
//                        $summands = $form.find('.amount'),
//                        $sumDisplay = $('.totalorder');
//
//                $form.delegate('.amount', 'change', function () {
//                    var sum = 0;
//                    $summands.each(function () {
//                        var value = Number($(this).val());
//                        if (!isNaN(value))
//                            sum += value;
//                    });
//
//                    $sumDisplay.val(sum);
//                });


            });


            function calculateSum() {

                
            }


        </script>

    </body>
</html>
