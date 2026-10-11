package com.example.task4;

import java.util.List;

public record SkillGapResult(
    double score,
    String label,
    List<String> matched,
    List<String> missing,
    List<String> recommendations
) {}