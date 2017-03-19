package techbysample.websocket.sample1;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.Session;

/**
 * 
 * @author TechBySample.com
 *
 */

@ServerEndpoint("/myechoendpoint")
public class EchoEndpoint {
	
	/**
	 * 
	 *  Method is called when a connection is established.
	 *  
	 * @param session
	 */
	 @OnOpen
	    public void onOpen(Session session){
	        System.out.println(session.getId() + " has opened a connection"); 
	        try {
	            session.getBasicRemote().sendText("Connection Established");
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    }
	 
	
	   /**
	     * Method is called when user closes the connection.
	     * 
	     * Note: You cannot send messages to the client from this method
	     */
	    @OnClose
	    public void onClose(Session session){
	        System.out.println("Session " +session.getId()+" has ended");
	    }
	
	/**
     * Method is called when a user sends a message to this server endpoint.
     * Method intercepts the message and allows us to react accordingly.
     */
    @OnMessage
    public void onMessage(String message, Session session){
        System.out.println("Message from " + session.getId() + ": " + message);
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     *  Method is called when an error occurs.
     *  
     * @param e
     */
	@OnError
	public void onError(Throwable e){
		e.printStackTrace();
	}

}
