package com.itheima.controller;

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

import com.itheima.po.Student;

@Controller
public class StuController {
	/***
	 * 接收修改id
	 * @param id
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/editpage")
	public String editpage(Integer id,Model model) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = 
		                    Resources.getResourceAsStream(resource);
				// 根据配置文件构建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = 
		                     new SqlSessionFactoryBuilder().build(inputStream);
				// 通过SqlSessionFactory创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
				// SqlSession执行映射文件中定义的SQL，并返回映射结果
		Student student = sqlSession.selectOne("com.itheima.mapper"
						  + ".StudentMapper.findinformationById",id);
		model.addAttribute("stu",student);
		sqlSession.close();
		return "editpage";
	}
	/***
	 * 提交修改
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
		String resource = "mybatis-config.xml";
		InputStream inputStream = 
		                    Resources.getResourceAsStream(resource);
				// 根据配置文件构建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = 
		                     new SqlSessionFactoryBuilder().build(inputStream);
				// 通过SqlSessionFactory创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
				// SqlSession执行映射文件中定义的SQL，并返回映射结果
		if(score!=score1 && score1!=null) {
			Student stu=new Student();
			stu.setId(id);
			stu.setScore(score1);
			student = sqlSession.update("com.itheima.mapper"
							  + ".StudentMapper.updateScore",stu);
			sqlSession.close();

		}
		System.out.println(student);
		
		if(true){
			return"edit_stuscore";
		}else{
			return"error";
		}
		
	}
}
