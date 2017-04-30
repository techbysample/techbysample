package techbysample.ignite.sample1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.apache.ignite.IgniteException;
import org.apache.ignite.cluster.ClusterNode;
import org.apache.ignite.compute.ComputeJob;
import org.apache.ignite.compute.ComputeJobResult;
import org.apache.ignite.compute.ComputeTaskAdapter;
import techbysample.ignite.sample1.model.Survey;


/**
 * 
 * @author TechBySample.com
 *  
 *  
 * Provides an example to demonstrate Apache Ignite's distributive features.
 * 
 * using CalculateSurveyTask and CalculateSurveyJob.
 * 
 * List of surveys are passed as task argument and distributed with CalculateSurveyJob among cluster nodes.
 * 
 * CalculateSurveyJob is responsible for totaling score for individual Surveys.
 *  
 * Each CalculateSurveyJob calculates an individual Survey and returns result to master node where average 
 * survey score is calculated in reduce method.
 *
 * NOTE:
 * 
 * Remote nodes should always be started with special configuration file which
 * enables Peer to Peer class loading.
 * 
 * 
 *  IE: 'ignite.{sh|bat} ../ignite-sample1/config/sample1-ignite.xml'.
 *
 */
public class CalculateSurveyTask extends ComputeTaskAdapter<List<Survey>, Double>  {


	/**
	 *  Map creates CalculateSurveyJobs and randomly assigns to available nodes
	 *  
	 */
	public Map<? extends ComputeJob, ClusterNode> map(List<ClusterNode> nodes, List<Survey> list)
			throws IgniteException {
		
		Map<ComputeJob, ClusterNode> map = new HashMap<>();
		for (Survey survey: list)
		{
			int min=0;
			int max = nodes.size()-1;
			
			//Randomly select a node fron curent list of nodes.
			Random r = new Random();
			
			int nodeToSelect =r.nextInt((max - min) + 1) + min;
			
			CalculateSurveyJob job = new CalculateSurveyJob(survey);
			map.put(job, nodes.get(nodeToSelect));
		}
        return map; 
	}
	
	/**
	 * 
	 *  Reduce sums individual results from ALL surveys to calculate average survey score
	 *  
	 */
	public Double reduce(List<ComputeJobResult> list) throws IgniteException {
		
	   double sum = 0;
	   
	   for (ComputeJobResult result : list)
	   {
		   double avalue = result.getData();
		   sum = sum + avalue;
	   }
	   double result = sum /list.size();
	   return result;
	}
    
	

}
