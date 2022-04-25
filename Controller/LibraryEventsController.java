package com.learnKafka.KafkaLearning.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learnKafka.KafkaLearning.Domain.LibraryEvents;

@RestController
public class LibraryEventsController
{
	@PostMapping("/v1/libraryevent")
	public ResponseEntity<LibraryEvents> postLibraryEvents(@RequestBody LibraryEvents libraryEvents)
	{
		//invoke kafka
		
		return ResponseEntity.status(HttpStatus.CREATED).body(libraryEvents);
		
	}
}
