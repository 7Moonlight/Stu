package all.dao.impl;

import all.dao.ScoreDao;
import all.po.Score;
import all.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ScoreDaoimpl implements ScoreDao {
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet res = null;
    @Override
    public int saveScore(Score score) {
        int resultnumber=0;
        String sql="insert into 架构_name.score value (?,?,?,?)";
        try {
            con= DBUtil.getConnection();
            pst=con.prepareStatement(sql);
            pst.setInt(1, score.getSno());
            pst.setInt(2, score.getTp());
            pst.setString(3, score.getLevel());
            pst.setString(4, score.getTeacher_name());
            resultnumber=pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(this.res,this.pst,this.con);
        }
        return resultnumber;
    }

    @Override
    public Score getScoreBySno(Integer Sno) {
        Score score=null;
        String sql="select * from 架构_name.score where Sno=?";
        try {
            con= DBUtil.getConnection();
            pst=con.prepareStatement(sql);
            pst.setInt(1,Sno);
            res=pst.executeQuery();
            while (res.next()){
                score = new Score();
                score.setSno(res.getInt("Sno"));
                score.setTp(res.getInt("tp"));
                score.setLevel(res.getString("level"));
                score.setTeacher_name(res.getString("Teacher_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(this.res,this.pst,this.con);
        }
        return score;
    }
}
