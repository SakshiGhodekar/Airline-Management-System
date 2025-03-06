import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
import net.port.sql.DbUtils;
public class flightinfo extends JFrame 
{

JTable tb;

public flightinfo()
{

Connection con=null;
Statement st=null;
JTable table=new JTable();
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 con=DriverManager.getConnection("jdbc:odbc:ams");
 st=con.createStatement();
ResultSet rs=st.executeQuery("select * from flight");

}
catch(Exception e)
{
System.out.println(e);
}
 JScrollPane jsp=new JScrollPane(table);
jsp.setBounds(0,0,);
add(jsp);


setSize(800,500);
setLocation(400,200);
setVisible(true);
}
public static void main(String args[])
{
new flightinfo();
}
}