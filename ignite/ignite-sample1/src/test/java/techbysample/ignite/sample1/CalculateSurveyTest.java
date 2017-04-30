package techbysample.ignite.sample1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCompute;
import org.apache.ignite.Ignition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import techbysample.ignite.sample1.model.Question;
import techbysample.ignite.sample1.model.Survey;

/**
 * 
 * @author TechBySample.com
 *
 */

public class CalculateSurveyTest 
{
	private Ignite ignite= null;
	private IgniteCompute compute = null;
	
	@Before
	public void initialize()
	{	
		try {
			  ignite = Ignition.start("config/sample1-config.xml");
			  compute = ignite.compute();
	        }
		catch (Exception e)
		{
			
			System.out.println(e);
		}
		
	}
	
	@Test
	 public void testCalculateSurveys()
	 {
		List<Survey> list = generateSample();
		
		// Execute task on the cluster and wait for its completion.
		// List of Surveys are passed to CalculateSurveyTask
        double avgScore = compute.execute(CalculateSurveyTask.class,list);

        System.out.println("\n\n");
        System.out.println("############################################################################################################################");
        System.out.println("Number of Surveys is : " + list.size());
        System.out.println("Survey average score is : " + avgScore);
        System.out.println("############################################################################################################################");
        
	 }
	
	/**
	 * Utility method to generate sample surveys
	 * @return
	 */
	private List<Survey> generateSample()
	{
	  List<Survey> surveySample = new ArrayList();
	  
	  for (int i=0; i<1000; i++)
	  {
		  Survey survey = new Survey();
		  
		  for (Question question: survey.getQuestions())
		  {
			  Random rn = new Random();
			  int answer = rn.nextInt(3);
			  question.setResponse(answer);
		  }
		  
		  surveySample.add(survey);
	  }
				
	  return surveySample;
	}

	/**
	 *  Clean up resources
	 */
	@After
	public void tearDown()
	{
		ignite=null;
	}
	
	
}
