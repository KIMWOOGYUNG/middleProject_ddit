package rmiServer;

import java.io.Serializable;

public class PrescriptionVO implements Serializable{
	private static final long serialVersionUID = 5335821493893125731L;
	
	private String fileName;
	private byte[] fileData;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public byte[] getFileData() {
		return fileData;
	}
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
	
	
}
