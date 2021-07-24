package sec02.ex01;

import java.sql.Date;

public class MemberVO {

	private String id;
	private String pwd;
	private String name;
	private String email;
	private Date joinDate;
	
	public MemberVO() {
		System.out.println("vo 持失");
	}

	public MemberVO(String id, String pwd, String name, String email) {
		System.out.println("vo 持失");
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
	}

	public MemberVO(String id, String pwd, String name, String email, Date joinDate) {
		System.out.println("vo 持失");
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.joinDate = joinDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
	
	
}
