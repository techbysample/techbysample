package techbysample.spring3.sample1.dao;

import java.util.List;

import techbysample.spring3.sample1.model.Movie;



public interface MovieDAO {

	public List<Movie>getMoviesByGenre(String genre);
	public void loadAllMovies();
	public int getInvocationCountForGetMoviesByGenre();
}
