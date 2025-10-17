package MICU.mechvent;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MechVentService {
    private final MechVentRepository repo;

    public MechVentService(MechVentRepository repo) { this.repo = repo; }

    @Transactional
    public MechVent create(MechVent body) {
        // ensure new row and sensible defaults
        body.setId(null);
        if (body.getRecordedAt() == null) body.setRecordedAt(LocalDateTime.now());
        if (body.getCreatedAt() == null) body.setCreatedAt(LocalDateTime.now());
        return repo.save(body);
    }

    @Transactional(readOnly = true)
    public List<MechVent> getAll() {
        return repo.findAll(Sort.by(Sort.Direction.DESC, "recordedAt"));
    }

    @Transactional(readOnly = true)
    public MechVent getById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Transactional
    public MechVent update(Integer id, MechVent body) {
        return repo.findById(id).map(existing -> {
            // copy over updatable fields
            existing.setRecordedAt(body.getRecordedAt() != null ? body.getRecordedAt() : existing.getRecordedAt());
            existing.setIntubated(body.getIntubated());
            existing.setMvMode(body.getMvMode());
            existing.setMvModeOther(body.getMvModeOther());
            existing.setFio2(body.getFio2());
            existing.setTvMl(body.getTvMl());
            existing.setBurBpm(body.getBurBpm());
            existing.setPsCmh2o(body.getPsCmh2o());
            existing.setP1Cmh2o(body.getP1Cmh2o());
            existing.setT1Seconds(body.getT1Seconds());
            existing.setIfrLpm(body.getIfrLpm());
            existing.setIeRatio(body.getIeRatio());
            existing.setPeepCmh2o(body.getPeepCmh2o());
            existing.setTriggerSens(body.getTriggerSens());
            existing.setRemarks(body.getRemarks());
            // updatedAt handled by @PreUpdate (if present) or set here:
            existing.setUpdatedAt(LocalDateTime.now());
            return repo.save(existing);
        }).orElse(null);
    }

    @Transactional
    public boolean delete(Integer id) {
        if (!repo.existsById(id)) return false;
        repo.deleteById(id);
        return true;
    }
}
