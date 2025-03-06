import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class home extends JFrame implements ActionListener
{
JTextField t1;
JPasswordField ps;
JLabel l1,l2;
JButton b1,b2,b3;

public home()
{
super("home page");
setLayout(null);
 ImageIcon image=new ImageIcon(ClassLoader.getSystemResource("air.jfif"));
JLabel lblimage=new JLabel(image);
lblimage.setBounds(0,0,1600,800);
add(lblimage);


JLabel heading=new JLabel("AIR INDIA WELCOMES YOU !!!");
heading.setBounds(500,40,1000,40);
heading.setForeground(Color.BLUE);
heading.setFont(new Font("Tahoma",Font.PLAIN,36));
lblimage.add(heading);

JMenuBar mb=new JMenuBar();
setJMenuBar(mb);

JMenu details=new JMenu("Ticket");
mb.add(details);

JMenuItem fdetails=new JMenuItem("Flight Details");
fdetails.addActionListener(this);
details.add(fdetails);

/*JMenuItem cdetails=new JMenuItem("Add Customer Details");
cdetails.addActionListener(this);
details.add(cdetails);*/

JMenuItem bk=new JMenuItem("Book Flight");
bk.addActionListener(this);
details.add(bk);

/*JMenuItem jdetails=new JMenuItem("Journey Details");
details.add(jdetails);*/

JMenuItem tc=new JMenuItem("Cancel Ticket");
tc.addActionListener(this);
details.add(tc);

/*JMenu ticket=new JMenu("Ticket");
mb.add(ticket);

JMenuItem bp=new JMenuItem("Boarding Pass");
ticket.add(bp);*/



setExtendedState(JFrame.MAXIMIZED_BOTH);
setLocation(600,250);
setVisible(true);

}
public void actionPerformed(ActionEvent ae)
{
String text=ae.getActionCommand();
if(text.equals("Flight Details"))
{
new flightdemo();
}
else if(text.equals("Book Flight"))
{
new book();
}
else if(text.equals("Cancel Ticket"))
{
new flightcancel();
}

}
public static void main(String args[])
{
new home();
}
}