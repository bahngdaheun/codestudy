package org.zerock.board.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.board.dto.BoardDTO;
import org.zerock.board.service.BoardService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Log4j2
@WebServlet(name = "ListController", value = "/board/list")
public class ListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
log.info("List Controller doGet...");
        ArrayList<BoardDTO> result= BoardService.INSTANCE.getList();
        request.setAttribute("Board",result);

request.getRequestDispatcher("/WEB-INF/board/list.jsp").forward(request,response);
    }
}
