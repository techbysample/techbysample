package techbysample.spring3.sample1.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import techbysample.spring3.sample1.dao.MovieDAO;
import techbysample.spring3.sample1.model.Movie;



 /**
 * 
 * @author TechBySample.com
 *
 */
public class MovieDAOImpl implements MovieDAO {

	private static int invocationCountForGetMoviesByGenre = 0 ;
	
	@Cacheable("movies")
	public List<Movie> getMoviesByGenre(String rating) {
		
		invocationCountForGetMoviesByGenre++;
		
	    List movies = new ArrayList();
		
		Movie movie1= new Movie();
		movie1.setTitle("Diehard");
		movie1.setGenre("action");
		movie1.setMovieRating("R");
		
		Movie movie2= new Movie();
		movie2.setTitle("The Dark Knight");
		movie2.setGenre("action");
		movie2.setMovieRating("PG-13");
		
		Movie movie3= new Movie();
		movie3.setTitle("Batman Begins");
		movie3.setGenre("action");
		movie3.setMovieRating("PG-13");
		
		Movie movie4= new Movie();
		movie4.setTitle("The Bourne Identity");
		movie4.setGenre("action");
		movie4.setMovieRating("PG-13");
		
		Movie movie5= new Movie();
		movie5.setTitle("The Bourne Ultimatum");
		movie5.setGenre("action");
		movie5.setMovieRating("PG-13");
		
		movies.add(movie1);
		movies.add(movie2);
		movies.add(movie3);
		movies.add(movie4);
		movies.add(movie5);
		
		System.out.println("Method getMoviesByGenre called " + invocationCountForGetMoviesByGenre + " time(s).") ;
		
		return movies;
	}

	@CacheEvict(value="movies", allEntries=true)
	public void loadAllMovies() {
		System.out.println("Method loadAllMovies has executed.");
	}
	
	public int getInvocationCountForGetMoviesByGenre()
	{
		return invocationCountForGetMoviesByGenre;
	}
}
