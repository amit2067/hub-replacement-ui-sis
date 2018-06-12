package uk.syntel.hackathon.sis.app.beans;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;

@Document(collection = "Application")
public class Application {

	@Id
	@ApiModelProperty(notes="Application Id")
	private String id;
	
	@ApiModelProperty(notes="Customer Id")
	private Long customerId;
	
	@ApiModelProperty(notes="HEI Code")
	private String heiCode;
	
	@ApiModelProperty(notes="Course Code")
	private String courseCode;
	
	@ApiModelProperty(notes="Course Year")
	private String courseYear;
	
	@ApiModelProperty(notes="Tuition fee loan amount")
	private Integer tflAmount;
	
	@ApiModelProperty(notes="Maintenance Loan Amount")
	private Integer mlAmount;
	
	@ApiModelProperty(notes="Created By")
	private String createdBy;
	
	@ApiModelProperty(notes="Attendance Confirmed Indicator")
	private String confirmedAtnInd;

	public Application() {
	}

	public Application(String id, Long customerId, String heiCode, String courseCode, String courseYear,
			Integer tflAmount, Integer mlAmount, String confirmedAtnInd, String createdBy) {
		this.id = id;
		this.customerId = customerId;
		this.heiCode = heiCode;
		this.courseCode = courseCode;
		this.courseYear = courseYear;
		this.tflAmount = tflAmount;
		this.mlAmount = mlAmount;
		this.confirmedAtnInd = confirmedAtnInd;
		this.createdBy = createdBy;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getHeiCode() {
		return heiCode;
	}

	public void setHeiCode(String heiCode) {
		this.heiCode = heiCode;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseYear() {
		return courseYear;
	}

	public void setCourseYear(String courseYear) {
		this.courseYear = courseYear;
	}

	public Integer getTflAmount() {
		return tflAmount;
	}

	public void setTflAmount(Integer tflAmount) {
		this.tflAmount = tflAmount;
	}

	public Integer getMlAmount() {
		return mlAmount;
	}

	public void setMlAmount(Integer mlAmount) {
		this.mlAmount = mlAmount;
	}

	public String getConfirmedAtnInd() {
		return confirmedAtnInd;
	}

	public void setConfirmedAtnInd(String confirmedAtnInd) {
		this.confirmedAtnInd = confirmedAtnInd;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public String toString() {
		return "Application [id=" + id + ", customerId=" + customerId + ", heiCode=" + heiCode + ", courseCode="
				+ courseCode + ", courseYear=" + courseYear + ", tflAmount=" + tflAmount + ", mlAmount=" + mlAmount
				+ ", confirmedAtnInd=" + confirmedAtnInd + ", createdBy=" + createdBy + "]";
	}

}
