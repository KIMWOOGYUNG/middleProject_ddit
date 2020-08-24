package vo;

public class PrescriptionVO {
	
	private int phar_messnum;
	private String phar_memid;
	private char phar_check;
	private String pharm_id;
	private String phar_file;
	private String phar_inboxdate;
	
	
	public PrescriptionVO() {}
	

	public PrescriptionVO(int phar_messnum, String phar_memid, char phar_check, String pharm_id, String phar_file,
		String phar_inboxdate) {
		super();
		this.phar_messnum = phar_messnum;
		this.phar_memid = phar_memid;
		this.phar_check = phar_check;
		this.pharm_id = pharm_id;
		this.phar_file = phar_file;
		this.phar_inboxdate = phar_inboxdate;
	}

	public int getPhar_messnum() {
		return phar_messnum;
	}
	public void setPhar_messnum(int phar_messnum) {
		this.phar_messnum = phar_messnum;
	}
	public String getPhar_memid() {
		return phar_memid;
	}
	public void setPhar_memid(String phar_memid) {
		this.phar_memid = phar_memid;
	}
	public char getPhar_check() {
		return phar_check;
	}
	public void setPhar_check(char phar_check) {
		this.phar_check = phar_check;
	}
	public String getPharm_id() {
		return pharm_id;
	}
	public void setPharm_id(String pharm_id) {
		this.pharm_id = pharm_id;
	}
	public String getPhar_file() {
		return phar_file;
	}
	public void setPhar_file(String phar_file) {
		this.phar_file = phar_file;
	}
	public String getPhar_inboxdate() {
		return phar_inboxdate;
	}	
	public void setPhar_inboxdate(String phar_inboxdate) {
		this.phar_inboxdate = phar_inboxdate;
	}
	
	
	
}
