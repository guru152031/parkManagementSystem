package com.bo;

public class addempbo {
	private String name,email,phnno,desg,address,doj,pkg;
	private int id;

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public void setPhone(String phnno) {
		this.phnno = phnno;
	}

	public String getDesg() {
		return desg;
	}

	public void setDesg(String desg) {
		this.desg = desg;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public String getPkg() {
		return pkg;
	}

	public void setPkg(String pkg) {
		this.pkg = pkg;
	}

	public addempbo(String name, String email, String phnno, String desg, String address, String doj, String pkg) {
		super();
		this.name = name;
		this.email = email;
		this.phnno = phnno;
		this.desg = desg;
		this.address = address;
		this.doj = doj;
		this.pkg = pkg;
	}
	public addempbo( int id,String name, String email, String phnno, String desg, String address, String doj, String pkg) {
		super();
		this.id=id;
		this.name = name;
		this.email = email;
		this.phnno = phnno;
		this.desg = desg;
		this.address = address;
		this.doj = doj;
		this.pkg = pkg;
	}

	public addempbo() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
