package yaksa.server.vo.prescription;

import java.io.Serializable;

public class InboxVO implements Serializable{

	private static final long serialVersionUID = 4058051081792913262L;

	private String mem_id;
	private String pharm_id;
	private int fileName;
		
	public InboxVO() {}

	public InboxVO(String mem_id, String pharm_id, int fileName) {
		super();
		this.mem_id = mem_id;
		this.pharm_id = pharm_id;
		this.fileName = fileName;
	}
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getPharm_id() {
		return pharm_id;
	}
	public void setPharm_id(String pharm_id) {
		this.pharm_id = pharm_id;
	}
	public int getFileName() {
		return fileName;
	}
	public void setFileName(int fileName) {
		this.fileName = fileName;
	}
}
