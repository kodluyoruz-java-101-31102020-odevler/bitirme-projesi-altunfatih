package com.spring.boot.dao.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.boot.dao.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	
	@Query("SELECT p FROM Book p WHERE "
			+ "CONCAT(p.id, p.name, p.author, p.publisher, p.price) "
			+ "LIKE %?1%")
	public List<Book> findAll(String keyword);
	
}