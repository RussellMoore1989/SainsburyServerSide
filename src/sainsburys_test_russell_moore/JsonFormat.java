package sainsburys_test_russell_moore;

import java.util.List;

public class JsonFormat {

	private List<Product> results;
	private Total total;
	
	public JsonFormat(List<Product> listItems, Total total) {
		this.results = listItems;
		this.total = total;
	}
	
	public List<Product> getResults() {
		return results;
	}
	
	public Total getTotal() {
		return total;
	}
	
	public void setResults(List<Product> results) {
		this.results = results;
	}
	
	public void setTotal(Total total) {
		this.total = total;
	}
}
