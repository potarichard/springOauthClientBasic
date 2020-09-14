package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// go to https://console.developers.google.com/   create creditentials, create oatuh client id, webclient ... copy key and secret

@RestController
@RequestMapping("/oa")
public class OAuthPart {

	@GetMapping
	public String indi() {
		return "Omami blue";
	}
}
