package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class flotchart3_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <meta charset=\"UTF-8\" />\n");
      out.write("        <title>Flot - Customised Bar Chart</title>\n");
      out.write("\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            body { font: 13px/1.3 Verdana, Arial, sans-serif; }\n");
      out.write("            #placeholder { width: 50%; height: 700px; position: relative; }\n");
      out.write("            .legend table, .legend > div { padding: 2px; }\n");
      out.write("            #bar_tooltip { font-size: 13px; position: absolute; display: none; padding: 2px; border: 2px solid; -webkit-border-radius: 5px; border-radius: 5px; background-color: #FFF; opacity: 0.8; }\n");
      out.write("        </style>\n");
      out.write("        <script src=\"js/jquery-1.11.1.min.js\"></script>\n");
      out.write("        <!--<script type=\"text/javascript\" src=\"http://cdnjs.cloudflare.com/ajax/libs/flot/0.8.2/excanvas.min.js\"></script>-->\n");
      out.write("        <!--[if lte IE 8]><script type=\"text/javascript\" src=\"http://cdnjs.cloudflare.com/ajax/libs/flot/0.8.2/excanvas.min.js\"></script><![endif]-->\n");
      out.write("        <!--<script type=\"text/javascript\" src=\"http://cdnjs.cloudflare.com/ajax/libs/jquery/1.11.0/jquery.min.js\"></script>-->\n");
      out.write("        <script type=\"text/javascript\" src=\"http://cdnjs.cloudflare.com/ajax/libs/flot/0.8.2/jquery.flot.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"http://cdnjs.cloudflare.com/ajax/libs/flot/0.8.2/jquery.flot.categories.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"http://www.pikemere.co.uk/blog/js/jquery.flot.orderBars.js\"></script>\n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                var data = [\n");
      out.write("                    {data: [[\"Jan\", 5], [\"Feb\", 4], [\"Mar\", 3], [\"Apr\", 6], [\"May\", 5], [\"Jun\", 5], [\"Jul\", 25]]},\n");
      out.write("                    {data: [[\"Jan\", 6], [\"Feb\", 8], [\"Mar\", 9], [\"Apr\", 2], [\"May\", 4], [\"Jun\", 3], [\"Jul\", 15]]}\n");
      out.write("                ];\n");
      out.write("\n");
      out.write("                $.plot(\"#placeholder\", data, {\n");
      out.write("                    series: {\n");
      out.write("                        bars: {\n");
      out.write("                            show: true,\n");
      out.write("                            barWidth: 0.2,\n");
      out.write("                            lineWidth: 0,\n");
      out.write("                            order: 1, // Include this line to ensure the bars will appear side by side.\n");
      out.write("                            fillColor: {\n");
      out.write("                                colors: [{\n");
      out.write("                                        opacity: 1\n");
      out.write("                                    }, {\n");
      out.write("                                        opacity: 0.7\n");
      out.write("                                    }]\n");
      out.write("                            }\n");
      out.write("                        }\n");
      out.write("                    },\n");
      out.write("                    xaxis: {\n");
      out.write("                        mode: \"categories\", // Include this line so the bars are grouped.\n");
      out.write("                        tickLength: 0\n");
      out.write("                    },\n");
      out.write("                    grid: {\n");
      out.write("                        borderWidth: 0\n");
      out.write("                    },\n");
      out.write("                    colors: [\"#058DC7\", \"#BE0E24\"]\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div id=\"placeholder\"></div>\n");
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
