package com.cms.dao;

import java.util.List;

import com.cms.bean.Student;

public interface StudentDao {
	
	public List<Student> queryAll();
	
	public boolean insert(Student student);

}
