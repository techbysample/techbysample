package techbysample.ignite.sample1.model;

import java.io.Serializable;

/**
 * 
 * @author TechBySample.com
 *
 */

public class Question implements Serializable{

	private String description;
    private int response;
    
    public Question(String description)
    {
    	this.description = description;
    }
    /**
     * 
     * @return
     */
	public String getDescription() {
		return description;
	}
    /**
     * 
     * @param description
     */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 
	 * @return response
	 */
	public int  getResponse() {
		return response;
	}

	/**
	 * 
	 * @param response
	 */
	public void setResponse(int response) {
		this.response = response;
	}
	
}
