
public class Products {

	private String productCode;
	private String productType;
	private String productName;

	public Products(String productCode, String productType, String productName){
		this.productCode = productCode;
		this.productType = productType;
		this.productName = productName;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	//getter for privateConsultantCode
	public String getConsultantPersonCode(){
		return this.getConsultantPersonCode();
	}

	//getter for hourlyFee
	public double getHourlyFee(){
		return this.getHourlyFee();
	}

	//getter for pricePerUnit
	public double getPricePerUnit(){
		return this.getPricePerUnit();
	}

	//getter for serviceFee
	public double getServiceFee(){
		return this.getServiceFee();
	}

	//getter for annualLicenceFee
	public double getAnnualLicenseFee(){
		return this.getAnnualLicenseFee();
	}



}
