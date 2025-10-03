package BIMS.record;

import jakarta.persistence.*;

@Entity
@Table(name = "patient_records")
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String timeStamp;  // store as String (or LocalDateTime if you want)

    private String urine;
    private String ngtResiduals;
    private String vomitus;
    private String stools;
    private String others;

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTimeStamp() { return timeStamp; }
    public void setTimeStamp(String timeStamp) { this.timeStamp = timeStamp; }

    public String getUrine() { return urine; }
    public void setUrine(String urine) { this.urine = urine; }

    public String getNgtResiduals() { return ngtResiduals; }
    public void setNgtResiduals(String ngtResiduals) { this.ngtResiduals = ngtResiduals; }

    public String getVomitus() { return vomitus; }
    public void setVomitus(String vomitus) { this.vomitus = vomitus; }

    public String getStools() { return stools; }
    public void setStools(String stools) { this.stools = stools; }

    public String getOthers() { return others; }
    public void setOthers(String others) { this.others = others; }
}
