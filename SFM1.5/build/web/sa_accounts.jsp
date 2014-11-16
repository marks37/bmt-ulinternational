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
        <title>Sales Analysis | Sales Force Management</title>
        <!--        <link rel="stylesheet" href="css/bootstrap-theme.css" type="text/css"/>
                <link rel="stylesheet" href="css/bootstrap-theme.min.css" type="text/css"/>
                <link rel="stylesheet" href="css/bootstrap.css" type="text/css">-->
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"/>
        <link rel="stylesheet" type="text/css" href="css/dataTables.tableTools.css">
        <link rel="stylesheet" type="text/css" href="css/jquery.dataTables.css">
        <script src="js/jquery-1.11.1.min.js"></script>

        <link rel="stylesheet" href="css/navbar.css" type="text/css"/>
        <link rel="stylesheet" href="css/sa_account.css" type="text/css"/>
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
                ArrayList<Sales> TotalSalesByAccount = (ArrayList<Sales>) session.getAttribute("TotalSalesByAccount");

                double acct1_amtY1 = 0;
                double acct1_amtY2 = 0;
                double acct1_amtY3 = 0;

                double acct2_amtY1 = 0;
                double acct2_amtY2 = 0;
                double acct2_amtY3 = 0;

                double acct3_amtY1 = 0;
                double acct3_amtY2 = 0;
                double acct3_amtY3 = 0;

                double acct4_amtY1 = 0;
                double acct4_amtY2 = 0;
                double acct4_amtY3 = 0;

                double acct5_amtY1 = 0;
                double acct5_amtY2 = 0;
                double acct5_amtY3 = 0;

                double acct6_amtY1 = 0;
                double acct6_amtY2 = 0;
                double acct6_amtY3 = 0;

                double acct7_amtY1 = 0;
                double acct7_amtY2 = 0;
                double acct7_amtY3 = 0;

                double acct8_amtY1 = 0;
                double acct8_amtY2 = 0;
                double acct8_amtY3 = 0;

                double acct9_amtY1 = 0;
                double acct9_amtY2 = 0;
                double acct9_amtY3 = 0;

                double acct10_amtY1 = 0;
                double acct10_amtY2 = 0;
                double acct10_amtY3 = 0;

                double acct11_amtY1 = 0;
                double acct11_amtY2 = 0;
                double acct11_amtY3 = 0;

                double total_amtY1 = 0;
                double total_amtY2 = 0;
                double total_amtY3 = 0;

                String acct1_str = "";
                String acct2_str = "";
                String acct3_str = "";
                String acct4_str = "";
                String acct5_str = "";
                String acct6_str = "";
                String acct7_str = "";
                String acct8_str = "";
                String acct9_str = "";
                String acct10_str = "";
                String acct11_str = "";

                for (int a = 0; a < TotalSalesByAccount.size(); a++) {

                    if (a == 0) {
                        acct1_amtY1 = TotalSalesByAccount.get(a).getYear1Amount();
                        acct1_amtY2 = TotalSalesByAccount.get(a).getYear2Amount();
                        acct1_amtY3 = TotalSalesByAccount.get(a).getYear3Amount();
                        acct1_str = TotalSalesByAccount.get(a).getEnglishName();

                    } else if (a == 1) {
                        acct2_amtY1 = TotalSalesByAccount.get(a).getYear1Amount();
                        acct2_amtY2 = TotalSalesByAccount.get(a).getYear2Amount();
                        acct2_amtY3 = TotalSalesByAccount.get(a).getYear3Amount();
                        acct2_str = TotalSalesByAccount.get(a).getEnglishName();
                    } else if (a == 2) {
                        acct3_amtY1 = TotalSalesByAccount.get(a).getYear1Amount();
                        acct3_amtY2 = TotalSalesByAccount.get(a).getYear2Amount();
                        acct3_amtY3 = TotalSalesByAccount.get(a).getYear3Amount();
                        acct3_str = TotalSalesByAccount.get(a).getEnglishName();
                    } else if (a == 3) {
                        acct4_amtY1 = TotalSalesByAccount.get(a).getYear1Amount();
                        acct4_amtY2 = TotalSalesByAccount.get(a).getYear2Amount();
                        acct4_amtY3 = TotalSalesByAccount.get(a).getYear3Amount();
                        acct4_str = TotalSalesByAccount.get(a).getEnglishName();
                    } else if (a == 4) {
                        acct5_amtY1 = TotalSalesByAccount.get(a).getYear1Amount();
                        acct5_amtY2 = TotalSalesByAccount.get(a).getYear2Amount();
                        acct5_amtY3 = TotalSalesByAccount.get(a).getYear3Amount();
                        acct5_str = TotalSalesByAccount.get(a).getEnglishName();
                    } else if (a == 5) {
                        acct6_amtY1 = TotalSalesByAccount.get(a).getYear1Amount();
                        acct6_amtY2 = TotalSalesByAccount.get(a).getYear2Amount();
                        acct6_amtY3 = TotalSalesByAccount.get(a).getYear3Amount();
                        acct6_str = TotalSalesByAccount.get(a).getEnglishName();
                    } else if (a == 6) {
                        acct7_amtY1 = TotalSalesByAccount.get(a).getYear1Amount();
                        acct7_amtY2 = TotalSalesByAccount.get(a).getYear2Amount();
                        acct7_amtY3 = TotalSalesByAccount.get(a).getYear3Amount();
                        acct7_str = TotalSalesByAccount.get(a).getEnglishName();
                    } else if (a == 7) {
                        acct8_amtY1 = TotalSalesByAccount.get(a).getYear1Amount();
                        acct8_amtY2 = TotalSalesByAccount.get(a).getYear2Amount();
                        acct8_amtY3 = TotalSalesByAccount.get(a).getYear3Amount();
                        acct8_str = TotalSalesByAccount.get(a).getEnglishName();
                    } else if (a == 8) {
                        acct9_amtY1 = TotalSalesByAccount.get(a).getYear1Amount();
                        acct9_amtY2 = TotalSalesByAccount.get(a).getYear2Amount();
                        acct9_amtY3 = TotalSalesByAccount.get(a).getYear3Amount();
                        acct9_str = TotalSalesByAccount.get(a).getEnglishName();
                    } else if (a == 9) {
                        acct10_amtY1 = TotalSalesByAccount.get(a).getYear1Amount();
                        acct10_amtY2 = TotalSalesByAccount.get(a).getYear2Amount();
                        acct10_amtY3 = TotalSalesByAccount.get(a).getYear3Amount();
                        acct10_str = TotalSalesByAccount.get(a).getEnglishName();
                    } else if (a >= 10) {
                        acct11_amtY1 = acct11_amtY1 + TotalSalesByAccount.get(a).getYear1Amount();
                        acct11_amtY2 = acct11_amtY2 + TotalSalesByAccount.get(a).getYear2Amount();
                        acct11_amtY3 = acct11_amtY3 + TotalSalesByAccount.get(a).getYear3Amount();
                        acct11_str = "Others";

                    }
                }

            %>
                var d1_1 = [
                    [<%out.print(acct1_amtY1);%>, 11.0],
                    [<%out.print(acct2_amtY1);%>, 10.0],
                    [<%out.print(acct3_amtY1);%>, 9.0],
                    [<%out.print(acct4_amtY1);%>, 8.0],
                    [<%out.print(acct5_amtY1);%>, 7.0],
                    [<%out.print(acct6_amtY1);%>, 6.0],
                    [<%out.print(acct7_amtY1);%>, 5.0],
                    [<%out.print(acct8_amtY1);%>, 4.0],
                    [<%out.print(acct9_amtY1);%>, 3.0],
                    [<%out.print(acct10_amtY1);%>, 2.0],
                    [<%out.print(acct11_amtY1);%>, 1.0]
                ];

                var d1_2 = [
                    [<%out.print(acct1_amtY2);%>, 11.0],
                    [<%out.print(acct2_amtY2);%>, 10.0],
                    [<%out.print(acct3_amtY2);%>, 9.0],
                    [<%out.print(acct4_amtY2);%>, 8.0],
                    [<%out.print(acct5_amtY2);%>, 7.0],
                    [<%out.print(acct6_amtY2);%>, 6.0],
                    [<%out.print(acct7_amtY2);%>, 5.0],
                    [<%out.print(acct8_amtY2);%>, 4.0],
                    [<%out.print(acct9_amtY2);%>, 3.0],
                    [<%out.print(acct10_amtY2);%>, 2.0],
                    [<%out.print(acct11_amtY2);%>, 1.0]
                ];

                var d1_3 = [
                    [<%out.print(8000);%>, 11.0],
                    [<%out.print(acct2_amtY3);%>, 10.0],
                    [<%out.print(acct3_amtY3);%>, 9.0],
                    [<%out.print(acct4_amtY3);%>, 8.0],
                    [<%out.print(acct5_amtY3);%>, 7.0],
                    [<%out.print(acct6_amtY3);%>, 6.0],
                    [<%out.print(acct7_amtY3);%>, 5.0],
                    [<%out.print(acct8_amtY3);%>, 4.0],
                    [<%out.print(acct9_amtY3);%>, 3.0],
                    [<%out.print(acct10_amtY3);%>, 2.0],
                    [<%out.print(acct11_amtY3);%>, 1.0]
                ];

                var data1 = [
                    {
                        label: "Year 1",
                        data: d1_1,
                        bars: {
                            align: "center",
                            show: true,
                            barWidth: 0.3,
                            fill: true,
                            lineWidth: 1,
                            order: 3,
                            horizontal: true
//                            fillColor: "#46b8da"
                        }
//                        color: "#46b8da"
                    },
                    {
                        label: "Year 2",
                        data: d1_2,
                        bars: {
                             align: "center",
                            show: true,
                            barWidth: 0.3,
                            fill: true,
                            lineWidth: 1,
                            order: 2,
                            horizontal: true
//                            fillColor: "#89A54E"
                        }
//                        color: "#89A54E"
                    },
                    {
                        label: "Year 3",
                        data: d1_3,
                        bars: {
                             align: "center",
                            show: true,
                            barWidth: 0.3,
                            fill: true,
                            lineWidth: 1,
                            order: 1,
                            horizontal: true
//                            fillColor: "#89A54E"
                        }
//                        color: "#89A54E"
                    }
                    
                ];

                var ticks = [
                    [1, "<%=acct11_str%>"], [2, "<%=acct10_str%>"], [3, "<%=acct9_str%>"], [4, "<%=acct8_str%>"], [5, "<%=acct7_str%>"], [6, "<%=acct6_str%>"], [7, "<%=acct5_str%>"], [8, "<%=acct4_str%>"], [9, "<%=acct3_str%>"], [10, "<%=acct2_str%>"], [11, "<%=acct1_str%>"]
                ];


                $.plot($("#placeholder"), data1, {
                    yaxis: {
                        min: 0.0,
                        max: 12.0,
                        mode: "categories",
                        ticks: ticks,
                        tickLength: 0, // hide gridlines
//                        autoscaleMargin: 0.5,
                        axisLabelUseCanvas: true,
                        axisLabel: "Accounts",
                        axisLabelFontSizePixels: 12,
                        axisLabelFontFamily: 'Verdana, Arial',
                        axisLabelPadding: 5
                    },
                    xaxis: {
                        min: 2000,
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
                        position: "ne"
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
                        <li><a href="sa_total_sales.jsp">Total Sales</a></li>
                        <li class="active"><a href="sa_accounts.jsp">Accounts</a></li>
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
                <h2>Sales Analysis By Account</h2>
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
                                            <th>Account Ranking</th>
                                            <th>Account Name</th>
                                            <th>2012</th>
                                            <th>2013</th>
                                            <th>2014</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
//                                            System.out.println(NumberFormat.getNumberInstance(Locale.US).format(Math.round(Jan.getSalesForecast())));
                                            int index = 0;
                                            for (int a = 0; a < TotalSalesByAccount.size(); a++) {
                                                index++;

                                        %>
                                        <tr>
                                            <td><%=index%></td>
                                            <td><%out.print(TotalSalesByAccount.get(a).getEnglishName());%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(TotalSalesByAccount.get(a).getYear3Amount())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(TotalSalesByAccount.get(a).getYear2Amount())));%></td>
                                            <td><%out.print(NumberFormat.getNumberInstance(Locale.US).format(Math.round(TotalSalesByAccount.get(a).getYear1Amount())));%></td>
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