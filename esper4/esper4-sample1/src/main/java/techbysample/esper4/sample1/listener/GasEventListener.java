package techbysample.esper4.sample1.listener;

import techbysample.esper4.sample1.model.GasEvent;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

/**
 * 
 * @author TechbySample.com
 *
 */
public class GasEventListener implements UpdateListener {

	@Override
	public void update(EventBean[] newEvents, EventBean[] arg1) {
		// TODO Auto-generated method stub
		 
	   GasEvent event = (GasEvent)newEvents[0].getUnderlying();
	
       System.out.println("Let's buy some gas! @");
       System.out.println("Store Name: " + event.getStore().getStoreName());
       System.out.println("Store Zip: " + event.getStore().getZipCode());
       System.out.println("Gas Grade: " + event.getGrade());
       System.out.println("Gas Price: " + event.getPrice());
       
	}

}
