<%-- 
    Document   : homepage
    Created on : 07 13, 14, 3:59:32 PM
    Author     : marksantiago
--%>

<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="Entities.Accounts"%>
<%@page import="Entities.CallForecast"%>
<%@page import="Entities.Sales_Forecast_Items"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entities.Sales_Forecast"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forecast | Sales Force Management</title>
        <!--        <link rel="stylesheet" href="css/bootstrap-theme.css" type="text/css"/>
                <link rel="stylesheet" href="css/bootstrap-theme.min.css" type="text/css"/>
                <link rel="stylesheet" href="css/bootstrap.css" type="text/css">-->
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"/>
        <link rel="stylesheet" type="text/css" href="css/dataTables.tableTools.css">
        <link rel="stylesheet" type="text/css" href="css/jquery.dataTables.css">
        <script src="js/jquery-1.11.1.min.js"></script>

        <link rel="stylesheet" href="css/navbar.css" type="text/css"/>
        <link rel="stylesheet" href="css/ce_forecast.css" type="text/css"/>
        <link rel="shortcut icon" href="images/unilab_icon.ico" type="image/x-icon">
        <link rel="icon" href="images/unilab_icon.ico" type="image/x-icon">

        <script src="js/jquery.knob.min.js"></script>
        <script language="javascript" type="text/javascript" src="js/jquery.flot.js"></script>
        <!--<script language="javascript" type="text/javascript" src="js/jquery.flot.categories.js"></script>-->
        <script language="javascript" type="text/javascript" src="js/jquery.flot.orderBars.js"></script>
        <script language="javascript" type="text/javascript" src="js/jquery.flot.axislabels.js"></script>

        <!--Knob -->
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

        <script type="text/javascript">
            $(document).ready(function () {

            <%
                Sales_Forecast Jan = (Sales_Forecast) session.getAttribute("Jan");
                Sales_Forecast Feb = (Sales_Forecast) session.getAttribute("Feb");
                Sales_Forecast Mar = (Sales_Forecast) session.getAttribute("Mar");
                Sales_Forecast Apr = (Sales_Forecast) session.getAttribute("Apr");
                Sales_Forecast May = (Sales_Forecast) session.getAttribute("May");
                Sales_Forecast Jun = (Sales_Forecast) session.getAttribute("Jun");
                Sales_Forecast Jul = (Sales_Forecast) session.getAttribute("Jul");
                Sales_Forecast Aug = (Sales_Forecast) session.getAttribute("Aug");
                Sales_Forecast Sep = (Sales_Forecast) session.getAttribute("Sep");
                Sales_Forecast Oct = (Sales_Forecast) session.getAttribute("Oct");
                Sales_Forecast Nov = (Sales_Forecast) session.getAttribute("Nov");
                Sales_Forecast Dec = (Sales_Forecast) session.getAttribute("Dec");
            %>
                var d1_1 = [
                    [1.0, <%out.print(Jan.getSalesForecast());%>],
                    [2.0, <%out.print(Feb.getSalesForecast());%>],
                    [3.0, <%out.print(Mar.getSalesForecast());%>],
                    [4.0, <%out.print(Apr.getSalesForecast());%>],
                    [5.0, <%out.print(May.getSalesForecast());%>],
                    [6.0, <%out.print(Jun.getSalesForecast());%>],
                    [7.0, <%out.print(Jul.getSalesForecast());%>],
                    [8.0, <%out.print(Aug.getSalesForecast());%>],
                    [9.0, <%out.print(Sep.getSalesForecast());%>],
                    [10.0, <%out.print(Oct.getSalesForecast());%>],
                    [11.0, <%out.print(Nov.getSalesForecast());%>],
                    [12.0, <%out.print(Dec.getSalesForecast());%>]
                ];

                var d1_2 = [
                    [1.0, <%out.print(Jan.getActualSales());%>],
                    [2.0, <%out.print(Feb.getActualSales());%>],
                    [3.0, <%out.print(Mar.getActualSales());%>],
                    [4.0, <%out.print(Apr.getActualSales());%>],
                    [5.0, <%out.print(May.getActualSales());%>],
                    [6.0, <%out.print(Jun.getActualSales());%>],
                    [7.0, <%out.print(Jul.getActualSales());%>],
                    [8.0, <%out.print(Aug.getActualSales());%>],
                    [9.0, <%out.print(Sep.getActualSales());%>],
                    [10.0, <%out.print(Oct.getActualSales());%>],
                    [11.0, <%out.print(Nov.getActualSales());%>],
                    [12.0, <%out.print(Dec.getActualSales());%>]
                ];

                var data1 = [
                    {
                        label: "Target Sales",
                        data: d1_1,
                        bars: {
                            show: true,
                            barWidth: 0.3,
                            fill: true,
                            lineWidth: 1,
                            order: 1,
//                            fillColor: "#46b8da"
                        },
//                        color: "#46b8da"
                    },
                    {
                        label: "Actual Sales",
                        data: d1_2,
                        bars: {
                            show: true,
                            barWidth: 0.3,
                            fill: true,
                            lineWidth: 1,
                            order: 2,
//                            fillColor: "#89A54E"
                        },
//                        color: "#89A54E"
                    },
                ];

                var ticks = [
                    [1, "Jan"], [2, "Feb"], [3, "Mar"], [4, "Apr"], [5, "May"], [6, "Jun"], [7, "Jul"], [8, "Aug"], [9, "Sep"], [10, "Oct"], [11, "Nov"], [12, "Dec"]
                ];


                $.plot($("#placeholder"), data1, {
                    xaxis: {
                        min: 0.0,
                        max: 13.0,
                        //mode: null,
                        ticks: ticks,
                        tickLength: 0, // hide gridlines
                        axisLabelUseCanvas: true,
                        axisLabel: "Months",
                        axisLabelFontSizePixels: 12,
                        axisLabelFontFamily: 'Verdana, Arial',
                        axisLabelPadding: 5
                    },
                    yaxis: {
                        axisLabel: "Sales",
                        axisLabelUseCanvas: true,
                        axisLabelFontSizePixels: 12,
                        axisLabelFontFamily: 'Verdana, Arial',
                        axisLabelPadding: 5,
                        tickFormatter: function numberWithCommas(x) {
                            return x.toString().replace(/\B(?=(?:\d{3})+(?!\d))/g, ",");
                        }

                    },
                    grid: {
                        hoverable: true,
                        clickable: true,
                        borderWidth: 1
                    },
                    legend: {
                        labelBoxBorderColor: "none",
                        position: "nw"
                    },
                    series: {
                        shadowSize: 1
                    }
                });

                function showTooltip(x, y, contents, z) {
                    $('<div id="flot-tooltip">' + contents + '</div>').css({
                        top: y - 20,
                        left: x - 90,
                        'border-color': z,
                    }).appendTo("body").show();
                }

                $("#placeholder").bind("plothover", function (event, pos, item) {
                    var previousPoint;
                    if (item) {
                        if (previousPoint != item.datapoint) {
                            previousPoint = item.datapoint;
                            $("#flot-tooltip").remove();

                            var originalPoint;

                            if (item.datapoint[0] == item.series.data[0][3]) {
                                originalPoint = item.series.data[0][0];
                            } else if (item.datapoint[0] == item.series.data[1][3]) {
                                originalPoint = item.series.data[1][0];
                            } else if (item.datapoint[0] == item.series.data[2][3]) {
                                originalPoint = item.series.data[2][0];
                            } else if (item.datapoint[0] == item.series.data[3][3]) {
                                originalPoint = item.series.data[3][0];
                            } else if (item.datapoint[0] == item.series.data[4][3]) {
                                originalPoint = item.series.data[4][0];
                            }

                            var x = originalPoint;
                            y = item.datapoint[1];
                            z = item.series.color;

                            showTooltip(item.pageX, item.pageY,
                                    "<b>" + item.series.label + "</b><br /> " + " = " + y,
                                    z);
                        }
                    } else {
                        $("#flot-tooltip").remove();
                        previousPoint = null;
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
                                <%                                    String fullname = (String) session.getAttribute("SalesRepName");
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
                        <li class="active"><a href="#">Sales Objective</a></li>
                        <li><a href="ce_purchase_history.jsp">Purchase History</a></li>
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
            <div>
                <%
                    Accounts account = (Accounts) session.getAttribute("Account");
                %>
                <h2><%out.print(account.getEnglishName());%></h2>
            </div>
        </div>

        <div class="container" id="body">
            <div class="row">

                <div class="col-md-10">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="demo-container">
                                <div id="placeholder" class="demo-placeholder"></div>
                            </div>
                            <div class="table-responsive">
                                <table class="table display" cellspacing="0" id="sales_forecast">
                                    <thead>
                                        <tr>
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
                                            long SalesForecastTotal = (long) session.getAttribute("SalesForecastTotal");
                                            long ActualSalesTotal = (long) session.getAttribute("ActualSalesTotal");
                                            System.out.println(NumberFormat.getNumberInstance(Locale.US).format(Math.round(Jan.getSalesForecast())));
                                        %>
                                        <tr>
                                            <th>My Target</th>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(Jan.getSalesForecast())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(Feb.getSalesForecast())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(Mar.getSalesForecast())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(Apr.getSalesForecast())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(May.getSalesForecast())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(Jun.getSalesForecast())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(Jul.getSalesForecast())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(Aug.getSalesForecast())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(Sep.getSalesForecast())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(Oct.getSalesForecast())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(Nov.getSalesForecast())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(Dec.getSalesForecast())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(SalesForecastTotal));%></td>
                                        </tr>
                                        <tr>
                                            <th>Actual Sales</th>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(Jan.getActualSales())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(Feb.getActualSales())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(Mar.getActualSales())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(Apr.getActualSales())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(May.getActualSales())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(Jun.getActualSales())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(Jul.getActualSales())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(Aug.getActualSales())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(Sep.getActualSales())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(Oct.getActualSales())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(Nov.getActualSales())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(Dec.getActualSales())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(ActualSalesTotal));%></td>
                                        </tr>
                                        <tr>
                                            <th>% to target</th>
                                            <td><%out.print(Math.round((Jan.getActualSales() * 100.0f) / Jan.getSalesForecast()));%>%</td>
                                            <td><%out.print(Math.round((Feb.getActualSales() * 100.0f) / Jan.getSalesForecast()));%>%</td>
                                            <td><%out.print(Math.round((Mar.getActualSales() * 100.0f) / Jan.getSalesForecast()));%>%</td>
                                            <td><%out.print(Math.round((Apr.getActualSales() * 100.0f) / Jan.getSalesForecast()));%>%</td>
                                            <td><%out.print(Math.round((May.getActualSales() * 100.0f) / Jan.getSalesForecast()));%>%</td>
                                            <td><%out.print(Math.round((Jun.getActualSales() * 100.0f) / Jan.getSalesForecast()));%>%</td>
                                            <td><%out.print(Math.round((Jul.getActualSales() * 100.0f) / Jan.getSalesForecast()));%>%</td>
                                            <td><%out.print(Math.round((Aug.getActualSales() * 100.0f) / Jan.getSalesForecast()));%>%</td>
                                            <td><%out.print(Math.round((Sep.getActualSales() * 100.0f) / Jan.getSalesForecast()));%>%</td>
                                            <td><%out.print(Math.round((Oct.getActualSales() * 100.0f) / Jan.getSalesForecast()));%>%</td>
                                            <td><%out.print(Math.round((Nov.getActualSales() * 100.0f) / Jan.getSalesForecast()));%>%</td>
                                            <td><%out.print(Math.round((Dec.getActualSales() * 100.0f) / Jan.getSalesForecast()));%>%</td>
                                            <td><%out.print(Math.round((ActualSalesTotal * 100.0f) / SalesForecastTotal));%>%</td>
                                        </tr>
                                    </tbody>
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




        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/jquery.dataTables.js"></script>
        <script type="text/javascript" src="js/dataTables.tableTools.js"></script>
        <script type="text/javascript" src="js/modal.js"></script>


        <script>
            $(document).ready(function () {
                $('#sales_forecast').DataTable({
                    "paging": false,
                    "ordering": false,
                    "info": false,
                    "filter": false
                }).columns.adjust();
//                $($.fn.dataTable.tables(true)).DataTable().columns.adjust();
            });
        </script>

    </body>
</html>
