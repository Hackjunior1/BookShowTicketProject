package com.Package.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "show_movie")
public class ShowMovie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "show_id")
	private int id;

	@Column(name = "show_time")
	private int Show_Time;

	@Column(name = "start_time")
	private int Start_Time;

	@Column(name = "language")
	private String Language;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getShow_Time() {
		return Show_Time;
	}

	public void setShow_Time(int show_Time) {
		Show_Time = show_Time;
	}

	public double getStart_Time() {
		return Start_Time;
	}

	public void setStart_Time(int start_Time) {
		Start_Time = start_Time;
	}

	public String getLanguage() {
		return Language;
	}

	public void setLanguage(String language) {
		Language = language;
	}

	public ShowMovie(int id, int show_Time, int start_Time, String language) {
		super();
		this.id = id;
		Show_Time = show_Time;
		Start_Time = start_Time;
		Language = language;
	}

	public ShowMovie() {
		super();
	}

}
