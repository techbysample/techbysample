package techbysample.gridgain4.sample1;

import java.io.Serializable;
import java.util.HashMap;

/**
 * 
 * @author TechBySample.com
 *
 */

    
public class VoteResult implements Serializable {

	private HashMap<Party, Integer> voteResultMap = new HashMap();
	
	public void setResults(Party party, Integer numVotes)
	{
		voteResultMap.put(party, numVotes);
	}
	
	public int getResults(Party party)
	
	{
		return (voteResultMap.get(party));
	}
	
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		
		sb.append("\n");
		sb.append("DEMOCRAT=" + voteResultMap.get(Party.DEMOCRAT) + " votes");
		sb.append("\n");
		sb.append("REPUBLICAN=" + voteResultMap.get(Party.REPUBLICAN) + " votes");
		
		return sb.toString();
		
	}
	
}
