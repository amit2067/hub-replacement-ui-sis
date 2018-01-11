package uk.syntel.hackathon.sis.app.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import uk.syntel.hackathon.sis.app.beans.Application;
import uk.syntel.hackathon.sis.app.beans.Customer;
import uk.syntel.hackathon.sis.app.repository.ApplicationRepository;
import uk.syntel.hackathon.sis.app.repository.CustomerRepository;
import uk.syntel.hackathon.sis.app.util.SisConstants;

@Service
public class SisService {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ApplicationRepository appRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
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
	
	public Customer saveCustomer(Customer customer) {
		Customer createdCustomer = customerRepository.save(customer);
		logger.info("SIS : Customer propagated via Kafka - "+customer);
		return createdCustomer;
	}
	
	public Application saveApplication(Application application) {
		Application createdApp = appRepository.save(application);
		logger.info("SIS : Application updated :"+createdApp);
		if (null !=createdApp && null != createdApp.getId()) {
			String result = restTemplate.postForObject(SisConstants.APPLICATION_PUBLISH_URL, createdApp, String.class);
			logger.info("SIS : Application publish to Kafka status :"+result);
		}
		return createdApp;
	}

	public void propogateCustomer(Customer customer) {
		saveCustomer(customer);
	}
	
	public void propogateApplication(Application application) {
		if (SisConstants.SIS.equalsIgnoreCase(application.getCreatedBy())) {
			logger.info("SIS : Application created by self - not inserting");
			return;
		}
		Application propogatedApp = appRepository.save(application);
		logger.info("CLASS : Application propagated via Kafka - "+propogatedApp);
	}

	public Application confirmAttendance(Application application) {
		return saveApplication(application);
	}

}
