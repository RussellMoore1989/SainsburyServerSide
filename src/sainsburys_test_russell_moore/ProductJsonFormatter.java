package sainsburys_test_russell_moore;

import com.google.gson.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

public class ProductJsonFormatter {

	public static void main(String[] args) {

		List<Product> listItems = new ArrayList<Product>(); 
		
		try {
			Document doc = Jsoup.connect("https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk/webapp/wcs/stores/servlet/gb/groceries/berries-cherries-currants6039.html").get();
			Elements temp = doc.select("li.gridItem");
			
			for(Element productList:temp) {
				Product product = new Product();
				product.setTitle(productList.getElementsByTag("a").first().text());
				
				String priceString = productList.getElementsByTag("p").first().text();
				priceString = priceString.replace("£", "");
				priceString = priceString.replace("/unit", "");
				double price = Double.parseDouble(priceString);
				product.setUnitPrice(price);
				
				String url = productList.getElementsByTag("a").first().attr("abs:href");
				Document docProduct = Jsoup.connect(url).get();
				
				product.setDescription(docProduct.select("div.productText").first().select("p").first().text());
				
				if (!(docProduct.select("tbody").isEmpty())){
					
					String energyString = docProduct.select("tbody").select("tr").first().select("td").first().text();
					energyString = energyString.replace("kJ", "");
					double energy = Double.parseDouble(energyString);
					product.setKCal(energy);
				}
				
				listItems.add(product);
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		double subTotalPrice = 0;
		double vatPrice = 0;
		double totalPrice = 0;
		
		Iterator<Product> iterator  = listItems.iterator();
		
		while(iterator.hasNext()) {
			subTotalPrice = subTotalPrice + ((Product) iterator.next()).getUnitPrice();
		}
		
		vatPrice = (subTotalPrice /100) *20;
		vatPrice = vatPrice *100;
		vatPrice = (double)((int) vatPrice);
		vatPrice = vatPrice /100;
		
		totalPrice = vatPrice + subTotalPrice;
		
		Total total = new Total(vatPrice, totalPrice);
		
		JsonFormat jsonFormat = new JsonFormat(listItems, total);
		
		Gson gson = new Gson();
		String json = gson.toJson(jsonFormat);
		
		try {
			FileWriter file = new FileWriter("test.json");
			file.write(json.toString());
			file.flush();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Done");

	}

}
