package com.springapp.mvc;

import com.jason.bookparadise.dao.BookDao;
import com.jason.bookparadise.dao.UserDao;
import com.jason.bookparadise.entities.Book;
import com.jason.bookparadise.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/test")
public class HelloController {

	@Autowired
	BookDao bookDao;

	@Autowired
	UserDao userDao;

	@RequestMapping(value = "/hello",method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");
		return "hello";
	}
	@RequestMapping(value = "/book",method = RequestMethod.GET)
	public String testbook(){
		List<Book> books = bookDao.getAll();
		for(Book book:books){
			System.out.println(book);
		}
		return "test";
	}

	@RequestMapping(value = "/onebook",method = RequestMethod.GET)
	public String testonebook(){
		Book book = bookDao.getById(1);
		System.out.println(book);
		return "test";
	}

	@RequestMapping(value = "/user",method = RequestMethod.GET)
	public String testuser(){
		List<User> users = userDao.getAll();
		for(User user:users){
			System.out.println(user);
		}
		return "test";
	}

	@RequestMapping(value = "/save",method = RequestMethod.GET)
	public String testsave(){
//		User user = new User();
//		user.setUserid(5);
//		user.setUsername("Mae Xu");
//		try {
//			user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1988-11-11"));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		user.setEducation("master");
//		user.setGender("female");
//		userDao.saveuser(user);

		Book book = new Book();
		book.setBookid(5);
		book.setBookname("Î÷ÓÎ¼Ç");
		book.setPersonid(5);
		bookDao.savebook(book);

		return "test";
	}
}