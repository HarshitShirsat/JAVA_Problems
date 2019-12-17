main.html
+++++++++

<html>
    <title>Sample Example </title>
    <body>
        <h1> <center> Example of JSP </center> </h1>
        <b>Arithmetic Calculator</b>
        <hr>
        <form method="post" action="main.jsp">
            <font size=5 face="Times New Roman">
                <input type="radio" name="a1" value="add" checked>Addition</input><br>
                <input type="radio" name="a1" value="mul" >Multiplication</input><br>
                <input type="radio" name="a1" value="div" >Division</input><br>
            </font>
            <hr>
            <br><br>
            Enter first Value <input type="text" name="t1" value=""><br><br>
            Enter second Value <input type="text" name="t2" value=""><br><br>
            <input type="submit" name="result">
        </form>
    </body>
</html>

main.jsp
++++++++

<%@ page language="java"%>
<%@ page import="java.lang.*"%>
<html>
	<body>
		<H1><center>Result for <%=request.getParameter("a1")%></center></H1>
		<%
			int i=Integer.parseInt(request.getParameter("t1"));
			int j=Integer.parseInt(request.getParameter("t2"));
			int k=0;
			String str=request.getParameter("a1");
			if(str.equals("add"))
			k=i+j;
			if(str.equals("mul"))
			k=i*j;
			if(str.equals("div"))
			k=i/j;
		%>
		Result is <%=k%>
	</body>
</html>