package all;

import all.po.Student;
import all.view.StudentView;
import all.view.impl.StudentViewimpl;

import java.util.Scanner;

public class StudentEntry {
    public void S_work(){
        Scanner input = new Scanner(System.in);
        System.out.println("-----------------------------------------");
        System.out.println("|\t\t\t 学生管理系统（学生端）\t\t\t|");
        System.out.println("-----------------------------------------");
        StudentView studentView=new StudentViewimpl();
        Student student=studentView.login();
        if (student!=null)
        {
            int menu = 0;
            while (menu != 4) {
                System.out.println("============1.查看个人信息==2.修改个人信息==3.查看成绩==4.退出系统============");
                System.out.println("请输入你的选择：");
                menu = input.nextInt();
                switch (menu) {
                    case 1 -> studentView.showStudnet(student.getSno());
                    case 2 -> studentView.editStudent(student.getSno());
                    case 3 -> studentView.showScore(student.getSno());
                    case 4 -> System.out.println("退出成功！");
                    default -> System.out.println("没有该功能！");
                }
            }

        }
        else{
            System.out.println("\n学工号或密码输入错误！\n");
        }
    }
    public static void main(String[] args) {
        new all.StudentEntry().S_work();
    }

}

