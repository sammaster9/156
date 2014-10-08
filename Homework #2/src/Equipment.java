
public class Equipment extends Products{

	
	private double pricePerUnit;

	Equipment(String productCode, String productType, String productName, double pricePerUnit){
		super(productCode,productType,productName);
		this.pricePerUnit = pricePerUnit;
	}

	//getter for pricePerUnit
	public double getPricePerUnit(){
		return this.pricePerUnit;
	}

}