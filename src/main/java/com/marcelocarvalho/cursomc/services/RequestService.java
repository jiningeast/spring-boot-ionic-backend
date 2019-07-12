package com.marcelocarvalho.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelocarvalho.cursomc.domain.Request;
import com.marcelocarvalho.cursomc.repositories.RequestRepository;
import com.marcelocarvalho.cursomc.services.exceptions.ObjectNotFoundException;
@Service
public class RequestService {


	@Autowired
	private RequestRepository requestRepository;

	public Request find(Integer id) {
		Optional<Request> obj = requestRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id + ", Type: " + Request.class.getName()));
	}
}
