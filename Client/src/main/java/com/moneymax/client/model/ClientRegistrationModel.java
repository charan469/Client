package com.moneymax.client.model;

import java.sql.Timestamp;

public class ClientRegistrationModel {
	
	
	private String clientGUID;
	private String oAuthProviderType;
	private String oAuthProviderID;
	private String oAuthProviderReturnKey;
	private String emailID;
	private String mobileCountryCode;
	private String mobileNumber;
	private String recordStatus;
	private Timestamp createdDateTime;
	private Timestamp lastModifiedDateTime;
	
	private String status;
	private String message;
	
	
	public String getClientGUID() {
		return clientGUID;
	}
	public void setClientGUID(String clientGUID) {
		this.clientGUID = clientGUID;
	}
	public String getOAuthProviderType() {
		return oAuthProviderType;
	}
	public void setOAuthProviderType(String oAuthProviderType) {
		this.oAuthProviderType = oAuthProviderType;
	}
	public String getOAuthProviderID() {
		return oAuthProviderID;
	}
	public void setOAuthProviderID(String oAuthProviderID) {
		this.oAuthProviderID = oAuthProviderID;
	}
	public String getOAuthProviderReturnKey() {
		return oAuthProviderReturnKey;
	}
	public void setOAuthProviderReturnKey(String oAuthProviderReturnKey) {
		this.oAuthProviderReturnKey = oAuthProviderReturnKey;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getMobileCountryCode() {
		return mobileCountryCode;
	}
	public void setMobileCountryCode(String mobileCountryCode) {
		this.mobileCountryCode = mobileCountryCode;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getRecordStatus() {
		return recordStatus;
	}
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
	public Timestamp getCreatedDateTime() {
		return createdDateTime;
	}
	public void setCreatedDateTime(Timestamp createdDateTime) {
		this.createdDateTime = createdDateTime;
	}
	public Timestamp getLastModifiedDateTime() {
		return lastModifiedDateTime;
	}
	public void setLastModifiedDateTime(Timestamp lastModifiedDateTime) {
		this.lastModifiedDateTime = lastModifiedDateTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	


}


