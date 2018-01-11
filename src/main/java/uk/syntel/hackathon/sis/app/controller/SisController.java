package uk.syntel.hackathon.sis.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import uk.syntel.hackathon.sis.app.beans.Application;
import uk.syntel.hackathon.sis.app.beans.Customer;
import uk.syntel.hackathon.sis.app.service.SisService;

@Api(value="SIS service", description="SIS Operations to deal with Customers and Applications")
@RestController
public class SisController {

	@Autowired
	private SisService service;

	@ApiOperation(value = "Retrieve list of customers",response = Iterable.class)
	@GetMapping("/getCustomers")
	public List<Customer> getCustomers() {
		List<Customer> customers = service.getCustomers();
		return customers;
	}

	@ApiOperation(value = "Retrieve list of applications",response = Iterable.class)
	@GetMapping("/getApplications")
	public List<Application> getApplications() {
		  List<Application> applications = service.getApplications();
          return applications;
	}
	
	@ApiOperation(value = "Update details of Customer",response = Customer.class)
	@PostMapping("/updateCustomer")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return service.updateCustomer(customer);
	}
	
	@ApiOperation(value = "Update details of Application",response = Application.class)
	@PostMapping("/updateApplication")
	public Application updateApplication(@RequestBody Application application) {
		return service.updateApplication(application);
	}
		
	@ApiOperation(value = "Confirm attendance against application",response = Application.class)
	@PostMapping("confirmAttendance")
	public Application confirmAttendance(@RequestBody Application application) {
		return service.confirmAttendance(application);
	}

}
