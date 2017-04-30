package techbysample.ignite.sample1.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;



/**
 * 
 * @author TechBySample.com
 *
 */
public class Survey implements Serializable{
	
    private int score;
    private Long id;

    private List<Question> questions = new ArrayList();
	private static final AtomicLong ID_GEN = new AtomicLong();

    public Survey()
       {
    	id = ID_GEN.incrementAndGet();
    	  
    	Question q1 = new Question("How would you rate your overall satisfaction with us?");
  		Question q2 = new Question("How would you rate our customer service and support?");
  		Question q3 = new Question("How would you rate the time it took us to respond to your questions/concerns?");
  		Question q4 = new Question("How would you rate our products?");

  	    List<Question> questions = new ArrayList();
  	    
  	    questions.add(q1);
  	    questions.add(q2);
  	    questions.add(q3);
  	    questions.add(q4);
  	    this.setQuestions(questions);
	   }
	 
    
    /**
     * @return Survey ID.
     */
    public Long id() {
        return id;
    }
    /**
     * 
     * @return questions
     */
	public List<Question> getQuestions() {
		return questions;

	}
	/**
	 * 
	 * @param questions
	 */
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	/**
	 * 
	 * @param score
	 */
	public void setScore(int score)
	{
		this.score=score;
	}
	
	/**
	 * 
	 * @return score
	 */
	public int getScore()
	{
		return this.score;
	}

}
