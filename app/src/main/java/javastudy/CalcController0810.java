package org.zerock.m1;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CalcController", value = "/calc")
@Log4j2
public class CalcController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("CalaController doGet.....");
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("WEB-INF/calcInput.jsp");

        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            log.info("CalcController doPost....");
            String num1Str=request.getParameter("num1");
        String num2Str=request.getParameter("num2");
        String oper=request.getParameter("oper");

        log.info("num1Str: "+num1Str);
        log.info("num2Str: "+num2Str);
        log.info("oper: "+oper);

            RequestDispatcher dispatcher
                    =request.getRequestDispatcher("WEB-INF/calcResult.jsp");

            dispatcher.forward(request,response);
    }
}
