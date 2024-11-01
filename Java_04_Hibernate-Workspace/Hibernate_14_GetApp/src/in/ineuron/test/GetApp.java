package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.utility.HibernateUtil;

public class GetApp {

	public static void main(String[] args) {
		Session session=null;
		int id = 99;
		
		try {
			
			session= HibernateUtil.getSession();
			if(session != null) {
				//get() is eager loading, used in standalone projects, returns null when no object is found
				//It creates only one object when the data is found by the ORM in DB
				
				Student student=session.get(Student.class, id);
				
				
				if(student != null) {
					System.out.println(student);
				}else {
					System.out.println("Student doesn't exists with id:: "+id);
				}
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
			
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}

}
