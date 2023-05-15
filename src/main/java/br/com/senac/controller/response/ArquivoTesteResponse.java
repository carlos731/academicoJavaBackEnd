package br.com.senac.controller.response;

import java.util.Date;

public class ArquivoTesteResponse {
	
	private String fileName;
    private String downloadURL;
    private String fileType;
    private long fileSize;
    private Date time;
    
    
	public ArquivoTesteResponse(String fileName, String downloadURL, String fileType, long fileSize, Date time) {
		super();
		this.fileName = fileName;
		this.downloadURL = downloadURL;
		this.fileType = fileType;
		this.fileSize = fileSize;
		this.time = time;
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getDownloadURL() {
		return downloadURL;
	}
	public void setDownloadURL(String downloadURL) {
		this.downloadURL = downloadURL;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}

}
