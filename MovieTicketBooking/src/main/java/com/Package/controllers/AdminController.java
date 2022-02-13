package com.Package.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.Package.DaoImpl.AdminDaoImpl;
import com.Package.DaoImpl.MovieDaoImpl;
import com.Package.Entity.Admin;
//import com.Package.Entity.Admin;
import com.Package.Entity.Movie;
import com.Package.config.DateTime;

@Controller
@SessionAttributes(value = { "ad", "profile" })
public class AdminController {

	@Autowired
	private DateTime dt;

	@Autowired
	private MovieDaoImpl mi;

	@Autowired
	private AdminDaoImpl ai;

	@RequestMapping(value = "/admin-login")
	public String getAdminLogin() {
		return "admin-login";
	}

	@RequestMapping(value = ("/admin"), method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getAdminDashboard(Principal principal, Admin admin) {
		ModelAndView m = new ModelAndView("admin");
		admin = ai.getAdminById(principal.getName());
		if (admin.getGender().equals("female")) {
			m.addObject("profile", "profile-female");

		} else if (admin.getGender().equals("male")) {
			m.addObject("profile", "profile-male");

		} else {
			m.addObject("profile", "profile");
		}

		m.addObject("ad", admin.getName());
		return m;
	}

	@RequestMapping(value = ("/admin/manage-movies"), method = RequestMethod.GET)
	public ModelAndView getManageMovies(@ModelAttribute("movie") Movie movie, Map<String, Object> model) {
		List<Movie> list = mi.getAllMovies();
		List<String> l = new ArrayList<String>();
		l.add("Language");
		l.add("Hindi");
		l.add("English");
		l.add("Punjabi");
		l.add("Telugu");
		List<String> s = new ArrayList<String>();
		s.add("Status");
		s.add("Released");
		s.add("Upcoming");
		List<String> c = new ArrayList<String>();
		c.add("Category");
		c.add("Action");
		c.add("Adventure");
		c.add("Comedy");
		c.add("Crime");
		c.add("Drama");
		c.add("Fantasy");
		c.add("History");
		c.add("Horror");
		c.add("Romance");
		c.add("Science Fiction");
		model.put("category", c);
		model.put("language", l);
		model.put("status", s);
		model.put("list", list);
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
		l.add("Cinepolis");
		l.add("DT Cinemas");
		l.add("Fun Cinemas");
		l.add("Satyam Cineplexes");
		l.add("M2K");
		l.add("Movietime");
		model.put("list", list);
		model.put("name", l);
		ModelAndView m = new ModelAndView("manage-cinemas");
		return m;
	}

	@RequestMapping(value = "/admin/registerCinema", method = RequestMethod.POST)
	public ModelAndView registerCinema(Movie cinema) {
		cinema.setDate(dt.date());
		mi.insert(cinema);
		ModelAndView m = new ModelAndView("redirect:/admin/manage-cinemas");
		return m;
	}

	@RequestMapping(value = ("/admin/updateCinema"), method = RequestMethod.POST)
	public ModelAndView updateCinema(Movie movie) {
		mi.update(movie);
		return new ModelAndView("redirect:/admin/manage-cinemas");
	}

	@RequestMapping(value = ("/admin/deleteCinema/{id}"), method = RequestMethod.GET)
	public ModelAndView deleteCinema(@PathVariable("id") long id) {
		mi.delete(id);
		return new ModelAndView("redirect:/admin/manage-cinemas");
	}

	@RequestMapping("/logout")
	public ModelAndView getLogout() {
		ModelAndView m = new ModelAndView("/admin");
		return m;
	}

	@RequestMapping("/logFail")
	public ModelAndView getLogFail() {
		ModelAndView m = new ModelAndView("/admin");
		return m;
	}

	@RequestMapping(value = "/admin/add", method = RequestMethod.GET)
	public ModelAndView addAdmin(@ModelAttribute("admin") Admin admin) {
		ModelAndView m = new ModelAndView("admin-registration");
		return m;
	}



	@RequestMapping(value = "/admin/upload", method = RequestMethod.POST)
	public ModelAndView upload(@RequestParam("file") CommonsMultipartFile file, @RequestParam String selection,
			HttpSession session, HttpServletRequest request) {

		String path = session.getServletContext().getRealPath("/resources/img/movies/");

		// String fileName=file.getOriginalFilename();

		Long id = Long.parseLong(selection);
		Movie movie = mi.getMovieById(id);
		movie.setImage(selection);
		String fileName = selection;

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

	}

}
