package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.utility.HibernateUtil;

public class SaveOrUpdateApp {

	public static void main(String[] args) throws IOException {
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		
		try {
			
			session= HibernateUtil.getSession();
			Student student=session.get(Student.class, 7);
			
			if(session != null) {
				transaction=session.beginTransaction();
				
				
				if(transaction != null) {
					
					//Entity setter method used is
					student.setSaddress("PSW");
					
					//Following Update query is generated for Dynamic Update
					//Update student set Saddress = ? where stdId = ?
					//Otherwise, update student set sname = ?, saddress = ? where stdId = ? 
					session.update(student);		
					flag=true;
					
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
