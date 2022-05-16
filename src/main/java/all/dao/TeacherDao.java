package all.dao;

import all.po.Teacher;

public interface TeacherDao {
    Teacher getTeacherByNoByPass(String Tno, String Tpassword);
}
