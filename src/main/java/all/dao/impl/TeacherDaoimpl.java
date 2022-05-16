package all.dao.impl;

import all.dao.TeacherDao;
import all.po.Teacher;
import all.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherDaoimpl implements TeacherDao {
    private Connection con=null;
    private PreparedStatement pst=null;
    private ResultSet res=null;
    @Override
    public Teacher getTeacherByNoByPass(String Tno, String Tpassword) {
        Teacher teacher=null;
        String sql="select * from 架构_name.teacher where Tno=? and Tpassword=?";
        try {
            con= DBUtil.getConnection();
            pst=con.prepareStatement(sql);
            pst.setString(1,Tno);
            pst.setString(2,Tpassword);
            res=pst.executeQuery();
            while (res.next()){
                teacher=new Teacher();
                teacher.setTno(res.getString("Tno"));
                teacher.setTname(res.getString("Tname"));
                teacher.setTpassword(res.getString("Tpassword"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(this.res,this.pst,this.con);
        }
        return teacher;
    }
}
