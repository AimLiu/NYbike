package cn.tedu.dao;

import cn.hutool.db.Entity;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Aim_Liu
 * @create 2021-07-16-14:51
 */
public class RealtimeDaoTest {

    @Test
    public void listNbaBySid() {
        RealtimeDao realtimeDao = new RealtimeDao();
        List<Entity> list = realtimeDao.listNbaBySid("72", 1);
        list.forEach(System.out::println);
    }
}