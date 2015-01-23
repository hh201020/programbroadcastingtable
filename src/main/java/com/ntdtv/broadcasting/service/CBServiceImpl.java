package com.ntdtv.broadcasting.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ntdtv.broadcasting.model.*;

@Service
public class CBServiceImpl implements CBService {

	@Inject
	CBRepository cBRepository;
	@SuppressWarnings("rawtypes")
	@Inject
	ProgramDisplayTable programDisplayTable;

	private List<BroadcastingProgramDisplayingInfo> listDayAllChannels01;
	private List<BroadcastingProgramDisplayingInfo> listDayAllChannels02;
	private List<BroadcastingProgramDisplayingInfo> listDayAllChannels03;
	private List<BroadcastingProgramDisplayingInfo> listDayAllChannels04;

	@SuppressWarnings("unchecked")
	@Scheduled(fixedDelay = 1800000)
	@Transactional
	public void refreshDayAllChannels() {
		List<List<TbProgramItemData>> originalListDayAllChannels = new ArrayList<>();
		
		originalListDayAllChannels.add(getDayChannel(1));
		originalListDayAllChannels.add(getDayChannel(2));
		originalListDayAllChannels.add(getDayChannel(3));
		originalListDayAllChannels.add(getDayChannel(4));

//		ProgramDisplayTable allDateTimeOfPrograms = new AllDateTimeOfPrograms(originalListDayAllChannels);
//		ProgramDisplayTable allDateTimeOfPrograms = new AllDateTimeOfPrograms();
		programDisplayTable.setOriginalListDayAllChannels(originalListDayAllChannels);

		listDayAllChannels01 = (List<BroadcastingProgramDisplayingInfo>) programDisplayTable.fillinUsefulPrograms().get(0);
		listDayAllChannels02 = (List<BroadcastingProgramDisplayingInfo>) programDisplayTable.fillinUsefulPrograms().get(1);
		listDayAllChannels03 = (List<BroadcastingProgramDisplayingInfo>) programDisplayTable.fillinUsefulPrograms().get(2);
		listDayAllChannels04 = (List<BroadcastingProgramDisplayingInfo>) programDisplayTable.fillinUsefulPrograms().get(3);
		
		System.out.println("This day all channels: " + listDayAllChannels01);
		System.out.println("This day all channels: " + listDayAllChannels02);
		System.out.println("This day all channels: " + listDayAllChannels03);
		System.out.println("This day all channels: " + listDayAllChannels04);
	}

	
	public List<BroadcastingProgramDisplayingInfo> getListDayAllChannels01() {
		GregorianCalendar currentTime = new GregorianCalendar();
//		System.out.println("Service : currentTime: " + currentTime.getTime() +  currentTime.getTimeInMillis());

		return listDayAllChannels01;
	}
	
	public List<BroadcastingProgramDisplayingInfo> getListDayAllChannels02() {
		return listDayAllChannels02;
	}
	
	public List<BroadcastingProgramDisplayingInfo> getListDayAllChannels03() {
		return listDayAllChannels03;
	}
	
	public List<BroadcastingProgramDisplayingInfo> getListDayAllChannels04() {
		return listDayAllChannels04;
	}

	
	@Transactional
	public List<TbProgramItemData> getDayChannel(int channel) {
		GregorianCalendar currentTime = new GregorianCalendar();
		System.out.println("getdaychannel : currentTime: " + currentTime.getTime() +  currentTime.getTimeInMillis());

		List<TbProgramItemData> list = new ArrayList<>();
//		this.cBRepository.getDayChannel(channel).forEach(e -> list.add(e));
		for(TbProgramItemData tbProgramItemData : this.cBRepository.getDayChannel(channel)){
			list.add(tbProgramItemData);
		}
		return list;
	}

	
	@Transactional
	public List<TbProgramItemData> getDayAllChannels() {
		List<TbProgramItemData> list = new ArrayList<>();
//		this.cBRepository.getDayAllChannels().forEach(e -> list.add(e));
		for(TbProgramItemData tbProgramItemData : this.cBRepository.getDayAllChannels()){
			list.add(tbProgramItemData);
		}
		return list;
	}

}
