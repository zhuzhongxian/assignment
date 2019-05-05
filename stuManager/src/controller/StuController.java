package controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
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
public class StuController {
	/***
	 * Get id
	 * @param id
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/editpage")
	public String editpage(Integer id,Model model) throws IOException {
		SqlSession sqlsession =MybatisUtils.getSession();
		Student student = sqlsession.selectOne("mapper"
						  + ".StudentMapper.findinformationById",id);
		model.addAttribute("stu",student);
		sqlsession.close();
		return "editpage";
	}
	/***
	 * Commit Edit
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/edit")
	private String editStuScore(HttpServletRequest request,Model model) throws IOException{
		int student=0;
		Integer id=Integer.parseInt(request.getParameter("id"));
		Double score=Double.parseDouble(request.getParameter("score"));
		Double score1=Double.parseDouble(request.getParameter("score1"));
		SqlSession sqlsession =MybatisUtils.getSession();
		if(score!=score1 && score1!=null) {
			Student stu=new Student();
			stu.setId(id);
			stu.setScore(score1);
			student = sqlsession.update("mapper"
							  + ".StudentMapper.updateScore",stu);
		}
		if(student==1){
			Student data= sqlsession.selectOne("mapper"
					  + ".StudentMapper.findinformationById",id);
			model.addAttribute("stu",data);
			sqlsession.close();
			return"edit_stuscore";
		}else{
			return"error";
		}
		
	}
}
