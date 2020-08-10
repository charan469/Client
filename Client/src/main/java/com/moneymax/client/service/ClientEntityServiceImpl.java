package com.moneymax.client.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moneymax.client.model.ClientEntityModel;
import com.moneymax.client.repository.ClientEntityRepository;
import com.moneymax.client.util.Constants;

@Service
public class ClientEntityServiceImpl implements ClientEntityService
{
	@Autowired
	ClientEntityRepository clientEntityRepository;
	
	@Override
	public List<ClientEntityModel> getClient()
	{
		return clientEntityRepository.get();	
	}
	
	@Override
	public Optional<ClientEntityModel> findClient(ClientEntityModel clientEntityModel)
	{
		return clientEntityRepository.find(clientEntityModel);
		
	}
	
	@Override
	public ClientEntityModel updateClient(ClientEntityModel clientEntityModel)
	{
		
		int count=0;
		count = clientEntityRepository.update(clientEntityModel);
			
		if(count > 0)
		{
			clientEntityModel.setStatus(Constants.SUCCESS);
			//clientEntityModel.setMessage(Constants.SUCCESS_MSG);
		}
		else
		{
			clientEntityModel.setStatus(Constants.FAILED);
			//clientEntityModel.setMessage(Constants.FAILED_MSG);
		}	
		
		return clientEntityModel;
	}
	
}
	
//	@Override
//	public ClientEntityModel signInClient(ClientEntityModel clientEntityModel) 
//	{
//		ClientEntityModel carrier = null;
//
//		carrier = clientEntityRepository.signIn(clientEntityModel);
//
//		if(carrier == null) 
//		{
//			clientEntityModel.setStatus(Constants.INVALID_SEQ_NO);
//			clientEntityModel.setMessage(Constants.INVALID_SEQ_NO_MSG);
//		} 
//		else if(clientEntityModel.getClientGUID().equals(carrier.getClientGUID())) 
//		{
//			clientEntityModel.setStatus(Constants.SUCCESS);
//			//clientEntityModel.setMessage(Constants.SUCCESS_MSG);
//		}
//        else 
//		{
//        	clientEntityModel.setStatus(Constants.INVALID_GUID);
//        	clientEntityModel.setMessage(Constants.INVALID_GUID_MSG);
//		}
//		return clientEntityModel;
//	}
//	
//	@Override
//	public ClientEntityModel signUpClient(ClientEntityModel clientEntityModel)
//	{
//		int count = 0;
//		count = clientEntityRepository.signUp(clientEntityModel);
//		
//		if(count > 0)
//		{
//			clientEntityModel.setStatus(Constants.SUCCESS);
//			//clientEntityModel.setMessage(Constants.SUCCESS_MSG);
//		}
//		else if(count == -1)
//		{
//			clientEntityModel.setStatus(Constants.DUPLICATE_SEQ_NO);
//			clientEntityModel.setMessage(Constants.DUPLICATE_SEQ_NO_MSG);
//		}
//		else
//		{
//			clientEntityModel.setStatus(Constants.FAILED);
//			//clientEntityModel.setMessage(Constants.FAILED_MSG);
//		}
//		return clientEntityModel;
//	}
//	
//	@Override
//	public ClientEntityModel deleteClient(ClientEntityModel clientEntityModel)
//	{
//		
//		int count=0;
//		count = clientEntityRepository.delete(clientEntityModel);
//		
//		if(count > 0)
//		{
//			clientEntityModel.setStatus(Constants.SUCCESS);
//			//clientEntityModel.setMessage(Constants.SUCCESS_MSG);
//		}
//		else
//		{
//			clientEntityModel.setStatus(Constants.INVALID_SEQ_NO);
//			clientEntityModel.setMessage(Constants.INVALID_SEQ_NO_MSG);
//		}
//		return clientEntityModel;
//	}
