package com.Package.Dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Package.Entity.Movie;

@Service
public interface MovieDao{
	
	/*public boolean insert(Movie movie);
	
	public List<Movie> getAllMovies();
	
	public boolean delete(long movie_id);
	
	public boolean update(Movie movie);
	
	public Movie getMovieById(long movie_id);*/
	
		//public boolean insert(Movie movie);
	
	   public List < Movie > getMovie();

	    public void saveMovie(Movie movie);

	    public Movie getMovie(int movie_id);

	    public void deleteMovie(int movie_id);
	    
	    public boolean update(Movie movie);
}
