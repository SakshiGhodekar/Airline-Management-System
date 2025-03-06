import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class login extends JFrame implements ActionListener
{
JTextField t1;
JPasswordField ps;
JLabel l1,l2;
JButton b1,b2,b3;
Connection c=null;
Statement s=null;
ResultSet rs=null;

login()
{
super("login page");
getContentPane().setBackground(Color.WHITE);
setLayout(null);
 l1=new JLabel("USERNAME:");
l1.setBounds(20,20,100,20);
add(l1);

 t1=new JTextField();
t1.setBounds(130,20,200,20);
add(t1);

l2=new JLabel("PASSWORD:");
l2.setBounds(20,60,100,20);
add(l2);

 ps=new JPasswordField();
ps.setBounds(130,60,200,20);
add(ps);

 b1=new JButton("RESET");
b1.setBounds(40,120,120,20);
b1.addActionListener(this);
add(b1);

 b2=new JButton("SUBMIT");
b2.setBounds(190,120,120,20);
b2.addActionListener(this);
add(b2);

b3=new JButton("CLOSE");
b3.setBounds(120,160,120,20);
b3.addActionListener(this);
add(b3);


setSize(400,250);
setLocation(600,250);
setVisible(true);
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
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
t1.setText("");
ps.setText("");
}
else if(ae.getSource()==b2)
{

try
{
//String username=t1.getText();
//String password=ps.getText();

//conn con1=new conn();
//String query="select * from login where username='"+username+"' and password='"+password+"'";
 //rs=s.executeQuery(query);
rs=s.executeQuery("select * from login where username='"+t1.getText()+"' and password='"+ps.getText()+"'");

if(rs.next())
{
new home();
setVisible(false);
}
else
{
JOptionPane.showMessageDialog(null,"invalid username or password");
setVisible(false);
}


}
catch(Exception e)
{
System.out.println(e);
}
}
else if(ae.getSource()==b3)
{
setVisible(false);
}
}
public static void main(String args[])
{
new login();
}
}