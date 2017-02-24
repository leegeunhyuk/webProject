package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BaseballTeam;
import domain.Player;
import service.BaseballTeamService;
import service.logic.BaseballTeamServiceLogic;

@WebServlet("/playerList.do")
public class PlayerListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BaseballTeamService service;

	public PlayerListController() {
		service = new BaseballTeamServiceLogic();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String teamId = request.getParameter("teamId");
		if (teamId == null || teamId.equals("")) {
			List<BaseballTeam> list = service.findAllTeamsWithPlayers();
			request.setAttribute("teamList", list);
			
			try {
				request.getRequestDispatcher("playerList.jsp").forward(request, response);
			} catch (Exception e) {
				e.getMessage();
			}
		} else {
			BaseballTeam bt = service.findTeam(teamId);
			request.setAttribute("team", bt);
			request.setAttribute("p", service.findPlayer(request.getParameter("playerId")));
			try {
				request.getRequestDispatcher("playerList.jsp").forward(request, response);
			} catch (Exception e) {
				e.getMessage();
			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
