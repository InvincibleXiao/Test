package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Users;
import dao.UsersDao;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		UsersDao dao=new UsersDao();
		List<Users> all = new ArrayList<>();
	     all=dao.findAll();
	       HttpSession session=request.getSession();
	       session.setAttribute("all", all);
		
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		UsersDao usersDao = new UsersDao();
		Users users = usersDao.findBy(userName, pwd);
		
		if (users != null) {
			
			session.setAttribute("user", users);
			
			response.sendRedirect("home.jsp");		
		}else{
			response.sendRedirect("login.jsp");
		}
	}

}
