package com.spring.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.dao.entity.Book;
import com.spring.boot.dao.jpa.repository.BookRepository;
 
@Service
@Transactional
public class BookService implements IBookService{
 
    @Autowired
    private BookRepository repo;
    
    public List<Book> listAll(String keyword) {
    	if(keyword != null) {
    		return repo.findAll(keyword);
    	}
    	
        return repo.findAll();
    }
     
    public void save(Book book) {
        repo.save(book);
    }
     
    public Book get(long id) {
        return repo.findById(id).get();
    }
    
    public void delete(long id) {
        repo.deleteById(id);
    }
}
