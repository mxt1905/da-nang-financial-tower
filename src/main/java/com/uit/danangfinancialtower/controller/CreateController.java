package com.uit.danangfinancialtower.controller;

import com.uit.danangfinancialtower.dto.EventDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * CreateController
 */
@Controller
@Slf4j
public class CreateController {

    @RequestMapping("/create")
    public ModelAndView create() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("create");
        mav.addObject("eventDto", new EventDto());
        return mav;
    }

    @PostMapping("/create")
    public ModelAndView createEvent(EventDto eventDto) {
        ModelAndView mav = new ModelAndView();
        log.info("Post called");
        log.info(eventDto.getId());
        log.info(eventDto.getName());
        return mav;
    }
}
