package yaksa.chemist.vo.prescription;

public class ReceiptVO {
	
	//pharmacy_history���̺�
	
	private String medi_name;
	private String phpres_num;
	private String phpres_code;
	private String phpres_medlcode;
	private int phpres_total_admin;
	private String phpres_taking_time;
	private int phpres_prladmin;
	private int phpres_salecnt;
	private int phpres_admin_day;
	
	public ReceiptVO(String phpres_num, String phpres_code, String phpres_medlcode, int phpres_total_admin, String phpres_taking_time,
			int phpres_prladmin, int phpres_salecnt, int phpres_admin_day) {
		super();
		this.phpres_num = phpres_num;
		this.phpres_code = phpres_code;
		this.phpres_medlcode = phpres_medlcode;
		this.phpres_total_admin = phpres_total_admin;
		this.phpres_taking_time = phpres_taking_time;
		this.phpres_prladmin = phpres_prladmin;
		this.phpres_salecnt = phpres_salecnt;
		this.phpres_admin_day = phpres_admin_day;
	}
	
	public String getMedi_name() {
		return medi_name;
	}
	
	public void setMedi_name(String medi_name) {
		this.medi_name = medi_name;
	}

	public ReceiptVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getPhpres_num() {
		return phpres_num;
	}

	public void setPhpres_num(String phpres_num) {
		this.phpres_num = phpres_num;
	}

	public String getPhpres_code() {
		return phpres_code;
	}

	public void setPhpres_code(String phpres_code) {
		this.phpres_code = phpres_code;
	}

	public String getPhpres_medlcode() {
		return phpres_medlcode;
	}

	public void setPhpres_medlcode(String phpres_medlcode) {
		this.phpres_medlcode = phpres_medlcode;
	}

	public int getPhpres_total_admin() {
		return phpres_total_admin;
	}

	public void setPhpres_total_admin(int phpres_total_admin) {
		this.phpres_total_admin = phpres_total_admin;
	}

	public String getPhpres_taking_time() {
		return phpres_taking_time;
	}

	public void setPhpres_taking_time(String phpres_taking_time) {
		this.phpres_taking_time = phpres_taking_time;
	}

	public int getPhpres_prladmin() {
		return phpres_prladmin;
	}

	public void setPhpres_prladmin(int phpres_prladmin) {
		this.phpres_prladmin = phpres_prladmin;
	}

	public int getPhpres_salecnt() {
		return phpres_salecnt;
	}

	public void setPhpres_salecnt(int phpres_salecnt) {
		this.phpres_salecnt = phpres_salecnt;
	}

	public int getPhpres_admin_day() {
		return phpres_admin_day;
	}

	public void setPhpres_admin_day(int phpres_admin_day) {
		this.phpres_admin_day = phpres_admin_day;
	}
	
	
	
	
}
