package com.Package.Dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Package.Entity.Movie;
import com.Package.Entity.ShowMovie;
import com.Package.Entity.CompositeModelDto;
@Service
public interface MovieDao{
	
	
	
		//public boolean insert(Movie movie);
	
	   public List < Movie > getMovie();

	    public void saveMovie(Movie movie, ShowMovie showmovie);

	    public Movie getMovie(int movie_id);

	    public void deleteMovie(int movie_id);
	    
	   // public boolean update(Movie movie);

		//public ResponseEntity<Movie> getMovie(Integer movie_id, @Valid Movie movie);
}
