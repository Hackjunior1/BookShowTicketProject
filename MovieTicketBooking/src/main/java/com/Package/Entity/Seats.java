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
	private int seat_number;
	
	@Column(name = "number_of_seats")
	private int number_of_seats;
	
	

	public int getNo_of_seats() {
		return number_of_seats;
	}

	public void setNo_of_seats(int no_of_seats) {
		this.number_of_seats = no_of_seats;
	}

	public int getSeat_no() {
		return seat_number;
	}

	public void setSeat_no(int seat_no) {
		this.seat_number = seat_no;
	}

	public int getSeat_id() {
		return id;
	}

	public void setSeat_id(int seat_id) {
		this.id = seat_id;
	}

	public Seats(int no_of_seats, int seat_no, int seat_id) {
		super();
		this.number_of_seats = no_of_seats;
		this.seat_number = seat_no;
		this.id = seat_id;
	}

	public Seats() {
		super();
	}
	

}
