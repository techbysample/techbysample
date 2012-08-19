package techbysample.jersey.sample1;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriBuilder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;
/**
 * 
 * @author TechBySample.com
 *
 */

public class TestHelloWorldService{

	private String hostName =null;
	private String port = null;
	
	@Before
	public void initialize() throws Exception {
		
		hostName = System.getProperty("WEB_SERVICE_HOST");
		port = System.getProperty("WEB_SERVICE_PORT");
		
		if (hostName==null)
		{
			hostName = "localhost";
			System.out.println("No webservice host specified using default");
		}
		if (port==null)
		{
			port = "8080";
			System.out.println("No webservice port specified using default");
		}
	}
	
	@Test
    public void testHelloWorld()
	{
		try{
			ClientConfig config = new DefaultClientConfig();
			Client client = Client.create(config);

			WebResource webResource = client.resource(getBaseURI());
	 
			MultivaluedMap queryParams = new MultivaluedMapImpl();
			queryParams.add("message", "Techbysample.com");
		
			webResource = webResource.path("helloworld").path("sayhello").queryParams(queryParams);
			
			String response = webResource.accept(MediaType.TEXT_PLAIN).get(String.class);
			
		    System.out.println(response);
			
			}
			catch (Exception e)
			{
				System.out.println("Error" + e);
			}
	}
	
	private URI getBaseURI() {
		
		StringBuffer sbUrl = new StringBuffer();
		sbUrl.append("http://");
		sbUrl.append(hostName);
		sbUrl.append(":");
		sbUrl.append(port);
		sbUrl.append("/jersey-sample1/rest");
		
		return UriBuilder.fromUri(
				sbUrl.toString()).build();
	}

    @After
	public void cleanup() 
	{
    	 hostName =null;
    	 port = null;
	}
}
