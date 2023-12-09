package in.ineuron.daofactory;
import in.ineuron.dao.IStudentDao;
import in.ineuron.dao.StudentDaoImpl;



public class StudentDaoFactory {
	
	private StudentDaoFactory() {}
	
	private static IStudentDao studentDao = null;
	
	
	public static IStudentDao getStudentDao() {
		studentDao = new StudentDaoImpl();
		return studentDao;
	}
}
