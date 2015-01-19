package com.ntdtv.broadcasting.service;

import java.util.Date;
import java.util.List;
import java.util.TreeMap;

interface ProgramDisplayTable<T, B> {

	void setOriginalListDayAllChannels(List<List<T>> originalListDayAllChannels);

	public abstract List<List<B>> fillinUsefulPrograms();

	public abstract TreeMap<Date, T> emptyMapAddingListDateTimes();

	public abstract List<List<B>> changeToLocalUsefulPrograms();


}