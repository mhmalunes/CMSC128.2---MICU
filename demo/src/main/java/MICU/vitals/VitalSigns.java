package MICU.vitals;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "vital_signs")
public class VitalSigns {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "time_stamp", nullable = false)
    private LocalDateTime timeStamp;

    @Column(name = "temperature")
    private Double temperature;

    @Column(name = "bp_systolic")
    private Integer bpSystolic;

    @Column(name = "bp_diastolic")
    private Integer bpDiastolic;

    @Column(name = "heart_rate")
    private Integer heartRate;

    @Column(name = "respiratory_rate")
    private Integer respiratoryRate;

    @PrePersist
    public void prePersist() {
        if (timeStamp == null)
            timeStamp = LocalDateTime.now();
    }

    // Getters and setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public LocalDateTime getTimeStamp() { return timeStamp; }
    public void setTimeStamp(LocalDateTime timeStamp) { this.timeStamp = timeStamp; }
    public Double getTemperature() { return temperature; }
    public void setTemperature(Double temperature) { this.temperature = temperature; }
    public Integer getBpSystolic() { return bpSystolic; }
    public void setBpSystolic(Integer bpSystolic) { this.bpSystolic = bpSystolic; }
    public Integer getBpDiastolic() { return bpDiastolic; }
    public void setBpDiastolic(Integer bpDiastolic) { this.bpDiastolic = bpDiastolic; }
    public Integer getHeartRate() { return heartRate; }
    public void setHeartRate(Integer heartRate) { this.heartRate = heartRate; }
    public Integer getRespiratoryRate() { return respiratoryRate; }
    public void setRespiratoryRate(Integer respiratoryRate) { this.respiratoryRate = respiratoryRate; }
}
