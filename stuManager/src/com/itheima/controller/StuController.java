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
	 * �����޸�id
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
				// ���������ļ�����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = 
		                     new SqlSessionFactoryBuilder().build(inputStream);
				// ͨ��SqlSessionFactory����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
				// SqlSessionִ��ӳ���ļ��ж����SQL��������ӳ����
		Student student = sqlSession.selectOne("com.itheima.mapper"
						  + ".StudentMapper.findinformationById",id);
		model.addAttribute("stu",student);
		sqlSession.close();
		return "editpage";
	}
	/***
	 * �ύ�޸�
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
				// ���������ļ�����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = 
		                     new SqlSessionFactoryBuilder().build(inputStream);
				// ͨ��SqlSessionFactory����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
				// SqlSessionִ��ӳ���ļ��ж����SQL��������ӳ����
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
