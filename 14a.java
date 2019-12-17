

import java.io.*;
import java.net.*;
import java.util.*;

public class TCPClient 
{
	private static InetAddress host;
	private static final int PORT=1235;
	
	public static void main(String args[])
	{
		try
		{
			host=InetAddress.getLocalHost(); //1
		}
		catch(UnknownHostException uhe)
		{
			System.out.println("HostID not found");
			System.exit(1);
		}
		
		accessServer();
	}
	
	private static void accessServer()
	{
		Socket link=null;
		try
		{
			link=new Socket(host,PORT);

			Scanner input=new Scanner(link.getInputStream()); //2
			PrintWriter output=new PrintWriter(link.getOutputStream(),true);
			
			Scanner userEntry=new Scanner(System.in);
			String message,response;
			
			do
			{
				System.out.println("Enter the message - ");
				message=userEntry.nextLine();
				output.println(message); //3
				response=input.nextLine();
				System.out.println(response);
			}while(!message.equals("***CLOSE***"));
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
		finally
		{
			try
			{
				System.out.println("Closing Connection");
				link.close(); //4
				System.exit(1);
			}
			catch(IOException ioe)
			{
				System.out.println("Error closing connection");
				System.exit(1);
			}
		}
	}
}
