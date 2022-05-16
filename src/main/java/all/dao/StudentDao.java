package all.dao;

import all.po.Student;

public interface StudentDao {
    Student getStudentByNoByPass(Integer Sno, String Spassword);
    Student getStudentBySno(Integer Sno);
    int updataInformation(Student student);
}
