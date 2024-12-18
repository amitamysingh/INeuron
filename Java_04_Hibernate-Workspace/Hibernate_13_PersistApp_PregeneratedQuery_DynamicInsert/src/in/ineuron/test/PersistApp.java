package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.utility.HibernateUtil;

public class PersistApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = null;		
		Transaction transaction = null;
		boolean flag=false;
		try {
			session=HibernateUtil.getSession();
			
			if(session != null) {
				transaction=session.beginTransaction();
			}
			
			if(transaction != null) {
				Student student = new Student();
				student.setSid(7);
				student.setSname("dhoni");
				//student.setSage(50);
				student.setSaddress("CSK");
				
				session.persist(student);
				flag=true;
			}
			
		}
		catch(HibernateException he) {
			System.out.println("Hibernate Exception occured");
			he.printStackTrace();
		}
		catch(Exception e) {
			System.out.println("Exception occured");
			e.printStackTrace();
		}
		finally{
			if(flag) {
				transaction.commit();
				System.out.println("Data is saved to Database...");
			}else {
				transaction.rollback();
				System.out.println("Data is not saved to Database...");
				
			}
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}

}
