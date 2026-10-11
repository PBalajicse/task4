package com.example.task4.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.demo2.Entity.RoleSkill;
import com.example.task4.SkillGapResult;

@Service
public class SkillGapService {

    public SkillGapResult analyze(List<RoleSkill> required, Set<Long> studentSkillIds) {
        
        int totalWeight = 0;
        int matchedWeight = 0;
        
        List<String> matched = new ArrayList<>();
        List<String> missing = new ArrayList<>();
        List<String> recommendations = new ArrayList<>();

		/*
		 * int totalWeight = 6; int matchedWeight = 0;
		 */

        if (studentSkillIds.contains(1L)) {
            matchedWeight += 3; 
            matched.add("Java");
        } else {
            missing.add("Java");
        }

        if (studentSkillIds.contains(2L)) {
            matchedWeight += 2; 
            matched.add("SQL");
        } else {
            missing.add("SQL");
        }

        if (studentSkillIds.contains(3L)) {
            matchedWeight += 1; 
            matched.add("Git");
        } else {
            missing.add("Git");
        }

        for (String m : missing) {
            recommendations.add(recommendationFor(m));
        }


        
        double score = totalWeight == 0 ? 0.0 : (matchedWeight * 100.0) / totalWeight;

        
        return new SkillGapResult(
            score,
            labelFor(score),
            matched,
            missing,
            recommendations
        );
    }

    private String labelFor(double score) {
        if (score >= 80) return "Strong Match";
        if (score >= 60) return "Good Match";
        if (score >= 40) return "Developing";
        return "Major Gap";
    }

    private String recommendationFor(String skill) {
        return "Build one practical project using " + skill + ".";
    }
}

