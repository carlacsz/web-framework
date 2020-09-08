<%@ page import = "java.io.*,java.util.*" %>

<html>
   <head>
      <title>Home</title>
   </head>

   <body>
      <center>
         <h1>Home Page</h1>
         <h2>HTTP Header Request Example</h2>
         <table width = "100%" border = "1" align = "center">
            <tr bgcolor = "#949494">
               <th>Param Name</th>
               <th>Param Value(s)</th>
            </tr>
            <%
               Enumeration paramNames = request.getParameterNames();
               while(paramNames.hasMoreElements()) {
                  String paramName = (String)paramNames.nextElement();
                  out.print("<tr><td>" + paramName + "</td>\n");
                  String[] paramValues = request.getParameterValues(paramName);
                  String paramValue;
                  if (paramValues == null || paramValues.length == 0) {
                    paramValue = "";
                  } else if (paramValues.length == 1) {
                    paramValue = paramValues[0];
                  } else {
                    paramValue = String.join(",", paramValues);
                  }
                  out.println("<td> " + paramValue + "</td></tr>\n");
               }
            %>
         </table>
      </center>

   </body>
</html>