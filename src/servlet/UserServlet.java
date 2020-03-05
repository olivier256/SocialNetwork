package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Post;
import model.User;
import service.UserService;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService;

	public UserServlet() {
		userService = new UserService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String _id = request.getParameter("id");
		int id = Integer.parseInt(_id);
		User user = userService.findOne(id);
		request.setAttribute("user", user);
		request.getRequestDispatcher("user.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String textField = request.getParameter("textField");
		Post post = new Post(textField);
		String _userId = request.getParameter("id");
		int userId = Integer.parseInt(_userId);
		User user = userService.findOne(userId);
		user.addPost(post);
		request.setAttribute("user", user);
		request.getRequestDispatcher("user.jsp").forward(request, response);
	}

}
