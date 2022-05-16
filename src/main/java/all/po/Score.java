package all.po;

public class Score {
    private Integer Sno;
    private Integer tp;
    private String level;
    private String Teacher_name;

    public Integer getSno() {
        return Sno;
    }

    public void setSno(Integer sno) {
        Sno = sno;
    }

    public Integer getTp() {
        return tp;
    }

    public void setTp(Integer tp) {
        this.tp = tp;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getTeacher_name() {
        return Teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        Teacher_name = teacher_name;
    }

    @Override
    public String toString() {
        return "学号：" + this.Sno +
                "总成绩：" + this.tp +
                "评级：" + this.level +
                "教师：" + this.Teacher_name
                ;
    }
}
