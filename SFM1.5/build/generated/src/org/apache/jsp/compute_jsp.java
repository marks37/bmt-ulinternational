package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class compute_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/jquery.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("<!--        <div class=\"row\">\n");
      out.write("            <div>\n");
      out.write("                <input class=\"units\" type=\"text\" placeholder=\"Number of units\"/>\n");
      out.write("            </div>\n");
      out.write("            <div>\n");
      out.write("                <input class=\"price\" type=\"hidden\" value='5' />\n");
      out.write("            </div>\n");
      out.write("            <div>\n");
      out.write("                <input class=\"total\" type=\"text\" placeholder=\"Total\" disabled/>\n");
      out.write("            </div>\n");
      out.write("        </div>-->\n");
      out.write("\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div>\n");
      out.write("                <input class=\"units\" type=\"text\" placeholder=\"Number of units\"/>\n");
      out.write("            </div>\n");
      out.write("            <div>\n");
      out.write("                <input class=\"price\" type=\"text\" placeholder=\"Unit price\"/>\n");
      out.write("            </div>\n");
      out.write("            <div>\n");
      out.write("                <input class=\"total\" type=\"text\" placeholder=\"Total\" disabled/>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            function calculate(units, price, discount) {\n");
      out.write("                if (discount) {\n");
      out.write("                    if (discount < 0 || discount > 100) {\n");
      out.write("                        discount = 0;\n");
      out.write("                    }\n");
      out.write("                } else {\n");
      out.write("                    discount = 0;\n");
      out.write("                }\n");
      out.write("                return (units * price) * (1 - (discount / 100));\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            $('input').on('change', function () {\n");
      out.write("                var scope = $(this).closest('.row'),\n");
      out.write("                        units = $('.units', scope).val(),\n");
      out.write("                        price = $('.price', scope).val(),\n");
      out.write("                        discount = $('.rate', scope).val(),\n");
      out.write("                        total = $('.total', scope);\n");
      out.write("                if ($.isNumeric(units) && $.isNumeric(price) && ($.isNumeric(discount) || discount === '')) {\n");
      out.write("                    total.val(calculate(units, price, discount));\n");
      out.write("                } else {\n");
      out.write("                    total.val('');\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
