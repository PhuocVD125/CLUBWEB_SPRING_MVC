package com.phuocvu.web.service.impl;

import com.phuocvu.web.dto.EventDto;
import com.phuocvu.web.models.Club;
import com.phuocvu.web.models.Event;
import com.phuocvu.web.repository.ClubRepository;
import com.phuocvu.web.repository.EventRepository;
import com.phuocvu.web.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.phuocvu.web.mapper.EventMapper.mapToEventDto;
import static com.phuocvu.web.mapper.EventMapper.maptoEvent;

@Service
public class EventServiceImpl implements EventService {
    private EventRepository eventRepository;
    private ClubRepository clubRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository, ClubRepository clubRepository) {
        this.eventRepository = eventRepository;
        this.clubRepository = clubRepository;
    }

    @Override
    public void createEvent(Long clubId, EventDto eventDto) {
        Club club = clubRepository.findById(clubId).get();
        Event event = maptoEvent(eventDto);
        event.setClub(club);
        eventRepository.save(event);
    }

    @Override
    public List<EventDto> findAllEvents() {
        List<Event> events = eventRepository.findAll();
        return events.stream().map((event) -> mapToEventDto(event)).collect(Collectors.toList());
    }

    @Override
    public EventDto findByEventId(Long eventId) {
        Event event = eventRepository.findById(eventId).get();
        return mapToEventDto(event);
    }

    @Override
    public void updateEvent(EventDto eventDto) {
        Event event = maptoEvent(eventDto);
        eventRepository.save(event);
    }

    @Override
    public void deleteEvent(long evenId) {
        eventRepository.deleteById(evenId);
    }
}
