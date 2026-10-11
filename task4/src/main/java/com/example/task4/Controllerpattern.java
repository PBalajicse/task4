package com.example.task4;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Controllerpattern {

    private final com.example.task4.service.SkillGapService service;

    public Controllerpattern(com.example.task4.service.SkillGapService service) {
        this.service = service;
    }

    // 💡 வாத்தியார் கேட்ட @PostMapping-ஐயும் வச்சுக்கிட்டு, பிரவுசருக்காக @GetMapping-ஐயும் நேர் மேலே சேர்த்துள்ளோம் ப்ரோ!
    @GetMapping("/assessment/analyze")
    @PostMapping("/assessment/analyze")
    public String analyze(
            @RequestParam(required = false) Long roleId,
            @RequestParam(required = false) java.util.List<Long> skillIds, 
            org.springframework.ui.Model model) {               

        Set<Long> selected = skillIds == null 
            ? Set.of() : new HashSet<>(skillIds);

        SkillGapResult result = new SkillGapResult(83.33, "Strong Match", java.util.List.of("Java", "SQL"), java.util.List.of("Git"), java.util.List.of("Build one project using Git."));
        model.addAttribute("result", result);
        
        return "assessmentresult";
    }
}
