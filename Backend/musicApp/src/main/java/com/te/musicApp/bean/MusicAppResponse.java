package com.te.musicApp.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

    @Data
	@JsonRootName("response")
	@JsonPropertyOrder({ "status", "msg" })
	@XmlRootElement(name = "response")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public class MusicAppResponse {
    	
    	@JsonProperty("status")
		@XmlElement(name = "status-code")
		private int statusCode;

		private String msg;

		
		@JsonProperty("MusicFiles")
		@XmlElement(name = "MusicFiles")
		private MusicFilesBean bean;
		
		private List<MusicFilesBean> files;
	
		public int getStatusCode() {
			return statusCode;
		}

		public void setStatusCode(int statusCode) {
			this.statusCode = statusCode;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public MusicFilesBean getBean() {
			return bean;
		}

		public void setBean(MusicFilesBean bean) {
			this.bean = bean;
		}

		public List<MusicFilesBean> getAllSongs() {
			return files ;
		}

		public void setMusicFiles(List<MusicFilesBean> musicfiles) {
			this.files = musicfiles;
		}


		

		
	}


