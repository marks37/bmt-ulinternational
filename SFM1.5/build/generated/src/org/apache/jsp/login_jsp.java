package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta name=\"author\" content=\"\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/login.css\" type=\"text/css\"/>\n");
      out.write("        <link rel=\"shortcut icon\" href=\"images/unilab_icon.ico\" type=\"image/x-icon\">\n");
      out.write("        <link rel=\"icon\" href=\"images/unilab_icon.ico\" type=\"image/x-icon\">\n");
      out.write("\n");
      out.write("        <title>Login | Sales Force Management</title>\n");
      out.write("\n");
      out.write("        <!-- Bootstrap core CSS -->\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- Custom styles for this template -->\n");
      out.write("        <link href=\"css/signin.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div id=\"container\">\n");
      out.write("\n");
      out.write("            <div id=\"logo\" >\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div id=\"login\">\n");
      out.write("                <form class=\"form-signin\" role=\"form\" action=\"login\" method=\"post\">\n");
      out.write("                    <div id=\"username\">\n");
      out.write("                        Username\n");
      out.write("                        <br>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" name=\"Username\" required autofocus>\n");
      out.write("                    </div>\n");
      out.write("                    <div id=\"password\">\n");
      out.write("                        Password\n");
      out.write("                        <br>\n");
      out.write("                        <input type=\"password\" class=\"form-control\"  name=\"Password\" required>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div id=\"container2\">\n");
      out.write("                        <div id=\"checkbox\">\n");
      out.write("                            <label class=\"checkbox\">\n");
      out.write("                                <input type=\"checkbox\" value=\"remember-me\"> Remember me\n");
      out.write("                            </label>\n");
      out.write("                        </div>\n");
      out.write("                        <div id=\"login_button\">\n");
      out.write("                            <input type=\"submit\" id=\"submitButton\" value=\"\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div> <!-- /container -->\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- Bootstrap core JavaScript\n");
      out.write("        ================================================== -->\n");
      out.write("        <!-- Placed at the end of the document so the pages load faster -->\n");
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
