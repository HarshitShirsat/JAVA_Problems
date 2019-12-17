import java.util.regex.*;

class RegexA
{
	public static void main(String args[])
	{
		String content = "This is Nitte "+"from Javabook.com.";
		String pattern = ".*book.*";
		boolean isMatch = Pattern.matches(pattern, content);
		System.out.println("The text contains 'book'? " + isMatch);
	}
}

