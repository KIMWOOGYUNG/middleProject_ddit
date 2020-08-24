package yaksa.chemist.vo.inventory;

public class medVO {


	private String medi_code;
	private String medi_name;
	private String medi_com;
	private String medi_etc;
	private String medi_outprcie;
	private String medi_inprice;
	
	
	
	
	
	medVO(){};
	
	
	public medVO(String medi_code, String medi_name, String medi_com, String medi_etc, String medi_outprcie, String medi_inprice ) {
		super();
		this.medi_code = medi_code;
		this.medi_name = medi_name;
		this.medi_com = medi_com;
		this.medi_etc = medi_etc;
		this.medi_outprcie = medi_outprcie;
		this.medi_inprice = medi_inprice;
		
		
		
	}
	
	
	public String getMedi_outprcie() {
		return medi_outprcie;
	}


	public void setMedi_outprcie(String medi_outprcie) {
		this.medi_outprcie = medi_outprcie;
	}


	public String getMedi_inprice() {
		return medi_inprice;
	}


	public void setMedi_inprice(String medi_inprice) {
		this.medi_inprice = medi_inprice;
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
