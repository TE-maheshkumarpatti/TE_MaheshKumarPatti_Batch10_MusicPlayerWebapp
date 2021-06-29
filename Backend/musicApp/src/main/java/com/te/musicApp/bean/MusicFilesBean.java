package com.te.musicApp.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="MusicFiles")
public class MusicFilesBean {
	@Id
	@Column(name="Song_ID")
	private int id;
	@Column
	private String Song_Title;
	@Column
	private String Artist_Name;
	@Column
	private String Album_Name;
	@Column
	private String Song_Location;
	@Column
	private String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSong_Title() {
		return Song_Title;
	}
	public void setSong_Title(String song_Title) {
		Song_Title = song_Title;
	}
	public String getArtist_Name() {
		return Artist_Name;
	}
	public void setArtist_Name(String artist_Name) {
		Artist_Name = artist_Name;
	}
	public String getAlbum_Name() {
		return Album_Name;
	}
	public void setAlbum_Name(String album_Name) {
		Album_Name = album_Name;
	}
	public String getSong_Location() {
		return Song_Location;
	}
	public void setSong_Location(String song_Location) {
		Song_Location = song_Location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "MusicFilesBean [id=" + id + ", Song_Title=" + Song_Title + ", Artist_Name=" + Artist_Name
				+ ", Album_Name=" + Album_Name + ", Song_Location=" + Song_Location + ", description=" + description
				+ "]";
	}
	
	
	
	

}
