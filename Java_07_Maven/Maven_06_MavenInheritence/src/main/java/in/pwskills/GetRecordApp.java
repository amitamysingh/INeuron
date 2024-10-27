package in.pwskills;

import in.pwskills.hibernateUtil.HibernateUtil;
import in.pwskills.model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class GetRecordApp {


    public static void main(String[] args) {
        Session session = null;

        int id=1;
        try{

            session= HibernateUtil.getSession();
            if(session != null){
                Student student = session.get(Student.class, id);
                if(student != null)
                    System.out.println(student);
                else
                    System.out.println("Student not found");
            }
        }catch(HibernateException he){
            System.out.println("Hibernate Exception");
            he.printStackTrace();
        }catch(Exception e){
            System.out.println("Exception found");
            e.printStackTrace();
        }finally {
            HibernateUtil.closeSession(session);
            HibernateUtil.closeSessionFactory();
        }
    }
}
