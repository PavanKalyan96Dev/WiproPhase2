package com.wipro.daoimpl;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
 
import com.wipro.dao.StudentDAO;
import com.wipro.model.Student;
 
@Repository(value = "student")
public class StudentDAOImpl implements StudentDAO {
 
	@Autowired
	private  JdbcTemplate template;
	public int saveStudent(Student student) {

		String sql = "insert into student values(?,?,?)";
		return template.update(sql, student.getStid(),student.getStname(),student.getStaddress());
	}
 
	public int updateStudent(Student student) {
		String sql = "update student set stname=?,staddress=? where stid=?";
	    return template.update(sql,student.getStname(),student.getStaddress(),student.getStid());
	}
 
	public int deleteStudent(int stid) {
		String sql = "delete from student where stid=?";
		return template.update(sql, stid);
	}
 
	public Student getStudentById(int stid) {
		String sql ="select * from student where stid=?";
		return template.queryForObject(sql, new StudentRowMapper(), stid);
	}
 
	public List<Student> getAllStudents() {
		String sql = "select * from student";
		return template.query(sql,new StudentRowMapper());
	}

	
	
 
}