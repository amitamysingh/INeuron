package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.utility.HibernateUtil;

public class DeleteApp2 {

	public static void main(String[] args) throws IOException {
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		
		try {
			
			session= HibernateUtil.getSession();
			int id=99;
			Student student=session.get(Student.class, id);
			if(session != null) {
				transaction=session.beginTransaction();
				
				
				if(transaction != null) {
					if(student != null) {
						session.delete(student);
						flag=true;
					}else {
						System.out.println("Record not available for deletion for id:: "+id);
					}
										
					
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
			if(flag) {
				System.in.read();
				transaction.commit();
				System.out.println("Data is loaded to Database");
			}else {
				transaction.rollback();
				System.out.println("Data is not loaded to Database");
			}
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}

}
