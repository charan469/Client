package com.moneymax.client.service;

import java.util.List;
import java.util.Optional;

import com.moneymax.client.model.ClientRegistrationModel;



public interface ClientService {
	
	List<ClientRegistrationModel> getAll();

	Optional<ClientRegistrationModel> findClient(ClientRegistrationModel clientRegistrationModel);
	
	ClientRegistrationModel loginClient(ClientRegistrationModel clientRegistrationModel);

	ClientRegistrationModel insertClient(ClientRegistrationModel clientRegistrationModel);

	ClientRegistrationModel deleteClient(ClientRegistrationModel clientRegistrationModel);

	ClientRegistrationModel updateClient(ClientRegistrationModel clientRegistrationModel);
	
	

}
