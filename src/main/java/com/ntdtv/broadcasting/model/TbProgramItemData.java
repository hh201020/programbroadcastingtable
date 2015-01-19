package com.ntdtv.broadcasting.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the tb_program_item_data database table.
 * 
 */
@Entity
@Table(name="tb_program_item_data")
@NamedQuery(name="TbProgramItemData.findAll", query="SELECT t FROM TbProgramItemData t")
public class TbProgramItemData implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String actions;

	private byte allowReschedule;

	private int childCnt;

	private String createBy;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDtm;

	private String ctrlNum;

	private byte editable;

	private int episodeNum;

	private byte lengthFlexible;

	private int mediaVer;

	private int operationStatus;

	private long parentId;

	private long programId;

	private String programName;

	private byte repeatPrevious;

	private int seasonNum;

	private long startAtGMT;

	@Temporal(TemporalType.TIMESTAMP)
	private Date startGMTDateTime;

	private long timeLengthInSecond;

	private int tvChannelId;

	private String tvProgramCode;

	private String updateBy;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDtm;

	private long version;

	public TbProgramItemData() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getActions() {
		return this.actions;
	}

	public void setActions(String actions) {
		this.actions = actions;
	}

	public byte getAllowReschedule() {
		return this.allowReschedule;
	}

	public void setAllowReschedule(byte allowReschedule) {
		this.allowReschedule = allowReschedule;
	}

	public int getChildCnt() {
		return this.childCnt;
	}

	public void setChildCnt(int childCnt) {
		this.childCnt = childCnt;
	}

	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDtm() {
		return this.createDtm;
	}

	public void setCreateDtm(Date createDtm) {
		this.createDtm = createDtm;
	}

	public String getCtrlNum() {
		return this.ctrlNum;
	}

	public void setCtrlNum(String ctrlNum) {
		this.ctrlNum = ctrlNum;
	}

	public byte getEditable() {
		return this.editable;
	}

	public void setEditable(byte editable) {
		this.editable = editable;
	}

	public int getEpisodeNum() {
		return this.episodeNum;
	}

	public void setEpisodeNum(int episodeNum) {
		this.episodeNum = episodeNum;
	}

	public byte getLengthFlexible() {
		return this.lengthFlexible;
	}

	public void setLengthFlexible(byte lengthFlexible) {
		this.lengthFlexible = lengthFlexible;
	}

	public int getMediaVer() {
		return this.mediaVer;
	}

	public void setMediaVer(int mediaVer) {
		this.mediaVer = mediaVer;
	}

	public int getOperationStatus() {
		return this.operationStatus;
	}

	public void setOperationStatus(int operationStatus) {
		this.operationStatus = operationStatus;
	}

	public long getParentId() {
		return this.parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public long getProgramId() {
		return this.programId;
	}

	public void setProgramId(long programId) {
		this.programId = programId;
	}

	public String getProgramName() {
		return this.programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public byte getRepeatPrevious() {
		return this.repeatPrevious;
	}

	public void setRepeatPrevious(byte repeatPrevious) {
		this.repeatPrevious = repeatPrevious;
	}

	public int getSeasonNum() {
		return this.seasonNum;
	}

	public void setSeasonNum(int seasonNum) {
		this.seasonNum = seasonNum;
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

	public long getTimeLengthInSecond() {
		return this.timeLengthInSecond;
	}

	public void setTimeLengthInSecond(long timeLengthInSecond) {
		this.timeLengthInSecond = timeLengthInSecond;
	}

	public int getTvChannelId() {
		return this.tvChannelId;
	}

	public void setTvChannelId(int tvChannelId) {
		this.tvChannelId = tvChannelId;
	}

	public String getTvProgramCode() {
		return this.tvProgramCode;
	}

	public void setTvProgramCode(String tvProgramCode) {
		this.tvProgramCode = tvProgramCode;
	}

	public String getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDtm() {
		return this.updateDtm;
	}

	public void setUpdateDtm(Date updateDtm) {
		this.updateDtm = updateDtm;
	}

	public long getVersion() {
		return this.version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public String toString(){
		String programEpisodeName = new String();
		programEpisodeName = programName;
		return programEpisodeName + "--" + startAtGMT;
	}
}