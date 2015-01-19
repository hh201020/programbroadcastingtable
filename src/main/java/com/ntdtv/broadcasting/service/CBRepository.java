package com.ntdtv.broadcasting.service;

import javax.validation.constraints.NotNull;

import com.ntdtv.broadcasting.model.TbProgramItemData;

public interface CBRepository extends GenericRepository<Long, TbProgramItemData>
{
    @NotNull
    public Iterable<TbProgramItemData> getDayChannel(int channel);
    @NotNull
	public Iterable<TbProgramItemData> getDayAllChannels();
}
