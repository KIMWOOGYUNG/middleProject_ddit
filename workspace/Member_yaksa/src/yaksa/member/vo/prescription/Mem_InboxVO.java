package yaksa.member.vo.prescription;

public class Mem_InboxVO {
	private String inbox_num;
	private String inbox_memid;
	private String inbox_check;
	private String inbox_phid;
	private String inbox_file;
	private String inbox_date;
	private String pharm_name;
	private String star_rate;
	private String persue;
	
	       
	public Mem_InboxVO() {
		super();
	}
	
	public Mem_InboxVO(String inbox_num, String inbox_memid, String inbox_check, String inbox_phid, String inbox_file,
			String inbox_date) {
		super();
		this.inbox_num = inbox_num;
		this.inbox_memid = inbox_memid;
		this.inbox_check = inbox_check;
		this.inbox_phid = inbox_phid;
		this.inbox_file = inbox_file;
		this.inbox_date = inbox_date;
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
	public String getPharm_name() {
		return pharm_name;
	}
	public void setPharm_name(String pharm_name) {
		this.pharm_name = pharm_name;
	}

	public String getPersue() {
		return persue;
	}

	public void setPersue(String persue) {
		this.persue = persue;
	}

	public String getStar_rate() {
		return star_rate;
	}

	public void setStar_rate(String star_rate) {
		this.star_rate = star_rate;
	}
	
	
}
