package yaksa.server.vo.pay;

public class PayVO {
	private String app_code;
	private String app_date;
	private int app_cost;
	private int app_ph_star;	
	
	public String getApp_code() {
		return app_code;
	}

	public void setApp_code(String app_code) {
		this.app_code = app_code;
	}

	public String getApp_date() {
		return app_date;
	}

	public void setApp_date(String app_date) {
		this.app_date = app_date;
	}

	public int getApp_cost() {
		return app_cost;
	}

	public void setApp_cost(int app_cost) {
		this.app_cost = app_cost;
	}

	public int getApp_ph_star() {
		return app_ph_star;
	}

	public void setApp_ph_star(int app_ph_star) {
		this.app_ph_star = app_ph_star;
	}

	public PayVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
