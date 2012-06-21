package techbysample.jgap3.sample1;
 
import java.util.ArrayList;
 
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;
 
import junit.framework.Assert;
 
import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.DefaultFitnessEvaluator;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;
import org.jgap.impl.SwappingMutationOperator;
import org.junit.Before;
import org.junit.Test;
 
import techbysample.jgap3.sample1.fitness.MovieFitnessFunction;
import techbysample.jgap3.sample1.model.Movie;
 
/**
 *
 * @author TechBySample.com
 *
 */
 
public class TestMovieFitness {
 
    private Configuration conf;
    private SwappingMutationOperator swapper;
    private MovieFitnessFunction fitnessFunction=null;
    private List movies = new ArrayList();
    private List genres = new ArrayList();
 
    private  static final int MAX_ALLOWED_EVOLUTIONS = 1500;
    private Chromosome movieChromosome = null;
 
    @Before
    public void initialize() throws Exception
    {
 
     String sGenres = System.getProperty("GENRES");
     Assert.assertNotNull("GENRES System property not set. Please provide GENRES information.", sGenres );
 
      StringTokenizer st = new StringTokenizer(sGenres, ",");
 
       while (st.hasMoreElements())
        {
           String genre = st.nextToken();
           genres.add(genre);
        }
 
       movies = this.loadMovies();
 
       conf = new DefaultConfiguration();
       Configuration.resetProperty(Configuration.PROPERTY_FITEVAL_INST);
       conf.setFitnessEvaluator(new DefaultFitnessEvaluator());
       conf.getGeneticOperators().clear();
 
       swapper = new SwappingMutationOperator(conf);
       conf.addGeneticOperator(swapper);
       conf.setPreservFittestIndividual(true);
       conf.setPopulationSize(1000);
       conf.setKeepPopulationSizeConstant(false);
 
       fitnessFunction = new MovieFitnessFunction(movies,genres);
 
       conf.setFitnessFunction( fitnessFunction );
 
       Gene[] movieGenes = new Gene[ 3 ];
 
       movieGenes[0] = new IntegerGene(conf, 0, movies.size()-1 );
       movieGenes[1] = new IntegerGene(conf, 0, movies.size()-1);
       movieGenes[2] = new IntegerGene(conf, 0, movies.size()-1);
 
       movieChromosome = new Chromosome(conf, movieGenes );
       movieGenes[0].setAllele(new Integer(0));
       movieGenes[1].setAllele(new Integer(1));
       movieGenes[2].setAllele(new Integer(3));
 
       conf.setSampleChromosome( movieChromosome );
 
    }
 
    private List loadMovies()
    {
         List list = new ArrayList();
 
          Movie movie1 = new Movie();
          movie1.setName("The Matrix");
          movie1.setImdbRating(7);
          List genre1 = new ArrayList();
          genre1.add("SciFi");
          genre1.add("Action");
          movie1.setGenre(genre1);
          movie1.setRating("PG-13");
          movie1.setYear("1999");
 
          Movie movie2 = new Movie();
          movie2.setName("The Dark Knight");
          movie2.setImdbRating(9.6);
          List genre2 = new ArrayList();
          genre2.add("Action");
          movie2.setGenre(genre2);
          movie2.setRating("PG-13");
          movie2.setYear("2008");
          
          Movie movie3 = new Movie();
          movie3.setName("The Avengers");
          movie3.setImdbRating(9.6);
          movie3.setYear("2012");
          
          List genre3 = new ArrayList();
          genre3.add("Action");
          movie3.setGenre(genre3);
          movie3.setRating("PG-13");
 
          Movie movie4 = new Movie();
          movie4.setName("The Hangover");
          movie4.setImdbRating(7.6);
          List genre4 = new ArrayList();
          genre4.add("Comedy");
          movie4.setGenre(genre4);
          movie4.setRating("R");
          movie4.setYear("2009");
 
          Movie movie5 = new Movie();
          movie5.setName("The Hangover 2");
          movie5.setImdbRating(9.6);
          List genre5 = new ArrayList();
          genre5.add("Comedy");
          movie5.setGenre(genre5);
          movie5.setRating("R");
          movie5.setYear("2012");
 
          Movie movie6 = new Movie();
          movie6.setName("This Means War");
          movie6.setImdbRating(6.4);
          List genre6 = new ArrayList();
          genre6.add("Comedy");
          genre6.add("Action");
          genre6.add("Romance");
          movie6.setGenre(genre6);
          movie6.setRating("PG-13");
          movie6.setYear("2012");
          
          Movie movie7 = new Movie();
          movie7.setName("Hitch");
          movie7.setImdbRating(10);
          List genre7 = new ArrayList();
          genre7.add("Comedy");
          genre7.add("Romance");
          movie7.setGenre(genre7);
          movie7.setRating("PG-13");
          movie7.setYear("2005");
 
          Movie movie8 = new Movie();
          movie8.setName("21 Jump Street");
          movie8.setImdbRating(6.7);
          List genre8 = new ArrayList();
          genre8.add("Comedy");
          genre8.add("Action");
          movie8.setGenre(genre8);
          movie8.setRating("R");
          movie8.setYear("2012");
 
          Movie movie9 = new Movie();
          movie9.setName("Killers");
          movie9.setImdbRating(5.1);
          List genre9 = new ArrayList();
          genre9.add("Comedy");
          genre9.add("Action");
          genre9.add("Romance");
          movie9.setGenre(genre9);
          movie9.setRating("PG-13");
          movie9.setYear("2010");
          
          Movie movie10 = new Movie();
          movie10.setName("What to Expect When You're Expecting");
          movie10.setImdbRating(5.1);
          List genre10 = new ArrayList();
          genre10.add("Comedy");
          genre10.add("Romance");
          movie10.setGenre(genre10);
          movie10.setRating("PG-13");
          movie10.setYear("2012");
 
          Movie movie11 = new Movie();
          movie11.setName("Anchorman");
          movie11.setImdbRating(6.9);
          List genre11 = new ArrayList();
          genre11.add("Comedy");
          movie11.setGenre(genre11);
          movie11.setRating("R");
          movie11.setYear("2009");
 
          Movie movie12 = new Movie();
          movie12.setName("Safe House");
          movie12.setImdbRating(8);
          List genre12 = new ArrayList();
          genre12.add("Action");
          movie12.setGenre(genre12);
          movie12.setRating("R");
          movie12.setYear("2012");
 
          Movie movie13 = new Movie();
          movie13.setName("Bridesmaids");
          movie13.setImdbRating(6.9);
          List genre13 = new ArrayList();
          genre13.add("Comedy");
          genre13.add("Romance");
          movie13.setGenre(genre13);
          movie13.setRating("R");
          movie13.setYear("2011");
 
          Movie movie14 = new Movie();
          movie14.setName("American Reunion");
          movie14.setImdbRating(7.4);
          List genre14 = new ArrayList();
          genre14.add("Comedy");
          movie14.setGenre(genre14);
          movie14.setRating("R");
          movie14.setYear("2012");
          
          Movie movie15 = new Movie();
          movie15.setName("Love Happens");
          movie15.setImdbRating(5.5);
          List genre15 = new ArrayList();
          genre15.add("Romance");
          movie15.setGenre(genre15);
          movie15.setRating("PG-13");
          movie15.setYear("2009");
 
          list.add(movie1);
          list.add(movie2);
          list.add(movie3);
          list.add(movie4);
          list.add(movie5);
          list.add(movie6);
          list.add(movie7);
          list.add(movie8);
          list.add(movie9);
          list.add(movie10);
          list.add(movie11);
          list.add(movie12);
          list.add(movie13);
          list.add(movie14);
          list.add(movie15);
          
          return list;
 
    }
 
    @Test
    public void testSelectFittestMovies() throws Exception
    {
 
        movies = this.loadMovies();
 
        Genotype population = Genotype.randomInitialGenotype( conf );
 
        IChromosome bestSolutionSoFar=movieChromosome;
 
        for( int i = 0; i < MAX_ALLOWED_EVOLUTIONS; i++ )        {    
        	population.evolve();         
        	IChromosome candidateBestSolution = population.getFittestChromosome();      
        	if (candidateBestSolution.getFitnessValue()>bestSolutionSoFar.getFitnessValue())
            {
                bestSolutionSoFar = candidateBestSolution;
            }
        }
          printSolution(bestSolutionSoFar,movies);
    }
 
    public void printSolution(IChromosome solution, List<Movie> movies)
    {
        System.out.println("#################################################################################################################");
        System.out.println("Fitness value: " + solution.getFitnessValue());
 
            for (int i = 0; i < solution.size(); i++) {
                int index = (Integer) solution.getGene(i).getAllele();
                  Movie movie = movies.get(index);
                  System.out.println(movie.toString());
                }
        System.out.println("#################################################################################################################");
    }
}