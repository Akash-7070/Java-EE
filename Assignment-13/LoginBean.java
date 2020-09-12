package mypack;

public class LoginBean 
{
	public boolean validate(String name,String pass)
	{
		if(name.equalsIgnoreCase("Akash") && pass.equals("AK@7070"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
}
