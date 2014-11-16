<%-- 
    Document   : sa_total_sales
    Created on : 11 15, 14, 11:20:46 AM
    Author     : Mark
--%>

<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="Entities.Sales"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sales Total | Sales Force Management</title>
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
        
        
        <script type="text/javascript">
            $(document).ready(function () {

            <%
                Sales TotalSales = (Sales) session.getAttribute("TotalSales");
            %>
                var d1_1 = [
                    [1.0, <%out.print(TotalSales.getJanTotalTarget());%>],
                    [2.0, <%out.print(TotalSales.getFebTotalTarget());%>],
                    [3.0, <%out.print(TotalSales.getMarTotalTarget());%>],
                    [4.0, <%out.print(TotalSales.getAprTotalTarget());%>],
                    [5.0, <%out.print(TotalSales.getMayTotalTarget());%>],
                    [6.0, <%out.print(TotalSales.getJunTotalTarget());%>],
                    [7.0, <%out.print(TotalSales.getJulTotalTarget());%>],
                    [8.0, <%out.print(TotalSales.getAugTotalTarget());%>],
                    [9.0, <%out.print(TotalSales.getSepTotalTarget());%>],
                    [10.0, <%out.print(TotalSales.getOctTotalTarget());%>],
                    [11.0, <%out.print(TotalSales.getNovTotalTarget());%>],
                    [12.0, <%out.print(TotalSales.getDecTotalTarget());%>]
                ];

                var d1_2 = [
                    [1.0, <%out.print(TotalSales.getJanTotalAmount());%>],
                    [2.0, <%out.print(TotalSales.getFebTotalAmount());%>],
                    [3.0, <%out.print(TotalSales.getMarTotalAmount());%>],
                    [4.0, <%out.print(TotalSales.getAprTotalAmount());%>],
                    [5.0, <%out.print(TotalSales.getMayTotalAmount());%>],
                    [6.0, <%out.print(TotalSales.getJunTotalAmount());%>],
                    [7.0, <%out.print(TotalSales.getJulTotalAmount());%>],
                    [8.0, <%out.print(TotalSales.getAugTotalAmount());%>],
                    [9.0, <%out.print(TotalSales.getSepTotalAmount());%>],
                    [10.0, <%out.print(TotalSales.getOctTotalAmount());%>],
                    [11.0, <%out.print(TotalSales.getNovTotalAmount());%>],
                    [12.0, <%out.print(TotalSales.getDecTotalAmount());%>]
                ];

                var data1 = [
                    {
                        label: "My Target",
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
                        label: "Actual Sales to Date",
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
                        <ul class="nav navbar-nav" style="display: block;">
                            <li><a href="sd_overview.jsp">Home</a></li>
                            <li><a href="accounts_page.jsp">Accounts</a></li>
                            <li class="active"><a href="sa_total_sales.jsp">Sales Analysis</a></li>
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
                        <li class="active"><a href="sa_total_sales.jsp">Total Sales</a></li>
                        <li><a href="sa_accounts.jsp">Accounts</a></li>
                        <li><a href="sa_products.jsp">Products</a></li>
                        <li><a href="sa_forecast.jsp">Forecast</a></li>
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
                <h2>Total Sales vs. Target</h2>
            </div>
        </div>

        <div class="container" id="body">
            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="demo-container">
                                <div id="placeholder" class="demo-placeholder"></div>
                            </div>
                            <div class="table-responsive">
                                <table class="table display" cellspacing="0" id="total_sales">
                                    <thead>
                                        <tr>
                                            <th>Total Sales vs. Target</th>
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
//                                            System.out.println(NumberFormat.getNumberInstance(Locale.US).format(Math.round(Jan.getSalesForecast())));
                                        %>
                                        <tr>
                                            <th>My Target</th>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(TotalSales.getJanTotalTarget())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(TotalSales.getFebTotalTarget())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(TotalSales.getMarTotalTarget())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(TotalSales.getAprTotalTarget())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(TotalSales.getMayTotalTarget())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(TotalSales.getJunTotalTarget())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(TotalSales.getJulTotalTarget())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(TotalSales.getAugTotalTarget())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(TotalSales.getSepTotalTarget())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(TotalSales.getOctTotalTarget())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(TotalSales.getNovTotalTarget())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(TotalSales.getDecTotalTarget())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(TotalSales.getYearTotalTarget()));%></td>
                                        </tr>
                                        <tr>
                                            <th>Actual Sales to Date</th>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(TotalSales.getJanTotalAmount())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(TotalSales.getFebTotalAmount())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(TotalSales.getMarTotalAmount())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(TotalSales.getAprTotalAmount())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(TotalSales.getMayTotalAmount())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(TotalSales.getJunTotalAmount())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(TotalSales.getJulTotalAmount())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(TotalSales.getAugTotalAmount())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(TotalSales.getSepTotalAmount())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(TotalSales.getOctTotalAmount())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(TotalSales.getNovTotalAmount())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(TotalSales.getDecTotalAmount())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(TotalSales.getYearTotalAmount()));%></td>
                                        </tr>
                                        <tr>
                                            <th>Actual vs. Target %</th>
                                            <td><%out.print(Math.round((TotalSales.getJanTotalAmount() * 100.0f) / TotalSales.getJanTotalTarget()));%>%</td>
                                            <td><%out.print(Math.round((TotalSales.getFebTotalAmount() * 100.0f) / TotalSales.getFebTotalTarget()));%>%</td>
                                            <td><%out.print(Math.round((TotalSales.getMarTotalAmount() * 100.0f) / TotalSales.getMarTotalTarget()));%>%</td>
                                            <td><%out.print(Math.round((TotalSales.getAprTotalAmount() * 100.0f) / TotalSales.getAprTotalTarget()));%>%</td>
                                            <td><%out.print(Math.round((TotalSales.getMayTotalAmount() * 100.0f) / TotalSales.getMayTotalTarget()));%>%</td>
                                            <td><%out.print(Math.round((TotalSales.getJunTotalAmount() * 100.0f) / TotalSales.getJunTotalTarget()));%>%</td>
                                            <td><%out.print(Math.round((TotalSales.getJulTotalAmount() * 100.0f) / TotalSales.getJulTotalTarget()));%>%</td>
                                            <td><%out.print(Math.round((TotalSales.getAugTotalAmount() * 100.0f) / TotalSales.getAugTotalTarget()));%>%</td>
                                            <td><%out.print(Math.round((TotalSales.getSepTotalAmount() * 100.0f) / TotalSales.getSepTotalTarget()));%>%</td>
                                            <td><%out.print(Math.round((TotalSales.getOctTotalAmount() * 100.0f) / TotalSales.getOctTotalTarget()));%>%</td>
                                            <td><%out.print(Math.round((TotalSales.getNovTotalAmount() * 100.0f) / TotalSales.getNovTotalTarget()));%>%</td>
                                            <td><%out.print(Math.round((TotalSales.getDecTotalAmount() * 100.0f) / TotalSales.getDecTotalTarget()));%>%</td>
                                            <td><%out.print(Math.round((TotalSales.getYearTotalAmount() * 100.0f) / TotalSales.getYearTotalAmount()));%>%</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
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
                $('#total_sales').DataTable({
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