package all.dao.impl;

import all.dao.StudentDao;
import all.po.Student;
import all.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

    public class StudentDaoimpl implements StudentDao {
    private Connection con=null;
    private PreparedStatement pst=null;
    private ResultSet res=null;
    @Override
    public Student getStudentByNoByPass(Integer Sno, String Spassword) {
        Student student=null;
        String sql="select * from 架构_name.student where Sno=? and Spassword=?";
        try {
            con= DBUtil.getConnection();
            pst=con.prepareStatement(sql);
            pst.setInt(1,Sno);
            pst.setString(2,Spassword);
            res=pst.executeQuery();
            while (res.next()){
                student=new Student();
                student.setSno(res.getInt("Sno"));
                student.setSpassword(res.getString("Spassword"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(this.res,this.pst,this.con);
        }
        return student;
    }

        @Override
        public Student getStudentBySno(Integer Sno) {
            Student student=null;
            String sql="select * from 架构_name.student where Sno=? ";
            try {
                con= DBUtil.getConnection();
                pst=con.prepareStatement(sql);
                pst.setInt(1,Sno);
                res=pst.executeQuery();
                while (res.next()){
                    student = new Student();
                    student.setSno(res.getInt("Sno"));
                    student.setSname(res.getString("Sname"));
                    student.setSsex(res.getString("Ssex"));
                    student.setSage(res.getInt("Sage"));
                    student.setSdept(res.getString("Sdept"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                DBUtil.close(this.res,this.pst,this.con);
            }
            return student;
        }

        @Override
        public int updataInformation(Student student) {
            int result=0;
            String sql="update 架构_name.student set Ssex=?,Sage=?,Sdept=?,Spassword=? where Sno=?";
            try {
                con= DBUtil.getConnection();
                pst=con.prepareStatement(sql);
                pst.setString(1,student.getSsex());
                pst.setInt(2,student.getSage());
                pst.setString(3, student.getSdept());
                pst.setString(4, student.getSpassword());
                pst.setInt(5, student.getSno());
                result=pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                DBUtil.close(this.res,this.pst,this.con);
            }
            return result;

        }

    }
