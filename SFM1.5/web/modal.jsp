<%-- 
    Document   : modal
    Created on : 11 11, 14, 10:58:02 AM
    Author     : Mark
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"/>
        
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
  Launch demo modal
</button>
        
        <!-- Modal -->
        <div class="modal fade" id="myModal" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog" style="width: 300px; height: 10px;">
                <div class="modal-content">
                    <div class="modal-body">
                        <span class="glyphicon glyphicon-question-sign"></span>
                        Do you want to proceed with the Call?
                        <div class="modal-footer">
                            <a href="customerengagement_forecast_page.jsp"><button type="button" class="btn btn-primary btn-sm">&nbsp Yes &nbsp</button></a>
                            <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">No</button>
                        </div>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->

        <!-- End of Modal -->	
        <script src="js/jquery-1.11.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/docs.min.js"></script>
    </body>
</html>
