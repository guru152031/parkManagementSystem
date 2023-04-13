package com.bo;

public class parkbo {
	private String name,email,phnno,password,confirmpassword;

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

	public String getPhnno() {
		return phnno;
	}

	public void setPhnno(String phnno) {
		this.phnno = phnno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	public parkbo(String name, String email, String phnno, String password, String confirmpassword) {
		super();
		this.name = name;
		this.email = email;
		this.phnno = phnno;
		this.password = password;
		this.confirmpassword = confirmpassword;
	}

	public parkbo() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
