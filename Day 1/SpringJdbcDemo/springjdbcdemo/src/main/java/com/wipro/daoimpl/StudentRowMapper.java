package com.wipro.daoimpl;
 
import java.sql.ResultSet;
import java.sql.SQLException;
 
import org.springframework.jdbc.core.RowMapper;
 
import com.wipro.model.Student;
 
public class StudentRowMapper implements RowMapper<Student> {
 
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Student(rs.getInt("stid"),rs.getString("stname"),rs.getString("staddress"));
	}
 
}