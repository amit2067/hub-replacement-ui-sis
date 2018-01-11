package uk.syntel.hackathon.sis.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import uk.syntel.hackathon.sis.app.beans.Customer;
import uk.syntel.hackathon.sis.app.service.SisService;

@Component
public class SisCustConsumer {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private SisService service;

	@KafkaListener(topics = "CUSTOMER", group = "HE_SIS")
	public void listen(Customer customer) {
		logger.info("Customer Received via Kafka: " + customer);
		service.propogateCustomer(customer);
	}
	
}
