package in.ineuron.service;
import java.util.ArrayList;
import java.util.List;
import in.ineuron.dao.IStudentDao;
import in.ineuron.daofactory.StudentDaoFactory;
import in.ineuron.model.StudentBO;
import in.ineuron.model.StudentDTO;


public class StudentServiceImpl implements IStudentService {
	
	private IStudentDao studentDao = null;

	@Override
	public List<StudentDTO> findAllStudents() {
		
		studentDao = StudentDaoFactory.getStudentDao();
		
		List<StudentBO> students = studentDao.getAllStudents();
		
		List<StudentDTO> studentDTOList = new ArrayList<StudentDTO>();
		
		for (StudentBO studentBO : students) {
			
			StudentDTO student = new StudentDTO();
			
			student.setSid(studentBO.getSid());
			student.setSname(studentBO.getSname());
			student.setSage(studentBO.getSage());
			student.setSaddress(studentBO.getSaddress());
			
			studentDTOList.add(student);
		}
		
		return studentDTOList;
	}

}
