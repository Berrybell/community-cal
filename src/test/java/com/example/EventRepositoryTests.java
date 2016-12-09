package com.example;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Category;
import com.example.domain.Event;
import com.example.domain.EventRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EventRepositoryTests {

    @Autowired
    private EventRepository repository;
    
    //Testing search
    @Test
    public void findByTitleShouldReturnHost() {
    	List<Event> events = repository.findByName("Christmas sale");
        assertThat(events).hasSize(1);
        assertThat(events.get(0).getHost()).isEqualTo("Book store");
    }
    
    //Testing event creation
    @Test
    public void createNewEvent() {
    	Event event = new Event("Art show", "Gallery", "Mannerheimintie 100", "December 10", "10:00 - 21:00", new Category("Art"));
    	repository.save(event);
    	assertThat(event.getId()).isNotNull();
    }
    
    //Testing event deletion
    @Test
    public void deleteEvent() {
    	List<Event> events = repository.findByName("Christmas sale");
    	repository.delete(events.get(0).getId());
    	assertThat(repository.findOne(events.get(0).getId()) == null);
    }
    

}