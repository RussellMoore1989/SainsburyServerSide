package sainsburys_test_russell_moore;

public class Product {

	private String title;
	private double unit_price;
	private double kcal_per_100g;
	private String description;
	
	public Product() {
	}
	
	public String getTitle() {
		return title;
	}
	
	public double getUnitPrice() {
		return unit_price;
	}
	
	public double getKCal() {
		return kcal_per_100g;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setUnitPrice(double unit_price) {
		this.unit_price = unit_price;
	}
	
	public void setKCal(double kcal_per_100g) {
		this.kcal_per_100g = kcal_per_100g;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

}
