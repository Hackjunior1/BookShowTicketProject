package com.Package.Entity;

import java.sql.Blob;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
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

	@Lob
	@Column(name = "image", columnDefinition = "LONGBLOB")
	private byte[] image;

	private String base64Image;

	@Column(name = "Actors_names")
	private String cast_names;

	/*
	 * @Column(name = "language") private String Language;
	 */// cut this here and add to show table. add price column here in movie entity.

	@Column(name = "Ticket_price")
	private int Price;// after execution make changes in JSP page.

	@Column(name = "movie_start_date")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE) // USED TO REMOVE THE TIME FRAME THAT PLACING BESIDE DATE WHEN PRINTING THE
									// DATE.
	private Date MovieStartDate;

	@Column(name = "movie_end_date")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date MovieEndDate;

	public Date getMovieStartDate() {
		return MovieStartDate;
	}

	public void setMovieStartDate(Date movieStartDate) {
		MovieStartDate = movieStartDate;
	}

	public Date getMovieEndDate() {
		return MovieEndDate;
	}

	public void setMovieEndDate(Date movieEndDate) {
		MovieEndDate = movieEndDate;
	}

	@Transient
	public String getBase64Image() {
		base64Image = Base64.getEncoder().encodeToString(this.image);
		return base64Image;
	}

	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}

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

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getCast_names() {
		return cast_names;
	}

	public void setCast_names(String cast_names) {
		this.cast_names = cast_names;
	}





	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public Movie() {

	}

	public Movie(int id, String name,int price, String duration, byte[] image, String cast_names,  Date movieStartDate,
			Date movieEndDate) {
		super();
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.image = image;
		this.cast_names = cast_names;
		this.Price = price;
		this.MovieStartDate = movieStartDate;
		this.MovieEndDate = movieEndDate;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", duration=" + duration + ", image=" + Arrays.toString(image)
				+ ", base64Image=" + base64Image + ", cast_names=" + cast_names + ", Price=" + Price
				+ ", MovieStartDate=" + MovieStartDate + ", MovieEndDate=" + MovieEndDate + "]";
	}

	
	
	

}
