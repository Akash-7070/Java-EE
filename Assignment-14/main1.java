package mypack1;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class main1 {

	public static void main(String[] args) 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tran=null;
		
		try
		{
			tran = session.beginTransaction();
			Student st1=new Student();
			
			st1.setName("Akash");
			st1.setAge(25);
			st1.setAddress("satar");
			
			session.save(st1);
			tran.commit();
			
			System.out.println("done with stds");
			
		}
		catch(Exception ee)
		{
			System.out.println("in catch\t");
		}

	}

}
