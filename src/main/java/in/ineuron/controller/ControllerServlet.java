package in.ineuron.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.ineuron.model.StudentDTO;
import in.ineuron.model.StudentVO;
import in.ineuron.service.IStudentService;
import in.ineuron.servicefactory.StudentServiceFactory;


@WebServlet("/search")
public class ControllerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IStudentService studentService = StudentServiceFactory.getStudentService();
		
		List<StudentDTO> students = studentService.findAllStudents();
		System.out.println(students);
		
		List<StudentVO> studentVOList =  new ArrayList<StudentVO>();
		
		
		for (StudentDTO studentDTO : students) {
			
			StudentVO studentVO = new StudentVO();
			
			studentVO.setSid(studentDTO.getSid().toString());
			studentVO.setSname(studentDTO.getSname());
			studentVO.setSage(studentDTO.getSage().toString());
			studentVO.setSaddress(studentDTO.getSaddress());
			
			studentVOList.add(studentVO);
		}
		
		System.out.println(studentVOList);
		
		request.setAttribute("studentVO", studentVOList);
		RequestDispatcher rd = request.getRequestDispatcher("./disp.jsp");
		rd.forward(request, response);
		
	}

}
