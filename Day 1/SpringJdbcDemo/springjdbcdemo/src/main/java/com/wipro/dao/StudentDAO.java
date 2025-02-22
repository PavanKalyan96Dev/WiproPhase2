package com.wipro.dao;
 
import java.util.List;
 
import com.wipro.model.Student;
 
public interface StudentDAO {
 
	int saveStudent(Student student);
	int updateStudent(Student student);
	int deleteStudent(int stid);
	Student getStudentById(int stid);
	List<Student> getAllStudents();
	
}