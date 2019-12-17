import java.util.Scanner;

class customer
{
	int accno;
	String custname;
	String acctype;
	double balance;

	customer(int no,String n,String type,double bal)
	{
		accno=no;
		custname=n;
		acctype=type;
		balance=bal;
	}
}

class account extends customer
{
	account(int no,String n,String type,double bal)
	{
		super(no,n,type,bal);
	}
	void deposit(double x)
	{
		balance=balance+x;
	}
	void withdraw(double y)
	{
		balance=balance-y;
	}
	double getbal()
	{
		return balance;
	}
}

public class Bank 
{
	public static void main(String[] args)
	{
		Scanner r=new Scanner(System.in);
		System.out.println("Enter the customer id:");
		int id=r.nextInt();
		
		System.out.println("Enter the name");
		String name=r.next();
		
		System.out.println("Enter the account type");
		String actype=r.next();
		
		account acc=new account(id,name,actype,15000.00);
		
		double bal=acc.getbal();
		System.out.println("The balance:"+bal);
		
		System.out.println("Enter the deposit amount");
		double dep=r.nextDouble();
		acc.deposit(dep);
		
		bal=acc.getbal();
		System.out.println("The balance:"+bal);
		
		System.out.println("Enter the withdraw amount");
		double wit=r.nextDouble();
		acc.withdraw(wit);
		
		bal=acc.getbal();
		System.out.println("The balance:"+bal);
	}
}

