// src/main/java/MICU/others/Others.java
package MICU.others;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "others")
public class Others {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // When the row was created (for listing/sorting)
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    // For hover "last updated"
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // ===== ECG =====
    // Store code (e.g., 1 = NSR, 2 = AFib, ...), keep label for easy read
    @Column(name = "ecg_code")
    private Integer ecgCode;                 // EDIT HERE ▾ send numeric code from UI

    @Column(name = "ecg_label")
    private String ecgLabel;                 // auto-filled from code on save/update

    @Column(name = "ecg_other_text")
    private String ecgOtherText;             // only when "Other (Specify)"

    // Auto timestamp when saved (recorded time for ECG reading)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "ecg_time")
    private LocalDateTime ecgTime;           // if null, will be set to now on save


    // ===== CBG =====
    @Column(name = "cbg_mgdl")
    private Integer cbgMgdl;                 // numeric mg/dL, optional

    // timing flags (all optional)
    @Column(name = "cbg_is_fasting")
    private Boolean cbgIsFasting;

    @Column(name = "cbg_is_random")
    private Boolean cbgIsRandom;

    @Column(name = "cbg_is_pre_feed")
    private Boolean cbgIsPreFeed;

    @Column(name = "cbg_is_post_feed")
    private Boolean cbgIsPostFeed;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "cbg_time")
    private LocalDateTime cbgTime;           // optional; if null we won’t overwrite

    // ===== Insulin =====
    // Type as code + label (optional)
    @Column(name = "insulin_type_code")
    private Integer insulinTypeCode;         // e.g., 1=NPH, 2=Regular, 3=Glargine, 4=70/30, …
    @Column(name = "insulin_type_label")
    private String insulinTypeLabel;

    @Column(name = "insulin_dose_units")
    private Integer insulinDoseUnits;        // numeric Units

    @Column(name = "insulin_route")
    private String insulinRoute;             // "SC" or "IV" (dropdown)

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "insulin_time_given")
    private LocalDateTime insulinTimeGiven;  // if null, will be set to now on save

    // ===== generic notes (optional) =====
    @Column(name = "notes", columnDefinition = "text")
    private String notes;

    // ===== lifecycle =====
    @PrePersist
    public void prePersist() {
        if (ecgTime == null && (ecgCode != null || ecgOtherText != null)) {
            ecgTime = LocalDateTime.now();
        }
        if (insulinTimeGiven == null && (insulinTypeCode != null || insulinDoseUnits != null || insulinRoute != null)) {
            insulinTimeGiven = LocalDateTime.now();
        }
        // Labels from codes (safe if null)
        this.ecgLabel = EcgCodes.labelOf(this.ecgCode, this.ecgOtherText);
        this.insulinTypeLabel = InsulinTypes.labelOf(this.insulinTypeCode);
    }

    @PreUpdate
    public void preUpdate() {
        // keep label fields in sync when code changes
        this.ecgLabel = EcgCodes.labelOf(this.ecgCode, this.ecgOtherText);
        this.insulinTypeLabel = InsulinTypes.labelOf(this.insulinTypeCode);
    }

    // ===== getters/setters =====
    public Integer getId() { return id; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }

    public Integer getEcgCode() { return ecgCode; }
    public void setEcgCode(Integer ecgCode) { this.ecgCode = ecgCode; }
    public String getEcgLabel() { return ecgLabel; }
    public void setEcgLabel(String ecgLabel) { this.ecgLabel = ecgLabel; }
    public String getEcgOtherText() { return ecgOtherText; }
    public void setEcgOtherText(String ecgOtherText) { this.ecgOtherText = ecgOtherText; }
    public LocalDateTime getEcgTime() { return ecgTime; }
    public void setEcgTime(LocalDateTime ecgTime) { this.ecgTime = ecgTime; }
    // public String getEcgRemarks() { return ecgRemarks; }
    // public void setEcgRemarks(String ecgRemarks) { this.ecgRemarks = ecgRemarks; }

    public Integer getCbgMgdl() { return cbgMgdl; }
    public void setCbgMgdl(Integer cbgMgdl) { this.cbgMgdl = cbgMgdl; }
    public Boolean getCbgIsFasting() { return cbgIsFasting; }
    public void setCbgIsFasting(Boolean cbgIsFasting) { this.cbgIsFasting = cbgIsFasting; }
    public Boolean getCbgIsRandom() { return cbgIsRandom; }
    public void setCbgIsRandom(Boolean cbgIsRandom) { this.cbgIsRandom = cbgIsRandom; }
    public Boolean getCbgIsPreFeed() { return cbgIsPreFeed; }
    public void setCbgIsPreFeed(Boolean cbgIsPreFeed) { this.cbgIsPreFeed = cbgIsPreFeed; }
    public Boolean getCbgIsPostFeed() { return cbgIsPostFeed; }
    public void setCbgIsPostFeed(Boolean cbgIsPostFeed) { this.cbgIsPostFeed = cbgIsPostFeed; }
    public LocalDateTime getCbgTime() { return cbgTime; }
    public void setCbgTime(LocalDateTime cbgTime) { this.cbgTime = cbgTime; }
    // public String getCbgRemarks() { return cbgRemarks; }
    // public void setCbgRemarks(String cbgRemarks) { this.cbgRemarks = cbgRemarks; }

    public Integer getInsulinTypeCode() { return insulinTypeCode; }
    public void setInsulinTypeCode(Integer insulinTypeCode) { this.insulinTypeCode = insulinTypeCode; }
    public String getInsulinTypeLabel() { return insulinTypeLabel; }
    public void setInsulinTypeLabel(String insulinTypeLabel) { this.insulinTypeLabel = insulinTypeLabel; }
    public Integer getInsulinDoseUnits() { return insulinDoseUnits; }
    public void setInsulinDoseUnits(Integer insulinDoseUnits) { this.insulinDoseUnits = insulinDoseUnits; }
    public String getInsulinRoute() { return insulinRoute; }
    public void setInsulinRoute(String insulinRoute) { this.insulinRoute = insulinRoute; }
    public LocalDateTime getInsulinTimeGiven() { return insulinTimeGiven; }
    public void setInsulinTimeGiven(LocalDateTime insulinTimeGiven) { this.insulinTimeGiven = insulinTimeGiven; }
    // public String getInsulinRemarks() { return insulinRemarks; }
    // public void setInsulinRemarks(String insulinRemarks) { this.insulinRemarks = insulinRemarks; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    // ===== static mapping helpers =====
    public static final class EcgCodes {
        // EDIT HERE ▾ codes: 1..16 matching your dropdown
        // 1: NSR, 2: Sinus Tachycardia, 3: Sinus Bradycardia, 4: Atrial Fibrillation,
        // 5: Atrial Flutter, 6: SVT, 7: PVCs, 8: VT, 9: VF, 10: Asystole,
        // 11: 1st Degree HB, 12: 2nd Degree HB (Mobitz I/II), 13: 3rd Degree HB,
        // 14: Paced Rhythm, 15: Other (Specify)
        public static String labelOf(Integer code, String otherText) {
            if (code == null) return null;
            return switch (code) {
                case 1 -> "Normal Sinus Rhythm (NSR)";
                case 2 -> "Sinus Tachycardia";
                case 3 -> "Sinus Bradycardia";
                case 4 -> "Atrial Fibrillation";
                case 5 -> "Atrial Flutter";
                case 6 -> "Supraventricular Tachycardia (SVT)";
                case 7 -> "Premature Ventricular Contractions (PVCs)";
                case 8 -> "Ventricular Tachycardia (VT)";
                case 9 -> "Ventricular Fibrillation (VF)";
                case 10 -> "Asystole";
                case 11 -> "Heart Block – First Degree";
                case 12 -> "Heart Block – Second Degree (Mobitz I / Mobitz II)";
                case 13 -> "Heart Block – Third Degree";
                case 14 -> "Paced Rhythm";
                case 15 -> (otherText == null || otherText.isBlank()) ? "Other (Specify)" : "Other: " + otherText.trim();
                default -> null;
            };
        }
    }

    public static final class InsulinTypes {
        // EDIT HERE ▾ define labels by code for your dropdown
        // 1=NPH (Isophane), 2=Regular (Human), 3=Glargine, 4=70/30 Mix, 5=Other
        public static String labelOf(Integer code) {
            if (code == null) return null;
            return switch (code) {
                case 1 -> "Isophane (NPH)";
                case 2 -> "Regular (Human)";
                case 3 -> "Glargine";
                case 4 -> "70/30 mix";
                case 5 -> "Other";
                default -> null;
            };
        }
    }
}
