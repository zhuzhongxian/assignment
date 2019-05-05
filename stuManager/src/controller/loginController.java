package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import po.Student;
import utils.MybatisUtils;
/***
 * 
 * @author Zeno
 *
 */
@Controller
public class loginController {
	@RequestMapping(value="/login")
	private String login(HttpServletRequest request){
		return "login";
	}
	/***
	 * Login
	 * @param stu
	 * @param model
	 * @param session
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/toEditStuScore")
	private String toEditStuScore(Student stu,Model model,HttpSession session) throws IOException{
		SqlSession sqlsession =MybatisUtils.getSession();
		List<Student> students = sqlsession.selectList("mapper"
						  + ".StudentMapper.findUser");
		if(students.contains(stu)) {
			Student student = sqlsession.selectOne("mapper"
					  + ".StudentMapper.findinformationByUsername",stu.getStuname());
			model.addAttribute("stu",student);
			session.setAttribute("STUDENT_SESSION",stu);
			return "edit_stuscore";
		}
		else {
			return "login";
		}
	}
	
	/***
	 * Logout
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login";
	}
}
