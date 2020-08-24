package yaksa.chemist.vo.prescription;

public class PharmVO {
	private String pharm_id;
	private String pharm_chname;
	private String pharm_name;
	private String pharm_email1;
	private String pharm_email2;
	private String pharm_add1;
	private String pharm_add2;
	private String pharm_tel;

	
	public PharmVO(String pharm_id, String pharm_chname, String pharm_name, String pharm_email1, String pharm_email2,
			String pharm_add1, String pharm_add2, String pharm_tel) {
		super();
		this.pharm_id = pharm_id;
		this.pharm_chname = pharm_chname;
		this.pharm_name = pharm_name;
		this.pharm_email1 = pharm_email1;
		this.pharm_email2 = pharm_email2;
		this.pharm_add1 = pharm_add1;
		this.pharm_add2 = pharm_add2;
		this.pharm_tel = pharm_tel;
	}

	public PharmVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public String getPharm_id() {
		return pharm_id;
	}

	public void setPharm_id(String pharm_id) {
		this.pharm_id = pharm_id;
	}

	public String getPharm_chname() {
		return pharm_chname;
	}

	public void setPharm_chname(String pharm_chname) {
		this.pharm_chname = pharm_chname;
	}

	public String getPharm_name() {
		return pharm_name;
	}

	public void setPharm_name(String pharm_name) {
		this.pharm_name = pharm_name;
	}

	public String getPharm_email1() {
		return pharm_email1;
	}

	public void setPharm_email1(String pharm_email1) {
		this.pharm_email1 = pharm_email1;
	}

	public String getPharm_email2() {
		return pharm_email2;
	}

	public void setPharm_email2(String pharm_email2) {
		this.pharm_email2 = pharm_email2;
	}

	public String getPharm_add1() {
		return pharm_add1;
	}

	public void setPharm_add1(String pharm_add1) {
		this.pharm_add1 = pharm_add1;
	}

	public String getPharm_add2() {
		return pharm_add2;
	}

	public void setPharm_add2(String pharm_add2) {
		this.pharm_add2 = pharm_add2;
	}

	public String getPharm_tel() {
		return pharm_tel;
	}

	public void setPharm_tel(String pharm_tel) {
		this.pharm_tel = pharm_tel;
	}


	
	
	
	
	
}
