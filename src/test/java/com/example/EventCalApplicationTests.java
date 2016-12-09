package com.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.web.EventController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventCalApplicationTests {
	
	//Controller test
	 @Autowired
	    private EventController controller;

	    @Test
	    public void contexLoads() throws Exception {
	        assertThat(controller).isNotNull();
	    }	

}
