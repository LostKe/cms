package com.cms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cms.annotation.AuthPassport;
import com.cms.bean.Student;
import com.cms.bean.User;
import com.cms.dao.StudentDao;

@Controller 
public class UserController {
	
	@Autowired
	private StudentDao studentDao;
	/***
	 * 
	 *ModelAttribute 有三个作用
	 *1.作为方法的参数：
	 *2.在方法上：该Controller的所有方法在调用前，先执行此@ModelAttribute方法。 
	 *3.
	 */
	@ModelAttribute("remote")
	public String getRemote(){//执行controller中每一个方法前都会执行该方法，在前台页面可以获取到值
		return "core";
	}
	
	@RequestMapping("showUser")
	public ModelAndView showUser(ModelMap model,@RequestParam("userName")String userName,@RequestParam("age")int age
			,@RequestParam(value="addr",required=false)String addr){
		User user=new User(userName, age, addr);
		model.put("user", user);
		return new ModelAndView("index", model);
	}
	
	@RequestMapping("showStudent.do")
	public ModelAndView showStudent(ModelMap model,HttpServletRequest request){
		List<Student> students=studentDao.queryAll();
		model.put("students", students);
		return new ModelAndView("student", model);
	}
	
	@AuthPassport
	@RequestMapping("getStudent.do")@ResponseBody()
	public JSONObject getStudent(HttpServletRequest request){
		List<Student> students=studentDao.queryAll();
		JSONObject result=new JSONObject();
		result.put("result", true);
		result.put("value", JSON.toJSON(students));
		return result;
	}
	
	@RequestMapping("test/{id}")//路径当做变量
	@ResponseBody
	public JSONObject test(@PathVariable String id,@RequestParam String value){
		JSONObject result=new JSONObject();
		result.put("result", true);
		result.put("id", id);
		result.put("value", value);
		return result;
	}
	
	
	

}
