package com.Package.Entity;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "movie")
public class Movie {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
	private int id;
	
	@Column(name = "movie_name")
	private String name;
	
	@Column(name = "duration")
	private String duration;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "Actors_names")
	private String cast_names;
	
	@Column(name = "language")
	private String Language;
	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	

	public String getCast_names() {
		return cast_names;
	}

	public void setCast_names(String cast_names) {
		this.cast_names = cast_names;
	}
	
	

	public String getLanguage() {
		return Language;
	}

	public void setLanguage(String language) {
		Language = language;
	}
	
	

	public Movie(int id, String name, String duration, String image, String cast_names,String language) {
		super();
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.image = image;
		this.cast_names = cast_names;
		this.Language=language;
	}

	public Movie() {
		super();
	}

	

}
