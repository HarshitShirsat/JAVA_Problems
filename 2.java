class student 
{ 
	String name;
	int rollno;

	student(String n,int r)
	{ 
		name=n; 
		rollno=r;
	}

	void display()
	{
		System.out.println("Name: "+name+"\tRollno: "+rollno);
	}
}

public class Array 
{
	public static void main(String ar[]) 
	{ 
		student st[]=new student[5];
		
		try
		{
			st[0]=new student("Jason",110);
			st[1]=new student("John",121);
			st[2]=new student("Ram",130);
			st[3]=new student("Sammy",160);
			st[4]=new student("Ajinkya",118);
			
			for(int i=0;i<=5;i++)
			{
				st[i].display();
			}
		}
		catch(ArrayIndexOutOfBoundsException e) 
		{ 
			System.out.println("The maximum students should be five\n"); 
		}
	}
}
