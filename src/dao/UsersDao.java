package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import dao.DBUtils;
import dao.Users;
public class UsersDao implements IDao<Users>  {
	public int insert(Users users) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
		
			connection = DBUtils.getConnection();
			String sql = "Insert into t_users(userName,pwd,gender,category,interest) values(?,?,?,?,?)";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, users.getUserName());
			pstmt.setString(2, users.getPwd());
			pstmt.setString(3, users.getGender());
			pstmt.setString(4, users.getCategory());
			pstmt.setString(5, users.getInterest());
		
			//pstmt.setString(6, users.getPhoto());
			int rows = pstmt.executeUpdate();
			return rows;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return 0;
		}finally{
	
			DBUtils.closeAll(connection, pstmt, null);
			
		}
		
	}
	public Users findBy(String userName,String pwd) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			connection = DBUtils.getConnection();
			String sql1 = "SELECT * FROM t_users WHERE userName = ? AND pwd = ?";
			pstmt = connection.prepareStatement(sql1);
			pstmt.setString(1, userName);
			pstmt.setString(2, pwd);
			resultSet = pstmt.executeQuery();
			Users users = null;
			while (resultSet.next()) {
				users = new Users();
				users.setId(resultSet.getInt("id"));
				users.setUserName( resultSet.getString("userName"));
				users.setPwd(resultSet.getString("pwd"));
				users.setGender(resultSet.getString("gender"));
				users.setCategory(resultSet.getString("category"));
				users.setInterest(resultSet.getString("interest"));
			}
			return users;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
		
			DBUtils.closeAll(connection, pstmt, resultSet);
			
		}
	}
	
	public Users findById(int id) {
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			connection = DBUtils.getConnection();
			String sql1 = "SELECT * FROM t_users WHERE id = ?";
			pstmt = connection.prepareStatement(sql1);
			pstmt.setInt(1, id);
			resultSet = pstmt.executeQuery();
			Users users = null;
			while (resultSet.next()) {
				users = new Users();
				users.setId(resultSet.getInt("id"));
				users.setUserName(resultSet.getString(2));
				users.setPwd(resultSet.getString("pwd"));
				users.setGender(resultSet.getString("gender"));
				users.setCategory(resultSet.getString("category"));
				users.setInterest(resultSet.getString("interest"));
				//users.setPhoto(resultSet.getString("photo"));
			}
			return users;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			DBUtils.closeAll(connection, pstmt, resultSet);
			
		}
	}
	@Override
	public int deletyById(int id) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			connection = DBUtils.getConnection();
			String sql1 = "Delete FROM t_users WHERE id = ?";
			pstmt = connection.prepareStatement(sql1);
			pstmt.setInt(1, id);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}finally{
			
			DBUtils.closeAll(connection, pstmt,null);
			
		}
	}
	@Override
	public int update(Users t) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<Users> findAll() {
		Connection connection = null;
		ResultSet resultSet = null;
		Statement st = null;
		try {
			connection = DBUtils.getConnection();
			String sql1 = "SELECT * FROM t_users";
			st = connection.createStatement();
			resultSet = st.executeQuery(sql1);
			Users users = null;
			List<Users> all = new ArrayList<>();
			while (resultSet.next()) {
				users = new Users();
				users.setId(resultSet.getInt("id"));
				users.setUserName(resultSet.getString("userName"));
				users.setPwd(resultSet.getString("pwd"));
				users.setGender(resultSet.getString("gender"));
				users.setCategory(resultSet.getString("category"));
				users.setInterest(resultSet.getString("interest"));
				//users.setPhoto(resultSet.getString("photo"));
				all.add(users);
			}
			return all;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}finally{
			
			DBUtils.closeAll(connection,null, resultSet);
			
		}
	}
}
