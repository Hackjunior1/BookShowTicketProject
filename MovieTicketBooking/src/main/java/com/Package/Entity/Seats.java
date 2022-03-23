package com.Package.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "seats")
public class Seats {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id")
	private int id;
	
	@Column(name = "seat_number")
	private int SeatNumber;
	
	@Column(name = "seat_status")
	private boolean SeatStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Seats() {
		
	}

	public Seats(int id, int seatNumber, boolean seatStatus) {
	
		this.id = id;
		SeatNumber = seatNumber;
		SeatStatus = seatStatus;
	}

	@Override
	public String toString() {
		return "Seats [id=" + id + ", SeatNumber=" + SeatNumber + ", SeatStatus=" + SeatStatus + "]";
	}
	
	


}
