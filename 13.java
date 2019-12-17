import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class Dbdemo2
{
	static Connection link;
	static Statement stm;
	static ResultSet rs;
	Dbdemo2() throws SQLException
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
	
			link=DriverManager.getConnection("jdbc:mysql://172.16.2.3/student","student","student");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("* Unable to load driver!*");
			System.exit(1);
		}
		catch(SQLException e)
		{
			System.out.println("*cannot connect to database!*");
			System.exit(1);
		}
		stm=link.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	}
	void displayinfo() throws SQLException
	{
		String s="SELECT * FROM student125";
		rs=stm.executeQuery(s);
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
		}
	
		rs.first();
		System.out.println("FIRST RECORD...");
		System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
		rs.absolute(3);
		System.out.println("THIRD RECORD...");
		System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
		rs.last();
		System.out.println("LAST RECORD...");
		System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
		rs.previous();
		System.out.println("Previous of LAST RECORD...");
		System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
		rs.relative(-1);
		System.out.println("Relative decrement from Previous RECORD...");
		System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
	}
	
	void insertinfo() throws SQLException
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter usn");
		int usn=s.nextInt();
		System.out.println("Enter first name");
		String fname=s.next();
		System.out.println("Enter last name");
		String lname=s.next();
		try
		{
		String s1="insert into student125 values("+usn+",'"+fname+"','"+lname+"');";
		int rs=stm.executeUpdate(s1);
		}
		catch(Exception e)
		{
		System.out.println(e);
		}
		System.out.println(rs+"rows affeced");
	}
	void updateinfo() throws SQLException
	{
		Scanner s1=new Scanner(System.in);
		System.out.println("Enter the usn:");
		int usn=s1.nextInt();
		System.out.println("Enter the fname");
		String fnam=s1.next();
		System.out.println("Enter lname:");
		String lnam=s1.next();
		
		String s3="UPDATE  student125  set fname='"+fnam+"',lname='"+lnam+"'where usn="+usn;
		
		stm.executeUpdate(s3);
		System.out.println("Database updated successfully");
	}
	void closecon() throws SQLException
	{
		rs.close();
		stm.close();
		link.close();
	}
}
public class JDBCScrollable 
{
	public static void main(String[] args) throws SQLException 
	{
		boolean f=true;
		Dbdemo2 d1=new Dbdemo2();
		d1.displayinfo();
		while(f)
		{
			System.out.println("1.insert 2:update 3:display ");
			System.out.println("Enter your option");
			Scanner s=new Scanner(System.in);
			int op=s.nextInt();
			switch(op)
			{
				case 1:d1.insertinfo();
				break;
				case 2:d1.updateinfo();
				break;
				case 3:d1.displayinfo();
				break;
				case 4:f=false;
			}
		}
		
		d1.closecon();
	}
}
