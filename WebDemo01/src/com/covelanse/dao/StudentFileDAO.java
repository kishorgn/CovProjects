package com.covelanse.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.covelanse.beans.Student;

public class StudentFileDAO implements DAO<Student> {

	@Override
	public boolean save(Student e) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		boolean res = false;
		
		ArrayList<Student> students = new ArrayList<>();
		File file = new File("student.dat");
		System.out.println("Inside of saving");
		if (file.exists()) {

			System.out.println("File existing");

			FileInputStream fis = null;
			ObjectInputStream ois = null;
			try {
				fis = new FileInputStream(file);
				ois = new ObjectInputStream(fis);
				while (fis.available() > 0) {
					Student s = (Student) ois.readObject();
					students.add(s);
					System.out.println("Reading student " + s.getId() + " into ArrayList");
				}
				file.delete();
			} finally {
				ois.close();
			}
		}

//			file.createNewFile();
		System.out.println("Creating file again");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(file, false);
			oos = new ObjectOutputStream(fos);

			students.add(e);

			for (Student student : students) {
				oos.writeObject(student);
				System.out.println("Writing " + student.getId() + " into file");
			}
			
			res = true;
			
		} finally {
			oos.close();
		}

		return res;
	}

	@Override
	public boolean edit(Student e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Student find(int id) throws IOException, FileNotFoundException, ClassNotFoundException {
		Student std = null;
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		TreeMap<Integer, Student> studentMap = new TreeMap<>();
		
		try {
			fis = new FileInputStream("student.dat");
			ois = new ObjectInputStream(fis);
			
			while(fis.available() > 0) {
				Student student = (Student)ois.readObject();
				studentMap.put(student.getId(), student);
			}
			
		}
		finally {
			ois.close();
		}
		std = studentMap.get(id) ;
		
		return std;
	}

	@Override
	public List<Student> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
