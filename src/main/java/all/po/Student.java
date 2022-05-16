package all.po;

public class Student {
    private Integer  Sno;
    private String  Sname;
    private String  Ssex;
    private Integer  Sage;
    private String  Sdept;
    private String Spassword;
    @Override
    public String toString(){
        return "学号："+this.Sno+
                "姓名："+this.Sname+
                "性别："+this.Ssex+
                "年龄："+this.Sage+
                "学院："+this.Sdept
                ;
    }

    public Integer getSno() {
        return Sno;
    }

    public void setSno(Integer sno) {
        Sno = sno;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getSsex() {
        return Ssex;
    }

    public void setSsex(String ssex) {
        Ssex = ssex;
    }

    public Integer getSage() {
        return Sage;
    }

    public void setSage(Integer sage) {
        Sage = sage;
    }

    public String getSdept() {
        return Sdept;
    }

    public void setSdept(String sdept) {
        Sdept = sdept;
    }

    public String getSpassword() {
        return Spassword;
    }

    public void setSpassword(String spassword) {
        Spassword = spassword;
    }
}
