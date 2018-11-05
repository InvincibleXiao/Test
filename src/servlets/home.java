package servlets;

import java.io.IOException;
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

@WebServlet("/user_list")
public class home extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public home() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
     UsersDao dao=new UsersDao();
     List<Users> all = new ArrayList<>();
     all=dao.findAll();
       HttpSession session=request.getSession();
       session.setAttribute("all", all);
     response.sendRedirect("users.jsp");
 	
	}

}
