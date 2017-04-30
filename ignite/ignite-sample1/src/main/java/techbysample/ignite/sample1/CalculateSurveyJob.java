package techbysample.ignite.sample1;

import org.apache.ignite.Ignite;     
import org.apache.ignite.IgniteException;
import org.apache.ignite.compute.ComputeJobAdapter;
import org.apache.ignite.resources.IgniteInstanceResource;

import techbysample.ignite.sample1.model.Question;
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
public class CalculateSurveyJob extends ComputeJobAdapter {

   private Survey survey = null;	
	
   @IgniteInstanceResource
   private Ignite ignite = null;
	 
	public CalculateSurveyJob(Survey survey)
	{
		this.survey = survey;
	}
	
	/**
	 *  Calculate survey and return score
	 */
	public Double execute() throws IgniteException {
		double score =0;
		score = calculateSurveyScore();
		System.out.println("Survey Id: " + survey.id() + " has score of:  "+ score);
		return new Double(score);
	}

	/**
	 *  Utility method to calculate a survey's score
	 *  
	 * @return
	 */
	private double calculateSurveyScore()
	{
		double score =0;
		for (Question question: survey.getQuestions())
		{
		  score = score + question.getResponse();
		}
		return score;
	}
}
