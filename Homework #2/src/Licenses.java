
public class Licenses extends Products {

	
	private double serviceFee;
	private double annualLicenseFee;

	Licenses(String productCode, String productType, String productName, double serviceFee, double annualLicenseFee){
		super(productCode,productType,productName);
		
		this.serviceFee = serviceFee;
		this.annualLicenseFee = annualLicenseFee;
	}

	//getter for serviceFee
	public double getServiceFee(){
		return this.serviceFee;
	}

	//getter for annualLicenceFee
	public double getAnnualLicenseFee(){
		return this.annualLicenseFee;
	}

}
