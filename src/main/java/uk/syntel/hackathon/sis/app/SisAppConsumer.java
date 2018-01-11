package uk.syntel.hackathon.sis.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import uk.syntel.hackathon.sis.app.beans.Application;
import uk.syntel.hackathon.sis.app.service.SisService;

@Component
public class SisAppConsumer {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SisService service;

	@KafkaListener(topics = "APPLICATION", group = "HE_SIS")
	public void listen(Application application) {
		logger.info("Application Received via Kafka: " + application);
		service.propogateApplication(application);
	}
	
}
