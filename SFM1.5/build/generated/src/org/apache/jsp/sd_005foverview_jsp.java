package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class sd_005foverview_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Start of Day | Sales Force Management</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\" type=\"text/css\"/>\n");
      out.write("        <script src=\"js/jquery-1.11.1.min.js\"></script>\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/navbar.css\" type=\"text/css\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/overview.css\" type=\"text/css\"/>\n");
      out.write("        <link rel=\"shortcut icon\" href=\"images/unilab_icon.ico\" type=\"image/x-icon\">\n");
      out.write("        <link rel=\"icon\" href=\"images/unilab_icon.ico\" type=\"image/x-icon\">\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script src=\"js/jquery.knob.min.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            $(function ($) {\n");
      out.write("\n");
      out.write("                $(\".knob\").knob({\n");
      out.write("                    format: function (value) {\n");
      out.write("                        return value + '%';\n");
      out.write("                    },\n");
      out.write("                    change: function (value) {\n");
      out.write("                        //console.log(\"change : \" + value);\n");
      out.write("                    },\n");
      out.write("                    release: function (value) {\n");
      out.write("                        //console.log(this.$.attr('value'));\n");
      out.write("                        console.log(\"release : \" + value);\n");
      out.write("                    },\n");
      out.write("                    cancel: function () {\n");
      out.write("                        console.log(\"cancel : \", this);\n");
      out.write("                    },\n");
      out.write("                    /*format : function (value) {\n");
      out.write("                     return value + '%';\n");
      out.write("                     },*/\n");
      out.write("                    draw: function () {\n");
      out.write("\n");
      out.write("                        // \"tron\" case\n");
      out.write("                        if (this.$.data('skin') == 'tron') {\n");
      out.write("\n");
      out.write("                            this.cursorExt = 0.3;\n");
      out.write("\n");
      out.write("                            var a = this.arc(this.cv)  // Arc\n");
      out.write("                                    , pa                   // Previous arc\n");
      out.write("                                    , r = 1;\n");
      out.write("\n");
      out.write("                            this.g.lineWidth = this.lineWidth;\n");
      out.write("\n");
      out.write("                            if (this.o.displayPrevious) {\n");
      out.write("                                pa = this.arc(this.v);\n");
      out.write("                                this.g.beginPath();\n");
      out.write("                                this.g.strokeStyle = this.pColor;\n");
      out.write("                                this.g.arc(this.xy, this.xy, this.radius - this.lineWidth, pa.s, pa.e, pa.d);\n");
      out.write("                                this.g.stroke();\n");
      out.write("                            }\n");
      out.write("\n");
      out.write("                            this.g.beginPath();\n");
      out.write("                            this.g.strokeStyle = r ? this.o.fgColor : this.fgColor;\n");
      out.write("                            this.g.arc(this.xy, this.xy, this.radius - this.lineWidth, a.s, a.e, a.d);\n");
      out.write("                            this.g.stroke();\n");
      out.write("\n");
      out.write("                            this.g.lineWidth = 2;\n");
      out.write("                            this.g.beginPath();\n");
      out.write("                            this.g.strokeStyle = this.o.fgColor;\n");
      out.write("                            this.g.arc(this.xy, this.xy, this.radius - this.lineWidth + 1 + this.lineWidth * 2 / 3, 0, 2 * Math.PI, false);\n");
      out.write("                            this.g.stroke();\n");
      out.write("\n");
      out.write("                            return false;\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("\n");
      out.write("                // Example of infinite knob, iPod click wheel\n");
      out.write("                var v, up = 0, down = 0, i = 0\n");
      out.write("                        , $idir = $(\"div.idir\")\n");
      out.write("                        , $ival = $(\"div.ival\")\n");
      out.write("                        , incr = function () {\n");
      out.write("                            i++;\n");
      out.write("                            $idir.show().html(\"+\").fadeOut();\n");
      out.write("                            $ival.html(i);\n");
      out.write("                        }\n");
      out.write("                , decr = function () {\n");
      out.write("                    i--;\n");
      out.write("                    $idir.show().html(\"-\").fadeOut();\n");
      out.write("                    $ival.html(i);\n");
      out.write("                };\n");
      out.write("                $(\"input.infinite\").knob(\n");
      out.write("                        {\n");
      out.write("                            min: 0\n");
      out.write("                            , max: 20\n");
      out.write("                            , stopper: false\n");
      out.write("                            , change: function () {\n");
      out.write("                                if (v > this.cv) {\n");
      out.write("                                    if (up) {\n");
      out.write("                                        decr();\n");
      out.write("                                        up = 0;\n");
      out.write("                                    } else {\n");
      out.write("                                        up = 1;\n");
      out.write("                                        down = 0;\n");
      out.write("                                    }\n");
      out.write("                                } else {\n");
      out.write("                                    if (v < this.cv) {\n");
      out.write("                                        if (down) {\n");
      out.write("                                            incr();\n");
      out.write("                                            down = 0;\n");
      out.write("                                        } else {\n");
      out.write("                                            down = 1;\n");
      out.write("                                            up = 0;\n");
      out.write("                                        }\n");
      out.write("                                    }\n");
      out.write("                                }\n");
      out.write("                                v = this.cv;\n");
      out.write("                            }\n");
      out.write("                        });\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <!-- Fixed navbar -->\n");
      out.write("        <div class=\"navbar navbar-inverse navbar-fixed-top shadow\" id=\"main_navbar\" role=\"navigation\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                    <a class=\"navbar-brand\" href=\"#\">Sales Force Management</a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"navbar-collapse collapse\">\n");
      out.write("                    <ul class=\"nav navbar-nav\">\n");
      out.write("                        <ul class=\"nav navbar-nav\" style=\"display: block;\">\n");
      out.write("                            <li class=\"active\"><a href=\"#\">Home</a></li>\n");
      out.write("                            <li><a href=\"accounts_page.jsp\">Accounts</a></li>\n");
      out.write("                            <li><a href=\"sales_analysis.jsp\">Sales</a></li>\n");
      out.write("                            <li><a href=\"products_page.jsp\">Products</a></li>\n");
      out.write("                            <li><a href=\"calls_page.jsp\">Calls</a></li>\n");
      out.write("\n");
      out.write("                        </ul>\n");
      out.write("                    </ul>\n");
      out.write("                    <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                        <li class=\"dropdown \">\n");
      out.write("                            <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">\n");
      out.write("                                <span class=\"glyphicon glyphicon-user\"></span>\n");
      out.write("                                ");

                                    String fullname = (String) session.getAttribute("SalesRepName");
                                    out.print(fullname);
                                
      out.write("\n");
      out.write("                            </a>\n");
      out.write("                            <ul class=\"dropdown-menu\">\n");
      out.write("                                <li><a href=\"profile.jsp\"><span class=\"glyphicon glyphicon-user\"></span> &nbsp Profile</a></li>\n");
      out.write("                                <li><a href=\"login.jsp\"><span class=\"glyphicon glyphicon-share-alt\"></span> &nbsp Log out</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </div><!--/.nav-collapse -->\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"navbar navbar-default navbar-fixed-top\" id=\"homepage_navbar\" role=\"navigation\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("\n");
      out.write("                <div class=\"navbar-collapse collapse\" id=\"inner_wrapper\">\n");
      out.write("                    <ul class=\"nav navbar-nav\">\n");
      out.write("                        <li class=\"active\"><a href=\"#\">Overview</a></li>\n");
      out.write("                        <li><a href=\"sd_objectives.jsp\">Objectives</a></li>\n");
      out.write("                        <li><a href=\"sd_sales.jsp\">Sales</a></li>\n");
      out.write("                        <li><a href=\"sd_calls.jsp\">Calls</a></li>\n");
      out.write("                    </ul>\n");
      out.write("\n");
      out.write("                </div><!--/.nav-collapse -->\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            <div class=\"sidebar_buttons\">\n");
      out.write("                <a href=\"#\"><img class=\"img-responsive\" src=\"images/Start_of_Day_Logo.png\"></a>\n");
      out.write("                <a href=\"ce_review_plans.jsp\"><img class=\"img-responsive\" src=\"images/Customer_Engagement_Logo.png\"></a>\n");
      out.write("                <a href=\"ed_overview.jsp\"><img class=\"img-responsive\" src=\"images/End_of_Day_Logo.png\"></a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"container\" style=\"margin-top: 120px\">\n");
      out.write("            <div class=\"header\">\n");
      out.write("                <h3><small>Start of Day</small></h3>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"container\" id=\"body\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("\n");
      out.write("                <div class=\"col-md-6\">\n");
      out.write("                    <div class=\"panel panel-default\" onclick=\"location.href = 'sd_objectives.jsp';\" style=\"cursor: pointer;\">\n");
      out.write("                        <div class=\"panel-body\">\n");
      out.write("                            <div id=\"logo\">\n");
      out.write("                                <a><img class=\"img-responsive\" src=\"images/objectives_logo.png\"></a>\n");
      out.write("                            </div>\n");
      out.write("                            <div id=\"text-title\">\n");
      out.write("                                <h4>Today's Objectives</h4>\n");
      out.write("                            </div>\n");
      out.write("                            <div id=\"text-body\">\n");
      out.write("                                ");

                                    int obj_count = (int) session.getAttribute("ObjectivesCount");
                                
      out.write("\n");
      out.write("                                <h5 style=\"margin-top: 20px\">You have ");
      out.print(obj_count);
      out.write(" objectives</h5>\n");
      out.write("                                <!--<h5 style=\"margin-top: 2px\">0 objectives</h5>-->\n");
      out.write("                                <!--<h3><small>You have 0 objectives</small></h3>-->\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"panel-footer\">View Details</div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"col-md-6\">\n");
      out.write("                    <div class=\"panel panel-default\">\n");
      out.write("                        <div class=\"panel-body\">\n");
      out.write("                            <div id=\"logo\">\n");
      out.write("                                <a><img class=\"img-responsive\" src=\"images/products_logo.png\"></a>\n");
      out.write("                            </div>\n");
      out.write("                            <div id=\"text-title\">\n");
      out.write("                                <h4>Product Updates</h4>\n");
      out.write("                            </div>\n");
      out.write("                            <div id=\"text-body\">\n");
      out.write("                                <h5 style=\"margin-top: 10px\">There are no product </h5>\n");
      out.write("                                <h5 style=\"margin-top: 2px\">updates at the moment</h5>\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"panel-footer\">View Details</div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-6\">\n");
      out.write("                    <div class=\"panel panel-default\" onclick=\"location.href = 'sd_sales.jsp';\" style=\"cursor: pointer;\">\n");
      out.write("                        <div class=\"panel-body\">\n");
      out.write("                            <div class=\"demo\" id=\"logo\">\n");
      out.write("                                ");

                                    long SalesPerformance = (long) session.getAttribute("SalesPerformance");
                                
      out.write("\n");
      out.write("                                <input data-width=\"100%\" class=\"knob\" data-fgColor=\"#46b8da\" style=\"color: #46b8da\" data-thickness=\".4\" readonly value=\"");
      out.print(SalesPerformance);
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("                            <div id=\"text-title\">\n");
      out.write("                                <h4>Sales Performance</h4>\n");
      out.write("                            </div>\n");
      out.write("                            <div id=\"text-body\">\n");
      out.write("                                ");

                                    String date = (String) session.getAttribute("CurrentDate");
                                    double MTDSales = (double) session.getAttribute("MTDSales");
                                    double MonthTarget = (double) session.getAttribute("MonthTarget");
                                
      out.write("\n");
      out.write("                                <h5 style=\"margin-top: 10px\">As of ");
      out.print(date);
      out.write("</h5>\n");
      out.write("                                <h5 style=\"margin-top: 2px\">");
      out.print(MTDSales);
      out.write('/');
      out.print(MonthTarget);
      out.write(" Sales</h5>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"panel-footer\">View Details</div>\n");
      out.write("                    </div>    \n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-6\">\n");
      out.write("                    <div class=\"panel panel-default\" onclick=\"location.href = 'sd_calls.jsp';\" style=\"cursor: pointer;\">\n");
      out.write("                        <div class=\"panel-body\">\n");
      out.write("                            <div class=\"demo\" id=\"logo\">\n");
      out.write("                                ");

                                    int CallPerformance = (int) session.getAttribute("CallPerformance");
                                
      out.write("\n");
      out.write("                                <input data-width=\"100%\" class=\"knob\" data-fgColor=\"#66CC66\" style=\"color: #46b8da\" data-thickness=\".4\" readonly value=\"");
      out.print(CallPerformance);
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("                            <div id=\"text-title\">\n");
      out.write("                                <h4>Call Performance</h4>\n");
      out.write("                            </div>\n");
      out.write("                            <div id=\"text-body\">\n");
      out.write("                                ");

                                    int CoveredCalls = (int) session.getAttribute("CoveredCalls");
                                    int TotalCalls = (int) session.getAttribute("TotalCalls");
                                
      out.write("\n");
      out.write("                                <h5 style=\"margin-top: 10px\">As of ");
      out.print(date);
      out.write("</h5>\n");
      out.write("                                <h5 style=\"margin-top: 2px\">");
      out.print(CoveredCalls);
      out.write('/');
      out.print(TotalCalls);
      out.write(" Calls</h5>\n");
      out.write("                                <!--<h5>2000 / 10000 </h5>-->\n");
      out.write("                                <!--<h3><small>2000 / 10000 Sales achieved</small></h3>-->\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"panel-footer\">View Details</div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script src=\"js/jquery-1.11.1.min.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"js/docs.min.js\"></script>\n");
      out.write("\n");
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
