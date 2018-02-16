package org.lrf.blogadmin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TypeController {

	@RequestMapping("/types")
	public ModelAndView getTypes() {
		ModelAndView mv = new ModelAndView("type_manage");
		return mv;
	}
	
	@RequestMapping("/show_add_type")
	public ModelAndView showAddType() {
		ModelAndView mv = new ModelAndView("add_type");
		return mv;
	}
	
	@RequestMapping("/add_type")
	@ResponseBody
	public String addType() {
		return null;
	}

	@RequestMapping("/update_type")
	@ResponseBody
	public String updateType() {
		return null;
	}
}
