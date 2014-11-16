<%-- 
    Document   : ce_purchase_history
    Created on : 11 6, 14, 1:07:49 AM
    Author     : Mark
--%>

<%@page import="Entities.Accounts"%>
<%@page import="Entities.Purchases"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Purchase History | Sales Force Management</title>
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"/>
        <link rel="stylesheet" type="text/css" href="css/dataTables.tableTools.css">
        <link rel="stylesheet" type="text/css" href="css/jquery.dataTables.css">
        <link rel="stylesheet" href="css/navbar.css" type="text/css"/>
        <link rel="stylesheet" href="css/ce_purchase_history.css" type="text/css"/>

        <script src="js/jquery-1.11.1.min.js"></script>

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
                        <li class="active"><a href="sd_overview.jsp">Home</a></li>
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



        <!-- Fixed navbar -->
        <div class="navbar navbar-default navbar-fixed-top" id="homepage_navbar" role="navigation">
            <div class="container">

                <div class="navbar-collapse collapse" id="inner_wrapper">
                    <ul class="nav navbar-nav">
                        <li><a href="ce_review_plans.jsp">Review Plans</a></li>
                        <li><a href="ce_forecast.jsp">Sales Objective</a></li>
                        <li class="active"><a href="#">Purchase History</a></li>
                        <li><a href="ce_trending_products.jsp">Trending Products</a></li>
                        <li><a href="ce_product_list.jsp">Product List</a></li>
                        <li><a href="ce_suggestion.jsp">Suggested Orders</a></li>
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
                    <ul class="nav nav-tabs" role="tablist">
                        <li class="active"><a role="tab" data-toggle="tab" onclick="click()" id="example-1" href="#amount">Amount</a></li>
                        <li><a role="tab" data-toggle="tab" onclick="click()" id="example-2" href="#units">Units</a></li>
                    </ul>

                    <%
                        ArrayList<Purchases> Purchases = (ArrayList<Purchases>) session.getAttribute("Purchases");
                    %>
                    <div class="panel panel-default tab-content" id="ph_panel">

                        <div class="panel-body tab-pane active" id="amount">
                            <div class="table-responsive">
                                <table class="table display" cellspacing="0" id="amount_table" style="font-size: 15px">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Item Code</th>
                                            <th>Item Description</th>
                                            <th></th>
                                            <th>Jan</th>
                                            <th>Feb</th>
                                            <th>Mar</th>
                                            <th>Apr</th>
                                            <th>May</th>
                                            <th>Jun</th>
                                            <th>Jul</th>
                                            <th>Aug</th>
                                            <th>Sep</th>
                                            <th>Oct</th>
                                            <th>Nov</th>
                                            <th>Dec</th>
                                            <th>Total</th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                        <%
                                            int index = 0;
                                            for (int a = 0; a < Purchases.size(); a++) {
                                                index = index + 1;
                                        %>
                                        <tr>
                                            <td rowspan="2"><%out.print(index);%></td>
                                            <td rowspan="2"><%out.print(Purchases.get(a).getItemCode());%></td>
                                            <td rowspan="2"><%out.print(Purchases.get(a).getDescription());%></td>
                                            <td>This Year</td>
                                            <td><%out.print(Purchases.get(a).getJanThisYearAmount());%></td>
                                            <td><%out.print(Purchases.get(a).getFebThisYearAmount());%></td>
                                            <td><%out.print(Purchases.get(a).getMarThisYearAmount());%></td>
                                            <td><%out.print(Purchases.get(a).getAprThisYearAmount());%></td>
                                            <td><%out.print(Purchases.get(a).getMayThisYearAmount());%></td>
                                            <td><%out.print(Purchases.get(a).getJunThisYearAmount());%></td>
                                            <td><%out.print(Purchases.get(a).getJulThisYearAmount());%></td>
                                            <td><%out.print(Purchases.get(a).getAugThisYearAmount());%></td>
                                            <td><%out.print(Purchases.get(a).getSepThisYearAmount());%></td>
                                            <td><%out.print(Purchases.get(a).getOctThisYearAmount());%></td>
                                            <td><%out.print(Purchases.get(a).getNovThisYearAmount());%></td>
                                            <td><%out.print(Purchases.get(a).getDecThisYearAmount());%></td>
                                            <td><%out.print(Purchases.get(a).getTotalThisYearAmount());%></td>
                                        </tr>
                                        <tr>
                                            <td>Last Year</td>
                                            <td><%out.print(Purchases.get(a).getJanPastYearAmount());%></td>
                                            <td><%out.print(Purchases.get(a).getFebPastYearAmount());%></td>
                                            <td><%out.print(Purchases.get(a).getMarPastYearAmount());%></td>
                                            <td><%out.print(Purchases.get(a).getAprPastYearAmount());%></td>
                                            <td><%out.print(Purchases.get(a).getMayPastYearAmount());%></td>
                                            <td><%out.print(Purchases.get(a).getJunPastYearAmount());%></td>
                                            <td><%out.print(Purchases.get(a).getJulPastYearAmount());%></td>
                                            <td><%out.print(Purchases.get(a).getAugPastYearAmount());%></td>
                                            <td><%out.print(Purchases.get(a).getSepPastYearAmount());%></td>
                                            <td><%out.print(Purchases.get(a).getOctPastYearAmount());%></td>
                                            <td><%out.print(Purchases.get(a).getNovPastYearAmount());%></td>
                                            <td><%out.print(Purchases.get(a).getDecPastYearAmount());%></td>
                                            <td><%out.print(Purchases.get(a).getTotalPastYearAmount());%></td>
                                        </tr>
                                        <%
                                            }
                                        %>

                                    </tbody>
                                    <tfoot>
                                        <tr>
                                            <th>#</th>
                                            <th>Item Code</th>
                                            <th>Item Description</th>
                                            <th></th>
                                            <th>Jan</th>
                                            <th>Feb</th>
                                            <th>Mar</th>
                                            <th>Apr</th>
                                            <th>May</th>
                                            <th>Jun</th>
                                            <th>Jul</th>
                                            <th>Aug</th>
                                            <th>Sep</th>
                                            <th>Oct</th>
                                            <th>Nov</th>
                                            <th>Dec</th>
                                            <th>Total</th>
                                        </tr>
                                    </tfoot>
                                </table>
                            </div>
                        </div>

                        <div class="panel-body tab-pane fade" id="units">
                            <div class="table-responsive">
                                <table class="table display" cellspacing="0" id="units_table" style="font-size: 15px">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Item Code</th>
                                            <th>Item Description</th>
                                            <th></th>
                                            <th>Jan</th>
                                            <th>Feb</th>
                                            <th>Mar</th>
                                            <th>Apr</th>
                                            <th>May</th>
                                            <th>Jun</th>
                                            <th>Jul</th>
                                            <th>Aug</th>
                                            <th>Sep</th>
                                            <th>Oct</th>
                                            <th>Nov</th>
                                            <th>Dec</th>
                                            <th>Total</th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                        <%
                                            index = 0;
                                            for (int a = 0; a < Purchases.size(); a++) {
                                                index = index + 1;
                                        %>
                                        <tr>
                                            <td rowspan="2"><%out.print(index);%></td>
                                            <td rowspan="2"><%out.print(Purchases.get(a).getItemCode());%></td>
                                            <td rowspan="2"><%out.print(Purchases.get(a).getDescription());%></td>
                                            <td>This Year</td>
                                            <td><%out.print(Purchases.get(a).getJanThisYearUnits());%></td>
                                            <td><%out.print(Purchases.get(a).getFebThisYearUnits());%></td>
                                            <td><%out.print(Purchases.get(a).getMarThisYearUnits());%></td>
                                            <td><%out.print(Purchases.get(a).getAprThisYearUnits());%></td>
                                            <td><%out.print(Purchases.get(a).getMayThisYearUnits());%></td>
                                            <td><%out.print(Purchases.get(a).getJunThisYearUnits());%></td>
                                            <td><%out.print(Purchases.get(a).getJulThisYearUnits());%></td>
                                            <td><%out.print(Purchases.get(a).getAugThisYearUnits());%></td>
                                            <td><%out.print(Purchases.get(a).getSepThisYearUnits());%></td>
                                            <td><%out.print(Purchases.get(a).getOctThisYearUnits());%></td>
                                            <td><%out.print(Purchases.get(a).getNovThisYearUnits());%></td>
                                            <td><%out.print(Purchases.get(a).getDecThisYearUnits());%></td>
                                            <td><%out.print(Purchases.get(a).getTotalThisYearUnits());%></td>
                                        </tr>
                                        <tr>
                                            <td>Past Year</td>
                                            <td><%out.print(Purchases.get(a).getJanPastYearUnits());%></td>
                                            <td><%out.print(Purchases.get(a).getFebPastYearUnits());%></td>
                                            <td><%out.print(Purchases.get(a).getMarPastYearUnits());%></td>
                                            <td><%out.print(Purchases.get(a).getAprPastYearUnits());%></td>
                                            <td><%out.print(Purchases.get(a).getMayPastYearUnits());%></td>
                                            <td><%out.print(Purchases.get(a).getJunPastYearUnits());%></td>
                                            <td><%out.print(Purchases.get(a).getJulPastYearUnits());%></td>
                                            <td><%out.print(Purchases.get(a).getAugPastYearUnits());%></td>
                                            <td><%out.print(Purchases.get(a).getSepPastYearUnits());%></td>
                                            <td><%out.print(Purchases.get(a).getOctPastYearUnits());%></td>
                                            <td><%out.print(Purchases.get(a).getNovPastYearUnits());%></td>
                                            <td><%out.print(Purchases.get(a).getDecPastYearUnits());%></td>
                                            <td><%out.print(Purchases.get(a).getTotalPastYearUnits());%></td>
                                        </tr>
                                        <%
                                            }
                                        %>

                                    </tbody>
                                    <tfoot>
                                        <tr>
                                            <th>#</th>
                                            <th>Item Code</th>
                                            <th>Item Description</th>
                                            <th></th>
                                            <th>Jan</th>
                                            <th>Feb</th>
                                            <th>Mar</th>
                                            <th>Apr</th>
                                            <th>May</th>
                                            <th>Jun</th>
                                            <th>Jul</th>
                                            <th>Aug</th>
                                            <th>Sep</th>
                                            <th>Oct</th>
                                            <th>Nov</th>
                                            <th>Dec</th>
                                            <th>Total</th>
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
                                <%                                    long SalesPerformance = (long) session.getAttribute("SalesPerformance_Account");
                                %>
                                <input data-width="100%" class="knob" data-fgColor="#46b8da" style="color: #46b8da" data-thickness=".4" readonly value="<%=SalesPerformance%>">
                            </div>
                            <div id="text-body">
                            </div>

                        </div>

                        <div class="panel-footer" id="sales_perf_footer">
                            <%
                                String date = (String) session.getAttribute("CurrentDate");
                                long MonthSales = (long) session.getAttribute("MTDSales_Account");
                                long MonthTarget = (long) session.getAttribute("MonthTarget_Account");
                                long difference = MonthTarget - MonthSales;
                            %>
                            <h4 style="margin-bottom: 10px"><small>As of <%=date%></small></h4>
                            <h5>Actual Sales:</h5>
                            <h5 style="margin-top: 2px"><%=MonthSales%> (-<%=difference%>)</h5>
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




        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/jquery.dataTables.js"></script>
        <script type="text/javascript" src="js/dataTables.tableTools.js"></script>
        <script type="text/javascript" src="js/modal.js"></script>


        <script>
                            $(document).ready(function () {
                                $("#tabs").tabs({
                                    "activate": function (event, ui) {
                                        $($.fn.dataTable.tables(true)).DataTable().columns.adjust();
                                    }
                                });

                                $('#amount_table').DataTable({
                                    "scrollX": true,
                                    stateSave: true
                                });
                                $('#units_table').DataTable({
                                    "scrollX": true,
                                    stateSave: true
                                });
                            });

                            function click() {
                                var amount = $('#amount_table').DataTable();
                                amount.columns.adjust();

                                var units = $('#units_table').DataTable();
                                units.columns.adjust();


                            }
        </script>



    </body>
</html>
