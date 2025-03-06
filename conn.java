package airlinemanagementsystem;

import java.sql.*;
 class conn
{
Connection c;
Statement s;

public conn()
{
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 c=DriverManager.getConnection("jdbc:odbc:ams");
 s=c.createStatement();
}
catch(Exception e)
{
System.out.println(e);
}
}
}