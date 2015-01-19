package com.ntdtv.broadcasting.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the tb_program_item_data database table.
 * 
 */

public class BroadcastingProgramDisplayingInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	private String programName;
	private long startAtGMT;
	private Date startGMTDateTime;
	private String tvProgramCode;
	private String startTime;
	
	public BroadcastingProgramDisplayingInfo() {
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getTvProgramCode() {
		return tvProgramCode;
	}

	public void setTvProgramCode(String tvProgramCode) {
		this.tvProgramCode = tvProgramCode;
	}

	public String getProgramName() {
		return this.programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public long getStartAtGMT() {
		return this.startAtGMT;
	}

	public void setStartAtGMT(long startAtGMT) {
		this.startAtGMT = startAtGMT;
	}

	public Date getStartGMTDateTime() {
		return this.startGMTDateTime;
	}

	public void setStartGMTDateTime(Date startGMTDateTime) {
		this.startGMTDateTime = startGMTDateTime;
	}

	public String toString(){
		String programEpisodeName = new String();
		programEpisodeName = programName;
		return programEpisodeName + "--" + startTime;
	}
}