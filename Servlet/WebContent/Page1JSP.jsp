<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Welcome to JSP Home Page
<%
try{ 
Class.forName("com.mysql.jdbc.Driver"); 
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/test?characterEncoding=latin1&useConfigs=maxPerformance","root","root");
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("select * from emp");  
while(rs.next()) {
%>
</br>
<%
out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)); 
}
con.close();  
}
catch (Exception e) {
	System.out.println(e);
}
%>

</body>
</html>