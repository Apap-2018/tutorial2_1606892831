package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/generator")
	public String generator(@RequestParam(value = "a", required=false, defaultValue="0") String angkaA, @RequestParam(value = "b", required = false, defaultValue="0") String angkaB,Model model) {
		int a = Integer.parseInt(angkaA);
		int b = Integer.parseInt(angkaB);
		String kumpulan = "h";
		
		if(a <= 1 && b<=1) {
			model.addAttribute("a",a);
			model.addAttribute("b",b);
			kumpulan = kumpulan+"m";
			
		}
		else if(a>=2 && b<=1) {
			model.addAttribute("a",a);
			model.addAttribute("b",b);
			for(int i=0;i<a;i++) {
				kumpulan = kumpulan+"m";
			}
			
		}
		else if(a<=1 && b>=2) {
			model.addAttribute("a",a);
			model.addAttribute("b",b);
			kumpulan = kumpulan+"m";
			String kumpulan2 = kumpulan;
			for(int i=0;i<b-1;i++) {
				kumpulan = kumpulan+" "+kumpulan2;
			}
		}
		else if(a>=2 && b>=2) {
			model.addAttribute("a",a);
			model.addAttribute("b", b);
			for (int i=0;i<a;i++) {
				kumpulan = kumpulan+"m";
			}
			String kumpulan2= kumpulan;
			for(int j=0;j<b-1;j++) {
				kumpulan = kumpulan+" "+kumpulan2;
			}
		}
		model.addAttribute("kumpulan",kumpulan);
		return "generator";
	}
	@RequestMapping("/viral")
	public String method() {
		return "viral";
	}
	
	@RequestMapping("/challenge")
	public String challenge(@RequestParam(value = "name") String name, Model model) {
		model.addAttribute("name", name);
		return "challenge";
	}
	@RequestMapping(value= {"/challenge","challenge/{name}"})
	public String challengePath(@PathVariable Optional <String> name, Model model) {
		if(name.isPresent()) {
			model.addAttribute("name",name.get());
		}
		else {
			model.addAttribute("name","KB");	
		}
		
		return "challenge";
	}
	
}