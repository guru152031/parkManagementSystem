package com.bo;

public class addstaff {
	private String name,phnno,desg,address,doj,pkg;
private int id;
	public addstaff(int id,String name, String phnno, String desg, String address, String doj, String pkg) {
	super();
	this.id = id;
	this.name = name;
	this.phnno = phnno;
	this.desg = desg;
	this.address = address;
	this.doj = doj;
	this.pkg = pkg;
 
}

	public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhnno() {
		return phnno;
	}

	public void setPhnno(String phnno) {
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

	public addstaff(String name, String phnno, String desg, String address, String doj, String pkg) {
		super();
		this.name = name;
		this.phnno = phnno;
		this.desg = desg;
		this.address = address;
		this.doj = doj;
		this.pkg = pkg;
	}

	public addstaff() {
		super();
		// TODO Auto-generated constructor stub
	}
	 

}
