<%-- 
    Document   : flot_chart
    Created on : 11 7, 14, 5:25:05 AM
    Author     : Mark
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <title>Flot Pie Chart</title>

        <style type="text/css">
            body { font-family: Verdana, Arial, sans-serif; font-size: 12px; }
            #placeholder { width: 250px; height: 150px; }
            .legend table, .legend > div { height: 82px !important; opacity: 1 !important; left: 170px; top: 10px; width: 116px !important; }
            .legend table { border: 1px solid #555; padding: 5px; }
        </style>

        <!--[if lte IE 8]><script type="text/javascript" language="javascript" src="excanvas.min.js"></script><![endif]-->
        <script type="text/javascript" language="javascript" src="js/jquery.js"></script>
        <script type="text/javascript" language="javascript" src="js/jquery.flot.js"></script>
        <script type="text/javascript" language="javascript" src="js/jquery.flot.pie.js"></script>

        <script type="text/javascript">
            var data = [
                {label: "IE", data: 19.5, color: "#4572A7"},
                {label: "Safari", data: 4.5, color: "#80699B"},
                {label: "Firefox", data: 36.6, color: "#AA4643"},
                {label: "Opera", data: 2.3, color: "#3D96AE"},
                {label: "Chrome", data: 36.3, color: "#89A54E"},
                {label: "Other", data: 0.8, color: "#3D96AE"}
            ];

            $(document).ready(function () {
                $.plot($("#placeholder"), data, {
                    series: {
                        pie: {
                            show: true
                        }
                    },
                    legend: {
                        labelBoxBorderColor: "none"
                    }
                });
            });
        </script>
    </head>

    <body>
        <div id="placeholder"></div>
    </body>
</html>