package yaksa.chemist.vo.inventory;

public class invVO {
	private String inven_num;
	private String inven_phid;
	private String inven_code;
	private String medi_name;	// 조인해서 받아올 값 저장
	private String inven_remain;
	private String inven_inprice;
	private String inven_outprice;
	
	
	
	
	public invVO(String inven_phid, String inven_code, String inven_inprice, String inven_outprice) {
		super();
		this.inven_phid = inven_phid;
		this.inven_code = inven_code;
		this.inven_inprice = inven_inprice;
		this.inven_outprice = inven_outprice;
	}
	
	public invVO() {} // 생성자
	
	public String getMedi_name() {
		return medi_name;
	}
	public void setMedi_name(String medi_name) {
		this.medi_name = medi_name;
	}
	public String getInven_num() {
		return inven_num;
	}
	public void setInven_num(String inven_num) {
		this.inven_num = inven_num;
	}
	public String getInven_phid() {
		return inven_phid;
	}
	public void setInven_phid(String inven_phid) {
		this.inven_phid = inven_phid;
	}
	public String getInven_code() {
		return inven_code;
	}
	public void setInven_code(String inven_code) {
		this.inven_code = inven_code;
	}
	public String getInven_remain() {
		return inven_remain;
	}
	public void setInven_remain(String inven_remain) {
		this.inven_remain = inven_remain;
	}
	public String getInven_inprice() {
		return inven_inprice;
	}
	public void setInven_inprice(String inven_inprice) {
		this.inven_inprice = inven_inprice;
	}
	public String getInven_outprice() {
		return inven_outprice;
	}
	public void setInven_outprice(String inven_outprice) {
		this.inven_outprice = inven_outprice;
	}
	
	

}
