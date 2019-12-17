import java.util.Comparator;
import java.util.TreeSet;

public class TSComparator 
{
	public static void main(String args[])
	{
		TreeSet<Employee> namets = new TreeSet<Employee> (new nameComparator());
		namets.add(new Employee("Gagan",10000));
		namets.add(new Employee("Deon",15000));
		namets.add(new Employee("Sherwin",12000));
		namets.add(new Employee("Lohith",5000));
		namets.add(new Employee("Harshit",6000));
		for(Employee e:namets)
		{
			System.out.println(e);
		}
		System.out.println("\n");
		TreeSet<Employee> salaryts = new TreeSet<Employee> (new salaryComparator());
		salaryts.add(new Employee("Gagan",10000));
		salaryts.add(new Employee("Deon",15000));
		salaryts.add(new Employee("Sherwin",12000));
		salaryts.add(new Employee("Lohith",5000));
		salaryts.add(new Employee("Harshit",6000));
		for(Employee e:salaryts)
		{
			System.out.println(e);
		}
	}
}

class nameComparator implements Comparator<Employee>
{
	public int compare(Employee e1,Employee e2)
	{
		return e1.getName().compareTo(e2.getName());
	}
}

class salaryComparator implements Comparator<Employee>
{
	public int compare(Employee e1,Employee e2)
	{
		if( e1.getSalary() > e2.getSalary())
			return 1;
		else
			return -1;
	}
}


class Employee
{
	String name;
	int salary;
	Employee(String n,int s)
	{
		name=n;
		salary=s;
	}
	void setName(String n)
	{
		name=n;
	}
	String getName()
	{
		return name;
	}
	void setSalary(int s)
	{
		salary=s;
	}
	int getSalary()
	{
		return salary;
	}
	public String toString()
	{
		return ("Name - "+name+"\t Salary - "+salary);
	}
}