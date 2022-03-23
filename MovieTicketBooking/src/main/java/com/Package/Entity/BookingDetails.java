package com.Package.Entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "Booking_Details")
public class BookingDetails {// this Entity is needed when admin want to see the Bookings from the DB

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "booking_id")
	private int BookingId;

	
	@Column(name = "movie_id")
	private int MovieId; // needed to give One to One relation mapping with Movie Entity.

	@Column(name = "show_date")
	//@DateTimeFormat(pattern = "dd/MM/yyyy")
	//@Temporal(TemporalType.DATE)
	private Date ShowDate;

	@Column(name = "show_time") // remaining 25,28,31,34 are comming from seat selection page
	private String ShowTime;

	@Column(name = "seat_number")
	private int SeatNumber;

	@Column(name = "seat_status")
	private boolean SeatStatus; // occupied or not

	//@OneToOne
	//@JoinColumn(name="movie_id")
	//private Movie movie;

//------------------------------------------- Variable Declaration-----------------------------

	public int getBookingId() {
		return BookingId;
	}

	public void setBookingId(int bookingId) {
		BookingId = bookingId;
	}

	public int getMovieId() {
		return MovieId;
	}

	public void setMovieId(int movieId) {
		MovieId = movieId;
	}

	public Date getShowDate() {
		return ShowDate;
	}

	public void setShowDate(Date showDate) {
		ShowDate = showDate;
	}

	public String getShowTime() {
		return ShowTime;
	}

	public void setShowTime(String showTime) {
		ShowTime = showTime;
	}

	public int getSeatNumber() {
		return SeatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		SeatNumber = seatNumber;
	}

	public boolean isSeatStatus() {
		return SeatStatus;
	}

	public void setSeatStatus(boolean seatStatus) {
		SeatStatus = seatStatus;
	}
//------------------------------------------- Getters and Setters-----------------------------

	public BookingDetails() {

	}

	public BookingDetails(int bookingId, int movieId, Date showDate, String showTime, int seatNumber,
			boolean seatStatus) {

		this.BookingId = bookingId;
		this.MovieId = movieId;
		this.ShowDate = showDate;
		this.ShowTime = showTime;
		this.SeatNumber = seatNumber;
		this.SeatStatus = seatStatus;
	}

	@Override
	public String toString() {
		return "BookingDetails [BookingId=" + BookingId + ", MovieId=" + MovieId + ", ShowDate=" + ShowDate
				+ ", ShowTime=" + ShowTime + ", SeatNumber=" + SeatNumber + ", SeatStatus=" + SeatStatus + "]";
	}

}
