package com.uit.danangfinancialtower.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * AppController
 */
@Controller
public class AppController {

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
    public ModelAndView map() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("map3d");
        return mav;
    }
}
