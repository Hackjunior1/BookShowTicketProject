package com.Package.DaoImpl;

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
import com.Package.Entity.BookingDetails;
import com.Package.Entity.CompositeModelDto;
import com.Package.Entity.Movie;
import com.Package.Entity.ShowMovie;

@Transactional
@Repository//Annotation for Hibernate exceptions to be translated into Spring DataAccessException for consistent exception handling
@Service
public class MovieDaoImpl implements MovieDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Movie> getMovie() {
		System.out.println("inside MoviedaoImpl class inside list movie method line 33");

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
		System.out.println("inside MoviedaoImpl class inside delete movie method line 63");

		Session session = sessionFactory.getCurrentSession();
		Movie movie = session.byId(Movie.class).load(movie_id);
		session.delete(movie);
	}

	@Override
	public void saveMovie(Movie movie) {
		System.out.println("inside MoviedaoImpl class inside save movie method line 72");

		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(movie);

	}

	@Override
	public Movie getMovie(int movie_id) {
		System.out.println("inside MoviedaoImpl class inside get movie method line  movie id= " + movie_id);

		Session currentSession = sessionFactory.getCurrentSession();

		System.out.println("implementation class line 100");
		Movie movie = currentSession.get(Movie.class, movie_id);
		System.out.println("line 104 Implementation class before return statement");
		return movie;
	}
	
	  
	  public List<BookingDetails> getBookingDetails() {
			System.out.println("inside MoviedaoImpl class inside list booking details method line 33");

			Session session = sessionFactory.getCurrentSession();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<BookingDetails> cq = cb.createQuery(BookingDetails.class);
			Root<BookingDetails> root = cq.from(BookingDetails.class);
			cq.select(root);
			Query query = session.createQuery(cq);
			List<BookingDetails> list = query.getResultList();
			System.out.println("inside Movie DAOImpl class printing the list of Booking details" + list.toString());
			return list;
		}
}

/*
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
