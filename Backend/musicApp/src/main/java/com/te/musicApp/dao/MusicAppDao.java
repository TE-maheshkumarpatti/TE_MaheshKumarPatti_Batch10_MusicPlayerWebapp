package com.te.musicApp.dao;

import java.util.List;

import com.te.musicApp.bean.MusicFilesBean;

public interface MusicAppDao {
	
	/*public List<MusicFilesBean> playAllSongs();
	
	public List<MusicFilesBean> playAllSongsRandomly();
	
	public MusicFilesBean playSong(String title);*/
	
	public MusicFilesBean searchSong(int id);
	
	public List<MusicFilesBean> showAll();
	
	public boolean addSong(MusicFilesBean song);
	
	public boolean editSongInfo(MusicFilesBean song);
	
	public boolean deleteSong(int id);
	
	
	

}
