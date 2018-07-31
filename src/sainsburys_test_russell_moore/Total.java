package sainsburys_test_russell_moore;

public class Total {

	private double gross;
	private double vatgross;
	
	public Total() {
		// TODO Auto-generated constructor stub
	}
	
	public Total(double gross, double vatgross) {
		this.gross = gross;
		this.vatgross = vatgross;
	}
	
	public double getGross() {
		return gross;
	}
	
	public double getVatGross() {
		return vatgross;
	}
	
	public void setGross(double gross) {
		this.gross = gross;
	}
	
	public void setVatGross(double vatgross) {
		this.vatgross = vatgross;
	}

}
