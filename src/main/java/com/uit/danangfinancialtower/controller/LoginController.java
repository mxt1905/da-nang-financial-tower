package com.uit.danangfinancialtower.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * LoginController
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public ModelAndView map() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }
}
