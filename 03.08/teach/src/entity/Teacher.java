package entity;

/**
 * @author：邾头肉
 * @date：2024/3/8
 */
public class Teacher {
    private int tid;
    private String tname;
    private String taccount;
    private String tpassword;
    private String tphone;

    public Teacher() {
    }
    public Teacher(String tname, String taccount, String tpassword, String tphone) {
        this.tname = tname;
        this.taccount = taccount;
        this.tpassword = tpassword;
        this.tphone = tphone;
    }
    public Teacher(int tid, String tname, String taccount, String tpassword, String tphone) {
        this.tid = tid;
        this.tname = tname;
        this.taccount = taccount;
        this.tpassword = tpassword;
        this.tphone = tphone;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTaccount() {
        return taccount;
    }

    public void setTaccount(String taccount) {
        this.taccount = taccount;
    }

    public String getTpassword() {
        return tpassword;
    }

    public void setTpassword(String tpassword) {
        this.tpassword = tpassword;
    }

    public String getTphone() {
        return tphone;
    }

    public void setTphone(String tphone) {
        this.tphone = tphone;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", taccount='" + taccount + '\'' +
                ", tpassword='" + tpassword + '\'' +
                ", tphone='" + tphone + '\'' +
                '}';
    }
}
