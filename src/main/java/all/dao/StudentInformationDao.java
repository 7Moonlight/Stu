package all.dao;

import all.po.Student;

import java.util.List;

public interface StudentInformationDao {
    List<Student> listStudent(String Sno,String Sname);
    Integer saveStudent(String Sname);

}
