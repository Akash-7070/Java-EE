package mypack;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDAODataImpl implements StrudentDAO
{
	public void addStudent(Student std)
	{
		try
		{
			Session ss= HibernateUtil.getSessionFactory().openSession();
			Transaction trans = ss.beginTransaction();
			
			ss.save(std);
			trans.commit();
			System.out.println("Done With Database");
			
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		
	}

}
