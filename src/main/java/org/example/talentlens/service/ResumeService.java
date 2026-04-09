package org.example.talentlens.service;

import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class ResumeService {

    private final Tika tika = new Tika();

    // 🔹 Extract text from resume
    public String extractText(MultipartFile file) {
        try {
            return tika.parseToString(file.getInputStream());
        } catch (IOException | TikaException e) {
            throw new RuntimeException("Failed to read file");
        }
    }

    // 🔹 Extract skills (basic keyword matching)
    public List<String> extractSkills(String text) {

        List<String> skillsDatabase = Arrays.asList(
                "java", "spring", "spring boot", "python",
                "sql", "html", "css", "javascript",
                "react", "node", "docker", "kubernetes"
        );

        List<String> foundSkills = new ArrayList<>();

        text = text.toLowerCase();

        for (String skill : skillsDatabase) {
            if (text.contains(skill)) {
                foundSkills.add(skill);
            }
        }

        return foundSkills;
    }

    // 🔹 Resume scoring logic
    public int calculateScore(String text) {

        int score = 0;
        text = text.toLowerCase();

        if (text.contains("java")) score += 10;
        if (text.contains("spring")) score += 10;
        if (text.contains("project")) score += 10;
        if (text.contains("experience")) score += 10;
        if (text.length() > 1000) score += 10;

        return Math.min(score, 100); // max 100
    }

    // 🔹 AI suggestions (basic logic for now)
    public String getSuggestions(String text) {

        text = text.toLowerCase();

        List<String> suggestions = new ArrayList<>();

        if (!text.contains("project")) {
            suggestions.add("Add more project details.");
        }

        if (!text.contains("experience")) {
            suggestions.add("Include work experience.");
        }

        if (!text.contains("skills")) {
            suggestions.add("Add a skills section.");
        }

        if (suggestions.isEmpty()) {
            return "Great resume! 🎉";
        }

        return String.join(" ", suggestions);
    }
}