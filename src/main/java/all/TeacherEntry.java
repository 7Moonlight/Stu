package all;
import all.po.Teacher;
import all.view.ScoreView;
import all.view.SelectStudentView;
import all.view.TeacherView;
import all.view.impl.ScoreViewimpl;
import all.view.impl.SelectStudentViewimpl;
import all.view.impl.TeacherViewimpl;

import java.util.Scanner;

public class TeacherEntry {

    public void work(){
       Scanner input = new Scanner(System.in);
        System.out.println("-----------------------------------------");
        System.out.println("|\t\t\t 学生管理系统（老师端）\t\t\t|");
        System.out.println("-----------------------------------------");
        TeacherView teacherView =new TeacherViewimpl();
        Teacher teacher = teacherView.login();
        SelectStudentView selectStudentView= new SelectStudentViewimpl();
        ScoreView scoreView=new ScoreViewimpl();
        //login
        if (teacher!=null)
        {
            int menu = 0;
            while (menu != 5) {
                System.out.println("============1.查看所有学生信息==2.搜索学生==3.添加学生==4.导入成绩==5.退出系统============");
                System.out.println("请输入你的选择：");
                menu = input.nextInt();
                switch (menu) {
                    case 1 -> selectStudentView.listStudentAll();
                    case 2 -> selectStudentView.listStudent();
                    case 3 -> selectStudentView.saveStudent();
                    case 4 -> scoreView.saveScore();
                    case 5 -> System.out.println("退出成功！");
                    default -> System.out.println("没有该功能！");
                }
            }

        }
        {
            System.out.println("\n学工号或密码输入错误！\n");
        }
    }

    public static void main(String[] args) {
        new all.TeacherEntry().work();
    }
}


