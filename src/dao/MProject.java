package dao;

public class MProject {
	private int pno;
	private String pname;

	public MProject(int pno, String pname) {
		this.pno = pno;
		this.pname = pname;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

}
