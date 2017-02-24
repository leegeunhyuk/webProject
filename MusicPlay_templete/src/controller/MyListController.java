package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Music;
import service.UserMusicService;
import service.logic.UserMusicServiceLogic;
import store.UserMusicStore;
import store.logic.UserMusicStoreLogic;

@WebServlet("/myList.do")
public class MyListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserMusicService service = new UserMusicServiceLogic();
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");

		

		List<Music> list = service.findMusicsByUser(userId);
		request.setAttribute("musics", list);
		request.getRequestDispatcher("myList.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
