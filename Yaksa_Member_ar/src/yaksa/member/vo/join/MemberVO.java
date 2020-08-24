package yaksa.member.vo.join;

public class MemberVO {

	private  String mem_id;
	private  String mem_pw;
	private  String mem_name;
	private  String mem_gender;
	private  String mem_regno1;
	private  String mem_regno2;
	private int mem_zip_code;
	private  String mem_add1;
	private  String mem_add2;
	private  String mem_tel;
	private  String mem_email1;
	private  String mem_email2;
	private  String mem_available;
	
	public MemberVO() { }
	
	public MemberVO(String mem_id, String mem_pw, String mem_name, String mem_gender, String mem_regno1,
			String mem_regno2, int mem_zip_code, String mem_add1, String mem_add2, String mem_tel, String mem_email1,
			String mem_email2, String mem_available) {
		super();
		this.mem_id = mem_id;
		this.mem_pw = mem_pw;
		this.mem_name = mem_name;
		this.mem_gender = mem_gender;
		this.mem_regno1 = mem_regno1;
		this.mem_regno2 = mem_regno2;
		this.mem_zip_code = mem_zip_code;
		this.mem_add1 = mem_add1;
		this.mem_add2 = mem_add2;
		this.mem_tel = mem_tel;
		this.mem_email1 = mem_email1;
		this.mem_email2 = mem_email2;
		this.mem_available = mem_available;
	}
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pw() {
		return mem_pw;
	}
	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_gender() {
		return mem_gender;
	}
	public void setMem_gender(String mem_gender) {
		this.mem_gender = mem_gender;
	}
	public String getMem_regno1() {
		return mem_regno1;
	}
	public void setMem_regno1(String mem_regno1) {
		this.mem_regno1 = mem_regno1;
	}
	public String getMem_regno2() {
		return mem_regno2;
	}
	public void setMem_regno2(String mem_regno2) {
		this.mem_regno2 = mem_regno2;
	}
	public int getMem_zip_code() {
		return mem_zip_code;
	}
	public void setMem_zip_code(int mem_zip_code) {
		this.mem_zip_code = mem_zip_code;
	}
	public String getMem_add1() {
		return mem_add1;
	}
	public void setMem_add1(String mem_add1) {
		this.mem_add1 = mem_add1;
	}
	public String getMem_add2() {
		return mem_add2;
	}
	public void setMem_add2(String mem_add2) {
		this.mem_add2 = mem_add2;
	}
	public String getMem_tel() {
		return mem_tel;
	}
	public void setMem_tel(String mem_tel) {
		this.mem_tel = mem_tel;
	}
	public String getMem_email1() {
		return mem_email1;
	}
	public void setMem_email1(String mem_email1) {
		this.mem_email1 = mem_email1;
	}
	public String getMem_email2() {
		return mem_email2;
	}
	public void setMem_email2(String mem_email2) {
		this.mem_email2 = mem_email2;
	}
	public String getMem_available() {
		return mem_available;
	}
	public void setMem_available(String mem_available) {
		this.mem_available = mem_available;
	}
	
}
