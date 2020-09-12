package mypack;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.tagext.JspFragment;
import java.io.*;
import javax.servlet.jsp.*;
public class Converter extends SimpleTagSupport
{
	private String code;
	
	public void setCode(String code)
	{
		this.code=code;
	}
	public String getCode()
	{
		return code;
	}
	
	public String toggle()
	{
		char str[]=getCode().toCharArray();
		for (int i=0; i<str.length; i++) 
	    { 
	        if (str[i]>='A' && str[i]<='Z') 
	        {
	            str[i] = (char) (str[i] + 32); 
	        }
	        else if (str[i]>='a' && str[i]<='z')
	        {
	            str[i] = (char) (str[i] -32); 
	        }
	    } 
		String s=String.valueOf(str);
		return s;
	}
	
	public void doTag()throws JspException,IOException
	{
		JspContext context=getJspContext();
		context.getOut().write(toggle());
		
	}
}




