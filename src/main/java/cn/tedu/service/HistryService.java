package cn.tedu.service;

import cn.hutool.db.Entity;
import cn.tedu.dao.HistorytimeDao;
import cn.tedu.pojo.DistributeVO;
import cn.tedu.pojo.PieView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aim_Liu
 * @create 2021-07-20-21:43
 */
public class HistryService {
    private HistorytimeDao historytimeDao = new HistorytimeDao();
    public DistributeVO findDistrybuteBygender(int gender){
        List<Entity> list = historytimeDao.listDistributeByGender(gender);
        ArrayList<Integer> xData = new ArrayList<>();
        ArrayList<Integer> yData = new ArrayList<>();
        for (Entity entity : list) {
            xData.add(entity.getInt("day"));
            yData.add(entity.getInt("times"));
        }

        return new DistributeVO(xData, yData);
    }

    public DistributeVO findHotestStationByDay(int day){
        List<Entity> list = historytimeDao.listHotestStationByDay(day);
        ArrayList<Integer> xData = new ArrayList<>();
        ArrayList<Integer> yData = new ArrayList<>();
        for (Entity entity : list) {
            xData.add(entity.getInt("end_station_id"));
            yData.add(entity.getInt("times"));
        }
        return new DistributeVO(xData, yData);
    }

    public DistributeVO findHotestStationByWeek(int week){
        List<Entity> list = historytimeDao.listHotestStationByWeek(week);
        ArrayList<Integer> xData = new ArrayList<>();
        ArrayList<Integer> yData = new ArrayList<>();
        for (Entity entity : list) {
            xData.add(entity.getInt("end_station_id"));
            yData.add(entity.getInt("times"));
        }
        return new DistributeVO(xData, yData);
    }

    public PieView findPerStationAgeById(int id, int gender){
        List<Entity> list = historytimeDao.listStationDistribute(id, gender);
        ArrayList<String> ageTemp = new ArrayList<>();
        ArrayList<Integer> sum = new ArrayList<>();

        for (Entity entity : list) {
            ageTemp.add(entity.getStr("age_temp"));
            sum.add(entity.getInt("num"));
        }
        return new PieView(ageTemp, sum);
    }

    public DistributeVO findHotestStationByIdAndDay(int id, int day){
        List<Entity> list = historytimeDao.listHotestStationByIdAndDay(id, day);
        List<Integer> times = new ArrayList<>();
        List<Integer> stationId = new ArrayList<>();

        for (Entity entity : list) {
            times.add(entity.getInt("times"));
            stationId.add(entity.getInt("stationId"));
        }
        return new DistributeVO(stationId,times);
    }
}
