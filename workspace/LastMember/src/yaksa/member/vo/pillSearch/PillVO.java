package yaksa.member.vo.pillSearch;

public class PillVO {
	private  String medi_code;
	private  String medi_name;
	private  String medi_com;
	private  String medi_etc;
	public PillVO() { }
	
	public PillVO(String medi_code, String medi_name, String medi_com, String medi_etc) {
		super();
		this.medi_code = medi_code;
		this.medi_name = medi_name;
		this.medi_com = medi_com;
		this.medi_etc = medi_etc;
	}
	
	public String getMedi_code() {
		return medi_code;
	}
	public void setMedi_code(String medi_code) {
		this.medi_code = medi_code;
	}
	public String getMedi_name() {
		return medi_name;
	}
	public void setMedi_name(String medi_name) {
		this.medi_name = medi_name;
	}
	public String getMedi_com() {
		return medi_com;
	}
	public void setMedi_com(String medi_com) {
		this.medi_com = medi_com;
	}
	public String getMedi_etc() {
		return medi_etc;
	}
	public void setMedi_etc(String medi_etc) {
		this.medi_etc = medi_etc;
	}
	
	

}
