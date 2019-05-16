package dao;

import java.sql.Date;

public class MEmployee {
	private int eno;
	private String ename;
	private Date hireDate;
	private int salary;
	private String address;

	public MEmployee() {

	}

	public MEmployee(int eno, String ename, Date hireDate, int salary, String address) {
		this.eno = eno;
		this.ename = ename;
		this.hireDate = hireDate;
		this.salary = salary;
		this.address = address;
	}

	public int getEno() {
		return eno;
	}

	public void setEno(int eno) {
		this.eno = eno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
