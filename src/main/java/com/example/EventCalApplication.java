package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.domain.Event;
import com.example.domain.EventRepository;
import com.example.domain.Category;
import com.example.domain.CategoryRepository;

import com.example.domain.User;
import com.example.domain.UserRepository;
import com.example.EventCalApplication;

@SpringBootApplication
public class EventCalApplication {
	private static final Logger log = LoggerFactory.getLogger(EventCalApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EventCalApplication.class, args);		
	}
	
	@Bean
	public CommandLineRunner eventCalDemo(EventRepository repository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			//Sample events
			log.info("enter sample events");
			crepository.save(new Category("Sale"));
			crepository.save(new Category("Concert"));
			crepository.save(new Category("Art show"));
			
			repository.save(new Event("Christmas sale", "Book store", "Ratapihantie 13", "December 1 - December 20 2016", "10:00 - 19:00", crepository.findByName("Sale").get(0)));
			repository.save(new Event("Christmas carols", "Community choir", "Urho Kekkosen katu 1", "December 15", "19:00", crepository.findByName("Concert").get(0)));
			
			//Sample users
			User user1 = new User("user", "$2a$04$AARBCcCki7YcxCATo06h5.gj.cZIKCXIVM6MsgD5EGrTgy6Uy85Hm", "user@abc.com", "USER");
			User user2 = new User("admin", "$2a$04$z6067HBvaF/1k1qW7e0LE.jAX8ObIfVI8xReD57MNKx6wu.fJftoa", "admin@abc.com", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("show all events");
			for (Event event : repository.findAll()) {
				log.info(event.toString());
			}
			
			log.info("show all categories");
			for (Category cat : crepository.findAll()) {
				log.info(cat.toString());
			}

		};
		
	}
			
}
