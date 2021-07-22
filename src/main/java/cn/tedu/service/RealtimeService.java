package cn.tedu.service;

import cn.hutool.db.Entity;
import cn.tedu.dao.RealtimeDao;
import cn.tedu.pojo.RepaireVO;
import cn.tedu.pojo.StationNbaVO;

import java.util.ArrayList;
import java.util.List;

/**
 * 实时数据业务层
 * @author Aim_Liu
 * @create 2021-07-16-15:47
 */
public class RealtimeService {
    private RealtimeDao realtimeDao = new RealtimeDao();
    public StationNbaVO finddNbaBySid(String sid, int hour){
        List<Entity> entities = realtimeDao.listNbaBySid(sid, hour);
        ArrayList<String> xData = new ArrayList<>();
        ArrayList<Integer> yData = new ArrayList<>();
        for (Entity entity : entities) {
            xData.add(entity.getStr("create_time"));
            yData.add(entity.getInt("num_bikes_available"));
        }
        return new StationNbaVO(xData, yData);
    }
    public RepaireVO findDockRepaire(){
        List<Entity> entities = realtimeDao.listDockRepaire();
        ArrayList<Integer> sid = new ArrayList<>();
        ArrayList<Integer> repaireNum = new ArrayList<>();
        for (Entity entity : entities) {
            sid.add(entity.getInt("id"));
            repaireNum.add(entity.getInt("docks"));
        }
        return new RepaireVO(sid, repaireNum);
    }
}
