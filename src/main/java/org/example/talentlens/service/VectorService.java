package org.example.talentlens.service;

import org.springframework.stereotype.Service;

@Service
public class VectorService {

    public String processText(String text) {
        return "Processed: " + text;
    }
}