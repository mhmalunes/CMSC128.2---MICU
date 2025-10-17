// src/main/java/MICU/others/OthersService.java
package MICU.others;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OthersService {

    private final OthersRepository repo;

    public OthersService(OthersRepository repo) {
        this.repo = repo;
    }

    public List<Others> getAll() {
        return repo.findAll();
    }

    public Page<Others> getPage(Pageable pageable) {
        return repo.findAll(pageable);
    }

    public List<Others> getRange(LocalDateTime start, LocalDateTime end) {
        return repo.findByCreatedAtBetween(start, end);
    }

    public Others getById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Transactional
    public Others create(Others body) {
        // Labels/time handled in @PrePersist
        return repo.saveAndFlush(body);
    }

    @Transactional
    public Others update(Integer id, Others body) {
        Others e = repo.findById(id).orElse(null);
        if (e == null) return null;

        // ===== ECG =====
        e.setEcgCode(body.getEcgCode());
        e.setEcgOtherText(body.getEcgOtherText());
        e.setEcgTime(body.getEcgTime());                // keep manual override if provided

        // ===== CBG =====
        e.setCbgMgdl(body.getCbgMgdl());
        e.setCbgIsFasting(body.getCbgIsFasting());
        e.setCbgIsRandom(body.getCbgIsRandom());
        e.setCbgIsPreFeed(body.getCbgIsPreFeed());
        e.setCbgIsPostFeed(body.getCbgIsPostFeed());
        e.setCbgTime(body.getCbgTime());

        // ===== Insulin =====
        e.setInsulinTypeCode(body.getInsulinTypeCode());
        e.setInsulinDoseUnits(body.getInsulinDoseUnits());
        e.setInsulinRoute(body.getInsulinRoute());
        e.setInsulinTimeGiven(body.getInsulinTimeGiven()); // auto-set at persist if null, but allow manual here

        // ===== notes =====
        e.setNotes(body.getNotes());

        // @PreUpdate refreshes labels
        return repo.saveAndFlush(e);
    }

    @Transactional
    public boolean delete(Integer id) {
        if (!repo.existsById(id)) return false;
        repo.deleteById(id);
        return true;
    }
}
