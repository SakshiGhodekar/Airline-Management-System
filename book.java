import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class book extends JFrame implements ActionListener
{
JTextField tfc,tfn,tsc,tdn,ttm;
//JPasswordField ps;
JLabel fc,fn,sc,dn,tm,l1;
JButton py;
Connection c=null;
Statement s=null;
ResultSet rs=null;

book()
{
super("booking page");
getContentPane().setBackground(Color.WHITE);
setLayout(null);
 l1=new JLabel("FLIGHT BOOKING");
l1.setBounds(220,20,500,35);
l1.setFont(new Font("Tahoma",Font.PLAIN,32));
l1.setForeground(Color.BLUE);
add(l1);

 fc=new JLabel("Flight code:");
fc.setBounds(60,80,150,25);
fc.setFont(new Font("Tahoma",Font.PLAIN,16));
add(fc);

 tfc=new JTextField();
tfc.setBounds(220,80,150,25);
add(tfc);

fn=new JLabel("Flight Name:");
fn.setBounds(60,130,150,25);
fn.setFont(new Font("Tahoma",Font.PLAIN,16));
add(fn);

 tfn=new JTextField();
tfn.setBounds(220,130,150,25);
add(tfn);

sc=new JLabel("Source:");
sc.setBounds(60,180,150,25);
sc.setFont(new Font("Tahoma",Font.PLAIN,16));
add(sc);

 tsc=new JTextField();
tsc.setBounds(220,180,150,25);
add(tsc);

 dn=new JLabel("Destination:");
dn.setBounds(60,230,150,25);
dn.setFont(new Font("Tahoma",Font.PLAIN,16));
add(dn);

 tdn=new JTextField();
tdn.setBounds(220,230,150,25);
add(tdn);

 tm=new JLabel("Time:");
tm.setBounds(60,280,150,25);
tm.setFont(new Font("Tahoma",Font.PLAIN,16));
add(tm);

ttm=new JTextField();
ttm.setBounds(220,230,150,25);
add(ttm);


 py=new JButton("Next");
py.setBackground(Color.BLACK);
py.setForeground(Color.WHITE);
py.setBounds(220,380,150,30);
add(py);
py.addActionListener(this);


setSize(900,600);
setLocation(300,150);
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
 if(ae.getSource()==py)
{

try
{
//String username=t1.getText();
//String password=ps.getText();

//conn con1=new conn();
//String query="select * from flight where FlightCode='"+F_code+"' and  FlightName='"+F_code+"'";
 //rs=s.executeQuery(query);
rs=s.executeQuery("select * from flight where F_code='"+tfc.getText()+"' and F_name='"+tfn.getText()+"' and Source='"+tsc.getText()+"' and Destination='"+tdn.getText()+"'");

if(rs.next())
{
new customer1();
setVisible(false);
}
else
{
JOptionPane.showMessageDialog(null,"invalid flight details");
setVisible(false);
}
}
catch(Exception e)
{
System.out.println(e);
}
}
}
public static void main(String args[])
{
new book();
}
}