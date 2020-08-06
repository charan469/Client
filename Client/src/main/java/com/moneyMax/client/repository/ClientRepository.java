package com.moneyMax.client.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.moneyMax.client.model.ClientRegistrationModel;

@Repository
public class ClientRepository {
	
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	class ClientRowMapper implements RowMapper<ClientRegistrationModel>
	{
		@Override
		public ClientRegistrationModel mapRow(ResultSet rs, int rowNum) throws SQLException
		{
			ClientRegistrationModel clientRegistrationModel = new ClientRegistrationModel();
			
			clientRegistrationModel.setClientGUID(rs.getString("ClientGUID"));
			clientRegistrationModel.setOAuthProviderID(rs.getString("OAuthProviderType"));
			clientRegistrationModel.setOAuthProviderID(rs.getString("OAuthProviderID"));
			clientRegistrationModel.setOAuthProviderID(rs.getString("OAuthProviderReturnKey"));
			clientRegistrationModel.setEmailID(rs.getString("EmailID"));
			clientRegistrationModel.setMobileCountryCode(rs.getString("MobileCountryCode"));
			clientRegistrationModel.setMobileNumber(rs.getString("MobileNumber"));
			clientRegistrationModel.setRecordStatus(rs.getString("RecordStatus"));
			clientRegistrationModel.setCreatedDateTime(rs.getTimestamp("CreatedDateTime"));
			clientRegistrationModel.setLastModifiedDateTime(rs.getTimestamp("LastModifiedDateTime"));
			
			return clientRegistrationModel;
			
		}
	}

	public int insertClient(ClientRegistrationModel clientRegistrationModel) 
	{
	
		int count = 0;
		System.out.println("InsertClientRepo" + clientRegistrationModel.getClientGUID());
		try
		{
			count = jdbcTemplate.update("INSERT INTO ClientRegistration(ClientGUID, OAuthProviderType, OAuthProviderID, OAuthProviderReturnKey, EmailID, MobileCountryCode, MobileNumber, RecordStatus, CreatedDateTime, LastModifiedDateTime )"+"VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ? )",
					new Object[] {clientRegistrationModel.getClientGUID(), clientRegistrationModel.getOAuthProviderType(), clientRegistrationModel.getOAuthProviderID(), clientRegistrationModel.getOAuthProviderID(), clientRegistrationModel.getEmailID(), clientRegistrationModel.getMobileCountryCode(), clientRegistrationModel.getMobileNumber(), clientRegistrationModel.getRecordStatus(), clientRegistrationModel.getCreatedDateTime(), clientRegistrationModel.getLastModifiedDateTime()});
		}
		catch(DuplicateKeyException dke)
		{
			count=-1;
			dke.printStackTrace();
		}
		catch(Exception ex)
		{
			count=0;
			ex.printStackTrace();
		}
		return count;
		
		
	
	}

	public int delete(ClientRegistrationModel clientRegistrationModel) 
	{
		int count=0;
		try
		{
			count = jdbcTemplate.update("DELETE  FROM ClientRegistration WHERE ClientGUID=?", new Object[] {clientRegistrationModel.getClientGUID()});
		}
		catch(Exception ex)
		{
			count=0;
			ex.printStackTrace();
		}
		return count;
	}

	public int update(ClientRegistrationModel clientRegistrationModel) 
	{
		int count=0;
		try
		{
			count = jdbcTemplate.update("UPDATE ClientRegistration  SET OAuthProviderType=?, OAuthProviderID=?, OAuthProviderReturnKey=?, EmailID=?, MobileCountryCode=?, MobileNumber=?, RecordStatus=?, CreatedDateTime=?, LastModifiedDateTime=? WHERE ClientGUID=? ", 
					new Object[] {clientRegistrationModel.getOAuthProviderType(), clientRegistrationModel.getOAuthProviderID(), clientRegistrationModel.getOAuthProviderReturnKey(), clientRegistrationModel.getEmailID(), clientRegistrationModel.getMobileCountryCode(), clientRegistrationModel.getMobileNumber(), clientRegistrationModel.getRecordStatus(), clientRegistrationModel.getCreatedDateTime(), clientRegistrationModel.getLastModifiedDateTime(), clientRegistrationModel.getClientGUID()});
		}
		catch(Exception ex)
		{
			count=0;
			ex.printStackTrace();
		}
		return count;
	}

	public Optional<ClientRegistrationModel> find(ClientRegistrationModel clientRegistrationModel) 
	{
		return Optional.of(jdbcTemplate.queryForObject("SELECT * FROM ClientRegistration WHERE ClientGUID=?", new Object[] {clientRegistrationModel.getClientGUID()}, new BeanPropertyRowMapper<ClientRegistrationModel>(ClientRegistrationModel.class)));
	}
	
//	public ClientRegistrationModel login(ClientRegistrationModel clientRegistrationModel) 
//	{
////		return Optional.of(jdbcTemplate.queryForObject("SELECT GUID,OAuthProviderReturnKey FROM Client WHERE GUID=?", new Object[] {clientRegistrationModel.getGUID()}, new BeanPropertyRowMapper<ClientRegistrationModel>(ClientRegistrationModel.class)));
//	   
//		ClientRegistrationModel optional =null;
//			
//		try {
//			optional = jdbcTemplate.queryForObject("SELECT GUID,OAuthProviderReturnKey FROM Client WHERE GUID=?", new Object[] {clientRegistrationModel.getGUID()}, new BeanPropertyRowMapper<ClientRegistrationModel>(ClientRegistrationModel.class));
//		} 
//		catch (EmptyResultDataAccessException  ed) {
//			
//			ed.printStackTrace();
//			return null;
//		}
//		
//		
//		catch (DataAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}
//		return optional;
//
//	
//	
//	}

	public List<ClientRegistrationModel> getAll() 
	{
		return jdbcTemplate.query("SELECT * FROM ClientRegistration", new ClientRowMapper());
	}
	
	
	
	

}

