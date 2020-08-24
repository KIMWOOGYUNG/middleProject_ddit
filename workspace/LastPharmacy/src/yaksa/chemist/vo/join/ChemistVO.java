package yaksa.chemist.vo.join;

public class ChemistVO {
	private  String pharm_id;
	private  String pharm_chname;
	private  String pharm_name;
	private  String pharm_pw;
	private  String pharm_regno1;
	private  String pharm_regno2;
	private  String pharm_email1;
	private  String pharm_email2;
	private  String pharm_license_num;
	private  String pharm_corpor_num;
	private int pharm_zip_code;
	private  String pharm_add1;
	private  String pharm_add2;
	private  String pharm_tel;
	
	public ChemistVO() { }
	
	public ChemistVO(String pharm_id, String pharm_chname, String pharm_name, String pharm_pw, String pharm_regno1,
			String pharm_regno2, String pharm_email1, String pharm_email2, String pharm_license_num,
			String pharm_corpor_num, int pharm_zip_code, String pharm_add1, String pharm_add2, String pharm_tel) {
		super();
		this.pharm_id = pharm_id;
		this.pharm_chname = pharm_chname;
		this.pharm_name = pharm_name;
		this.pharm_pw = pharm_pw;
		this.pharm_regno1 = pharm_regno1;
		this.pharm_regno2 = pharm_regno2;
		this.pharm_email1 = pharm_email1;
		this.pharm_email2 = pharm_email2;
		this.pharm_license_num = pharm_license_num;
		this.pharm_corpor_num = pharm_corpor_num;
		this.pharm_zip_code = pharm_zip_code;
		this.pharm_add1 = pharm_add1;
		this.pharm_add2 = pharm_add2;
		this.pharm_tel = pharm_tel;
	}
	
	
	
	
	@Override
	public String toString() {
		return "ChemistVO [pharm_id=" + pharm_id + ", pharm_chname=" + pharm_chname + ", pharm_name=" + pharm_name
				+ ", pharm_pw=" + pharm_pw + ", pharm_regno1=" + pharm_regno1 + ", pharm_regno2=" + pharm_regno2
				+ ", pharm_email1=" + pharm_email1 + ", pharm_email2=" + pharm_email2 + ", pharm_license_num="
				+ pharm_license_num + ", pharm_corpor_num=" + pharm_corpor_num + ", pharm_zip_code=" + pharm_zip_code
				+ ", pharm_add1=" + pharm_add1 + ", pharm_add2=" + pharm_add2 + ", pharm_tel=" + pharm_tel + "]";
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
	public String getPharm_pw() {
		return pharm_pw;
	}
	public void setPharm_pw(String pharm_pw) {
		this.pharm_pw = pharm_pw;
	}
	public String getPharm_regno1() {
		return pharm_regno1;
	}
	public void setPharm_regno1(String pharm_regno1) {
		this.pharm_regno1 = pharm_regno1;
	}
	public String getPharm_regno2() {
		return pharm_regno2;
	}
	public void setPharm_regno2(String pharm_regno2) {
		this.pharm_regno2 = pharm_regno2;
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
	public String getPharm_license_num() {
		return pharm_license_num;
	}
	public void setPharm_license_num(String pharm_license_num) {
		this.pharm_license_num = pharm_license_num;
	}
	public String getPharm_corpor_num() {
		return pharm_corpor_num;
	}
	public void setPharm_corpor_num(String pharm_corpor_num) {
		this.pharm_corpor_num = pharm_corpor_num;
	}
	public int getPharm_zip_code() {
		return pharm_zip_code;
	}
	public void setPharm_zip_code(int pharm_zip_code) {
		this.pharm_zip_code = pharm_zip_code;
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
