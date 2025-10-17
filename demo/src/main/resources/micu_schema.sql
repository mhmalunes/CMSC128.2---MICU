CREATE TABLE public.output (
  id               INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  time_stamp       TIMESTAMP NOT NULL DEFAULT NOW(),
  urine_ml         INTEGER,                 -- numeric
  ngt_residuals_ml INTEGER,                 -- numeric
  vomitus_ml       INTEGER,                 -- numeric
  stool_present    BOOLEAN DEFAULT FALSE,   -- tickbox
  others           TEXT,
  updated_at       TIMESTAMP,
  remarks          TEXT
  ngt_remarks      TEXT,
  vomitus_remarks TEXT,
  stool_form      VARCHAR(40),
  stool_volume_ml INTEGER

);

<<<<<<< HEAD
CREATE TABLE vital_signs (
  id SERIAL PRIMARY KEY,
  time_stamp TIMESTAMP NOT NULL DEFAULT NOW(),
  temperature DOUBLE PRECISION,
  bp_systolic INTEGER,
  bp_diastolic INTEGER,
  heart_rate INTEGER,
  respiratory_rate INTEGER
);

CREATE TABLE neuro_assessment (
    id SERIAL PRIMARY KEY,
    gcs_eye INT,
    gcs_voice INT,
    gcs_motor INT,
    pupil_size_r INT,
    pupil_size_l INT,
    pupil_react_r VARCHAR(50),
    pupil_react_l VARCHAR(50),
    motor_ur INT,
    motor_ul INT,
    motor_lr INT,
    motor_ll INT,
    sensory_ur INT,
    sensory_ul INT,
    sensory_lr INT,
    sensory_ll INT,
    sedation_score VARCHAR(50),
    analgesia_score VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

=======
-- Run once to create table if you are not using JPA auto-DDL
CREATE TABLE IF NOT EXISTS public.others (
  id                   INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  created_at           TIMESTAMP NOT NULL DEFAULT NOW(),
  updated_at           TIMESTAMP NOT NULL DEFAULT NOW(),

  ecg_code             INTEGER,
  ecg_label            TEXT,
  ecg_other_text       TEXT,
  ecg_time             TIMESTAMP,

  cbg_mgdl             INTEGER,
  cbg_is_fasting       BOOLEAN,
  cbg_is_random        BOOLEAN,
  cbg_is_pre_feed      BOOLEAN,
  cbg_is_post_feed     BOOLEAN,
  cbg_time             TIMESTAMP,

  insulin_type_code    INTEGER,
  insulin_type_label   TEXT,
  insulin_dose_units   INTEGER,
  insulin_route        VARCHAR(8),
  insulin_time_given   TIMESTAMP,

  notes                TEXT
);

-- Keep updated_at fresh on UPDATE (nice even if using @UpdateTimestamp)
CREATE OR REPLACE FUNCTION trg_others_set_updated_at()
RETURNS trigger AS $$
BEGIN
  NEW.updated_at := NOW();
  RETURN NEW;
END; $$ LANGUAGE plpgsql;

DROP TRIGGER IF EXISTS set_updated_at_others ON public.others;
CREATE TRIGGER set_updated_at_others
BEFORE UPDATE ON public.others
FOR EACH ROW
EXECUTE FUNCTION trg_others_set_updated_at();

-- Table: public.mechvent
CREATE TABLE IF NOT EXISTS public.mechvent (
  id               INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  recorded_at      TIMESTAMP NOT NULL DEFAULT NOW(), -- hourly logs

  intubated        BOOLEAN NOT NULL,
  mv_mode          VARCHAR(20) NOT NULL,
  mv_mode_other    VARCHAR(80),

  fio2             INTEGER,           -- 21..100 (%)
  tv_ml            INTEGER,           -- tidal volume (mL)
  bur_bpm          INTEGER,           -- backup rate (breaths/min)
  ps_cmh2o         INTEGER,
  p1_cmh2o         INTEGER,
  t1_seconds       NUMERIC(4,2),
  ifr_lpm          NUMERIC(5,2),
  ie_ratio         VARCHAR(10),
  peep_cmh2o       INTEGER,
  trigger_sens     NUMERIC(4,2),

  remarks          TEXT,
  created_at       TIMESTAMP NOT NULL DEFAULT NOW(),
  updated_at       TIMESTAMP
);

ALTER TABLE public.mechvent
  ADD CONSTRAINT mechvent_mv_mode_chk
  CHECK (mv_mode IN ('AC_VC','AC_PC','SIMV_VC','SIMV_PC','PSV','CPAP','BIPAP','SPONTANEOUS','OTHER'));

ALTER TABLE public.mechvent
  ADD CONSTRAINT mechvent_other_requires_text
  CHECK (mv_mode <> 'OTHER' OR (mv_mode_other IS NOT NULL AND length(trim(mv_mode_other)) > 0));

ALTER TABLE public.mechvent
  ADD CONSTRAINT mechvent_nonneg
  CHECK (
    COALESCE(fio2,21) BETWEEN 1 AND 100 AND
    COALESCE(tv_ml,0) >= 0 AND
    COALESCE(bur_bpm,0) >= 0 AND
    COALESCE(ps_cmh2o,0) >= 0 AND
    COALESCE(p1_cmh2o,0) >= 0 AND
    COALESCE(t1_seconds,0) >= 0 AND
    COALESCE(ifr_lpm,0) >= 0 AND
    COALESCE(peep_cmh2o,0) >= 0 AND
    COALESCE(trigger_sens,0) >= 0
  );

CREATE OR REPLACE FUNCTION trg_mechvent_set_updated_at()
RETURNS trigger AS $$
BEGIN
  NEW.updated_at := NOW();
  RETURN NEW;
END; $$ LANGUAGE plpgsql;

DROP TRIGGER IF EXISTS set_updated_at_mechvent ON public.mechvent;
CREATE TRIGGER set_updated_at_mechvent
BEFORE UPDATE ON public.mechvent
FOR EACH ROW
EXECUTE FUNCTION trg_mechvent_set_updated_at();

CREATE INDEX IF NOT EXISTS idx_mechvent_time ON public.mechvent (recorded_at DESC);

>>>>>>> tela-branch1

