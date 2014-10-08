
public class Customers {
	
	private String customerNumber;
	private String customerCode;
	private String type;
	private Persons primaryContact;
	private String company;
	
	// constructor for Customers
	public Customers(String customerNumber, String customerCode, String type, Persons primaryContact, String company){
		this.customerCode = customerCode;
		this.type = type;
		this.primaryContact= primaryContact;
		this.company = company;
	}
	public String getCumpany() {
		return company;
	}
	public String getCustomerNumber() {
		return customerNumber;
	}
	public Persons getPrimaryContact() {
		return primaryContact;
	}
	// getter for customerCode
	public String getCustomerCode(){
		return this.customerCode;
	}
	
	// getter for type
	public String getType(){
		return this.type;
	}
		
	// getter for name
	public Persons getPrimaryContactName(){
		return this.primaryContact;
	}
		
	
	
}



