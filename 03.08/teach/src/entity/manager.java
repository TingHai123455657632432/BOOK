package entity;

/**
 * @author：邾头肉
 * @date：2024/3/8
 */
public class manager {
    private String  maccount;
    private String mpassword;

    public String getMaccount() {
        return maccount;
    }

    public void setMaccount(String maccount) {
        this.maccount = maccount;
    }

    public String getMpassword() {
        return mpassword;
    }

    public void setMpassword(String mpassword) {
        this.mpassword = mpassword;
    }

    public manager() {
    }

    public manager(String maccount, String mpassword) {
        this.maccount = maccount;
        this.mpassword = mpassword;
    }

    @Override
    public String toString() {
        return "manager{" +
                "maccount='" + maccount + '\'' +
                ", mpassword='" + mpassword + '\'' +
                '}';
    }
}
