package MICU.neuro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NeuroAssessmentRepository extends JpaRepository<NeuroAssessment, Long> {
}
