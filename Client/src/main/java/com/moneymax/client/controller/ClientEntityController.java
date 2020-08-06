package com.moneymax.client.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moneymax.client.model.ClientEntityModel;
import com.moneymax.client.service.ClientEntityService;


@RestController
@RequestMapping(path="/client")
@CrossOrigin(origins="*")
public class ClientEntityController 
{
	
	@Autowired
	ClientEntityService clientEntityService;
	
	@GetMapping(path="/get")
	public List<ClientEntityModel> get()
    {
		return clientEntityService.getClient();
    }
    
    @PostMapping(path="/find")
    public Optional<ClientEntityModel> find(@RequestBody final ClientEntityModel clientEntityModel)
    {
    	return clientEntityService.findClient(clientEntityModel);
    }
    
    @PostMapping(path="/signin")
    public ClientEntityModel signIn(@RequestBody final ClientEntityModel clientEntityModel)
    {
    	return clientEntityService.signInClient(clientEntityModel);
    }
	
	@PostMapping(path="/signup")
	public ClientEntityModel signUp(@RequestBody final ClientEntityModel clientEntityModel)
    {
		return clientEntityService.signUpClient(clientEntityModel);
    }
    
    @PostMapping(path="/update")
    public ClientEntityModel update(@RequestBody final ClientEntityModel clientEntityModel)
    {
    	return clientEntityService.updateClient(clientEntityModel);
    }
    
    @PostMapping(path="/delete")
    public ClientEntityModel delete(@RequestBody final ClientEntityModel clientEntityModel)
    {
    	return clientEntityService.deleteClient(clientEntityModel);
    }
    

}
