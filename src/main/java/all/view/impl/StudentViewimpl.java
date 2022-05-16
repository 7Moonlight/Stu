package all.view.impl;

import all.dao.ScoreDao;
import all.dao.StudentDao;
import all.dao.impl.ScoreDaoimpl;
import all.dao.impl.StudentDaoimpl;
import all.po.Score;
import all.po.Student;
import all.view.StudentView;

import java.util.Scanner;

public class StudentViewimpl implements StudentView {
    private final Scanner input =new Scanner(System.in);
    @Override
    public Student login() {
        System.out.print("请输入学工号：");
        Integer Sno = Integer.valueOf(input.next());
        System.out.print("请输入密码：");
        String Spassword = input.next();
        StudentDao dao =new StudentDaoimpl();
        return dao.getStudentByNoByPass(Sno,Spassword);
    }

    @Override
    public void showStudnet(Integer Sno) {
        StudentDao dao=new StudentDaoimpl();
        Student student = dao.getStudentBySno(Sno);
        System.out.println(student);

    }

    @Override
    public void editStudent(Integer Sno) {
        StudentDao dao=new StudentDaoimpl();
        Student student=dao.getStudentBySno(Sno);
        System.out.println(student);
        String inputstr="";
        System.out.println("是否修改性别（y/n）");
        inputstr=input.next();
        if (inputstr.equals("y")){
            System.out.println("请输入性别：");
            student.setSsex(input.next());
        }
        System.out.println("是否修改年龄（y/n）");
        inputstr=input.next();
        if (inputstr.equals("y")){
            System.out.println("请输入年龄：");
            student.setSage(input.nextInt());
        }
        System.out.println("是否修改学院（y/n）");
        inputstr=input.next();
        if (inputstr.equals("y")){
            System.out.println("请输入学院：");
            student.setSdept(input.next());
        }
        System.out.println("是否修改密码（y/n）");
        inputstr=input.next();
        if (inputstr.equals("y")){
            System.out.println("请输入新密码：");
            student.setSpassword(input.next());
        }else{
            student.setSpassword("1234562");
        }
        int result=dao.updataInformation(student);
        if (result>0){
            System.out.println("修改成功！");
        }else{
            System.out.println("修改失败！");
        }
    }

    @Override
    public void showScore(Integer Sno) {
        ScoreDao dao =new ScoreDaoimpl();
        Score score= dao.getScoreBySno(Sno);
        System.out.println(score);
    }

}
