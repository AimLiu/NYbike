package cn.tedu.pojo;

import java.util.List;

/**
 * @author Aim_Liu
 * @create 2021-07-22-20:54
 */
public class RepaireVO {
    List<Integer> sid;
    List<Integer> repaireNum;

    @Override
    public String toString() {
        return "RepaireVO{" +
                "sid=" + sid +
                ", repaireNum=" + repaireNum +
                '}';
    }

    public RepaireVO(List<Integer> sid, List<Integer> repaireNum) {
        this.sid = sid;
        this.repaireNum = repaireNum;
    }

    public List<Integer> getSid() {
        return sid;
    }

    public void setSid(List<Integer> sid) {
        this.sid = sid;
    }

    public List<Integer> getRepaireNum() {
        return repaireNum;
    }

    public void setRepaireNum(List<Integer> repaireNum) {
        this.repaireNum = repaireNum;
    }
}
