package com.Package.controllers;

import java.io.IOException;
import java.sql.SQLException;

import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;

import org.apache.commons.codec.binary.Base64;
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
import com.Package.Entity.Movie;

@Controller
@Transactional
@Repository
@EnableWebMvc
@RequestMapping(value = "/movie", method = RequestMethod.GET)
public class AdminController {

	@Autowired
	private MovieDao movieDaoImpl;
	
	private ModelAndView mav;
	
	@RequestMapping(value = "/admin-login") // change login home page name in value attribute.
	public String getAdminLogin() {
		System.out.println("in get admin Method");
		return "admin-login";
	}

	@GetMapping(value = "/Listmovies")
	public String listMovies(Model Model,Movie movie) throws SQLException, IOException {
		System.out.println(" inside Admin Controller inside List method line 53");
		
		List<Movie> movies = movieDaoImpl.getMovie();
		
		
		/*
		 * byte[] encodeBase64 = Base64.encode(movie.getImage()); String base64Encoded =
		 * new String(encodeBase64, "UTF-8"); mav.addObject("image", base64Encoded );
		 */
	    
		System.out.println("flow came back to Admin controller after MovieDAOIMPL line 76");
		
		Model.addAttribute("movies", movies);
		
		
		System.out.println("after setting the model attribute before returning the list line 79");
		
		return "listmovies";
	}

	@GetMapping("/showForm")
	public String showFormForAdd(Model Model) {
		System.out.println(" inside Admin Controller inside showForm method");
		/*Movie movie=new Movie();
		Model.addAttribute("movie", movie);*/
		Model.addAttribute("movie", new Movie());

		return "admin-home";
	}

	//@RequestMapping(value = "/saveMovie", method = RequestMethod.POST)
	
	@PostMapping("/saveMovie")
	public String saveMovie(@ModelAttribute("movie") Movie movie,Model model)  throws IOException{

		System.out.println(" inside Admin Controller inside SaveMovie method before values inserted line 88");
		

		model.addAttribute("myfile", movie.getImage());
		movieDaoImpl.saveMovie(movie);
		System.out.println("Image =" + movie.getImage());
		/*model.addAttribute("name", movie.getName());
		model.addAttribute("language", movie.getLanguage());
		model.addAttribute("duration", movie.getDuration());
		model.addAttribute("castname", movie.getCast_names());
		*/
		//System.out.println(" inside Admin Controller inside SaveMovie method before values inserted line 109");

		/*System.out.println("name =" + movie.getName());
		System.out.println("Language =" + movie.getLanguage());
		System.out.println("Duration =" + movie.getDuration());
		System.out.println("Cast's Names =" + movie.getCast_names());
		*/

		return "redirect:/movie/Listmovies";
	}
	
	
	
	@GetMapping("/updateMovie")
	//@PutMapping("/{movieId}")
	//public String showFormForUpdate(@PathVariable(value = "movieId") int movie_id,@Valid @RequestBody Movie movie, Model Model)
	public String showFormForUpdate(@RequestParam("movieId") int movie_id, Model Model)
		{
		System.out.println(" inside Admin Controller inside updateMovie method");
		
		Movie movies = movieDaoImpl.getMovie(movie_id);
		
		
		 movies.setMovieStartDate(new Date()); 
		  movies.setMovieEndDate(new Date()); 
		Model.addAttribute("movie", movies);
		
		/*movies.setImage(movies.getImage());
		movies.setName(movies.getName());
		movies.setLanguage(movies.getLanguage());
		movies.setDuration(movies.getDuration());
		movies.setCast_names(movies.getCast_names());*/
		 //movies = movieDaoImpl.getMovie(movie_id);
		
		return "admin-home";
	}

	@GetMapping("/delete")
	public String deleteMovie(@RequestParam("movieId") int movie_id) {
		System.out.println(" inside Admin Controller inside deleteMovie method");

		movieDaoImpl.deleteMovie(movie_id);
		return "redirect:/movie/Listmovies";
	}


	
	
	
	
	
	
	
	
	
	

	/*
	 * @RequestMapping(value = "/admin/upload", method = RequestMethod.POST) public
	 * ModelAndView upload(@RequestParam("file") CommonsMultipartFile
	 * file, @RequestParam String image, HttpSession session, HttpServletRequest
	 * request) {
	 * System.out.println(" inside Admin Controller inside imageupdate method");
	 * 
	 * String path =
	 * session.getServletContext().getRealPath("/resources/img/movies/");
	 * 
	 * // String fileName=file.getOriginalFilename();
	 * 
	 * Integer movie_id = Integer.parseInt(image); // Long.parseLong(image); Movie
	 * movie = movieDaoImpl.getMovie(movie_id); movie.setImage(image); String
	 * fileName = image;
	 * 
	 * // Blob fileName = Hibernate.createBlob(file.getInputStream());
	 * 
	 * System.out.println(path);
	 * 
	 * try {
	 * 
	 * File f = new File(path + fileName + ".jpg"); if (f.exists()) { boolean res =
	 * f.delete(); if (res) { System.out.println("Deleted"); } byte img[] =
	 * file.getBytes(); BufferedOutputStream out = new BufferedOutputStream(new
	 * FileOutputStream(path + fileName + ".jpg")); out.write(img); out.flush();
	 * out.close(); movieDaoImpl.update(movie); } else { byte img[] =
	 * file.getBytes(); BufferedOutputStream out = new BufferedOutputStream(new
	 * FileOutputStream(path + fileName + ".jpg")); out.write(img); out.flush();
	 * out.close(); movieDaoImpl.update(movie); }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } ModelAndView m = new
	 * ModelAndView("redirect:/movie/AdminHomepage"); return m;
	 * 
	 * }
	 */

	@RequestMapping("/logout")
	public ModelAndView getLogout() {
		ModelAndView m = new ModelAndView("/admin");
		return m;
	}

}

/*
 * @RequestMapping(value = ("/admin/manage-movies"), method = RequestMethod.GET)
 * public ModelAndView getManageMovies(@ModelAttribute("movie") Movie movie,
 * Map<String, Object> model) { List<Movie> list = mi.getAllMovies();
 * List<String> l = new ArrayList<String>(); l.add("Language"); l.add("Hindi");
 * l.add("English"); l.add("Punjabi"); l.add("Telugu"); ModelAndView m = new
 * ModelAndView("manage-movies"); return m; }
 * 
 * @RequestMapping(value = ("/admin/registerMovie"), method =
 * RequestMethod.POST) public ModelAndView registerMovie(Movie movie) { boolean
 * res = mi.insert(movie); ModelAndView m = new
 * ModelAndView("redirect:/admin/manage-movies"); if (res == true) {
 * m.addObject("msg", "added"); } else { m.addObject("msg",
 * "Cannot add movie re-submit"); } return m; }
 * 
 * @RequestMapping(value = ("/admin/updateMovie"), method = RequestMethod.POST)
 * public ModelAndView updateMovie(Movie mov) { mi.update(mov); return new
 * ModelAndView("redirect:/admin/manage-movies"); }
 * 
 * @RequestMapping(value = ("/admin/deleteMovie/{id}"), method =
 * RequestMethod.GET) public ModelAndView deleteMovie(@PathVariable("id") long
 * id) { mi.delete(id); return new
 * ModelAndView("redirect:/admin/manage-movies"); }
 * 
 * @RequestMapping("/admin/manage-movies") public ModelAndView
 * getManageCinemas(@ModelAttribute("cinema") Movie movie, Map<String, Object>
 * model) { List<Movie> list = mi.getAllMovies(); List<String> l = new
 * ArrayList<String>(); l.add("PVR"); ModelAndView m = new
 * ModelAndView("manage-cinemas"); return m; }
 * 
 * @RequestMapping("/logout") public ModelAndView getLogout() { ModelAndView m =
 * new ModelAndView("/admin"); return m; }
 * 
 * /*
 * 
 * @RequestMapping(value = "/admin/add", method = RequestMethod.GET) public
 * ModelAndView addAdmin(@ModelAttribute("admin") Admin admin) { ModelAndView m
 * = new ModelAndView("admin-registration"); return m; }
 */

/*
 * @RequestMapping(value = "/admin/upload", method = RequestMethod.POST) public
 * ModelAndView upload(@RequestParam("file") CommonsMultipartFile
 * file, @RequestParam String image, HttpSession session, HttpServletRequest
 * request) {
 * 
 * String path =
 * session.getServletContext().getRealPath("/resources/img/movies/");
 * 
 * // String fileName=file.getOriginalFilename();
 * 
 * 
 * Long id = Long.parseLong(image); Movie movie = mi.getMovieById(id);
 * movie.setImage(image); String fileName = image;
 * 
 * //Blob fileName = Hibernate.createBlob(file.getInputStream());
 * 
 * System.out.println(path);
 * 
 * try {
 * 
 * File f = new File(path + fileName + ".jpg"); if (f.exists()) { boolean res =
 * f.delete(); if (res) { System.out.println("Deleted"); } byte img[] =
 * file.getBytes(); BufferedOutputStream out = new BufferedOutputStream(new
 * FileOutputStream(path + fileName + ".jpg")); out.write(img); out.flush();
 * out.close(); mi.update(movie); } else { byte img[] = file.getBytes();
 * BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(path
 * + fileName + ".jpg")); out.write(img); out.flush(); out.close();
 * mi.update(movie); }
 * 
 * } catch (Exception e) { e.printStackTrace(); } ModelAndView m = new
 * ModelAndView("redirect:/admin/manage-movies"); return m;
 * 
 * }
 */
