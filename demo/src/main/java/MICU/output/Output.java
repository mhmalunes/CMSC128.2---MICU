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

    @PrePersist
    public void prePersist() {
        if (timeStamp == null) timeStamp = LocalDateTime.now();
        if (stool == null) stool = false;
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
}
