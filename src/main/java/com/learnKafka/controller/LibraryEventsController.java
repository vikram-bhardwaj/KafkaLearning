package com.learnKafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.learnKafka.domain.LibraryEvents;
import com.learnKafka.producer.LibraryEventProducer;

@RestController
public class LibraryEventsController
{
	@Autowired
	LibraryEventProducer libraryEventProducer;
	
	
	@RequestMapping("/test")
	public String test()
	{
		return "Hi";
	}
	
	@PostMapping("/v1/libraryevent")
	public ResponseEntity<LibraryEvents> postLibraryEvents(@RequestBody LibraryEvents libraryEvents) throws JsonProcessingException
	{
		//invoke kafka
		libraryEventProducer.sendLibraryEvents(libraryEvents);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(libraryEvents);
		
	}
}
