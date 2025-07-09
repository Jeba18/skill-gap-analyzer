package com.jona.skillgap.skill_gap_analyzer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("roles", SkillComparator.getAllRoles());
        return "index";
    }

    @PostMapping("/analyze")
    public String analyzeSkills(@RequestParam String role, @RequestParam List<String> skills, Model model) {
        List<String> missing = SkillComparator.analyze(role, skills);
        model.addAttribute("missingSkills", missing);
        model.addAttribute("selectedRole", role);
        return "result";
    }
}
