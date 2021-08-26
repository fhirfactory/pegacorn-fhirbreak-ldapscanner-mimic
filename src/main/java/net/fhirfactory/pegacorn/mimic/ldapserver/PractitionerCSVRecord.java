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
	private String telephoneNumber;

	@CsvBindByPosition(position = 2)
	private String mobileNumber;

	@CsvBindByPosition(position = 3)
	private String givenName;

	@CsvBindByPosition(position = 4)
	private String surname;

	@CsvBindByPosition(position = 5)
	private String agsNumber;

	@CsvBindByPosition(position = 6)
	private String jobTitle;

	@CsvBindByPosition(position = 7)
	private String preferredName;
	
	@CsvBindByPosition(position = 8)
	private String personalTitle;
	
	@CsvBindByPosition(position = 9)
	private String suffix;
	
	@CsvBindByPosition(position = 10)
	private String pager;
	
	@CsvBindByPosition(position = 11)
	private String department;
	
	@CsvBindByPosition(position = 12)
	private String division;
	
	@CsvBindByPosition(position = 13)
	private String branch;
	
	@CsvBindByPosition(position = 14)
	private String section;
	
	@CsvBindByPosition(position = 15)
	private String subsection;
	
	@CsvBindByPosition(position = 16)
	private String businessUnit;
	
	@CsvBindByPosition(position = 17)
	private String gs1;
	
	@CsvBindByPosition(position = 18)
	private String irn;

	
	public String getEmailAddress() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobile(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAgsNumber() {
		return agsNumber;
	}

	public void setAgsNumber(String agsNumber) {
		this.agsNumber = agsNumber;
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

	public String getPersonalTitle() {
		return personalTitle;
	}

	public void setPersonalTitle(String personalTitle) {
		this.personalTitle = personalTitle;
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

	public String getGS1() {
		return gs1;
	}

	public void setGS1(String gs1) {
		this.gs1 = gs1;
	}

	public String getIRN() {
		return irn;
	}

	public void setIRN(String irn) {
		this.irn = irn;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
}
