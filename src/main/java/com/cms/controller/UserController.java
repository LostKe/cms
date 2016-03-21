package com.cms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cms.bean.Student;
import com.cms.bean.User;
import com.cms.dao.StudentDao;

@Controller
public class UserController {
	
	@Autowired
	private StudentDao studentDao;
	
	@RequestMapping("showUser.do")
	public ModelAndView showUser(ModelMap model,HttpServletRequest request){
		User user=new User("KE", 12, "ShenZhen");
		model.put("user", user);
		Student s=new Student();
		s.setName("aaaaa");
		s.setAge(10);
		s.setSex(1);
		return new ModelAndView("index", model);
	}
	
	@RequestMapping("showStudent.do")
	public ModelAndView showStudent(ModelMap model,HttpServletRequest request){
		List<Student> students=studentDao.queryAll();
		model.put("students", students);
		return new ModelAndView("student", model);
	}
	
	@RequestMapping(value="getStudent.do",produces = "text/plain;charset=UTF-8")
	@ResponseBody()
	public String getStudent(HttpServletRequest request){
		List<Student> students=studentDao.queryAll();
		JSONObject result=new JSONObject();
		result.put("result", true);
		result.put("value", JSON.toJSON(students));
		return result.toJSONString();
	}
	
	
	
	
	

}
