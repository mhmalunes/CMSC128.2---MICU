package MICU.neuro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NeuroAssessmentService {
    private final NeuroAssessmentRepository repository;

    public NeuroAssessmentService(NeuroAssessmentRepository repository) {
        this.repository = repository;
    }

    public NeuroAssessment saveAssessment(NeuroAssessment assessment) {
        return repository.save(assessment);
    }

    public List<NeuroAssessment> getAllAssessments() {
        return repository.findAll();
    }
}
