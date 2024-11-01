package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.utility.HibernateUtil;

public class LoadApp {

	public static void main(String[] args) {
		Session session=null;
		int id = 7;
		
		try {
			
			session= HibernateUtil.getSession();
			if(session != null) {
				
				
				//Load() is lazy loading, used in layered projects, and throws ObjectNotFound exception
				//when no object found
				//It creates 2 object, one temporary only with id and run getter methods to get the details
				//Ex: student.getSname(), student.getSage(), student.getSaddress();
				//The other object is created when ORM fetches the data of the student when found in DB with 
				//all the details like student - sage, sname, saddress
				Student student=session.load(Student.class, id);
				if(student != null) {
					System.out.println("Student id is:: "+student.getSid());
					
					System.in.read();
					
					System.out.println("Student name is:: "+student.getSname());
					System.out.println("Student address is:: "+student.getSaddress());
					
					
					
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
