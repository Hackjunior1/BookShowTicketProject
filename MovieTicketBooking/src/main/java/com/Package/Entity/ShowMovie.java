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
	private String Show_Time;//show time like morning, noon, 1st and 2nd shows like this) crete a dropdown menu for it in jsp

	@Column(name = "start_time")
	private String Start_Time;//Exact time of when the movie will start.

	@Column(name = "language")
	private String Language;//change this in jsp and in controller.to add this column data in show movie table.

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShow_Time() {
		return Show_Time;
	}

	public void setShow_Time(String show_Time) {
		Show_Time = show_Time;
	}

	public String getStart_Time() {
		return Start_Time;
	}

	public void setStart_Time(String start_Time) {
		Start_Time = start_Time;
	}

	public String getLanguage() {
		return Language;
	}

	public void setLanguage(String language) {
		Language = language;
	}

	public ShowMovie(int id, String show_Time, String  start_Time, String language) {
		super();
		this.id = id;
		Show_Time = show_Time;
		Start_Time = start_Time;
		Language = language;
	}

	public ShowMovie() {
		
	}

	@Override
	public String toString() {
		return "ShowMovie [id=" + id + ", Show_Time=" + Show_Time + ", Start_Time=" + Start_Time + ", Language="
				+ Language + "]";
	}
	
	

}
