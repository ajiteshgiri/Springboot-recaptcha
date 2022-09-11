package com.captcha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.captcha.model.Employee;
import com.captcha.model.RecaptchaResponse;
import com.captcha.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	@Value("${recaptcha.sitekey}")
	private String sitekey;
	private String message;
	
	@GetMapping("/")
	public String EmployeeReg(@ModelAttribute Employee employee, Model model) {
		model.addAttribute("recaptchaSitekey", sitekey);
		model.addAttribute("message", message);
		return "index";
	}
	
	@PostMapping("/addEmployee")
	public String EmployeeAdd(@ModelAttribute Employee employee, Model model, @RequestParam (name="g-recaptcha-response") String recaptchaRes) {
		String url="https://www.google.com/recaptcha/api/siteverify";
		String params="?secret=6LencO0hAAAAANZQNTanRAtK-YHHPqLH8z3RBMqz&response="+recaptchaRes;
		RestTemplate restTemplate = new RestTemplate();
		RecaptchaResponse recaptchaResponse = restTemplate.exchange(url+params, HttpMethod.POST, null, RecaptchaResponse.class).getBody();
		if(recaptchaResponse.isSuccess()) {
			service.save(employee);
			message="data added successfull";
			return "redirect:/";	
		}else {
			message="please validate recaptcha";
			return "redirect:/";
		}
		
	}

}
