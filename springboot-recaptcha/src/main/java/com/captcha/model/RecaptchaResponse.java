package com.captcha.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class RecaptchaResponse {
	
	private boolean success;
	private String challenge_ts;
	private String hostName;

}
