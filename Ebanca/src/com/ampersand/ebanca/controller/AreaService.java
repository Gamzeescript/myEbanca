package com.ampersand.ebanca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ampersand.ebanca.Repository.AreaImp;

@Controller
@RequestMapping("/")
public class AreaService {
	

		
		@Autowired
		private AreaImp areaVer;
		

		@RequestMapping(value = "singular", method = RequestMethod.GET)
		public ModelAndView verArea() {
			ModelAndView mv = new ModelAndView();
			mv.addObject("listagatito", areaVer.get());
			mv.setViewName("s");
			return mv;
			
		}


}
