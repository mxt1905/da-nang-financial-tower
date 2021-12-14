package com.uit.danangfinancialtower.controller;

import com.uit.danangfinancialtower.service.building.BuildingSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * AppController
 */
@Controller
@RequiredArgsConstructor
public class AppController {

    private final BuildingSearchService buildingSearchService;

    @RequestMapping({"/", "/index"})
    public ModelAndView indexPage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping("/appointment")
    public ModelAndView appointmentPage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("appointment");
        return mav;
    }

    @RequestMapping("/login")
    public ModelAndView loginPage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }

    @RequestMapping("/map")
    public ModelAndView mapPage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("map3d");
        return mav;
    }

    @RequestMapping("/event")
    public ModelAndView eventPage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("event");
        return mav;
    }

    @RequestMapping("/building-list")
    public ModelAndView buildingListPage() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("buildings", buildingSearchService.execute());
        mav.setViewName("building-list");
        return mav;
    }

    @RequestMapping("/building/{buildingId}")
    public ModelAndView buildingPage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("building");
        return mav;
    }
}
