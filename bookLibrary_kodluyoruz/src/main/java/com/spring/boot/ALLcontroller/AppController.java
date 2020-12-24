package com.spring.boot.ALLcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.boot.dao.entity.Book;
import com.spring.boot.service.BookService;


@Controller
public class AppController {
 
    @Autowired
    private BookService service;
     
    @RequestMapping("/")
    public String viewHomePage(Model model,
    		 @Param("keyword") String keyword) {
    	List<Book> listBooks = service.listAll(keyword);
    	model.addAttribute("listBooks", listBooks);
    	model.addAttribute("keyword", keyword);
    	
    	return "index";
    }
    
    @RequestMapping("/new")
    public String showNewBookForm(Model model) {
    	Book book = new Book();
    	model.addAttribute("book", book);
    	
    	return "new_book";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBook(@ModelAttribute("book") Book book) {
    	service.save(book);
    	
    	return "redirect:/";
    }
    
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditBookForm(@PathVariable(name = "id") Long id) {
    	ModelAndView mav = new ModelAndView("edit_book");
    	
    	Book book = service.get(id);
    	mav.addObject("book", book);
    	
    	return mav;
    }
    
    @RequestMapping("/delete/{id}")
    public String deleteBook(@PathVariable(name = "id") Long id) {
    	service.delete(id);
    	
    	return "redirect:/";
    }
    
}