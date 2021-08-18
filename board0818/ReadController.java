package org.zerock.board.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.board.dto.BoardDTO;
import org.zerock.board.service.BoardService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
@Log4j2
@WebServlet(name = "ReadController", value = "/board/read")
public class ReadController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int bno=Integer.parseInt(request.getParameter("bno"));
        BoardDTO boardDTO= BoardService.INSTANCE.read(bno);
        request.setAttribute("dto", boardDTO);
        request.getRequestDispatcher("/WEB-INF/board/read.jsp").forward(request,response);

    }
}
