package com.moneymax.client.model;

public class ClientEntityModel 
{
	private String clientEntitySeqNo;
	private String clientGUID;
	private String mappedEntityID;
	private String mappedAccountCurrency;
	private String mappedAccountReference;
	private String createDateTime;
	private String lastModifiedDateTime;
	private String status;
	private String message;
	
	
	public String getClientEntitySeqNo() 
	{
		return clientEntitySeqNo;
	}
	public void setClientEntitySeqNo(String clientEntitySeqNo) 
	{
		this.clientEntitySeqNo = clientEntitySeqNo;
	}
	public String getClientGUID() 
	{
		return clientGUID;
	}
	public void setClientGUID(String clientGUID) 
	{
		this.clientGUID = clientGUID;
	}
	public String getMappedEntityID() 
	{
		return mappedEntityID;
	}
	public void setMappedEntityID(String mappedEntityID) 
	{
		this.mappedEntityID = mappedEntityID;
	}
	public String getMappedAccountCurrency() 
	{
		return mappedAccountCurrency;
	}
	public void setMappedAccountCurrency(String mappedAccountCurrency) 
	{
		this.mappedAccountCurrency = mappedAccountCurrency;
	}
	public String getMappedAccountReference() 
	{
		return mappedAccountReference;
	}
	public void setMappedAccountReference(String mappedAccountReference) 
	{
		this.mappedAccountReference = mappedAccountReference;
	}
	public String getCreateDateTime() 
	{
		return createDateTime;
	}
	public void setCreateDateTime(String createDateTime) 
	{
		this.createDateTime = createDateTime;
	}
	public String getLastModifiedDateTime() 
	{
		return lastModifiedDateTime;
	}
	public void setLastModifiedDateTime(String lastModifiedDateTime) 
	{
		this.lastModifiedDateTime = lastModifiedDateTime;
	}
	public String getStatus() 
	{
		return status;
	}
	public void setStatus(String status) 
	{
		this.status = status;
	}
	public String getMessage() 
	{
		return message;
	}
	public void setMessage(String message) 
	{
		this.message = message;
	}
	
}
