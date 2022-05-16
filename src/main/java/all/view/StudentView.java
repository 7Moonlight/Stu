package all.view;

import all.po.Student;

public interface StudentView {
    Student login();
    void  showStudnet(Integer Sno);
    void editStudent(Integer Sno);
    void  showScore(Integer Sno);

}
