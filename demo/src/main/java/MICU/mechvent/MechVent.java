package MICU.mechvent;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "mechvent", schema = "public")
public class MechVent {

    // ---------- Primary Key ----------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // ---------- Core Fields ----------
    @Column(name = "recorded_at", nullable = false)
    private LocalDateTime recordedAt = LocalDateTime.now();

    @Column(name = "intubated")
    private Boolean intubated;

    // Enum for MV Mode
    @Enumerated(EnumType.STRING)
    @Column(name = "mv_mode", length = 30)
    private MVMode mvMode;

    @Column(name = "mv_mode_other", length = 100)
    private String mvModeOther;

    @Column(name = "fio2")
    private Integer fio2;

    @Column(name = "tv_ml")
    private Integer tvMl;

    @Column(name = "bur_bpm")
    private Integer burBpm;

    @Column(name = "ps_cmh2o")
    private Integer psCmh2o;

    @Column(name = "p1_cmh2o")
    private Integer p1Cmh2o;

    @Column(name = "t1_seconds")
    private Double t1Seconds;

    @Column(name = "ifr_lpm")
    private Double ifrLpm;

    @Column(name = "ie_ratio", length = 20)
    private String ieRatio;

    @Column(name = "peep_cmh2o")
    private Integer peepCmh2o;

    @Column(name = "trigger_sens")
    private Double triggerSens;

    @Column(name = "remarks", columnDefinition = "text")
    private String remarks;

    // ---------- Timestamps ----------
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    // ---------- Enum Definition ----------
    public enum MVMode {
        AC_VC,
        AC_PC,
        SIMV_VC,
        SIMV_PC,
        PSV,
        CPAP,
        BIPAP,
        SPONTANEOUS,
        OTHER
    }

    // ---------- Getters ----------
    public Integer getId() { return id; }
    public LocalDateTime getRecordedAt() { return recordedAt; }
    public Boolean getIntubated() { return intubated; }
    public MVMode getMvMode() { return mvMode; }
    public String getMvModeOther() { return mvModeOther; }
    public Integer getFio2() { return fio2; }
    public Integer getTvMl() { return tvMl; }
    public Integer getBurBpm() { return burBpm; }
    public Integer getPsCmh2o() { return psCmh2o; }
    public Integer getP1Cmh2o() { return p1Cmh2o; }
    public Double getT1Seconds() { return t1Seconds; }
    public Double getIfrLpm() { return ifrLpm; }
    public String getIeRatio() { return ieRatio; }
    public Integer getPeepCmh2o() { return peepCmh2o; }
    public Double getTriggerSens() { return triggerSens; }
    public String getRemarks() { return remarks; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }

    // ---------- Setters ----------
    public void setId(Integer id) { this.id = id; }
    public void setRecordedAt(LocalDateTime recordedAt) { this.recordedAt = recordedAt; }
    public void setIntubated(Boolean intubated) { this.intubated = intubated; }
    public void setMvMode(MVMode mvMode) { this.mvMode = mvMode; }
    public void setMvModeOther(String mvModeOther) { this.mvModeOther = mvModeOther; }
    public void setFio2(Integer fio2) { this.fio2 = fio2; }
    public void setTvMl(Integer tvMl) { this.tvMl = tvMl; }
    public void setBurBpm(Integer burBpm) { this.burBpm = burBpm; }
    public void setPsCmh2o(Integer psCmh2o) { this.psCmh2o = psCmh2o; }
    public void setP1Cmh2o(Integer p1Cmh2o) { this.p1Cmh2o = p1Cmh2o; }
    public void setT1Seconds(Double t1Seconds) { this.t1Seconds = t1Seconds; }
    public void setIfrLpm(Double ifrLpm) { this.ifrLpm = ifrLpm; }
    public void setIeRatio(String ieRatio) { this.ieRatio = ieRatio; }
    public void setPeepCmh2o(Integer peepCmh2o) { this.peepCmh2o = peepCmh2o; }
    public void setTriggerSens(Double triggerSens) { this.triggerSens = triggerSens; }
    public void setRemarks(String remarks) { this.remarks = remarks; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
