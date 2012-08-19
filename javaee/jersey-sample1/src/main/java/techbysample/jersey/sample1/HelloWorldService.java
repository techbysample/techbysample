package techbysample.jersey.sample1;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * 
 * @author TechBySample.com
 *
 */

@Path("/helloworld")
public class HelloWorldService {

	@GET
	@Path("/sayhello")
	@Produces( MediaType.TEXT_PLAIN)
	public String sayHello(@QueryParam("message")  String msg) {
		String output = "Hello " + msg;
		System.out.println(output);
		return output;
	}

}
