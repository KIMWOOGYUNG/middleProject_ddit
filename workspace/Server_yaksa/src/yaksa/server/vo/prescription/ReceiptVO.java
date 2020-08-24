package yaksa.server.vo.prescription;

public class ReceiptVO {
	private String inbox_num;
	private String inbox_memid;
	private String inbox_check;
	private String inbox_phid;
	private String inbox_file;
	private String inbox_date;
	
	
	
	public ReceiptVO(String inbox_num, String inbox_memid, String inbox_check, String inbox_phid, String inbox_file,
			String inbox_date) {
		super();
		this.inbox_num = inbox_num;
		this.inbox_memid = inbox_memid;
		this.inbox_check = inbox_check;
		this.inbox_phid = inbox_phid;
		this.inbox_file = inbox_file;
		this.inbox_date = inbox_date;
	}

	public ReceiptVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getInbox_num() {
		return inbox_num;
	}
	public void setInbox_num(String inbox_num) {
		this.inbox_num = inbox_num;
	}
	public String getInbox_memid() {
		return inbox_memid;
	}
	public void setInbox_memid(String inbox_memid) {
		this.inbox_memid = inbox_memid;
	}
	public String getInbox_check() {
		return inbox_check;
	}
	public void setInbox_check(String inbox_check) {
		this.inbox_check = inbox_check;
	}
	public String getInbox_phid() {
		return inbox_phid;
	}
	public void setInbox_phid(String inbox_phid) {
		this.inbox_phid = inbox_phid;
	}
	public String getInbox_file() {
		return inbox_file;
	}
	public void setInbox_file(String inbox_file) {
		this.inbox_file = inbox_file;
	}
	public String getInbox_date() {
		return inbox_date;
	}
	public void setInbox_date(String inbox_date) {
		this.inbox_date = inbox_date;
	}
	
	
}
