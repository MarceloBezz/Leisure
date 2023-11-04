package org.deem.project.leisure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/leisure")
public class LeisureController {
	
	@GetMapping("/index")
	public String getIndex() {
		return "/leisure/index";
	}
	@GetMapping("/faq")
	public String getFaq() {
		return "/leisure/faq";
	}
	@GetMapping("/faq#duvidas")
	public String getFaqDuvidas() {	
		return "/leisure/faq#duvidas";
	}
	@GetMapping("/index#sobre")
	public String getIndexSobre() {
		return "/leisure/index#sobre";
	}
	@GetMapping("/index#servicos-area")
	public String getIndexServicosArea() {
		return "/leisure/index#servicos-area";
	}
	@GetMapping("/index#time-area")
	public String getIndexTimeArea() {
		return "/leisure/index#time-area";
	}
	@GetMapping("/index#bottomMenu")
	public String getIndexContatos() {
		return "/leisure/index#bottomMenu";
	}
	
}
