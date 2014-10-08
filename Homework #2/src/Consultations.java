
public class Consultations extends Products {

	
	private String consultantPersonCode;
	private double hourlyFee;
	
	Consultations(String productCode, String productType, String productName, String consultantPersonCode, double hourlyFee){
		super(productCode, productType, productName);
		this.consultantPersonCode = consultantPersonCode;
		this.hourlyFee = hourlyFee;
	}
		
		//getter for privateConsultantCode
		public String getConsultantPersonCode(){
			return this.consultantPersonCode;
		}
		
		//getter for hourlyFee
		public double getHourlyFee(){
			return this.hourlyFee;
		}
		
}
