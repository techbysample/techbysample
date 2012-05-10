package techbysample.javase.sample1.model;

import techbysample.javase.sample1.annotation.NotNullable;


/**
 * 
 * @author TechBySample.com
 *
 */

public class Employee {

	@NotNullable(message="Employee lastName cannot be NULL!")
	private String lastName;
	@NotNullable(message="Employee firstName cannot be NULL!")
	private String firstName;
	private String id;
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
