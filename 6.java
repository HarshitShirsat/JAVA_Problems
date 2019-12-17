import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile 
{
	public static void main(String args[]) throws IOException
	{
		FileInputStream f1=new FileInputStream("C:\\Eclipse_Workspace\\JAVA_LAB_SEE\\f1.txt");
		FileInputStream f2=new FileInputStream("C:\\Eclipse_Workspace\\JAVA_LAB_SEE\\f2.txt");
		FileOutputStream f3=new FileOutputStream("C:\\Eclipse_Workspace\\JAVA_LAB_SEE\\f3.txt");
		int i;
		while((i=f1.read()) != -1)
			f3.write((char)i);
		f1.close();
		while((i=f2.read()) != -1)
			f3.write((char)i);
		System.out.println("Done");
		f2.close();
		f3.close();							
	}
}
