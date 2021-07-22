package cn.tedu.dao;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Aim_Liu
 * @create 2021-07-16-14:06
 * @desciption 对实时数据进行访问
 */
public class RealtimeDao {
    public List<Entity> listNbaBySid(String sid, int hour) {
        String sql = "select station_id, num_bikes_available, create_time from "
                    +"t_status where station_id = ? and create_time > "+
                "DATE_SUB(NOW(), INTERVAL ? hour);";
        //使用Hutool工具进行查询
        List<Entity> list = null;
        try {
            list = Db.use().query(sql,sid,hour);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public List<Entity> listDockRepaire(){
        String sql = "select `station_id` as `id`, `num_docks_disabled` as `docks` from `t_status` " +
                "where `station_status` = 'active'  " +
                "AND (DAY(NOW()) - DAY(create_time)) < 1 " +
                "AND `num_docks_disabled` != 0 " +
                "GROUP BY `station_id` " +
                "ORDER BY (num_bikes_disabled /(num_docks_available + num_bikes_available)) DESC LIMIT 10;";
        List<Entity> list = null;
        try {
            list = Db.use().query(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

}
