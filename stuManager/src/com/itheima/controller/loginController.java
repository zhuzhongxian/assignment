package com.itheima.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itheima.po.Student;

@Controller
public class loginController {
	@RequestMapping(value="/login")
	private String login(HttpServletRequest request){
		return "login";
	}
	
	@RequestMapping(value="/toEditStuScore")
	private String toEditStuScore(Student stu,Model model) throws IOException{
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
						  + ".StudentMapper.findpasswordBystuname",stu.getStuname());
		System.out.println(student.getStuname());
		System.out.println(student.getPassword());
		System.out.println(stu.getStuname());
		System.out.println(stu.getPassword());
		String stupassword=stu.getPassword();
		String studentpassword=stu.getPassword();
		if(studentpassword!=null && stupassword==studentpassword) {
			model.addAttribute(student);
			return "edit_stuscore";
		}
		else {
			return "login";
		}
	}
}
