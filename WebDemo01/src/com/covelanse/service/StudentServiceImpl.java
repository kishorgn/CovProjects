package com.covelanse.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.covelanse.beans.Student;
import com.covelanse.dao.StudentJdbcDAO;
import com.covelanse.exception.StudentException;

public class StudentServiceImpl implements StudentService {
	
	StudentJdbcDAO studentJdbcDAO ;
	public StudentServiceImpl() throws StudentException {
		// TODO Auto-generated constructor stub
		try {
			studentJdbcDAO = new StudentJdbcDAO();
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			StudentException studentException = new StudentException("File Not Found");
			throw studentException;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			StudentException studentException = new StudentException("Class Not Found");
			throw studentException;
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			StudentException studentException = new StudentException("Some thing went wrong in IO");
			throw studentException;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			StudentException studentException = new StudentException("Some thing went wrong in SQL");
			throw studentException;
		}
		
	}

	@SuppressWarnings("finally")
	@Override
	public boolean save(Student student) {
		// TODO Auto-generated method stub
		boolean res = false;
		try {
			res = studentJdbcDAO.save(student);
			if(res) {
				studentJdbcDAO.save();
			}
			
		} 
		
		// In every catch block use the log.error() to log the error into log file and rethrow the exception,
		// as user defined exception
		catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			StudentException studentException = new StudentException("Some thing went wrong in SQL");
			throw studentException;
		}
		finally {
			return res;
		}
		
	}

	@Override
	public Student find(int id) {
		Student student = null;
		try {
			student = studentJdbcDAO.find(id);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return student;
	}

	@Override
	public List<Student> findAll() {
		List<Student> students = null;
		try {
			students = studentJdbcDAO.findAll();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
	}

	@Override
	public boolean update(Student student) {
		boolean res = false;
		try {
			res = studentJdbcDAO.edit(student);
			if(res) {
				studentJdbcDAO.save();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		boolean res = false;
		try {
			res = studentJdbcDAO.delete(id);
			if(res) {
				studentJdbcDAO.save();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
