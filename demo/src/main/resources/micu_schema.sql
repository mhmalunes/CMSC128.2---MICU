CREATE TABLE public.output (
  id               INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  time_stamp       TIMESTAMP NOT NULL DEFAULT NOW(),

  urine_ml         INTEGER,                 -- numeric
  ngt_residuals_ml INTEGER,                 -- numeric
  vomitus_ml       INTEGER,                 -- numeric

  stool_present    BOOLEAN DEFAULT FALSE,   -- tickbox
  stool_type       VARCHAR(16),             -- 'formed' | 'loose' (optional)
  stool_volume_ml  INTEGER,                 -- optional volume in mL

  others           TEXT
);

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


