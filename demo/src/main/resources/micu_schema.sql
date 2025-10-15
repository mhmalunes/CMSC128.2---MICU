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


