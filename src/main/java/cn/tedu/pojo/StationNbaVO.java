package cn.tedu.pojo;

import java.util.List;

/**
 * @author Aim_Liu
 * @create 2021-07-16-15:30
 */
public class StationNbaVO {
    //封装前端折线图X轴数据
    private List<String> xData;
    private List<Integer> yData;

    public StationNbaVO(List<String> xData, List<Integer> yData) {
        this.xData = xData;
        this.yData = yData;
    }

    @Override
    public String toString() {
        return "StationNbaVO{" +
                "xData=" + xData +
                ", yData=" + yData +
                '}';
    }

    public List<String> getxData() {
        return xData;
    }

    public void setxData(List<String> xData) {
        this.xData = xData;
    }

    public List<Integer> getyData() {
        return yData;
    }

    public void setyData(List<Integer> yData) {
        this.yData = yData;
    }
}
