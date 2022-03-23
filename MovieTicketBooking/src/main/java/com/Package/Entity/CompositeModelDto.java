package com.Package.Entity;


public class CompositeModelDto {
	
	private Movie movie;
	
	private ShowMovie showmovie;

	public Movie getMovie() {
		System.out.println("inside compositmodelDto inside getMovie() line 10");
		return movie;
	}

	public void setMovie(Movie movie) {
		System.out.println("inside compositmodelDto inside setMovie() line 15");
		this.movie = movie;
	}

	public ShowMovie getShowmovie() {
		System.out.println("inside compositmodelDto inside getShowMovie() line 20");
		return showmovie;
	}

	public void setShowmovie(ShowMovie showmovie) {
		System.out.println("inside compositmodelDto inside setShowMovie() line 25");
		this.showmovie = showmovie;
	}

	

	
	

}
