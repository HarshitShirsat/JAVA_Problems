Login.html
++++++++++

<html>
	<head>
		<title>login form</title>
	</head>
	
	<body>
		<form name="Form1" method="post" action="LoginHandler">
			Name:<input type="text" name=“nam" >
			Password:<input type=“password" name="pass" >
			<input type="submit" value="login" >
		</form>
	</body>
</html>

LoginHandler.java
+++++++++++++++++

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginHandler extends HttpServlet
{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		String uname = req.getParameter("nam");
		String upwd = req.getParameter("pass");
		String n="NMAMIT";
		String p="NMAMIT12345";

		out.println("<html>");
		out.println("<body>");
		
		if (uname.equals(n) && upwd.equals(p))
		{
			out.println("<h1>Hello!!Welcome to NMAMIT!!!!!!!</h1>");
		}
		else
		{
			out.println("<h1>Your username or password are invalid.</h1>");
			out.println("You may want to <A HREF=\"/login.html\">try again</A>");
		}
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}

web.xml
+++++++

<servlet>
	<servlet-name>Program</servlet-name>
	<servlet-class>LoginHandler</servlet-class>
/<servlet>
<servlet-mapping>
	<servlet-name>Program</servlet-name>
	<url-pattern>LoginHandler</url-pattern>
</servlet-mapping>