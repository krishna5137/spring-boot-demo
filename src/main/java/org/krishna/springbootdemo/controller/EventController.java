package org.krishna.springbootdemo.controller;

import org.krishna.springbootdemo.data.EventData;
import org.krishna.springbootdemo.model.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/events")
public class EventController {

    //private static List<Event> events = new ArrayList<>();

    @RequestMapping(method = RequestMethod.GET)
    public String displayAllEvents(Model model) {
        model.addAttribute("title", "All events");
        model.addAttribute("events", EventData.getAllEvents());
        return "events/index";
    }

    @GetMapping("/create")
    public String renderCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");
        return "events/create";
    }

    @PostMapping("/create")
    public String createEvent(@RequestParam String eventName,
                                @RequestParam String eventDescription) {
        EventData.add(new Event(eventName, eventDescription));
        return "redirect:";
    }

    @GetMapping("delete")
    public String renderDeleteEventForm(Model model ) {
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", EventData.getAllEvents());
        return "events/delete";
    }

    @PostMapping("delete")
    public String deleteEvents(@RequestParam(required = false) int[] eventIds) {
        if (eventIds != null) {
            for (int id : eventIds) {
                EventData.delete(id);
            }
        }
        return "redirect:";
    }
}
