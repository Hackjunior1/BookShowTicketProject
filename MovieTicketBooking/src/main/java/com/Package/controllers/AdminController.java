package com.Package.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.Package.Dao.MovieDao;
//import com.Package.Entity.Admin;
//import com.Package.Entity.Admin;
import com.Package.Entity.Movie;
import com.Package.Entity.ShowMovie;


@Controller
//@SessionAttributes(value = { "ad", "profile" })
@Transactional
@Repository
@EnableWebMvc
@RequestMapping(value="/movie", method=RequestMethod.GET)
public class AdminController {

	//@Autowired
	//private DateTime dt;

	@Autowired
	private MovieDao movieDaoImpl;
	
	@Autowired
    private SessionFactory sessionFactory;

	@RequestMapping(value = "/admin-login")//change login home page name in value attribute.
	public String getAdminLogin() {
		System.out.println("in get admin Method");
		return "admin-login";
	}

	
   // @Autowired
   // private CustomerService customerService;

    @GetMapping(value="/list")
    public String listMovies(Model Model) {
    	System.out.println(" inside Admin Controller inside List method");
    	
        List < Movie > movies = movieDaoImpl.getMovie();
        Model.addAttribute("movies", movies);
        return "listofmovies";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model Model) {
    	System.out.println(" inside Admin Controller inside showForm method");
    	
        Movie movies = new Movie();
        Model.addAttribute("movies", movies);
        return "admin-home";
    }

    @RequestMapping(value="/saveMovie", method=RequestMethod.POST)
    public String saveMovie(@ModelAttribute("movie") Movie movie, ModelMap model,HttpServletRequest request) {
    	 HttpSession session=request.getSession(); 
    	 
    	 String n=request.getParameter("moviename");
    	session.setAttribute("Mname", n);
    	
    	 
    	System.out.println(" inside Admin Controller inside SaveMovie method before values inserted");
    	
    	
    	ModelMap name=model.addAttribute("Mname", movie.getName());
    	//ModelMap language=model.addAttribute("language",smovie.getLanguage() );
    	ModelMap duration=model.addAttribute("duration", movie.getDuration());
    	ModelMap cast_name=model.addAttribute("castname", movie.getCast_names());
    	ModelMap image=model.addAttribute("myfile", movie.getImage());
    	
    	
    	System.out.println("name getting by request object =" +n);
    	
    
    	
    	System.out.println("name ="+toString(name));
    	//System.out.println("language=" +toString(language));
    	System.out.println("duration = "+toString(duration));
    	System.out.println("cast_names= "+toString(cast_name));
    	System.out.println("image= "+toString(image));
    	
    	movieDaoImpl.saveMovie(movie);
    	
    	return "listofmovies";
    	/*try {
			
			System.out.println("inside adminControlloer class inside insert method in try block");
			
			Session session = sessionFactory.getCurrentSession();
			Transaction t = session.beginTransaction();
			session.save(movie);
			t.commit();
			session.close();
			System.out.println(" inside Admin Controller inside SaveMovie method after values inserted.");
			

		} catch (Exception e) {

			System.out.println("inside Catch in Admin Controller");
			System.out.println("Exception(ADD): " + e);
			//return false;

		}
    	return "listofmovies";*/
    	
    	//System.out.println(" inside Admin Controller inside SaveMovie method after values inserted redirecting to List.");
    	
       //return "redirect:/movie/list";
    }

    private String toString(ModelMap name) {
		// TODO Auto-generated method stub
		return null;
	}


	@GetMapping("/updateMovie")
    public String showFormForUpdate(@RequestParam("movieId") int movie_id, Model Model) {
    	System.out.println(" inside Admin Controller inside updateMovie method");
    	
        Movie movie = movieDaoImpl.getMovie(movie_id);
        Model.addAttribute("movie", movie);
        return "AdminHomepage";
    }

    @GetMapping("/delete")
    public String deleteMovie(@RequestParam("movieId") int movie_id) {
    	System.out.println(" inside Admin Controller inside deleteMovie method");
    	
    	movieDaoImpl.deleteMovie(movie_id);
        return "redirect:/movie/list";
    }
    
    @RequestMapping(value = "/admin/upload", method = RequestMethod.POST)
    public ModelAndView upload(@RequestParam("file") CommonsMultipartFile file, @RequestParam String image,
    		HttpSession session, HttpServletRequest request) {
    	System.out.println(" inside Admin Controller inside imageupdate method");
    	

    	String path = session.getServletContext().getRealPath("/resources/img/movies/");

    	// String fileName=file.getOriginalFilename();

    	
    	  Integer movie_id = Integer.parseInt(image);  //Long.parseLong(image); 
    	  Movie movie = movieDaoImpl.getMovie(movie_id);
    	  movie.setImage(image);
    	  String fileName = image;
    	 
    	//Blob fileName = Hibernate.createBlob(file.getInputStream());

    	System.out.println(path);

    	try {
    		
    		File f = new File(path + fileName + ".jpg");
    		if (f.exists()) {
    			boolean res = f.delete();
    			if (res) {
    				System.out.println("Deleted");
    			}
    			byte img[] = file.getBytes();
    			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(path + fileName + ".jpg"));
    			out.write(img);
    			out.flush();
    			out.close();
    			movieDaoImpl.update(movie);
    		} else {
    			byte img[] = file.getBytes();
    			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(path + fileName + ".jpg"));
    			out.write(img);
    			out.flush();
    			out.close();
    			movieDaoImpl.update(movie);
    		}

    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	ModelAndView m = new ModelAndView("redirect:/movie/AdminHomepage");
    	return m;

    }
    
    @RequestMapping("/logout")
    public ModelAndView getLogout() {
    	ModelAndView m = new ModelAndView("/admin");
    	return m;
    }
    
    

}












/*@RequestMapping(value = ("/admin/manage-movies"), method = RequestMethod.GET)
public ModelAndView getManageMovies(@ModelAttribute("movie") Movie movie, Map<String, Object> model) {
	List<Movie> list = mi.getAllMovies();
	List<String> l = new ArrayList<String>();
	l.add("Language");
	l.add("Hindi");
	l.add("English");
	l.add("Punjabi");
	l.add("Telugu");
	ModelAndView m = new ModelAndView("manage-movies");
	return m;
}

@RequestMapping(value = ("/admin/registerMovie"), method = RequestMethod.POST)
public ModelAndView registerMovie(Movie movie) {
	boolean res = mi.insert(movie);
	ModelAndView m = new ModelAndView("redirect:/admin/manage-movies");
	if (res == true) {
		m.addObject("msg", "added");
	} else {
		m.addObject("msg", "Cannot add movie re-submit");
	}
	return m;
}

@RequestMapping(value = ("/admin/updateMovie"), method = RequestMethod.POST)
public ModelAndView updateMovie(Movie mov) {
	mi.update(mov);
	return new ModelAndView("redirect:/admin/manage-movies");
}

@RequestMapping(value = ("/admin/deleteMovie/{id}"), method = RequestMethod.GET)
public ModelAndView deleteMovie(@PathVariable("id") long id) {
	mi.delete(id);
	return new ModelAndView("redirect:/admin/manage-movies");
}

@RequestMapping("/admin/manage-movies")
public ModelAndView getManageCinemas(@ModelAttribute("cinema") Movie movie, Map<String, Object> model) {
	List<Movie> list = mi.getAllMovies();
	List<String> l = new ArrayList<String>();
	l.add("PVR");
	ModelAndView m = new ModelAndView("manage-cinemas");
	return m;
}

@RequestMapping("/logout")
public ModelAndView getLogout() {
	ModelAndView m = new ModelAndView("/admin");
	return m;
}

/*
 * @RequestMapping(value = "/admin/add", method = RequestMethod.GET) public
 * ModelAndView addAdmin(@ModelAttribute("admin") Admin admin) { ModelAndView m
 * = new ModelAndView("admin-registration"); return m; }
 */


/*@RequestMapping(value = "/admin/upload", method = RequestMethod.POST)
public ModelAndView upload(@RequestParam("file") CommonsMultipartFile file, @RequestParam String image,
		HttpSession session, HttpServletRequest request) {

	String path = session.getServletContext().getRealPath("/resources/img/movies/");

	// String fileName=file.getOriginalFilename();

	
	  Long id = Long.parseLong(image); 
	  Movie movie = mi.getMovieById(id);
	  movie.setImage(image);
	  String fileName = image;
	 
	//Blob fileName = Hibernate.createBlob(file.getInputStream());

	System.out.println(path);

	try {
		
		File f = new File(path + fileName + ".jpg");
		if (f.exists()) {
			boolean res = f.delete();
			if (res) {
				System.out.println("Deleted");
			}
			byte img[] = file.getBytes();
			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(path + fileName + ".jpg"));
			out.write(img);
			out.flush();
			out.close();
			mi.update(movie);
		} else {
			byte img[] = file.getBytes();
			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(path + fileName + ".jpg"));
			out.write(img);
			out.flush();
			out.close();
			mi.update(movie);
		}

	} catch (Exception e) {
		e.printStackTrace();
	}
	ModelAndView m = new ModelAndView("redirect:/admin/manage-movies");
	return m;

}*/
