package com.te.musicApp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.te.musicApp.bean.MusicFilesBean;


@Repository
public class MusicappDaoImpl implements MusicAppDao{
	
	@PersistenceUnit
	private EntityManagerFactory factory;
	
	
	

	/*@Override
	public List<MusicFilesBean> playAllSongs() {
		
		
		
	}

	@Override
	public List<MusicFilesBean> playAllSongsRandomly() {
		
	}

	@Override
	public MusicFilesBean playSong(String title) {
		
	}*/

	@Override
	public MusicFilesBean searchSong(int id) {
		EntityManager manager = factory.createEntityManager();
		MusicFilesBean bean = manager.find(MusicFilesBean.class, id);
		return bean;
	}

	@Override
	public List<MusicFilesBean> showAll() {
		List<MusicFilesBean> Beans = null;

		try {
			EntityManager manager = factory.createEntityManager();

			Query query = manager.createQuery("from MusicFilesBean");

			Beans = query.getResultList();

		} catch (Exception e) {
			Beans = null;
			e.printStackTrace();
		}

		return Beans;

	}
	
		

	@Override
	public boolean addSong(MusicFilesBean song) {
		try {

			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(song);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean editSongInfo(MusicFilesBean song) {
		try {
//			EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			MusicFilesBean orgData = manager.find(MusicFilesBean.class, song.getId());

			if( (song.getAlbum_Name() != null) && (song.getArtist_Name() != "") ){
				orgData.setAlbum_Name(song.getAlbum_Name());
			}

			if ((song.getSong_Title()!="")&&(song.getSong_Title()!=null)) {
				orgData.setSong_Title(song.getSong_Title());
			}

			if ((song.getSong_Location()!=null)&&(song.getSong_Location()!="")) {
				orgData.setSong_Location(song.getSong_Location());
			}
			if((song.getDescription()!=null)&&(song.getDescription()!=null)) {
				orgData.setDescription(song.getDescription());
			}

			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean deleteSong(int id) {
		
		try {
//			EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			 MusicFilesBean bean = manager.find(MusicFilesBean.class, id);
			manager.remove(bean);
			transaction.commit();
			return true;
		} catch (Exception e) {

			e.printStackTrace();

			return false;
		}
		
	}

}
