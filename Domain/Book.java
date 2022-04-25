package com.learnKafka.KafkaLearning.Domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
public class Book
{
	private Integer bookID;
	private String bookName;
	private String bookAuth;

}
