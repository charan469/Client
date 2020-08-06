package com.moneymax.client.service;

import java.util.List;
import java.util.Optional;

import com.moneymax.client.model.ClientEntityModel;

public interface ClientEntityService 
{
	List<ClientEntityModel> getClient();

	Optional<ClientEntityModel> findClient(ClientEntityModel clientEntityModel);
	
	ClientEntityModel signInClient(ClientEntityModel clientEntityModel);

	ClientEntityModel signUpClient(ClientEntityModel clientEntityModel);

	ClientEntityModel updateClient(ClientEntityModel clientEntityModel);
    
	ClientEntityModel deleteClient(ClientEntityModel clientEntityModel);

}
