package com.example.demo;

import com.example.demo.entity.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		Person person = new Person.Builder().setAge(10).setAddress("asd").getPerson();
		Person person2 = new Person.Builder().setAge(2).getPerson();
		System.out.println(person2);
		SpringApplication.run(DemoApplication.class, args);
	}

}
