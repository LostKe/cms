package com.cms.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cms.bean.Student;
import com.cms.dao.StudentDao;

@Repository
public class StudentDaoImpl implements StudentDao{

	@Autowired
	private SqlSession session;
	
	public List<Student> queryAll() {
		StudentDao  mapper=session.getMapper(StudentDao.class);
		return mapper.queryAll();
	}

}
