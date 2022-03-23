package com.Package.controllers;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.Package.Dao.MovieDao;
import com.Package.Entity.BookingDetails;
import com.Package.Entity.Movie;

@Controller
@Transactional
@Repository
@EnableWebMvc
//@RequestMapping(value = "/movie", method = RequestMethod.GET)
public class AdminController {

	@Autowired
	private MovieDao movieDaoImpl;

	@RequestMapping(value = "/admin-login") // change login home page name in value attribute.
	public String getAdminLogin() {
		System.out.println("in get admin Method");
		return "admin-login";
	}

	// @GetMapping(value = "/Listmovies")
	@RequestMapping(method=RequestMethod.GET)
	public String listMovies(Model Model) {
		System.out.println(" inside Admin Controller inside List method line 41");
		List<Movie> movies = movieDaoImpl.getMovie();
		System.out.println("flow came back to Admin controller after MovieDAOIMPL line 43");
		Model.addAttribute("movies", movies);
		System.out.println("after setting the model attribute before returning the list line 45");
		return "listmovies";
	}

	@GetMapping("/showForm")
	public String showFormForAdd(Model Model) {
		System.out.println(" inside Admin Controller inside showForm method");
		// Movie movie=new Movie(); Model.addAttribute("movie", movie);
		Model.addAttribute("movie", new Movie());
		return "addmovie";
	}

	// @RequestMapping(value = "/saveMovie", method = RequestMethod.POST)
	@PostMapping("/saveMovie")
	public String saveMovie(@ModelAttribute("movie") Movie movie, Model model) {
		System.out.println(" inside Admin Controller inside SaveMovie method before values inserted line 60");
		movieDaoImpl.saveMovie(movie);
		System.out.println(" inside Admin Controller inside SaveMovie method After values inserted line 62");
		return "redirect:/Listmovies";
	}

	@GetMapping("/updateMovie")
	public String showFormForUpdate(@RequestParam("movieId") int movieId, Model Model) {
		System.out.println(" inside Admin Controller inside updateMovie method  " + movieId);
		System.out.println("movie id is =" + movieId);
		Movie movies = movieDaoImpl.getMovie(movieId);
		// movies.getMovie().setMovieStartDate(new Date());
		// movies.getMovie().setMovieEndDate(new Date());
		Model.addAttribute("movie", movies);
		return "addmovie";
	}

	@GetMapping("/delete")
	public String deleteMovie(@RequestParam("movieId") int movie_id) {
		System.out.println(" inside Admin Controller inside deleteMovie method");
		movieDaoImpl.deleteMovie(movie_id);
		return "redirect:/Listmovies";
	}

	@GetMapping( "/getbookings")
	public String GetBookingDetails(Model Model) {
		System.out.println(" inside Admin Controller inside booking details method line 86");
		List<BookingDetails> Bookings = movieDaoImpl.getBookingDetails();
		System.out.println("flow came back to Admin controller after MovieDAOIMPL line 88");
		Model.addAttribute("bookings", Bookings);
		System.out.println("after setting the model attribute before returning the list line 90");
		return "BookingDetails";
	}

	@RequestMapping("/logout")
	public ModelAndView getLogout() {
		ModelAndView m = new ModelAndView("/admin");
		return m;
	}

}
