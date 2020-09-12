package mypack;

public class CareerExpert 
{
	private String Quali;

	public String getQuali() 
	{
		return Quali;
	}

	public void setQuali(String quali) 
	{
		Quali = quali;
	}
	public String getAdvice(String s)
	{
		if(s.equalsIgnoreCase("BE"))
		{
			return "BE Qualified";
		}
		else if(s.equalsIgnoreCase("BBA"))
		{
			return "BBA Qualified";
		}
		else if(s.equalsIgnoreCase("CA"))
		{
			return "CA Qualified";
		}
		else if(s.equalsIgnoreCase("MS"))
		{
			return "MS Qualified";
		}
		
		return "";
	}

}
