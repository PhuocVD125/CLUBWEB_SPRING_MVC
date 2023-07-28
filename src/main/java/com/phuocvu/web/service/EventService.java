package com.phuocvu.web.service;

import com.phuocvu.web.dto.EventDto;
import com.phuocvu.web.models.Event;

import java.util.List;

public interface EventService {
    void createEvent(Long clubId, EventDto eventDto);
    List<EventDto> findAllEvents();
    EventDto findByEventId(Long eventId);
    void updateEvent(EventDto eventDto);
    void deleteEvent(long evenId);
}
