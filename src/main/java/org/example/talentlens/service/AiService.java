package org.example.talentlens.service;

import org.springframework.stereotype.Service;

@Service
public class AiService {

    public String analyzeResume(String resumeText) {

        // Simple AI logic (we upgrade later)
        String lowerText = resumeText.toLowerCase();

        StringBuilder result = new StringBuilder();

        // Skills detection
        result.append("Skills Detected:\n");

        if (lowerText.contains("java")) result.append("- Java\n");
        if (lowerText.contains("spring")) result.append("- Spring Boot\n");
        if (lowerText.contains("python")) result.append("- Python\n");
        if (lowerText.contains("sql")) result.append("- SQL\n");
        if (lowerText.contains("react")) result.append("- React\n");

        // Experience level
        result.append("\nExperience Level:\n");

        if (lowerText.contains("3 years") || lowerText.contains("4 years"))
            result.append("Mid-level\n");
        else if (lowerText.contains("5 years") || lowerText.contains("6 years"))
            result.append("Senior\n");
        else
            result.append("Fresher/Junior\n");

        // Summary
        result.append("\nSummary:\n");
        result.append("Candidate has relevant technical skills based on resume.");

        return result.toString();
    }
}