package uk.syntel.hackathon.sis.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.syntel.hackathon.sis.app.beans.Application;
import uk.syntel.hackathon.sis.app.beans.Customer;
import uk.syntel.hackathon.sis.app.repository.ApplicationRepository;
import uk.syntel.hackathon.sis.app.repository.CustomerRepository;

@Service
public class SisService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ApplicationRepository appRepository;
	
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}

	public List<Application> getApplications() {
		return appRepository.findAll();
	}
	
	public Customer updateCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public Application updateApplication(Application application) {
		return appRepository.save(application);
	}

}
