package cn.tedu.pojo;

import java.util.List;

/**
 * @author Aim_Liu
 * @create 2021-07-21-23:50
 */
public class OneStation {
    Integer stationId;
    Integer num;

    public OneStation(Integer stationId, Integer num) {
        this.stationId = stationId;
        this.num = num;
    }

    @Override
    public String toString() {
        return "OneStation{" +
                "stationId=" + stationId +
                ", num=" + num +
                '}';
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
