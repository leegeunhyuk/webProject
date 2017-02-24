package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Player;
import service.logic.BaseballTeamServiceLogic;

@WebServlet("/trade.do")
public class TradeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BaseballTeamServiceLogic service = new BaseballTeamServiceLogic();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String playerId = request.getParameter("player");
		String targetPlayer = request.getParameter("targetPlayer");
		service.tradePlayer(playerId, targetPlayer);
		response.sendRedirect("playerList.do");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	

}
