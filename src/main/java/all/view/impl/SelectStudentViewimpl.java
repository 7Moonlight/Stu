package all.view.impl;

import all.dao.StudentInformationDao;
import all.dao.impl.StudentInformationDaoimpl;
import all.po.Student;
import all.view.SelectStudentView;

import java.util.List;
import java.util.Scanner;

public class SelectStudentViewimpl implements SelectStudentView {
    Scanner input =new Scanner(System.in);
    @Override
    public void listStudentAll() {
        StudentInformationDao dao =new StudentInformationDaoimpl();
        List<Student> list = dao.listStudent(null ,null);
        System.out.println("学号\t姓名\t性别\t年龄\t学院\t");
        for (Student s : list) {
            System.out.println(s.getSno() + "\t" + s.getSname() + "\t" + s.getSsex() + "\t" + s.getSage() + "\t" + s.getSdept() + "\t");
        }
    }

    @Override
    public void listStudent() {
        String Sno=null;
        String Sname=null;
        int inputStr;
        System.out.println("1.学号精准查询");
        System.out.println("2.姓名查询");
        inputStr=input.nextInt();
        switch (inputStr) {
            case 1 -> {
                System.out.println("请输入学号：");
                Sno = input.next();
            }
            case 2 -> {
                System.out.println("请输入姓名关键字：");
                Sname = input.next();
            }
            default -> System.out.println("没有该选项！");
        }
        StudentInformationDao dao=new StudentInformationDaoimpl();
        List<Student> list=dao.listStudent(Sno,Sname);
        System.out.println("学号\t\t\t姓名\t\t性别\t\t年龄\t\t学院\t\t");
        for (Student s : list) {
            System.out.println(s.getSno() + "\t" + s.getSname() + "\t" + s.getSsex() + "\t" + s.getSage() + "\t" + s.getSdept() + "\t");
        }


    }

    @Override
    public void saveStudent() {
        System.out.println("输入学生姓名：");
        String Sname=input.next();
        StudentInformationDao dao=new StudentInformationDaoimpl();
        Integer Sno=dao.saveStudent(Sname);
        if (Sno>0){
            System.out.println("添加成功！\n学生学号为："+Sno+"\n默认密码为：123456");
        }else{
            System.out.println("添加失败！");
        }

    }
}
