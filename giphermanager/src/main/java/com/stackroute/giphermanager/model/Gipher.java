package com.stackroute.giphermanager.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Gipher {
	
	@Id
	private int gipherId;
	private String gipherTitle;
	private String gipherContent;
	private String gipherStatus;
	private Date gipherCreationDate;
	private String gipherCreatedBy;
	
	public Gipher(){}
	
	public Gipher(int gipherId, String gipherTitle, String gipherContent, String gipherStatus, Date gipherCreationDate,
			String gipherCreatedBy) {
		super();
		this.gipherId = gipherId;
		this.gipherTitle = gipherTitle;
		this.gipherContent = gipherContent;
		this.gipherStatus = gipherStatus;
		this.gipherCreationDate = gipherCreationDate;
		this.gipherCreatedBy = gipherCreatedBy;
	}
	public int getGipherId() {
		return gipherId;
	}
	public void setGipherId(int gipherId) {
		this.gipherId = gipherId;
	}
	public String getGipherTitle() {
		return gipherTitle;
	}
	public void setGipherTitle(String gipherTitle) {
		this.gipherTitle = gipherTitle;
	}
	public String getGipherContent() {
		return gipherContent;
	}
	public void setGipherContent(String gipherContent) {
		this.gipherContent = gipherContent;
	}
	public String getGipherStatus() {
		return gipherStatus;
	}
	public void setGipherStatus(String gipherStatus) {
		this.gipherStatus = gipherStatus;
	}
	public Date getGipherCreationDate() {
		return gipherCreationDate;
	}
	public void setGipherCreationDate(Date gipherCreationDate) {
		this.gipherCreationDate = gipherCreationDate;
	}
	public String getGipherCreatedBy() {
		return gipherCreatedBy;
	}
	public void setGipherCreatedBy(String gipherCreatedBy) {
		this.gipherCreatedBy = gipherCreatedBy;
	}
	
	


}
