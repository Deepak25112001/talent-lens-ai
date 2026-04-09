package org.example.talentlens.controller;

import org.example.talentlens.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/resume")
@CrossOrigin(origins = "*")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @PostMapping("/upload")
    public Map<String, Object> uploadResume(@RequestParam("file") MultipartFile file) {

        // Extract text from resume
        String text = resumeService.extractText(file);

        // Extract skills
        List<String> skills = resumeService.extractSkills(text);

        // Calculate score
        int score = resumeService.calculateScore(text);

        // Get suggestions
        String suggestions = resumeService.getSuggestions(text);

        // Return response as JSON
        return Map.of(
                "skills", skills,
                "score", score,
                "suggestions", suggestions
        );
    }

    @GetMapping("/test")
    public String test() {
        return "Resume API working 🚀";
    }
}