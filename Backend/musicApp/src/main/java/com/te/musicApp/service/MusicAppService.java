package com.te.musicApp.service;

import java.util.List;

import com.te.musicApp.bean.MusicFilesBean;

public interface MusicAppService {
	
public MusicFilesBean searchSong(int id);
	
	public List<MusicFilesBean> showAll();
	
	public boolean addSong(MusicFilesBean song);
	
	public boolean editSongInfo(MusicFilesBean song);
	
	public boolean deleteSong(int id);
	
}
