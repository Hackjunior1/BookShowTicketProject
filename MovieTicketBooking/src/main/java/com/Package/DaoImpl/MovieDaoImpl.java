package com.Package.DaoImpl;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.Package.Dao.MovieDao;
import com.Package.Entity.Movie;
import com.Package.config.AppContext;

@Transactional
@Repository
@Service
public class MovieDaoImpl implements MovieDao {

	@Autowired
	private AppContext con;
	
	public boolean insert(Movie movie) {
		
		try {
			
			Session session = (Session) con.sessionFactory();
			Transaction t = session.beginTransaction();
			session.save(movie);
			t.commit();
			session.close();
			return true;
			
		} catch (Exception e) {
			
			System.out.println("Exception(ADD): " + e);
			return false;
		
		}
		
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Movie> getAllMovies() {

		List<Movie> cinema= new ArrayList<Movie>();
		
		try {
			
			Session session =  (Session) con.sessionFactory();
			Transaction t = session.beginTransaction();
			cinema=session.createCriteria(Movie.class).list();
			t.commit();
			session.close();
			return cinema;
			
		} catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return cinema;
		}
		
	}

	public boolean delete(long cinemaId) {

		try {
			
			Statement st=JConnect.getStatement();
			st.executeUpdate("delete from cinemas where CNM_ID='"+cinemaId+"'");
			return true;
			
		}catch(Exception exception) {
			exception.printStackTrace();
			return false;
		}

	}

	public boolean update(Movie movie) {

		try {
			Session session =  (Session) con.sessionFactory();
			Transaction t = session.beginTransaction();
			session.update(movie);
			t.commit();
			session.close();
			return true;
			
			}catch (Exception e) {
				System.out.println("Exception(ADD): " + e);
				return false;
			}
		
	}

	public Movie getMovieById(long id) {

		Movie cinema=new Movie();	
		
		try {
			Statement st=JConnect.getStatement();
			ResultSet rs=st.executeQuery("select * from cinemas where CNM_ID='"+id+"'");
			while(rs.next()){
				
				cinema.setImage(rs.getLong("CNM_ID"));
				cinema.setMovie_name(rs.getString("CNM_NAME"));
				cinema.setDuration(rs.getString("CNM_LOC"));
				cinema.setDate(rs.getString("CNM_DTE"));
				cinema.setT1(rs.getString("CNM_S_1"));
				cinema.setT2(rs.getString("CNM_S_2"));
				cinema.setT3(rs.getString("CNM_S_3"));
				cinema.setT4(rs.getString("CNM_S_4"));
				cinema.setT5(rs.getString("CNM_S_5"));
				}
				
				return cinema;
			
		}catch(Exception exception) {
			exception.printStackTrace();
			return cinema;
		}
		
	}

}
