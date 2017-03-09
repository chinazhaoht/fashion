package com.fashion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhaoht
 * @date 2016/9/10 10:40
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    public String home(){
        return "/index";
    }
}
