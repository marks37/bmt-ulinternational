<%-- 
    Document   : compute
    Created on : 11 14, 14, 10:18:48 PM
    Author     : Mark
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="js/jquery.js"></script>
    </head>
    <body>
        
<!--        <div class="row">
            <div>
                <input class="units" type="text" placeholder="Number of units"/>
            </div>
            <div>
                <input class="price" type="hidden" value='5' />
            </div>
            <div>
                <input class="total" type="text" placeholder="Total" disabled/>
            </div>
        </div>-->

        <div class="row">
            <div>
                <input class="units" type="text" placeholder="Number of units"/>
            </div>
            <div>
                <input class="price" type="text" placeholder="Unit price"/>
            </div>
            <div>
                <input class="total" type="text" placeholder="Total" disabled/>
            </div>
        </div>

        <script>
            function calculate(units, price, discount) {
                if (discount) {
                    if (discount < 0 || discount > 100) {
                        discount = 0;
                    }
                } else {
                    discount = 0;
                }
                return (units * price) * (1 - (discount / 100));
            }

            $('input').on('change', function () {
                var scope = $(this).closest('.row'),
                        units = $('.units', scope).val(),
                        price = $('.price', scope).val(),
                        total = $('.total', scope);
                if ($.isNumeric(units) !== '') {
                    total.val(calculate(units, price));
                } else {
                    total.val('');
                }
            });
        </script>
    </body>
</html>
