package in.ineuron.dao;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import in.ineuron.model.StudentBO;
import in.ineuron.util.HibernateUtil;



public class StudentDaoImpl implements IStudentDao {
	
	Session session = HibernateUtil.getSession();

	
	@Override
	public List<StudentBO> getAllStudents() {
		
		List<StudentBO> resultList = null;
		
		try {
			
			Query<StudentBO> query = session.createQuery("from in.ineuron.model.StudentBO");
			
			resultList = query.getResultList();
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		
		return resultList;
	}

}
