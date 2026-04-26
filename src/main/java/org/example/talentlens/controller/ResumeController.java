package org.example.talentlens.controller;

import org.example.talentlens.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resume")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @GetMapping("/test")
    public String test() {
        return resumeService.test();
    }
}