package MICU.vitals;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class VitalSignsService {
    private final VitalSignsRepository repo;

    public VitalSignsService(VitalSignsRepository repo) {
        this.repo = repo;
    }

    public List<VitalSigns> getAll() {
        return repo.findAll();
    }

    @Transactional
    public VitalSigns create(VitalSigns v) {
        return repo.saveAndFlush(v);
    }

    public VitalSigns getById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Transactional
    public VitalSigns update(Integer id, VitalSigns body) {
        VitalSigns e = repo.findById(id).orElse(null);
        if (e == null) return null;
        e.setTemperature(body.getTemperature());
        e.setBpSystolic(body.getBpSystolic());
        e.setBpDiastolic(body.getBpDiastolic());
        e.setHeartRate(body.getHeartRate());
        e.setRespiratoryRate(body.getRespiratoryRate());
        return repo.saveAndFlush(e);
    }

    @Transactional
    public boolean delete(Integer id) {
        if (!repo.existsById(id)) return false;
        repo.deleteById(id);
        return true;
    }
}
