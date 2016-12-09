package com.example.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.Event;
import com.example.domain.EventRepository;
import com.example.domain.CategoryRepository;

@Controller
public class EventController {
	@Autowired
	private EventRepository repository;
	@Autowired
	private CategoryRepository crepository;
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
    public String index(Model model) {
        return "eventlist";        
    }
	
	 @RequestMapping(value="/login")
	public String login() {	
	    return "login";
	}
	
	@RequestMapping(value = "/addevent")
    public String addBook(Model model){
    	model.addAttribute("event", new Event());
    	model.addAttribute("categories", crepository.findAll());
        return "addevent";
    }
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Event event){
        repository.save(event);
        return "redirect:eventlist";
    }    

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteEvent(@PathVariable("id") Long eventId, Model model) {
    	repository.delete(eventId);
        return "redirect:/eventlist";
    }   
	
	@RequestMapping(value="/eventlist", method=RequestMethod.GET)
    public String booklist(Model model) {
        // Add events to model and return to view
        model.addAttribute("events", repository.findAll());
        return "eventlist";        
    }
	
	// RESTful service to get all events
    @RequestMapping(value="/events", method = RequestMethod.GET)
    public @ResponseBody List<Event> eventListRest() {	
        return (List<Event>) repository.findAll();
    }    

	// RESTful service to get event by id
    @RequestMapping(value="/event/{id}", method = RequestMethod.GET)
    public @ResponseBody Event findEventRest(@PathVariable("id") Long eventId) {	
    	return repository.findOne(eventId);
    } 

}
