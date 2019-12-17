//Create a swing program that is having a list view to select the city,
//text box to enter the name, phone number. radio button to select gender 
//and check box for hobby create an alert to display the selctions made by the user

import javax.swing.*;
import javax.swing.event.*; 
import java.awt.*;
import java.awt.event.*;

class SwingCity extends JFrame implements ActionListener, ListSelectionListener
{
	JLabel l1,l2,l3,l4,l5,el1,el2; 
	JButton b1,b2;
	JCheckBox c1,c2,c3;
	JRadioButton rb1,rb2; 
	JTextField t1,t2;
	JList<String>jlist;
	
	JScrollPane jp;
	JLabel jlb;
	String cities[]={"Delhi","Wellington","Auckland","Udupi","Mangalore","Sydney","DUbai"}; 
	
	SwingCity()
	{
		setTitle("Choices");
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setLayout(new FlowLayout());
		
		t1=new JTextField(10);
		t2=new JTextField(10);
		l1=new JLabel("Enter Name : ");
		l2=new JLabel("Enter Contact No : "); 
		el1=new JLabel("                               ");
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		
		l3=new JLabel("Choose gender"); 
		add(l3);
		
		rb1=new JRadioButton("Male"); 
		rb2=new JRadioButton("Female");
		rb1.addActionListener(this);
		rb2.addActionListener(this);
		
		add(rb1);
		add(rb2);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(rb1);
		bg.add(rb2);
		
		l4=new JLabel("Choose Hobbies");
		c1=new JCheckBox("Singing");
		c2=new JCheckBox("Reading Books"); 
		c3=new JCheckBox("Numismatcs");
		
		c1.addActionListener(this);
		c2.addActionListener(this);
		c3.addActionListener(this);
		
		add(l4);
		add(c1);
		add(c2);
		add(c3);
		
		jlist=new JList<String>(cities);
		jp=new JScrollPane(jlist);
		jp.setPreferredSize(new Dimension(100,120));
		
		jlist.addListSelectionListener(this);
		el2=new JLabel("                               ");
		add(el2);
		add(jp);
		jlb=new JLabel("Select a city");
		add(jlb);
		
		b1=new JButton("Submit");
		b1.addActionListener(this); 
		add(b1);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getActionCommand().equals("Submit"))
		{
			String a=t1.getText();
			String b=t2.getText();
			String c="";
			String d="";
			String g="";
			
			if(rb1.isSelected())
			{
				c="Male";
			}
			if(rb2.isSelected())
			{
				c="Female";
			}
			if(c1.isSelected())
			{
				d+=" Singing";
			}
			if(c2.isSelected())
			{
				d+=" Reading";
			}
			if(c3.isSelected())
			{
				d+=" Numismatics";
			}
			int i=jlist.getSelectedIndex(); 
			if(i!=-1)
			{
				g=cities[i];
			}
			String tot="Name is "+a+"\n"+"Contact is "+b+"\n"+"Gender :"+c+"\n"+"Hobbies:"+d+"\n City :"+g;
			JOptionPane.showMessageDialog(null,tot);
		}
	}
	
	public void valueChanged(ListSelectionEvent le)
	{
		int i=jlist.getSelectedIndex();
		if(i!=-1)
		{
			jlb.setText("city is "+cities[i]);
		}
	}

	public static void main(String[] args)
	{
		new SwingCity();
	}
}