package com.uit.danangfinancialtower.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * AppController
 */
@Controller
public class AppController {

    @RequestMapping("/appointment")
    public ModelAndView appointmentPage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("appointment");
        return mav;
    }
}
