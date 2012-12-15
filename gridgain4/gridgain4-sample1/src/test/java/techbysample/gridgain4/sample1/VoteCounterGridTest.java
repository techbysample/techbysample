package techbysample.gridgain4.sample1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.gridgain.grid.Grid;
import org.gridgain.grid.GridTaskFuture;
import org.gridgain.grid.typedef.G;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * 
 * @author TechBySample.com
 *
 */


public class VoteCounterGridTest {

	private Grid grid = null;
	
	@Before
	public  void initialize() {
		
		try{
			G.start();
			
			grid = G.grid();
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	

	@Test
	public void testCountVotes()
	{
	    Party[] parties = {Party.DEMOCRAT,Party.REPUBLICAN};
	
		List<Vote> votesTobeCounted = new ArrayList();
		Random randomGenerator = new Random();
		   
		for (int i=0;i<10000;i++)
		{
			int randomInt = randomGenerator.nextInt(2);
			votesTobeCounted.add(new Vote(parties[randomInt]));
		}
		try{
		// Execute task.
		GridTaskFuture<VoteResult> future = grid.execute(VoteCounterGridTask.class, votesTobeCounted);
		
		// Wait for task completion.
		VoteResult  result = future.get();
		
		System.out.println("Democrat vote count=" + result.getResults(Party.DEMOCRAT));
		System.out.println("Republican vote count=" + result.getResults(Party.REPUBLICAN));
		
		if (result.getResults(Party.DEMOCRAT) == result.getResults(Party.REPUBLICAN))
		{
			System.out.println("We have tie!");
		}
		
		if (result.getResults(Party.DEMOCRAT) > result.getResults(Party.REPUBLICAN))
		{
			System.out.println("We have a Democratic president!");
		}
		else{
			System.out.println("We have a Republican president!");
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		 
	}
	
	
	@After
	public void tearDown()
	{
		grid=null;
	}
}
