package all.dao.impl;

import all.po.Student;
import all.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentInformationDaoimpl implements all.dao.StudentInformationDao {
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet res = null;

    @Override
    public List<Student> listStudent(String Sno,String Sname) {
        List<Student> list = new ArrayList();
        StringBuilder sql=new StringBuilder("select * from  架构_name.student s where 1=1 ");
        if (Sno!=null&&!Sno.equals("")){
            sql.append("and s.Sno='").append(Sno).append("'");
        }
        if (Sname!=null&&!Sname.equals("")){
            sql.append("and s.Sname like '%").append(Sname).append("%'");
        }
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(String.valueOf(sql));
            res = pst.executeQuery();
            while (res.next()) {
                Student student = new Student();
                student.setSno(res.getInt("Sno"));
                student.setSname(res.getString("Sname"));
                student.setSsex(res.getString("Ssex"));
                student.setSage(res.getInt("Sage"));
                student.setSdept(res.getString("Sdept"));
                student.setSpassword(res.getString("Spassword"));
                list.add(student);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(this.res, this.pst, this.con);
        }
        return list;
    }
    @Override
    public Integer saveStudent(String Sname) {
        Integer Snumber=0;
        String sql="insert into student (Sname) value (?)";
        try {
            con= DBUtil.getConnection();
            pst=con.prepareStatement(sql);
            pst=con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1,Sname);
            pst.executeUpdate();
            res=pst.getGeneratedKeys();
            if (res.next()){
                Snumber=res.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(this.res,this.pst,this.con);
        }
        return Snumber;
    }
}
