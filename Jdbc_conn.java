package javaclass;
import java.sql.*; 
import java.io.*;

class Jdbc_conn{  
public static void main(String args[]){  

try{ 
Class.forName("com.mysql.jdbc.Driver"); 
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/test?characterEncoding=latin1&useConfigs=maxPerformance","root","root");  


PreparedStatement ps=con.prepareStatement("insert into emp values(?,?,?)");  
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
  
con.setAutoCommit(false); 
do{  
System.out.println("enter id:");  
int id=Integer.parseInt(br.readLine());  
System.out.println("enter name:");  
String name=br.readLine();  
System.out.println("enter dept:");  
String dept=br.readLine();  
  
ps.setInt(1,id);  
ps.setString(2,name);  
ps.setString(3,dept);  
int i=ps.executeUpdate();  
System.out.println(i+" records affected");  

System.out.println("Do you want to continue: y/n");  
String s=br.readLine();  
if(s.startsWith("n")){  
break;  
}  
}while(true); 
System.out.println("commit/rollback");  
String answer=br.readLine();  
if(answer.equals("commit")){  
con.commit();  
}  
if(answer.equals("rollback")){  
con.rollback();  
}  


Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
//Statement stmt=con.createStatement();
stmt.execute("DROP PROCEDURE IF EXISTS `test`.`getName`"); 

String query = "CREATE PROCEDURE `test`.`getName` (IN EMP_ID INT, OUT EMP_NAME VARCHAR(30)) " +
"BEGIN "+
" SELECT name INTO EMP_NAME FROM emp WHERE id = EMP_ID; "+
"END";
stmt.execute(query);
System.out.println("Procedure Created......");

CallableStatement cstmt = null;
String SQL = "{call getName (?, ?)}";
cstmt = con.prepareCall (SQL);
cstmt.setInt(1,1);
cstmt.registerOutParameter(2, java.sql.Types.VARCHAR);
//cstmt.execute();
cstmt.executeUpdate();
String rn = cstmt.getString(2);

System.out.println("Retrieved Name = " + rn);

ResultSet rs=stmt.executeQuery("select * from emp");  

ResultSetMetaData rsmd=rs.getMetaData();  

System.out.println("Total columns: "+rsmd.getColumnCount());  
System.out.println("Column Name of 1st column: "+rsmd.getColumnName(1));  
System.out.println("Column Type Name of 1st column: "+rsmd.getColumnTypeName(1));  
System.out.println("Column Label of 1st column: "+rsmd.getColumnLabel(1));  
System.out.println("Table Name: "+rsmd.getTableName(1)); 

DatabaseMetaData dbmd=con.getMetaData();  

System.out.println("Driver Name: "+dbmd.getDriverName());  
System.out.println("Driver Version: "+dbmd.getDriverVersion());  
System.out.println("UserName: "+dbmd.getUserName());  
System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());  
System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());  

rs.absolute(1);  
rs.beforeFirst();

System.out.println("Inserting a new record...");
rs.moveToInsertRow();
rs.updateInt("id",5);
rs.updateString("name","Paul");
rs.updateString("dept","cse");
// Commit row
rs.insertRow();
rs.deleteRow();

while(rs.next())  
System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
con.close();  
}

catch(Exception e){ System.out.println(e);}  
}  

}  