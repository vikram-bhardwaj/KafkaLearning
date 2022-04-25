package com.learnKafka.domain;

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
	
	public Book()
	{
		
	}
	
	public Book(Integer bookID, String bookName, String bookAuth)
	{
		super();
		this.bookID = bookID;
		this.bookName = bookName;
		this.bookAuth = bookAuth;
	}
	
	public Integer getBookID()
	{
		return bookID;
	}
	public void setBookID(Integer bookID)
	{
		this.bookID = bookID;
	}
	public String getBookName()
	{
		return bookName;
	}
	public void setBookName(String bookName)
	{
		this.bookName = bookName;
	}
	public String getBookAuth()
	{
		return bookAuth;
	}
	public void setBookAuth(String bookAuth)
	{
		this.bookAuth = bookAuth;
	}

}
