package com.spring.boot.service;

import java.util.List;

import com.spring.boot.dao.entity.Book;

public interface IBookService {
	
	public List<Book> listAll(String keyword);
	
	public void save(Book book);
	
	public Book get(long id);
	
	public void delete(long id);
}
