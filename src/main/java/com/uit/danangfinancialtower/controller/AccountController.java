package com.uit.danangfinancialtower.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * AccountController
 */
@Controller
public class AccountController {

    @RequestMapping("/account")
    public ModelAndView map() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("account-list");
        return mav;
    }
}
