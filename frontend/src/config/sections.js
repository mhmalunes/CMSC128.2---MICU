export const hourOptions = Array.from({ length: 24 }, (_, i) => ({
  label: `${String(i).padStart(2, '0')}:00`,
  value: i
}));

export const sectionDefinitions = [
  {
    id: 'vitals',
    title: '1. Vital Signs',
    description: 'Capture hourly vital signs and neurological checks.',
    alwaysOpen: true,
    fields: [
      { name: 'date', label: 'Date', type: 'date', required: true },
      { name: 'time', label: 'Time', type: 'time', required: true },
      { name: 'bpSystolic', label: 'Systolic (mmHg)', type: 'number', required: true },
      { name: 'bpDiastolic', label: 'Diastolic (mmHg)', type: 'number', required: true },
      { name: 'heartRate', label: 'Heart Rate (bpm)', type: 'number', required: true },
      { name: 'respRate', label: 'Resp. Rate (breaths/min)', type: 'number', required: true },
      { name: 'temperature', label: 'Temperature (°C)', type: 'number', step: '0.1' },
      { name: 'spo2', label: 'SpO₂ (%)', type: 'number' },
      { name: 'gcsEye', label: 'GCS Eye', type: 'number' },
      { name: 'gcsVerbal', label: 'GCS Verbal', type: 'number' },
      { name: 'gcsMotor', label: 'GCS Motor', type: 'number' },
      { name: 'painScore', label: 'Pain Score (0-10)', type: 'number' },
      {
        name: 'oxygenMethod',
        label: 'Oxygen Delivery',
        type: 'select',
        options: ['Room Air', 'Nasal Cannula', 'HFNC', 'NRM', 'Mechanical Ventilator']
      },
      { name: 'oxygenFlow', label: 'Flow (L/min)', type: 'number', step: '0.1' }
    ]
  },
  {
    id: 'medications',
    title: '2. Medications',
    fields: [
      { name: 'date', label: 'Date', type: 'date', required: true },
      { name: 'time', label: 'Time', type: 'time', required: true },
      { name: 'drug', label: 'Medication / Drip', type: 'text', required: true },
      { name: 'dose', label: 'Dose', type: 'text', required: true },
      { name: 'route', label: 'Route', type: 'select', options: ['IV', 'IM', 'PO', 'SubQ', 'Nebulization'] },
      { name: 'frequency', label: 'Frequency', type: 'text' },
      { name: 'remarks', label: 'Remarks', type: 'textarea' }
    ]
  },
  {
    id: 'intake_output',
    title: '3. Intake & Output',
    fields: [
      { name: 'date', label: 'Date', type: 'date', required: true },
      { name: 'time', label: 'Time', type: 'time', required: true },
      { name: 'intakeType', label: 'Intake Type', type: 'select', options: ['Oral', 'IVF', 'PN', 'Blood Products'] },
      { name: 'intakeVolume', label: 'Intake Volume (mL)', type: 'number' },
      { name: 'outputType', label: 'Output Type', type: 'select', options: ['Urine', 'Drain', 'Emesis', 'Stool'] },
      { name: 'outputVolume', label: 'Output Volume (mL)', type: 'number' },
      { name: 'remarks', label: 'Remarks', type: 'textarea' }
    ]
  },
  {
    id: 'ventilator',
    title: '4. Ventilator Settings',
    fields: [
      { name: 'date', label: 'Date', type: 'date', required: true },
      { name: 'time', label: 'Time', type: 'time', required: true },
      { name: 'mode', label: 'Mode', type: 'select', options: ['AC', 'SIMV', 'CPAP', 'BiPAP', 'HFNC'] },
      { name: 'fio2', label: 'FiO₂ (%)', type: 'number' },
      { name: 'peep', label: 'PEEP (cmH₂O)', type: 'number' },
      { name: 'rate', label: 'Rate (bpm)', type: 'number' },
      { name: 'tidalVolume', label: 'Tidal Volume (mL)', type: 'number' },
      { name: 'pressureSupport', label: 'Pressure Support (cmH₂O)', type: 'number' },
      { name: 'remarks', label: 'Remarks', type: 'textarea' }
    ]
  },
  {
    id: 'procedures_lines',
    title: '5. Procedures & Lines',
    fields: [
      { name: 'date', label: 'Date', type: 'date', required: true },
      { name: 'time', label: 'Time', type: 'time', required: true },
      {
        name: 'procedure',
        label: 'Procedure / Line',
        type: 'select',
        options: [
          'Central Line',
          'Peripheral Line',
          'Arterial Line',
          'Hemodialysis',
          'Bronchoscopy',
          'Other'
        ]
      },
      { name: 'site', label: 'Site', type: 'text' },
      { name: 'status', label: 'Status', type: 'select', options: ['Inserted', 'Ongoing', 'Removed'] },
      { name: 'remarks', label: 'Remarks', type: 'textarea' }
    ]
  },
  {
    id: 'labs_imaging',
    title: '6. Labs & Imaging',
    fields: [
      { name: 'date', label: 'Date', type: 'date', required: true },
      { name: 'time', label: 'Time', type: 'time', required: true },
      { name: 'testName', label: 'Test / Imaging', type: 'text', required: true },
      { name: 'status', label: 'Status', type: 'select', options: ['Sent', 'Pending', 'Resulted'] },
      { name: 'result', label: 'Result / Summary', type: 'textarea' }
    ]
  },
  {
    id: 'clinical_notes',
    title: '7. Clinical Notes',
    fields: [
      { name: 'date', label: 'Date', type: 'date', required: true },
      { name: 'time', label: 'Time', type: 'time', required: true },
      {
        name: 'noteType',
        label: 'Note Type',
        type: 'select',
        options: ['Assessment', 'Intervention', 'Evaluation', 'Physician Order', 'Shift Handover']
      },
      { name: 'note', label: 'Narrative Note', type: 'textarea', required: true }
    ]
  },
  {
    id: 'doctor_notes',
    title: 'Doctor Progress Notes',
    description: 'Official physician entries regarding assessment, plan, or new orders.',
    fields: [
      { name: 'date', label: 'Date', type: 'date', required: true },
      { name: 'time', label: 'Time', type: 'time', required: true },
      { name: 'note', label: 'Physician Note', type: 'textarea', required: true },
      { name: 'plan', label: 'Plan / Orders', type: 'textarea' }
    ]
  }
];

export const sectionColumns = {
  vitals: [
    { key: 'timestamp', label: 'Time Stamp', formatter: (row) => row.timestamp },
    { key: 'temperature', label: 'Temp (°C)' },
    {
      key: 'bloodPressure',
      label: 'BP (mmHg)',
      formatter: (row) => `${row.bpSystolic || '-'} / ${row.bpDiastolic || '-'}`
    },
    { key: 'heartRate', label: 'HR' },
    { key: 'respRate', label: 'RR' },
    { key: 'spo2', label: 'SpO₂' }
  ],
  medications: [
    { key: 'timestamp', label: 'Time Stamp' },
    { key: 'drug', label: 'Medication' },
    { key: 'dose', label: 'Dose' },
    { key: 'route', label: 'Route' },
    { key: 'frequency', label: 'Frequency' }
  ],
  intake_output: [
    { key: 'timestamp', label: 'Time Stamp' },
    { key: 'intakeType', label: 'Intake' },
    { key: 'intakeVolume', label: 'Intake Vol (mL)' },
    { key: 'outputType', label: 'Output' },
    { key: 'outputVolume', label: 'Output Vol (mL)' }
  ],
  ventilator: [
    { key: 'timestamp', label: 'Time Stamp' },
    { key: 'mode', label: 'Mode' },
    { key: 'fio2', label: 'FiO₂' },
    { key: 'peep', label: 'PEEP' },
    { key: 'rate', label: 'Rate' }
  ],
  procedures_lines: [
    { key: 'timestamp', label: 'Time Stamp' },
    { key: 'procedure', label: 'Procedure / Line' },
    { key: 'site', label: 'Site' },
    { key: 'status', label: 'Status' }
  ],
  labs_imaging: [
    { key: 'timestamp', label: 'Time Stamp' },
    { key: 'testName', label: 'Test' },
    { key: 'status', label: 'Status' },
    { key: 'result', label: 'Result' }
  ],
  clinical_notes: [
    { key: 'timestamp', label: 'Time Stamp' },
    { key: 'noteType', label: 'Type' },
    { key: 'note', label: 'Narrative' }
  ],
  doctor_notes: [
    { key: 'timestamp', label: 'Time Stamp' },
    { key: 'note', label: 'Doctor Note' },
    { key: 'plan', label: 'Plan / Orders' }
  ]
};

