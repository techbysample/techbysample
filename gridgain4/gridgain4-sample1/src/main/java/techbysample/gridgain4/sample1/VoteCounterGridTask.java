package techbysample.gridgain4.sample1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.gridgain.grid.GridException;
import org.gridgain.grid.GridJob;
import org.gridgain.grid.GridJobResult;
import org.gridgain.grid.GridTaskSplitAdapter;

/**
 * 
 * @author TechBySample.com
 *
 */


public class VoteCounterGridTask  extends GridTaskSplitAdapter<List<Vote>, VoteResult> {

	protected Collection split(int gridSize, List<Vote> votes) throws GridException {
		
		List<List<Vote>> dividedVotes = divide(votes,50);
		
		List<GridJob> jobs = new ArrayList<GridJob>(dividedVotes.size());
		
	    for (List _votes: dividedVotes)
	     { 
	    	 jobs.add(new VoteCounterGridJob(_votes));
	     }
		
		return jobs;
		
	}

	public VoteResult reduce(List<GridJobResult> results) throws GridException {
		
		int democrat=0;
		int republican=0;
		
		for (GridJobResult result: results)
		{
			VoteResult voteResult= result.getData();
			
			democrat = democrat + voteResult.getResults(Party.DEMOCRAT);
			republican= republican + voteResult.getResults(Party.REPUBLICAN);
		}
		
		VoteResult _voteResult = new VoteResult();
		_voteResult.setResults(Party.DEMOCRAT, democrat );
		_voteResult.setResults(Party.REPUBLICAN, republican );
		return _voteResult;
	}

	public static <T> List<List<T>> divide(List<T> list, int size)
            throws NullPointerException, IllegalArgumentException {
        if (list == null) {
            throw new NullPointerException("The list parameter is null.");
        }
        if (size <= 0) {
            throw new IllegalArgumentException(
                "The list size parameter must be more than 0.");
        }
        int num = list.size() / size;
        int mod = list.size() % size;
        List<List<T>> ret = new ArrayList<List<T>>(mod > 0 ? num + 1 : num);
        for (int i = 0; i < num; i++) {
            ret.add(list.subList(i * size, (i + 1) * size));
        }
        if (mod > 0) {
            ret.add(list.subList(num * size, list.size()));
        }
        return ret;
    }

}
