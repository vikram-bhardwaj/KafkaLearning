package com.learnKafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learnKafka.domain.LibraryEvents;

import lombok.extern.slf4j.Slf4j;

@Component
public class LibraryEventProducer
{
	@Autowired
	KafkaTemplate<Integer, String> kafkaTemplate;

	@Autowired
	ObjectMapper objectMapper; // to convert an object to JSON format String
	
	Slf4j log;

	public void sendLibraryEvents(LibraryEvents libraryEvents) throws JsonProcessingException
	{

		Integer key = libraryEvents.getLibraryEventID();
		String value = objectMapper.writeValueAsString(libraryEvents);
		ListenableFuture<SendResult<Integer, String>> listenableFuture = kafkaTemplate.sendDefault(key, value);
		listenableFuture.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>()
		{

			@Override
			public void onSuccess(SendResult<Integer, String> result)
			{
				handleSuccess(key, value, result);

			}

			@Override
			public void onFailure(Throwable ex)
			{
				handleFailure(key, value, ex);

			}

		});

	}
	private void handleSuccess(Integer key, String value, SendResult<Integer, String> result)
	{
		System.out.println("message sent successfully. key: " + key + " value: " + value + "result: " + result.getRecordMetadata().partition());
	}
	
	private void handleFailure(Integer key, String value, Throwable ex)
	{
		System.out.println("Message sending failed. The exception is: " + ex.getMessage());
	}
}
