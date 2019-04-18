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
		model.addAttribute(student);
		sqlSession.close();
		return "editpage";
	}
	/***
	 * �ύ�޸�
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/edit")
	private String editStuScore(HttpServletRequest request,Model model){
		if(true){
			model.addAttribute("msg","score");
			return"success";
		}else{
			return"error";
		}
	}
}
