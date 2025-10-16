package MICU.neuro;

import jakarta.persistence.*;

@Entity
@Table(name = "neuro_assessment")
public class NeuroAssessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // GCS
    private int gcsEye;
    private int gcsVoice;
    private int gcsMotor;

    // Pupil
    private int pupilSizeR;
    private int pupilSizeL;
    private String pupilReactR;
    private String pupilReactL;

    // Motor
    private int motorUR;
    private int motorUL;
    private int motorLR;
    private int motorLL;

    // Sensory
    private int sensoryUR;
    private int sensoryUL;
    private int sensoryLR;
    private int sensoryLL;

    // Scores
    private String sedationScore;
    private String analgesiaScore;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getGcsEye() {
        return gcsEye;
    }

    public void setGcsEye(int gcsEye) {
        this.gcsEye = gcsEye;
    }

    public int getGcsVoice() {
        return gcsVoice;
    }

    public void setGcsVoice(int gcsVoice) {
        this.gcsVoice = gcsVoice;
    }

    public int getGcsMotor() {
        return gcsMotor;
    }

    public void setGcsMotor(int gcsMotor) {
        this.gcsMotor = gcsMotor;
    }

    public int getPupilSizeR() {
        return pupilSizeR;
    }

    public void setPupilSizeR(int pupilSizeR) {
        this.pupilSizeR = pupilSizeR;
    }

    public int getPupilSizeL() {
        return pupilSizeL;
    }

    public void setPupilSizeL(int pupilSizeL) {
        this.pupilSizeL = pupilSizeL;
    }

    public String getPupilReactR() {
        return pupilReactR;
    }

    public void setPupilReactR(String pupilReactR) {
        this.pupilReactR = pupilReactR;
    }

    public String getPupilReactL() {
        return pupilReactL;
    }

    public void setPupilReactL(String pupilReactL) {
        this.pupilReactL = pupilReactL;
    }

    public int getMotorUR() {
        return motorUR;
    }

    public void setMotorUR(int motorUR) {
        this.motorUR = motorUR;
    }

    public int getMotorUL() {
        return motorUL;
    }

    public void setMotorUL(int motorUL) {
        this.motorUL = motorUL;
    }

    public int getMotorLR() {
        return motorLR;
    }

    public void setMotorLR(int motorLR) {
        this.motorLR = motorLR;
    }

    public int getMotorLL() {
        return motorLL;
    }

    public void setMotorLL(int motorLL) {
        this.motorLL = motorLL;
    }

    public int getSensoryUR() {
        return sensoryUR;
    }

    public void setSensoryUR(int sensoryUR) {
        this.sensoryUR = sensoryUR;
    }

    public int getSensoryUL() {
        return sensoryUL;
    }

    public void setSensoryUL(int sensoryUL) {
        this.sensoryUL = sensoryUL;
    }

    public int getSensoryLR() {
        return sensoryLR;
    }

    public void setSensoryLR(int sensoryLR) {
        this.sensoryLR = sensoryLR;
    }

    public int getSensoryLL() {
        return sensoryLL;
    }

    public void setSensoryLL(int sensoryLL) {
        this.sensoryLL = sensoryLL;
    }

    public String getSedationScore() {
        return sedationScore;
    }

    public void setSedationScore(String sedationScore) {
        this.sedationScore = sedationScore;
    }

    public String getAnalgesiaScore() {
        return analgesiaScore;
    }

    public void setAnalgesiaScore(String analgesiaScore) {
        this.analgesiaScore = analgesiaScore;
    }
}
