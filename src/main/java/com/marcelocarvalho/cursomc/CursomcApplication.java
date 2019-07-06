package com.marcelocarvalho.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marcelocarvalho.cursomc.domain.Address;
import com.marcelocarvalho.cursomc.domain.Category;
import com.marcelocarvalho.cursomc.domain.City;
import com.marcelocarvalho.cursomc.domain.Client;
import com.marcelocarvalho.cursomc.domain.Payment;
import com.marcelocarvalho.cursomc.domain.PaymentCreditCard;
import com.marcelocarvalho.cursomc.domain.PaymentTicket;
import com.marcelocarvalho.cursomc.domain.Product;
import com.marcelocarvalho.cursomc.domain.Request;
import com.marcelocarvalho.cursomc.domain.State;
import com.marcelocarvalho.cursomc.domain.enums.ClientType;
import com.marcelocarvalho.cursomc.domain.enums.PaymentStatus;
import com.marcelocarvalho.cursomc.repositories.AddressRepository;
import com.marcelocarvalho.cursomc.repositories.CategoryRepository;
import com.marcelocarvalho.cursomc.repositories.CityRepository;
import com.marcelocarvalho.cursomc.repositories.ClientRepository;
import com.marcelocarvalho.cursomc.repositories.PaymentRepository;
import com.marcelocarvalho.cursomc.repositories.ProductRepository;
import com.marcelocarvalho.cursomc.repositories.RequestRepository;
import com.marcelocarvalho.cursomc.repositories.StateRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository; 
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private RequestRepository requestRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Computer");
		Category cat2 = new Category(null, "Office");
		
		Product p1 = new Product(null, "computer", 2000.00);
		Product p2 = new Product(null, "printer", 5000.00);
		Product p3 = new Product(null, "mouse", 50.00);
		
		cat1.getProducts().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProducts().addAll(Arrays.asList(p2));
		
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1,cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		
		State est1 = new State(null, "Minas Gerais");
		State est2 = new State(null, "São Paulo");
		
		City c1 = new City(null, "Uberlândia", est1);
		City c2 = new City(null, "São Paulo", est2);
		City c3 = new City(null, "Campinas", est2);
		
		est1.getCities().addAll(Arrays.asList(c1));
		est2.getCities().addAll(Arrays.asList(c2,c3));
		
		stateRepository.saveAll(Arrays.asList(est1, est2));
		cityRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		
		Client cli1 = new Client(null, "Maria Silva", "maria@gmail.com", "36378912377", ClientType.PESSOAFISICA );
		cli1.getFhones().addAll(Arrays.asList("27363323","938383393"));
		
		Address a1 = new Address(null, "Rua Flores", "300", "Apto 303", "Jardim", "16015-290", cli1, c1);
		Address a2 = new Address(null, "Av. Matos", "105", "Sala 800", "Centro", "16015-290", cli1, c2);
		
		cli1.getAdresses().addAll(Arrays.asList(a1,a2));
		
		clientRepository.saveAll(Arrays.asList(cli1));
		addressRepository.saveAll(Arrays.asList(a1,a2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Request req1 = new Request(null, sdf.parse("30/09/2018 00:28 "), cli1, a1);
		Request req2 = new Request(null, sdf.parse("30/09/2018 00:28 "), cli1, a2);
		
		Payment pay1 = new PaymentCreditCard(null, PaymentStatus.QUITADO, req1, 6);
		req1.setPayment(pay1);
		
		Payment pay2 = new PaymentTicket(null,  PaymentStatus.PENDENTE, req2,sdf.parse("20/11/2019 00:00"),null);	
		req2.setPayment(pay2);
		
		cli1.getRequests().addAll(Arrays.asList(req1,req2));
		
		
		requestRepository.saveAll(Arrays.asList(req1, req2));
		paymentRepository.saveAll(Arrays.asList(pay1,pay2));
		
		
	}


}
