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
		model.addAttribute(student);
		sqlSession.close();
		return "editpage";
	}
	/***
	 * 提交修改
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
