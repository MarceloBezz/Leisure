package org.deem.project.leisure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/leisure")
public class LeisureController {
	
	@GetMapping("/index")
	public String getIndex() {
		return "leisure/index";
	}
	
}
