class employee implements java.io.Serializable
{
	int id;
	String fname;
	String lname;
	String location;
	
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public String getFname() 
	{
		return fname;
	}
	public void setFname(String fname) 
	{
		this.fname = fname;
	}
	public String getLname() 
	{
		return lname;
	}
	public void setLname(String lname) 
	{
		this.lname = lname;
	}
	public String getLocation() 
	{
		return location;
	}
	public void setLocation(String location) 
	{
		this.location = location;
	}
}

public class JavaBean 
{
	public static void main(String args[])
	{
		employee e=new employee();//object is created
		e.setId(123);
		e.setFname("Harshit");//setting value to the object
		e.setLname("Shirsat");
		e.setLocation("Udupi");
		
		System.out.println(e.getId());
		System.out.println(e.getFname());
		System.out.println(e.getLname());
		System.out.println(e.getLocation());
	}
}
