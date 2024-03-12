package entity;

/**
 * @author：邾头肉
 * @date：2024/3/8
 */
public class Class1 {
    private String cname;
    private int tid;
    private int sid;

    public Class1() {
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cnmae) {
        this.cname = cnmae;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public Class1(String cnmae, int tid, int sid) {
        this.cname = cnmae;
        this.tid = tid;
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "Class{" +
                "cnmae='" + cname + '\'' +
                ", tid=" + tid +
                ", sid=" + sid +
                '}';
    }
}
