package cn.tedu.web;

import cn.hutool.json.JSONUtil;
import cn.tedu.pojo.DistributeVO;
import cn.tedu.pojo.PieView;
import cn.tedu.service.HistryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Aim_Liu
 * @create 2021-07-21-15:14
 */
@WebServlet("/history/perstation")
public class PerStationDistributeServlet extends HttpServlet {
    private HistryService histryService =new HistryService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数,类型转换
        Integer stationId = Integer.parseInt(req.getParameter("id"));
        Integer gender = Integer.parseInt(req.getParameter("gender"));
        //调用业务层
        PieView pieView = histryService.findPerStationAgeById(stationId, gender);
        //结果转为json格式
        //输出测试
        String result = JSONUtil.toJsonStr(pieView);
        System.out.println(result);
        //通知浏览器返回JSON数据
        resp.setContentType("application/json;charset=utf-8");
//        发送响应数据
        resp.getWriter().write(result);
    }
}
