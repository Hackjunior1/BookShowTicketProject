package com.Package.DaoImpl;


import java.sql.ResultSet;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.Package.Dao.MovieDao;
import com.Package.Entity.Movie;

@Transactional
@Repository
@Service
public class MovieDaoImpl implements MovieDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Movie> getMovie() {
		System.out.println("inside MoviedaoImpl class inside list movie method line 61");

		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Movie> cq = cb.createQuery(Movie.class);
		Root<Movie> root = cq.from(Movie.class);
		cq.select(root);
		Query query = session.createQuery(cq);
		List<Movie> list = query.getResultList();
		System.out.println("inside Movie DAOImpl class ptinting the list of movies" + list.toString());
		return list;
	}

	@Override
	public void deleteMovie(int movie_id) {
		System.out.println("inside MoviedaoImpl class inside delete movie method line 75");

		Session session = sessionFactory.getCurrentSession();
		Movie movie = session.byId(Movie.class).load(movie_id);
		session.delete(movie);
	}

	@Override
	public void saveMovie(Movie movie) {
		System.out.println("inside MoviedaoImpl class inside save movie method line 85");

		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(movie);

		// System.out.println("current session Details" +currentSession.getSession());
		// System.out.println("entity Detauls" +movie);
	}

	@Override
	
	public Movie getMovie(int movie_id) {
		System.out.println("inside MoviedaoImpl class inside get movie method line 93");

		Session currentSession = sessionFactory.getCurrentSession();
		
		Movie movie = currentSession.get(Movie.class, movie_id);
		//byte[] result= movie.getImage();
		
		
		return movie;
	}
	

	/*public boolean update(Movie movie) {

		try {
			System.out.println("inside MoviedaoImpl class inside update movie method line 104");

			Session session = sessionFactory.getCurrentSession();
			// Transaction t = session.beginTransaction();
			session.update(movie);
			// t.commit();
			session.close();
			return true;

		} catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return false;
		}

	}*/
}

/*
 * @Autowired private AppContext con;
 * 
 * @Autowired private SessionFactory sessionFactory;
 * 
 * public boolean insert(Movie movie) {
 * 
 * try {
 * 
 * Session session = (Session) con.sessionFactory(); Transaction t =
 * session.beginTransaction(); session.save(movie); t.commit(); session.close();
 * return true;
 * 
 * } catch (Exception e) {
 * 
 * System.out.println("Exception(ADD): " + e); return false;
 * 
 * }
 * 
 * }
 * 
 * @SuppressWarnings({ "unchecked", "deprecation" }) public List<Movie>
 * getAllMovies() {
 * 
 * List<Movie> cinema = new ArrayList<Movie>();
 * 
 * try {
 * 
 * Session session = (Session) con.sessionFactory(); Transaction t =
 * session.beginTransaction(); cinema =
 * session.createCriteria(Movie.class).list(); t.commit(); session.close();
 * return cinema;
 * 
 * } catch (Exception e) { System.out.println("Exception(ADD): " + e); return
 * cinema; }
 * 
 * }
 * 
 * public boolean delete(long cinemaId) {
 * 
 * try {
 * 
 * 
 * HibernateTransactionManager st=con.getTransactionManager(); //Statement
 * st=AppContext.
 * 
 * Session session = sessionFactory.getCurrentSession(); Movie movie =
 * session.byId(Movie.class).load(cinemaId); session.delete(movie); ((Statement)
 * session).executeUpdate("delete from cinemas where CNM_ID='" + cinemaId +
 * "'"); return true;
 * 
 * } catch (Exception exception) { exception.printStackTrace(); return false; }
 * 
 * }
 * 
 * public boolean update(Movie movie) {
 * 
 * try { Session session = (Session) con.sessionFactory(); Transaction t =
 * session.beginTransaction(); session.update(movie); t.commit();
 * session.close(); return true;
 * 
 * } catch (Exception e) { System.out.println("Exception(ADD): " + e); return
 * false; }
 * 
 * }
 * 
 * public Movie getMovieById(long id) {
 * 
 * Movie cinema = new Movie(); return cinema;
 * 
 * try { Statement st = JConnect.getStatement(); ResultSet rs =
 * st.executeQuery("select * from cinemas where CNM_ID='" + id + "'"); while
 * (rs.next()) {
 * 
 * cinema.setImage(rs.getLong("CNM_ID"));
 * cinema.setMovie_name(rs.getString("CNM_NAME"));
 * cinema.setDuration(rs.getString("CNM_LOC"));
 * cinema.setDate(rs.getString("CNM_DTE"));
 * cinema.setT1(rs.getString("CNM_S_1")); cinema.setT2(rs.getString("CNM_S_2"));
 * cinema.setT3(rs.getString("CNM_S_3")); cinema.setT4(rs.getString("CNM_S_4"));
 * cinema.setT5(rs.getString("CNM_S_5")); }
 * 
 * return cinema;
 * 
 * } catch (Exception exception) { exception.printStackTrace(); return cinema; }
 * 
 * }*
 *
 * 
 * @Autowired private SessionFactory sessionFactory;
 * 
 * @Override public List < Customer > getCustomers() { Session session =
 * sessionFactory.getCurrentSession(); CriteriaBuilder cb =
 * session.getCriteriaBuilder(); CriteriaQuery < Customer > cq =
 * cb.createQuery(Customer.class); Root < Customer > root =
 * cq.from(Customer.class); cq.select(root); Query query =
 * session.createQuery(cq); return query.getResultList(); }
 * 
 * @Override public void deleteCustomer(int id) { Session session =
 * sessionFactory.getCurrentSession(); Customer book =
 * session.byId(Customer.class).load(id); session.delete(book); }
 * 
 * @Override public void saveCustomer(Customer theCustomer) { Session
 * currentSession = sessionFactory.getCurrentSession();
 * currentSession.saveOrUpdate(theCustomer); }
 * 
 * @Override public Customer getCustomer(int theId) { Session currentSession =
 * sessionFactory.getCurrentSession(); Customer theCustomer =
 * currentSession.get(Customer.class, theId); return theCustomer; }
 */
