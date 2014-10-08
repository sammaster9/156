
public class Persons {

	private String personCode;
	private String name;
	private String personsAddress;
	private String email;
	private String email2;
	private String emailAddress;
	


	public Persons(String personCode, String name, String email, String email2){
		this.personCode = personCode;
		this.name = name;
		this.email = email;
		this.email2 = email2;
	}

	// getter for personCode
	public String getPersonCode(){
		return this.personCode;
	}

	// getter for name
	public String getName(){
		return this.name;
	}


	// getter for address
	public String getPersonsAddress(){
		return this.personsAddress;
	}


	//getter for emailAddress
	public String getEmailAddress(){
		return this.emailAddress;
	}
	

	public String getEmail() {
		return email;
	}

	public String getEmail2() {
		return email2;
	}


}
