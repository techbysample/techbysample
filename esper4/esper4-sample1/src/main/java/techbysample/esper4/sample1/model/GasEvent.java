package techbysample.esper4.sample1.model;

/**
 * 
 * @author TechbySample.com
 *
 */
public class GasEvent {

	private Store store;
	private String grade;
	private double price;
	
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
