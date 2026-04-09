package org.example.talentlens.service;

import org.apache.tika.Tika;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ResumeService {

    public String parseResume(MultipartFile file) {
        try {
            Tika tika = new Tika();
            String content = tika.parseToString(file.getInputStream());
            return content;
        } catch (Exception e) {
            return "Error parsing file: " + e.getMessage();
        }
    }
}