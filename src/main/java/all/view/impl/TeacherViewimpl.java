package all.view.impl;

import all.dao.TeacherDao;
import all.dao.impl.TeacherDaoimpl;
import all.po.Teacher;
import all.view.TeacherView;

import java.util.Scanner;

public class TeacherViewimpl implements TeacherView {
    private final Scanner input =new Scanner(System.in);
    @Override
    public Teacher login() {
        System.out.print("请输入学工号：");
        String Tno = input.next();
        System.out.print("请输入密码：");
        String Tpassword = input.next();
        TeacherDao dao =new TeacherDaoimpl();
        return dao.getTeacherByNoByPass(Tno,Tpassword);
    }
}
