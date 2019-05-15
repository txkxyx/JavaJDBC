package dao;

public class MRole {
	private int rno;
	private String rname;

	public MRole(int rno, String rname) {
		this.rno = rno;
		this.rname = rname;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

}
