package techbysample.gridgain4.sample1;

import java.util.Collection;
import java.util.List;

import org.gridgain.grid.GridException;
import org.gridgain.grid.GridJobAdapterEx;

/**
 * 
 * @author TechBySample.com
 *
 */


public class VoteCounterGridJob extends GridJobAdapterEx {

	private Collection<Vote> votes = null;
	
	private int democratNumOfVotes = 0;
	private int republicanNumOfVotes = 0;
	
	public VoteCounterGridJob(Collection<Vote> votes)
	{
		this.votes=votes;
	}

	public VoteResult execute() throws GridException {
		// TODO Auto-generated method stub
		VoteResult result = new VoteResult();
		for (Vote vote : votes)
		{
			if (Party.DEMOCRAT.equals(vote.getChoice()))
			{
				democratNumOfVotes = democratNumOfVotes + 1;
			}
			
			else{
				republicanNumOfVotes = republicanNumOfVotes + 1;
			}
		}
		
		result.setResults(Party.DEMOCRAT,democratNumOfVotes);
		result.setResults(Party.REPUBLICAN,republicanNumOfVotes);
		
		System.out.println("Local vote results: " + result.toString());
		return result;
	}

	
	

}
