package com.uit.danangfinancialtower.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * IndexController
 */
@Controller
public class IndexController {

    @RequestMapping({"/", "/index"})
    public ModelAndView indexPage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }
}
