package cn.tedu.web;

import cn.hutool.json.JSONUtil;
import cn.tedu.pojo.DistributeVO;
import cn.tedu.service.HistryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/history/monthhot")
public class PerMonthHotestServlet extends HttpServlet {
    private HistryService histryService = new HistryService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DistributeVO distributeVO = histryService.findHotestStationByMonth();
        String result = JSONUtil.toJsonStr(distributeVO);
        System.out.println(result);
        //通知浏览器返回JSON数据
        resp.setContentType("application/json;charset=utf-8");
//        发送响应数据
        resp.getWriter().write(result);

    }
}
