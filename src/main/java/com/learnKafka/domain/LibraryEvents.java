package com.learnKafka.domain;

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
	
	public LibraryEvents()
	{
		
	}
	public LibraryEvents(Integer libraryEventID, Book book)
	{
		super();
		LibraryEventID = libraryEventID;
		this.book = book;
	}
	
	public Integer getLibraryEventID()
	{
		return LibraryEventID;
	}
	public void setLibraryEventID(Integer libraryEventID)
	{
		LibraryEventID = libraryEventID;
	}
	public Book getBook()
	{
		return book;
	}
	public void setBook(Book book)
	{
		this.book = book;
	}
	
	
}
