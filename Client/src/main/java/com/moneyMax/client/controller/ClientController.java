package com.moneyMax.client.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moneyMax.client.model.ClientRegistrationModel;
import com.moneyMax.client.service.ClientService;



@RestController
@CrossOrigin(origins="*")
@RequestMapping(path="/client")

public class ClientController {
	
	@Autowired
	ClientService clientService;
	
	@GetMapping
	public String check()
	{
		return "Successfull";
	}
	
	@GetMapping(path="/get")
	public List<ClientRegistrationModel> getAll()
    {
    	return clientService.getAll();
    }
    
    @PostMapping(path="/find")
    public Optional<ClientRegistrationModel> find(@RequestBody final ClientRegistrationModel clientRegistrationModel)
    {
    	return clientService.findClient(clientRegistrationModel);
    }
    
    @PostMapping(path="/login")
    public ClientRegistrationModel login(@RequestBody final ClientRegistrationModel clientRegistrationModel)
    {
    	return clientService.loginClient(clientRegistrationModel);
    }
	
	@PostMapping(path="/insert")
	public ClientRegistrationModel insert(@RequestBody final ClientRegistrationModel clientRegistrationModel)
    {
    	System.out.println("Insert" + clientRegistrationModel.getClientGUID());
		return clientService.insertClient(clientRegistrationModel);
    }
	
    @PostMapping(path="/delete")
    public ClientRegistrationModel delete(@RequestBody final ClientRegistrationModel clientRegistrationModel)
    {
    	return clientService.deleteClient(clientRegistrationModel);
    }
    
    @PostMapping(path="/update")
    public ClientRegistrationModel update(@RequestBody final ClientRegistrationModel clientRegistrationModel)
    {
    	return clientService.updateClient(clientRegistrationModel);
    }
    
    

}
