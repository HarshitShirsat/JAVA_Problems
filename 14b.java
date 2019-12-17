import java.io.*;
import java.net.*;
import java.util.*;

public class TCPServer 
{
	private static ServerSocket servSock;
	private static final int PORT=1235;
	
	public static void main(String args[])
	{
		System.out.println("Opening Port...");
		try
		{
			servSock=new ServerSocket(PORT); //1
		}
		catch(IOException ioe)
		{
			System.out.println("Unable to attach to port");
			System.exit(1);
		}
		do
		{
			handleClient();
		}while(true);
	}
	
	private static void handleClient()
	{
		Socket link=null;
		try
		{
			link=servSock.accept(); //2
			
			Scanner input=new Scanner(link.getInputStream()); //3
			PrintWriter output=new PrintWriter(link.getOutputStream(),true);
			
			String message=input.nextLine(); //4
			int messagecount=0;
			
			while(!message.equals("***CLOSE***"))
			{
				System.out.println("Message Received");
				messagecount++;
				output.println("SERVER > Message "+messagecount+" : "+message);
				message=input.nextLine();
			}
			output.println(messagecount+" messages received");
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
				link.close(); //5
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
