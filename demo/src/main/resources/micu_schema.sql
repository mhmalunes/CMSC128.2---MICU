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

