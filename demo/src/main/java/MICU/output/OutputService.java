package MICU.output;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OutputService {

    private final OutputRepository repo;

    public OutputService(OutputRepository repo) {
        this.repo = repo;
    }

    public List<Output> getAll() {
        return repo.findAll();
    }

    public Output getById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Transactional
    public Output create(Output body) {
        return repo.saveAndFlush(body);
    }

    @Transactional
    public Output update(Integer id, Output body) {
        Output e = repo.findById(id).orElse(null);
        if (e == null) return null;

        e.setTimeStamp(body.getTimeStamp());
        e.setUrineMl(body.getUrineMl());
        e.setNgtResidualsMl(body.getNgtResidualsMl());
        e.setVomitusMl(body.getVomitusMl());
        e.setStool(body.getStool());            // <- single boolean now
        e.setOthers(body.getOthers());
        e.setRemarks(body.getRemarks());

        e.setNgtRemarks(body.getNgtRemarks());
        e.setVomitusRemarks(body.getVomitusRemarks());
        e.setStoolForm(body.getStoolForm());
        e.setStoolVolumeMl(body.getStoolVolumeMl());

        return repo.saveAndFlush(e);
    }

    @Transactional
    public boolean delete(Integer id) {
        if (!repo.existsById(id)) return false;
        repo.deleteById(id);
        return true;
    }
}
