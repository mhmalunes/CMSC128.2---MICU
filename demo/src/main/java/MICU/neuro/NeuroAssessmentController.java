package MICU.neuro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/neuro")
public class NeuroAssessmentController {

    private final NeuroAssessmentService service;

    public NeuroAssessmentController(NeuroAssessmentService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public NeuroAssessment save(@RequestBody NeuroAssessment assessment) {
        return service.saveAssessment(assessment);
    }

    @GetMapping("/all")
    public List<NeuroAssessment> getAllAssessments() {
        return service.getAllAssessments();
    }
}
