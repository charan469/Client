package com.moneymax.client.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.moneymax.client.model.ClientRegistrationModel;
import com.moneymax.client.repository.ClientRepository;
import com.moneymax.client.util.Constants;


@org.springframework.stereotype.Service
public class ClientServiceImpl implements ClientService {
	
	
	@Autowired
	ClientRepository clientRepository;

	@Override
	public ClientRegistrationModel insertClient(ClientRegistrationModel clientRegistrationModel) {

		System.out.println("InsertClient" + clientRegistrationModel.getClientGUID());
		int count = 0;
		count = clientRepository.insertClient(clientRegistrationModel);

		if (count > 0) {

			clientRegistrationModel.setStatus(Constants.LOGIN_SUCCESS);
			clientRegistrationModel.setMessage(Constants.REGISTER_SUCCESS_MSG);
			
		} else if (count == -1) {
			clientRegistrationModel.setStatus(Constants.DUPLICATE);
			clientRegistrationModel.setMessage(Constants.DUPLICATE_REGISTER_MSG);
		}

		else {
			clientRegistrationModel.setStatus(Constants.REGISTER_FAILED);
			clientRegistrationModel.setMessage(Constants.REGISTER_FAILED_MSG);
		}
		return clientRegistrationModel;
	}

	@Override
	public ClientRegistrationModel deleteClient(ClientRegistrationModel clientRegistrationModel) {

		int count = 0;
		count = clientRepository.delete(clientRegistrationModel);

		if (count > 0) {
			clientRegistrationModel.setStatus(Constants.DELETE_SUCCESS);
			clientRegistrationModel.setMessage(Constants.DELETE_SUCCESS_MSG);
		} else {
			clientRegistrationModel.setStatus(Constants.RECORD_NOT_FOUND);
			clientRegistrationModel.setMessage(Constants.NOT_EXISTS_MSG);
		}
		return clientRegistrationModel;
	}

	@Override
	public ClientRegistrationModel updateClient(ClientRegistrationModel clientRegistrationModel) {

		int count = 0;

		try {
			count = clientRepository.update(clientRegistrationModel);
			if (count > 0) {
				clientRegistrationModel.setStatus(Constants.UPDATE_SUCCESS);
				clientRegistrationModel.setMessage(Constants.UPDATE_SUCCESS_MSG);
			} else {
				clientRegistrationModel.setStatus(Constants.UPDATE_FAILED);
				clientRegistrationModel.setMessage(Constants.UPDATE_FAILED_MSG);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return clientRegistrationModel;

	}

	@Override
	public Optional<ClientRegistrationModel> findClient(ClientRegistrationModel clientRegistrationModel) {
		return clientRepository.find(clientRegistrationModel);

	}

//	@Override
//	public ClientRegistrationModel loginClient(ClientRegistrationModel clientRegistrationModel) {
//		// return clientRepository.login(clientRegistrationModel);
//		ClientRegistrationModel optional = null;
//
//		optional = clientRepository.login(clientRegistrationModel);
//
//		if (optional == null) {
//			clientRegistrationModel.setStatus(Constants.RECORD_NOT_FOUND);
//			clientRegistrationModel.setMessage(Constants.NOT_EXISTS);
//
//			return clientRegistrationModel;
//
//		} else {
//
//		//	System.out.println("pw1" + clientRegistrationModel.getClientPassword());
//			//System.out.println("pw1" + optional.getClientPassword());
//		//	if (clientRegistrationModel.getClientPassword().trim().equals(optional.getClientPassword().trim())) {
//			if (clientRegistrationModel.getClientPassword().equals(optional.getClientPassword())) {
//
//			//	System.out.println("pw2" + clientRegistrationModel.getClientPassword());
//			//	System.out.println("pw2" + optional.getClientPassword());
//
//				clientRegistrationModel.setStatus(Constants.LOGIN_SUCCESS);
//				clientRegistrationModel.setMessage(Constants.SUCCESS);
//
//			}
//
//			else {
//
//			//	System.out.println("pw3" + clientRegistrationModel.getClientPassword());
//			//	System.out.println("pw3" + optional.getClientPassword());
//				clientRegistrationModel.setStatus(Constants.INVALID_PASSWORD);
//			//	System.out.println("pw4" + clientRegistrationModel.getClientPassword());
//			//	System.out.println("pw4" + optional.getClientPassword());
//				clientRegistrationModel.setMessage(Constants.INVALID_PASSWORD_MSG);
//			//	System.out.println("pw5" + clientRegistrationModel.getClientPassword());
//			//	System.out.println("pw5" + optional.getClientPassword());
//
//			}
//			return clientRegistrationModel;
//		}
//
//	}

	@Override
	public List<ClientRegistrationModel> getAll() {
		return clientRepository.getAll();

	}

@Override
public ClientRegistrationModel loginClient(ClientRegistrationModel clientRegistrationModel) {
	// TODO Auto-generated method stub
	return null;
}




}
