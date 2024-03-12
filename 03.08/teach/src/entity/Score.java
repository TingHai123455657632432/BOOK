package entity;

/**
 * @author：邾头肉
 * @date：2024/3/8
 */
public class Score {
    private int sid;
    private int cid;
    private int score;

    public Score(int sid, int cid, int score) {
        this.sid = sid;
        this.cid = cid;
        this.score = score;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "sid=" + sid +
                ", cid=" + cid +
                ", score=" + score +
                '}';
    }
}
