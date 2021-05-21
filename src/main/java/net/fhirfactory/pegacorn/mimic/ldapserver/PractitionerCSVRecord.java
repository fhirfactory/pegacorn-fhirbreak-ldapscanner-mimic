package net.fhirfactory.pegacorn.mimic.ldapserver;

import com.opencsv.bean.CsvBindByPosition;

/**
 * A CSV bean for practitioner data.
 * 
 * @author Brendan Douglas
 *
 */
public class PractitionerCSVRecord {

	@CsvBindByPosition(position = 0)
	private String email;

	@CsvBindByPosition(position = 1)
	private String telephone;

	@CsvBindByPosition(position = 2)
	private String mobile;

	@CsvBindByPosition(position = 3)
	private String firstName;

	@CsvBindByPosition(position = 4)
	private String lastName;

	@CsvBindByPosition(position = 5)
	private String employeeId;

	@CsvBindByPosition(position = 6)
	private String jobTitle;

	@CsvBindByPosition(position = 7)
	private String preferredName;
	
	@CsvBindByPosition(position = 8)
	private String title;
	
	@CsvBindByPosition(position = 9)
	private String suffix;
	
	@CsvBindByPosition(position = 10)
	private String pager;
	
	@CsvBindByPosition(position = 11)
	private String division;
	
	@CsvBindByPosition(position = 12)
	private String branch;
	
	@CsvBindByPosition(position = 13)
	private String section;
	
	@CsvBindByPosition(position = 14)
	private String subsection;
	
	@CsvBindByPosition(position = 15)
	private String businessUnit;

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getPreferredName() {
		return preferredName;
	}

	public void setPreferredName(String preferredName) {
		this.preferredName = preferredName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getPager() {
		return pager;
	}

	public void setPager(String pager) {
		this.pager = pager;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getSubsection() {
		return subsection;
	}

	public void setSubsection(String subsection) {
		this.subsection = subsection;
	}

	public String getBusinessUnit() {
		return businessUnit;
	}

	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}
}
