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
@RequestMapping(value = "")
public class DefaultController {
	private static final Logger log = LogManager.getLogger();

	@RequestMapping(value = { "", "" }, method = RequestMethod.GET)
	public String list(Map<String, Object> model) {

		System.out.println("Starting ...");
		return "index";
	}
}
