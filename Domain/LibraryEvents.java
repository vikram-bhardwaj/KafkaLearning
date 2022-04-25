package com.learnKafka.KafkaLearning.Domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
public class LibraryEvents
{
	private Integer LibraryEventID;
	private Book book;
}
