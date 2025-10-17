// src/main/java/MICU/output/Output.java
package MICU.output;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "output")
public class Output {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "time_stamp", nullable = false)
    private LocalDateTime timeStamp;

    @Column(name = "urine_ml")
    private Integer urineMl;

    @Column(name = "ngt_residuals_ml")
    private Integer ngtResidualsMl;

    @Column(name = "vomitus_ml")
    private Integer vomitusMl;

    @Column(name = "stool_present")            // tickbox
    private Boolean stool;

    @Column(columnDefinition = "text")
    private String others;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "ngt_remarks", columnDefinition = "text")
    private String ngtRemarks;

    @Column(name = "vomitus_remarks", columnDefinition = "text")
    private String vomitusRemarks;

    // NEW: Stool details (optional)
    @Column(name = "stool_form")         // e.g., "Formed", "Loose", "Watery", etc.
    private String stoolForm;

    @Column(name = "stool_volume_ml")    // optional measured stool volume
    private Integer stoolVolumeMl;

        // EDIT HERE ▾ add a dedicated remarks/notes field
    @Column(name = "remarks", columnDefinition = "text")
    private String remarks;

    @PrePersist
    public void prePersist() {
        if (timeStamp == null) timeStamp = LocalDateTime.now();
        if (stool == null) stool = false;

        if (updatedAt == null) updatedAt = timeStamp;
    }

     @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }

    // getters/setters...
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public LocalDateTime getTimeStamp() { return timeStamp; }
    public void setTimeStamp(LocalDateTime timeStamp) { this.timeStamp = timeStamp; }
    public Integer getUrineMl() { return urineMl; }
    public void setUrineMl(Integer urineMl) { this.urineMl = urineMl; }
    public Integer getNgtResidualsMl() { return ngtResidualsMl; }
    public void setNgtResidualsMl(Integer ngtResidualsMl) { this.ngtResidualsMl = ngtResidualsMl; }
    public Integer getVomitusMl() { return vomitusMl; }
    public void setVomitusMl(Integer vomitusMl) { this.vomitusMl = vomitusMl; }
    public Boolean getStool() { return stool; }
    public void setStool(Boolean stool) { this.stool = stool; }
    public String getOthers() { return others; }
    public void setOthers(String others) { this.others = others; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }

     public String getNgtRemarks() { return ngtRemarks; }
    public void setNgtRemarks(String ngtRemarks) { this.ngtRemarks = ngtRemarks; }

    public String getVomitusRemarks() { return vomitusRemarks; }
    public void setVomitusRemarks(String vomitusRemarks) { this.vomitusRemarks = vomitusRemarks; }

    public String getStoolForm() { return stoolForm; }
    public void setStoolForm(String stoolForm) { this.stoolForm = stoolForm; }

    public Integer getStoolVolumeMl() { return stoolVolumeMl; }
    public void setStoolVolumeMl(Integer stoolVolumeMl) { this.stoolVolumeMl = stoolVolumeMl; }
}
