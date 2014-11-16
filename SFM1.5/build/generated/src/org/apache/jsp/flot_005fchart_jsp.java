package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class flot_005fchart_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />\n");
      out.write("        <title>Flot Pie Chart</title>\n");
      out.write("\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            body { font-family: Verdana, Arial, sans-serif; font-size: 12px; }\n");
      out.write("            #placeholder { width: 250px; height: 150px; }\n");
      out.write("            .legend table, .legend > div { height: 82px !important; opacity: 1 !important; left: 170px; top: 10px; width: 116px !important; }\n");
      out.write("            .legend table { border: 1px solid #555; padding: 5px; }\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("        <!--[if lte IE 8]><script type=\"text/javascript\" language=\"javascript\" src=\"excanvas.min.js\"></script><![endif]-->\n");
      out.write("        <script type=\"text/javascript\" language=\"javascript\" src=\"js/jquery.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" language=\"javascript\" src=\"js/jquery.flot.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" language=\"javascript\" src=\"js/jquery.flot.pie.js\"></script>\n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            var data = [\n");
      out.write("                {label: \"IE\", data: 19.5, color: \"#4572A7\"},\n");
      out.write("                {label: \"Safari\", data: 4.5, color: \"#80699B\"},\n");
      out.write("                {label: \"Firefox\", data: 36.6, color: \"#AA4643\"},\n");
      out.write("                {label: \"Opera\", data: 2.3, color: \"#3D96AE\"},\n");
      out.write("                {label: \"Chrome\", data: 36.3, color: \"#89A54E\"},\n");
      out.write("                {label: \"Other\", data: 0.8, color: \"#3D96AE\"}\n");
      out.write("            ];\n");
      out.write("\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                $.plot($(\"#placeholder\"), data, {\n");
      out.write("                    series: {\n");
      out.write("                        pie: {\n");
      out.write("                            show: true\n");
      out.write("                        }\n");
      out.write("                    },\n");
      out.write("                    legend: {\n");
      out.write("                        labelBoxBorderColor: \"none\"\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div id=\"placeholder\"></div>\n");
      out.write("    </body>\n");
      out.write("</html>");
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
