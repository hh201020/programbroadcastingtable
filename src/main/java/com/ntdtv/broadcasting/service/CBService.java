package com.ntdtv.broadcasting.service;

import org.springframework.validation.annotation.Validated;

import com.ntdtv.broadcasting.model.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Validated
public interface CBService
{
    public List<BroadcastingProgramDisplayingInfo> getListDayAllChannels01();
	public List<BroadcastingProgramDisplayingInfo> getListDayAllChannels02();
    public List<BroadcastingProgramDisplayingInfo> getListDayAllChannels03();
	public List<BroadcastingProgramDisplayingInfo> getListDayAllChannels04();
	
    public void refreshDayAllChannels();    

    @NotNull
    List<TbProgramItemData> getDayChannel(int channel);
    @NotNull
    List<TbProgramItemData> getDayAllChannels();
}
