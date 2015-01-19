package com.ntdtv.broadcasting.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import com.ntdtv.broadcasting.model.TbProgramItemData;

import org.springframework.stereotype.Repository;

@Repository
public class CBRepositoryImpl extends
		GenericJpaRepository<Long, TbProgramItemData> implements CBRepository {

	
	public Iterable<TbProgramItemData> getDayChannel(int channel) {
		
		GregorianCalendar today = new GregorianCalendar();
		System.out.println("Access Database : " + today);
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<TbProgramItemData> query = builder
				.createQuery(this.entityClass);
		return this.entityManager
				.createQuery(
//						"select t from TbProgramItemData t where t.tvChannelId=:thisChannel AND date(t.startGMTDateTime) = '2014-11-6'")
						//Get the programs of current date.
//						"select t from TbProgramItemData t where t.tvChannelId = :thisChannel AND DATE_FORMAT(t.startGMTDateTime, '%Y-%m-%d') = :thisDay ORDER BY t.startGMTDateTime")
//						.setParameter("thisChannel", channel).setParameter("thisDay", new SimpleDateFormat("yyyy-MM-dd").format(today)).getResultList();
						// Get the programs 5 hours before and after current time.
						"select t from TbProgramItemData t where t.tvChannelId = :thisChannel AND t.startAtGMT > :beginning And t.startAtGMT < :end ORDER BY t.startAtGMT")
				.setParameter("thisChannel", channel).setParameter("beginning", today.getTimeInMillis()-18000000).setParameter("end", today.getTimeInMillis()+18000000).getResultList();
	}
	

	
	public Iterable<TbProgramItemData> getDayAllChannels() {
///		GregorianCalendar today = new GregorianCalendar();
		 Date today = new Date();
		System.out.println(today);
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<TbProgramItemData> query = builder
				.createQuery(this.entityClass);
		return this.entityManager
				.createQuery(
//						"select t from TbProgramItemData t where t.tvChannelId=:thisChannel AND date(t.startGMTDateTime) = '2014-11-6'")
						"select t from TbProgramItemData t where DATE_FORMAT(t.startGMTDateTime, '%Y-%m-%d') = :thisDay ORDER BY t.startGMTDateTime")
				.setParameter("thisDay", new SimpleDateFormat("yyyy-MM-dd").format(today)).getResultList();
	}
}
