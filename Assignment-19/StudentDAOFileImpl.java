package mypack;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;

public class StudentDAOFileImpl implements StrudentDAO 
{
	private static final long serialVersionUID = 1L;
	
	public void addStudent(Student std)
	{
		
		try(FileOutputStream fo= new FileOutputStream("E://Student.txt"))
		{
				ObjectOutputStream ob= new ObjectOutputStream(fo);
				ob.writeObject(std);
				System.out.println("Done With File");
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
