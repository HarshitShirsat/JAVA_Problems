import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class Dbdemo1
{
	static Connection link;
	static Statement stm;
	static ResultSet rs;
	
	Dbdemo1() throws SQLException
	{ 
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			link=DriverManager.getConnection("jdbc:mysql://172.16.2.3/student","student","student");
		}
		catch(ClassNotFoundException E)
		{
			System.out.println("* Unable to load driver!*"); 
			System.exit(1);
		}
		catch(SQLException E)
		{
			System.out.println("* Cannot connect to database!*"); 
			System.exit(1);
		}
		stm= link.createStatement ( );
	}

	void displayinfo() throws SQLException
	{
		String s = "SELECT * FROM av1"; 
		rs= stm.executeQuery(s); 
		while(rs.next())
		{
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2)+"\t" + rs.getString(3)+ "\t" +rs.getFloat(4));
		} 
	}

	void insertinfo() throws SQLException
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter Account Number");
		int acno=s.nextInt();
		System.out.println("Enter surname");
		String sur=s.next();
		System.out.println("Enter firstname");
		String fname=s.next();
		System.out.println("Enter Balance"); 
		Float balance=s.nextFloat();
		
		try
		{
			String s1 = "insert into av1 values("+acno+",'"+sur+"','"+fname+"',"+balance+");"; 
			int rs= stm.executeUpdate(s1);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		System.out.println(rs+"rows affected");
	}

	void deleteinfo() throws SQLException
	{
		Scanner s1=new Scanner(System.in);
		System.out.println("Enter the account no ."); 
		int acno= s1.nextInt();
		String s2 = "DELETE FROM av1 WHERE acno="+acno;
		stm.executeUpdate (s2);
		System.out.println("Database deleted successfully!!!!");
	}

	void closecon() throws SQLException
	{
		rs.close();
		stm.close();
		link.close();
	}
}
	
public class JDBC
{
	public static void main(String args[]) throws SQLException
	{
		boolean f=true;
		Dbdemo1 d1= new Dbdemo1();
		d1.displayinfo();
		while(f)
		{
			System.out.println("1:insert 2:delete 3:display 4:exit"); 
			System.out.println("enter your option");
			Scanner s=new Scanner(System.in);
			int op=s.nextInt();
			switch(op)
			{
				case 1:d1.insertinfo(); 
				break;
				case 2:d1.deleteinfo();
				break;
				case 3:d1.displayinfo(); 
				break;
				case 4:f=false;
			} 
		}
		d1.closecon();
	} 
}
