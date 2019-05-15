package dao;

import java.sql.Date;

public class MEmployee {
	private int eno;
	private String ename;
	private Date hire_date;
	private int salary;
	private String address;

	public MEmployee() {

	}

	public MEmployee(int eno, String ename, Date hire_date, int salary, String address) {
		this.eno = eno;
		this.ename = ename;
		this.hire_date = hire_date;
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

	public Date getHire_date() {
		return hire_date;
	}

	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
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
