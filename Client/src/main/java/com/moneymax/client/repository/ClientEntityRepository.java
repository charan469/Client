package com.moneymax.client.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.moneymax.client.model.ClientEntityModel;

@Repository
public class ClientEntityRepository 
{
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	class ClientRowMapper implements RowMapper<ClientEntityModel>
	{
		@Override
		public ClientEntityModel mapRow(ResultSet rs, int rowNum) throws SQLException
		{
			ClientEntityModel clientEntityModel = new ClientEntityModel();
			DateFormat df = new SimpleDateFormat("DD-MM-YYYY");
			
			clientEntityModel.setClientEntitySeqNo(rs.getString("ClientEntitySeqNo"));
			clientEntityModel.setClientGUID(rs.getString("ClientGUID"));
			clientEntityModel.setMappedEntityID(rs.getString("MappedEntityID"));
			clientEntityModel.setMappedAccountCurrency(rs.getString("MappedAccountCurrency"));
			clientEntityModel.setMappedAccountReference(rs.getString("MappedAccountReference"));
			clientEntityModel.setCreateDateTime(df.format(rs.getString("CreateDateTime")));
			clientEntityModel.setLastModifiedDateTime(df.format(rs.getString("LastModifiedDateTime")));
			
			return clientEntityModel;
		}
	}
	
	public List<ClientEntityModel> get() 
	{
		return jdbcTemplate.query("SELECT * FROM ClientEntity", new ClientRowMapper());
	}
	
	public ClientEntityModel find(ClientEntityModel clientEntityModel) 
	{
		return jdbcTemplate.queryForObject("SELECT * FROM ClientEntity WHERE ClientEntitySeqNo=?", new Object[] {clientEntityModel.getClientEntitySeqNo()}, new BeanPropertyRowMapper<ClientEntityModel>(ClientEntityModel.class));
	}
	
	public int insert(ClientEntityModel clientEntityModel) 
	{
		int count = 0;
		try
		{	
			SimpleDateFormat formatter = new SimpleDateFormat("DD-MM-YYYY hh:mm:ss");
			
			Date createDateTime = new Date(System.currentTimeMillis());
			System.out.println(formatter.format(createDateTime));
			
			count = jdbcTemplate.update("INSERT INTO ClientEntity(ClientEntitySeqNo, ClientGUID, MappedEntityID, MappedAccountCurrency, MappedAccountReference, CreateDateTime) VALUES(?, ?, ?, ?, ?, ?)",
					new Object[] {clientEntityModel.getClientEntitySeqNo(), clientEntityModel.getClientGUID(), clientEntityModel.getMappedEntityID(), clientEntityModel.getMappedAccountCurrency(), clientEntityModel.getMappedAccountReference(), createDateTime});
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

	
	public int update(ClientEntityModel clientEntityModel)
	{
		int count=0;
		try
		{	
            SimpleDateFormat formatter = new SimpleDateFormat("DD-MM-YYYY hh:mm:ss");
			
			Date lastModifiedDateTime = new Date(System.currentTimeMillis());
			System.out.println(formatter.format(lastModifiedDateTime));
			
			count = jdbcTemplate.update("UPDATE ClientEntity SET ClientGUID=?, MappedEntityID=?, MappedAccountCurrency=?, MappedAccountReference=?, LastModifiedDateTime=? WHERE ClientEntitySeqNo=?", 
					new Object[] {clientEntityModel.getClientGUID(), clientEntityModel.getMappedEntityID(), clientEntityModel.getMappedAccountCurrency(), clientEntityModel.getMappedAccountReference(), lastModifiedDateTime, clientEntityModel.getClientEntitySeqNo()});
		}
		catch(Exception ex)
		{
			count=0;
			ex.printStackTrace();
		}
		return count;
	}
	
}
	
//	public ClientEntityModel signIn(ClientEntityModel clientEntityModel)
//	{		
//		ClientEntityModel carrier = null;
//		try 
//		{
//			carrier = jdbcTemplate.queryForObject("SELECT ClientEntitySeqNo, ClientGUID FROM ClientEntity WHERE ClientEntitySeqNo=?", new Object[] {clientEntityModel.getClientEntitySeqNo()}, new BeanPropertyRowMapper<ClientEntityModel>(ClientEntityModel.class));
//		} 
//		catch (EmptyResultDataAccessException edx)
//		{
//			edx.printStackTrace();
//			return null;
//		}
//		catch (DataAccessException e) 
//		{ 
//			e.printStackTrace();
//			return null;
//		}
//		return carrier;
//	}
//	
//	
//	public int delete(ClientEntityModel clientEntityModel) 
//	{
//		int count=0;
//		try
//		{
//			count = jdbcTemplate.update("DELETE FROM ClientEntity WHERE ClientEntitySeqNo=?", new Object[] {clientEntityModel.getClientEntitySeqNo()});
//		}
//		catch(Exception ex)
//		{
//			count=0;
//			ex.printStackTrace();
//		}
//		return count;
//	}
