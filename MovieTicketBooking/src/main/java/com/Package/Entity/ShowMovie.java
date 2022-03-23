package com.Package.Entity;

/*import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

//@Entity
//@Table(name = "show_movie")
public class ShowMovie {*/

import java.util.Arrays;
import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

/*@Component
@Entity
@Table(name = "showmovie")*/
public class ShowMovie {

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

	@Column(name = "image", columnDefinition = "BLOB")
	public byte[] getImage() {
		return this.image;
	}

	private String base64Image;

	@Transient
	public String getBase64Image() {
		base64Image = Base64.getEncoder().encodeToString(this.image);
		return base64Image;
	}

	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}

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

	public void setImage(byte[] image) {
		this.image = image;
	}

	public ShowMovie(int id, String name, String duration, byte[] image, String base64Image, String cast_names,
			String language) {
		super();
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.image = image;
		this.base64Image = base64Image;
		this.cast_names = cast_names;
		Language = language;
	}

	public ShowMovie() {
		super();
	}

	@Override
	public String toString() {
		return "ShowMovie [id=" + id + ", name=" + name + ", duration=" + duration + ", image=" + Arrays.toString(image)
				+ ", base64Image=" + base64Image + ", cast_names=" + cast_names + ", Language=" + Language + "]";
	}
}

/*
 * @Id My show_movie details.
 * @GeneratedValue(strategy = GenerationType.IDENTITY)
 * @Column(name = "show_id") private int id;
 * 
 * @Column(name = "show_time") private String Show_Time; //show time like
 * morning, noon, 1st and 2nd shows like this) crete a dropdown menu for it in
 * jsp
 * 
 * @Column(name = "start_time") private String Start_Time; //Exact time of when
 * the movie will start.
 * 
 * @Column(name="movie_id") private int movieid;
 * 
 * @OneToOne
 * 
 * @PrimaryKeyJoinColumn(name="movie_id") Movie movie;
 * 
 * 
 * public int getId() { return id; }
 * 
 * public void setId(int id) { this.id = id; }
 * 
 * public String getShow_Time() { return Show_Time; }
 * 
 * public void setShow_Time(String show_Time) { Show_Time = show_Time; }
 * 
 * public String getStart_Time() { return Start_Time; }
 * 
 * public void setStart_Time(String start_Time) { Start_Time = start_Time; }
 * 
 * 
 * 
 * public ShowMovie(int id, String show_Time, String start_Time) { super();
 * this.id = id; Show_Time = show_Time; Start_Time = start_Time;
 * 
 * }
 * 
 * public ShowMovie() {
 * 
 * }
 * 
 * @Override public String toString() { return "ShowMovie [id=" + id +
 * ", Show_Time=" + Show_Time + ", Start_Time=" + Start_Time + "]"; }
 */
