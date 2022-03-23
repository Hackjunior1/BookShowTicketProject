package com.Package.Dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Package.Entity.Movie;
import com.Package.Entity.ShowMovie;
import com.Package.Entity.BookingDetails;
import com.Package.Entity.CompositeModelDto;

@Service
public interface MovieDao {

	public List<Movie> getMovie();

	public void saveMovie(Movie movie);

	public Movie getMovie(int movie_Id);

	public void deleteMovie(int movie_id);
	
	public List<BookingDetails> getBookingDetails();

}
