package com.wipro;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.wipro.config.Myconfig;
import com.wipro.dao.StudentDAO;
import com.wipro.model.Student;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Myconfig.class);
        
        // ✅ Use interface instead of implementation class
        StudentDAO dao = context.getBean(StudentDAO.class);

        /* Uncomment if needed
        int x = dao.saveStudent(new Student(24, "pavan", "kadiri"));
        System.out.println(x + " rows inserted");

        int y = dao.updateStudent(new Student(100, "kalyan", "kdr"));
        System.out.println(y + " rows updated");

        int z = dao.deleteStudent(100);
        System.out.println(z + " rows deleted");
        */

        Student student = dao.getStudentById(100);
        System.out.println(student.getStid() + " " + student.getStname() + " " + student.getStaddress());
        
        System.out.println("==========");
        List<Student> students=dao.getAllStudents();
        for(Student st:students)
        {
        	System.out.println(st.getStid()+""+st.getStname()+""+st.getStaddress());
        }
        
    }
}
