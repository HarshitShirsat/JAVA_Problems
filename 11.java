import java.util.*;
import java.io.*;

public class RandomAccessFiles 
{
	private static final int record_size=72;
	private static final int surname_limit=15;
	private static final int initial_limit=15;
	private static long acc_no=0;
	private static float balance;
	private static String surname,initials;
	
	public static void main(String args[]) throws IOException
	{
		RandomAccessFile obj=new RandomAccessFile("Account.txt","rw");
		Scanner ip=new Scanner(System.in);
		Scanner ip2=new Scanner(System.in);
		String op="y";
		do
		{
			acc_no++;
			
			System.out.println("\nAccount number " + acc_no + ".\n");
			System.out.print("Surname: "); 
			surname = ip.nextLine();
			System.out.print("Initial: ");   
			initials = ip.nextLine();
			System.out.print("Balance: ");   
			balance = ip.nextFloat();
			
			ip.nextLine();
			writeRecord(obj);
			
			System.out.print("\nDo you wish to do this again (y/n)? ");
			op = ip2.nextLine();
			
		}while(op.equals("y") || op.equals("Y"));
		System.out.println("\n");
		showRecords(obj);
		ip.close();
		ip2.close();
	}
	
	public static void writeRecord(RandomAccessFile fl) throws IOException
	{
		long pos=(acc_no-1)*record_size;
		fl.seek(pos);
		
		fl.writeLong(acc_no);
		writeString(fl,surname,surname_limit);
		writeString(fl,initials,initial_limit);
		fl.writeFloat(balance);
	}
	
	public static void writeString(RandomAccessFile f,String s,int size) throws IOException
	{
		int len=s.length();
		if(len<=size)
		{
			f.writeChars(s);
			for(int i=len;i<size;i++)
			{
				f.writeChar(' ');
			}
		}
		else
		{
			f.writeChars(s.substring(0, size));
		}
	}
	
	public static void showRecords(RandomAccessFile f) throws IOException
	{
		long noofrecords=f.length()/record_size;
		f.seek(0);
		for(int i=0;i<noofrecords;i++)
		{
			acc_no=f.readLong();
			surname=readString(f,surname_limit);
			initials=readString(f,initial_limit);
			balance=f.readFloat();
			System.out.println("Account Number : "+acc_no+" Surname : "+surname+" Initials : "+initials+" Balance : "+balance);
		}
	}
	
	public static String readString(RandomAccessFile f,long limit) throws IOException
	{
		String str="";
		for(int i=0;i<limit;i++)
		{
			str+=f.readChar();
		}
		return str;
	}
}