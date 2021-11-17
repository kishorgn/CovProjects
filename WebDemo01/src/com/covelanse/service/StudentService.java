package com.covelanse.service;

import java.util.List;

import com.covelanse.beans.Student;

public interface StudentService {
	
	boolean save(Student student) ;
	Student find (int id) ;
	List<Student> findAll() ;
	boolean update(Student student) ;
	boolean delete(int id) ;

}
