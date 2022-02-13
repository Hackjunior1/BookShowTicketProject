package com.Package.Dao;

import java.util.List;

import com.Package.Entity.Movie;

public interface MovieDao{
	
	public boolean insert(Movie movie);
	public List<Movie> getAllMovies();
	public boolean delete(long movie_id);
	public boolean update(Movie movie);
	public Movie getMovieById(long movie_id);
}
