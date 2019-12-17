import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingCalc extends JFrame implements ActionListener 
{
	JLabel l1,l2,l3,l4;
	JTextField t1,t2,t3;
	JButton b1,b2,b3;
	SwingCalc()
	{
		setLayout(new FlowLayout());
		setSize(500,500);
		l1=new JLabel("Enter number 1 : ");
		l2=new JLabel("Enter number 2 : ");
		l3=new JLabel("Enter number 3 : ");
		l4=new JLabel("");
		b1=new JButton(" Sum ");
		b2=new JButton(" Avg ");
		b3=new JButton(" Max ");
		t1=new JTextField(10);
		t2=new JTextField(10);
		t3=new JTextField(10);
		l1.setBounds(70, 50, 150, 30);
		l2.setBounds(70, 80, 150, 30);
		l3.setBounds(70, 110, 150, 30);
		t1.setBounds(230, 50, 130, 30);
		t2.setBounds(230, 80, 130, 30);
		t3.setBounds(230, 110, 130, 30);
		b1.setBounds(70	, 130, 40, 40);
		b2.setBounds(120, 130, 40, 40);
		b3.setBounds(170, 130, 40, 40);
		l4.setBounds(70, 140, 150, 30);  
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(l3);
		add(t3);
		add(b1);
		add(b2);
		add(b3);
		b1.setActionCommand("Sum");
		b2.setActionCommand("Avg");
		b3.setActionCommand("Max");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		setTitle("Calculator");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		float a,b,c,d;
		a=Float.parseFloat(t1.getText().trim());
		b=Float.parseFloat(t2.getText().trim());
		c=Float.parseFloat(t3.getText().trim());
		if(ae.getActionCommand()=="Sum")
		{
			d=a+b+c;
			l4.setText("The sum of the 3 numbers is "+d);
			add(l4);
		}
		if(ae.getActionCommand()=="Avg")
		{
			d=(a+b+c)/3;
			l4.setText("The average of the 3 numbers is "+d);
			add(l4);
		}
		if(ae.getActionCommand()=="Max")
		{
			float x=Math.max(a, b);
			d=Math.max(x, c);
			l4.setText("The maximum of the 3 numbers is "+d);
			add(l4);
		}
	}
	
	public static void main(String args[])
	{
		new SwingCalc();
	}
}
