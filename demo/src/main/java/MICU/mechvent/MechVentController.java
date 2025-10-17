package MICU.mechvent;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/mechvent")
public class MechVentController {

    private final MechVentService service;

    public MechVentController(MechVentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<MechVent> create(@RequestBody MechVent body) {
        return ResponseEntity.ok(service.create(body));
    }

    @GetMapping
    public ResponseEntity<List<MechVent>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MechVent> getById(@PathVariable Integer id) {
        MechVent mv = service.getById(id);
        return mv == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(mv);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MechVent> update(@PathVariable Integer id, @RequestBody MechVent body) {
        MechVent updated = service.update(id, body);
        return updated == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        return service.delete(id) ? ResponseEntity.noContent().build()
                                  : ResponseEntity.notFound().build();
    }

    // Simple counter to sanity check
    @GetMapping("/_count")
    public long count() {
        return service.getAll().size();
    }
}
