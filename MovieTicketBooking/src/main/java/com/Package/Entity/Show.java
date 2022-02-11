package com.Package.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "show")
public class Show {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "show_id")
	private int show_id;
	
	@Column(name = "show_time")
	private double show_time;
	
	@Column(name = "start_time")
	private float start_time;
	
	@Column(name = "language")
	private String language;
	
	

	public double getShow_time() {
		return show_time;
	}

	public void setShow_time(double show_time) {
		this.show_time = show_time;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public float getStart_time() {
		return start_time;
	}

	public void setStart_time(float start_time) {
		this.start_time = start_time;
	}

	public int getShow_id() {
		return show_id;
	}

	public void setShow_id(int show_id) {
		this.show_id = show_id;
	}

	public Show(double show_time, String language, float start_time, int show_id) {
		super();
		this.show_time = show_time;
		this.language = language;
		this.start_time = start_time;
		this.show_id = show_id;
	}

}
