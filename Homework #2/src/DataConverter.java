import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class DataConverter {


	private static void loadFiles() throws IOException {
		// creates ArrayList of Persons to store them and later can be written to XML
		ArrayList<Persons> per = new ArrayList<Persons>();
		ArrayList<Address> a = new ArrayList<Address>();

		try {
			//reads in the file of persons
			Scanner persons = new Scanner(new File("data/Persons.dat"));

			// this is to calculate the total amount of people in the file
			int totalPersons = Integer.parseInt(persons.nextLine());

			// this creates every part of a person with a while loop
			while (persons.hasNextLine()){
				String line = persons.nextLine();
				String tokens [] = line.split(";");
				String personCode = tokens[0];
				String name = tokens[1];
				String personsAddress = tokens[2];
				String tokens2 [] = personsAddress.split(",");
				String street = tokens2[0];
				String city = tokens2[1];
				String state = tokens2[2];
				String zipCode = tokens2[3];
				String country = tokens2[4];
				String emailAddress = null;
				String email = null;
				String email2 = null;
				if (tokens.length > 3){
					emailAddress = tokens[3];
					String tokens3 [] = emailAddress.split(",");
					email = tokens3[0];
					if (tokens3.length >1){
						email2 = tokens3[1];
					}
				}

				// creating an object person
				Persons person = new Persons(personCode, email, email2, name );
				per.add(person);
				
				//creating an address
				Address add = new Address(street, city, state, zipCode, country);
				a.add(add);


			}

			// writes persons to xml file
			XStream xs = new XStream(new DomDriver());
			String personsXML = xs.toXML(per);
			String addressXML = xs.toXML(a);

			PrintWriter personWriter = new PrintWriter(new FileWriter("data/Persons.xml"));
			personWriter.println(personsXML);
			personWriter.println(addressXML);

			personWriter.close();
			persons.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}
		// *****************************************************************************************************
		// this is where Customers starts	
		try {
			Scanner c = new Scanner(new File("data/Customers.dat"));

			int totalCustomers = Integer.parseInt(c.nextLine());

			ArrayList<Customers> customers = new ArrayList<Customers>();

			while(c.hasNextLine()){
				String line = c.nextLine();
				String tokens[] = line.split(";");
				String customerNumber = tokens[0];

				String type = null;
				if (tokens.length > 1){
					type = tokens[1];
				}
				String customerCode = null;
				Persons primaryContact = null;
				boolean found = false;
				if (tokens.length > 2){
					customerCode = tokens[2];
					while(found == false){
						for (int i = 0; i< per.size(); i++){
							if ((per.get(i)).getPersonCode().equals(customerCode)){
								primaryContact = per.get(i);
								found = true;
								break;
							}// closing if 
							else {
								found = false;
							}
						}// closing while(found == false)
					}// closing for
				}
				String company = null;
				if (tokens.length > 3){
					company = tokens[3];
				}
				// now we are creating an object customer
				Customers customer = new Customers(customerNumber,customerCode,type,primaryContact,company);
				customers.add(customer);

			}	
			// writes data to customers xml file
			XStream xs = new XStream(new DomDriver());
			String customersXML = xs.toXML(customers);

			PrintWriter personWriter = new PrintWriter(new FileWriter("data/Customers.xml"));
			personWriter.println(customersXML);

			personWriter.close();
			c.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//************************************************************
		// this is where Products Starts 

		try {
			Scanner p = new Scanner(new File("data/Products.dat"));
			int totalProducts = Integer.parseInt(p.nextLine());

			ArrayList<Object> products = new ArrayList<Object>();

			while(p.hasNextLine()){
				Products pr = null;
				String line = p.nextLine();
				String tokens [] = line.split(";");
				String productCode = tokens[0];
				String productType = tokens[1];
				String productName = tokens[2];
				if (productType.equals("E")){
					double pricePerUnit = 0.00;
					if (tokens.length > 3){
						pricePerUnit = Double.parseDouble(tokens[3]);
					}
					
					// creates an product called equipment
					if (productType.equals("E")){
						pr = new Equipment(productCode,productType,productName,pricePerUnit);
						products.add(pr);
					}
				}
				if (productType.equals("L")){
					double serviceFee = Double.parseDouble(tokens[3]);
					double annualLicenseFee = Double.parseDouble(tokens[4]);
					// creates object Licenses
					pr = new Licenses(productCode,productType,productName,serviceFee, annualLicenseFee);
					products.add(pr);
				}
				if (productType.equals("C")){
					String consultantPersonCode = tokens[3];
					double hourlyFee = Double.parseDouble(tokens[4]);
					// this creates an object call Consultations
					pr = new Consultations(productCode, productType, productName, consultantPersonCode, hourlyFee);
					// adds each consultation to arrayList "products"
					products.add(pr);

				}
			}
			// creating xstream writer to write the data to a XML file
			XStream xs = new XStream(new DomDriver());
			String productsXML = xs.toXML(products);

			PrintWriter personWriter = new PrintWriter(new FileWriter("data/Products.xml"));
			personWriter.println(productsXML);

			p.close();
			personWriter.close();
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}



		//***************************************************************************************************************
		// this starts where invoice file is read in 



	}
	// main ***************************************************
	public static void main(String[] args) throws IOException {
		loadFiles();
	}
}
