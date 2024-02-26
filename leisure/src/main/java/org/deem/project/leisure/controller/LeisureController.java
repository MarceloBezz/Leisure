package org.deem.project.leisure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/leisure")
public class LeisureController {
	
	@GetMapping("/index")
	public String getIndex() {
		return "/index";
	}
	@GetMapping("/faq")
	public String getFaq() {
		return "/faq";
	}
	@GetMapping("/faq#duvidas")
	public String getFaqDuvidas() {	
		return "/faq#duvidas";
	}
	@GetMapping("/index#sobre")
	public String getIndexSobre() {
		return "/index#sobre";
	}
	@GetMapping("/index#servicos-area")
	public String getIndexServicosArea() {
		return "/index#servicos-area";
	}
	@GetMapping("/index#time-area")
	public String getIndexTimeArea() {
		return "/index#time-area";
	}
	@GetMapping("/index#bottomMenu")
	public String getIndexContatos() {
		return "/index#bottomMenu";
	}
	
}
