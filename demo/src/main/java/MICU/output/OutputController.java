package MICU.output;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/outputs")
public class OutputController {

    private final OutputService service;

    public OutputController(OutputService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Output> create(@RequestBody Output body) {
        return ResponseEntity.ok(service.create(body));
    }

    @GetMapping
    public ResponseEntity<List<Output>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Output> getById(@PathVariable Integer id) {
        Output out = service.getById(id);
        return out == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(out);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Output> update(@PathVariable Integer id, @RequestBody Output body) {
        Output updated = service.update(id, body);
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
