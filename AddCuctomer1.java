//package airlinemanagementsystem ;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class AddCuctomer1 extends JFrame implements ActionListener
{
JTextField tnm,tnl,tar,tad,tpn;
JLabel nm,nl,ar,ad,pn,gn,l1;
JRadioButton rb1,rb2;
JButton save;
Connection con=null;
Statement st=null;
ResultSet rs1=null;

public AddCuctomer1()
{
getContentPane().setBackground(Color.WHITE);
setLayout(null);
 l1=new JLabel("ADD CUSTOMER DETAILS");
l1.setBounds(220,20,500,35);
l1.setFont(new Font("Tahoma",Font.PLAIN,32));
l1.setForeground(Color.BLUE);
add(l1);

 nm=new JLabel("Name:");
nm.setBounds(60,80,150,25);
nm.setFont(new Font("Tahoma",Font.PLAIN,16));
add(nm);

 tnm=new JTextField();
tnm.setBounds(220,80,150,25);
add(tnm);

nl=new JLabel("Nationality:");
nl.setBounds(60,130,150,25);
nl.setFont(new Font("Tahoma",Font.PLAIN,16));
add(nl);

 tnl=new JTextField();
tnl.setBounds(220,130,150,25);
add(tnl);

ar=new JLabel("Aadhar:");
ar.setBounds(60,180,150,25);
ar.setFont(new Font("Tahoma",Font.PLAIN,16));
add(ar);

 tar=new JTextField();
tar.setBounds(220,180,150,25);
add(tar);

 ad=new JLabel("Address:");
ad.setBounds(60,230,150,25);
ad.setFont(new Font("Tahoma",Font.PLAIN,16));
add(ad);

 tad=new JTextField();
tad.setBounds(220,230,150,25);
add(tad);

 gn=new JLabel("Gender:");
gn.setBounds(60,280,150,25);
gn.setFont(new Font("Tahoma",Font.PLAIN,16));
add(gn);

ButtonGroup bgp=new ButtonGroup();

rb1=new JRadioButton("Male");
rb1.setBounds(220,280,70,25);
rb1.setBackground(Color.WHITE);
add(rb1);

rb2=new JRadioButton("Female");
rb2.setBounds(300,280,70,25);
rb2.setBackground(Color.WHITE);
add(rb2);
bgp.add(rb1);
bgp.add(rb2);

 pn=new JLabel("Phone no:");
pn.setBounds(60,330,150,25);
pn.setFont(new Font("Tahoma",Font.PLAIN,16));
add(pn);

tpn=new JTextField();
tpn.setBounds(220,330,150,25);
add(tpn);

 save=new JButton("SAVE");
save.setBackground(Color.BLACK);
save.setForeground(Color.WHITE);
save.setBounds(220,380,150,30);
add(save);
save.addActionListener(this);

ImageIcon image=new ImageIcon(ClassLoader.getSystemResource("customer.png"));
JLabel lblimage=new JLabel(image);
lblimage.setBounds(450,80,280,400);
add(lblimage);


setSize(900,600);
setLocation(300,150);
setVisible(true);

try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:ams");
 Statement st=con.createStatement();
}
catch(Exception e)
{
System.out.println(e);
}
}
public void actionPerformed(ActionEvent ae)
{
String name=tnm.getText();
String nationality=tnl.getText();
String address=tad.getText();
String aadhar=tar.getText();
String phone=tpn.getText();
String gender=null;
if(rb1.isSelected())
{
gender="male";
}
else
{
gender="female";
}
try
{
String query="insert into pasenger values('"+name+"', '"+nationality+"', '"+address+"', '"+aadhar+"', '"+phone+"', '"+gender+"')";
rs1=st.executeUpdate(query);
JOptionPane.showMessageDialog(null,"customer details added successfully");
}
catch(Exception e)
{
System.out.println(e);
}
}
public static void main(String args[])
{
new AddCuctomer1();
}
}