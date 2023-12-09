package in.ineuron.servicefactory;
import in.ineuron.service.IStudentService;
import in.ineuron.service.StudentServiceImpl;


//factory design pattern(Singleton)::
public class StudentServiceFactory {
	
	private static IStudentService studentService = null;
	
	private StudentServiceFactory() {}
	
	public static IStudentService getStudentService() {
		studentService = new StudentServiceImpl();
		return studentService;
	}
	
}
