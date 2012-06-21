package techbysample.jgap3.sample1.model;

import java.util.List;

/**
 * 
 * @author TechBySample.com
 *
 */

public class Movie {

	private String name;
	private List<String> genre;
	private String rating;
	
	private double imdbRating;
	private String year;
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	public double getImdbRating() {
		return imdbRating;
	}
	public void setImdbRating(double imdbRating) {
		this.imdbRating = imdbRating;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List getGenre() {
		return genre;
	}
	public void setGenre(List<String> genre) {
		this.genre = genre;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Movie [name=" + name + ", genre=" + genre + ", rating="
				+ rating + ", imdbRating=" + imdbRating + ", year=" + year
				+ "]";
	}
	
	
	
}
	
