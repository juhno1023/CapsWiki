package com.example.capswiki.Domain.Post.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping(value = "/{path:[^\\.]*}")
    public String forward() {
        return "forward:/";
    }

}
