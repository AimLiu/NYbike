package cn.tedu.dao;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Aim_Liu
 * @create 2021-07-20-21:12
 */
public class HistorytimeDao {
    public List<Entity> listDistributeByGender(int gender){
        String sql = "SELECT DAY(starttime) as `day` ,count(*) as `times` " +
                "from `t_trip_202006` where gender = ? GROUP BY(`day`);";
        //使用糊涂包进行查询
        List<Entity> list = null;
        try {
            list = Db.use().query(sql, gender);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
    public List<Entity> listHotestStationByWeek(int week){
        String sql = "SELECT `end_station_id`, count(*) as `times`, WEEK(stoptime) as `week` " +
                "from `t_trip_202006` " +
                "where  WEEK(stoptime) = ? " +
                "GROUP BY `end_station_id` " +
                "ORDER BY `times` DESC limit 10;";
        //使用糊涂包
        List<Entity> list = null;
        try {
            list = Db.use().query(sql, week);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public List<Entity> listHotestStationByDay(int day){
        String sql = "SELECT `end_station_id`, count(*) as `times`, DAY(stoptime) as `day` " +
                "from `t_trip_202006` " +
                "where  DAY(stoptime) = ? " +
                "GROUP BY `end_station_id` " +
                "ORDER BY `times` DESC limit 10;";
        //使用糊涂包
        List<Entity> list = null;
        try {
            list = Db.use().query(sql, day);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public List<Entity> listStationDistribute(int stationId, int gender){
        String sql = "SELECT " +
                "COUNT(*) AS num, " +
                "gender AS sex, " +
                "end_station_id AS id, " +
                " CASE" +
                " WHEN YEAR(NOW())-birth_year BETWEEN 1 and 20 THEN '1-20'" +
                " WHEN YEAR(NOW())-birth_year BETWEEN 21 and 40 THEN '21-40'" +
                " WHEN YEAR(NOW())-birth_year BETWEEN 41 and 60 THEN '41-60'" +
                " WHEN YEAR(NOW())-birth_year BETWEEN 61 and 80 THEN '61-80'" +
                " WHEN YEAR(NOW())-birth_year BETWEEN 81 and 100 THEN '81-100'" +
                " ELSE'100+'" +
                " END AS age_temp " +
                " FROM t_trip_202006 " +
                " WHERE end_station_id = ? AND gender = ? " +
                " GROUP BY" +
                " sex," +
                " age_temp," +
                " id" +
                " ORDER BY" +
                " num DESC;";
        List<Entity> list = null;
        try {
            list = Db.use().query(sql, stationId, gender);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
    public List<Entity> listHotestStationByIdAndDay(int stationId, int day){
        String sql = "SELECT count(*) as `times`,`end_station_id` as `stationId` from t_trip_202006 WHERE `end_station_id` = ? AND DAY(`stoptime`) = ?;";
        List<Entity> list = null;
        try {
            list = Db.use().query(sql, stationId, day);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
