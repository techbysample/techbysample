package techbysample.gridgain4.sample1;

import java.io.Serializable;

/**
 * 
 * @author TechBySample.com
 *
 */

public class Vote {

	private Party ballot = null;
	
	public Vote(Party ballot)
	{
	  this.ballot = ballot;
	}
	
	public Party getChoice()
	{
		return ballot;
	}
}
