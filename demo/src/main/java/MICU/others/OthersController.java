package MICU.others;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/others")
public class OthersController {

    private final OthersService service;

    public OthersController(OthersService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Others> create(@RequestBody Others body) {
        // Nothing required: all fields optional; timestamps/labels handled in entity
        return ResponseEntity.ok(service.create(body));
    }

    @GetMapping
    public ResponseEntity<List<Others>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    // Paging + sorting (default sort = createdAt desc)
    @GetMapping("/page")
    public ResponseEntity<Page<Others>> getPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(defaultValue = "createdAt,desc") String sort) {

        String[] parts = sort.split(",", 2);
        Sort s = parts.length == 2 && "asc".equalsIgnoreCase(parts[1])
                ? Sort.by(parts[0]).ascending()
                : Sort.by(parts[0]).descending();
        Pageable pageable = PageRequest.of(page, size, s);
        return ResponseEntity.ok(service.getPage(pageable));
    }

    // Date range filter by createdAt
    @GetMapping("/range")
    public ResponseEntity<List<Others>> getRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        return ResponseEntity.ok(service.getRange(start, end));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Others> getById(@PathVariable Integer id) {
        Others out = service.getById(id);
        return out == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(out);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Others> update(@PathVariable Integer id, @RequestBody Others body) {
        Others updated = service.update(id, body);
        return updated == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        return service.delete(id) ? ResponseEntity.noContent().build()
                                  : ResponseEntity.notFound().build();
    }

    // sanity counter
    @GetMapping("/_count")
    public long count() {
        return service.getAll().size();
    }
}

