package cn.tedu.web;

import cn.hutool.json.JSONUtil;
import cn.tedu.pojo.RepaireVO;
import cn.tedu.service.RealtimeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Aim_Liu
 * @create 2021-07-22-21:01
 */
@WebServlet("/realtime/repaire")
public class RepaireSevlet extends HttpServlet {
    private RealtimeService  realtimeService = new RealtimeService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //调用业务层方法
        RepaireVO repaireVO = realtimeService.findDockRepaire();
        //结果转JSON
        String result = JSONUtil.toJsonStr(repaireVO);
        System.out.println(result);
        //通知浏览器返回JSON格式
        resp.setContentType("application/json;charset=utf-8");
        //发送响应数据
        resp.getWriter().write(result);//将结果写出去
    }
}
