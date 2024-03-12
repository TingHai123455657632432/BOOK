package entity;

import java.util.Date;

/**
 * @author：邾头肉
 * @date：2024/3/8
 */
public class Student {
    private int sid;
    private String sname;
    private Date sbirth;
    private String ssex;
    private String saccount;
    private String spassword;
    private String saddress;

    public Student() {
    }

    public Student(String sname, Date sbirth, String ssex, String saccount, String spassword, String saddress) {
        this.sname = sname;
        this.sbirth = sbirth;
        this.ssex = ssex;
        this.saccount = saccount;
        this.spassword = spassword;
        this.saddress = saddress;
    }

    public Student(int sid, String sname, Date sbirth, String ssex, String saccount, String spassword, String saddress) {
        this.sid = sid;
        this.sname = sname;
        this.sbirth = sbirth;
        this.ssex = ssex;
        this.saccount = saccount;
        this.spassword = spassword;
        this.saddress = saddress;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Date getSbirth() {
        return sbirth;
    }

    public void setSbirth(Date sbirth) {
        this.sbirth = sbirth;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public String getSaccount() {
        return saccount;
    }

    public void setSaccount(String saccount) {
        this.saccount = saccount;
    }

    public String getSpassword() {
        return spassword;
    }

    public void setSpassword(String spassword) {
        this.spassword = spassword;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", sbirth=" + sbirth +
                ", ssex='" + ssex + '\'' +
                ", saccount='" + saccount + '\'' +
                ", spassword='" + spassword + '\'' +
                ", saddress='" + saddress + '\'' +
                '}';
    }
}
