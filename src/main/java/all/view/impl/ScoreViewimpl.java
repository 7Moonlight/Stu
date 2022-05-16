package all.view.impl;

import all.dao.ScoreDao;
import all.dao.impl.ScoreDaoimpl;
import all.po.Score;
import all.view.ScoreView;

import java.util.Scanner;

public class ScoreViewimpl implements ScoreView {
   private Scanner input=new Scanner(System.in);
    @Override
    public void saveScore() {
        Score score=new Score();
        System.out.println("请输入学号：");
        score.setSno(input.nextInt());
        System.out.println("请输入总成绩：");
        score.setTp(input.nextInt());
        System.out.println("请输入评级：");
        score.setLevel(input.next());
        System.out.println("请输入教师姓名：");
        score.setTeacher_name(input.next());

        ScoreDao dao=new ScoreDaoimpl();
        int result= dao.saveScore(score);
        if (result>0){
            System.out.println("\n导入成绩成功！\n");
        }else {
            System.out.println("\n导入成绩失败！\n");
        }
    }
}
