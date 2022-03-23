package com.Package.Entity;

import java.util.Arrays;
import java.util.Base64;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
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

//-------------------------------Variavle Declaration-------------------------
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "movie_id")
	private int id;

	@Column(name = "movie_name")
	private String name;

	@Column(name = "duration")
	private String duration;

	@Lob
	private byte[] image;

	private String base64Image;

	@Column(name = "movie_details")
	private String Details;

	@Column(name = "language")
	private String Language;

	@Column(name = "Ticket_price")
	private int Price;

	@Column(name = "movie_start_date")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE) // USED TO REMOVE THE TIME FRAME THAT PLACING BESIDE DATE WHEN PRINTING THE
									// DATE.
	private Date MovieStartDate;

	@Column(name = "movie_end_date")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date MovieEndDate;

	@Column(name = "show_11to2")
	private boolean Show11to2;

	@Column(name = "show_2to5")
	private boolean Show2to5;

	@Column(name = "show_6to8")
	private boolean Shwo6to8;

	@Column(name = "show_9to12")
	private boolean Show9to12;

	//@OneToOne(mappedBy = "movie", cascade = CascadeType.ALL)
	//private BookingDetails bookingdetails;

//----------------------------Getter, Setters------------------------
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

	@Column(name = "image", columnDefinition = "LONGBLOB")
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getDetails() {
		return Details;
	}

	public void setDetails(String details) {
		Details = details;
	}

	public String getLanguage() {
		return Language;
	}

	public void setLanguage(String language) {
		Language = language;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

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

	public boolean isShow11to2() {
		return Show11to2;
	}

	public void setShow11to2(boolean show11to2) {
		Show11to2 = show11to2;
	}

	public boolean isShow2to5() {
		return Show2to5;
	}

	public void setShow2to5(boolean show2to5) {
		Show2to5 = show2to5;
	}

	public boolean isShwo6to8() {
		return Shwo6to8;
	}

	public void setShwo6to8(boolean shwo6to8) {
		Shwo6to8 = shwo6to8;
	}

	public boolean isShow9to12() {
		return Show9to12;
	}

	public void setShow9to12(boolean show9to12) {
		Show9to12 = show9to12;
	}

	/*
	 * public BookingDetails getBookingdetails() { return bookingdetails; }
	 * 
	 * public void setBookingdetails(BookingDetails bookingdetails) {
	 * this.bookingdetails = bookingdetails; }
	 */

	// -----------------------------Constructars--------------------------------
	public Movie() {

	}

	public Movie(int id, String name, String duration, byte[] image, String base64Image, String details,
			String language, int price, Date movieStartDate, Date movieEndDate, boolean show11to2, boolean show2to5,
			boolean shwo6to8, boolean show9to12) {

		this.id = id;
		this.name = name;
		this.duration = duration;
		this.image = image;
		this.base64Image = base64Image;
		this.Details = details;
		this.Language = language;
		this.Price = price;
		this.MovieStartDate = movieStartDate;
		this.MovieEndDate = movieEndDate;
		this.Show11to2 = show11to2;
		this.Show2to5 = show2to5;
		this.Shwo6to8 = shwo6to8;
		this.Show9to12 = show9to12;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", duration=" + duration + ", image=" + Arrays.toString(image)
				+ ", base64Image=" + base64Image + ", Details=" + Details + ", Language=" + Language + ", Price="
				+ Price + ", MovieStartDate=" + MovieStartDate + ", MovieEndDate=" + MovieEndDate + ", Show11to2="
				+ Show11to2 + ", Show2to5=" + Show2to5 + ", Shwo6to8=" + Shwo6to8 + ", Show9to12=" + Show9to12 + "]";
	}

}
