import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingLogin extends JFrame implements ActionListener
{
	JTextField t1,t2;
	JLabel l1,l2;
	JButton b;
	
	SwingLogin()
	{
		setSize(350,200);
		l1=new JLabel();
		l1.setText("Username - ");
		l2=new JLabel();
		l2.setText("Password - ");
		t1=new JTextField(20);
		t2=new JPasswordField(20);
		b=new JButton("Submit");
		setLayout(new FlowLayout());
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(b);
		b.addActionListener(this);
		setTitle("Login Page");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String str1=t1.getText();
		String str2=t2.getText();
		if(str1.contentEquals("harshit") && str2.contentEquals("password"))
		{
			NextPage page=new NextPage();
			page.setVisible(true);
			JLabel l=new JLabel("Welcome "+str1);
			page.add(l);
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Incorrect username or password","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void main(String args[])
	{
		new SwingLogin();
	}
}

class NextPage extends JFrame
{
	NextPage()
	{
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Welcome");
		setSize(400,200);
	}
}