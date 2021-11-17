package com.covelanse.beans;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.management.modelmbean.ModelMBean;

public class Student implements Serializable, Comparable<Student> {
	int id;
	String name;
	Date dob;
	String email;
	String mobile;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String name, String strDob, String email, String mobile) throws ParseException {
		super();
		this.id = id;
		this.name = name;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		dob = sdf.parse(strDob);
		this.email = email;
		this.mobile = mobile;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		String strDob = new SimpleDateFormat("dd-MM-yyyy").format(dob);
		return "Student [id=" + id + ", name=" + name + ", dob=" + strDob + ", email=" + email + ", mobile=" + mobile
				+ "]";
	}

	public String toCSV() {
		String strDob = new SimpleDateFormat("dd-MM-yyyyy").format(dob);
		return id + ", " + name + ", " + strDob + ", " + email + ", " + mobile;
	}
	
	public static Student parseStudent(String csvStudent) throws ParseException {
		
		String[] values = csvStudent.split(",");
		int id = Integer.parseInt(values[0].trim());
		String name = values[1].trim();
		String strDob = values[2].trim();
		String email = values[3].trim();
		String mobile = values[4].trim();
		
		Student student = new Student(id, name, strDob, email, mobile);
		
		return student;
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return this.id - o.getId();
	}

}
