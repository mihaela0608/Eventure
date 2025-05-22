package com.example.demo.service.impl;

import com.example.demo.model.dto.EventRequestDto;
import com.example.demo.model.entity.EventRequest;
import com.example.demo.repository.EventRepository;
import com.example.demo.repository.EventRequestRepository;
import com.example.demo.service.EventService;
import com.example.demo.service.session.UserHelperService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {
    private final ModelMapper modelMapper;
    private final UserHelperService userHelperService;
    private final EventRequestRepository eventRequestRepository;

    public EventServiceImpl (ModelMapper modelMapper, UserHelperService userHelperService, EventRequestRepository eventRequestRepository) {
        this.modelMapper = modelMapper;
        this.userHelperService = userHelperService;
        this.eventRequestRepository = eventRequestRepository;
    }

    @Override
    public void eventRequesting (EventRequestDto eventRequestDto) {
        EventRequest eventRequest = modelMapper.map(eventRequestDto, EventRequest.class);
        eventRequest.setUserId(userHelperService.getUser().getId());

        eventRequestRepository.save(eventRequest);

    }
}
