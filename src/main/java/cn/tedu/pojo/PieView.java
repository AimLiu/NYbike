package cn.tedu.pojo;

import java.util.Arrays;
import java.util.List;

/**
 * @author Aim_Liu
 * @create 2021-07-21-14:31
 */
public class PieView {
    List<String> ageTemp;
    List<Integer> sum;

    public PieView(List<String> ageTemp, List<Integer> sum) {
        this.ageTemp = ageTemp;
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "PieView{" +
                "ageTemp=" + ageTemp +
                ", sum=" + sum +
                '}';
    }

    public List<String> getAgeTemp() {
        return ageTemp;
    }

    public void setAgeTemp(List<String> ageTemp) {
        this.ageTemp = ageTemp;
    }

    public List<Integer> getSum() {
        return sum;
    }

    public void setSum(List<Integer> sum) {
        this.sum = sum;
    }
}
