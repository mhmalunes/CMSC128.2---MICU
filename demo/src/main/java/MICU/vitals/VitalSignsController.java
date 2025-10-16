package MICU.vitals;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/vitals")
public class VitalSignsController {
    private final VitalSignsService service;

    public VitalSignsController(VitalSignsService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<VitalSigns>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<VitalSigns> create(@RequestBody VitalSigns v) {
        return ResponseEntity.ok(service.create(v));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VitalSigns> getById(@PathVariable Integer id) {
        VitalSigns v = service.getById(id);
        return v == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(v);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VitalSigns> update(@PathVariable Integer id, @RequestBody VitalSigns body) {
        VitalSigns updated = service.update(id, body);
        return updated == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        return service.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
