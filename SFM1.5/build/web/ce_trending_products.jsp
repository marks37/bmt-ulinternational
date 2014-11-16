<%-- 
    Document   : ce_trending_products
    Created on : 11 6, 14, 5:14:12 AM
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
        <title>Trending Products | Sales Force Management</title>
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"/>
        <link rel="stylesheet" type="text/css" href="css/dataTables.tableTools.css">
        <link rel="stylesheet" type="text/css" href="css/jquery.dataTables.css">
        <link rel="stylesheet" href="css/navbar.css" type="text/css"/>
        <link rel="stylesheet" href="css/ce_trending_products.css" type="text/css"/>

        <script src="js/jquery-1.11.1.min.js"></script>

        <link rel="shortcut icon" href="images/unilab_icon.ico" type="image/x-icon">
        <link rel="icon" href="images/unilab_icon.ico" type="image/x-icon">

        <script src="js/jquery.knob.min.js"></script>
        <script language="javascript" type="text/javascript" src="js/jquery.flot.js"></script>

        <script language="javascript" type="text/javascript" src="js/jquery.flot.orderBars.js"></script>
        <script language="javascript" type="text/javascript" src="js/jquery.flot.axislabels.js"></script>

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
                        if (this.$.data('skin') === 'tron') {

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
        <script>
            $(function () {

                $(document).ready(function () {
                });




            });
        </script>
        <script>
            $(function () {
                var placeholder1 = $("#placeholder1");
                var placeholder2 = $("#placeholder2");
                var placeholder3 = $("#placeholder3");
                var placeholder4 = $("#placeholder4");
                var placeholder5 = $("#placeholder5");
                var placeholder6 = $("#placeholder6");

                $("#example-1").click(function () {
                    placeholder1.unbind();


            <%

                ArrayList<Trending_Products> ThisMonthTrending = (ArrayList<Trending_Products>) session.getAttribute("ThisMonthTrending");
                double prod1_amt = 0;
                double prod2_amt = 0;
                double prod3_amt = 0;
                double prod4_amt = 0;
                double prod5_amt = 0;
                double prod6_amt = 0;
                double prodtotal_amt = 0;

                String prod1_str = "";
                String prod2_str = "NONE";
                String prod3_str = "NONE";
                String prod4_str = "NONE";
                String prod5_str = "NONE";
                String prod6_str = "NONE";
                for (int a = 0; a < ThisMonthTrending.size(); a++) {
                    if (a == 0) {
                        prod1_str = ThisMonthTrending.get(a).getDescription();
                        prod1_amt = ThisMonthTrending.get(a).getThisMonthTotalAmount();
                    } else if (a == 1) {
                        prod2_str = ThisMonthTrending.get(a).getDescription();
                        prod2_amt = ThisMonthTrending.get(a).getThisMonthTotalAmount();
                    } else if (a == 2) {
                        prod3_str = ThisMonthTrending.get(a).getDescription();
                        prod3_amt = ThisMonthTrending.get(a).getThisMonthTotalAmount();
                    } else if (a == 3) {
                        prod4_str = ThisMonthTrending.get(a).getDescription();
                        prod4_amt = ThisMonthTrending.get(a).getThisMonthTotalAmount();
                    } else if (a == 4) {
                        prod5_str = ThisMonthTrending.get(a).getDescription();
                        prod5_amt = ThisMonthTrending.get(a).getThisMonthTotalAmount();
                    } else if (a >= 5) {
                        prod6_str = "Others";
                        prod6_amt = prod6_amt + ThisMonthTrending.get(a).getThisMonthTotalAmount();
                    }
                    prodtotal_amt = prodtotal_amt + ThisMonthTrending.get(a).getThisMonthTotalAmount();
                }

                long prod1_val = Math.round((prod1_amt * 100.0f) / prodtotal_amt);
                long prod2_val = Math.round((prod2_amt * 100.0f) / prodtotal_amt);
                long prod3_val = Math.round((prod3_amt * 100.0f) / prodtotal_amt);
                long prod4_val = Math.round((prod4_amt * 100.0f) / prodtotal_amt);
                long prod5_val = Math.round((prod5_amt * 100.0f) / prodtotal_amt);
                long prod6_val = Math.round((prod6_amt * 100.0f) / prodtotal_amt);
            %>

                    var data = [
                        {label: "<%="Item 1: " + prod1_val + "%"%>", data: [[1, <%=prod1_amt%>]]},
                        {label: "<%="Item 2 :" + prod2_val + "%"%>", data: [[2, <%=prod2_amt%>]]},
                        {label: "<%="Item 3 :" + prod3_val + "%"%>", data: [[3, <%=prod3_amt%>]]},
                        {label: "<%="Item 4 :" + prod4_val + "%"%>", data: [[4, <%=prod4_amt%>]]},
                        {label: "<%="Item 5 :" + prod5_val + "%"%>", data: [[5, <%=prod5_amt%>]]},
                        {label: "<%="Item 6 :" + prod6_val + "%"%>", data: [[6, <%=prod6_amt%>]]}
                    ];

                    $.plot($("#placeholder1"), data, {
                        series: {
                            lines: {
                                fill: true
                            },
                            bars: {
                                show: true,
                                align: 'center',
                                barWidth: 0.8,
                            }
                        },
                        xaxis: {
                            min: 0.0,
                            max: 7.0,
                            ticks: [[1, "<%=prod1_str%>"], [2, "<%=prod2_str%>"], [3, "<%=prod3_str%>"], [4, "<%=prod4_str%>"], [5, "<%=prod5_str%>"], [6, "<%=prod6_str%>"]],
                            tickLength: 0, // hide gridlines
                            axisLabelUseCanvas: true,
                            axisLabel: "Products",
                            axisLabelFontSizePixels: 12,
                            axisLabelFontFamily: 'Verdana, Arial',
                            axisLabelPadding: 5,
                            shadowSize: 1

                        },
                        yaxis: {
//                            min: 0,
                            axisLabel: "Sales",
                            axisLabelUseCanvas: true,
                            axisLabelFontSizePixels: 12,
                            axisLabelFontFamily: 'Verdana, Arial',
                            axisLabelPadding: 5

                        },
                        grid: {
                            hoverable: true,
                            clickable: true,
                            borderWidth: 1
                        },
                        legend: {
                            labelBoxBorderColor: "none",
                            position: "ne"
                        }

                    });

                    function showTooltip(x, y, contents, z) {
                        $('<div id="flot-tooltip">' + contents + '</div>').css({
                            top: y - 20,
                            left: x - 90,
                            'border-color': z,
                        }).appendTo("body").show();
                    }

                    $("#placeholder1").bind("plothover", function (event, pos, item) {
                        var previousPoint;
                        if (item) {
                            if (previousPoint != item.datapoint) {
                                previousPoint = item.datapoint;
                                $("#flot-tooltip").remove();

                                var originalPoint;

                                if (item.datapoint[0] == item.series.data[0]) {
                                    originalPoint = item.series.data[0][0];
                                } else if (item.datapoint[0] == item.series.data[1]) {
                                    originalPoint = item.series.data[1][0];
                                } else if (item.datapoint[0] == item.series.data[2]) {
                                    originalPoint = item.series.data[2][0];
                                } else if (item.datapoint[0] == item.series.data[3]) {
                                    originalPoint = item.series.data[3][0];
                                } else if (item.datapoint[0] == item.series.data[4]) {
                                    originalPoint = item.series.data[4][0];
                                }

                                var x = originalPoint;
                                y = item.datapoint[1];
                                z = item.series.color;

                                showTooltip(item.pageX, item.pageY,
                                        "<b>" + item.series.label + "</b><br /> " + " Amount: " + y,
                                        z);
                            }
                        } else {
                            $("#flot-tooltip").remove();
                            previousPoint = null;
                        }
                    });



                });
                $("#example-2").click(function () {
                    placeholder2.unbind();


            <%

                ArrayList<Trending_Products> ThisYearTrending = (ArrayList<Trending_Products>) session.getAttribute("ThisYearTrending");
                prod1_amt = 0;
                prod2_amt = 0;
                prod3_amt = 0;
                prod4_amt = 0;
                prod5_amt = 0;
                prod6_amt = 0;
                prodtotal_amt = 0;

                prod1_str = "";
                prod2_str = "NONE";
                prod3_str = "NONE";
                prod4_str = "NONE";
                prod5_str = "NONE";
                prod6_str = "NONE";
                for (int a = 0; a < ThisYearTrending.size(); a++) {
                    if (a == 0) {
                        prod1_str = ThisYearTrending.get(a).getDescription();
                        prod1_amt = ThisYearTrending.get(a).getThisYearTotalAmount();
                    } else if (a == 1) {
                        prod2_str = ThisYearTrending.get(a).getDescription();
                        prod2_amt = ThisYearTrending.get(a).getThisYearTotalAmount();
                    } else if (a == 2) {
                        prod3_str = ThisYearTrending.get(a).getDescription();
                        prod3_amt = ThisYearTrending.get(a).getThisYearTotalAmount();
                    } else if (a == 3) {
                        prod4_str = ThisYearTrending.get(a).getDescription();
                        prod4_amt = ThisYearTrending.get(a).getThisYearTotalAmount();
                    } else if (a == 4) {
                        prod5_str = ThisYearTrending.get(a).getDescription();
                        prod5_amt = ThisYearTrending.get(a).getThisYearTotalAmount();
                    } else if (a >= 5) {
                        prod6_str = ThisYearTrending.get(a).getDescription();
                        prod6_amt = prod6_amt + ThisYearTrending.get(a).getThisYearTotalAmount();
                    }
                    prodtotal_amt = prodtotal_amt + ThisYearTrending.get(a).getThisYearTotalAmount();
                }

                prod1_val = Math.round((prod1_amt * 100.0f) / prodtotal_amt);
                prod2_val = Math.round((prod2_amt * 100.0f) / prodtotal_amt);
                prod3_val = Math.round((prod3_amt * 100.0f) / prodtotal_amt);
                prod4_val = Math.round((prod4_amt * 100.0f) / prodtotal_amt);
                prod5_val = Math.round((prod5_amt * 100.0f) / prodtotal_amt);
                prod6_val = Math.round((prod6_amt * 100.0f) / prodtotal_amt);
            %>

                    var data = [
                        {label: "<%="Item 1: " + prod1_val + "%"%>", data: [[1, <%=prod1_amt%>]]},
                        {label: "<%="Item 2 :" + prod2_val + "%"%>", data: [[2, <%=prod2_amt%>]]},
                        {label: "<%="Item 3 :" + prod3_val + "%"%>", data: [[3, <%=prod3_amt%>]]},
                        {label: "<%="Item 4 :" + prod4_val + "%"%>", data: [[4, <%=prod4_amt%>]]},
                        {label: "<%="Item 5 :" + prod5_val + "%"%>", data: [[5, <%=prod5_amt%>]]},
                        {label: "<%="Item 6 :" + prod6_val + "%"%>", data: [[6, <%=prod6_amt%>]]}
                    ];

                    $.plot($("#placeholder2"), data, {
                        series: {
                            lines: {
                                fill: true
                            },
                            bars: {
                                show: true,
                                align: 'center',
                                barWidth: 0.8,
                            }
                        },
                        xaxis: {
                            min: 0.0,
                            max: 7.0,
                            ticks: [[1, "<%=prod1_str%>"], [2, "<%=prod2_str%>"], [3, "<%=prod3_str%>"], [4, "<%=prod4_str%>"], [5, "<%=prod5_str%>"], [6, "<%=prod6_str%>"]],
                            tickLength: 0, // hide gridlines
                            axisLabelUseCanvas: true,
                            axisLabel: "Products",
                            axisLabelFontSizePixels: 12,
                            axisLabelFontFamily: 'Verdana, Arial',
                            axisLabelPadding: 5,
                            shadowSize: 1

                        },
                        yaxis: {
//                            min: 0,
                            axisLabel: "Sales",
                            axisLabelUseCanvas: true,
                            axisLabelFontSizePixels: 12,
                            axisLabelFontFamily: 'Verdana, Arial',
                            axisLabelPadding: 5

                        },
                        grid: {
                            hoverable: true,
                            clickable: true,
                            borderWidth: 1
                        },
                        legend: {
                            labelBoxBorderColor: "none",
                            position: "ne"
                        }

                    });

                    function showTooltip(x, y, contents, z) {
                        $('<div id="flot-tooltip">' + contents + '</div>').css({
                            top: y - 20,
                            left: x - 90,
                            'border-color': z,
                        }).appendTo("body").show();
                    }

                    $("#placeholder2").bind("plothover", function (event, pos, item) {
                        var previousPoint;
                        if (item) {
                            if (previousPoint != item.datapoint) {
                                previousPoint = item.datapoint;
                                $("#flot-tooltip").remove();

                                var originalPoint;

                                if (item.datapoint[0] == item.series.data[0]) {
                                    originalPoint = item.series.data[0][0];
                                } else if (item.datapoint[0] == item.series.data[1]) {
                                    originalPoint = item.series.data[1][0];
                                } else if (item.datapoint[0] == item.series.data[2]) {
                                    originalPoint = item.series.data[2][0];
                                } else if (item.datapoint[0] == item.series.data[3]) {
                                    originalPoint = item.series.data[3][0];
                                } else if (item.datapoint[0] == item.series.data[4]) {
                                    originalPoint = item.series.data[4][0];
                                }

                                var x = originalPoint;
                                y = item.datapoint[1];
                                z = item.series.color;

                                showTooltip(item.pageX, item.pageY,
                                        "<b>" + item.series.label + "</b><br /> " + " Amount: " + y,
                                        z);
                            }
                        } else {
                            $("#flot-tooltip").remove();
                            previousPoint = null;
                        }
                    });


                });
                $("#example-3").click(function () {
                    placeholder3.unbind();


            <%

                ArrayList<Trending_Products> P3Trending = (ArrayList<Trending_Products>) session.getAttribute("P3Trending");
                prod1_amt = 0;
                prod2_amt = 0;
                prod3_amt = 0;
                prod4_amt = 0;
                prod5_amt = 0;
                prod6_amt = 0;
                prodtotal_amt = 0;

                prod1_str = "";
                prod2_str = "NONE";
                prod3_str = "NONE";
                prod4_str = "NONE";
                prod5_str = "NONE";
                prod6_str = "NONE";
                for (int a = 0; a < P3Trending.size(); a++) {
                    if (a == 0) {
                        prod1_str = P3Trending.get(a).getDescription();
                        prod1_amt = P3Trending.get(a).getP3TotalAmount();
                    } else if (a == 1) {
                        prod2_str = P3Trending.get(a).getDescription();
                        prod2_amt = P3Trending.get(a).getP3TotalAmount();
                    } else if (a == 2) {
                        prod3_str = P3Trending.get(a).getDescription();
                        prod3_amt = P3Trending.get(a).getP3TotalAmount();
                    } else if (a == 3) {
                        prod4_str = P3Trending.get(a).getDescription();
                        prod4_amt = P3Trending.get(a).getP3TotalAmount();
                    } else if (a == 4) {
                        prod5_str = P3Trending.get(a).getDescription();
                        prod5_amt = P3Trending.get(a).getP3TotalAmount();
                    } else if (a >= 5) {
                        prod6_str = P3Trending.get(a).getDescription();
                        prod6_amt = prod6_amt + P3Trending.get(a).getP3TotalAmount();
                    }
                    prodtotal_amt = prodtotal_amt + P3Trending.get(a).getP3TotalAmount();
                }

                prod1_val = Math.round((prod1_amt * 100.0f) / prodtotal_amt);
                prod2_val = Math.round((prod2_amt * 100.0f) / prodtotal_amt);
                prod3_val = Math.round((prod3_amt * 100.0f) / prodtotal_amt);
                prod4_val = Math.round((prod4_amt * 100.0f) / prodtotal_amt);
                prod5_val = Math.round((prod5_amt * 100.0f) / prodtotal_amt);
                prod6_val = Math.round((prod6_amt * 100.0f) / prodtotal_amt);
            %>

                    var data = [
                        {label: "<%="Item 1: " + prod1_val + "%"%>", data: [[1, <%=prod1_amt%>]]},
                        {label: "<%="Item 2 :" + prod2_val + "%"%>", data: [[2, <%=prod2_amt%>]]},
                        {label: "<%="Item 3 :" + prod3_val + "%"%>", data: [[3, <%=prod3_amt%>]]},
                        {label: "<%="Item 4 :" + prod4_val + "%"%>", data: [[4, <%=prod4_amt%>]]},
                        {label: "<%="Item 5 :" + prod5_val + "%"%>", data: [[5, <%=prod5_amt%>]]},
                        {label: "<%="Item 6 :" + prod6_val + "%"%>", data: [[6, <%=prod6_amt%>]]}
                    ];

                    $.plot($("#placeholder3"), data, {
                        series: {
                            lines: {
                                fill: true
                            },
                            bars: {
                                show: true,
                                align: 'center',
                                barWidth: 0.8,
                            }
                        },
                        xaxis: {
                            min: 0.0,
                            max: 7.0,
                            ticks: [[1, "<%=prod1_str%>"], [2, "<%=prod2_str%>"], [3, "<%=prod3_str%>"], [4, "<%=prod4_str%>"], [5, "<%=prod5_str%>"], [6, "<%=prod6_str%>"]],
                            tickLength: 0, // hide gridlines
                            axisLabelUseCanvas: true,
                            axisLabel: "Products",
                            axisLabelFontSizePixels: 12,
                            axisLabelFontFamily: 'Verdana, Arial',
                            axisLabelPadding: 5,
                            shadowSize: 1

                        },
                        yaxis: {
//                            min: 0,
                            axisLabel: "Sales",
                            axisLabelUseCanvas: true,
                            axisLabelFontSizePixels: 12,
                            axisLabelFontFamily: 'Verdana, Arial',
                            axisLabelPadding: 5

                        },
                        grid: {
                            hoverable: true,
                            clickable: true,
                            borderWidth: 1
                        },
                        legend: {
                            labelBoxBorderColor: "none",
                            position: "ne"
                        }

                    });

                    function showTooltip(x, y, contents, z) {
                        $('<div id="flot-tooltip">' + contents + '</div>').css({
                            top: y - 20,
                            left: x - 90,
                            'border-color': z,
                        }).appendTo("body").show();
                    }

                    $("#placeholder3").bind("plothover", function (event, pos, item) {
                        var previousPoint;
                        if (item) {
                            if (previousPoint != item.datapoint) {
                                previousPoint = item.datapoint;
                                $("#flot-tooltip").remove();

                                var originalPoint;

                                if (item.datapoint[0] == item.series.data[0]) {
                                    originalPoint = item.series.data[0][0];
                                } else if (item.datapoint[0] == item.series.data[1]) {
                                    originalPoint = item.series.data[1][0];
                                } else if (item.datapoint[0] == item.series.data[2]) {
                                    originalPoint = item.series.data[2][0];
                                } else if (item.datapoint[0] == item.series.data[3]) {
                                    originalPoint = item.series.data[3][0];
                                } else if (item.datapoint[0] == item.series.data[4]) {
                                    originalPoint = item.series.data[4][0];
                                }

                                var x = originalPoint;
                                y = item.datapoint[1];
                                z = item.series.color;

                                showTooltip(item.pageX, item.pageY,
                                        "<b>" + item.series.label + "</b><br /> " + " Amount: " + y,
                                        z);
                            }
                        } else {
                            $("#flot-tooltip").remove();
                            previousPoint = null;
                        }
                    });

                });
                $("#example-4").click(function () {

                    placeholder4.unbind();


            <%

                ArrayList<Trending_Products> P6Trending = (ArrayList<Trending_Products>) session.getAttribute("P6Trending");
                prod1_amt = 0;
                prod2_amt = 0;
                prod3_amt = 0;
                prod4_amt = 0;
                prod5_amt = 0;
                prod6_amt = 0;
                prodtotal_amt = 0;

                prod1_str = "";
                prod2_str = "NONE";
                prod3_str = "NONE";
                prod4_str = "NONE";
                prod5_str = "NONE";
                prod6_str = "NONE";
                for (int a = 0; a < P6Trending.size(); a++) {
                    if (a == 0) {
                        prod1_str = P6Trending.get(a).getDescription();
                        prod1_amt = P6Trending.get(a).getP6TotalAmount();
                    } else if (a == 1) {
                        prod2_str = P6Trending.get(a).getDescription();
                        prod2_amt = P6Trending.get(a).getP6TotalAmount();
                    } else if (a == 2) {
                        prod3_str = P6Trending.get(a).getDescription();
                        prod3_amt = P6Trending.get(a).getP6TotalAmount();
                    } else if (a == 3) {
                        prod4_str = P6Trending.get(a).getDescription();
                        prod4_amt = P6Trending.get(a).getP6TotalAmount();
                    } else if (a == 4) {
                        prod5_str = P6Trending.get(a).getDescription();
                        prod5_amt = P6Trending.get(a).getP6TotalAmount();
                    } else if (a >= 5) {
                        prod6_str = P6Trending.get(a).getDescription();
                        prod6_amt = prod6_amt + P6Trending.get(a).getP6TotalAmount();
                    }
                    prodtotal_amt = prodtotal_amt + P6Trending.get(a).getP6TotalAmount();
                }

                prod1_val = Math.round((prod1_amt * 100.0f) / prodtotal_amt);
                prod2_val = Math.round((prod2_amt * 100.0f) / prodtotal_amt);
                prod3_val = Math.round((prod3_amt * 100.0f) / prodtotal_amt);
                prod4_val = Math.round((prod4_amt * 100.0f) / prodtotal_amt);
                prod5_val = Math.round((prod5_amt * 100.0f) / prodtotal_amt);
                prod6_val = Math.round((prod6_amt * 100.0f) / prodtotal_amt);
            %>

                    var data = [
                        {label: "<%="Item 1: " + prod1_val + "%"%>", data: [[1, <%=prod1_amt%>]]},
                        {label: "<%="Item 2 :" + prod2_val + "%"%>", data: [[2, <%=prod2_amt%>]]},
                        {label: "<%="Item 3 :" + prod3_val + "%"%>", data: [[3, <%=prod3_amt%>]]},
                        {label: "<%="Item 4 :" + prod4_val + "%"%>", data: [[4, <%=prod4_amt%>]]},
                        {label: "<%="Item 5 :" + prod5_val + "%"%>", data: [[5, <%=prod5_amt%>]]},
                        {label: "<%="Item 6 :" + prod6_val + "%"%>", data: [[6, <%=prod6_amt%>]]}
                    ];

                    $.plot($("#placeholder4"), data, {
                        series: {
                            lines: {
                                fill: true
                            },
                            bars: {
                                show: true,
                                align: 'center',
                                barWidth: 0.8,
                            }
                        },
                        xaxis: {
                            min: 0.0,
                            max: 7.0,
                            ticks: [[1, "<%=prod1_str%>"], [2, "<%=prod2_str%>"], [3, "<%=prod3_str%>"], [4, "<%=prod4_str%>"], [5, "<%=prod5_str%>"], [6, "<%=prod6_str%>"]],
                            tickLength: 0, // hide gridlines
                            axisLabelUseCanvas: true,
                            axisLabel: "Products",
                            axisLabelFontSizePixels: 12,
                            axisLabelFontFamily: 'Verdana, Arial',
                            axisLabelPadding: 5,
                            shadowSize: 1

                        },
                        yaxis: {
//                            min: 0,
                            axisLabel: "Sales",
                            axisLabelUseCanvas: true,
                            axisLabelFontSizePixels: 12,
                            axisLabelFontFamily: 'Verdana, Arial',
                            axisLabelPadding: 5

                        },
                        grid: {
                            hoverable: true,
                            clickable: true,
                            borderWidth: 1
                        },
                        legend: {
                            labelBoxBorderColor: "none",
                            position: "ne"
                        }

                    });

                    function showTooltip(x, y, contents, z) {
                        $('<div id="flot-tooltip">' + contents + '</div>').css({
                            top: y - 20,
                            left: x - 90,
                            'border-color': z,
                        }).appendTo("body").show();
                    }

                    $("#placeholder4").bind("plothover", function (event, pos, item) {
                        var previousPoint;
                        if (item) {
                            if (previousPoint != item.datapoint) {
                                previousPoint = item.datapoint;
                                $("#flot-tooltip").remove();

                                var originalPoint;

                                if (item.datapoint[0] == item.series.data[0]) {
                                    originalPoint = item.series.data[0][0];
                                } else if (item.datapoint[0] == item.series.data[1]) {
                                    originalPoint = item.series.data[1][0];
                                } else if (item.datapoint[0] == item.series.data[2]) {
                                    originalPoint = item.series.data[2][0];
                                } else if (item.datapoint[0] == item.series.data[3]) {
                                    originalPoint = item.series.data[3][0];
                                } else if (item.datapoint[0] == item.series.data[4]) {
                                    originalPoint = item.series.data[4][0];
                                }

                                var x = originalPoint;
                                y = item.datapoint[1];
                                z = item.series.color;

                                showTooltip(item.pageX, item.pageY,
                                        "<b>" + item.series.label + "</b><br /> " + " Amount: " + y,
                                        z);
                            }
                        } else {
                            $("#flot-tooltip").remove();
                            previousPoint = null;
                        }
                    });


                });
                $("#example-5").click(function () {
                    placeholder5.unbind();



            <%

                ArrayList<Trending_Products> P9Trending = (ArrayList<Trending_Products>) session.getAttribute("P9Trending");
                prod1_amt = 0;
                prod2_amt = 0;
                prod3_amt = 0;
                prod4_amt = 0;
                prod5_amt = 0;
                prod6_amt = 0;
                prodtotal_amt = 0;

                prod1_str = "";
                prod2_str = "NONE";
                prod3_str = "NONE";
                prod4_str = "NONE";
                prod5_str = "NONE";
                prod6_str = "NONE";
                for (int a = 0; a < P9Trending.size(); a++) {
                    if (a == 0) {
                        prod1_str = P9Trending.get(a).getDescription();
                        prod1_amt = P9Trending.get(a).getP9TotalAmount();
                    } else if (a == 1) {
                        prod2_str = P9Trending.get(a).getDescription();
                        prod2_amt = P9Trending.get(a).getP9TotalAmount();
                    } else if (a == 2) {
                        prod3_str = P9Trending.get(a).getDescription();
                        prod3_amt = P9Trending.get(a).getP9TotalAmount();
                    } else if (a == 3) {
                        prod4_str = P9Trending.get(a).getDescription();
                        prod4_amt = P9Trending.get(a).getP9TotalAmount();
                    } else if (a == 4) {
                        prod5_str = P9Trending.get(a).getDescription();
                        prod5_amt = P9Trending.get(a).getP9TotalAmount();
                    } else if (a >= 5) {
                        prod6_str = P9Trending.get(a).getDescription();
                        prod6_amt = prod6_amt + P9Trending.get(a).getP9TotalAmount();
                    }
                    prodtotal_amt = prodtotal_amt + P9Trending.get(a).getP9TotalAmount();
                }

                prod1_val = Math.round((prod1_amt * 100.0f) / prodtotal_amt);
                prod2_val = Math.round((prod2_amt * 100.0f) / prodtotal_amt);
                prod3_val = Math.round((prod3_amt * 100.0f) / prodtotal_amt);
                prod4_val = Math.round((prod4_amt * 100.0f) / prodtotal_amt);
                prod5_val = Math.round((prod5_amt * 100.0f) / prodtotal_amt);
                prod6_val = Math.round((prod6_amt * 100.0f) / prodtotal_amt);
            %>

                    var data = [
                        {label: "<%="Item 1: " + prod1_val + "%"%>", data: [[1, <%=prod1_amt%>]]},
                        {label: "<%="Item 2 :" + prod2_val + "%"%>", data: [[2, <%=prod2_amt%>]]},
                        {label: "<%="Item 3 :" + prod3_val + "%"%>", data: [[3, <%=prod3_amt%>]]},
                        {label: "<%="Item 4 :" + prod4_val + "%"%>", data: [[4, <%=prod4_amt%>]]},
                        {label: "<%="Item 5 :" + prod5_val + "%"%>", data: [[5, <%=prod5_amt%>]]},
                        {label: "<%="Item 6 :" + prod6_val + "%"%>", data: [[6, <%=prod6_amt%>]]}
                    ];

                    $.plot($("#placeholder5"), data, {
                        series: {
                            lines: {
                                fill: true
                            },
                            bars: {
                                show: true,
                                align: 'center',
                                barWidth: 0.8,
                            }
                        },
                        xaxis: {
                            min: 0.0,
                            max: 7.0,
                            ticks: [[1, "<%=prod1_str%>"], [2, "<%=prod2_str%>"], [3, "<%=prod3_str%>"], [4, "<%=prod4_str%>"], [5, "<%=prod5_str%>"], [6, "<%=prod6_str%>"]],
                            tickLength: 0, // hide gridlines
                            axisLabelUseCanvas: true,
                            axisLabel: "Products",
                            axisLabelFontSizePixels: 12,
                            axisLabelFontFamily: 'Verdana, Arial',
                            axisLabelPadding: 5,
                            shadowSize: 1

                        },
                        yaxis: {
//                            min: 0,
                            axisLabel: "Sales",
                            axisLabelUseCanvas: true,
                            axisLabelFontSizePixels: 12,
                            axisLabelFontFamily: 'Verdana, Arial',
                            axisLabelPadding: 5

                        },
                        grid: {
                            hoverable: true,
                            clickable: true,
                            borderWidth: 1
                        },
                        legend: {
                            labelBoxBorderColor: "none",
                            position: "ne"
                        }

                    });

                    function showTooltip(x, y, contents, z) {
                        $('<div id="flot-tooltip">' + contents + '</div>').css({
                            top: y - 20,
                            left: x - 90,
                            'border-color': z,
                        }).appendTo("body").show();
                    }

                    $("#placeholder5").bind("plothover", function (event, pos, item) {
                        var previousPoint;
                        if (item) {
                            if (previousPoint != item.datapoint) {
                                previousPoint = item.datapoint;
                                $("#flot-tooltip").remove();

                                var originalPoint;

                                if (item.datapoint[0] == item.series.data[0]) {
                                    originalPoint = item.series.data[0][0];
                                } else if (item.datapoint[0] == item.series.data[1]) {
                                    originalPoint = item.series.data[1][0];
                                } else if (item.datapoint[0] == item.series.data[2]) {
                                    originalPoint = item.series.data[2][0];
                                } else if (item.datapoint[0] == item.series.data[3]) {
                                    originalPoint = item.series.data[3][0];
                                } else if (item.datapoint[0] == item.series.data[4]) {
                                    originalPoint = item.series.data[4][0];
                                }

                                var x = originalPoint;
                                y = item.datapoint[1];
                                z = item.series.color;

                                showTooltip(item.pageX, item.pageY,
                                        "<b>" + item.series.label + "</b><br /> " + " Amount: " + y,
                                        z);
                            }
                        } else {
                            $("#flot-tooltip").remove();
                            previousPoint = null;
                        }
                    });
                });
                $("#example-6").click(function () {
                    placeholder6.unbind();



            <%

                ArrayList<Trending_Products> P12Trending = (ArrayList<Trending_Products>) session.getAttribute("P12Trending");
                prod1_amt = 0;
                prod2_amt = 0;
                prod3_amt = 0;
                prod4_amt = 0;
                prod5_amt = 0;
                prod6_amt = 0;
                prodtotal_amt = 0;

                prod1_str = "";
                prod2_str = "NONE";
                prod3_str = "NONE";
                prod4_str = "NONE";
                prod5_str = "NONE";
                prod6_str = "NONE";
                for (int a = 0; a < P12Trending.size(); a++) {
                    if (a == 0) {
                        prod1_str = P12Trending.get(a).getDescription();
                        prod1_amt = P12Trending.get(a).getP12TotalAmount();
                    } else if (a == 1) {
                        prod2_str = P12Trending.get(a).getDescription();
                        prod2_amt = P12Trending.get(a).getP12TotalAmount();
                    } else if (a == 2) {
                        prod3_str = P12Trending.get(a).getDescription();
                        prod3_amt = P12Trending.get(a).getP12TotalAmount();
                    } else if (a == 3) {
                        prod4_str = P12Trending.get(a).getDescription();
                        prod4_amt = P12Trending.get(a).getP12TotalAmount();
                    } else if (a == 4) {
                        prod5_str = P12Trending.get(a).getDescription();
                        prod5_amt = P12Trending.get(a).getP12TotalAmount();
                    } else if (a >= 5) {
                        prod6_str = P12Trending.get(a).getDescription();
                        prod6_amt = prod6_amt + P12Trending.get(a).getP12TotalAmount();
                    }
                    prodtotal_amt = prodtotal_amt + P12Trending.get(a).getP12TotalAmount();
                }

                prod1_val = Math.round((prod1_amt * 100.0f) / prodtotal_amt);
                prod2_val = Math.round((prod2_amt * 100.0f) / prodtotal_amt);
                prod3_val = Math.round((prod3_amt * 100.0f) / prodtotal_amt);
                prod4_val = Math.round((prod4_amt * 100.0f) / prodtotal_amt);
                prod5_val = Math.round((prod5_amt * 100.0f) / prodtotal_amt);
                prod6_val = Math.round((prod6_amt * 100.0f) / prodtotal_amt);
            %>

                    var data = [
                        {label: "<%="Item 1: " + prod1_val + "%"%>", data: [[1, <%=prod1_amt%>]]},
                        {label: "<%="Item 2 :" + prod2_val + "%"%>", data: [[2, <%=prod2_amt%>]]},
                        {label: "<%="Item 3 :" + prod3_val + "%"%>", data: [[3, <%=prod3_amt%>]]},
                        {label: "<%="Item 4 :" + prod4_val + "%"%>", data: [[4, <%=prod4_amt%>]]},
                        {label: "<%="Item 5 :" + prod5_val + "%"%>", data: [[5, <%=prod5_amt%>]]},
                        {label: "<%="Item 6 :" + prod6_val + "%"%>", data: [[6, <%=prod6_amt%>]]}
                    ];

                    $.plot($("#placeholder6"), data, {
                        series: {
                            lines: {
                                fill: true
                            },
                            bars: {
                                show: true,
                                align: 'center',
                                barWidth: 0.8,
                            }
                        },
                        xaxis: {
                            min: 0.0,
                            max: 7.0,
                            ticks: [[1, "<%=prod1_str%>"], [2, "<%=prod2_str%>"], [3, "<%=prod3_str%>"], [4, "<%=prod4_str%>"], [5, "<%=prod5_str%>"], [6, "<%=prod6_str%>"]],
                            tickLength: 0, // hide gridlines
                            axisLabelUseCanvas: true,
                            axisLabel: "Products",
                            axisLabelFontSizePixels: 12,
                            axisLabelFontFamily: 'Verdana, Arial',
                            axisLabelPadding: 5,
                            shadowSize: 1

                        },
                        yaxis: {
//                            min: 0,
                            axisLabel: "Sales",
                            axisLabelUseCanvas: true,
                            axisLabelFontSizePixels: 12,
                            axisLabelFontFamily: 'Verdana, Arial',
                            axisLabelPadding: 5

                        },
                        grid: {
                            hoverable: true,
                            clickable: true,
                            borderWidth: 1
                        },
                        legend: {
                            labelBoxBorderColor: "none",
                            position: "ne"
                        }

                    });

                    function showTooltip(x, y, contents, z) {
                        $('<div id="flot-tooltip">' + contents + '</div>').css({
                            top: y - 20,
                            left: x - 90,
                            'border-color': z,
                        }).appendTo("body").show();
                    }

                    $("#placeholder6").bind("plothover", function (event, pos, item) {
                        var previousPoint;
                        if (item) {
                            if (previousPoint != item.datapoint) {
                                previousPoint = item.datapoint;
                                $("#flot-tooltip").remove();

                                var originalPoint;

                                if (item.datapoint[0] == item.series.data[0]) {
                                    originalPoint = item.series.data[0][0];
                                } else if (item.datapoint[0] == item.series.data[1]) {
                                    originalPoint = item.series.data[1][0];
                                } else if (item.datapoint[0] == item.series.data[2]) {
                                    originalPoint = item.series.data[2][0];
                                } else if (item.datapoint[0] == item.series.data[3]) {
                                    originalPoint = item.series.data[3][0];
                                } else if (item.datapoint[0] == item.series.data[4]) {
                                    originalPoint = item.series.data[4][0];
                                }

                                var x = originalPoint;
                                y = item.datapoint[1];
                                z = item.series.color;

                                showTooltip(item.pageX, item.pageY,
                                        "<b>" + item.series.label + "</b><br /> " + " Amount: " + y,
                                        z);
                            }
                        } else {
                            $("#flot-tooltip").remove();
                            previousPoint = null;
                        }
                    });
                });

                $("#example-1").click();



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
                        <li class="active"><a href="ce_trending_products.jsp">Trending Products</a></li>
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
                        <li class="active"><a role="tab" data-toggle="tab" onclick="click()" id="example-1" href="#month">This month</a></li>
                        <li><a role="tab" data-toggle="tab" onclick="click()" id="example-2" href="#year">This year</a></li>
                        <li><a role="tab" data-toggle="tab" onclick="click()" id="example-3" href="#p3">Past 3 months</a></li>
                        <li><a role="tab" data-toggle="tab" onclick="click()" id="example-4" href="#p6">Past 6 months</a></li>
                        <li><a role="tab" data-toggle="tab" onclick="click()" id="example-5" href="#p9">Past 9 months</a></li>
                        <li><a role="tab" data-toggle="tab" onclick="click()" id="example-6" href="#p12">Past 12 months</a></li>
                    </ul>

                    <div class="panel panel-default tab-content" id="ph_panel">
                        <div class="panel-body tab-pane active" id="month">
                            <div class="demo-container">
                                <div id="placeholder1" class="demo-placeholder"></div>

                            </div>

                            <div class="table-responsive">
                                <table class="table display cell-border" cellspacing="0" id="month_table">
                                    <thead>
                                        <tr>
                                            <th rowspan="2">Rank</th>
                                            <th rowspan="2">Item Code</th>
                                            <th rowspan="2">Item Description</th>
                                            <th colspan="2">Total</th>
                                            <th colspan="2">Average</th>
                                        </tr>
                                        <tr>
                                            <th>Amount</th>
                                            <th>Units</th>
                                            <th>Amount</th>
                                            <th>Units</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            int index = 0;
                                            for (int a = 0; a < ThisMonthTrending.size(); a++) {
                                                index = index + 1;
                                        %>
                                        <tr>
                                            <td><%out.print(index);%></td>
                                            <td><%out.print(ThisMonthTrending.get(a).getItemCode());%></td>
                                            <td><%out.print(ThisMonthTrending.get(a).getDescription());%></td>
                                            <td><%out.print(ThisMonthTrending.get(a).getThisMonthTotalAmount());%></td>
                                            <td><%out.print(ThisMonthTrending.get(a).getThisMonthTotalUnits());%></td>
                                            <td><%out.print(ThisMonthTrending.get(a).getThisMonthAveAmount());%></td>
                                            <td><%out.print(ThisMonthTrending.get(a).getThisMonthAveUnits());%></td>
                                        </tr>
                                        <%
                                            }
                                        %>
                                    </tbody>
                                </table>
                            </div>
                        </div>

                        <div class="panel-body tab-pane fade" id="year">

                            <div class="demo-container">
                                <div id="placeholder2" class="demo-placeholder"></div>

                            </div>


                            <div class="table-responsive">
                                <table class="table display cell-border" cellspacing="0" id="year_table">
                                    <thead>
                                        <tr>
                                            <th rowspan="2">Rank</th>
                                            <th rowspan="2">Item Code</th>
                                            <th rowspan="2">Item Description</th>
                                            <th colspan="2">Total</th>
                                            <th colspan="2">Average</th>
                                        </tr>
                                        <tr>
                                            <th>Amount</th>
                                            <th>Units</th>
                                            <th>Amount</th>
                                            <th>Units</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            index = 0;
                                            ThisYearTrending = (ArrayList<Trending_Products>) session.getAttribute("ThisYearTrending");
                                            for (int a = 0; a < ThisYearTrending.size(); a++) {
                                                index = index + 1;
                                        %>
                                        <tr>
                                            <td><%out.print(index);%></td>
                                            <td><%out.print(ThisYearTrending.get(a).getItemCode());%></td>
                                            <td><%out.print(ThisYearTrending.get(a).getDescription());%></td>
                                            <td><%out.print(ThisYearTrending.get(a).getThisYearTotalAmount());%></td>
                                            <td><%out.print(ThisYearTrending.get(a).getThisYearTotalUnits());%></td>
                                            <td><%out.print(ThisYearTrending.get(a).getThisYearAveAmount());%></td>
                                            <td><%out.print(ThisYearTrending.get(a).getThisYearAveUnits());%></td>
                                        </tr>
                                        <%
                                            }
                                        %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="panel-body tab-pane fade" id="p3">

                            <div class="demo-container">
                                <div id="placeholder3" class="demo-placeholder"></div>

                            </div>


                            <div class="table-responsive">
                                <table class="table display cell-border" cellspacing="0" id="p3_table">
                                    <thead>
                                        <tr>
                                            <th rowspan="2">Rank</th>
                                            <th rowspan="2">Item Code</th>
                                            <th rowspan="2">Item Description</th>
                                            <th colspan="2">Total</th>
                                            <th colspan="2">Average</th>
                                        </tr>
                                        <tr>
                                            <th>Amount</th>
                                            <th>Units</th>
                                            <th>Amount</th>
                                            <th>Units</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            index = 0;
                                            for (int a = 0; a < P3Trending.size(); a++) {
                                                index = index + 1;
                                        %>
                                        <tr>
                                            <td><%out.print(index);%></td>
                                            <td><%out.print(P3Trending.get(a).getItemCode());%></td>
                                            <td><%out.print(P3Trending.get(a).getDescription());%></td>
                                            <td><%out.print(P3Trending.get(a).getP3TotalAmount());%></td>
                                            <td><%out.print(P3Trending.get(a).getP3TotalUnits());%></td>
                                            <td><%out.print(P3Trending.get(a).getP3AveAmount());%></td>
                                            <td><%out.print(P3Trending.get(a).getP3AveUnits());%></td>
                                        </tr>
                                        <%
                                            }
                                        %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="panel-body tab-pane fade" id="p6">

                            <div class="demo-container">
                                <div id="placeholder4" class="demo-placeholder"></div>

                            </div>

                            <div class="table-responsive">
                                <table class="table display cell-border" cellspacing="0" id="p6_table">
                                    <thead>
                                        <tr>
                                            <th rowspan="2">Rank</th>
                                            <th rowspan="2">Item Code</th>
                                            <th rowspan="2">Item Description</th>
                                            <th colspan="2">Total</th>
                                            <th colspan="2">Average</th>
                                        </tr>
                                        <tr>
                                            <th>Amount</th>
                                            <th>Units</th>
                                            <th>Amount</th>
                                            <th>Units</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            index = 0;
                                            P6Trending = (ArrayList<Trending_Products>) session.getAttribute("P6Trending");
                                            for (int a = 0; a < P6Trending.size(); a++) {
                                                index = index + 1;
                                        %>
                                        <tr>
                                            <td><%out.print(index);%></td>
                                            <td><%out.print(P6Trending.get(a).getItemCode());%></td>
                                            <td><%out.print(P6Trending.get(a).getDescription());%></td>
                                            <td><%out.print(P6Trending.get(a).getP6TotalAmount());%></td>
                                            <td><%out.print(P6Trending.get(a).getP6TotalUnits());%></td>
                                            <td><%out.print(P6Trending.get(a).getP6AveAmount());%></td>
                                            <td><%out.print(P6Trending.get(a).getP6AveUnits());%></td>
                                        </tr>
                                        <%
                                            }
                                        %>
                                    </tbody>
                                </table>
                            </div>
                        </div>

                        <div class="panel-body tab-pane fade" id="p9">

                            <div class="demo-container">
                                <div id="placeholder5" class="demo-placeholder"></div>

                            </div>

                            <div class="table-responsive">
                                <table class="table display cell-border" cellspacing="0" id="p9_table">
                                    <thead>
                                        <tr>
                                            <th rowspan="2">Rank</th>
                                            <th rowspan="2">Item Code</th>
                                            <th rowspan="2">Item Description</th>
                                            <th colspan="2">Total</th>
                                            <th colspan="2">Average</th>
                                        </tr>
                                        <tr>
                                            <th>Amount</th>
                                            <th>Units</th>
                                            <th>Amount</th>
                                            <th>Units</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            index = 0;
                                            P9Trending = (ArrayList<Trending_Products>) session.getAttribute("P9Trending");
                                            for (int a = 0; a < P9Trending.size(); a++) {
                                                index = index + 1;
                                        %>
                                        <tr>
                                            <td><%out.print(index);%></td>
                                            <td><%out.print(P9Trending.get(a).getItemCode());%></td>
                                            <td><%out.print(P9Trending.get(a).getDescription());%></td>
                                            <td><%out.print(P9Trending.get(a).getP9TotalAmount());%></td>
                                            <td><%out.print(P9Trending.get(a).getP9TotalUnits());%></td>
                                            <td><%out.print(P9Trending.get(a).getP9AveAmount());%></td>
                                            <td><%out.print(P9Trending.get(a).getP9AveUnits());%></td>
                                        </tr>
                                        <%
                                            }
                                        %>
                                    </tbody>
                                </table>
                            </div>
                        </div>




                        <div class="panel-body tab-pane fade" id="p12">

                            <div class="demo-container">
                                <div id="placeholder6" class="demo-placeholder"></div>

                            </div>

                            <div class="table-responsive">
                                <table class="table display" cellspacing="0" id="p12_table">
                                    <thead>
                                        <tr>
                                            <th rowspan="2">Rank</th>
                                            <th rowspan="2">Item Code</th>
                                            <th rowspan="2">Item Description</th>
                                            <th colspan="2">Total</th>
                                            <th colspan="2">Average</th>
                                        </tr>
                                        <tr>
                                            <th>Amount</th>
                                            <th>Units</th>
                                            <th>Amount</th>
                                            <th>Units</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            index = 0;
                                            P12Trending = (ArrayList<Trending_Products>) session.getAttribute("P12Trending");
                                            for (int a = 0; a < P12Trending.size(); a++) {
                                                index = index + 1;
                                        %>
                                        <tr>
                                            <td><%out.print(index);%></td>
                                            <td><%out.print(P12Trending.get(a).getItemCode());%></td>
                                            <td><%out.print(P12Trending.get(a).getDescription());%></td>
                                            <td><%out.print(P12Trending.get(a).getP12TotalAmount());%></td>
                                            <td><%out.print(P12Trending.get(a).getP12TotalUnits());%></td>
                                            <td><%out.print(P12Trending.get(a).getP12AveAmount());%></td>
                                            <td><%out.print(P12Trending.get(a).getP12AveUnits());%></td>
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




        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/jquery.dataTables.js"></script>
        <script type="text/javascript" src="js/dataTables.tableTools.js"></script>
        <script type="text/javascript" src="js/modal.js"></script>


        <script>
                            $(document).ready(function () {
//                $("#tabs").tabs({
//                    "activate": function (event, ui) {
//                        $($.fn.dataTable.tables(true)).DataTable().columns.adjust();
//                    }
//                });

                                $('#month_table').DataTable({
                                    stateSave: true
                                });
                                $('#year_table').DataTable({
                                    stateSave: true
                                });
                                $('#p3_table').DataTable({
                                    stateSave: true
                                });
                                $('#p6_table').DataTable({
                                    stateSave: true
                                });
                                $('#p9_table').DataTable({
                                    stateSave: true
                                });
                                $('#p12_table').DataTable({
                                    stateSave: true
                                });
                            });
        </script>

        <script type="text/javascript">
            function click() {
                $("#example-1").click();
                $("#example-2").click();
                $("#example-3").click();
                $("#example-4").click();
                $("#example-5").click();
                $("#example-6").click();

            }
        </script>

    </body>
</html>
