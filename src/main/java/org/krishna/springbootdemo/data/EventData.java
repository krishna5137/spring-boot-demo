package org.krishna.springbootdemo.data;

import org.krishna.springbootdemo.model.Event;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EventData {

    private static final Map<Integer, Event> events = new HashMap<>();

    // add an event
    public static void add(Event event) {
        events.put(event.getId(), event);
    }

    // display event by id
    public static Event getEvent(int id) {
        return events.get(id);
    }

    // get all events
    public static Collection<Event> getAllEvents() {
        return events.values();
    }

    // delete an event
    public static void delete(int id) {
        events.remove(id);
    }


}
