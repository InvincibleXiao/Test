package dao;
import java.io.Serializable;
import javax.servlet.http.Part;
public class Users{
	private String userName;
	private String pwd;
	private String gender;
	private String category;
	private String interest;
    private int id;
	private String pwdConfirm;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getGender() { 
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setPwdConfirm(String pwdConfirm) {
		// TODO Auto-generated method stub
		this.pwdConfirm=pwdConfirm;
	}
	public String getPwdConfirm() {
		return pwdConfirm;
	}
}
