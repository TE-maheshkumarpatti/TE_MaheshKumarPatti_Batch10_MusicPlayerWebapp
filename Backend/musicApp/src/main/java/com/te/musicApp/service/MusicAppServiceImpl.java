package com.te.musicApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.musicApp.bean.MusicFilesBean;
import com.te.musicApp.dao.MusicAppDao;
@Service
public class MusicAppServiceImpl implements MusicAppService {
	
	@Autowired
	MusicAppDao dao;

	@Override
	public MusicFilesBean searchSong(int id) {
		return dao.searchSong(id);
		
	}

	@Override
	public List<MusicFilesBean> showAll() {
		// TODO Auto-generated method stub
		return dao.showAll();
	}

	@Override
	public boolean addSong(MusicFilesBean song) {
	return dao.addSong(song);
	}

	@Override
	public boolean editSongInfo(MusicFilesBean song) {
		// TODO Auto-generated method stub
		return dao.editSongInfo(song);
	}

	@Override
	public boolean deleteSong(int id) {
		return dao.deleteSong(id);
	}

}
