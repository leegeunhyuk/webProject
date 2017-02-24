package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BaseballTeam;
import service.logic.BaseballTeamServiceLogic;

@WebServlet("/tradeTargetList.do")
public class tradeTargetListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BaseballTeamServiceLogic service = new BaseballTeamServiceLogic();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String teamId = request.getParameter("teamId");
		List<BaseballTeam> list = service.findTradeTargetPalyers(teamId);
		request.setAttribute("teamList", list);
		request.setAttribute("p", service.findPlayer(request.getParameter("playerId")));
		request.getRequestDispatcher("tradeTargetList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
