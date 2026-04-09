package org.example.talentlens.controller;

import org.example.talentlens.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;

public class Controller {
    @Autowired
    public ResumeService resumeService;

    public String test() {
        return "Working!";
    }
}