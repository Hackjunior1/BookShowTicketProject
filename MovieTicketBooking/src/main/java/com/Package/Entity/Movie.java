package com.Package.Entity;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "movie")
public class Movie {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
	private int movie_id;
	
	@Column(name = "movie_name")
	private String movie_name;
	
	@Column(name = "duration")
	private String duration;
	
	@Column(name = "image")
	private Blob image;
	
	

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public String getMovie_name() {
		return movie_name;
	}

	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public Movie(int movie_id, String movie_name, String duration, Blob image) {
		super();
		this.movie_id = movie_id;
		this.movie_name = movie_name;
		this.duration = duration;
		this.image = image;
	}

	public Movie() {
		super();
	}

	

}
