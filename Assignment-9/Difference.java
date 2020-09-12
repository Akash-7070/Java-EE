package Mypack;

import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.*;
import javax.servlet.jsp.*;

public class Difference extends SimpleTagSupport
{
	int first;
	int  second;
	public int getFirst() {
		return first;
	}
	public void setFirst(int first) {
		this.first = first;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		this.second = second;
	}
	
	public void doTag() throws IOException,JspException
	{
		getJspContext().getOut().print(getFirst()-getSecond());
	}

}
