package com.example.java_task_2;

import com.example.java_task_2.dao.AuthorDAO;
import com.example.java_task_2.data.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableMongoRepositories
public class JavaTask2Application {
	@Autowired
	private AuthorDAO authorDAO;
	public static void main(String[] args) {
		SpringApplication.run(JavaTask2Application.class, args);
	}
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		Author author = authorDAO.findAuthor("Email");
		System.out.println(author);
		return String.format("Hello %s!", name);
	}
}
