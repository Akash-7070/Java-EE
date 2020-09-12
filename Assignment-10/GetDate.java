package day7_1;



import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.*;
import java.util.Date;

import javax.servlet.jsp.*;

public class GetDate extends SimpleTagSupport
{
	public void doTag()throws JspException,IOException
	{
		getJspContext().getOut().print(new Date());
	}
}
