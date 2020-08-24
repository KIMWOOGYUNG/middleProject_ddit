package yaksa.chemist.vo.prescription;

public class InventoryVO {
	private String inven_num;
	private String inven_phid;
	private String inven_code;
	private int inven_remain;
	private int inven_inprice;
	private String inven_outprice;
	private String inven_YakName;
	
	
	public String getInven_YakName() {
		return inven_YakName;
	}



	public void setInven_YakName(String inven_YakName) {
		this.inven_YakName = inven_YakName;
	}



	public InventoryVO() {
		super();
	}
	
	
	
	public InventoryVO(String inven_num, String inven_phid, String inven_code, int inven_remain, int inven_inprice,
			String inven_outprice) {
		super();
		this.inven_num = inven_num;
		this.inven_phid = inven_phid;
		this.inven_code = inven_code;
		this.inven_remain = inven_remain;
		this.inven_inprice = inven_inprice;
		this.inven_outprice = inven_outprice;
	}


	

	@Override
	public String toString() {
		return "InventoryVO [inven_num=" + inven_num + ", inven_phid=" + inven_phid + ", inven_code=" + inven_code
				+ ", inven_remain=" + inven_remain + ", inven_inprice=" + inven_inprice + ", inven_outprice="
				+ inven_outprice + "]";
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
	public int getInven_remain() {
		return inven_remain;
	}
	public void setInven_remain(int inven_remain) {
		this.inven_remain = inven_remain;
	}
	public int getInven_inprice() {
		return inven_inprice;
	}
	public void setInven_inprice(int inven_inprice) {
		this.inven_inprice = inven_inprice;
	}
	public String getInven_outprice() {
		return inven_outprice;
	}
	public void setInven_outprice(String inven_outprice) {
		this.inven_outprice = inven_outprice;
	}
	
	
}
