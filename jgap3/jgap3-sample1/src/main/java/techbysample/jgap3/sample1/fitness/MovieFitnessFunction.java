package techbysample.jgap3.sample1.fitness;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jgap.FitnessFunction;
import org.jgap.IChromosome;
import org.jgap.impl.IntegerGene;

import techbysample.jgap3.sample1.model.Movie;

/**
 * 
 * @author TechBySample.com
 *
 */

public class MovieFitnessFunction extends FitnessFunction{

	List<Movie> movies = new ArrayList();
	List<String> genres = new ArrayList();
	
	public MovieFitnessFunction(List<Movie> movies, List<String> genres)
	{
		this.movies= movies;
		this.genres= genres;
	}
	
	@Override
	protected double evaluate(IChromosome chromosome) {
		double score=0;
        double imdbScore =0;
        
        List dups = new ArrayList();
        int badSolution = 1;
        
		for (int i = 0; i < chromosome.size(); i++) {
			
			IntegerGene agene =  (IntegerGene)chromosome.getGene(i);
			int index = (Integer) chromosome.getGene(i).getAllele(); 
			
		    if (dups.contains(index))
		     {
		      badSolution = 0;
		     }
		    else{
		      dups.add(index);
		    }
		    
			Movie movie = movies.get(index);
			double genreScore = getGenreScore(movie);
			if (genreScore==0)
			{
			 badSolution = 0;
			}
			score = (score + movie.getImdbRating()) + (genreScore);
			  
			}
		return (score*badSolution) ;
	}
	
	
	private double getGenreScore(Movie movie)
	{
		double genreScore= 0;
		Iterator it = this.genres.iterator();
		
		while (it.hasNext())
		{
			String genre = (String) it.next();
			if (movie.getGenre().contains(genre))
			{
			  genreScore = genreScore + 1;	
			}
		}
	  return genreScore;	
	}

}
