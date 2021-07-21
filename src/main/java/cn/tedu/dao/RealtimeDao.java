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

}
