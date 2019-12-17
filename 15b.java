

import java.io.*;
import java.net.*;
import java.util.*;

public class UDPServer 
{
	private static DatagramSocket datagramSocket;
	private static DatagramPacket inPacket,outPacket;
	private static final int PORT=1234;
	private static byte[] buffer;
	
	public static void main(String args[])
	{
		System.out.println("Opening port...");
		try
		{
			datagramSocket=new DatagramSocket(PORT); //1
		}
		catch(SocketException se)
		{
			System.out.println("Unable to attach to port");
			System.exit(1);
		}
		handleClient();
	}
	
	private static void handleClient()
	{
		try
		{
			String messagein,messageout;
			int messagecount=0;
			do
			{
				buffer=new byte[256]; //2
				
				inpacket=new DatagramPacket(buffer,buffer.length); //3
				datagramSocket.receive(inPacket); //4
				
				InetAddress clientAddress=inPacket.getAddress(); //5
				int clientPort=inPacket.getPort();
				
				messagein=new String(inPacket.getData(),0,inPacket.getLength()); //6
				
				System.out.println("Message received");
				messagecount++;
				messageout="Message "+messagecount+" : "+messagein;
				
				outPacket=new DatagramPacket(messageout.getBytes(),messageout.length(),clientAddress,clientPort); //7
				datagramSocket.send(outPacket); //8
			}while(true);
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
		finally
		{
			System.out.println("Closing Connection..");
			datagramSocket.close(); //9
			System.exit(1);
		}
	}
}
