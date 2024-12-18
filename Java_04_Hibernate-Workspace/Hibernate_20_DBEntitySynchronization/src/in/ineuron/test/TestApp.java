package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.utility.HibernateUtil;

public class TestApp {

	public static void main(String[] args) throws IOException {
		Session session=null;
		boolean flag=false;
		int id=7;
		
		try {
			
			session= HibernateUtil.getSession();
			Student student=session.get(Student.class, id);
			System.out.println("Before updation in table:: " +student);
			
			if(student != null) {
				System.in.read();//Go to DB and make the changes
				
				//session.refresh(object) is to be called to sync the db according to L1-cache
				session.refresh(student);
				
				System.out.println("After updation in table:: "+student);
				
			}else {
				System.out.println("Record not available for the ID:: "+id);
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
				System.in.read();
				//transaction.commit();
				System.out.println("Data is loaded to Database");
			}else {
				//transaction.rollback();
				System.out.println("Data is not loaded to Database");
			}
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}

}
