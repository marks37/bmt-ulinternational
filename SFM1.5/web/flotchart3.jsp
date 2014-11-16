<%-- 
    Document   : flotchart3
    Created on : 11 12, 14, 11:12:15 AM
    Author     : Mark
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Flot - Customised Bar Chart</title>

        <style type="text/css">
            body { font: 13px/1.3 Verdana, Arial, sans-serif; }
            #placeholder { width: 80%; height: 500px; position: relative; }
            .legend table, .legend > div { padding: 2px; }
            #bar_tooltip { font-size: 13px; position: absolute; display: none; padding: 2px; border: 2px solid; -webkit-border-radius: 5px; border-radius: 5px; background-color: #FFF; opacity: 0.8; }
        </style>
        <script src="js/jquery-1.11.1.min.js"></script>
        <!--<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/flot/0.8.2/excanvas.min.js"></script>-->
        <!--[if lte IE 8]><script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/flot/0.8.2/excanvas.min.js"></script><![endif]-->
        <!--<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>-->
        <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/flot/0.8.2/jquery.flot.min.js"></script>
        <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/flot/0.8.2/jquery.flot.categories.min.js"></script>
        <script type="text/javascript" src="http://www.pikemere.co.uk/blog/js/jquery.flot.orderBars.js"></script>

        <script type="text/javascript">

            $(document).ready(function () {
                var data = [
                    {data: [["Jan", 5], ["Feb", 4], ["Mar", 3], ["Apr", 6], ["May", 5], ["Jun", 5], ["Jul", 25], ["Aug", 35],["Sep", 45], ["Oct", 45],["Nov", 20],["Dec", 20]]},
                    {data: [["Jan", 6], ["Feb", 8], ["Mar", 9], ["Apr", 2], ["May", 4], ["Jun", 3], ["Jul", 15], ["Aug", 45],["Sep", 45],["Oct", 40],["Nov", 40],["Dec", 20]]}
                ];

                $.plot("#placeholder", data, {
                    series: {
                        bars: {
                            show: true,
                            barWidth: 0.2,
                            lineWidth: 0,
                            order: 1, // Include this line to ensure the bars will appear side by side.
                            fillColor: {
                                colors: [{
                                        opacity: 1
                                    }, {
                                        opacity: 0.7
                                    }]
                            }
                        }
                    },
                    xaxis: {
                        mode: "categories", // Include this line so the bars are grouped.
                        tickLength: 0
                    },
                    grid: {
                        borderWidth: 0
                    },
                    colors: ["#058DC7", "#BE0E24"]
                });
            });
        </script>
    </head>

    <body>
        <div id="placeholder"></div>
    </body>
</html>
