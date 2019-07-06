package com.marcelocarvalho.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelocarvalho.cursomc.domain.Client;
import com.marcelocarvalho.cursomc.repositories.ClientRepository;
import com.marcelocarvalho.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	public Client find(Integer id) {
		Optional<Client> obj = clientRepository.findById(id); 	
		return obj.orElseThrow(()-> new ObjectNotFoundException ("Object not found! ID: "+ id +", Type :" + Client.class.getName()));
				
				
	}
	
}
