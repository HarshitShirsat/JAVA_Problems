

import java.io.*;
import java.net.*;
import java.util.*;

public class UDPClient 
{
	private static InetAddress host;
	private static DatagramSocket datagramSocket;
	private static DatagramPacket inPacket,outPacket;
	private static final int PORT=1234;
	private static byte[] buffer;
	
	public static void main(String args[])
	{
		try
		{
			host=InetAddress.getLocalHost();
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
		try
		{
			datagramSocket=new DatagramSocket(); //1
			Scanner userEntry=new Scanner(System.in);
			String message="",response="";
			do
			{
				System.out.println("Enter the message - ");
				message=userEntry.nextLine();
				outPacket=new DatagramPacket(message.getBytes(),message.length(),host,PORT); //2
				datagramSocket.send(outPacket); //3
				buffer=new byte[256]; //4
				inPacket=new DatagramPacket(buffer,buffer.length); //5
				datagramSocket.receive(inPacket); //6
				response=new String(inPacket.getData(),0,inPacket.getLength()); //7
				System.out.println("SERVER > "+response);
	
			}while(!message.equals("***CLOSE***"));
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
		finally
		{
			System.out.println("Closing Connection..");
			datagramSocket.close(); //8
			System.exit(1);
		}
	}
}
