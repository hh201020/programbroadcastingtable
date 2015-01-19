package com.ntdtv.broadcasting.web;

import com.ntdtv.broadcasting.model.*;
import com.ntdtv.broadcasting.service.CBService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import javax.inject.Inject;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import java.io.IOException;
import java.security.Principal;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/broadcast")
public class CBController {
	private static final Logger log = LogManager.getLogger();

	@Inject
	CBService cBService;

	int currentIndex01 = 0;
	int currentIndex02 = 0;
	int currentIndex03 = 0;
	int currentIndex04 = 0;
	List<BroadcastingProgramDisplayingInfo> model_Today_All_01 = new LinkedList<BroadcastingProgramDisplayingInfo>();
	List<BroadcastingProgramDisplayingInfo> model_Today_All_02 = new LinkedList<BroadcastingProgramDisplayingInfo>();
	List<BroadcastingProgramDisplayingInfo> model_Today_All_03 = new LinkedList<BroadcastingProgramDisplayingInfo>();
	List<BroadcastingProgramDisplayingInfo> model_Today_All_04 = new LinkedList<BroadcastingProgramDisplayingInfo>();

	@RequestMapping(value = { "", "CurrentBroadcasting" }, method = RequestMethod.GET)
	public String list(Map<String, Object> model) {
		// GregorianCalendar currentTime = new GregorianCalendar();
		log.debug("Listing tickets.");
//		System.out.println("CB display");
		GregorianCalendar currentTime = new GregorianCalendar();
		System.out.println("currentTime: " + currentTime.getTime() +  currentTime.getTimeInMillis());

		model_Today_All_01 = cBService.getListDayAllChannels01();
		model_Today_All_02 = cBService.getListDayAllChannels02();
		model_Today_All_03 = cBService.getListDayAllChannels03();
		model_Today_All_04 = cBService.getListDayAllChannels04();
		System.out.println("model_Today_All_01 : " + model_Today_All_01);

		currentIndex01 = currentProgram_Index(model_Today_All_01);
		putModel_Value(model, "tickets01", currentIndex01, model_Today_All_01);

		currentIndex02 = currentProgram_Index(model_Today_All_02);
		putModel_Value(model, "tickets02", currentIndex02, model_Today_All_02);

		currentIndex03 = currentProgram_Index(model_Today_All_03);
		putModel_Value(model, "tickets03", currentIndex03, model_Today_All_03);

		currentIndex04 = currentProgram_Index(model_Today_All_04);
		putModel_Value(model, "tickets04", currentIndex04, model_Today_All_04);

		System.out.println(model.get("tickets01"));
		return "broadcast/CurrentBroadcasting";
	}

	private int currentProgram_Index(List<BroadcastingProgramDisplayingInfo> model_Today_All) {
		int Index = 0;
		GregorianCalendar currentTime = new GregorianCalendar();
//		System.out.println("currentTime: " + currentTime.getTimeInMillis());
		if (model_Today_All != null && model_Today_All.size() != 0) {
			for (BroadcastingProgramDisplayingInfo programItem : model_Today_All) {
				if (programItem.getStartAtGMT() > currentTime.getTimeInMillis()) {
					Index = model_Today_All.indexOf(programItem);
					return Index;
					//break;
				}
			}
		}else{
			return Index;
		}
		return model_Today_All.size()-1;
	}

	private void putModel_Value(Map<String, Object> model, String tickets,
			int currentIndex, List<BroadcastingProgramDisplayingInfo> model_Today_All) {
//		System.out.println("currentIndex = " + currentIndex);
		if (model_Today_All != null && model_Today_All.size() > 5) {
			if (currentIndex <= 1) {
				model.put(tickets, model_Today_All.subList(currentIndex, 4));
			} else if (currentIndex < model_Today_All.size() - 5) {
				model.put(tickets, model_Today_All.subList(currentIndex - 2,
						currentIndex + 4));
			} else {
				model.put(tickets, model_Today_All.subList(currentIndex - 2,
						model_Today_All.size()));
			}
		} else if (model_Today_All != null && model_Today_All.size() > 0) {
			model.put(tickets, model_Today_All);
		}
	}


	private ModelAndView getListRedirectModelAndView() {
		return new ModelAndView(this.getListRedirectView());
	}

	private View getListRedirectView() {
		return new RedirectView("/ticket/CurrentBroadcasting", true, false);
	}

}
