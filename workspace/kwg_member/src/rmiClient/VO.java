package rmiClient;

import java.io.File;
import java.io.Serializable;

public class VO implements Serializable{

	private static final long serialVersionUID = -3968825874163608022L;

	private String mem_id;
	private String pharm_id;
	private File file;
		
	public VO() {}

	public VO(String mem_id, String pharm_id, File file) {
		super();
		this.mem_id = mem_id;
		this.pharm_id = pharm_id;
		this.file = file;
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
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	
	
}
