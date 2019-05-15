package dao;

public class TProject {
	private int id;
	private int pno;
	private int eno;
	private int rno;

	public TProject(int id, int pno, int eno, int rno) {
		this.id = id;
		this.pno = pno;
		this.eno = eno;
		this.rno = rno;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public int getEno() {
		return eno;
	}

	public void setEno(int eno) {
		this.eno = eno;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

}
