package entity;

/**
 * @author：邾头肉
 * @date：2024/3/8
 */
public class Course {
    private int cid;
    private String cname;
    private String tid;

    public Course(String cname, String tid) {
        this.cname = cname;
        this.tid = tid;
    }

    public Course() {
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public Course(int cid, String cname, String tid) {
        this.cid = cid;
        this.cname = cname;
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", tid='" + tid + '\'' +
                '}';
    }
}
