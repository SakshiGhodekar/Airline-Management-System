import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class flightcancel extends JFrame implements ActionListener
{
JTextField tar,tbk;
//JPasswordField ps;
JLabel ar,bk,l1;
JButton cl;
Connection c=null;
Statement s=null;
//ResultSet rs=null;

flightcancel()
{
super("Ticket Cancel");
getContentPane().setBackground(Color.WHITE);
setLayout(null);
 l1=new JLabel("FLIGHT CANCEL");
l1.setBounds(220,20,500,35);
l1.setFont(new Font("Tahoma",Font.PLAIN,32));
l1.setForeground(Color.BLUE);
add(l1);

 bk=new JLabel("Flight code:");
bk.setBounds(60,80,150,25);
bk.setFont(new Font("Tahoma",Font.PLAIN,16));
add(bk);

 tbk=new JTextField();
tbk.setBounds(220,80,150,25);
add(tbk);

ar=new JLabel("Aadhar no:");
ar.setBounds(60,130,150,25);
ar.setFont(new Font("Tahoma",Font.PLAIN,16));
add(ar);

 tar=new JTextField();
tar.setBounds(220,130,150,25);
add(tar);

 cl=new JButton("Cancel");
cl.setBackground(Color.BLACK);
cl.setForeground(Color.WHITE);
cl.setBounds(220,180,150,25);
add(cl);
cl.addActionListener(this);


setSize(900,600);
setLocation(300,150);
setVisible(true);
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
 c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
 s=c.createStatement();
}
catch(Exception e)
{
System.out.println(e);
}
}
public void actionPerformed(ActionEvent ae)
{
 if(ae.getSource()==cl)
{
try
{
//String username=t1.getText();
//String password=ps.getText();

//conn con1=new conn();
//String query="select * from login where username='"+username+"' and password='"+password+"'";
 //rs=s.executeQuery(query);
 int rs=s.executeUpdate("delete from pasenger1 where aadhar='"+tar.getText()+"'");

if(rs>0)
{
JOptionPane.showMessageDialog(null,"flight cancel");
//setVisible(false);
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
new flightcancel();
}
}