package BIMS.record;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/records")
public class RecordController {

    private final RecordService recordService;

    @Autowired
    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @PostMapping
    public ResponseEntity<Record> createRecord(@RequestBody Record record) {
        Record createdRecord = recordService.createRecord(record);
        return ResponseEntity.ok(createdRecord);
    }

    @GetMapping
    public ResponseEntity<List<Record>> getAllRecords() {
        List<Record> records = recordService.getAllRecords();
        return ResponseEntity.ok(records);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Record> getRecordById(@PathVariable Integer id) {
        Record record = recordService.getRecordById(id);
        if (record == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(record);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Record> updateRecord(@PathVariable Integer id, @RequestBody Record record) {
        Record updatedRecord = recordService.updateRecord(id, record);
        if (updatedRecord == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedRecord);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecord(@PathVariable Integer id) {
        boolean deleted = recordService.deleteRecord(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
