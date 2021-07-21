package cn.tedu.service;

import cn.tedu.pojo.StationNbaVO;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Aim_Liu
 * @create 2021-07-16-16:12
 */
public class RealtimeServiceTest {

    @Test
    public void finddNbaBySid() {
        RealtimeService realtimeService = new RealtimeService();
        StationNbaVO stationNbaVO = realtimeService.finddNbaBySid("72", 1);
        System.out.println(stationNbaVO);
    }
}