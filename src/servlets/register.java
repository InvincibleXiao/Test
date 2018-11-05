package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Users;
import dao.UsersDao;

@WebServlet("/register")
@MultipartConfig
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public register() {
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

	
	
		PrintWriter out = response.getWriter();
		List<Users> user=new ArrayList<Users>();
		
		UsersDao dao=new UsersDao();
		List<Users> all = new ArrayList<>();
	     all=dao.findAll();
	       HttpSession session=request.getSession();
	       session.setAttribute("all", all);
		
		Users users=new Users();
		String[] Interest=request.getParameterValues("interest");
		users.setGender(request.getParameter("gender"));    
        users.setPwd(request.getParameter("pwd"));
		users.setCategory(request.getParameter("category"));
	    users.setInterest(Arrays.toString(Interest));  
	    users.setUserName(request.getParameter("userName"));
	    users.setPwdConfirm(request.getParameter("pwdConfirm"));
      
	    UsersDao DAO=new UsersDao();
	   int i= DAO.insert(users);
        user.add(users);

        System.out.print(i);
	    if(i==1) {
	    	out.println("注册成功，3秒后跳转到登陆页面");
			response.setHeader("Refresh", "3;login.jsp");
	    }
	    else {
	    	request.getRequestDispatcher("register.jsp").forward(request, response);
	    }
	    
	    
}

}