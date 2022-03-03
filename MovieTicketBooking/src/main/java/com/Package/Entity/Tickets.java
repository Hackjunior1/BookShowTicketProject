package com.Package.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tickets")
public class Tickets {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ticket_number")
	private int ticket_number;//

	@Column(name = "show_id")
	private int show_id;//

	@Column(name = "show_date")
	private int show_date;//

	@Column(name = "seat_number")
	private int seat_number;// has to come from seats table at the time of booking.

	@Column(name = "Ticket_price")
	private int price;// has to come from movie table.

	public int getShow_id() {
		return show_id;
	}

	public void setShow_id(int show_id) {
		this.show_id = show_id;
	}

	public int getShow_date() {
		return show_date;
	}

	public void setShow_date(int show_date) {
		this.show_date = show_date;
	}

	public int getTicket_no() {
		return ticket_number;
	}

	public void setTicket_no(int ticket_no) {
		this.ticket_number = ticket_no;
	}

	public int getSeat_no() {
		return seat_number;
	}

	public void setSeat_no(int seat_no) {
		this.seat_number = seat_no;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Tickets(int show_id, int show_date, int ticket_no, int seat_no, int price) {
		super();
		this.show_id = show_id;
		this.show_date = show_date;
		this.ticket_number = ticket_no;
		this.seat_number = seat_no;
		this.price = price;
	}

	public Tickets() {
		
	}

}
