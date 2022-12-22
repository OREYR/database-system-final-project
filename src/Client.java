package net.insurancemanagement.model;

public class Client {
	protected int id;
	protected String lastName;
	protected String firstName;
	protected String middleInitial;
	protected String birthDate;
	protected int age;
	protected String gender;
	protected String ssn;
	protected String mailAddress;
	protected Double fraudRate;
	
	public Client() {
	}
	
	
	public Client(int id, String lastName, String firstName, String middleInitial, String birthDate, 
			int age, String gender, String ssn, String mailAddress, Double fraudRate) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.middleInitial = middleInitial;
		this.birthDate = birthDate;
		this.age = age;
		this.gender = gender;
		this.ssn = ssn;
		this.mailAddress = mailAddress;
		this.fraudRate = fraudRate;
	}
	
	
	public Client(String lastName, String firstName, String middleInitial, String birthDate, 
			int age, String gender, String ssn, String mailAddress, Double fraudRate) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.middleInitial = middleInitial;
		this.birthDate = birthDate;
		this.age = age;
		this.gender = gender;
		this.ssn = ssn;
		this.mailAddress = mailAddress;
		this.fraudRate = fraudRate;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleInitial() {
		return middleInitial;
	}
	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public Double getFraudRate() {
		return fraudRate;
	}
	public void setFraudRate(Double fraudRate) {
		this.fraudRate = fraudRate;
	}
	
}
