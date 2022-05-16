package all.dao;

import all.po.Score;

public interface ScoreDao {
    int saveScore(Score score);
    Score getScoreBySno(Integer Sno);
}
