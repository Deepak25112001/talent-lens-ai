package org.example.talentlens.controller;

import org.example.talentlens.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/resume")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @PostMapping("/upload")
    public String uploadResume(@RequestParam("file") MultipartFile file) {
        return resumeService.parseResume(file);
    }

    @GetMapping("/test")
    public String test() {
        return "Resume API working 🚀";
    }
}