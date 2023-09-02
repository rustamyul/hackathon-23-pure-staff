package ru.smbr.hackathon.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexMapController {
    @GetMapping
    public String getIndexHtml(){
        return "index.html";
    }
}
