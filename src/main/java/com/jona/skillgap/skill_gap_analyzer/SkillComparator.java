package com.jona.skillgap.skill_gap_analyzer;

import java.util.*;

public class SkillComparator {
    private static final Map<String, List<String>> jobRoleSkills = new HashMap<>();

    static {
        jobRoleSkills.put("Java Developer", Arrays.asList("Java", "Spring Boot", "MySQL", "Git", "OOP", "JPA"));
        jobRoleSkills.put("Web Developer", Arrays.asList("HTML", "CSS", "JavaScript", "React", "Node.js", "MongoDB"));
        jobRoleSkills.put("Cloud Engineer", Arrays.asList("AWS", "Azure", "Linux", "Docker", "Kubernetes", "CI/CD"));
        jobRoleSkills.put("Cybersecurity Analyst", Arrays.asList("Networking", "Firewalls", "Linux", "Python", "Risk Analysis", "Encryption"));
    }

    public static Set<String> getAllRoles() {
        return jobRoleSkills.keySet();
    }

    public static List<String> analyze(String jobRole, List<String> knownSkills) {
        List<String> required = jobRoleSkills.getOrDefault(jobRole, new ArrayList<>());
        List<String> missing = new ArrayList<>(required);
        missing.removeAll(knownSkills);
        return missing;
    }
}
