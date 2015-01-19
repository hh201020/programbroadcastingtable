package com.ntdtv.broadcasting.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Component;

import com.ntdtv.broadcasting.model.*;

@Component
class ProgramDisplayTableImpl implements ProgramDisplayTable<TbProgramItemData, BroadcastingProgramDisplayingInfo> {
	SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	List<List<TbProgramItemData>> originalListDayAllChannels;

	// public AllDateTimeOfPrograms(List<List<TbProgramItemData>>
	// originalListDayAllChannels) {
	// super();
	// this.originalListDayAllChannels = originalListDayAllChannels;
	// }
	//
	public List<List<TbProgramItemData>> getOriginalListDayAllChannels() {
		return originalListDayAllChannels;
	}

	@Override
	public void setOriginalListDayAllChannels(List<List<TbProgramItemData>> originalListDayAllChannels) {
		this.originalListDayAllChannels = originalListDayAllChannels;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ntdtv.site.ProgramDisplayTable#fillinUsefulPrograms()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<List<BroadcastingProgramDisplayingInfo>> fillinUsefulPrograms() {
		List<List<BroadcastingProgramDisplayingInfo>> model_OutputList = new ArrayList<>();
		List<List<BroadcastingProgramDisplayingInfo>> localListDayAllChannels = changeToLocalUsefulPrograms();
		TreeMap<Date, BroadcastingProgramDisplayingInfo> allDateTimesEmptyProgram = emptyMapDisplaying(emptyMapAddingListDateTimesLocal(localListDayAllChannels));
		if (localListDayAllChannels != null && localListDayAllChannels.size() != 0) {
			for (List<BroadcastingProgramDisplayingInfo> programItemList : changeToLocalUsefulPrograms()) {
				List<BroadcastingProgramDisplayingInfo> model_Outputs = new ArrayList<>();
				TreeMap<Date, BroadcastingProgramDisplayingInfo> allDateTimes = new TreeMap<>();
				if (allDateTimesEmptyProgram != null) {
					allDateTimes = (TreeMap<Date, BroadcastingProgramDisplayingInfo>) allDateTimesEmptyProgram.clone();
				}
				for (BroadcastingProgramDisplayingInfo programItem : programItemList) {
					allDateTimes.put(programItem.getStartGMTDateTime(), programItem);
				}
				model_Outputs.addAll(allDateTimes.values());

				model_OutputList.add(fillinEmptyProgramList(model_Outputs));
			}
		} else {
		}
		return model_OutputList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ntdtv.site.ProgramDisplayTable#emptyMapAddingListDateTimes()
	 */
	// Has no use in this program.
	@Override
	public TreeMap<Date, TbProgramItemData> emptyMapAddingListDateTimes() {
		TreeMap<Date, TbProgramItemData> dateTimePrograms = new TreeMap<>();
		for (List<TbProgramItemData> programItemList : originalListDayAllChannels) {
			for (TbProgramItemData programItem : programItemList) {
				dateTimePrograms.put(programItem.getStartGMTDateTime(), new TbProgramItemData());
			}
		}
		return dateTimePrograms;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ntdtv.site.ProgramDisplayTable#emptyMapAddingListDateTimes()
	 */
	private TreeMap<Date, BroadcastingProgramDisplayingInfo> emptyMapAddingListDateTimesLocal(List<List<BroadcastingProgramDisplayingInfo>> localListDayAllChannels) {
		TreeMap<Date, BroadcastingProgramDisplayingInfo> dateTimePrograms = new TreeMap<>();
		for (List<BroadcastingProgramDisplayingInfo> programItemList : localListDayAllChannels) {
			for (BroadcastingProgramDisplayingInfo programItem : programItemList) {
				dateTimePrograms.put(programItem.getStartGMTDateTime(), new BroadcastingProgramDisplayingInfo());
			}
		}
		return dateTimePrograms;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ntdtv.site.ProgramDisplayTable#changeToLocalUsefulPrograms()
	 */
	@Override
	public List<List<BroadcastingProgramDisplayingInfo>> changeToLocalUsefulPrograms() {
		List<List<BroadcastingProgramDisplayingInfo>> model_OutputList = new ArrayList<>();
		if (originalListDayAllChannels != null && originalListDayAllChannels.size() != 0) {
			for (List<TbProgramItemData> programItemList : originalListDayAllChannels) {
				List<BroadcastingProgramDisplayingInfo> model_Outputs = new ArrayList<>();
				for (TbProgramItemData programItem : programItemList) {
					if (programItem.getParentId() <= 0) {
						BroadcastingProgramDisplayingInfo model_Output = new BroadcastingProgramDisplayingInfo();
						model_Output.setStartAtGMT(programItem.getStartAtGMT());
						model_Output.setStartGMTDateTime(programItem.getStartGMTDateTime());
						if (programItem.getProgramName().length() > 10) {
							model_Output.setProgramName(programItem.getProgramName().substring(0, 10));
						} else {
							model_Output.setProgramName(programItem.getProgramName().substring(0, programItem.getProgramName().length()));
						}
						if (programItem.getTvProgramCode().equals("Merged")) {
							model_Output.setTvProgramCode("M");
						}
						model_Outputs.add(model_Output);
					}
				}
				model_OutputList.add(model_Outputs);
			}
		} else {
		}
		return model_OutputList;
	}

	private TreeMap<Date, BroadcastingProgramDisplayingInfo> emptyMapDisplaying(TreeMap<Date, BroadcastingProgramDisplayingInfo> dateTimePrograms) {
		TreeMap<Date, BroadcastingProgramDisplayingInfo> dateTimeDisplaying = new TreeMap<>();
		for (Date date : dateTimePrograms.keySet()) {
			dateTimeDisplaying.put(date, new BroadcastingProgramDisplayingInfo());
		}
		for (Map.Entry<Date, BroadcastingProgramDisplayingInfo> entry : dateTimeDisplaying.entrySet()) {
			entry.getValue().setStartGMTDateTime(entry.getKey());
			entry.getValue().setStartAtGMT(entry.getKey().getTime());
		}
		return dateTimeDisplaying;
	}

	private List<BroadcastingProgramDisplayingInfo> fillinEmptyProgramList(List<BroadcastingProgramDisplayingInfo> outputList) {
		List<BroadcastingProgramDisplayingInfo> displayInfo_Program = new ArrayList<>();
		for (BroadcastingProgramDisplayingInfo item : outputList) {
			BroadcastingProgramDisplayingInfo info_Program = new BroadcastingProgramDisplayingInfo();
			info_Program.setStartAtGMT(item.getStartAtGMT());
			info_Program.setStartGMTDateTime(item.getStartGMTDateTime());
			info_Program.setStartTime(dateFormat.format(info_Program.getStartGMTDateTime()));
			if (item.getProgramName() != null) {
				info_Program.setProgramName(item.getProgramName());
				info_Program.setTvProgramCode(item.getTvProgramCode());
			} else if (outputList.indexOf(item) > 0) {
				info_Program.setProgramName(displayInfo_Program.get(outputList.indexOf(item) - 1).getProgramName());
				info_Program.setTvProgramCode(displayInfo_Program.get(outputList.indexOf(item) - 1).getTvProgramCode());
			}
			displayInfo_Program.add(info_Program);
		}
		return displayInfo_Program;
	}
}
