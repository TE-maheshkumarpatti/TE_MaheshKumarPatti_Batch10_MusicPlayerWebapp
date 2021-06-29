package com.te.musicApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.musicApp.bean.MusicAppResponse;
import com.te.musicApp.bean.MusicFilesBean;
import com.te.musicApp.service.MusicAppService;

@RestController
public class MusicAppController {
	@Autowired
	private MusicAppService service;

	@GetMapping(path = "/getSong", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public MusicAppResponse getSong(int id) {

		 MusicAppResponse response = new  MusicAppResponse();
		 MusicFilesBean bean = service.searchSong(id);

		if (bean != null) {
			response.setStatusCode(200);
			response.setMsg("Success");
			response.setBean(bean);
		} else {
			response.setStatusCode(404);
			response.setMsg("Failure , Data Not found");
		}

		return response;
	}// end of getSong

	@GetMapping(path = "/getAll", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public MusicAppResponse getAllSongs() {
		MusicAppResponse response = new MusicAppResponse();
		List<MusicFilesBean> beans=service.showAll();

		if (beans != null) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setMusicFiles(beans);
		} else {
			response.setStatusCode(400);
			response.setMsg("Datas not found");
		}

		return response;
	}// END OF GETALL

	@PostMapping(path = "/add", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public MusicAppResponse addEmpData(@RequestBody MusicFilesBean bean) {
		MusicAppResponse response = new MusicAppResponse();

		if (service.addSong(bean)) {
			response.setStatusCode(200);
			response.setMsg("success , Added the song");
		} else {
			response.setStatusCode(400);
			response.setMsg("Failure , Could not add the data");
		}

		return response;
	}// end of addEmp

	@PutMapping(path = "/edit", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public MusicAppResponse  updateEmpData(@RequestBody MusicFilesBean bean) {
		MusicAppResponse response = new MusicAppResponse();

		if (service.editSongInfo(bean)) {
			response.setStatusCode(200);
			response.setMsg("success , edited the details");
		} else {
			response.setStatusCode(400);
			response.setMsg("Failure , Could not edited the record");
		}
		return response;
	} // update

	
	@DeleteMapping(path = "/delete/{id}" , produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public MusicAppResponse deleteSong(@PathVariable(name = "id")int id ) {
		MusicAppResponse response = new MusicAppResponse();

		if (service.deleteSong(id)) {
			response.setStatusCode(200);
			response.setMsg("success , record deleted");
		} else {
			response.setStatusCode(400);
			response.setMsg("Failure , Could not delete the record");
		}
		return response;
	}

	

}
