package uk.syntel.hackathon.sis.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uk.syntel.hackathon.sis.app.beans.Application;
import uk.syntel.hackathon.sis.app.beans.Customer;
import uk.syntel.hackathon.sis.app.service.SisService;

@RestController
public class SisController {

	@Autowired
	SisService service;

	@GetMapping("/getCustomers")
	public List<Customer> getCustomers() {
		List<Customer> customers = service.getCustomers();
		return customers;
	}

	@GetMapping("/getApplications")
	public List<Application> getApplications() {
		  List<Application> applications = service.getApplications();
          return applications;
	}
	
	@PostMapping("/updateCustomer")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return service.updateCustomer(customer);
	}
	
	@PostMapping("/updateApplication")
	public Application updateApplication(@RequestBody Application application) {
		return service.updateApplication(application);
	}

}
