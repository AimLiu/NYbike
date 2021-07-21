package cn.tedu.pojo;

import java.util.List;

/**
 * @author Aim_Liu
 * @create 2021-07-20-21:34
 */
public class DistributeVO {
    //封装折线图
    List<Integer> xData;//性别
    List<Integer> yData;//次数

    @Override
    public String toString() {
        return "DistributeVO{" +
                "xData=" + xData +
                ", yData=" + yData +
                '}';
    }

    public DistributeVO() {
    }

    public DistributeVO(List<Integer> xData, List<Integer> yData) {
        this.xData = xData;
        this.yData = yData;
    }

    public List<Integer> getxData() {
        return xData;
    }

    public void setxData(List<Integer> xData) {
        this.xData = xData;
    }

    public List<Integer> getyData() {
        return yData;
    }

    public void setyData(List<Integer> yData) {
        this.yData = yData;
    }
}
