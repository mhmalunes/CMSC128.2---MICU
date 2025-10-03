package BIMS.record;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecordService {

    private final RecordRepository recordRepository;

    @Autowired
    public RecordService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    public List<Record> getAllRecords() {
        return recordRepository.findAll();
    }

    public Record getRecordById(Integer id) {
        return recordRepository.findById(id).orElse(null);
    }

    @Transactional
    public Record createRecord(Record record) {
        return recordRepository.save(record);
    }

    @Transactional
    public Record updateRecord(Integer id, Record recordDetails) {
        Optional<Record> optionalRecord = recordRepository.findById(id);
        if (optionalRecord.isEmpty()) {
            return null;
        }

        Record existingRecord = optionalRecord.get();
        existingRecord.setTimeStamp(recordDetails.getTimeStamp());
        existingRecord.setUrine(recordDetails.getUrine());
        existingRecord.setNgtResiduals(recordDetails.getNgtResiduals());
        existingRecord.setVomitus(recordDetails.getVomitus());
        existingRecord.setStools(recordDetails.getStools());
        existingRecord.setOthers(recordDetails.getOthers());

        return recordRepository.save(existingRecord);
    }

    @Transactional
    public boolean deleteRecord(Integer id) {
        if (!recordRepository.existsById(id)) {
            return false;
        }
        recordRepository.deleteById(id);
        return true;
    }
}
