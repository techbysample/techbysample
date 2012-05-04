package techbysample.spring3.sample1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import techbysample.spring3.sample1.dao.MovieDAO;



/**
 * 
 * @author TechBySample.com
 *
 */

public class TestMovieDAOSimpleCache{

	private MovieDAO dao = null;
	
	@Before
	public void initialize() throws Exception {
		//Load Spring Context
		String[] configFiles = new String[] {"MovieDAOTest-simplecache-context.xml"};
	    ApplicationContext appContext  = new ClassPathXmlApplicationContext(configFiles);
	    dao = (MovieDAO)appContext.getBean("movieDAO");
	}
	
	@Test
    public void testGetMovies() {
	    String genre ="action";
	    
	    /*
		 * Call getMoviesByGenre an additional 50 times.
		 * Should be called only once.
		 */
	    
		for (int i = 1; i < 51; i++) {
		   dao.getMoviesByGenre(genre);
		}
				
		Assert.assertEquals("Invocation count for method getMoviesByGenre is not 1 but should be.", 1, dao.getInvocationCountForGetMoviesByGenre() );
		
		/*
		 * Load new Movie records
		 * Cache is cleared.
		 */
		dao.loadAllMovies() ;
		
		/*
		 * Call getMoviesByGenre an additional 50 times.
		 */
		for (int i = 1; i < 51; i++) {
			dao.getMoviesByGenre(genre);
		}
		
		Assert.assertEquals("Invocation count for method getMoviesByGenre is not 2 but should be.", 2, dao.getInvocationCountForGetMoviesByGenre() );
	}
	
    @After
	public void cleanup() 
	{
		dao = null;
	}
}
