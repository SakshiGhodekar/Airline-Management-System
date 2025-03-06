import java.awt.*;
import javax.swing.*;
public class flightdemo extends JFrame 
{
flightdemo()
{
String data[][]={{"101","AI-1101","Delhi","Mumbai","07:15 am"},{"102","AI-1102","Mumabi","Delhi","07:30 pm"},{"103","AI-1103","kalkatta","Chennai","08:10 am"},
		{"104","AI-1104","Goa","Panjab","09:00 pm"},{"105","AI-1105","Delhi","Mumbai","11:45 am"},{"106","AI-1106","Mumbai","Delhi","03:15 pm"},
		{"107","AI-1107","Delhi","Goa","12:10 pm"},{"108","AI-1108","Panjab","Mumbai","04:00 pm"},{"109","AI-1109","chennai","kalkatta","10:00 am"}};
String col[]={"F_id","F_name","Source","Destination","Time"};

JTable tb=new JTable(data,col);
int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;

JScrollPane sp=new JScrollPane(tb,v,h);

setSize(400,400);
setVisible(true);
add(sp,BorderLayout.CENTER);

}
public static void main(String args[])
{
new flightdemo();
}
}
